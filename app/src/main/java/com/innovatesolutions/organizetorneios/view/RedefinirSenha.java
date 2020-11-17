package com.innovatesolutions.organizetorneios.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.api.AppUtil;
import com.innovatesolutions.organizetorneios.controller.UsuarioController;
import com.innovatesolutions.organizetorneios.model.Usuario;

public class RedefinirSenha extends AppCompatActivity {

    Usuario usuario;

    UsuarioController controller;

    AlertDialog.Builder builder;
    AlertDialog alert;

    private SharedPreferences preferences;

    Button btnRedefinir;
    EditText editNovaSenha, editConfirmacaoNovaSenha;
    Boolean isFormularioOK;

    int usuarioID;

    String emailUsuario, nomeUsuario, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redefinir_senha);

        initFormulario();

    }

    private void initFormulario() {

        editNovaSenha = findViewById(R.id.editNovaSenha);
        editConfirmacaoNovaSenha = findViewById(R.id.editConfirmacaoNovaSenha);
        btnRedefinir = findViewById(R.id.btnRedefinirSenha);
        isFormularioOK = false;

        controller = new UsuarioController(getApplicationContext());
        usuario = new Usuario();
        usuario.setId(usuarioID);

        restaurarSharedPreferences();
    }

    private boolean validarFormulario() {

        boolean retorno = true;

        if (TextUtils.isEmpty(editNovaSenha.getText().toString())) {
            editNovaSenha.setError("*");
            editNovaSenha.requestFocus();
            retorno = false;
        }

        if (TextUtils.isEmpty(editConfirmacaoNovaSenha.getText().toString())) {
            editConfirmacaoNovaSenha.setError("*");
            editConfirmacaoNovaSenha.requestFocus();
            retorno = false;
        }

        return retorno;
    }

    public boolean validarSenhasDigitadas() {

        boolean retorno = false;
        String senhaA, senhaB;

        senhaA = editNovaSenha.getText().toString();
        senhaB = editConfirmacaoNovaSenha.getText().toString();

        retorno = senhaA.equals(senhaB);

        return retorno;

    }

    public void redefinir(View view) {

        if (isFormularioOK = validarFormulario()) {

            if (!validarSenhasDigitadas()) {
                editNovaSenha.setError("*");
                editConfirmacaoNovaSenha.setError("*");
                editNovaSenha.requestFocus();

                builder = new AlertDialog.Builder(this);
                builder.setTitle("ATENÇÃO:");
                builder.setMessage("As senhas digitadas devem ser iguais, por favor tente novamente.");
                builder.setCancelable(true);
                builder.setIcon(R.mipmap.ic_launcher_round);

                builder.setPositiveButton("ENTENDI", new Dialog.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.cancel();

                    }
                });

                alert = builder.create();
                alert.show();

            } else {

                usuario = controller.getUsuarioByID(usuario);

                usuario.setId(usuarioID);
                usuario.setNome(nomeUsuario);
                usuario.setEmail(emailUsuario);
                usuario.setSenha(AppUtil.gerarMD5Hash(editNovaSenha.getText().toString()));

                if (controller.alterar(usuario)) {

                    salvarSharedPreferences();

                    Toast.makeText(getApplicationContext(), "Senha alterada com sucesso!!", Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(getApplicationContext(), "Não foi possível alterar sua senha.", Toast.LENGTH_LONG).show();

                Intent novaTela = new Intent(RedefinirSenha.this, Login.class);
                novaTela.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(novaTela);
                finish();
                return;

            }
        } else
            Toast.makeText(getApplicationContext(), "Favor, preencher todos os campos!", Toast.LENGTH_SHORT).show();
    }

    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putString("senha", usuario.getSenha());
        dados.apply();

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(RedefinirSenha.this, Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        return;
    }

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);

        usuarioID = preferences.getInt("usuarioID", -1);
        emailUsuario = preferences.getString("emailUsuario", "");
        nomeUsuario = preferences.getString("nomeUsuario", "");
        senha = preferences.getString("senha", "");
    }

}