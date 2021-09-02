package com.innovatesolutions.organizetorneios.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.api.AppUtil;
import com.innovatesolutions.organizetorneios.controller.EquipeController;
import com.innovatesolutions.organizetorneios.model.Equipe;
import com.innovatesolutions.organizetorneios.model.Torneio;

public class MelhorAtaque extends AppCompatActivity {

    private TextView txtEquipe1, gpEquipe1, txtEquipe2, gpEquipe2, txtEquipe3, gpEquipe3, txtEquipe4, gpEquipe4, txtEquipe5, gpEquipe5, txtEquipe6, gpEquipe6, txtEquipe7, gpEquipe7, txtEquipe8, gpEquipe8, txtEquipe9, gpEquipe9, txtEquipe10, gpEquipe10, txtEquipe11, gpEquipe11, txtEquipe12, gpEquipe12, txtEquipe13, gpEquipe13, txtEquipe14, gpEquipe14, txtEquipe15, gpEquipe15, txtEquipe16, gpEquipe16;
    private Equipe equipe1, equipe2, equipe3, equipe4, equipe5, equipe6, equipe7, equipe8, equipe9, equipe10, equipe11, equipe12, equipe13, equipe14, equipe15, equipe16;
    private EquipeController equipeController;
    private SharedPreferences preferences;
    private int equipe1ID, equipe2ID, equipe3ID, equipe4ID, equipe5ID, equipe6ID, equipe7ID, equipe8ID, equipe9ID, equipe10ID, equipe11ID, equipe12ID, equipe13ID, equipe14ID, equipe15ID, equipe16ID, qtdEquipes;
    private Equipe[] equipes;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        restaurarSharedPreferencesQtdEquipes();
        switch (qtdEquipes) {
            case Torneio.TORNEIO_QUATRO_EQUIPES:
                setContentView(R.layout.activity_melhor_ataque_quatro);
                break;
            case Torneio.TORNEIO_DOZE_EQUIPES:
                setContentView(R.layout.activity_melhor_ataque_doze);
                break;
            case Torneio.TORNEIO_DEZESSEIS_EQUIPES:
                setContentView(R.layout.activity_melhor_ataque_dezesseis);
                break;
        }

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        restaurarSharedPreferences();
        initFormulario();
        popularFormulario();
    }

    private void initFormulario() {
        txtEquipe1 = findViewById(R.id.txtEquipe1);
        txtEquipe2 = findViewById(R.id.txtEquipe2);
        txtEquipe3 = findViewById(R.id.txtEquipe3);
        txtEquipe4 = findViewById(R.id.txtEquipe4);
        gpEquipe1 = findViewById(R.id.txtGolsProEquipe1);
        gpEquipe2 = findViewById(R.id.txtGolsProEquipe2);
        gpEquipe3 = findViewById(R.id.txtGolsProEquipe3);
        gpEquipe4 = findViewById(R.id.txtGolsProEquipe4);

        equipe1 = new Equipe();
        equipe1.setId(equipe1ID);
        equipe2 = new Equipe();
        equipe2.setId(equipe2ID);
        equipe3 = new Equipe();
        equipe3.setId(equipe3ID);
        equipe4 = new Equipe();
        equipe4.setId(equipe4ID);

        equipes = new Equipe[qtdEquipes];
        equipeController = new EquipeController(this);

        if (qtdEquipes > Torneio.TORNEIO_QUATRO_EQUIPES) {
            txtEquipe5 = findViewById(R.id.txtEquipe5);
            txtEquipe6 = findViewById(R.id.txtEquipe6);
            txtEquipe7 = findViewById(R.id.txtEquipe7);
            txtEquipe8 = findViewById(R.id.txtEquipe8);
            txtEquipe9 = findViewById(R.id.txtEquipe9);
            txtEquipe10 = findViewById(R.id.txtEquipe10);
            txtEquipe11 = findViewById(R.id.txtEquipe11);
            txtEquipe12 = findViewById(R.id.txtEquipe12);
            gpEquipe5 = findViewById(R.id.txtGolsProEquipe5);
            gpEquipe6 = findViewById(R.id.txtGolsProEquipe6);
            gpEquipe7 = findViewById(R.id.txtGolsProEquipe7);
            gpEquipe8 = findViewById(R.id.txtGolsProEquipe8);
            gpEquipe9 = findViewById(R.id.txtGolsProEquipe9);
            gpEquipe10 = findViewById(R.id.txtGolsProEquipe10);
            gpEquipe11 = findViewById(R.id.txtGolsProEquipe11);
            gpEquipe12 = findViewById(R.id.txtGolsProEquipe12);

            equipe5 = new Equipe();
            equipe5.setId(equipe5ID);
            equipe6 = new Equipe();
            equipe6.setId(equipe6ID);
            equipe7 = new Equipe();
            equipe7.setId(equipe7ID);
            equipe8 = new Equipe();
            equipe8.setId(equipe8ID);
            equipe9 = new Equipe();
            equipe9.setId(equipe9ID);
            equipe10 = new Equipe();
            equipe10.setId(equipe10ID);
            equipe11 = new Equipe();
            equipe11.setId(equipe11ID);
            equipe12 = new Equipe();
            equipe12.setId(equipe12ID);

        }
        if (qtdEquipes > Torneio.TORNEIO_DOZE_EQUIPES) {
            txtEquipe13 = findViewById(R.id.txtEquipe13);
            txtEquipe14 = findViewById(R.id.txtEquipe14);
            txtEquipe15 = findViewById(R.id.txtEquipe15);
            txtEquipe16 = findViewById(R.id.txtEquipe16);
            gpEquipe13 = findViewById(R.id.txtGolsProEquipe13);
            gpEquipe14 = findViewById(R.id.txtGolsProEquipe14);
            gpEquipe15 = findViewById(R.id.txtGolsProEquipe15);
            gpEquipe16 = findViewById(R.id.txtGolsProEquipe16);

            equipe13 = new Equipe();
            equipe13.setId(equipe13ID);
            equipe14 = new Equipe();
            equipe14.setId(equipe14ID);
            equipe15 = new Equipe();
            equipe15.setId(equipe15ID);
            equipe16 = new Equipe();
            equipe16.setId(equipe16ID);
        }
    }

    private void popularFormulario() {
        equipe1 = equipeController.getEquipeByID(equipe1);
        equipe2 = equipeController.getEquipeByID(equipe2);
        equipe3 = equipeController.getEquipeByID(equipe3);
        equipe4 = equipeController.getEquipeByID(equipe4);

        equipes[0] = equipe1;
        equipes[1] = equipe2;
        equipes[2] = equipe3;
        equipes[3] = equipe4;

        if (qtdEquipes > Torneio.TORNEIO_QUATRO_EQUIPES) {
            equipe5 = equipeController.getEquipeByID(equipe5);
            equipe6 = equipeController.getEquipeByID(equipe6);
            equipe7 = equipeController.getEquipeByID(equipe7);
            equipe8 = equipeController.getEquipeByID(equipe8);
            equipe9 = equipeController.getEquipeByID(equipe9);
            equipe10 = equipeController.getEquipeByID(equipe10);
            equipe11 = equipeController.getEquipeByID(equipe11);
            equipe12 = equipeController.getEquipeByID(equipe12);

            equipes[4] = equipe5;
            equipes[5] = equipe6;
            equipes[6] = equipe7;
            equipes[7] = equipe8;
            equipes[8] = equipe9;
            equipes[9] = equipe10;
            equipes[10] = equipe11;
            equipes[11] = equipe12;

        }
        if (qtdEquipes > Torneio.TORNEIO_DOZE_EQUIPES) {
            equipe13 = equipeController.getEquipeByID(equipe13);
            equipe14 = equipeController.getEquipeByID(equipe14);
            equipe15 = equipeController.getEquipeByID(equipe15);
            equipe16 = equipeController.getEquipeByID(equipe16);

            equipes[12] = equipe13;
            equipes[13] = equipe14;
            equipes[14] = equipe15;
            equipes[15] = equipe16;

        }

        ordenaMelhorAtaque(equipes);

        txtEquipe1.setText(equipes[0].getNome());
        gpEquipe1.setText(String.valueOf(equipes[0].getGolsPro()));
        txtEquipe2.setText(equipes[1].getNome());
        gpEquipe2.setText(String.valueOf(equipes[1].getGolsPro()));
        txtEquipe3.setText(equipes[2].getNome());
        gpEquipe3.setText(String.valueOf(equipes[2].getGolsPro()));
        txtEquipe4.setText(equipes[3].getNome());
        gpEquipe4.setText(String.valueOf(equipes[3].getGolsPro()));
        if (qtdEquipes > Torneio.GRUPO_QUATRO_EQUIPES) {
            txtEquipe5.setText(equipes[4].getNome());
            gpEquipe5.setText(String.valueOf(equipes[4].getGolsPro()));
            txtEquipe6.setText(equipes[5].getNome());
            gpEquipe6.setText(String.valueOf(equipes[5].getGolsPro()));
            txtEquipe7.setText(equipes[6].getNome());
            gpEquipe7.setText(String.valueOf(equipes[6].getGolsPro()));
            txtEquipe8.setText(equipes[7].getNome());
            gpEquipe8.setText(String.valueOf(equipes[7].getGolsPro()));
            txtEquipe9.setText(equipes[8].getNome());
            gpEquipe9.setText(String.valueOf(equipes[8].getGolsPro()));
            txtEquipe10.setText(equipes[9].getNome());
            gpEquipe10.setText(String.valueOf(equipes[9].getGolsPro()));
            txtEquipe11.setText(equipes[10].getNome());
            gpEquipe11.setText(String.valueOf(equipes[10].getGolsPro()));
            txtEquipe12.setText(equipes[11].getNome());
            gpEquipe12.setText(String.valueOf(equipes[11].getGolsPro()));
        }
        if (qtdEquipes > Torneio.TORNEIO_DOZE_EQUIPES) {
            txtEquipe13.setText(equipes[12].getNome());
            gpEquipe13.setText(String.valueOf(equipes[12].getGolsPro()));
            txtEquipe14.setText(equipes[13].getNome());
            gpEquipe14.setText(String.valueOf(equipes[13].getGolsPro()));
            txtEquipe15.setText(equipes[14].getNome());
            gpEquipe15.setText(String.valueOf(equipes[14].getGolsPro()));
            txtEquipe16.setText(equipes[15].getNome());
            gpEquipe16.setText(String.valueOf(equipes[15].getGolsPro()));
        }
    }

    public void voltar(View view) {
        AppUtil.goNextScreen(MelhorAtaque.this, Dashboard.class, true);
        finish();
    }

    @Override
    public void onBackPressed() {
        AppUtil.goNextScreen(MelhorAtaque.this, Dashboard.class, true);
        finish();
    }

    private void ordenaMelhorAtaque(Equipe[] equipes) {
        boolean troca = true;
        Equipe equipeFake;
        while (troca) {
            troca = false;
            for (int i = 0; i < equipes.length - 1; i++) {
                if (equipes[i].getGolsPro() < equipes[i + 1].getGolsPro()) {
                    equipeFake = equipes[i];
                    equipes[i] = equipes[i + 1];
                    equipes[i + 1] = equipeFake;
                    troca = true;
                }
            }
        }
    }

    private void restaurarSharedPreferencesQtdEquipes() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        qtdEquipes = preferences.getInt("qtdEquipes", -1);
    }

    private void restaurarSharedPreferences() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);

        equipe1ID = preferences.getInt("equipe1ID", -1);
        equipe2ID = preferences.getInt("equipe2ID", -1);
        equipe3ID = preferences.getInt("equipe3ID", -1);
        equipe4ID = preferences.getInt("equipe4ID", -1);
        if (qtdEquipes > Torneio.TORNEIO_QUATRO_EQUIPES) {
            equipe5ID = preferences.getInt("equipe5ID", -1);
            equipe6ID = preferences.getInt("equipe6ID", -1);
            equipe7ID = preferences.getInt("equipe7ID", -1);
            equipe8ID = preferences.getInt("equipe8ID", -1);
            equipe9ID = preferences.getInt("equipe9ID", -1);
            equipe10ID = preferences.getInt("equipe10ID", -1);
            equipe11ID = preferences.getInt("equipe11ID", -1);
            equipe12ID = preferences.getInt("equipe12ID", -1);
        }
        if (qtdEquipes > Torneio.TORNEIO_DOZE_EQUIPES) {
            equipe13ID = preferences.getInt("equipe13ID", -1);
            equipe14ID = preferences.getInt("equipe14ID", -1);
            equipe15ID = preferences.getInt("equipe15ID", -1);
            equipe16ID = preferences.getInt("equipe16ID", -1);
        }
    }
}