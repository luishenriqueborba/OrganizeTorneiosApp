package com.innovatesolutions.organizetorneios.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.api.AppUtil;
import com.innovatesolutions.organizetorneios.controller.UsuarioController;
import com.innovatesolutions.organizetorneios.model.Usuario;

public class Login extends AppCompatActivity {

    private long backPressedTime;

    Usuario usuario;

    UsuarioController controller;

    private SharedPreferences preferences;

    Button btnEntrar;
    TextView txtCadastrar, txtEsqueceuSenha;
    EditText editSenha, editEmail;
    CheckBox chLembrar;
    Boolean isFormularioOK, isLembrarSenha;
    ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initFormulario();

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isFormularioOK = validarFormulario()) {

                    if (!validarDadosUsuario()) {
                        editEmail.setError("*");
                        editSenha.setError("*");
                        editEmail.requestFocus();
                        Toast.makeText(getApplicationContext(), "O e-mail e/ou senha estão incorretos.", Toast.LENGTH_LONG).show();
                    } else {

                        salvarSharedPreferences();

                        Intent novaTela = new Intent(Login.this, EscolherTorneio.class);
                        startActivity(novaTela);
                        finish();
                        return;
                    }

                }
            }
        });

        txtCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent novaTela = new Intent(Login.this, CadastrarUsuario.class);
                startActivity(novaTela);
                finish();
                return;
            }
        });

        txtEsqueceuSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent novaTelaA = new Intent(Login.this, RecuperarSenha.class);
                startActivity(novaTelaA);
                finish();
                return;
            }
        });
    }

    private boolean validarFormulario() {

        boolean retorno = true;

        if (TextUtils.isEmpty(editEmail.getText().toString())) {
            editEmail.setError("*");
            editEmail.requestFocus();
            retorno = false;
        }

        if (TextUtils.isEmpty(editSenha.getText().toString())) {
            editSenha.setError("*");
            editSenha.requestFocus();
            retorno = false;
        }

        return retorno;
    }

    private void initFormulario() {

        btnEntrar = findViewById(R.id.btnEntrar);
        txtCadastrar = findViewById(R.id.txtCadastrar);
        txtEsqueceuSenha = findViewById(R.id.txtEsqueceuSenha);
        editEmail = findViewById(R.id.editEmailLogin);
        editSenha = findViewById(R.id.editSenhaLogin);
        chLembrar = findViewById(R.id.chLembrar);
        imgLogo = findViewById(R.id.imgLogo);
        isFormularioOK = false;

        controller = new UsuarioController(getApplicationContext());
        usuario = new Usuario();

        restaurarSharedPreferences();
    }

    public void lembrarSenha(View view) {

        isLembrarSenha = chLembrar.isChecked();
    }

    public boolean validarDadosUsuario() {

        boolean retornoE = false;
        boolean retornoS = false;

        String emailDigitado = editEmail.getText().toString();
        String emailCadastrado = usuario.getEmail();

        retornoE = emailCadastrado.equals(emailDigitado);

        String senhaDigitada = editSenha.getText().toString();
        String senhaCadastrada = usuario.getSenha();

        retornoS = senhaCadastrada.equals(AppUtil.gerarMD5Hash(senhaDigitada));

        return (retornoE && retornoS);

    }

    @Override
    public void onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(this, "Pressione novamente para sair.", Toast.LENGTH_SHORT).show();
        }

        backPressedTime = System.currentTimeMillis();
    }

    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putBoolean("loginAutomatico", isLembrarSenha);
        dados.apply();

    }

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);

        usuario.setNome(preferences.getString("nomeUsuario", "Fake"));
        usuario.setEmail(preferences.getString("emailUsuario", "teste@teste.com"));
        usuario.setSenha(preferences.getString("senha", "123"));
        isLembrarSenha = preferences.getBoolean("loginAutomatico", false);

    }

}