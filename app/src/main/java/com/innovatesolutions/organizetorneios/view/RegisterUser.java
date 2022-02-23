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

public class RegisterUser extends AppCompatActivity {

    private SharedPreferences preferences;
    private User newUser;
    private UsuarioController controller;
    private int lastID;
    private int userID;
    private String emailAddressUser;
    private EditText editName;
    private EditText editEmail;
    private EditText editPassword;
    private EditText editConfirmation;
    private TextView txtTerms;
    private CheckBox chTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);

        restoreSharedPreferences();
        initForm();

        txtTerms.setOnClickListener(view -> {
            AppUtil.goNextScreen(RegisterUser.this, TermosDeUso.class, false);
            finish();
        });
    }

    private void initForm() {
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        editConfirmation = findViewById(R.id.editConfirmation);
        chTerms = findViewById(R.id.checkBoxTerms);
        txtTerms = findViewById(R.id.txtTerms);
        Button btnRegister = findViewById(R.id.btnRegister);

        newUser = new User();
        newUser.setId(userID);
        controller = new UsuarioController(this);
    }

    public void validateTermsOfUse(View view) {
        if (!chTerms.isChecked()) {
            Toast.makeText(getApplicationContext(), R.string.msgTermsOfUseAlert, Toast.LENGTH_LONG).show();
        }
    }

    private boolean validateForm() {
        if (TextUtils.isEmpty(editName.getText().toString())) {
            editName.setError("*");
            editName.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(editEmail.getText().toString())) {
            editEmail.setError("*");
            editEmail.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(editPassword.getText().toString())) {
            editPassword.setError("*");
            editPassword.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(editConfirmation.getText().toString())) {
            editConfirmation.setError("*");
            editConfirmation.requestFocus();
            return false;
        }
        if (!chTerms.isChecked()) {
            return false;
        }
        return true;
    }

    public boolean validateUserEmailAddress(String email) {
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

    public boolean compareUserEmail() {
        String typedEmail = editEmail.getText().toString();
        String registeredEmail = emailAddressUser;
        if (registeredEmail.equals(typedEmail)) {
            return true;
        }
        return false;
    }

    public boolean validatePassword() {
        String password = editPassword.getText().toString();
        String confirmation = editConfirmation.getText().toString();
        if (password.equals(confirmation)) {
            return true;
        }
        return false;
    }

    public void registerUser(View view) {
        if (validateForm()) {
            if (validateUserEmailAddress(editEmail.getText().toString())) {
                if (!compareUserEmail()) {
                    if (!validatePassword()) {
                        editPassword.setError("*");
                        editConfirmation.setError("*");
                        editPassword.requestFocus();
                        showAlertDialog();
                    } else {
                        newUser.setName(editName.getText().toString());
                        newUser.setEmail(editEmail.getText().toString());
                        newUser.setPassword(AppUtil.gerarMD5Hash(editPassword.getText().toString()));
                        controller.incluir(newUser);
                        lastID = controller.getUltimoID();

                        saveSharedPreferences();

                        Toast.makeText(getApplicationContext(), R.string.msgUserRegistrationSuccess, Toast.LENGTH_SHORT).show();

                        AppUtil.goNextScreen(RegisterUser.this, Login.class, true);
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
                        Toast.makeText(getApplicationContext(), R.string.msgContinueRegistration, Toast.LENGTH_SHORT).show())
                .OnNegativeClicked(() -> {
                    AppUtil.goNextScreen(RegisterUser.this, Login.class, true);
                    finish();
                })
                .build();
    }

    @Override
    public void onBackPressed() {
        AppUtil.goNextScreen(RegisterUser.this, Login.class, true);
        finish();
    }

    private void saveSharedPreferences() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor data = preferences.edit();
        data.putInt("usuarioID", lastID);
        data.putString("nomeUsuario", newUser.getName());
        data.putString("emailUsuario", newUser.getEmail());
        data.putString("senha", newUser.getPassword());
        data.apply();
    }

    private void restoreSharedPreferences() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        userID = preferences.getInt("usuarioID", -1);
        emailAddressUser = preferences.getString("emailUsuario", "");
    }
}