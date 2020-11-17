package com.innovatesolutions.organizetorneios.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import com.innovatesolutions.organizetorneios.model.Usuario;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;
import com.shashank.sony.fancydialoglib.Icon;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastrarUsuario extends AppCompatActivity {

    private SharedPreferences preferences;

    Usuario novoUsuario;
    UsuarioController controller;

    AlertDialog.Builder builder;
    AlertDialog alert;

    int ultimoID, usuarioID;

    String emailUsuario;

    EditText editNome, editEmail, editSenha, editConfirmacao;
    TextView txtTermos;
    Button btnCadastrar;
    CheckBox chTermos;
    Boolean isFormularioOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);

        restaurarSharedPreferences();

        initFormulario();

        txtTermos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CadastrarUsuario.this, TermosDeUso.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                return;

            }
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
        isFormularioOK = false;

        novoUsuario = new Usuario();
        novoUsuario.setId(usuarioID);

        controller = new UsuarioController(this);
    }

    public void validarTermos(View view) {

        if (!chTermos.isChecked()) {

            Toast.makeText(getApplicationContext(), "É necessário aceitar os termos de uso para continuar o cadastro.", Toast.LENGTH_LONG).show();
        }
    }

    private boolean validarFormulario() {

        boolean retorno = true;

        if (TextUtils.isEmpty(editNome.getText().toString())) {
            editNome.setError("*");
            editNome.requestFocus();
            retorno = false;
        }

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

        if (TextUtils.isEmpty(editConfirmacao.getText().toString())) {
            editConfirmacao.setError("*");
            editConfirmacao.requestFocus();
            retorno = false;
        }

        if (!chTermos.isChecked()) {
            retorno = false;
        }

        return retorno;
    }

    public boolean validarEmailUsuario(String email) {

        boolean isEmailIdValid = false;

        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;

    }

    public boolean compararEmailUsuario() {

        boolean retornoE = false;

        String emailDigitado = editEmail.getText().toString();
        String emailCadastrado = emailUsuario;

        return retornoE = emailCadastrado.equals(emailDigitado);

    }

    public boolean validarSenha() {

        boolean retorno = false;
        String senhaA, senhaB;

        senhaA = editSenha.getText().toString();
        senhaB = editConfirmacao.getText().toString();

        return retorno = senhaA.equals(senhaB);

    }

    public void cadastrarUsuario(View view) {

        if (isFormularioOK = validarFormulario()) {

            if (validarEmailUsuario(editEmail.getText().toString())) {

                if (!compararEmailUsuario()) {

                    if (!validarSenha()) {

                        editSenha.setError("*");
                        editConfirmacao.setError("*");
                        editSenha.requestFocus();

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

                        novoUsuario.setNome(editNome.getText().toString());
                        novoUsuario.setEmail(editEmail.getText().toString());
                        novoUsuario.setSenha(AppUtil.gerarMD5Hash(editSenha.getText().toString()));

                        controller.incluir(novoUsuario);

                        ultimoID = controller.getUltimoID();

                        salvarSharedPreferences();

                        Toast.makeText(getApplicationContext(), "Cadastro concluído! Seja bem vindo...", Toast.LENGTH_SHORT).show();

                        Intent novaTela = new Intent(CadastrarUsuario.this, Login.class);
                        novaTela.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(novaTela);
                        finish();
                        return;

                    }
                } else {

                    editEmail.setError("*");
                    editEmail.requestFocus();

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
                            .OnPositiveClicked(new FancyAlertDialogListener() {
                                @Override
                                public void OnClick() {
                                    Toast.makeText(getApplicationContext(), "Continue seu cadastro...", Toast.LENGTH_SHORT).show();

                                }
                            })
                            .OnNegativeClicked(new FancyAlertDialogListener() {
                                @Override
                                public void OnClick() {
                                    Intent novaTela = new Intent(CadastrarUsuario.this, Login.class);
                                    novaTela.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(novaTela);
                                    finish();
                                    return;

                                }
                            })
                            .build();
                }
            } else {

                editEmail.setError("*");
                editEmail.requestFocus();

                Toast.makeText(getApplicationContext(), "E-mail inválido!", Toast.LENGTH_SHORT).show();
            }
        } else
            Toast.makeText(getApplicationContext(), "Favor, preencher todos os campos!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        return;
    }

    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("usuarioID", ultimoID);
        dados.putString("nomeUsuario", novoUsuario.getNome());
        dados.putString("emailUsuario", novoUsuario.getEmail());
        dados.putString("senha", novoUsuario.getSenha());
        dados.apply();

    }

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        usuarioID = preferences.getInt("usuarioID", -1);
        emailUsuario = preferences.getString("emailUsuario", "");

    }

}