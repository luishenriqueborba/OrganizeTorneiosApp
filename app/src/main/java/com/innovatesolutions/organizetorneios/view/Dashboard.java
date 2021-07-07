package com.innovatesolutions.organizetorneios.view;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.api.AppUtil;

public class Dashboard extends AppCompatActivity {

    private long backPressedTime;
    private SharedPreferences preferences;
    private int qtdEquipes, qtdJogadores;
    private boolean finalizouPrimeiraFase;
    private final String pasta = "fonts/";
    private final String fontBanger = "Bangers.ttf";

    TextView txtTitulo;

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
        AppUtil.goNextScreen(Dashboard.this, Equipes.class, true);
        finish();
    }

    public void verJogosPrimeiraFase(View view) {
        AppUtil.goNextScreen(Dashboard.this, JogosPrimeiraFase.class, true);
        finish();
    }

    public void verClassificacao(View view) {
        AppUtil.goNextScreen(Dashboard.this, Classificacao.class, true);
        finish();
    }

    public void verJogosEliminatorias(View view) {
        if (finalizouPrimeiraFase) {
            AppUtil.goNextScreen(Dashboard.this, MataMata.class, true);
            finish();
        } else {
            AppUtil.goNextScreen(Dashboard.this, MataMataFake.class, true);
            finish();
        }
    }

    public void verArtilharia(View view) {
        salvarTelaAnterior("artilharia");
        if (qtdJogadores >= 1) {
            AppUtil.goNextScreen(Dashboard.this, Artilharia.class, true);
            finish();
        } else {
            AppUtil.goNextScreen(Dashboard.this, CadastrarJogador.class, true);
            finish();
        }
    }

    public void verCartoes(View view) {
        salvarTelaAnterior("cartoes");
        if (qtdJogadores >= 1) {
            AppUtil.goNextScreen(Dashboard.this, Cartoes.class, true);
            finish();
        } else {
            AppUtil.goNextScreen(Dashboard.this, CadastrarJogador.class, true);
            finish();
        }
    }

    public void verMelhorDefesa(View view) {
        AppUtil.goNextScreen(Dashboard.this, MelhorDefesa.class, true);
        finish();
    }

    public void verMelhorAtaque(View view) {
        AppUtil.goNextScreen(Dashboard.this, MelhorAtaque.class, true);
        finish();
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