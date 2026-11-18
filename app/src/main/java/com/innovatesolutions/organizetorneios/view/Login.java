package com.innovatesolutions.organizetorneios.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.api.AppUtil;

public class Login extends AppCompatActivity {

    private SharedPreferences preferences;
    private Button btnSignIn;
    private EditText editEmailLogin;
    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_new);

        initForm();
        restoreSharedPreferences();

        btnSignIn.setOnClickListener(v -> saveAndProceed());

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (backPressedTime + 2000 > System.currentTimeMillis()) {
                    finish();
                    return;
                } else {
                    Toast.makeText(Login.this, R.string.msgAppExitAlert, Toast.LENGTH_SHORT).show();
                }
                backPressedTime = System.currentTimeMillis();
            }
        });
    }

    private void initForm() {
        btnSignIn = findViewById(R.id.btnSignIn);
        editEmailLogin = findViewById(R.id.editEmailLogin);
    }

    public void saveAndProceed() {
        String name = editEmailLogin.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            editEmailLogin.setError("*");
            editEmailLogin.requestFocus();
            Toast.makeText(getApplicationContext(), R.string.msgBlankFieldsAlert, Toast.LENGTH_LONG).show();
        } else {
            saveSharedPreferences(name);
            AppUtil.goNextScreen(Login.this, EscolherTorneio.class, true);
            finish();
        }
    }


    private void saveSharedPreferences(String name) {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor data = preferences.edit();
        data.putString("nomeUsuario", name);
        data.putBoolean("loginAutomatico", true);
        data.apply();
    }

    private void restoreSharedPreferences() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        String savedName = preferences.getString("nomeUsuario", "");
        if (!TextUtils.isEmpty(savedName) && editEmailLogin != null) {
            editEmailLogin.setText(savedName);
        }
    }

}
