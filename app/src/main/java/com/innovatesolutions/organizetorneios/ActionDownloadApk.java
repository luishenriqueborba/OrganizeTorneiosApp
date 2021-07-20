package com.innovatesolutions.organizetorneios;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;

import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ActionDownloadApk {

    private final String downloadUrl;
    private final String apkName;
    private final String downloadDirectory;
    private final Context context;

    public ActionDownloadApk(Activity activity, String downloadUrl, String apkName) {
        this.downloadUrl = downloadUrl;
        this.apkName = apkName;
        this.downloadDirectory = activity.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        this.context = activity;
    }

    private boolean mustOpenGooglePlay() {
        return this.downloadUrl.startsWith("https://play.google.com");
    }

    public void doAction() {
        if (mustOpenGooglePlay()) {
            actionOpenGooglePlay(this.context, this.downloadUrl);
        } else {
            deleteCurrentFile();
            boolean apkDownloaded = downloadApk();
            if (apkDownloaded) {
                installApk();
            } else {
                AlertDialog.Builder alert = new AlertDialog.Builder(this.context);
                alert.setMessage(context.getResources().getString(R.string.downloadApkError));
                alert.show();
            }
        }
    }

    private void actionOpenGooglePlay(Context context, String downloadUrl) {
        String packageName = Uri.parse(downloadUrl).getQueryParameter("id");
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName));
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        context.startActivity(intent);
    }

    private void deleteCurrentFile() {
        new File(this.downloadDirectory, this.apkName).delete();
    }

    private boolean downloadApk() {
        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        try {
            //getActionExecuter().getSafetyAsyncExecution().getProcessingDialog().setMode(ProcessingDialog.MODE_DOWNLOADING_APK);

            HttpURLConnection connection = (HttpURLConnection) new URL(this.downloadUrl).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Cache-Control", "no-cache");
            connection.setDefaultUseCaches(false);
            connection.setUseCaches(false);
            connection.connect();

            File outputFile = new File(this.downloadDirectory, this.apkName);
            fileOutputStream = new FileOutputStream(outputFile);
            inputStream = connection.getInputStream();
            byte[] buffer = new byte[1024];
            int len1;
            while ((len1 = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len1);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Exception ex) {
            }
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception ex) {
            }
        }
    }

    private void installApk() {
        Intent intent;
        Uri uri;
        File file = new File(this.downloadDirectory, this.apkName);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            uri = FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".provider", file);
            intent = new Intent(Intent.ACTION_INSTALL_PACKAGE);
            intent.setData(uri);
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        } else {
            intent = new Intent(Intent.ACTION_VIEW);
            uri = Uri.fromFile(file);
            intent.setDataAndType(uri, "application/vnd.android.package-archive");
        }
        context.startActivity(intent);
    }

}
