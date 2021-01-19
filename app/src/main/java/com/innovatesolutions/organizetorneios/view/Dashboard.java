package com.innovatesolutions.organizetorneios.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.api.AppUtil;

public class Dashboard extends AppCompatActivity {

    private long backPressedTime;

    private SharedPreferences preferences;

    AlertDialog.Builder builder;
    AlertDialog alert;

    TextView txtTitulo;

    String pasta = "fonts/";
    String fontBanger = "Bangers.ttf";

    int qtdEquipes, qtdJogadores;

    boolean finalizouPrimeiraFase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        restaurarSharedPreferences();

        init();

    }

    private void init() {

        txtTitulo = findViewById(R.id.txtTituloDashboard);

        Typeface font = Typeface.createFromAsset(getAssets(), pasta + fontBanger);
        txtTitulo.setTypeface(font);

    }

    public void verEquipes(View view) {

        Intent intent = new Intent(Dashboard.this, Equipes.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        return;

    }

    public void verJogosPrimeiraFase(View view) {

        Intent intent = new Intent(Dashboard.this, JogosPrimeiraFase.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        return;

    }

    public void verClassificacao(View view) {

        Intent intent = new Intent(Dashboard.this, Classificacao.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        return;
    }

    public void verJogosEliminatorias(View view) {

        if (finalizouPrimeiraFase) {
            Intent intent = new Intent(Dashboard.this, MataMata.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            return;
        } else {
            Intent intent = new Intent(Dashboard.this, MataMataFake.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            return;
        }
    }

    public void verArtilharia(View view) {
        salvarTelaAnterior("artilharia");

        if (qtdJogadores >= 1) {

            Intent intent = new Intent(Dashboard.this, Artilharia.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            return;
        } else {
            Intent intent = new Intent(Dashboard.this, CadastrarJogador.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            return;
        }

    }

    public void verCartoes(View view) {
        salvarTelaAnterior("cartoes");

        if (qtdJogadores >= 1) {

            Intent intent = new Intent(Dashboard.this, Cartoes.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            return;
        } else {
            Intent intent = new Intent(Dashboard.this, CadastrarJogador.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            return;
        }
    }

    public void verMelhorDefesa(View view) {

        Intent intent = new Intent(Dashboard.this, MelhorDefesa.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        return;
    }

    public void verMelhorAtaque(View view) {

        Intent intent = new Intent(Dashboard.this, MelhorAtaque.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        return;

    }


    @Override
    public void onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
            return;
        } else {
            Toast.makeText(this, "Pressione novamente para sair.", Toast.LENGTH_SHORT).show();
        }

        backPressedTime = System.currentTimeMillis();
    }

    private void salvarTelaAnterior(String tela) {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putString("telaAnterior", tela);
        dados.apply();
    }

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        qtdEquipes = preferences.getInt("qtdEquipes", -1);
        finalizouPrimeiraFase = preferences.getBoolean("finalizouPrimeiraFase", false);
        qtdJogadores = preferences.getInt("qtdJogadores", 0);

    }


}