package com.innovatesolutions.organizetorneios.api;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.app.NotificationCompat;

import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.controller.EquipeController;
import com.innovatesolutions.organizetorneios.controller.GrupoController;
import com.innovatesolutions.organizetorneios.controller.JogadorController;
import com.innovatesolutions.organizetorneios.model.Equipe;
import com.innovatesolutions.organizetorneios.model.Grupo;
import com.innovatesolutions.organizetorneios.model.Jogador;
import com.innovatesolutions.organizetorneios.view.NotificacaoVersaoPremium;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.List;

/**
 * Classe de apoio contendo métodos que podem ser reutilizadas no projeto
 * <p>
 * Criada por Luis Borba - 06/2020
 */
public class AppUtil {

    public static final int TIME_SPLASH = 3500;
    public static final String PREF_APP = "app_organize_torneios_pref";
    public static final String LOG_APP1 = "USUARIO_LOG";
    public static final String LOG_APP2 = "EQUIPE_LOG";
    public static final String LOG_APP3 = "GRUPO_LOG";
    public static final String LOG_APP4 = "JOGADOR_LOG";
    public static final String URL_IMG_BACKGROUND = "http://bit.ly/daaziImgBackground";
    public static final String URL_IMG_LOGO = "http://bit.ly/daaziImgLogo";

    /**
     * @return devolve a data atual.
     */
    public static String getDataAtual() {
        String dia, mes, ano;
        String dataAtual = "00/00/0000";

        try {
            Calendar calendar = Calendar.getInstance();
            dia = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
            mes = String.valueOf(calendar.get(Calendar.MONTH) + 1);
            ano = String.valueOf(calendar.get(Calendar.YEAR));

            //TODO: conferir em dia do mês menor que 10
            // dia = (Calendar.DAY_OF_MONTH<10) ? "0"+dia : dia;

            dia = (Calendar.DAY_OF_MONTH < 10) ? dia : dia;

            int mesAtual = (Calendar.MONTH) + 1;

            mes = (mesAtual < 10) ? "0" + mes : mes;

            dataAtual = dia + "/" + mes + "/" + ano;

            return dataAtual;

        } catch (Exception e) {

        }
        return dataAtual;
    }

    /**
     * @return devolve a hora atual.
     */

    public static String getHoraAtual() {
        String hora, minuto, segundo;
        String horaAtual = "00:00:00";

        try {
            Calendar calendar = Calendar.getInstance();

            int iHora = calendar.get(Calendar.HOUR_OF_DAY);
            int iMinuto = calendar.get(Calendar.MINUTE);
            int iSegundo = calendar.get(Calendar.SECOND);

            //TODO: conferir em hora do mês menor que 10
            hora = (iHora <= 9) ? "0" + iHora : Integer.toString(iHora);
            minuto = (iMinuto <= 9) ? "0" + iMinuto : Integer.toString(iMinuto);
            segundo = (iSegundo <= 9) ? "0" + iSegundo : Integer.toString(iSegundo);

            horaAtual = hora + ":" + minuto + ":" + segundo;

            return horaAtual;

        } catch (Exception e) {

        }
        return horaAtual;
    }

    /**
     * Gerar senha criptografada com MD5.
     *
     * @param password
     * @return
     */
    public static String gerarMD5Hash(String password) {
        String retorno = "";

        if (!password.isEmpty()) {
            retorno = "falhou";
            try {
                // Create MD5 Hash
                MessageDigest digest = MessageDigest.getInstance("MD5");
                digest.update(password.getBytes());
                byte messageDigest[] = digest.digest();

                StringBuffer MD5Hash = new StringBuffer();
                for (int i = 0; i < messageDigest.length; i++) {
                    String h = Integer.toHexString(0xFF & messageDigest[i]);
                    while (h.length() < 2)
                        h = "0" + h;
                    MD5Hash.append(h);
                }
                return MD5Hash.toString();

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return retorno;
    }

    public static boolean isAppInstalled(Context context, String packageName) {
        try {
            context.getPackageManager().getApplicationInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static void goNextScreen(Context context, Class<?> cls, boolean clearStackActivities) {
        Intent intent = new Intent(context, cls);
        if (clearStackActivities) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        }
        context.startActivity(intent);
    }

    public void openUrlOnChromeCustomTab(Context context, String url, String color) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        configuraChromeCustomTab(builder, color);
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(context, Uri.parse(url));
    }

    private void configuraChromeCustomTab(CustomTabsIntent.Builder builder, String color) {
        //Add color para o Toolbar
        int colorInt = Color.parseColor(color);
        CustomTabColorSchemeParams defaultColors = new CustomTabColorSchemeParams.Builder()
                .setToolbarColor(colorInt)
                .build();
        builder.setDefaultColorSchemeParams(defaultColors);
    }

    public void addSettingsOnWebView(final WebView webView, final WebViewClient webViewClient, final WebChromeClient webChromeClient, boolean isCleanCache) {
        CookieManager.getInstance().setAcceptCookie(true);

        if (webViewClient != null) {
            webView.setWebViewClient(webViewClient);
        }

        if (webChromeClient != null) {
            webView.setWebChromeClient(webChromeClient);
        }

        if (isCleanCache) {
            webView.clearCache(true);
            webView.clearHistory();
        }

        webView.setDownloadListener(new DownloadListener() {

            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                try {
                    if (mimetype.equals("application/pdf")) {
                        //showPDFFileOnViewer(url, webView);
                    } else {
                        //downloadContentByUrl(url);
                    }
                } catch (Exception ex) {
                }
                if (webViewClient != null) {
                    webViewClient.onPageFinished(webView, url);
                }
            }

        });

        WebSettings settings = webView.getSettings();
        settings.setAllowFileAccess(true);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
    }


    public static void limpaRegistros(Context context) {
        GrupoController grupoController = new GrupoController(context);
        List<Grupo> listGrupos = grupoController.listar();
        for (Grupo grupo : listGrupos) {
            grupoController.deletar(grupo);
        }

        EquipeController equipeController = new EquipeController(context);
        List<Equipe> listEquipes = equipeController.listarTodasEquipes();
        for (Equipe equipe : listEquipes) {
            equipeController.deletar(equipe);
        }

        JogadorController jogadorController = new JogadorController(context);
        List<Jogador> list = jogadorController.listarTodosJogadores();
        for(Jogador jogador : list) {
            jogadorController.deletar(jogador);
        }
    }

    public static void notificarUsuario(Context context, String mensagem,
                                  String titulo) {

        NotificationCompat.Builder notificacao =
                new NotificationCompat.Builder(context);

        notificacao.setContentTitle(titulo);
        notificacao.setContentText(mensagem);
        notificacao.setPriority(Notification.PRIORITY_HIGH);


        notificacao.setLargeIcon(
                BitmapFactory.decodeResource(context.getResources(),
                        R.mipmap.ic_launcher_round));

        notificacao.setSmallIcon(R.drawable.iconfinder_trophy);

        Intent intent =
                new Intent(context, NotificacaoVersaoPremium.class);

        PendingIntent pendingIntent =
                PendingIntent.getActivity(context, 100,
                        intent, PendingIntent.FLAG_UPDATE_CURRENT);

        notificacao.setAutoCancel(true);
        notificacao.setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager)
                        context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(9000, notificacao.build());
    }
}
