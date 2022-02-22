package com.innovatesolutions.organizetorneios.view;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.api.AppUtil;
import com.innovatesolutions.organizetorneios.controller.UsuarioController;
import com.innovatesolutions.organizetorneios.model.User;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.Icon;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastrarUsuario extends AppCompatActivity {

    private SharedPreferences preferences;
    private User novoUser;
    private UsuarioController controller;
    private int ultimoID, usuarioID;
    private String emailUsuario;

    EditText editNome, editEmail, editSenha, editConfirmacao;
    TextView txtTermos;
    Button btnCadastrar;
    CheckBox chTermos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);

        restaurarSharedPreferences();
        initFormulario();

        txtTermos.setOnClickListener(view -> {
            AppUtil.goNextScreen(CadastrarUsuario.this, TermosDeUso.class, false);
            finish();
        });

    }

    private void initFormulario() {
        editNome = findViewById(R.id.editNome);
        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
        editConfirmacao = findViewById(R.id.editConfirmacaoSenha);
        chTermos = findViewById(R.id.checkBoxTermos);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        txtTermos = findViewById(R.id.txtTermos);

        novoUser = new User();
        novoUser.setId(usuarioID);
        controller = new UsuarioController(this);
    }

    public void validarTermos(View view) {
        if (!chTermos.isChecked()) {
            Toast.makeText(getApplicationContext(), "É necessário aceitar os termos de uso para continuar o cadastro.", Toast.LENGTH_LONG).show();
        }
    }

    private boolean validarFormulario() {
        if (TextUtils.isEmpty(editNome.getText().toString())) {
            editNome.setError("*");
            editNome.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(editEmail.getText().toString())) {
            editEmail.setError("*");
            editEmail.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(editSenha.getText().toString())) {
            editSenha.setError("*");
            editSenha.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(editConfirmacao.getText().toString())) {
            editConfirmacao.setError("*");
            editConfirmacao.requestFocus();
            return false;
        }
        if (!chTermos.isChecked()) {
            return false;
        }
        return true;
    }

    public boolean validarEmailUsuario(String email) {
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;

    }

    public boolean compararEmailUsuario() {
        String emailDigitado = editEmail.getText().toString();
        String emailCadastrado = emailUsuario;

        if (emailCadastrado.equals(emailDigitado)) {
            return true;
        }
        return false;
    }

    public boolean validarSenha() {
        String senhaA = editSenha.getText().toString();
        String senhaB = editConfirmacao.getText().toString();

        if (senhaA.equals(senhaB)) {
            return true;
        }
        return false;
    }

    public void cadastrarUsuario(View view) {
        if (validarFormulario()) {
            if (validarEmailUsuario(editEmail.getText().toString())) {
                if (!compararEmailUsuario()) {
                    if (!validarSenha()) {
                        editSenha.setError("*");
                        editConfirmacao.setError("*");
                        editSenha.requestFocus();
                        showAlertDialog();
                    } else {
                        novoUser.setName(editNome.getText().toString());
                        novoUser.setEmail(editEmail.getText().toString());
                        novoUser.setPassword(AppUtil.gerarMD5Hash(editSenha.getText().toString()));
                        controller.incluir(novoUser);
                        ultimoID = controller.getUltimoID();

                        salvarSharedPreferences();

                        Toast.makeText(getApplicationContext(), "Cadastro concluído! Seja bem vindo...", Toast.LENGTH_SHORT).show();

                        AppUtil.goNextScreen(CadastrarUsuario.this, Login.class, true);
                        finish();
                    }
                } else {
                    editEmail.setError("*");
                    editEmail.requestFocus();
                    showFancyAlertDialog();
                }
            } else {
                editEmail.setError("*");
                editEmail.requestFocus();
                Toast.makeText(getApplicationContext(), "E-mail inválido!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Favor, preencher todos os campos!", Toast.LENGTH_SHORT).show();
        }
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

    private void showFancyAlertDialog() {
        new FancyAlertDialog.Builder(this)
                .setTitle("ATENÇÃO")
                .setBackgroundColor(Color.parseColor("#303F9F"))
                .setMessage("Esse e-mail já está cadastrado!")
                .setNegativeBtnText("CANCELAR")
                .setNegativeBtnBackground(Color.parseColor("#FF4081"))
                .setPositiveBtnText("CONTINUAR")
                .setPositiveBtnBackground(Color.parseColor("#4ECA25"))
                .isCancellable(true)
                .setIcon(R.mipmap.ic_launcher_round, Icon.Visible)
                .OnPositiveClicked(() ->
                        Toast.makeText(getApplicationContext(), "Continue seu cadastro...", Toast.LENGTH_SHORT).show())
                .OnNegativeClicked(() -> {
                    AppUtil.goNextScreen(CadastrarUsuario.this, Login.class, true);
                    finish();
                })
                .build();
    }

    @Override
    public void onBackPressed() {
        AppUtil.goNextScreen(CadastrarUsuario.this, Login.class, true);
        finish();
    }

    private void salvarSharedPreferences() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("usuarioID", ultimoID);
        dados.putString("nomeUsuario", novoUser.getName());
        dados.putString("emailUsuario", novoUser.getEmail());
        dados.putString("senha", novoUser.getPassword());
        dados.apply();
    }

    private void restaurarSharedPreferences() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);

        usuarioID = preferences.getInt("usuarioID", -1);
        emailUsuario = preferences.getString("emailUsuario", "");
    }
}