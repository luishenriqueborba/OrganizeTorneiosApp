package com.innovatesolutions.organizetorneios.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.api.AppUtil;
import com.innovatesolutions.organizetorneios.model.User;

public class Login extends AppCompatActivity {

    private User user;
    private SharedPreferences preferences;
    private Button btnSignIn;
    private TextView txtRegister;
    private TextView txtForgotPassword;
    private EditText editPassword;
    private EditText editEmail;
    private CheckBox chRemember;
    private Boolean isRememberPassword = false;
    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initForm();
        restoreSharedPreferences();

        txtRegister.setOnClickListener(view -> {
            AppUtil.goNextScreen(Login.this, CadastrarUsuario.class, false);
            finish();
        });
        txtForgotPassword.setOnClickListener(view -> {
            AppUtil.goNextScreen(Login.this, RecuperarSenha.class, false);
            finish();
        });

        chRemember.setOnClickListener(v ->
                rememberPassword());

        btnSignIn.setOnClickListener(v -> signIn());
    }

    private void initForm() {
        btnSignIn = findViewById(R.id.btnSignIn);
        txtRegister = findViewById(R.id.txtRegister);
        txtForgotPassword = findViewById(R.id.txtForgotPassword);
        editEmail = findViewById(R.id.editEmailLogin);
        editPassword = findViewById(R.id.editPasswordLogin);
        chRemember = findViewById(R.id.chRemember);

        user = new User();
    }

    public void signIn() {
        if (validateForm()) {
            if (!validateUserData()) {
                editEmail.setError("*");
                editPassword.setError("*");
                editEmail.requestFocus();
                Toast.makeText(getApplicationContext(), R.string.msgErrorInvalidLogin, Toast.LENGTH_LONG).show();
            } else {
                saveSharedPreferences();
                AppUtil.goNextScreen(Login.this, EscolherTorneio.class, true);
                finish();
            }
        }
    }

    public void rememberPassword() {
        isRememberPassword = chRemember.isChecked();
    }

    private boolean validateForm() {
        boolean isValid = true;
        if (TextUtils.isEmpty(editEmail.getText().toString())) {
            editEmail.setError("*");
            editEmail.requestFocus();
            isValid = false;
        }
        if (TextUtils.isEmpty(editPassword.getText().toString())) {
            editPassword.setError("*");
            editPassword.requestFocus();
            isValid = false;
        }
        return isValid;
    }

    public boolean validateUserData() {
        String typedEmail = editEmail.getText().toString();
        String registeredEmail = user.getEmail();
        String typedPassword = editPassword.getText().toString();
        String registeredPassword = user.getPassword();

        boolean isEmailValid = registeredEmail.equals(typedEmail);
        boolean isPasswordValid = registeredPassword.equals(AppUtil.gerarMD5Hash(typedPassword));

        return (isEmailValid && isPasswordValid);
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(this, R.string.msgAppExitAlert, Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    private void saveSharedPreferences() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor data = preferences.edit();
        data.putBoolean("loginAutomatico", isRememberPassword);
        data.apply();
    }

    private void restoreSharedPreferences() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        user.setName(preferences.getString("nomeUsuario", "Fake"));
        user.setEmail(preferences.getString("emailUsuario", "teste@teste.com"));
        user.setPassword(preferences.getString("senha", "123"));
        isRememberPassword = preferences.getBoolean("loginAutomatico", false);
    }

}