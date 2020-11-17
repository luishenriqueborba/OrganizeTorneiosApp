package com.innovatesolutions.organizetorneios.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.api.AppUtil;

public class MataMataFake extends AppCompatActivity {

    SharedPreferences preferences;

    int qtdEquipes;

    AlertDialog.Builder builder;
    AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mata_mata_doze_fake);

        restaurarSharedPreferencesQtdEquipes();

        switch (qtdEquipes) {

            case 4:
                setContentView(R.layout.activity_mata_mata_quatro_fake);
                alert();
                break;

            case 12:
            case 16:
                setContentView(R.layout.activity_mata_mata_doze_fake);
                alert();
                break;
        }


    }

    public void voltar(View view) {

        Intent intent = new Intent(MataMataFake.this, Dashboard.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        return;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Dashboard.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        return;
    }

    private void alert() {

        builder = new AlertDialog.Builder(this);
        builder.setTitle("ATENÇÃO");
        builder.setMessage("Para prosseguir com o torneio você deve finalizar a primeira fase!\n\nJOGOS > Finalizar 1ª Fase");
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
    }

    private void restaurarSharedPreferencesQtdEquipes() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        qtdEquipes = preferences.getInt("qtdEquipes", -1);

    }
}