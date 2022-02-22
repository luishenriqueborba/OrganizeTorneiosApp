package com.innovatesolutions.organizetorneios.view;

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
import com.innovatesolutions.organizetorneios.model.User;

public class RedefinirSenha extends AppCompatActivity {

    private User user;
    private UsuarioController controller;
    private SharedPreferences preferences;
    private int usuarioID;
    private String emailUsuario, nomeUsuario;

    Button btnRedefinir;
    EditText editNovaSenha, editConfirmacaoNovaSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redefinir_senha);

        initFormulario();
        restaurarSharedPreferences();
    }

    private void initFormulario() {
        editNovaSenha = findViewById(R.id.editNovaSenha);
        editConfirmacaoNovaSenha = findViewById(R.id.editConfirmacaoNovaSenha);
        btnRedefinir = findViewById(R.id.btnRedefinirSenha);

        controller = new UsuarioController(getApplicationContext());
        user = new User();
        user.setId(usuarioID);
    }

    private boolean validarFormulario() {
        boolean sucesso = true;
        if (TextUtils.isEmpty(editNovaSenha.getText().toString())) {
            editNovaSenha.setError("*");
            editNovaSenha.requestFocus();
            sucesso = false;
        }
        if (TextUtils.isEmpty(editConfirmacaoNovaSenha.getText().toString())) {
            editConfirmacaoNovaSenha.setError("*");
            editConfirmacaoNovaSenha.requestFocus();
            sucesso = false;
        }
        return sucesso;
    }

    public boolean validarSenhasDigitadas() {
        String senhaA = editNovaSenha.getText().toString();
        String senhaB = editConfirmacaoNovaSenha.getText().toString();

        if (senhaA.equals(senhaB)) {
            return true;
        }
        return false;
    }

    public void redefinir(View view) {
        if (validarFormulario()) {
            if (!validarSenhasDigitadas()) {
                editNovaSenha.setError("*");
                editConfirmacaoNovaSenha.setError("*");
                editNovaSenha.requestFocus();
                showAlertDialog();
            } else {
                user = controller.getUsuarioByID(user);
                user.setId(usuarioID);
                user.setName(nomeUsuario);
                user.setEmail(emailUsuario);
                user.setPassword(AppUtil.gerarMD5Hash(editNovaSenha.getText().toString()));

                if (controller.alterar(user)) {
                    salvarSharedPreferences();
                    Toast.makeText(getApplicationContext(), "Senha alterada com sucesso!!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Não foi possível alterar sua senha.", Toast.LENGTH_LONG).show();
                }
                AppUtil.goNextScreen(RedefinirSenha.this, Login.class, true);
                finish();
            }
        } else
            Toast.makeText(getApplicationContext(), "Favor, preencher todos os campos!", Toast.LENGTH_SHORT).show();
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ATENÇÃO:");
        builder.setMessage("As senhas digitadas devem ser iguais, por favor tente novamente.");
        builder.setCancelable(true);
        builder.setIcon(R.mipmap.ic_launcher_round);
        builder.setPositiveButton("ENTENDI", (dialogInterface, i) ->
                dialogInterface.cancel());
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void onBackPressed() {
        AppUtil.goNextScreen(RedefinirSenha.this, RecuperarSenha.class, true);
        finish();
    }

    private void salvarSharedPreferences() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putString("senha", user.getPassword());
        dados.apply();
    }

    private void restaurarSharedPreferences() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);

        usuarioID = preferences.getInt("usuarioID", -1);
        emailUsuario = preferences.getString("emailUsuario", "");
        nomeUsuario = preferences.getString("nomeUsuario", "");
        //String senha = preferences.getString("senha", "");
    }
}