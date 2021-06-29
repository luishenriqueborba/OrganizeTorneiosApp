package com.innovatesolutions.organizetorneios.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.api.AppUtil;
import com.innovatesolutions.organizetorneios.model.Usuario;

public class RecuperarSenha extends AppCompatActivity {

    private Usuario usuario;

    EditText editEmailRecuperacaoSenha;
    Button btnRecuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);

        initFormulario();
        restaurarSharedPreferences();
    }

    private void initFormulario() {
        editEmailRecuperacaoSenha = findViewById(R.id.editEmailRecuperacaoSenha);
        btnRecuperar = findViewById(R.id.btnRecuperarSenha);
        usuario = new Usuario();
    }

    private boolean validarFormulario() {
        if (TextUtils.isEmpty(editEmailRecuperacaoSenha.getText().toString())) {
            editEmailRecuperacaoSenha.setError("*");
            editEmailRecuperacaoSenha.requestFocus();
            return false;
        }
        return true;
    }

    public boolean validarEmailUsuario() {
        String emailDigitado = editEmailRecuperacaoSenha.getText().toString();
        String emailCadastrado = usuario.getEmail();

        if (emailCadastrado.equals(emailDigitado)) {
            return true;
        }
        return false;
    }

    public void recuperarSenha(View view) {
        if (validarFormulario()) {
            if (!validarEmailUsuario()) {
                editEmailRecuperacaoSenha.setError("*");
                editEmailRecuperacaoSenha.requestFocus();
                Toast.makeText(getApplicationContext(), "E-mail não cadastrado!", Toast.LENGTH_LONG).show();
            } else {
                AppUtil.goNextScreen(RecuperarSenha.this, RedefinirSenha.class);
                finish();
            }
        } else
            Toast.makeText(getApplicationContext(), "Favor, preencher o campo indicado!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        AppUtil.goNextScreen(RecuperarSenha.this, Login.class);
        finish();
    }

    private void restaurarSharedPreferences() {
        SharedPreferences preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);

        usuario.setEmail(preferences.getString("emailUsuario", "teste@teste.com"));
    }
}