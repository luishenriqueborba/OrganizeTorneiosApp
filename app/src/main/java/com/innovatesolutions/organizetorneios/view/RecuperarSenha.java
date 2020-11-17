package com.innovatesolutions.organizetorneios.view;

import android.content.Intent;
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
import com.innovatesolutions.organizetorneios.controller.UsuarioController;
import com.innovatesolutions.organizetorneios.model.Usuario;

public class RecuperarSenha extends AppCompatActivity {

    Usuario usuario;

    UsuarioController controller;

    private SharedPreferences preferences;

    EditText editEmailRecuperacaoSenha;
    Button btnRecuperar;
    Boolean isFormularioOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);

        initFormulario();

    }

    private void initFormulario() {

        editEmailRecuperacaoSenha = findViewById(R.id.editEmailRecuperacaoSenha);
        btnRecuperar = findViewById(R.id.btnRecuperarSenha);
        isFormularioOK = false;

        controller = new UsuarioController(getApplicationContext());
        usuario = new Usuario();

        restaurarSharedPreferences();
    }

    private boolean validarFormulario() {

        boolean retorno = true;

        if (TextUtils.isEmpty(editEmailRecuperacaoSenha.getText().toString())) {
            editEmailRecuperacaoSenha.setError("*");
            editEmailRecuperacaoSenha.requestFocus();
            retorno = false;
        }

        return retorno;
    }

    public boolean validarEmailUsuario() {

        boolean retornoE = false;

        String emailDigitado = editEmailRecuperacaoSenha.getText().toString();
        String emailCadastrado = usuario.getEmail();

        retornoE = emailCadastrado.equals(emailDigitado);

        return retornoE;

    }

    public void recuperarSenha(View view) {

        if (isFormularioOK = validarFormulario()) {

            if (!validarEmailUsuario()) {
                editEmailRecuperacaoSenha.setError("*");
                editEmailRecuperacaoSenha.requestFocus();
                Toast.makeText(getApplicationContext(), "E-mail não cadastrado!", Toast.LENGTH_LONG).show();
            } else {

                Intent novaTela = new Intent(RecuperarSenha.this, RedefinirSenha.class);
                novaTela.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(novaTela);
                finish();
                return;
            }
        } else
            Toast.makeText(getApplicationContext(), "Favor, preencher o campo indicado!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(RecuperarSenha.this, Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        return;
    }

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);

        usuario.setEmail(preferences.getString("emailUsuario", "teste@teste.com"));
    }

}