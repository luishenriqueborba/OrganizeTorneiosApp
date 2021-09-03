package com.innovatesolutions.organizetorneios.view;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.api.AppUtil;
import com.innovatesolutions.organizetorneios.controller.EquipeController;
import com.innovatesolutions.organizetorneios.controller.GrupoController;
import com.innovatesolutions.organizetorneios.model.Equipe;
import com.innovatesolutions.organizetorneios.model.Grupo;
import com.innovatesolutions.organizetorneios.model.Torneio;
import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.Icon;

import static android.content.ContentValues.TAG;

public class JogosPrimeiraFase extends AppCompatActivity {

    private TextView txtEquipe1J1, txtEquipe1J2, txtEquipe1J3,
            txtEquipe2J1, txtEquipe2J2, txtEquipe2J3,
            txtEquipe3J1, txtEquipe3J2, txtEquipe3J3,
            txtEquipe4J1, txtEquipe4J2, txtEquipe4J3,
            txtEquipe5J1, txtEquipe5J2, txtEquipe5J3,
            txtEquipe6J1, txtEquipe6J2, txtEquipe6J3,
            txtEquipe7J1, txtEquipe7J2, txtEquipe7J3,
            txtEquipe8J1, txtEquipe8J2, txtEquipe8J3,
            txtEquipe9J1, txtEquipe9J2, txtEquipe9J3,
            txtEquipe10J1, txtEquipe10J2, txtEquipe10J3,
            txtEquipe11J1, txtEquipe11J2, txtEquipe11J3,
            txtEquipe12J1, txtEquipe12J2, txtEquipe12J3,
            txtEquipe13J1, txtEquipe13J2, txtEquipe13J3,
            txtEquipe14J1, txtEquipe14J2, txtEquipe14J3,
            txtEquipe15J1, txtEquipe15J2, txtEquipe15J3,
            txtEquipe16J1, txtEquipe16J2, txtEquipe16J3;
    private EditText editPlacarEquipe1J1, editPlacarEquipe1J2, editPlacarEquipe1J3,
            editPlacarEquipe2J1, editPlacarEquipe2J2, editPlacarEquipe2J3,
            editPlacarEquipe3J1, editPlacarEquipe3J2, editPlacarEquipe3J3,
            editPlacarEquipe4J1, editPlacarEquipe4J2, editPlacarEquipe4J3,
            editPlacarEquipe5J1, editPlacarEquipe5J2, editPlacarEquipe5J3,
            editPlacarEquipe6J1, editPlacarEquipe6J2, editPlacarEquipe6J3,
            editPlacarEquipe7J1, editPlacarEquipe7J2, editPlacarEquipe7J3,
            editPlacarEquipe8J1, editPlacarEquipe8J2, editPlacarEquipe8J3,
            editPlacarEquipe9J1, editPlacarEquipe9J2, editPlacarEquipe9J3,
            editPlacarEquipe10J1, editPlacarEquipe10J2, editPlacarEquipe10J3,
            editPlacarEquipe11J1, editPlacarEquipe11J2, editPlacarEquipe11J3,
            editPlacarEquipe12J1, editPlacarEquipe12J2, editPlacarEquipe12J3,
            editPlacarEquipe13J1, editPlacarEquipe13J2, editPlacarEquipe13J3,
            editPlacarEquipe14J1, editPlacarEquipe14J2, editPlacarEquipe14J3,
            editPlacarEquipe15J1, editPlacarEquipe15J2, editPlacarEquipe15J3,
            editPlacarEquipe16J1, editPlacarEquipe16J2, editPlacarEquipe16J3;
    private String placarEquipe1J1, placarEquipe1J2, placarEquipe1J3,
            placarEquipe2J1, placarEquipe2J2, placarEquipe2J3,
            placarEquipe3J1, placarEquipe3J2, placarEquipe3J3,
            placarEquipe4J1, placarEquipe4J2, placarEquipe4J3,
            placarEquipe5J1, placarEquipe5J2, placarEquipe5J3,
            placarEquipe6J1, placarEquipe6J2, placarEquipe6J3,
            placarEquipe7J1, placarEquipe7J2, placarEquipe7J3,
            placarEquipe8J1, placarEquipe8J2, placarEquipe8J3,
            placarEquipe9J1, placarEquipe9J2, placarEquipe9J3,
            placarEquipe10J1, placarEquipe10J2, placarEquipe10J3,
            placarEquipe11J1, placarEquipe11J2, placarEquipe11J3,
            placarEquipe12J1, placarEquipe12J2, placarEquipe12J3,
            placarEquipe13J1, placarEquipe13J2, placarEquipe13J3,
            placarEquipe14J1, placarEquipe14J2, placarEquipe14J3,
            placarEquipe15J1, placarEquipe15J2, placarEquipe15J3,
            placarEquipe16J1, placarEquipe16J2, placarEquipe16J3;
    private Grupo grupo1, grupo2, grupo3, grupo4;
    private GrupoController grupoController;
    private Equipe equipe1, equipe2, equipe3, equipe4, equipe5, equipe6, equipe7, equipe8, equipe9, equipe10, equipe11, equipe12, equipe13, equipe14, equipe15, equipe16;
    private EquipeController equipeController;
    private Equipe[] equipes, equipesA, equipesB, equipesC, equipesD;
    private SharedPreferences preferences;
    private int grupo1ID, grupo2ID, grupo3ID, grupo4ID, equipe1ID, equipe2ID, equipe3ID, equipe4ID, equipe5ID, equipe6ID, equipe7ID, equipe8ID, equipe9ID, equipe10ID, equipe11ID, equipe12ID, equipe13ID, equipe14ID, equipe15ID, equipe16ID, placarA, placarB, qtdEquipes;
    private Button btnSalvar, btnEditar, btnFinalizarPrimeiraFase;
    private boolean trocaTela;
    private boolean conseguiu = false;
    private boolean finalizouQuartas;
    private boolean finalizouPrimeiraFase;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        restaurarSharedPreferencesQtdEquipes();
        switch (qtdEquipes) {
            case Torneio.TORNEIO_QUATRO_EQUIPES:
                setContentView(R.layout.activity_jogos_primeira_fase_quatro);
                break;
            case Torneio.TORNEIO_DOZE_EQUIPES:
                setContentView(R.layout.activity_jogos_primeira_fase_doze);
                break;
            case Torneio.TORNEIO_DEZESSEIS_EQUIPES:
                setContentView(R.layout.activity_jogos_primeira_fase_dezesseis);
                break;
        }

        MobileAds.initialize(this, initializationStatus -> {
        });
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        restaurarSharedPreferences();
        initFormulario();
        configuraBotoesCarregamentoTela();
        popularFormulario();

        btnSalvar.setOnClickListener(v -> {
            salvarStatusFaseSharedPreferences();
            salvarResultados();
        });

        btnFinalizarPrimeiraFase.setOnClickListener(v -> {
            if (finalizarPrimeiraFase()) {
                restaurarSharedPreferencesQtdEquipes();
                if (finalizouPrimeiraFase) {
                    showInterstitialAd(getString(R.string.anuncioIntersticial2), adRequest);
                }
            }
        });
    }

    private void showInterstitialAd(String adUnitId, AdRequest adRequest) {
        InterstitialAd.load(JogosPrimeiraFase.this, adUnitId, adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i(TAG, "onAdLoaded");

                        if (mInterstitialAd != null) {

                            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    // Called when fullscreen content is dismissed.
                                    Log.d("TAG", "The ad was dismissed.");
                                    AppUtil.goNextScreen(JogosPrimeiraFase.this, Dashboard.class, false);
                                    finish();
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(AdError adError) {
                                    // Called when fullscreen content failed to show.
                                    Log.d("TAG", "The ad failed to show.");
                                    AppUtil.goNextScreen(JogosPrimeiraFase.this, Dashboard.class, false);
                                    finish();
                                }

                                @Override
                                public void onAdShowedFullScreenContent() {
                                    // Called when fullscreen content is shown.
                                    // Make sure to set your reference to null so you don't
                                    // show it a second time.
                                    mInterstitialAd = null;
                                    Log.d("TAG", "The ad was shown.");
                                }
                            });

                            mInterstitialAd.show(JogosPrimeiraFase.this);
                        } else {
                            Log.d("TAG", "The interstitial ad wasn't ready yet.");
                        }
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i(TAG, loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });
    }

    private void initFormulario() {
        btnEditar = findViewById(R.id.btnEditar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizarPrimeiraFase = findViewById(R.id.btnFinalizarPrimeiraFase);

        equipeController = new EquipeController(this);
        grupoController = new GrupoController(this);

        grupo1 = new Grupo();
        grupo1.setId(grupo1ID);
        equipe1 = new Equipe();
        equipe1.setId(equipe1ID);
        equipe2 = new Equipe();
        equipe2.setId(equipe2ID);
        equipe3 = new Equipe();
        equipe3.setId(equipe3ID);
        equipe4 = new Equipe();
        equipe4.setId(equipe4ID);

        if (qtdEquipes == Torneio.TORNEIO_QUATRO_EQUIPES) {
            txtEquipe1J1 = findViewById(R.id.txtEquipe1J1);
            txtEquipe1J2 = findViewById(R.id.txtEquipe1J2);
            txtEquipe1J3 = findViewById(R.id.txtEquipe1J3);
            txtEquipe2J1 = findViewById(R.id.txtEquipe2J1);
            txtEquipe2J2 = findViewById(R.id.txtEquipe2J2);
            txtEquipe2J3 = findViewById(R.id.txtEquipe2J3);
            txtEquipe3J1 = findViewById(R.id.txtEquipe3J1);
            txtEquipe3J2 = findViewById(R.id.txtEquipe3J2);
            txtEquipe3J3 = findViewById(R.id.txtEquipe3J3);
            txtEquipe4J1 = findViewById(R.id.txtEquipe4J1);
            txtEquipe4J2 = findViewById(R.id.txtEquipe4J2);
            txtEquipe4J3 = findViewById(R.id.txtEquipe4J3);
            editPlacarEquipe1J1 = findViewById(R.id.editPlacarEquipe1J1);
            editPlacarEquipe1J2 = findViewById(R.id.editPlacarEquipe1J2);
            editPlacarEquipe1J3 = findViewById(R.id.editPlacarEquipe1J3);
            editPlacarEquipe2J1 = findViewById(R.id.editPlacarEquipe2J1);
            editPlacarEquipe2J2 = findViewById(R.id.editPlacarEquipe2J2);
            editPlacarEquipe2J3 = findViewById(R.id.editPlacarEquipe2J3);
            editPlacarEquipe3J1 = findViewById(R.id.editPlacarEquipe3J1);
            editPlacarEquipe3J2 = findViewById(R.id.editPlacarEquipe3J2);
            editPlacarEquipe3J3 = findViewById(R.id.editPlacarEquipe3J3);
            editPlacarEquipe4J1 = findViewById(R.id.editPlacarEquipe4J1);
            editPlacarEquipe4J2 = findViewById(R.id.editPlacarEquipe4J2);
            editPlacarEquipe4J3 = findViewById(R.id.editPlacarEquipe4J3);
        }

        if (qtdEquipes > Torneio.TORNEIO_QUATRO_EQUIPES) {
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

            grupo2 = new Grupo();
            grupo2.setId(grupo2ID);
            grupo3 = new Grupo();
            grupo3.setId(grupo3ID);
            grupo4 = new Grupo();
            grupo4.setId(grupo4ID);

            if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
                txtEquipe1J1 = findViewById(R.id.txtEquipe1J1);
                txtEquipe1J2 = findViewById(R.id.txtEquipe1J2);
                txtEquipe2J1 = findViewById(R.id.txtEquipe2J1);
                txtEquipe2J2 = findViewById(R.id.txtEquipe2J2);
                txtEquipe3J1 = findViewById(R.id.txtEquipe3J1);
                txtEquipe3J2 = findViewById(R.id.txtEquipe3J2);
                txtEquipe4J1 = findViewById(R.id.txtEquipe4J1);
                txtEquipe4J2 = findViewById(R.id.txtEquipe4J2);
                txtEquipe5J1 = findViewById(R.id.txtEquipe5J1);
                txtEquipe5J2 = findViewById(R.id.txtEquipe5J2);
                txtEquipe6J1 = findViewById(R.id.txtEquipe6J1);
                txtEquipe6J2 = findViewById(R.id.txtEquipe6J2);
                txtEquipe7J1 = findViewById(R.id.txtEquipe7J1);
                txtEquipe7J2 = findViewById(R.id.txtEquipe7J2);
                txtEquipe8J1 = findViewById(R.id.txtEquipe8J1);
                txtEquipe8J2 = findViewById(R.id.txtEquipe8J2);
                txtEquipe9J1 = findViewById(R.id.txtEquipe9J1);
                txtEquipe9J2 = findViewById(R.id.txtEquipe9J2);
                txtEquipe10J1 = findViewById(R.id.txtEquipe10J1);
                txtEquipe10J2 = findViewById(R.id.txtEquipe10J2);
                txtEquipe11J1 = findViewById(R.id.txtEquipe11J1);
                txtEquipe11J2 = findViewById(R.id.txtEquipe11J2);
                txtEquipe12J1 = findViewById(R.id.txtEquipe12J1);
                txtEquipe12J2 = findViewById(R.id.txtEquipe12J2);

                editPlacarEquipe1J1 = findViewById(R.id.editPlacarEquipe1J1);
                editPlacarEquipe1J2 = findViewById(R.id.editPlacarEquipe1J2);
                editPlacarEquipe2J1 = findViewById(R.id.editPlacarEquipe2J1);
                editPlacarEquipe2J2 = findViewById(R.id.editPlacarEquipe2J2);
                editPlacarEquipe3J1 = findViewById(R.id.editPlacarEquipe3J1);
                editPlacarEquipe3J2 = findViewById(R.id.editPlacarEquipe3J2);
                editPlacarEquipe4J1 = findViewById(R.id.editPlacarEquipe4J1);
                editPlacarEquipe4J2 = findViewById(R.id.editPlacarEquipe4J2);
                editPlacarEquipe5J1 = findViewById(R.id.editPlacarEquipe5J1);
                editPlacarEquipe5J2 = findViewById(R.id.editPlacarEquipe5J2);
                editPlacarEquipe6J1 = findViewById(R.id.editPlacarEquipe6J1);
                editPlacarEquipe6J2 = findViewById(R.id.editPlacarEquipe6J2);
                editPlacarEquipe7J1 = findViewById(R.id.editPlacarEquipe7J1);
                editPlacarEquipe7J2 = findViewById(R.id.editPlacarEquipe7J2);
                editPlacarEquipe8J1 = findViewById(R.id.editPlacarEquipe8J1);
                editPlacarEquipe8J2 = findViewById(R.id.editPlacarEquipe8J2);
                editPlacarEquipe9J1 = findViewById(R.id.editPlacarEquipe9J1);
                editPlacarEquipe9J2 = findViewById(R.id.editPlacarEquipe9J2);
                editPlacarEquipe10J1 = findViewById(R.id.editPlacarEquipe10J1);
                editPlacarEquipe10J2 = findViewById(R.id.editPlacarEquipe10J2);
                editPlacarEquipe11J1 = findViewById(R.id.editPlacarEquipe11J1);
                editPlacarEquipe11J2 = findViewById(R.id.editPlacarEquipe11J2);
                editPlacarEquipe12J1 = findViewById(R.id.editPlacarEquipe12J1);
                editPlacarEquipe12J2 = findViewById(R.id.editPlacarEquipe12J2);

                equipesA = new Equipe[Torneio.GRUPO_TRES_EQUIPES];
                equipesB = new Equipe[Torneio.GRUPO_TRES_EQUIPES];
                equipesC = new Equipe[Torneio.GRUPO_TRES_EQUIPES];
                equipesD = new Equipe[Torneio.GRUPO_TRES_EQUIPES];
            }
        }
        if (qtdEquipes > Torneio.TORNEIO_DOZE_EQUIPES) {
            equipe13 = new Equipe();
            equipe13.setId(equipe13ID);
            equipe14 = new Equipe();
            equipe14.setId(equipe14ID);
            equipe15 = new Equipe();
            equipe15.setId(equipe15ID);
            equipe16 = new Equipe();
            equipe16.setId(equipe16ID);

            if (qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
                txtEquipe1J1 = findViewById(R.id.txtEquipe1J1);
                txtEquipe1J2 = findViewById(R.id.txtEquipe1J2);
                txtEquipe1J3 = findViewById(R.id.txtEquipe1J3);
                txtEquipe2J1 = findViewById(R.id.txtEquipe2J1);
                txtEquipe2J2 = findViewById(R.id.txtEquipe2J2);
                txtEquipe2J3 = findViewById(R.id.txtEquipe2J3);
                txtEquipe3J1 = findViewById(R.id.txtEquipe3J1);
                txtEquipe3J2 = findViewById(R.id.txtEquipe3J2);
                txtEquipe3J3 = findViewById(R.id.txtEquipe3J3);
                txtEquipe4J1 = findViewById(R.id.txtEquipe4J1);
                txtEquipe4J2 = findViewById(R.id.txtEquipe4J2);
                txtEquipe4J3 = findViewById(R.id.txtEquipe4J3);
                txtEquipe5J1 = findViewById(R.id.txtEquipe5J1);
                txtEquipe5J2 = findViewById(R.id.txtEquipe5J2);
                txtEquipe5J3 = findViewById(R.id.txtEquipe5J3);
                txtEquipe6J1 = findViewById(R.id.txtEquipe6J1);
                txtEquipe6J2 = findViewById(R.id.txtEquipe6J2);
                txtEquipe6J3 = findViewById(R.id.txtEquipe6J3);
                txtEquipe7J1 = findViewById(R.id.txtEquipe7J1);
                txtEquipe7J2 = findViewById(R.id.txtEquipe7J2);
                txtEquipe7J3 = findViewById(R.id.txtEquipe7J3);
                txtEquipe8J1 = findViewById(R.id.txtEquipe8J1);
                txtEquipe8J2 = findViewById(R.id.txtEquipe8J2);
                txtEquipe8J3 = findViewById(R.id.txtEquipe8J3);
                txtEquipe9J1 = findViewById(R.id.txtEquipe9J1);
                txtEquipe9J2 = findViewById(R.id.txtEquipe9J2);
                txtEquipe9J3 = findViewById(R.id.txtEquipe9J3);
                txtEquipe10J1 = findViewById(R.id.txtEquipe10J1);
                txtEquipe10J2 = findViewById(R.id.txtEquipe10J2);
                txtEquipe10J3 = findViewById(R.id.txtEquipe10J3);
                txtEquipe11J1 = findViewById(R.id.txtEquipe11J1);
                txtEquipe11J2 = findViewById(R.id.txtEquipe11J2);
                txtEquipe11J3 = findViewById(R.id.txtEquipe11J3);
                txtEquipe12J1 = findViewById(R.id.txtEquipe12J1);
                txtEquipe12J2 = findViewById(R.id.txtEquipe12J2);
                txtEquipe12J3 = findViewById(R.id.txtEquipe12J3);
                txtEquipe13J1 = findViewById(R.id.txtEquipe13J1);
                txtEquipe13J2 = findViewById(R.id.txtEquipe13J2);
                txtEquipe13J3 = findViewById(R.id.txtEquipe13J3);
                txtEquipe14J1 = findViewById(R.id.txtEquipe14J1);
                txtEquipe14J2 = findViewById(R.id.txtEquipe14J2);
                txtEquipe14J3 = findViewById(R.id.txtEquipe14J3);
                txtEquipe15J1 = findViewById(R.id.txtEquipe15J1);
                txtEquipe15J2 = findViewById(R.id.txtEquipe15J2);
                txtEquipe15J3 = findViewById(R.id.txtEquipe15J3);
                txtEquipe16J1 = findViewById(R.id.txtEquipe16J1);
                txtEquipe16J2 = findViewById(R.id.txtEquipe16J2);
                txtEquipe16J3 = findViewById(R.id.txtEquipe16J3);

                editPlacarEquipe1J1 = findViewById(R.id.editPlacarEquipe1J1);
                editPlacarEquipe1J2 = findViewById(R.id.editPlacarEquipe1J2);
                editPlacarEquipe1J3 = findViewById(R.id.editPlacarEquipe1J3);
                editPlacarEquipe2J1 = findViewById(R.id.editPlacarEquipe2J1);
                editPlacarEquipe2J2 = findViewById(R.id.editPlacarEquipe2J2);
                editPlacarEquipe2J3 = findViewById(R.id.editPlacarEquipe2J3);
                editPlacarEquipe3J1 = findViewById(R.id.editPlacarEquipe3J1);
                editPlacarEquipe3J2 = findViewById(R.id.editPlacarEquipe3J2);
                editPlacarEquipe3J3 = findViewById(R.id.editPlacarEquipe3J3);
                editPlacarEquipe4J1 = findViewById(R.id.editPlacarEquipe4J1);
                editPlacarEquipe4J2 = findViewById(R.id.editPlacarEquipe4J2);
                editPlacarEquipe4J3 = findViewById(R.id.editPlacarEquipe4J3);
                editPlacarEquipe5J1 = findViewById(R.id.editPlacarEquipe5J1);
                editPlacarEquipe5J2 = findViewById(R.id.editPlacarEquipe5J2);
                editPlacarEquipe5J3 = findViewById(R.id.editPlacarEquipe5J3);
                editPlacarEquipe6J1 = findViewById(R.id.editPlacarEquipe6J1);
                editPlacarEquipe6J2 = findViewById(R.id.editPlacarEquipe6J2);
                editPlacarEquipe6J3 = findViewById(R.id.editPlacarEquipe6J3);
                editPlacarEquipe7J1 = findViewById(R.id.editPlacarEquipe7J1);
                editPlacarEquipe7J2 = findViewById(R.id.editPlacarEquipe7J2);
                editPlacarEquipe7J3 = findViewById(R.id.editPlacarEquipe7J3);
                editPlacarEquipe8J1 = findViewById(R.id.editPlacarEquipe8J1);
                editPlacarEquipe8J2 = findViewById(R.id.editPlacarEquipe8J2);
                editPlacarEquipe8J3 = findViewById(R.id.editPlacarEquipe8J3);
                editPlacarEquipe9J1 = findViewById(R.id.editPlacarEquipe9J1);
                editPlacarEquipe9J2 = findViewById(R.id.editPlacarEquipe9J2);
                editPlacarEquipe9J3 = findViewById(R.id.editPlacarEquipe9J3);
                editPlacarEquipe10J1 = findViewById(R.id.editPlacarEquipe10J1);
                editPlacarEquipe10J2 = findViewById(R.id.editPlacarEquipe10J2);
                editPlacarEquipe10J3 = findViewById(R.id.editPlacarEquipe10J3);
                editPlacarEquipe11J1 = findViewById(R.id.editPlacarEquipe11J1);
                editPlacarEquipe11J2 = findViewById(R.id.editPlacarEquipe11J2);
                editPlacarEquipe11J3 = findViewById(R.id.editPlacarEquipe11J3);
                editPlacarEquipe12J1 = findViewById(R.id.editPlacarEquipe12J1);
                editPlacarEquipe12J2 = findViewById(R.id.editPlacarEquipe12J2);
                editPlacarEquipe12J3 = findViewById(R.id.editPlacarEquipe12J3);
                editPlacarEquipe13J1 = findViewById(R.id.editPlacarEquipe13J1);
                editPlacarEquipe13J2 = findViewById(R.id.editPlacarEquipe13J2);
                editPlacarEquipe13J3 = findViewById(R.id.editPlacarEquipe13J3);
                editPlacarEquipe14J1 = findViewById(R.id.editPlacarEquipe14J1);
                editPlacarEquipe14J2 = findViewById(R.id.editPlacarEquipe14J2);
                editPlacarEquipe14J3 = findViewById(R.id.editPlacarEquipe14J3);
                editPlacarEquipe15J1 = findViewById(R.id.editPlacarEquipe15J1);
                editPlacarEquipe15J2 = findViewById(R.id.editPlacarEquipe15J2);
                editPlacarEquipe15J3 = findViewById(R.id.editPlacarEquipe15J3);
                editPlacarEquipe16J1 = findViewById(R.id.editPlacarEquipe16J1);
                editPlacarEquipe16J2 = findViewById(R.id.editPlacarEquipe16J2);
                editPlacarEquipe16J3 = findViewById(R.id.editPlacarEquipe16J3);

                equipesA = new Equipe[Torneio.GRUPO_QUATRO_EQUIPES];
                equipesB = new Equipe[Torneio.GRUPO_QUATRO_EQUIPES];
                equipesC = new Equipe[Torneio.GRUPO_QUATRO_EQUIPES];
                equipesD = new Equipe[Torneio.GRUPO_QUATRO_EQUIPES];
            }
        }
    }

    private void configuraBotoesCarregamentoTela() {
        if(finalizouPrimeiraFase) {
            btnSalvar.setVisibility(View.GONE);
            btnFinalizarPrimeiraFase.setVisibility(View.GONE);
        }
    }

    private void popularFormulario() {
        if (grupo1ID >= 1) {
            grupo1 = grupoController.getGrupoByID(grupo1);
            equipe1 = equipeController.getEquipeByID(equipe1);
            equipe2 = equipeController.getEquipeByID(equipe2);
            equipe3 = equipeController.getEquipeByID(equipe3);
            equipe4 = equipeController.getEquipeByID(equipe4);

            if (qtdEquipes == Torneio.TORNEIO_QUATRO_EQUIPES || qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
                grupo1.setEquipe1(equipe1);
                grupo1.setEquipe2(equipe2);
                grupo1.setEquipe3(equipe3);
                grupo1.setEquipe4(equipe4);
            }

            if (qtdEquipes == Torneio.TORNEIO_QUATRO_EQUIPES) {
                txtEquipe1J1.setText(grupo1.getEquipe1().getNome());
                txtEquipe1J2.setText(grupo1.getEquipe1().getNome());
                txtEquipe1J3.setText(grupo1.getEquipe1().getNome());
                txtEquipe2J1.setText(grupo1.getEquipe2().getNome());
                txtEquipe2J2.setText(grupo1.getEquipe2().getNome());
                txtEquipe2J3.setText(grupo1.getEquipe2().getNome());
                txtEquipe3J1.setText(grupo1.getEquipe3().getNome());
                txtEquipe3J2.setText(grupo1.getEquipe3().getNome());
                txtEquipe3J3.setText(grupo1.getEquipe3().getNome());
                txtEquipe4J1.setText(grupo1.getEquipe4().getNome());
                txtEquipe4J2.setText(grupo1.getEquipe4().getNome());
                txtEquipe4J3.setText(grupo1.getEquipe4().getNome());

                editPlacarEquipe1J1.setText(placarEquipe1J1);
                editPlacarEquipe1J2.setText(placarEquipe1J2);
                editPlacarEquipe1J3.setText(placarEquipe1J3);
                editPlacarEquipe2J1.setText(placarEquipe2J1);
                editPlacarEquipe2J2.setText(placarEquipe2J2);
                editPlacarEquipe2J3.setText(placarEquipe2J3);
                editPlacarEquipe3J1.setText(placarEquipe3J1);
                editPlacarEquipe3J2.setText(placarEquipe3J2);
                editPlacarEquipe3J3.setText(placarEquipe3J3);
                editPlacarEquipe4J1.setText(placarEquipe4J1);
                editPlacarEquipe4J2.setText(placarEquipe4J2);
                editPlacarEquipe4J3.setText(placarEquipe4J3);

                trocaTela = true;

                if (!editPlacarEquipe1J1.getText().toString().equals("") && !editPlacarEquipe2J1.getText().toString().equals("")) {
                    editPlacarEquipe1J1.setEnabled(false);
                    editPlacarEquipe2J1.setEnabled(false);
                }
                if (!editPlacarEquipe3J1.getText().toString().equals("") && !editPlacarEquipe4J1.getText().toString().equals("")) {
                    editPlacarEquipe3J1.setEnabled(false);
                    editPlacarEquipe4J1.setEnabled(false);
                }
                if (!editPlacarEquipe4J2.getText().toString().equals("") && !editPlacarEquipe1J2.getText().toString().equals("")) {
                    editPlacarEquipe4J2.setEnabled(false);
                    editPlacarEquipe1J2.setEnabled(false);
                }
                if (!editPlacarEquipe2J2.getText().toString().equals("") && !editPlacarEquipe3J2.getText().toString().equals("")) {
                    editPlacarEquipe2J2.setEnabled(false);
                    editPlacarEquipe3J2.setEnabled(false);
                }
                if (!editPlacarEquipe1J3.getText().toString().equals("") && !editPlacarEquipe3J3.getText().toString().equals("")) {
                    editPlacarEquipe1J3.setEnabled(false);
                    editPlacarEquipe3J3.setEnabled(false);
                }
                if (!editPlacarEquipe2J3.getText().toString().equals("") && !editPlacarEquipe4J3.getText().toString().equals("")) {
                    editPlacarEquipe2J3.setEnabled(false);
                    editPlacarEquipe4J3.setEnabled(false);
                }
            }
        } else {
            showFancyAlertDialog();
        }
        if (qtdEquipes > Torneio.TORNEIO_QUATRO_EQUIPES) {
            if (grupo4ID >= 1) {
                grupo2 = grupoController.getGrupoByID(grupo2);
                grupo3 = grupoController.getGrupoByID(grupo3);
                grupo4 = grupoController.getGrupoByID(grupo4);
                equipe5 = equipeController.getEquipeByID(equipe5);
                equipe6 = equipeController.getEquipeByID(equipe6);
                equipe7 = equipeController.getEquipeByID(equipe7);
                equipe8 = equipeController.getEquipeByID(equipe8);
                equipe9 = equipeController.getEquipeByID(equipe9);
                equipe10 = equipeController.getEquipeByID(equipe10);
                equipe11 = equipeController.getEquipeByID(equipe11);
                equipe12 = equipeController.getEquipeByID(equipe12);

                if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
                    grupo1.setEquipe1(equipe1);
                    grupo1.setEquipe2(equipe2);
                    grupo1.setEquipe3(equipe3);
                    grupo2.setEquipe1(equipe4);
                    grupo2.setEquipe2(equipe5);
                    grupo2.setEquipe3(equipe6);
                    grupo3.setEquipe1(equipe7);
                    grupo3.setEquipe2(equipe8);
                    grupo3.setEquipe3(equipe9);
                    grupo4.setEquipe1(equipe10);
                    grupo4.setEquipe2(equipe11);
                    grupo4.setEquipe3(equipe12);

                    txtEquipe1J1.setText(grupo1.getEquipe1().getNome());
                    txtEquipe1J2.setText(grupo1.getEquipe1().getNome());
                    txtEquipe2J1.setText(grupo1.getEquipe2().getNome());
                    txtEquipe2J2.setText(grupo1.getEquipe2().getNome());
                    txtEquipe3J1.setText(grupo1.getEquipe3().getNome());
                    txtEquipe3J2.setText(grupo1.getEquipe3().getNome());
                    txtEquipe4J1.setText(grupo2.getEquipe1().getNome());
                    txtEquipe4J2.setText(grupo2.getEquipe1().getNome());
                    txtEquipe5J1.setText(grupo2.getEquipe2().getNome());
                    txtEquipe5J2.setText(grupo2.getEquipe2().getNome());
                    txtEquipe6J1.setText(grupo2.getEquipe3().getNome());
                    txtEquipe6J2.setText(grupo2.getEquipe3().getNome());
                    txtEquipe7J1.setText(grupo3.getEquipe1().getNome());
                    txtEquipe7J2.setText(grupo3.getEquipe1().getNome());
                    txtEquipe8J1.setText(grupo3.getEquipe2().getNome());
                    txtEquipe8J2.setText(grupo3.getEquipe2().getNome());
                    txtEquipe9J1.setText(grupo3.getEquipe3().getNome());
                    txtEquipe9J2.setText(grupo3.getEquipe3().getNome());
                    txtEquipe10J1.setText(grupo4.getEquipe1().getNome());
                    txtEquipe10J2.setText(grupo4.getEquipe1().getNome());
                    txtEquipe11J1.setText(grupo4.getEquipe2().getNome());
                    txtEquipe11J2.setText(grupo4.getEquipe2().getNome());
                    txtEquipe12J1.setText(grupo4.getEquipe3().getNome());
                    txtEquipe12J2.setText(grupo4.getEquipe3().getNome());

                    editPlacarEquipe1J1.setText(placarEquipe1J1);
                    editPlacarEquipe1J2.setText(placarEquipe1J2);
                    editPlacarEquipe2J1.setText(placarEquipe2J1);
                    editPlacarEquipe2J2.setText(placarEquipe2J2);
                    editPlacarEquipe3J1.setText(placarEquipe3J1);
                    editPlacarEquipe3J2.setText(placarEquipe3J2);
                    editPlacarEquipe4J1.setText(placarEquipe4J1);
                    editPlacarEquipe4J2.setText(placarEquipe4J2);
                    editPlacarEquipe5J1.setText(placarEquipe5J1);
                    editPlacarEquipe5J2.setText(placarEquipe5J2);
                    editPlacarEquipe6J1.setText(placarEquipe6J1);
                    editPlacarEquipe6J2.setText(placarEquipe6J2);
                    editPlacarEquipe7J1.setText(placarEquipe7J1);
                    editPlacarEquipe7J2.setText(placarEquipe7J2);
                    editPlacarEquipe8J1.setText(placarEquipe8J1);
                    editPlacarEquipe8J2.setText(placarEquipe8J2);
                    editPlacarEquipe9J1.setText(placarEquipe9J1);
                    editPlacarEquipe9J2.setText(placarEquipe9J2);
                    editPlacarEquipe10J1.setText(placarEquipe10J1);
                    editPlacarEquipe10J2.setText(placarEquipe10J2);
                    editPlacarEquipe11J1.setText(placarEquipe11J1);
                    editPlacarEquipe11J2.setText(placarEquipe11J2);
                    editPlacarEquipe12J1.setText(placarEquipe12J1);
                    editPlacarEquipe12J2.setText(placarEquipe12J2);

                    trocaTela = true;

                    if (!editPlacarEquipe3J1.getText().toString().equals("") && !editPlacarEquipe2J1.getText().toString().equals("")) {
                        editPlacarEquipe3J1.setEnabled(false);
                        editPlacarEquipe2J1.setEnabled(false);
                    }
                    if (!editPlacarEquipe6J1.getText().toString().equals("") && !editPlacarEquipe5J1.getText().toString().equals("")) {
                        editPlacarEquipe6J1.setEnabled(false);
                        editPlacarEquipe5J1.setEnabled(false);
                    }
                    if (!editPlacarEquipe9J1.getText().toString().equals("") && !editPlacarEquipe8J1.getText().toString().equals("")) {
                        editPlacarEquipe9J1.setEnabled(false);
                        editPlacarEquipe8J1.setEnabled(false);
                    }
                    if (!editPlacarEquipe12J1.getText().toString().equals("") && !editPlacarEquipe11J1.getText().toString().equals("")) {
                        editPlacarEquipe12J1.setEnabled(false);
                        editPlacarEquipe11J1.setEnabled(false);
                    }
                    if (!editPlacarEquipe1J1.getText().toString().equals("") && !editPlacarEquipe3J2.getText().toString().equals("")) {
                        editPlacarEquipe1J1.setEnabled(false);
                        editPlacarEquipe3J2.setEnabled(false);
                    }
                    if (!editPlacarEquipe4J1.getText().toString().equals("") && !editPlacarEquipe6J2.getText().toString().equals("")) {
                        editPlacarEquipe4J1.setEnabled(false);
                        editPlacarEquipe6J2.setEnabled(false);
                    }
                    if (!editPlacarEquipe7J1.getText().toString().equals("") && !editPlacarEquipe9J2.getText().toString().equals("")) {
                        editPlacarEquipe7J1.setEnabled(false);
                        editPlacarEquipe9J2.setEnabled(false);
                    }
                    if (!editPlacarEquipe10J1.getText().toString().equals("") && !editPlacarEquipe12J2.getText().toString().equals("")) {
                        editPlacarEquipe10J1.setEnabled(false);
                        editPlacarEquipe12J2.setEnabled(false);
                    }
                    if (!editPlacarEquipe2J2.getText().toString().equals("") && !editPlacarEquipe1J2.getText().toString().equals("")) {
                        editPlacarEquipe2J2.setEnabled(false);
                        editPlacarEquipe1J2.setEnabled(false);
                    }
                    if (!editPlacarEquipe5J2.getText().toString().equals("") && !editPlacarEquipe4J2.getText().toString().equals("")) {
                        editPlacarEquipe5J2.setEnabled(false);
                        editPlacarEquipe4J2.setEnabled(false);
                    }
                    if (!editPlacarEquipe8J2.getText().toString().equals("") && !editPlacarEquipe7J2.getText().toString().equals("")) {
                        editPlacarEquipe8J2.setEnabled(false);
                        editPlacarEquipe7J2.setEnabled(false);
                    }
                    if (!editPlacarEquipe11J2.getText().toString().equals("") && !editPlacarEquipe10J2.getText().toString().equals("")) {
                        editPlacarEquipe11J2.setEnabled(false);
                        editPlacarEquipe10J2.setEnabled(false);
                    }

                    if (finalizouQuartas) {
                        btnSalvar.setEnabled(false);
                        btnEditar.setEnabled(false);
                        btnFinalizarPrimeiraFase.setEnabled(false);
                    }
                }
            } else {
                showFancyAlertDialog();
            }
        }
        if (qtdEquipes > Torneio.TORNEIO_DOZE_EQUIPES) {
            if (grupo4ID >= 1) {
                equipe13 = equipeController.getEquipeByID(equipe13);
                equipe14 = equipeController.getEquipeByID(equipe14);
                equipe15 = equipeController.getEquipeByID(equipe15);
                equipe16 = equipeController.getEquipeByID(equipe16);

                if (qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
                    grupo1.setEquipe1(equipe1);
                    grupo1.setEquipe2(equipe2);
                    grupo1.setEquipe3(equipe3);
                    grupo1.setEquipe4(equipe4);
                    grupo2.setEquipe1(equipe5);
                    grupo2.setEquipe2(equipe6);
                    grupo2.setEquipe3(equipe7);
                    grupo2.setEquipe4(equipe8);
                    grupo3.setEquipe1(equipe9);
                    grupo3.setEquipe2(equipe10);
                    grupo3.setEquipe3(equipe11);
                    grupo3.setEquipe4(equipe12);
                    grupo4.setEquipe1(equipe13);
                    grupo4.setEquipe2(equipe14);
                    grupo4.setEquipe3(equipe15);
                    grupo4.setEquipe4(equipe16);

                    txtEquipe1J1.setText(grupo1.getEquipe1().getNome());
                    txtEquipe1J2.setText(grupo1.getEquipe1().getNome());
                    txtEquipe1J3.setText(grupo1.getEquipe1().getNome());
                    txtEquipe2J1.setText(grupo1.getEquipe2().getNome());
                    txtEquipe2J2.setText(grupo1.getEquipe2().getNome());
                    txtEquipe2J3.setText(grupo1.getEquipe2().getNome());
                    txtEquipe3J1.setText(grupo1.getEquipe3().getNome());
                    txtEquipe3J2.setText(grupo1.getEquipe3().getNome());
                    txtEquipe3J3.setText(grupo1.getEquipe3().getNome());
                    txtEquipe4J1.setText(grupo1.getEquipe4().getNome());
                    txtEquipe4J2.setText(grupo1.getEquipe4().getNome());
                    txtEquipe4J3.setText(grupo1.getEquipe4().getNome());
                    txtEquipe5J1.setText(grupo2.getEquipe1().getNome());
                    txtEquipe5J2.setText(grupo2.getEquipe1().getNome());
                    txtEquipe5J3.setText(grupo2.getEquipe1().getNome());
                    txtEquipe6J1.setText(grupo2.getEquipe2().getNome());
                    txtEquipe6J2.setText(grupo2.getEquipe2().getNome());
                    txtEquipe6J3.setText(grupo2.getEquipe2().getNome());
                    txtEquipe7J1.setText(grupo2.getEquipe3().getNome());
                    txtEquipe7J2.setText(grupo2.getEquipe3().getNome());
                    txtEquipe7J3.setText(grupo2.getEquipe3().getNome());
                    txtEquipe8J1.setText(grupo2.getEquipe4().getNome());
                    txtEquipe8J2.setText(grupo2.getEquipe4().getNome());
                    txtEquipe8J3.setText(grupo2.getEquipe4().getNome());
                    txtEquipe9J1.setText(grupo3.getEquipe1().getNome());
                    txtEquipe9J2.setText(grupo3.getEquipe1().getNome());
                    txtEquipe9J3.setText(grupo3.getEquipe1().getNome());
                    txtEquipe10J1.setText(grupo3.getEquipe2().getNome());
                    txtEquipe10J2.setText(grupo3.getEquipe2().getNome());
                    txtEquipe10J3.setText(grupo3.getEquipe2().getNome());
                    txtEquipe11J1.setText(grupo3.getEquipe3().getNome());
                    txtEquipe11J2.setText(grupo3.getEquipe3().getNome());
                    txtEquipe11J3.setText(grupo3.getEquipe3().getNome());
                    txtEquipe12J1.setText(grupo3.getEquipe4().getNome());
                    txtEquipe12J2.setText(grupo3.getEquipe4().getNome());
                    txtEquipe12J3.setText(grupo3.getEquipe4().getNome());
                    txtEquipe13J1.setText(grupo4.getEquipe1().getNome());
                    txtEquipe13J2.setText(grupo4.getEquipe1().getNome());
                    txtEquipe13J3.setText(grupo4.getEquipe1().getNome());
                    txtEquipe14J1.setText(grupo4.getEquipe2().getNome());
                    txtEquipe14J2.setText(grupo4.getEquipe2().getNome());
                    txtEquipe14J3.setText(grupo4.getEquipe2().getNome());
                    txtEquipe15J1.setText(grupo4.getEquipe3().getNome());
                    txtEquipe15J2.setText(grupo4.getEquipe3().getNome());
                    txtEquipe15J3.setText(grupo4.getEquipe3().getNome());
                    txtEquipe16J1.setText(grupo4.getEquipe4().getNome());
                    txtEquipe16J2.setText(grupo4.getEquipe4().getNome());
                    txtEquipe16J3.setText(grupo4.getEquipe4().getNome());

                    editPlacarEquipe1J1.setText(placarEquipe1J1);
                    editPlacarEquipe1J2.setText(placarEquipe1J2);
                    editPlacarEquipe1J3.setText(placarEquipe1J3);
                    editPlacarEquipe2J1.setText(placarEquipe2J1);
                    editPlacarEquipe2J2.setText(placarEquipe2J2);
                    editPlacarEquipe2J3.setText(placarEquipe2J3);
                    editPlacarEquipe3J1.setText(placarEquipe3J1);
                    editPlacarEquipe3J2.setText(placarEquipe3J2);
                    editPlacarEquipe3J3.setText(placarEquipe3J3);
                    editPlacarEquipe4J1.setText(placarEquipe4J1);
                    editPlacarEquipe4J2.setText(placarEquipe4J2);
                    editPlacarEquipe4J3.setText(placarEquipe4J3);
                    editPlacarEquipe5J1.setText(placarEquipe5J1);
                    editPlacarEquipe5J2.setText(placarEquipe5J2);
                    editPlacarEquipe5J3.setText(placarEquipe5J3);
                    editPlacarEquipe6J1.setText(placarEquipe6J1);
                    editPlacarEquipe6J2.setText(placarEquipe6J2);
                    editPlacarEquipe6J3.setText(placarEquipe6J3);
                    editPlacarEquipe7J1.setText(placarEquipe7J1);
                    editPlacarEquipe7J2.setText(placarEquipe7J2);
                    editPlacarEquipe7J3.setText(placarEquipe7J3);
                    editPlacarEquipe8J1.setText(placarEquipe8J1);
                    editPlacarEquipe8J2.setText(placarEquipe8J2);
                    editPlacarEquipe8J3.setText(placarEquipe8J3);
                    editPlacarEquipe9J1.setText(placarEquipe9J1);
                    editPlacarEquipe9J2.setText(placarEquipe9J2);
                    editPlacarEquipe9J3.setText(placarEquipe9J3);
                    editPlacarEquipe10J1.setText(placarEquipe10J1);
                    editPlacarEquipe10J2.setText(placarEquipe10J2);
                    editPlacarEquipe10J3.setText(placarEquipe10J3);
                    editPlacarEquipe11J1.setText(placarEquipe11J1);
                    editPlacarEquipe11J2.setText(placarEquipe11J2);
                    editPlacarEquipe11J3.setText(placarEquipe11J3);
                    editPlacarEquipe12J1.setText(placarEquipe12J1);
                    editPlacarEquipe12J2.setText(placarEquipe12J2);
                    editPlacarEquipe12J3.setText(placarEquipe12J3);
                    editPlacarEquipe13J1.setText(placarEquipe13J1);
                    editPlacarEquipe13J2.setText(placarEquipe13J2);
                    editPlacarEquipe13J3.setText(placarEquipe13J3);
                    editPlacarEquipe14J1.setText(placarEquipe14J1);
                    editPlacarEquipe14J2.setText(placarEquipe14J2);
                    editPlacarEquipe14J3.setText(placarEquipe14J3);
                    editPlacarEquipe15J1.setText(placarEquipe15J1);
                    editPlacarEquipe15J2.setText(placarEquipe15J2);
                    editPlacarEquipe15J3.setText(placarEquipe15J3);
                    editPlacarEquipe16J1.setText(placarEquipe16J1);
                    editPlacarEquipe16J2.setText(placarEquipe16J2);
                    editPlacarEquipe16J3.setText(placarEquipe16J3);

                    trocaTela = true;

                    if (!editPlacarEquipe1J1.getText().toString().equals("") && !editPlacarEquipe2J1.getText().toString().equals("")) {
                        editPlacarEquipe1J1.setEnabled(false);
                        editPlacarEquipe2J1.setEnabled(false);
                    }
                    if (!editPlacarEquipe5J1.getText().toString().equals("") && !editPlacarEquipe6J1.getText().toString().equals("")) {
                        editPlacarEquipe5J1.setEnabled(false);
                        editPlacarEquipe6J1.setEnabled(false);
                    }
                    if (!editPlacarEquipe9J1.getText().toString().equals("") && !editPlacarEquipe10J1.getText().toString().equals("")) {
                        editPlacarEquipe9J1.setEnabled(false);
                        editPlacarEquipe10J1.setEnabled(false);
                    }
                    if (!editPlacarEquipe13J1.getText().toString().equals("") && !editPlacarEquipe14J1.getText().toString().equals("")) {
                        editPlacarEquipe13J1.setEnabled(false);
                        editPlacarEquipe14J1.setEnabled(false);
                    }
                    if (!editPlacarEquipe3J1.getText().toString().equals("") && !editPlacarEquipe4J1.getText().toString().equals("")) {
                        editPlacarEquipe3J1.setEnabled(false);
                        editPlacarEquipe4J1.setEnabled(false);
                    }
                    if (!editPlacarEquipe7J1.getText().toString().equals("") && !editPlacarEquipe8J1.getText().toString().equals("")) {
                        editPlacarEquipe7J1.setEnabled(false);
                        editPlacarEquipe8J1.setEnabled(false);
                    }
                    if (!editPlacarEquipe11J1.getText().toString().equals("") && !editPlacarEquipe12J1.getText().toString().equals("")) {
                        editPlacarEquipe11J1.setEnabled(false);
                        editPlacarEquipe12J1.setEnabled(false);
                    }
                    if (!editPlacarEquipe15J1.getText().toString().equals("") && !editPlacarEquipe16J1.getText().toString().equals("")) {
                        editPlacarEquipe15J1.setEnabled(false);
                        editPlacarEquipe16J1.setEnabled(false);
                    }
                    if (!editPlacarEquipe4J2.getText().toString().equals("") && !editPlacarEquipe1J2.getText().toString().equals("")) {
                        editPlacarEquipe4J2.setEnabled(false);
                        editPlacarEquipe1J2.setEnabled(false);
                    }
                    if (!editPlacarEquipe8J2.getText().toString().equals("") && !editPlacarEquipe5J2.getText().toString().equals("")) {
                        editPlacarEquipe8J2.setEnabled(false);
                        editPlacarEquipe5J2.setEnabled(false);
                    }
                    if (!editPlacarEquipe12J2.getText().toString().equals("") && !editPlacarEquipe9J2.getText().toString().equals("")) {
                        editPlacarEquipe12J2.setEnabled(false);
                        editPlacarEquipe9J2.setEnabled(false);
                    }
                    if (!editPlacarEquipe16J2.getText().toString().equals("") && !editPlacarEquipe13J2.getText().toString().equals("")) {
                        editPlacarEquipe16J2.setEnabled(false);
                        editPlacarEquipe13J2.setEnabled(false);
                    }
                    if (!editPlacarEquipe2J2.getText().toString().equals("") && !editPlacarEquipe3J2.getText().toString().equals("")) {
                        editPlacarEquipe2J2.setEnabled(false);
                        editPlacarEquipe3J2.setEnabled(false);
                    }
                    if (!editPlacarEquipe6J2.getText().toString().equals("") && !editPlacarEquipe7J2.getText().toString().equals("")) {
                        editPlacarEquipe6J2.setEnabled(false);
                        editPlacarEquipe7J2.setEnabled(false);
                    }
                    if (!editPlacarEquipe10J2.getText().toString().equals("") && !editPlacarEquipe11J2.getText().toString().equals("")) {
                        editPlacarEquipe10J2.setEnabled(false);
                        editPlacarEquipe11J2.setEnabled(false);
                    }
                    if (!editPlacarEquipe14J2.getText().toString().equals("") && !editPlacarEquipe15J2.getText().toString().equals("")) {
                        editPlacarEquipe14J2.setEnabled(false);
                        editPlacarEquipe15J2.setEnabled(false);
                    }
                    if (!editPlacarEquipe1J3.getText().toString().equals("") && !editPlacarEquipe3J3.getText().toString().equals("")) {
                        editPlacarEquipe1J3.setEnabled(false);
                        editPlacarEquipe3J3.setEnabled(false);
                    }
                    if (!editPlacarEquipe5J3.getText().toString().equals("") && !editPlacarEquipe7J3.getText().toString().equals("")) {
                        editPlacarEquipe5J3.setEnabled(false);
                        editPlacarEquipe7J3.setEnabled(false);
                    }
                    if (!editPlacarEquipe9J3.getText().toString().equals("") && !editPlacarEquipe11J3.getText().toString().equals("")) {
                        editPlacarEquipe9J3.setEnabled(false);
                        editPlacarEquipe11J3.setEnabled(false);
                    }
                    if (!editPlacarEquipe13J3.getText().toString().equals("") && !editPlacarEquipe15J3.getText().toString().equals("")) {
                        editPlacarEquipe13J3.setEnabled(false);
                        editPlacarEquipe15J3.setEnabled(false);
                    }
                    if (!editPlacarEquipe2J3.getText().toString().equals("") && !editPlacarEquipe4J3.getText().toString().equals("")) {
                        editPlacarEquipe2J3.setEnabled(false);
                        editPlacarEquipe4J3.setEnabled(false);
                    }
                    if (!editPlacarEquipe6J3.getText().toString().equals("") && !editPlacarEquipe8J3.getText().toString().equals("")) {
                        editPlacarEquipe6J3.setEnabled(false);
                        editPlacarEquipe8J3.setEnabled(false);
                    }
                    if (!editPlacarEquipe10J3.getText().toString().equals("") && !editPlacarEquipe12J3.getText().toString().equals("")) {
                        editPlacarEquipe10J3.setEnabled(false);
                        editPlacarEquipe12J3.setEnabled(false);
                    }
                    if (!editPlacarEquipe14J3.getText().toString().equals("") && !editPlacarEquipe16J3.getText().toString().equals("")) {
                        editPlacarEquipe14J3.setEnabled(false);
                        editPlacarEquipe16J3.setEnabled(false);
                    }
                } else {
                    showFancyAlertDialog();
                }
            }
        }
    }

    private void showFancyAlertDialog() {
        new FancyAlertDialog.Builder(JogosPrimeiraFase.this)
                .setTitle("Atenção")
                .setBackgroundColor(Color.parseColor("#303F9F"))  //Don't pass R.color.colorvalue
                .setMessage("Não foi possível recuperar os dados das equipes!")
                .setNegativeBtnText("Retornar")
                .setNegativeBtnBackground(Color.parseColor("#FFA9A7A8"))  //Don't pass R.color.colorvalue
                .setAnimation(Animation.POP)
                .isCancellable(true)
                .setIcon(R.mipmap.ic_launcher_round, Icon.Visible)
                .OnNegativeClicked(() -> {
                    AppUtil.goNextScreen(JogosPrimeiraFase.this, Dashboard.class, false);
                    finish();
                })
                .build();
    }

    private boolean salvarJogo(Equipe equipe1, Equipe equipe2, EditText placarEquipe1, EditText placarEquipe2, int equipe1ID, int equipe2ID, int grupo1ID, int grupo2ID) {
        placarA = Integer.parseInt(placarEquipe1.getText().toString());
        placarB = Integer.parseInt(placarEquipe2.getText().toString());
        if (placarA > placarB) {
            equipe1.setId(equipe1ID);
            equipe1.setGrupoID(grupo1ID);
            equipe1.setJogos(equipe1.getJogos() + 1);
            equipe1.setPontos(equipe1.getPontos() + 3);
            equipe1.setVitorias(equipe1.getVitorias() + 1);
            equipe1.setGolsPro(equipe1.getGolsPro() + placarA);
            equipe1.setGolsContra(equipe1.getGolsContra() + placarB);
            if (!equipeController.alterar(equipe1)) {
                // falha ao salvar o obj  no DB
                return false;
            }
            equipe2.setId(equipe2ID);
            equipe2.setGrupoID(grupo2ID);
            equipe2.setJogos(equipe2.getJogos() + 1);
            equipe2.setDerrotas(equipe2.getDerrotas() + 1);
            equipe2.setGolsPro(equipe2.getGolsPro() + placarB);
            equipe2.setGolsContra(equipe2.getGolsContra() + placarA);
            if (!equipeController.alterar(equipe2)) {
                return false;
            }

        } else if (placarA < placarB) {
            equipe2.setId(equipe2ID);
            equipe2.setGrupoID(grupo2ID);
            equipe2.setJogos(equipe2.getJogos() + 1);
            equipe2.setPontos(equipe2.getPontos() + 3);
            equipe2.setVitorias(equipe2.getVitorias() + 1);
            equipe2.setGolsPro(equipe2.getGolsPro() + placarB);
            equipe2.setGolsContra(equipe2.getGolsContra() + placarA);
            if (!equipeController.alterar(equipe2)) {
                // falha ao salvar o obj  no DB
                return false;
            }
            equipe1.setId(equipe1ID);
            equipe1.setGrupoID(grupo1ID);
            equipe1.setJogos(equipe1.getJogos() + 1);
            equipe1.setDerrotas(equipe1.getDerrotas() + 1);
            equipe1.setGolsPro(equipe1.getGolsPro() + placarA);
            equipe1.setGolsContra(equipe1.getGolsContra() + placarB);
            if (!equipeController.alterar(equipe1)) {
                return false;
            }

        } else {
            equipe1.setId(equipe1ID);
            equipe1.setGrupoID(grupo1ID);
            equipe1.setJogos(equipe1.getJogos() + 1);
            equipe1.setPontos(equipe1.getPontos() + 1);
            equipe1.setEmpates(equipe1.getEmpates() + 1);
            equipe1.setGolsPro(equipe1.getGolsPro() + placarA);
            equipe1.setGolsContra(equipe1.getGolsContra() + placarB);
            if (!equipeController.alterar(equipe1)) {
                // falha ao salvar o obj  no DB
                return false;
            }
            equipe2.setId(equipe2ID);
            equipe2.setGrupoID(grupo2ID);
            equipe2.setJogos(equipe2.getJogos() + 1);
            equipe2.setPontos(equipe2.getPontos() + 1);
            equipe2.setEmpates(equipe2.getEmpates() + 1);
            equipe2.setGolsPro(equipe2.getGolsPro() + placarB);
            equipe2.setGolsContra(equipe2.getGolsContra() + placarA);
            if (!equipeController.alterar(equipe2)) {
                return false;
            }
        }

        return true;
    }

    private boolean validarFormularioJogo(EditText placarEquipe1, EditText placarEquipe2) {
        boolean retorno = true;
        if (TextUtils.isEmpty(placarEquipe1.getText().toString())) {
            retorno = false;
        } else if (Integer.parseInt(placarEquipe1.getText().toString()) < 0) {
            placarEquipe1.setError("*");
            placarEquipe1.requestFocus();
            trocaTela = false;
            retorno = false;
        }
        if (TextUtils.isEmpty(placarEquipe2.getText().toString())) {
            retorno = false;
        } else if (Integer.parseInt(placarEquipe2.getText().toString()) < 0) {
            placarEquipe2.setError("*");
            placarEquipe2.requestFocus();
            trocaTela = false;
            retorno = false;
        }
        return retorno;
    }

    public void voltar(View view) {
        AppUtil.goNextScreen(JogosPrimeiraFase.this, Dashboard.class, true);
        finish();
    }

    @Override
    public void onBackPressed() {
        AppUtil.goNextScreen(JogosPrimeiraFase.this, Dashboard.class, true);
        finish();
    }

    public void editarResultados(View view) {
        if (finalizouPrimeiraFase) {
            finalizouPrimeiraFase = false;
            btnSalvar.setVisibility(View.VISIBLE);
            btnFinalizarPrimeiraFase.setVisibility(View.VISIBLE);
        }
        btnEditar.setEnabled(false);

        if (qtdEquipes == Torneio.TORNEIO_QUATRO_EQUIPES) {
            if (!editPlacarEquipe1J1.getText().toString().equals("")) {
                editPlacarEquipe1J1.setEnabled(true);
                editPlacarEquipe2J1.setEnabled(true);
            }
            if (!editPlacarEquipe3J1.getText().toString().equals("")) {
                editPlacarEquipe3J1.setEnabled(true);
                editPlacarEquipe4J1.setEnabled(true);
            }
            if (!editPlacarEquipe4J2.getText().toString().equals("")) {
                editPlacarEquipe4J2.setEnabled(true);
                editPlacarEquipe1J2.setEnabled(true);
            }
            if (!editPlacarEquipe2J2.getText().toString().equals("")) {
                editPlacarEquipe2J2.setEnabled(true);
                editPlacarEquipe3J2.setEnabled(true);
            }
            if (!editPlacarEquipe1J3.getText().toString().equals("")) {
                editPlacarEquipe1J3.setEnabled(true);
                editPlacarEquipe3J3.setEnabled(true);
            }
            if (!editPlacarEquipe2J3.getText().toString().equals("")) {
                editPlacarEquipe2J3.setEnabled(true);
                editPlacarEquipe4J3.setEnabled(true);
            }
        } else if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
            if (!editPlacarEquipe3J1.getText().toString().equals("")) {
                editPlacarEquipe3J1.setEnabled(true);
                editPlacarEquipe2J1.setEnabled(true);
            }
            if (!editPlacarEquipe6J1.getText().toString().equals("")) {
                editPlacarEquipe6J1.setEnabled(true);
                editPlacarEquipe5J1.setEnabled(true);
            }
            if (!editPlacarEquipe9J1.getText().toString().equals("")) {
                editPlacarEquipe9J1.setEnabled(true);
                editPlacarEquipe8J1.setEnabled(true);
            }
            if (!editPlacarEquipe12J1.getText().toString().equals("")) {
                editPlacarEquipe12J1.setEnabled(true);
                editPlacarEquipe11J1.setEnabled(true);
            }
            if (!editPlacarEquipe1J1.getText().toString().equals("")) {
                editPlacarEquipe1J1.setEnabled(true);
                editPlacarEquipe3J2.setEnabled(true);
            }
            if (!editPlacarEquipe4J1.getText().toString().equals("")) {
                editPlacarEquipe4J1.setEnabled(true);
                editPlacarEquipe6J2.setEnabled(true);
            }
            if (!editPlacarEquipe7J1.getText().toString().equals("")) {
                editPlacarEquipe7J1.setEnabled(true);
                editPlacarEquipe9J2.setEnabled(true);
            }
            if (!editPlacarEquipe10J1.getText().toString().equals("")) {
                editPlacarEquipe10J1.setEnabled(true);
                editPlacarEquipe12J2.setEnabled(true);
            }
            if (!editPlacarEquipe2J2.getText().toString().equals("")) {
                editPlacarEquipe2J2.setEnabled(true);
                editPlacarEquipe1J2.setEnabled(true);
            }
            if (!editPlacarEquipe5J2.getText().toString().equals("")) {
                editPlacarEquipe5J2.setEnabled(true);
                editPlacarEquipe4J2.setEnabled(true);
            }
            if (!editPlacarEquipe8J2.getText().toString().equals("")) {
                editPlacarEquipe8J2.setEnabled(true);
                editPlacarEquipe7J2.setEnabled(true);
            }
            if (!editPlacarEquipe11J2.getText().toString().equals("")) {
                editPlacarEquipe11J2.setEnabled(true);
                editPlacarEquipe10J2.setEnabled(true);
            }
        } else if (qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
            if (!editPlacarEquipe1J1.getText().toString().equals("")) {
                editPlacarEquipe1J1.setEnabled(true);
                editPlacarEquipe2J1.setEnabled(true);
            }
            if (!editPlacarEquipe5J1.getText().toString().equals("")) {
                editPlacarEquipe5J1.setEnabled(true);
                editPlacarEquipe6J1.setEnabled(true);
            }
            if (!editPlacarEquipe9J1.getText().toString().equals("")) {
                editPlacarEquipe9J1.setEnabled(true);
                editPlacarEquipe10J1.setEnabled(true);
            }
            if (!editPlacarEquipe13J1.getText().toString().equals("")) {
                editPlacarEquipe13J1.setEnabled(true);
                editPlacarEquipe14J1.setEnabled(true);
            }
            if (!editPlacarEquipe3J1.getText().toString().equals("")) {
                editPlacarEquipe3J1.setEnabled(true);
                editPlacarEquipe4J1.setEnabled(true);
            }
            if (!editPlacarEquipe7J1.getText().toString().equals("")) {
                editPlacarEquipe7J1.setEnabled(true);
                editPlacarEquipe8J1.setEnabled(true);
            }
            if (!editPlacarEquipe11J1.getText().toString().equals("")) {
                editPlacarEquipe11J1.setEnabled(true);
                editPlacarEquipe12J1.setEnabled(true);
            }
            if (!editPlacarEquipe15J1.getText().toString().equals("")) {
                editPlacarEquipe15J1.setEnabled(true);
                editPlacarEquipe16J1.setEnabled(true);
            }
            if (!editPlacarEquipe4J2.getText().toString().equals("")) {
                editPlacarEquipe4J2.setEnabled(true);
                editPlacarEquipe1J2.setEnabled(true);
            }
            if (!editPlacarEquipe8J2.getText().toString().equals("")) {
                editPlacarEquipe8J2.setEnabled(true);
                editPlacarEquipe5J2.setEnabled(true);
            }
            if (!editPlacarEquipe12J2.getText().toString().equals("")) {
                editPlacarEquipe12J2.setEnabled(true);
                editPlacarEquipe9J2.setEnabled(true);
            }
            if (!editPlacarEquipe16J2.getText().toString().equals("")) {
                editPlacarEquipe16J2.setEnabled(true);
                editPlacarEquipe13J2.setEnabled(true);
            }
            if (!editPlacarEquipe2J2.getText().toString().equals("")) {
                editPlacarEquipe2J2.setEnabled(true);
                editPlacarEquipe3J2.setEnabled(true);
            }
            if (!editPlacarEquipe6J2.getText().toString().equals("")) {
                editPlacarEquipe6J2.setEnabled(true);
                editPlacarEquipe7J2.setEnabled(true);
            }
            if (!editPlacarEquipe10J2.getText().toString().equals("")) {
                editPlacarEquipe10J2.setEnabled(true);
                editPlacarEquipe11J2.setEnabled(true);
            }
            if (!editPlacarEquipe14J2.getText().toString().equals("")) {
                editPlacarEquipe14J2.setEnabled(true);
                editPlacarEquipe15J2.setEnabled(true);
            }
            if (!editPlacarEquipe1J3.getText().toString().equals("")) {
                editPlacarEquipe1J3.setEnabled(true);
                editPlacarEquipe3J3.setEnabled(true);
            }
            if (!editPlacarEquipe5J3.getText().toString().equals("")) {
                editPlacarEquipe5J3.setEnabled(true);
                editPlacarEquipe7J3.setEnabled(true);
            }
            if (!editPlacarEquipe9J3.getText().toString().equals("")) {
                editPlacarEquipe9J3.setEnabled(true);
                editPlacarEquipe11J3.setEnabled(true);
            }
            if (!editPlacarEquipe13J3.getText().toString().equals("")) {
                editPlacarEquipe13J3.setEnabled(true);
                editPlacarEquipe15J3.setEnabled(true);
            }
            if (!editPlacarEquipe2J3.getText().toString().equals("")) {
                editPlacarEquipe2J3.setEnabled(true);
                editPlacarEquipe4J3.setEnabled(true);
            }
            if (!editPlacarEquipe6J3.getText().toString().equals("")) {
                editPlacarEquipe6J3.setEnabled(true);
                editPlacarEquipe8J3.setEnabled(true);
            }
            if (!editPlacarEquipe10J3.getText().toString().equals("")) {
                editPlacarEquipe10J3.setEnabled(true);
                editPlacarEquipe12J3.setEnabled(true);
            }
            if (!editPlacarEquipe14J3.getText().toString().equals("")) {
                editPlacarEquipe14J3.setEnabled(true);
                editPlacarEquipe16J3.setEnabled(true);
            }
        }
    }

    private boolean salvarResultados() {
        equipe1.setId(equipe1ID);
        equipe2.setId(equipe2ID);
        equipe3.setId(equipe3ID);
        equipe4.setId(equipe4ID);
        equipe1.setJogos(0);
        equipe2.setJogos(0);
        equipe3.setJogos(0);
        equipe4.setJogos(0);
        equipe1.setPontos(0);
        equipe2.setPontos(0);
        equipe3.setPontos(0);
        equipe4.setPontos(0);
        equipe1.setVitorias(0);
        equipe2.setVitorias(0);
        equipe3.setVitorias(0);
        equipe4.setVitorias(0);
        equipe1.setEmpates(0);
        equipe2.setEmpates(0);
        equipe3.setEmpates(0);
        equipe4.setEmpates(0);
        equipe1.setDerrotas(0);
        equipe2.setDerrotas(0);
        equipe3.setDerrotas(0);
        equipe4.setDerrotas(0);
        equipe1.setGolsPro(0);
        equipe2.setGolsPro(0);
        equipe3.setGolsPro(0);
        equipe4.setGolsPro(0);
        equipe1.setGolsContra(0);
        equipe2.setGolsContra(0);
        equipe3.setGolsContra(0);
        equipe4.setGolsContra(0);
        equipeController.alterar(equipe1);
        equipeController.alterar(equipe2);
        equipeController.alterar(equipe3);
        equipeController.alterar(equipe4);

        if (qtdEquipes == Torneio.TORNEIO_QUATRO_EQUIPES || qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
            equipe1.setGrupoID(grupo1ID);
            equipe2.setGrupoID(grupo1ID);
            equipe3.setGrupoID(grupo1ID);
            equipe4.setGrupoID(grupo1ID);

            editPlacarEquipe1J1.setEnabled(true);
            editPlacarEquipe1J2.setEnabled(true);
            editPlacarEquipe1J3.setEnabled(true);
            editPlacarEquipe2J1.setEnabled(true);
            editPlacarEquipe2J2.setEnabled(true);
            editPlacarEquipe2J3.setEnabled(true);
            editPlacarEquipe3J1.setEnabled(true);
            editPlacarEquipe3J2.setEnabled(true);
            editPlacarEquipe3J3.setEnabled(true);
            editPlacarEquipe4J1.setEnabled(true);
            editPlacarEquipe4J2.setEnabled(true);
            editPlacarEquipe4J3.setEnabled(true);
        }
        if (qtdEquipes == Torneio.TORNEIO_QUATRO_EQUIPES) {
            if (editPlacarEquipe1J1.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe1J1, editPlacarEquipe2J1)) {
                    salvarJogo(equipe1, equipe2, editPlacarEquipe1J1, editPlacarEquipe2J1, equipe1ID, equipe2ID, grupo1ID, grupo1ID);
                }
            }
            if (editPlacarEquipe3J1.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe3J1, editPlacarEquipe4J1)) {
                    salvarJogo(equipe3, equipe4, editPlacarEquipe3J1, editPlacarEquipe4J1, equipe3ID, equipe4ID, grupo1ID, grupo1ID);
                }
            }
            if (editPlacarEquipe4J2.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe4J2, editPlacarEquipe1J2)) {
                    salvarJogo(equipe4, equipe1, editPlacarEquipe4J2, editPlacarEquipe1J2, equipe4ID, equipe1ID, grupo1ID, grupo1ID);
                }
            }
            if (editPlacarEquipe2J2.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe2J2, editPlacarEquipe3J2)) {
                    salvarJogo(equipe2, equipe3, editPlacarEquipe2J2, editPlacarEquipe3J2, equipe2ID, equipe3ID, grupo1ID, grupo1ID);
                }
            }
            if (editPlacarEquipe1J3.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe1J3, editPlacarEquipe3J3)) {
                    salvarJogo(equipe1, equipe3, editPlacarEquipe1J3, editPlacarEquipe3J3, equipe1ID, equipe3ID, grupo1ID, grupo1ID);
                }
            }
            if (editPlacarEquipe2J3.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe2J3, editPlacarEquipe4J3)) {
                    salvarJogo(equipe2, equipe4, editPlacarEquipe2J3, editPlacarEquipe4J3, equipe2ID, equipe4ID, grupo1ID, grupo1ID);
                }
            }

            if (trocaTela) {
                salvarSharedPreferences();
                conseguiu = true;
                Toast.makeText(this, "Dados Salvos com Sucesso...", Toast.LENGTH_SHORT).show();

                AppUtil.goNextScreen(JogosPrimeiraFase.this, Dashboard.class, true);
                finish();
            }
        }
        if (qtdEquipes > Torneio.TORNEIO_QUATRO_EQUIPES) {
            equipe5.setId(equipe5ID);
            equipe6.setId(equipe6ID);
            equipe7.setId(equipe7ID);
            equipe8.setId(equipe8ID);
            equipe9.setId(equipe9ID);
            equipe10.setId(equipe10ID);
            equipe11.setId(equipe11ID);
            equipe12.setId(equipe12ID);
            equipe5.setJogos(0);
            equipe6.setJogos(0);
            equipe7.setJogos(0);
            equipe8.setJogos(0);
            equipe9.setJogos(0);
            equipe10.setJogos(0);
            equipe11.setJogos(0);
            equipe12.setJogos(0);
            equipe5.setPontos(0);
            equipe6.setPontos(0);
            equipe7.setPontos(0);
            equipe8.setPontos(0);
            equipe9.setPontos(0);
            equipe10.setPontos(0);
            equipe11.setPontos(0);
            equipe12.setPontos(0);
            equipe5.setVitorias(0);
            equipe6.setVitorias(0);
            equipe7.setVitorias(0);
            equipe8.setVitorias(0);
            equipe9.setVitorias(0);
            equipe10.setVitorias(0);
            equipe11.setVitorias(0);
            equipe12.setVitorias(0);
            equipe5.setEmpates(0);
            equipe6.setEmpates(0);
            equipe7.setEmpates(0);
            equipe8.setEmpates(0);
            equipe9.setEmpates(0);
            equipe10.setEmpates(0);
            equipe11.setEmpates(0);
            equipe12.setEmpates(0);
            equipe5.setDerrotas(0);
            equipe6.setDerrotas(0);
            equipe7.setDerrotas(0);
            equipe8.setDerrotas(0);
            equipe9.setDerrotas(0);
            equipe10.setDerrotas(0);
            equipe11.setDerrotas(0);
            equipe12.setDerrotas(0);
            equipe5.setGolsPro(0);
            equipe6.setGolsPro(0);
            equipe7.setGolsPro(0);
            equipe8.setGolsPro(0);
            equipe9.setGolsPro(0);
            equipe10.setGolsPro(0);
            equipe11.setGolsPro(0);
            equipe12.setGolsPro(0);
            equipe5.setGolsContra(0);
            equipe6.setGolsContra(0);
            equipe7.setGolsContra(0);
            equipe8.setGolsContra(0);
            equipe9.setGolsContra(0);
            equipe10.setGolsContra(0);
            equipe11.setGolsContra(0);
            equipe12.setGolsContra(0);
            equipeController.alterar(equipe5);
            equipeController.alterar(equipe6);
            equipeController.alterar(equipe7);
            equipeController.alterar(equipe8);
            equipeController.alterar(equipe9);
            equipeController.alterar(equipe10);
            equipeController.alterar(equipe11);
            equipeController.alterar(equipe12);

            if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
                equipe1.setGrupoID(grupo1ID);
                equipe2.setGrupoID(grupo1ID);
                equipe3.setGrupoID(grupo1ID);
                equipe4.setGrupoID(grupo2ID);
                equipe5.setGrupoID(grupo2ID);
                equipe6.setGrupoID(grupo2ID);
                equipe7.setGrupoID(grupo3ID);
                equipe8.setGrupoID(grupo3ID);
                equipe9.setGrupoID(grupo3ID);
                equipe10.setGrupoID(grupo4ID);
                equipe11.setGrupoID(grupo4ID);
                equipe12.setGrupoID(grupo4ID);

                editPlacarEquipe1J1.setEnabled(true);
                editPlacarEquipe1J2.setEnabled(true);
                editPlacarEquipe2J1.setEnabled(true);
                editPlacarEquipe2J2.setEnabled(true);
                editPlacarEquipe3J1.setEnabled(true);
                editPlacarEquipe3J2.setEnabled(true);
                editPlacarEquipe4J1.setEnabled(true);
                editPlacarEquipe4J2.setEnabled(true);
                editPlacarEquipe5J1.setEnabled(true);
                editPlacarEquipe5J2.setEnabled(true);
                editPlacarEquipe6J1.setEnabled(true);
                editPlacarEquipe6J2.setEnabled(true);
                editPlacarEquipe7J1.setEnabled(true);
                editPlacarEquipe7J2.setEnabled(true);
                editPlacarEquipe8J1.setEnabled(true);
                editPlacarEquipe8J2.setEnabled(true);
                editPlacarEquipe9J1.setEnabled(true);
                editPlacarEquipe9J2.setEnabled(true);
                editPlacarEquipe10J1.setEnabled(true);
                editPlacarEquipe10J2.setEnabled(true);
                editPlacarEquipe11J1.setEnabled(true);
                editPlacarEquipe11J2.setEnabled(true);
                editPlacarEquipe12J1.setEnabled(true);
                editPlacarEquipe12J2.setEnabled(true);

                if (editPlacarEquipe3J1.isEnabled()) {
                    if (validarFormularioJogo(editPlacarEquipe3J1, editPlacarEquipe2J1)) {
                        salvarJogo(equipe3, equipe2, editPlacarEquipe3J1, editPlacarEquipe2J1, equipe3ID, equipe2ID, grupo1ID, grupo1ID);
                    }
                }
                if (editPlacarEquipe6J1.isEnabled()) {
                    if (validarFormularioJogo(editPlacarEquipe6J1, editPlacarEquipe5J1)) {
                        salvarJogo(equipe6, equipe5, editPlacarEquipe6J1, editPlacarEquipe5J1, equipe6ID, equipe5ID, grupo2ID, grupo2ID);
                    }
                }
                if (editPlacarEquipe9J1.isEnabled()) {
                    if (validarFormularioJogo(editPlacarEquipe9J1, editPlacarEquipe8J1)) {
                        salvarJogo(equipe9, equipe8, editPlacarEquipe9J1, editPlacarEquipe8J1, equipe9ID, equipe8ID, grupo3ID, grupo3ID);
                    }
                }
                if (editPlacarEquipe12J1.isEnabled()) {
                    if (validarFormularioJogo(editPlacarEquipe12J1, editPlacarEquipe11J1)) {
                        salvarJogo(equipe12, equipe11, editPlacarEquipe12J1, editPlacarEquipe11J1, equipe12ID, equipe11ID, grupo4ID, grupo4ID);
                    }
                }
                if (editPlacarEquipe1J1.isEnabled()) {
                    if (validarFormularioJogo(editPlacarEquipe1J1, editPlacarEquipe3J2)) {
                        salvarJogo(equipe1, equipe3, editPlacarEquipe1J1, editPlacarEquipe3J2, equipe1ID, equipe3ID, grupo1ID, grupo1ID);
                    }
                }
                if (editPlacarEquipe4J1.isEnabled()) {
                    if (validarFormularioJogo(editPlacarEquipe4J1, editPlacarEquipe6J2)) {
                        salvarJogo(equipe4, equipe6, editPlacarEquipe4J1, editPlacarEquipe6J2, equipe4ID, equipe6ID, grupo2ID, grupo2ID);
                    }
                }
                if (editPlacarEquipe7J1.isEnabled()) {
                    if (validarFormularioJogo(editPlacarEquipe7J1, editPlacarEquipe9J2)) {
                        salvarJogo(equipe7, equipe9, editPlacarEquipe7J1, editPlacarEquipe9J2, equipe7ID, equipe9ID, grupo3ID, grupo3ID);
                    }
                }
                if (editPlacarEquipe10J1.isEnabled()) {
                    if (validarFormularioJogo(editPlacarEquipe10J1, editPlacarEquipe12J2)) {
                        salvarJogo(equipe10, equipe12, editPlacarEquipe10J1, editPlacarEquipe12J2, equipe10ID, equipe12ID, grupo4ID, grupo4ID);
                    }
                }
                if (editPlacarEquipe2J2.isEnabled()) {
                    if (validarFormularioJogo(editPlacarEquipe2J2, editPlacarEquipe1J2)) {
                        salvarJogo(equipe2, equipe1, editPlacarEquipe2J2, editPlacarEquipe1J2, equipe2ID, equipe1ID, grupo1ID, grupo1ID);
                    }
                }
                if (editPlacarEquipe5J2.isEnabled()) {
                    if (validarFormularioJogo(editPlacarEquipe5J2, editPlacarEquipe4J2)) {
                        salvarJogo(equipe5, equipe4, editPlacarEquipe5J2, editPlacarEquipe4J2, equipe5ID, equipe4ID, grupo2ID, grupo2ID);
                    }
                }
                if (editPlacarEquipe8J2.isEnabled()) {
                    if (validarFormularioJogo(editPlacarEquipe8J2, editPlacarEquipe7J2)) {
                        salvarJogo(equipe8, equipe7, editPlacarEquipe8J2, editPlacarEquipe7J2, equipe8ID, equipe7ID, grupo3ID, grupo3ID);
                    }
                }
                if (editPlacarEquipe11J2.isEnabled()) {
                    if (validarFormularioJogo(editPlacarEquipe11J2, editPlacarEquipe10J2)) {
                        salvarJogo(equipe11, equipe10, editPlacarEquipe11J2, editPlacarEquipe10J2, equipe11ID, equipe10ID, grupo4ID, grupo4ID);
                    }
                }
            }

            if (trocaTela) {
                salvarSharedPreferences();
                conseguiu = true;
                Toast.makeText(this, "Dados Salvos com Sucesso...", Toast.LENGTH_SHORT).show();

                AppUtil.goNextScreen(JogosPrimeiraFase.this, Dashboard.class, true);
                finish();
            }
        }
        if (qtdEquipes > Torneio.TORNEIO_DOZE_EQUIPES) {
            equipe13.setId(equipe13ID);
            equipe14.setId(equipe14ID);
            equipe15.setId(equipe15ID);
            equipe16.setId(equipe16ID);
            equipe13.setJogos(0);
            equipe14.setJogos(0);
            equipe15.setJogos(0);
            equipe16.setJogos(0);
            equipe13.setPontos(0);
            equipe14.setPontos(0);
            equipe15.setPontos(0);
            equipe16.setPontos(0);
            equipe13.setVitorias(0);
            equipe14.setVitorias(0);
            equipe15.setVitorias(0);
            equipe16.setVitorias(0);
            equipe13.setEmpates(0);
            equipe14.setEmpates(0);
            equipe15.setEmpates(0);
            equipe16.setEmpates(0);
            equipe13.setDerrotas(0);
            equipe14.setDerrotas(0);
            equipe15.setDerrotas(0);
            equipe16.setDerrotas(0);
            equipe13.setGolsPro(0);
            equipe14.setGolsPro(0);
            equipe15.setGolsPro(0);
            equipe16.setGolsPro(0);
            equipe13.setGolsContra(0);
            equipe14.setGolsContra(0);
            equipe15.setGolsContra(0);
            equipe16.setGolsContra(0);
            equipeController.alterar(equipe13);
            equipeController.alterar(equipe14);
            equipeController.alterar(equipe15);
            equipeController.alterar(equipe16);

            if (qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
                equipe5.setGrupoID(grupo2ID);
                equipe6.setGrupoID(grupo2ID);
                equipe7.setGrupoID(grupo2ID);
                equipe8.setGrupoID(grupo2ID);
                equipe9.setGrupoID(grupo3ID);
                equipe10.setGrupoID(grupo3ID);
                equipe11.setGrupoID(grupo3ID);
                equipe12.setGrupoID(grupo3ID);
                equipe13.setGrupoID(grupo4ID);
                equipe14.setGrupoID(grupo4ID);
                equipe15.setGrupoID(grupo4ID);
                equipe16.setGrupoID(grupo4ID);

                editPlacarEquipe5J1.setEnabled(true);
                editPlacarEquipe5J2.setEnabled(true);
                editPlacarEquipe5J3.setEnabled(true);
                editPlacarEquipe6J1.setEnabled(true);
                editPlacarEquipe6J2.setEnabled(true);
                editPlacarEquipe6J3.setEnabled(true);
                editPlacarEquipe7J1.setEnabled(true);
                editPlacarEquipe7J2.setEnabled(true);
                editPlacarEquipe7J3.setEnabled(true);
                editPlacarEquipe8J1.setEnabled(true);
                editPlacarEquipe8J2.setEnabled(true);
                editPlacarEquipe8J3.setEnabled(true);
                editPlacarEquipe9J1.setEnabled(true);
                editPlacarEquipe9J2.setEnabled(true);
                editPlacarEquipe9J3.setEnabled(true);
                editPlacarEquipe10J1.setEnabled(true);
                editPlacarEquipe10J2.setEnabled(true);
                editPlacarEquipe10J3.setEnabled(true);
                editPlacarEquipe11J1.setEnabled(true);
                editPlacarEquipe11J2.setEnabled(true);
                editPlacarEquipe11J3.setEnabled(true);
                editPlacarEquipe12J1.setEnabled(true);
                editPlacarEquipe12J2.setEnabled(true);
                editPlacarEquipe12J3.setEnabled(true);
                editPlacarEquipe13J1.setEnabled(true);
                editPlacarEquipe13J2.setEnabled(true);
                editPlacarEquipe13J3.setEnabled(true);
                editPlacarEquipe14J1.setEnabled(true);
                editPlacarEquipe14J2.setEnabled(true);
                editPlacarEquipe14J3.setEnabled(true);
                editPlacarEquipe15J1.setEnabled(true);
                editPlacarEquipe15J2.setEnabled(true);
                editPlacarEquipe15J3.setEnabled(true);
                editPlacarEquipe16J1.setEnabled(true);
                editPlacarEquipe16J2.setEnabled(true);
                editPlacarEquipe16J3.setEnabled(true);
            }

            if (editPlacarEquipe1J1.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe1J1, editPlacarEquipe2J1)) {
                    salvarJogo(equipe1, equipe2, editPlacarEquipe1J1, editPlacarEquipe2J1, equipe1ID, equipe2ID, grupo1ID, grupo1ID);
                }
            }
            if (editPlacarEquipe5J1.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe5J1, editPlacarEquipe6J1)) {
                    salvarJogo(equipe5, equipe6, editPlacarEquipe5J1, editPlacarEquipe6J1, equipe5ID, equipe6ID, grupo2ID, grupo2ID);
                }
            }
            if (editPlacarEquipe9J1.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe9J1, editPlacarEquipe10J1)) {
                    salvarJogo(equipe9, equipe10, editPlacarEquipe9J1, editPlacarEquipe10J1, equipe9ID, equipe10ID, grupo3ID, grupo3ID);
                }
            }
            if (editPlacarEquipe13J1.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe13J1, editPlacarEquipe14J1)) {
                    salvarJogo(equipe13, equipe14, editPlacarEquipe13J1, editPlacarEquipe14J1, equipe13ID, equipe14ID, grupo4ID, grupo4ID);
                }
            }
            if (editPlacarEquipe3J1.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe3J1, editPlacarEquipe4J1)) {
                    salvarJogo(equipe3, equipe4, editPlacarEquipe3J1, editPlacarEquipe4J1, equipe3ID, equipe4ID, grupo1ID, grupo1ID);
                }
            }
            if (editPlacarEquipe7J1.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe7J1, editPlacarEquipe8J1)) {
                    salvarJogo(equipe7, equipe8, editPlacarEquipe7J1, editPlacarEquipe8J1, equipe7ID, equipe8ID, grupo2ID, grupo2ID);
                }
            }
            if (editPlacarEquipe11J1.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe11J1, editPlacarEquipe12J1)) {
                    salvarJogo(equipe11, equipe12, editPlacarEquipe11J1, editPlacarEquipe12J1, equipe11ID, equipe12ID, grupo3ID, grupo3ID);
                }
            }
            if (editPlacarEquipe15J1.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe15J1, editPlacarEquipe16J1)) {
                    salvarJogo(equipe15, equipe16, editPlacarEquipe15J1, editPlacarEquipe16J1, equipe15ID, equipe16ID, grupo4ID, grupo4ID);
                }
            }
            if (editPlacarEquipe4J2.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe4J2, editPlacarEquipe1J2)) {
                    salvarJogo(equipe4, equipe1, editPlacarEquipe4J2, editPlacarEquipe1J2, equipe4ID, equipe1ID, grupo1ID, grupo1ID);
                }
            }
            if (editPlacarEquipe8J2.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe8J2, editPlacarEquipe5J2)) {
                    salvarJogo(equipe8, equipe5, editPlacarEquipe8J2, editPlacarEquipe5J2, equipe8ID, equipe5ID, grupo2ID, grupo2ID);
                }
            }
            if (editPlacarEquipe12J2.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe12J2, editPlacarEquipe9J2)) {
                    salvarJogo(equipe12, equipe9, editPlacarEquipe12J2, editPlacarEquipe9J2, equipe12ID, equipe9ID, grupo3ID, grupo3ID);
                }
            }
            if (editPlacarEquipe16J2.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe16J2, editPlacarEquipe13J2)) {
                    salvarJogo(equipe16, equipe13, editPlacarEquipe16J2, editPlacarEquipe13J2, equipe16ID, equipe13ID, grupo4ID, grupo4ID);
                }
            }
            if (editPlacarEquipe2J2.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe2J2, editPlacarEquipe3J2)) {
                    salvarJogo(equipe2, equipe3, editPlacarEquipe2J2, editPlacarEquipe3J2, equipe2ID, equipe3ID, grupo1ID, grupo1ID);
                }
            }
            if (editPlacarEquipe6J2.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe6J2, editPlacarEquipe7J2)) {
                    salvarJogo(equipe6, equipe7, editPlacarEquipe6J2, editPlacarEquipe7J2, equipe6ID, equipe7ID, grupo2ID, grupo2ID);
                }
            }
            if (editPlacarEquipe10J2.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe10J2, editPlacarEquipe11J2)) {
                    salvarJogo(equipe10, equipe11, editPlacarEquipe10J2, editPlacarEquipe11J2, equipe10ID, equipe11ID, grupo3ID, grupo3ID);
                }
            }
            if (editPlacarEquipe14J2.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe14J2, editPlacarEquipe15J2)) {
                    salvarJogo(equipe14, equipe15, editPlacarEquipe14J2, editPlacarEquipe15J2, equipe14ID, equipe15ID, grupo4ID, grupo4ID);
                }
            }
            if (editPlacarEquipe1J3.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe1J3, editPlacarEquipe3J3)) {
                    salvarJogo(equipe1, equipe3, editPlacarEquipe1J3, editPlacarEquipe3J3, equipe1ID, equipe3ID, grupo1ID, grupo1ID);
                }
            }
            if (editPlacarEquipe5J3.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe5J3, editPlacarEquipe7J3)) {
                    salvarJogo(equipe5, equipe7, editPlacarEquipe5J3, editPlacarEquipe7J3, equipe5ID, equipe7ID, grupo2ID, grupo2ID);
                }
            }
            if (editPlacarEquipe9J3.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe9J3, editPlacarEquipe11J3)) {
                    salvarJogo(equipe9, equipe11, editPlacarEquipe9J3, editPlacarEquipe11J3, equipe9ID, equipe11ID, grupo3ID, grupo3ID);
                }
            }
            if (editPlacarEquipe13J3.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe13J3, editPlacarEquipe15J3)) {
                    salvarJogo(equipe13, equipe15, editPlacarEquipe13J3, editPlacarEquipe15J3, equipe13ID, equipe15ID, grupo4ID, grupo4ID);
                }
            }
            if (editPlacarEquipe2J3.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe2J3, editPlacarEquipe4J3)) {
                    salvarJogo(equipe2, equipe4, editPlacarEquipe2J3, editPlacarEquipe4J3, equipe2ID, equipe4ID, grupo1ID, grupo1ID);
                }
            }
            if (editPlacarEquipe6J3.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe6J3, editPlacarEquipe8J3)) {
                    salvarJogo(equipe6, equipe8, editPlacarEquipe6J3, editPlacarEquipe8J3, equipe6ID, equipe8ID, grupo2ID, grupo2ID);
                }
            }
            if (editPlacarEquipe10J3.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe10J3, editPlacarEquipe12J3)) {
                    salvarJogo(equipe10, equipe12, editPlacarEquipe10J3, editPlacarEquipe12J3, equipe10ID, equipe12ID, grupo3ID, grupo3ID);
                }
            }
            if (editPlacarEquipe14J3.isEnabled()) {
                if (validarFormularioJogo(editPlacarEquipe14J3, editPlacarEquipe16J3)) {
                    salvarJogo(equipe14, equipe16, editPlacarEquipe14J3, editPlacarEquipe16J3, equipe14ID, equipe16ID, grupo4ID, grupo4ID);
                }
            }

            if (trocaTela) {
                salvarSharedPreferences();
                conseguiu = true;
                Toast.makeText(this, "Dados Salvos com Sucesso...", Toast.LENGTH_SHORT).show();

                AppUtil.goNextScreen(JogosPrimeiraFase.this, Dashboard.class, true);
                finish();
            }
        }
        return conseguiu;
    }

    private boolean finalizarPrimeiraFase() {
        if (qtdEquipes == Torneio.TORNEIO_QUATRO_EQUIPES) {
            if (validarFormularioJogo(editPlacarEquipe1J1, editPlacarEquipe2J1) && validarFormularioJogo(editPlacarEquipe3J1, editPlacarEquipe4J1) &&
                    validarFormularioJogo(editPlacarEquipe4J2, editPlacarEquipe1J2) && validarFormularioJogo(editPlacarEquipe2J2, editPlacarEquipe3J2)
                    && validarFormularioJogo(editPlacarEquipe1J3, editPlacarEquipe3J3) && validarFormularioJogo(editPlacarEquipe2J3, editPlacarEquipe4J3)) {

                editPlacarEquipe1J1.setEnabled(true);
                editPlacarEquipe1J2.setEnabled(true);
                editPlacarEquipe1J3.setEnabled(true);
                editPlacarEquipe2J1.setEnabled(true);
                editPlacarEquipe2J2.setEnabled(true);
                editPlacarEquipe2J3.setEnabled(true);
                editPlacarEquipe3J1.setEnabled(true);
                editPlacarEquipe3J2.setEnabled(true);
                editPlacarEquipe3J3.setEnabled(true);
                editPlacarEquipe4J1.setEnabled(true);
                editPlacarEquipe4J2.setEnabled(true);
                editPlacarEquipe4J3.setEnabled(true);

                if (salvarResultados()) {
                    equipes = new Equipe[Torneio.GRUPO_QUATRO_EQUIPES];
                    equipes[0] = equipe1;
                    equipes[1] = equipe2;
                    equipes[2] = equipe3;
                    equipes[3] = equipe4;

                    ordenaGrupo(equipes);
                }
            } else {
                showFormErrorAlertDialog();
                return false;
            }
        } else if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
            if (validarFormularioJogo(editPlacarEquipe3J1, editPlacarEquipe2J1) && validarFormularioJogo(editPlacarEquipe6J1, editPlacarEquipe5J1) &&
                    validarFormularioJogo(editPlacarEquipe9J1, editPlacarEquipe8J1) && validarFormularioJogo(editPlacarEquipe12J1, editPlacarEquipe11J1) &&
                    validarFormularioJogo(editPlacarEquipe1J1, editPlacarEquipe3J2) && validarFormularioJogo(editPlacarEquipe4J1, editPlacarEquipe6J2) &&
                    validarFormularioJogo(editPlacarEquipe7J1, editPlacarEquipe9J2) && validarFormularioJogo(editPlacarEquipe10J1, editPlacarEquipe12J2) &&
                    validarFormularioJogo(editPlacarEquipe2J2, editPlacarEquipe1J2) && validarFormularioJogo(editPlacarEquipe5J2, editPlacarEquipe4J2) &&
                    validarFormularioJogo(editPlacarEquipe8J2, editPlacarEquipe7J2) && validarFormularioJogo(editPlacarEquipe11J2, editPlacarEquipe10J2)) {

                editPlacarEquipe1J1.setEnabled(true);
                editPlacarEquipe1J2.setEnabled(true);
                editPlacarEquipe2J1.setEnabled(true);
                editPlacarEquipe2J2.setEnabled(true);
                editPlacarEquipe3J1.setEnabled(true);
                editPlacarEquipe3J2.setEnabled(true);
                editPlacarEquipe4J1.setEnabled(true);
                editPlacarEquipe4J2.setEnabled(true);
                editPlacarEquipe5J1.setEnabled(true);
                editPlacarEquipe5J2.setEnabled(true);
                editPlacarEquipe6J1.setEnabled(true);
                editPlacarEquipe6J2.setEnabled(true);
                editPlacarEquipe7J1.setEnabled(true);
                editPlacarEquipe7J2.setEnabled(true);
                editPlacarEquipe8J1.setEnabled(true);
                editPlacarEquipe8J2.setEnabled(true);
                editPlacarEquipe9J1.setEnabled(true);
                editPlacarEquipe9J2.setEnabled(true);
                editPlacarEquipe10J1.setEnabled(true);
                editPlacarEquipe10J2.setEnabled(true);
                editPlacarEquipe11J1.setEnabled(true);
                editPlacarEquipe11J2.setEnabled(true);
                editPlacarEquipe12J1.setEnabled(true);
                editPlacarEquipe12J2.setEnabled(true);

                if (salvarResultados()) {
                    equipesA[0] = equipe1;
                    equipesA[1] = equipe2;
                    equipesA[2] = equipe3;
                    equipesB[0] = equipe4;
                    equipesB[1] = equipe5;
                    equipesB[2] = equipe6;
                    equipesC[0] = equipe7;
                    equipesC[1] = equipe8;
                    equipesC[2] = equipe9;
                    equipesD[0] = equipe10;
                    equipesD[1] = equipe11;
                    equipesD[2] = equipe12;

                    ordenaGrupo(equipesA);
                    ordenaGrupo(equipesB);
                    ordenaGrupo(equipesC);
                    ordenaGrupo(equipesD);
                }
            } else {
                showFormErrorAlertDialog();
                return false;
            }
        } else if (qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
            if (validarFormularioJogo(editPlacarEquipe1J1, editPlacarEquipe2J1) && validarFormularioJogo(editPlacarEquipe5J1, editPlacarEquipe6J1) &&
                    validarFormularioJogo(editPlacarEquipe9J1, editPlacarEquipe10J1) && validarFormularioJogo(editPlacarEquipe13J1, editPlacarEquipe14J1) &&
                    validarFormularioJogo(editPlacarEquipe3J1, editPlacarEquipe4J1) && validarFormularioJogo(editPlacarEquipe7J1, editPlacarEquipe8J1) &&
                    validarFormularioJogo(editPlacarEquipe11J1, editPlacarEquipe12J1) && validarFormularioJogo(editPlacarEquipe15J1, editPlacarEquipe16J1) &&
                    validarFormularioJogo(editPlacarEquipe4J2, editPlacarEquipe1J2) && validarFormularioJogo(editPlacarEquipe8J2, editPlacarEquipe5J2) &&
                    validarFormularioJogo(editPlacarEquipe12J2, editPlacarEquipe9J2) && validarFormularioJogo(editPlacarEquipe16J2, editPlacarEquipe13J2) &&
                    validarFormularioJogo(editPlacarEquipe2J2, editPlacarEquipe3J2) && validarFormularioJogo(editPlacarEquipe6J2, editPlacarEquipe7J2) &&
                    validarFormularioJogo(editPlacarEquipe10J2, editPlacarEquipe11J2) && validarFormularioJogo(editPlacarEquipe14J2, editPlacarEquipe15J2) &&
                    validarFormularioJogo(editPlacarEquipe1J3, editPlacarEquipe3J3) && validarFormularioJogo(editPlacarEquipe5J3, editPlacarEquipe7J3) &&
                    validarFormularioJogo(editPlacarEquipe9J3, editPlacarEquipe11J3) && validarFormularioJogo(editPlacarEquipe13J3, editPlacarEquipe15J3) &&
                    validarFormularioJogo(editPlacarEquipe2J3, editPlacarEquipe4J3) && validarFormularioJogo(editPlacarEquipe6J3, editPlacarEquipe8J3) &&
                    validarFormularioJogo(editPlacarEquipe10J3, editPlacarEquipe12J3) && validarFormularioJogo(editPlacarEquipe14J3, editPlacarEquipe16J3)) {

                editPlacarEquipe1J1.setEnabled(true);
                editPlacarEquipe1J2.setEnabled(true);
                editPlacarEquipe1J3.setEnabled(true);
                editPlacarEquipe2J1.setEnabled(true);
                editPlacarEquipe2J2.setEnabled(true);
                editPlacarEquipe2J3.setEnabled(true);
                editPlacarEquipe3J1.setEnabled(true);
                editPlacarEquipe3J2.setEnabled(true);
                editPlacarEquipe3J3.setEnabled(true);
                editPlacarEquipe4J1.setEnabled(true);
                editPlacarEquipe4J2.setEnabled(true);
                editPlacarEquipe4J3.setEnabled(true);
                editPlacarEquipe5J1.setEnabled(true);
                editPlacarEquipe5J2.setEnabled(true);
                editPlacarEquipe5J3.setEnabled(true);
                editPlacarEquipe6J1.setEnabled(true);
                editPlacarEquipe6J2.setEnabled(true);
                editPlacarEquipe6J3.setEnabled(true);
                editPlacarEquipe7J1.setEnabled(true);
                editPlacarEquipe7J2.setEnabled(true);
                editPlacarEquipe7J3.setEnabled(true);
                editPlacarEquipe8J1.setEnabled(true);
                editPlacarEquipe8J2.setEnabled(true);
                editPlacarEquipe8J3.setEnabled(true);
                editPlacarEquipe9J1.setEnabled(true);
                editPlacarEquipe9J2.setEnabled(true);
                editPlacarEquipe9J3.setEnabled(true);
                editPlacarEquipe10J1.setEnabled(true);
                editPlacarEquipe10J2.setEnabled(true);
                editPlacarEquipe10J3.setEnabled(true);
                editPlacarEquipe11J1.setEnabled(true);
                editPlacarEquipe11J2.setEnabled(true);
                editPlacarEquipe11J3.setEnabled(true);
                editPlacarEquipe12J1.setEnabled(true);
                editPlacarEquipe12J2.setEnabled(true);
                editPlacarEquipe12J3.setEnabled(true);
                editPlacarEquipe13J1.setEnabled(true);
                editPlacarEquipe13J2.setEnabled(true);
                editPlacarEquipe13J3.setEnabled(true);
                editPlacarEquipe14J1.setEnabled(true);
                editPlacarEquipe14J2.setEnabled(true);
                editPlacarEquipe14J3.setEnabled(true);
                editPlacarEquipe15J1.setEnabled(true);
                editPlacarEquipe15J2.setEnabled(true);
                editPlacarEquipe15J3.setEnabled(true);
                editPlacarEquipe16J1.setEnabled(true);
                editPlacarEquipe16J2.setEnabled(true);
                editPlacarEquipe16J3.setEnabled(true);

                if (salvarResultados()) {
                    equipesA[0] = equipe1;
                    equipesA[1] = equipe2;
                    equipesA[2] = equipe3;
                    equipesA[3] = equipe4;
                    equipesB[0] = equipe5;
                    equipesB[1] = equipe6;
                    equipesB[2] = equipe7;
                    equipesB[3] = equipe8;
                    equipesC[0] = equipe9;
                    equipesC[1] = equipe10;
                    equipesC[2] = equipe11;
                    equipesC[3] = equipe12;
                    equipesD[0] = equipe13;
                    equipesD[1] = equipe14;
                    equipesD[2] = equipe15;
                    equipesD[3] = equipe16;

                    ordenaGrupo(equipesA);
                    ordenaGrupo(equipesB);
                    ordenaGrupo(equipesC);
                    ordenaGrupo(equipesD);
                }
            } else {
                showFormErrorAlertDialog();
                return false;
            }
        }
        salvarSharedPreferencesClassificados();
        return true;
    }

    public void ordenaGrupo(Equipe[] equipes) {
        boolean troca = true;
        Equipe equipeFake;
        while (troca) {
            troca = false;
            for (int i = 0; i < equipes.length - 1; i++) {
                if (equipes[i].getPontos() < equipes[i + 1].getPontos()) {
                    equipeFake = equipes[i];
                    equipes[i] = equipes[i + 1];
                    equipes[i + 1] = equipeFake;
                    troca = true;
                } //Era só até aqui!!!
                else if (equipes[i].getPontos() == equipes[i + 1].getPontos()) {
                    if (equipes[i].getVitorias() < equipes[i + 1].getVitorias()) {
                        equipeFake = equipes[i];
                        equipes[i] = equipes[i + 1];
                        equipes[i + 1] = equipeFake;
                        troca = true;
                    } else if (equipes[i].getVitorias() == equipes[i + 1].getVitorias()) {
                        if (equipes[i].getSaldoGols() < equipes[i + 1].getSaldoGols()) {
                            equipeFake = equipes[i];
                            equipes[i] = equipes[i + 1];
                            equipes[i + 1] = equipeFake;
                            troca = true;
                        } else if (equipes[i].getSaldoGols() == equipes[i + 1].getSaldoGols()) {
                            if (equipes[i].getGolsPro() < equipes[i + 1].getGolsPro()) {
                                equipeFake = equipes[i];
                                equipes[i] = equipes[i + 1];
                                equipes[i + 1] = equipeFake;
                                troca = true;
                            } else if (equipes[i].getGolsPro() == equipes[i + 1].getGolsPro()) {
                                if (equipes[i].getGolsContra() < equipes[i + 1].getGolsContra()) {
                                    equipeFake = equipes[i];
                                    equipes[i] = equipes[i + 1];
                                    equipes[i + 1] = equipeFake;
                                    troca = true;
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    private void showFormErrorAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ALERTA");
        builder.setMessage("Você deve preencher o placar de todos os jogos para finalizar a 1ª fase!");
        builder.setCancelable(true);
        builder.setIcon(R.mipmap.ic_launcher_round);

        builder.setPositiveButton("OK", (dialogInterface, i) ->
                dialogInterface.cancel());

        AlertDialog alert = builder.create();
        alert.show();
    }

    private void restaurarSharedPreferencesQtdEquipes() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);

        qtdEquipes = preferences.getInt("qtdEquipes", -1);
        finalizouPrimeiraFase = preferences.getBoolean("finalizouPrimeiraFase", false);
    }

    private void restaurarSharedPreferences() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);

        grupo1ID = preferences.getInt("grupo1ID", -1);
        equipe1ID = preferences.getInt("equipe1ID", -1);
        equipe2ID = preferences.getInt("equipe2ID", -1);
        equipe3ID = preferences.getInt("equipe3ID", -1);
        equipe4ID = preferences.getInt("equipe4ID", -1);
        finalizouPrimeiraFase = preferences.getBoolean("finalizouPrimeiraFase", false);

        if (qtdEquipes == Torneio.TORNEIO_QUATRO_EQUIPES) {
            placarEquipe1J1 = preferences.getString("placarEquipe1J1", "");
            placarEquipe1J2 = preferences.getString("placarEquipe1J2", "");
            placarEquipe1J3 = preferences.getString("placarEquipe1J3", "");
            placarEquipe2J1 = preferences.getString("placarEquipe2J1", "");
            placarEquipe2J2 = preferences.getString("placarEquipe2J2", "");
            placarEquipe2J3 = preferences.getString("placarEquipe2J3", "");
            placarEquipe3J1 = preferences.getString("placarEquipe3J1", "");
            placarEquipe3J2 = preferences.getString("placarEquipe3J2", "");
            placarEquipe3J3 = preferences.getString("placarEquipe3J3", "");
            placarEquipe4J1 = preferences.getString("placarEquipe4J1", "");
            placarEquipe4J2 = preferences.getString("placarEquipe4J2", "");
            placarEquipe4J3 = preferences.getString("placarEquipe4J3", "");
        }
        if (qtdEquipes > Torneio.TORNEIO_QUATRO_EQUIPES) {
            grupo2ID = preferences.getInt("grupo2ID", -1);
            grupo3ID = preferences.getInt("grupo3ID", -1);
            grupo4ID = preferences.getInt("grupo4ID", -1);

            equipe5ID = preferences.getInt("equipe5ID", -1);
            equipe6ID = preferences.getInt("equipe6ID", -1);
            equipe7ID = preferences.getInt("equipe7ID", -1);
            equipe8ID = preferences.getInt("equipe8ID", -1);
            equipe9ID = preferences.getInt("equipe9ID", -1);
            equipe10ID = preferences.getInt("equipe10ID", -1);
            equipe11ID = preferences.getInt("equipe11ID", -1);
            equipe12ID = preferences.getInt("equipe12ID", -1);

            if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
                placarEquipe1J1 = preferences.getString("placarEquipe1J1", "");
                placarEquipe1J2 = preferences.getString("placarEquipe1J2", "");
                placarEquipe2J1 = preferences.getString("placarEquipe2J1", "");
                placarEquipe2J2 = preferences.getString("placarEquipe2J2", "");
                placarEquipe3J1 = preferences.getString("placarEquipe3J1", "");
                placarEquipe3J2 = preferences.getString("placarEquipe3J2", "");
                placarEquipe4J1 = preferences.getString("placarEquipe4J1", "");
                placarEquipe4J2 = preferences.getString("placarEquipe4J2", "");
                placarEquipe5J1 = preferences.getString("placarEquipe5J1", "");
                placarEquipe5J2 = preferences.getString("placarEquipe5J2", "");
                placarEquipe6J1 = preferences.getString("placarEquipe6J1", "");
                placarEquipe6J2 = preferences.getString("placarEquipe6J2", "");
                placarEquipe7J1 = preferences.getString("placarEquipe7J1", "");
                placarEquipe7J2 = preferences.getString("placarEquipe7J2", "");
                placarEquipe8J1 = preferences.getString("placarEquipe8J1", "");
                placarEquipe8J2 = preferences.getString("placarEquipe8J2", "");
                placarEquipe9J1 = preferences.getString("placarEquipe9J1", "");
                placarEquipe9J2 = preferences.getString("placarEquipe9J2", "");
                placarEquipe10J1 = preferences.getString("placarEquipe10J1", "");
                placarEquipe10J2 = preferences.getString("placarEquipe10J2", "");
                placarEquipe11J1 = preferences.getString("placarEquipe11J1", "");
                placarEquipe11J2 = preferences.getString("placarEquipe11J2", "");
                placarEquipe12J1 = preferences.getString("placarEquipe12J1", "");
                placarEquipe12J2 = preferences.getString("placarEquipe12J2", "");
                finalizouQuartas = preferences.getBoolean("finalizouQuartas", false);
            }
        }
        if (qtdEquipes > Torneio.TORNEIO_DOZE_EQUIPES) {
            equipe13ID = preferences.getInt("equipe13ID", -1);
            equipe14ID = preferences.getInt("equipe14ID", -1);
            equipe15ID = preferences.getInt("equipe15ID", -1);
            equipe16ID = preferences.getInt("equipe16ID", -1);

            if (qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
                placarEquipe1J1 = preferences.getString("placarEquipe1J1", "");
                placarEquipe1J2 = preferences.getString("placarEquipe1J2", "");
                placarEquipe1J3 = preferences.getString("placarEquipe1J3", "");
                placarEquipe2J1 = preferences.getString("placarEquipe2J1", "");
                placarEquipe2J2 = preferences.getString("placarEquipe2J2", "");
                placarEquipe2J3 = preferences.getString("placarEquipe2J3", "");
                placarEquipe3J1 = preferences.getString("placarEquipe3J1", "");
                placarEquipe3J2 = preferences.getString("placarEquipe3J2", "");
                placarEquipe3J3 = preferences.getString("placarEquipe3J3", "");
                placarEquipe4J1 = preferences.getString("placarEquipe4J1", "");
                placarEquipe4J2 = preferences.getString("placarEquipe4J2", "");
                placarEquipe4J3 = preferences.getString("placarEquipe4J3", "");
                placarEquipe5J1 = preferences.getString("placarEquipe5J1", "");
                placarEquipe5J2 = preferences.getString("placarEquipe5J2", "");
                placarEquipe5J3 = preferences.getString("placarEquipe5J3", "");
                placarEquipe6J1 = preferences.getString("placarEquipe6J1", "");
                placarEquipe6J2 = preferences.getString("placarEquipe6J2", "");
                placarEquipe6J3 = preferences.getString("placarEquipe6J3", "");
                placarEquipe7J1 = preferences.getString("placarEquipe7J1", "");
                placarEquipe7J2 = preferences.getString("placarEquipe7J2", "");
                placarEquipe7J3 = preferences.getString("placarEquipe7J3", "");
                placarEquipe8J1 = preferences.getString("placarEquipe8J1", "");
                placarEquipe8J2 = preferences.getString("placarEquipe8J2", "");
                placarEquipe8J3 = preferences.getString("placarEquipe8J3", "");
                placarEquipe9J1 = preferences.getString("placarEquipe9J1", "");
                placarEquipe9J2 = preferences.getString("placarEquipe9J2", "");
                placarEquipe9J3 = preferences.getString("placarEquipe9J3", "");
                placarEquipe10J1 = preferences.getString("placarEquipe10J1", "");
                placarEquipe10J2 = preferences.getString("placarEquipe10J2", "");
                placarEquipe10J3 = preferences.getString("placarEquipe10J3", "");
                placarEquipe11J1 = preferences.getString("placarEquipe11J1", "");
                placarEquipe11J2 = preferences.getString("placarEquipe11J2", "");
                placarEquipe11J3 = preferences.getString("placarEquipe11J3", "");
                placarEquipe12J1 = preferences.getString("placarEquipe12J1", "");
                placarEquipe12J2 = preferences.getString("placarEquipe12J2", "");
                placarEquipe12J3 = preferences.getString("placarEquipe12J3", "");
                placarEquipe13J1 = preferences.getString("placarEquipe13J1", "");
                placarEquipe13J2 = preferences.getString("placarEquipe13J2", "");
                placarEquipe13J3 = preferences.getString("placarEquipe13J3", "");
                placarEquipe14J1 = preferences.getString("placarEquipe14J1", "");
                placarEquipe14J2 = preferences.getString("placarEquipe14J2", "");
                placarEquipe14J3 = preferences.getString("placarEquipe14J3", "");
                placarEquipe15J1 = preferences.getString("placarEquipe15J1", "");
                placarEquipe15J2 = preferences.getString("placarEquipe15J2", "");
                placarEquipe15J3 = preferences.getString("placarEquipe15J3", "");
                placarEquipe16J1 = preferences.getString("placarEquipe16J1", "");
                placarEquipe16J2 = preferences.getString("placarEquipe16J2", "");
                placarEquipe16J3 = preferences.getString("placarEquipe16J3", "");
                finalizouQuartas = preferences.getBoolean("finalizouQuartas", false);
            }
        }
    }

    private void salvarSharedPreferences() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        if (qtdEquipes == Torneio.TORNEIO_QUATRO_EQUIPES) {
            dados.putString("placarEquipe1J1", editPlacarEquipe1J1.getText().toString());
            dados.putString("placarEquipe1J2", editPlacarEquipe1J2.getText().toString());
            dados.putString("placarEquipe1J3", editPlacarEquipe1J3.getText().toString());
            dados.putString("placarEquipe2J1", editPlacarEquipe2J1.getText().toString());
            dados.putString("placarEquipe2J2", editPlacarEquipe2J2.getText().toString());
            dados.putString("placarEquipe2J3", editPlacarEquipe2J3.getText().toString());
            dados.putString("placarEquipe3J1", editPlacarEquipe3J1.getText().toString());
            dados.putString("placarEquipe3J2", editPlacarEquipe3J2.getText().toString());
            dados.putString("placarEquipe3J3", editPlacarEquipe3J3.getText().toString());
            dados.putString("placarEquipe4J1", editPlacarEquipe4J1.getText().toString());
            dados.putString("placarEquipe4J2", editPlacarEquipe4J2.getText().toString());
            dados.putString("placarEquipe4J3", editPlacarEquipe4J3.getText().toString());

        } else if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
            dados.putString("placarEquipe1J1", editPlacarEquipe1J1.getText().toString());
            dados.putString("placarEquipe1J2", editPlacarEquipe1J2.getText().toString());
            dados.putString("placarEquipe2J1", editPlacarEquipe2J1.getText().toString());
            dados.putString("placarEquipe2J2", editPlacarEquipe2J2.getText().toString());
            dados.putString("placarEquipe3J1", editPlacarEquipe3J1.getText().toString());
            dados.putString("placarEquipe3J2", editPlacarEquipe3J2.getText().toString());
            dados.putString("placarEquipe4J1", editPlacarEquipe4J1.getText().toString());
            dados.putString("placarEquipe4J2", editPlacarEquipe4J2.getText().toString());
            dados.putString("placarEquipe5J1", editPlacarEquipe5J1.getText().toString());
            dados.putString("placarEquipe5J2", editPlacarEquipe5J2.getText().toString());
            dados.putString("placarEquipe6J1", editPlacarEquipe6J1.getText().toString());
            dados.putString("placarEquipe6J2", editPlacarEquipe6J2.getText().toString());
            dados.putString("placarEquipe7J1", editPlacarEquipe7J1.getText().toString());
            dados.putString("placarEquipe7J2", editPlacarEquipe7J2.getText().toString());
            dados.putString("placarEquipe8J1", editPlacarEquipe8J1.getText().toString());
            dados.putString("placarEquipe8J2", editPlacarEquipe8J2.getText().toString());
            dados.putString("placarEquipe9J1", editPlacarEquipe9J1.getText().toString());
            dados.putString("placarEquipe9J2", editPlacarEquipe9J2.getText().toString());
            dados.putString("placarEquipe10J1", editPlacarEquipe10J1.getText().toString());
            dados.putString("placarEquipe10J2", editPlacarEquipe10J2.getText().toString());
            dados.putString("placarEquipe11J1", editPlacarEquipe11J1.getText().toString());
            dados.putString("placarEquipe11J2", editPlacarEquipe11J2.getText().toString());
            dados.putString("placarEquipe12J1", editPlacarEquipe12J1.getText().toString());
            dados.putString("placarEquipe12J2", editPlacarEquipe12J2.getText().toString());

        } else if (qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
            dados.putString("placarEquipe1J1", editPlacarEquipe1J1.getText().toString());
            dados.putString("placarEquipe1J2", editPlacarEquipe1J2.getText().toString());
            dados.putString("placarEquipe1J3", editPlacarEquipe1J3.getText().toString());
            dados.putString("placarEquipe2J1", editPlacarEquipe2J1.getText().toString());
            dados.putString("placarEquipe2J2", editPlacarEquipe2J2.getText().toString());
            dados.putString("placarEquipe2J3", editPlacarEquipe2J3.getText().toString());
            dados.putString("placarEquipe3J1", editPlacarEquipe3J1.getText().toString());
            dados.putString("placarEquipe3J2", editPlacarEquipe3J2.getText().toString());
            dados.putString("placarEquipe3J3", editPlacarEquipe3J3.getText().toString());
            dados.putString("placarEquipe4J1", editPlacarEquipe4J1.getText().toString());
            dados.putString("placarEquipe4J2", editPlacarEquipe4J2.getText().toString());
            dados.putString("placarEquipe4J3", editPlacarEquipe4J3.getText().toString());
            dados.putString("placarEquipe5J1", editPlacarEquipe5J1.getText().toString());
            dados.putString("placarEquipe5J2", editPlacarEquipe5J2.getText().toString());
            dados.putString("placarEquipe5J3", editPlacarEquipe5J3.getText().toString());
            dados.putString("placarEquipe6J1", editPlacarEquipe6J1.getText().toString());
            dados.putString("placarEquipe6J2", editPlacarEquipe6J2.getText().toString());
            dados.putString("placarEquipe6J3", editPlacarEquipe6J3.getText().toString());
            dados.putString("placarEquipe7J1", editPlacarEquipe7J1.getText().toString());
            dados.putString("placarEquipe7J2", editPlacarEquipe7J2.getText().toString());
            dados.putString("placarEquipe7J3", editPlacarEquipe7J3.getText().toString());
            dados.putString("placarEquipe8J1", editPlacarEquipe8J1.getText().toString());
            dados.putString("placarEquipe8J2", editPlacarEquipe8J2.getText().toString());
            dados.putString("placarEquipe8J3", editPlacarEquipe8J3.getText().toString());
            dados.putString("placarEquipe9J1", editPlacarEquipe9J1.getText().toString());
            dados.putString("placarEquipe9J2", editPlacarEquipe9J2.getText().toString());
            dados.putString("placarEquipe9J3", editPlacarEquipe9J3.getText().toString());
            dados.putString("placarEquipe10J1", editPlacarEquipe10J1.getText().toString());
            dados.putString("placarEquipe10J2", editPlacarEquipe10J2.getText().toString());
            dados.putString("placarEquipe10J3", editPlacarEquipe10J3.getText().toString());
            dados.putString("placarEquipe11J1", editPlacarEquipe11J1.getText().toString());
            dados.putString("placarEquipe11J2", editPlacarEquipe11J2.getText().toString());
            dados.putString("placarEquipe11J3", editPlacarEquipe11J3.getText().toString());
            dados.putString("placarEquipe12J1", editPlacarEquipe12J1.getText().toString());
            dados.putString("placarEquipe12J2", editPlacarEquipe12J2.getText().toString());
            dados.putString("placarEquipe12J3", editPlacarEquipe12J3.getText().toString());
            dados.putString("placarEquipe13J1", editPlacarEquipe13J1.getText().toString());
            dados.putString("placarEquipe13J2", editPlacarEquipe13J2.getText().toString());
            dados.putString("placarEquipe13J3", editPlacarEquipe13J3.getText().toString());
            dados.putString("placarEquipe14J1", editPlacarEquipe14J1.getText().toString());
            dados.putString("placarEquipe14J2", editPlacarEquipe14J2.getText().toString());
            dados.putString("placarEquipe14J3", editPlacarEquipe14J3.getText().toString());
            dados.putString("placarEquipe15J1", editPlacarEquipe15J1.getText().toString());
            dados.putString("placarEquipe15J2", editPlacarEquipe15J2.getText().toString());
            dados.putString("placarEquipe15J3", editPlacarEquipe15J3.getText().toString());
            dados.putString("placarEquipe16J1", editPlacarEquipe16J1.getText().toString());
            dados.putString("placarEquipe16J2", editPlacarEquipe16J2.getText().toString());
            dados.putString("placarEquipe16J3", editPlacarEquipe16J3.getText().toString());
        }
        dados.apply();
    }

    private void salvarSharedPreferencesClassificados() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        if (qtdEquipes == Torneio.TORNEIO_QUATRO_EQUIPES) {
            dados.putInt("primeiroAID", equipes[0].getId());
            dados.putString("nomePrimeiroA", equipes[0].getNome());
            dados.putInt("segundoAID", equipes[1].getId());
            dados.putString("nomeSegundoA", equipes[1].getNome());
            dados.putInt("terceiroID", equipes[2].getId());
            dados.putString("nomeTerceiro", equipes[2].getNome());
            dados.putBoolean("finalizouPrimeiraFase", true);

            dados.putInt("pEquipe1Final", equipes[0].getPontos());
            dados.putInt("jEquipe1Final", equipes[0].getJogos());
            dados.putInt("vEquipe1Final", equipes[0].getVitorias());
            dados.putInt("eEquipe1Final", equipes[0].getEmpates());
            dados.putInt("dEquipe1Final", equipes[0].getDerrotas());
            dados.putInt("gpEquipe1Final", equipes[0].getGolsPro());
            dados.putInt("gcEquipe1Final", equipes[0].getGolsContra());
            dados.putInt("sgEquipe1Final", equipes[0].getSaldoGols());

            dados.putInt("pEquipe2Final", equipes[1].getPontos());
            dados.putInt("jEquipe2Final", equipes[1].getJogos());
            dados.putInt("vEquipe2Final", equipes[1].getVitorias());
            dados.putInt("eEquipe2Final", equipes[1].getEmpates());
            dados.putInt("dEquipe2Final", equipes[1].getDerrotas());
            dados.putInt("gpEquipe2Final", equipes[1].getGolsPro());
            dados.putInt("gcEquipe2Final", equipes[1].getGolsContra());
            dados.putInt("sgEquipe2Final", equipes[1].getSaldoGols());

            dados.putInt("pEquipe1Class", equipe1.getPontos());
            dados.putInt("jEquipe1Class", equipe1.getJogos());
            dados.putInt("vEquipe1Class", equipe1.getVitorias());
            dados.putInt("eEquipe1Class", equipe1.getEmpates());
            dados.putInt("dEquipe1Class", equipe1.getDerrotas());
            dados.putInt("gpEquipe1Class", equipe1.getGolsPro());
            dados.putInt("gcEquipe1Class", equipe1.getGolsContra());
            dados.putInt("sgEquipe1Class", equipe1.getSaldoGols());

            dados.putInt("pEquipe2Class", equipe2.getPontos());
            dados.putInt("jEquipe2Class", equipe2.getJogos());
            dados.putInt("vEquipe2Class", equipe2.getVitorias());
            dados.putInt("eEquipe2Class", equipe2.getEmpates());
            dados.putInt("dEquipe2Class", equipe2.getDerrotas());
            dados.putInt("gpEquipe2Class", equipe2.getGolsPro());
            dados.putInt("gcEquipe2Class", equipe2.getGolsContra());
            dados.putInt("sgEquipe2Class", equipe2.getSaldoGols());

            dados.putInt("pEquipe3Class", equipe3.getPontos());
            dados.putInt("jEquipe3Class", equipe3.getJogos());
            dados.putInt("vEquipe3Class", equipe3.getVitorias());
            dados.putInt("eEquipe3Class", equipe3.getEmpates());
            dados.putInt("dEquipe3Class", equipe3.getDerrotas());
            dados.putInt("gpEquipe3Class", equipe3.getGolsPro());
            dados.putInt("gcEquipe3Class", equipe3.getGolsContra());
            dados.putInt("sgEquipe3Class", equipe3.getSaldoGols());

            dados.putInt("pEquipe4Class", equipe4.getPontos());
            dados.putInt("jEquipe4Class", equipe4.getJogos());
            dados.putInt("vEquipe4Class", equipe4.getVitorias());
            dados.putInt("eEquipe4Class", equipe4.getEmpates());
            dados.putInt("dEquipe4Class", equipe4.getDerrotas());
            dados.putInt("gpEquipe4Class", equipe4.getGolsPro());
            dados.putInt("gcEquipe4Class", equipe4.getGolsContra());
            dados.putInt("sgEquipe4Class", equipe4.getSaldoGols());

        } else if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
            dados.putInt("primeiroAID", equipesA[0].getId());
            dados.putString("nomePrimeiroA", equipesA[0].getNome());
            dados.putInt("segundoAID", equipesA[1].getId());
            dados.putString("nomeSegundoA", equipesA[1].getNome());
            dados.putInt("terceiroAID", equipesA[2].getId());
            dados.putString("nomeTerceiroA", equipesA[2].getNome());
            dados.putInt("primeiroBID", equipesB[0].getId());
            dados.putString("nomePrimeiroB", equipesB[0].getNome());
            dados.putInt("segundoBID", equipesB[1].getId());
            dados.putString("nomeSegundoB", equipesB[1].getNome());
            dados.putInt("terceiroBID", equipesB[2].getId());
            dados.putString("nomeTerceiroB", equipesB[2].getNome());
            dados.putInt("primeiroCID", equipesC[0].getId());
            dados.putString("nomePrimeiroC", equipesC[0].getNome());
            dados.putInt("segundoCID", equipesC[1].getId());
            dados.putString("nomeSegundoC", equipesC[1].getNome());
            dados.putInt("terceiroCID", equipesC[2].getId());
            dados.putString("nomeTerceiroC", equipesC[2].getNome());
            dados.putInt("primeiroDID", equipesD[0].getId());
            dados.putString("nomePrimeiroD", equipesD[0].getNome());
            dados.putInt("segundoDID", equipesD[1].getId());
            dados.putString("nomeSegundoD", equipesD[1].getNome());
            dados.putInt("terceiroDID", equipesD[2].getId());
            dados.putString("nomeTerceiroD", equipesD[2].getNome());
            dados.putBoolean("finalizouPrimeiraFase", true);

            dados.putInt("pEquipe1Quartas", equipesA[0].getPontos());
            dados.putInt("jEquipe1Quartas", equipesA[0].getJogos());
            dados.putInt("vEquipe1Quartas", equipesA[0].getVitorias());
            dados.putInt("eEquipe1Quartas", equipesA[0].getEmpates());
            dados.putInt("dEquipe1Quartas", equipesA[0].getDerrotas());
            dados.putInt("gpEquipe1Quartas", equipesA[0].getGolsPro());
            dados.putInt("gcEquipe1Quartas", equipesA[0].getGolsContra());
            dados.putInt("sgEquipe1Quartas", equipesA[0].getSaldoGols());

            dados.putInt("pEquipe2Quartas", equipesA[1].getPontos());
            dados.putInt("jEquipe2Quartas", equipesA[1].getJogos());
            dados.putInt("vEquipe2Quartas", equipesA[1].getVitorias());
            dados.putInt("eEquipe2Quartas", equipesA[1].getEmpates());
            dados.putInt("dEquipe2Quartas", equipesA[1].getDerrotas());
            dados.putInt("gpEquipe2Quartas", equipesA[1].getGolsPro());
            dados.putInt("gcEquipe2Quartas", equipesA[1].getGolsContra());
            dados.putInt("sgEquipe2Quartas", equipesA[1].getSaldoGols());

            dados.putInt("pEquipe3Quartas", equipesB[0].getPontos());
            dados.putInt("jEquipe3Quartas", equipesB[0].getJogos());
            dados.putInt("vEquipe3Quartas", equipesB[0].getVitorias());
            dados.putInt("eEquipe3Quartas", equipesB[0].getEmpates());
            dados.putInt("dEquipe3Quartas", equipesB[0].getDerrotas());
            dados.putInt("gpEquipe3Quartas", equipesB[0].getGolsPro());
            dados.putInt("gcEquipe3Quartas", equipesB[0].getGolsContra());
            dados.putInt("sgEquipe3Quartas", equipesB[0].getSaldoGols());

            dados.putInt("pEquipe4Quartas", equipesB[1].getPontos());
            dados.putInt("jEquipe4Quartas", equipesB[1].getJogos());
            dados.putInt("vEquipe4Quartas", equipesB[1].getVitorias());
            dados.putInt("eEquipe4Quartas", equipesB[1].getEmpates());
            dados.putInt("dEquipe4Quartas", equipesB[1].getDerrotas());
            dados.putInt("gpEquipe4Quartas", equipesB[1].getGolsPro());
            dados.putInt("gcEquipe4Quartas", equipesB[1].getGolsContra());
            dados.putInt("sgEquipe4Quartas", equipesB[1].getSaldoGols());

            dados.putInt("pEquipe5Quartas", equipesC[0].getPontos());
            dados.putInt("jEquipe5Quartas", equipesC[0].getJogos());
            dados.putInt("vEquipe5Quartas", equipesC[0].getVitorias());
            dados.putInt("eEquipe5Quartas", equipesC[0].getEmpates());
            dados.putInt("dEquipe5Quartas", equipesC[0].getDerrotas());
            dados.putInt("gpEquipe5Quartas", equipesC[0].getGolsPro());
            dados.putInt("gcEquipe5Quartas", equipesC[0].getGolsContra());
            dados.putInt("sgEquipe5Quartas", equipesC[0].getSaldoGols());

            dados.putInt("pEquipe6Quartas", equipesC[1].getPontos());
            dados.putInt("jEquipe6Quartas", equipesC[1].getJogos());
            dados.putInt("vEquipe6Quartas", equipesC[1].getVitorias());
            dados.putInt("eEquipe6Quartas", equipesC[1].getEmpates());
            dados.putInt("dEquipe6Quartas", equipesC[1].getDerrotas());
            dados.putInt("gpEquipe6Quartas", equipesC[1].getGolsPro());
            dados.putInt("gcEquipe6Quartas", equipesC[1].getGolsContra());
            dados.putInt("sgEquipe6Quartas", equipesC[1].getSaldoGols());

            dados.putInt("pEquipe7Quartas", equipesD[0].getPontos());
            dados.putInt("jEquipe7Quartas", equipesD[0].getJogos());
            dados.putInt("vEquipe7Quartas", equipesD[0].getVitorias());
            dados.putInt("eEquipe7Quartas", equipesD[0].getEmpates());
            dados.putInt("dEquipe7Quartas", equipesD[0].getDerrotas());
            dados.putInt("gpEquipe7Quartas", equipesD[0].getGolsPro());
            dados.putInt("gcEquipe7Quartas", equipesD[0].getGolsContra());
            dados.putInt("sgEquipe7Quartas", equipesD[0].getSaldoGols());

            dados.putInt("pEquipe8Quartas", equipesD[1].getPontos());
            dados.putInt("jEquipe8Quartas", equipesD[1].getJogos());
            dados.putInt("vEquipe8Quartas", equipesD[1].getVitorias());
            dados.putInt("eEquipe8Quartas", equipesD[1].getEmpates());
            dados.putInt("dEquipe8Quartas", equipesD[1].getDerrotas());
            dados.putInt("gpEquipe8Quartas", equipesD[1].getGolsPro());
            dados.putInt("gcEquipe8Quartas", equipesD[1].getGolsContra());
            dados.putInt("sgEquipe8Quartas", equipesD[1].getSaldoGols());

            dados.putInt("pEquipe1Class", equipe1.getPontos());
            dados.putInt("jEquipe1Class", equipe1.getJogos());
            dados.putInt("vEquipe1Class", equipe1.getVitorias());
            dados.putInt("eEquipe1Class", equipe1.getEmpates());
            dados.putInt("dEquipe1Class", equipe1.getDerrotas());
            dados.putInt("gpEquipe1Class", equipe1.getGolsPro());
            dados.putInt("gcEquipe1Class", equipe1.getGolsContra());
            dados.putInt("sgEquipe1Class", equipe1.getSaldoGols());

            dados.putInt("pEquipe2Class", equipe2.getPontos());
            dados.putInt("jEquipe2Class", equipe2.getJogos());
            dados.putInt("vEquipe2Class", equipe2.getVitorias());
            dados.putInt("eEquipe2Class", equipe2.getEmpates());
            dados.putInt("dEquipe2Class", equipe2.getDerrotas());
            dados.putInt("gpEquipe2Class", equipe2.getGolsPro());
            dados.putInt("gcEquipe2Class", equipe2.getGolsContra());
            dados.putInt("sgEquipe2Class", equipe2.getSaldoGols());

            dados.putInt("pEquipe3Class", equipe3.getPontos());
            dados.putInt("jEquipe3Class", equipe3.getJogos());
            dados.putInt("vEquipe3Class", equipe3.getVitorias());
            dados.putInt("eEquipe3Class", equipe3.getEmpates());
            dados.putInt("dEquipe3Class", equipe3.getDerrotas());
            dados.putInt("gpEquipe3Class", equipe3.getGolsPro());
            dados.putInt("gcEquipe3Class", equipe3.getGolsContra());
            dados.putInt("sgEquipe3Class", equipe3.getSaldoGols());

            dados.putInt("pEquipe4Class", equipe4.getPontos());
            dados.putInt("jEquipe4Class", equipe4.getJogos());
            dados.putInt("vEquipe4Class", equipe4.getVitorias());
            dados.putInt("eEquipe4Class", equipe4.getEmpates());
            dados.putInt("dEquipe4Class", equipe4.getDerrotas());
            dados.putInt("gpEquipe4Class", equipe4.getGolsPro());
            dados.putInt("gcEquipe4Class", equipe4.getGolsContra());
            dados.putInt("sgEquipe4Class", equipe4.getSaldoGols());

            dados.putInt("pEquipe5Class", equipe5.getPontos());
            dados.putInt("jEquipe5Class", equipe5.getJogos());
            dados.putInt("vEquipe5Class", equipe5.getVitorias());
            dados.putInt("eEquipe5Class", equipe5.getEmpates());
            dados.putInt("dEquipe5Class", equipe5.getDerrotas());
            dados.putInt("gpEquipe5Class", equipe5.getGolsPro());
            dados.putInt("gcEquipe5Class", equipe5.getGolsContra());
            dados.putInt("sgEquipe5Class", equipe5.getSaldoGols());

            dados.putInt("pEquipe6Class", equipe6.getPontos());
            dados.putInt("jEquipe6Class", equipe6.getJogos());
            dados.putInt("vEquipe6Class", equipe6.getVitorias());
            dados.putInt("eEquipe6Class", equipe6.getEmpates());
            dados.putInt("dEquipe6Class", equipe6.getDerrotas());
            dados.putInt("gpEquipe6Class", equipe6.getGolsPro());
            dados.putInt("gcEquipe6Class", equipe6.getGolsContra());
            dados.putInt("sgEquipe6Class", equipe6.getSaldoGols());

            dados.putInt("pEquipe7Class", equipe7.getPontos());
            dados.putInt("jEquipe7Class", equipe7.getJogos());
            dados.putInt("vEquipe7Class", equipe7.getVitorias());
            dados.putInt("eEquipe7Class", equipe7.getEmpates());
            dados.putInt("dEquipe7Class", equipe7.getDerrotas());
            dados.putInt("gpEquipe7Class", equipe7.getGolsPro());
            dados.putInt("gcEquipe7Class", equipe7.getGolsContra());
            dados.putInt("sgEquipe7Class", equipe7.getSaldoGols());

            dados.putInt("pEquipe8Class", equipe8.getPontos());
            dados.putInt("jEquipe8Class", equipe8.getJogos());
            dados.putInt("vEquipe8Class", equipe8.getVitorias());
            dados.putInt("eEquipe8Class", equipe8.getEmpates());
            dados.putInt("dEquipe8Class", equipe8.getDerrotas());
            dados.putInt("gpEquipe8Class", equipe8.getGolsPro());
            dados.putInt("gcEquipe8Class", equipe8.getGolsContra());
            dados.putInt("sgEquipe8Class", equipe8.getSaldoGols());

            dados.putInt("pEquipe9Class", equipe9.getPontos());
            dados.putInt("jEquipe9Class", equipe9.getJogos());
            dados.putInt("vEquipe9Class", equipe9.getVitorias());
            dados.putInt("eEquipe9Class", equipe9.getEmpates());
            dados.putInt("dEquipe9Class", equipe9.getDerrotas());
            dados.putInt("gpEquipe9Class", equipe9.getGolsPro());
            dados.putInt("gcEquipe9Class", equipe9.getGolsContra());
            dados.putInt("sgEquipe9Class", equipe9.getSaldoGols());

            dados.putInt("pEquipe10Class", equipe10.getPontos());
            dados.putInt("jEquipe10Class", equipe10.getJogos());
            dados.putInt("vEquipe10Class", equipe10.getVitorias());
            dados.putInt("eEquipe10Class", equipe10.getEmpates());
            dados.putInt("dEquipe10Class", equipe10.getDerrotas());
            dados.putInt("gpEquipe10Class", equipe10.getGolsPro());
            dados.putInt("gcEquipe10Class", equipe10.getGolsContra());
            dados.putInt("sgEquipe10Class", equipe10.getSaldoGols());

            dados.putInt("pEquipe11Class", equipe11.getPontos());
            dados.putInt("jEquipe11Class", equipe11.getJogos());
            dados.putInt("vEquipe11Class", equipe11.getVitorias());
            dados.putInt("eEquipe11Class", equipe11.getEmpates());
            dados.putInt("dEquipe11Class", equipe11.getDerrotas());
            dados.putInt("gpEquipe11Class", equipe11.getGolsPro());
            dados.putInt("gcEquipe11Class", equipe11.getGolsContra());
            dados.putInt("sgEquipe11Class", equipe11.getSaldoGols());

            dados.putInt("pEquipe12Class", equipe12.getPontos());
            dados.putInt("jEquipe12Class", equipe12.getJogos());
            dados.putInt("vEquipe12Class", equipe12.getVitorias());
            dados.putInt("eEquipe12Class", equipe12.getEmpates());
            dados.putInt("dEquipe12Class", equipe12.getDerrotas());
            dados.putInt("gpEquipe12Class", equipe12.getGolsPro());
            dados.putInt("gcEquipe12Class", equipe12.getGolsContra());
            dados.putInt("sgEquipe12Class", equipe12.getSaldoGols());

        } else if (qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
            dados.putInt("primeiroAID", equipesA[0].getId());
            dados.putString("nomePrimeiroA", equipesA[0].getNome());
            dados.putInt("segundoAID", equipesA[1].getId());
            dados.putString("nomeSegundoA", equipesA[1].getNome());
            dados.putInt("terceiroAID", equipesA[2].getId());
            dados.putString("nomeTerceiroA", equipesA[2].getNome());
            dados.putInt("primeiroBID", equipesB[0].getId());
            dados.putString("nomePrimeiroB", equipesB[0].getNome());
            dados.putInt("segundoBID", equipesB[1].getId());
            dados.putString("nomeSegundoB", equipesB[1].getNome());
            dados.putInt("terceiroBID", equipesB[2].getId());
            dados.putString("nomeTerceiroB", equipesB[2].getNome());
            dados.putInt("primeiroCID", equipesC[0].getId());
            dados.putString("nomePrimeiroC", equipesC[0].getNome());
            dados.putInt("segundoCID", equipesC[1].getId());
            dados.putString("nomeSegundoC", equipesC[1].getNome());
            dados.putInt("terceiroCID", equipesC[2].getId());
            dados.putString("nomeTerceiroC", equipesC[2].getNome());
            dados.putInt("primeiroDID", equipesD[0].getId());
            dados.putString("nomePrimeiroD", equipesD[0].getNome());
            dados.putInt("segundoDID", equipesD[1].getId());
            dados.putString("nomeSegundoD", equipesD[1].getNome());
            dados.putInt("terceiroDID", equipesD[2].getId());
            dados.putString("nomeTerceiroD", equipesD[2].getNome());
            dados.putBoolean("finalizouPrimeiraFase", true);

            dados.putInt("pEquipe1Quartas", equipesA[0].getPontos());
            dados.putInt("jEquipe1Quartas", equipesA[0].getJogos());
            dados.putInt("vEquipe1Quartas", equipesA[0].getVitorias());
            dados.putInt("eEquipe1Quartas", equipesA[0].getEmpates());
            dados.putInt("dEquipe1Quartas", equipesA[0].getDerrotas());
            dados.putInt("gpEquipe1Quartas", equipesA[0].getGolsPro());
            dados.putInt("gcEquipe1Quartas", equipesA[0].getGolsContra());
            dados.putInt("sgEquipe1Quartas", equipesA[0].getSaldoGols());

            dados.putInt("pEquipe2Quartas", equipesA[1].getPontos());
            dados.putInt("jEquipe2Quartas", equipesA[1].getJogos());
            dados.putInt("vEquipe2Quartas", equipesA[1].getVitorias());
            dados.putInt("eEquipe2Quartas", equipesA[1].getEmpates());
            dados.putInt("dEquipe2Quartas", equipesA[1].getDerrotas());
            dados.putInt("gpEquipe2Quartas", equipesA[1].getGolsPro());
            dados.putInt("gcEquipe2Quartas", equipesA[1].getGolsContra());
            dados.putInt("sgEquipe2Quartas", equipesA[1].getSaldoGols());

            dados.putInt("pEquipe3Quartas", equipesB[0].getPontos());
            dados.putInt("jEquipe3Quartas", equipesB[0].getJogos());
            dados.putInt("vEquipe3Quartas", equipesB[0].getVitorias());
            dados.putInt("eEquipe3Quartas", equipesB[0].getEmpates());
            dados.putInt("dEquipe3Quartas", equipesB[0].getDerrotas());
            dados.putInt("gpEquipe3Quartas", equipesB[0].getGolsPro());
            dados.putInt("gcEquipe3Quartas", equipesB[0].getGolsContra());
            dados.putInt("sgEquipe3Quartas", equipesB[0].getSaldoGols());

            dados.putInt("pEquipe4Quartas", equipesB[1].getPontos());
            dados.putInt("jEquipe4Quartas", equipesB[1].getJogos());
            dados.putInt("vEquipe4Quartas", equipesB[1].getVitorias());
            dados.putInt("eEquipe4Quartas", equipesB[1].getEmpates());
            dados.putInt("dEquipe4Quartas", equipesB[1].getDerrotas());
            dados.putInt("gpEquipe4Quartas", equipesB[1].getGolsPro());
            dados.putInt("gcEquipe4Quartas", equipesB[1].getGolsContra());
            dados.putInt("sgEquipe4Quartas", equipesB[1].getSaldoGols());

            dados.putInt("pEquipe5Quartas", equipesC[0].getPontos());
            dados.putInt("jEquipe5Quartas", equipesC[0].getJogos());
            dados.putInt("vEquipe5Quartas", equipesC[0].getVitorias());
            dados.putInt("eEquipe5Quartas", equipesC[0].getEmpates());
            dados.putInt("dEquipe5Quartas", equipesC[0].getDerrotas());
            dados.putInt("gpEquipe5Quartas", equipesC[0].getGolsPro());
            dados.putInt("gcEquipe5Quartas", equipesC[0].getGolsContra());
            dados.putInt("sgEquipe5Quartas", equipesC[0].getSaldoGols());

            dados.putInt("pEquipe6Quartas", equipesC[1].getPontos());
            dados.putInt("jEquipe6Quartas", equipesC[1].getJogos());
            dados.putInt("vEquipe6Quartas", equipesC[1].getVitorias());
            dados.putInt("eEquipe6Quartas", equipesC[1].getEmpates());
            dados.putInt("dEquipe6Quartas", equipesC[1].getDerrotas());
            dados.putInt("gpEquipe6Quartas", equipesC[1].getGolsPro());
            dados.putInt("gcEquipe6Quartas", equipesC[1].getGolsContra());
            dados.putInt("sgEquipe6Quartas", equipesC[1].getSaldoGols());

            dados.putInt("pEquipe7Quartas", equipesD[0].getPontos());
            dados.putInt("jEquipe7Quartas", equipesD[0].getJogos());
            dados.putInt("vEquipe7Quartas", equipesD[0].getVitorias());
            dados.putInt("eEquipe7Quartas", equipesD[0].getEmpates());
            dados.putInt("dEquipe7Quartas", equipesD[0].getDerrotas());
            dados.putInt("gpEquipe7Quartas", equipesD[0].getGolsPro());
            dados.putInt("gcEquipe7Quartas", equipesD[0].getGolsContra());
            dados.putInt("sgEquipe7Quartas", equipesD[0].getSaldoGols());

            dados.putInt("pEquipe8Quartas", equipesD[1].getPontos());
            dados.putInt("jEquipe8Quartas", equipesD[1].getJogos());
            dados.putInt("vEquipe8Quartas", equipesD[1].getVitorias());
            dados.putInt("eEquipe8Quartas", equipesD[1].getEmpates());
            dados.putInt("dEquipe8Quartas", equipesD[1].getDerrotas());
            dados.putInt("gpEquipe8Quartas", equipesD[1].getGolsPro());
            dados.putInt("gcEquipe8Quartas", equipesD[1].getGolsContra());
            dados.putInt("sgEquipe8Quartas", equipesD[1].getSaldoGols());

            dados.putInt("pEquipe1Class", equipe1.getPontos());
            dados.putInt("jEquipe1Class", equipe1.getJogos());
            dados.putInt("vEquipe1Class", equipe1.getVitorias());
            dados.putInt("eEquipe1Class", equipe1.getEmpates());
            dados.putInt("dEquipe1Class", equipe1.getDerrotas());
            dados.putInt("gpEquipe1Class", equipe1.getGolsPro());
            dados.putInt("gcEquipe1Class", equipe1.getGolsContra());
            dados.putInt("sgEquipe1Class", equipe1.getSaldoGols());

            dados.putInt("pEquipe2Class", equipe2.getPontos());
            dados.putInt("jEquipe2Class", equipe2.getJogos());
            dados.putInt("vEquipe2Class", equipe2.getVitorias());
            dados.putInt("eEquipe2Class", equipe2.getEmpates());
            dados.putInt("dEquipe2Class", equipe2.getDerrotas());
            dados.putInt("gpEquipe2Class", equipe2.getGolsPro());
            dados.putInt("gcEquipe2Class", equipe2.getGolsContra());
            dados.putInt("sgEquipe2Class", equipe2.getSaldoGols());

            dados.putInt("pEquipe3Class", equipe3.getPontos());
            dados.putInt("jEquipe3Class", equipe3.getJogos());
            dados.putInt("vEquipe3Class", equipe3.getVitorias());
            dados.putInt("eEquipe3Class", equipe3.getEmpates());
            dados.putInt("dEquipe3Class", equipe3.getDerrotas());
            dados.putInt("gpEquipe3Class", equipe3.getGolsPro());
            dados.putInt("gcEquipe3Class", equipe3.getGolsContra());
            dados.putInt("sgEquipe3Class", equipe3.getSaldoGols());

            dados.putInt("pEquipe4Class", equipe4.getPontos());
            dados.putInt("jEquipe4Class", equipe4.getJogos());
            dados.putInt("vEquipe4Class", equipe4.getVitorias());
            dados.putInt("eEquipe4Class", equipe4.getEmpates());
            dados.putInt("dEquipe4Class", equipe4.getDerrotas());
            dados.putInt("gpEquipe4Class", equipe4.getGolsPro());
            dados.putInt("gcEquipe4Class", equipe4.getGolsContra());
            dados.putInt("sgEquipe4Class", equipe4.getSaldoGols());

            dados.putInt("pEquipe5Class", equipe5.getPontos());
            dados.putInt("jEquipe5Class", equipe5.getJogos());
            dados.putInt("vEquipe5Class", equipe5.getVitorias());
            dados.putInt("eEquipe5Class", equipe5.getEmpates());
            dados.putInt("dEquipe5Class", equipe5.getDerrotas());
            dados.putInt("gpEquipe5Class", equipe5.getGolsPro());
            dados.putInt("gcEquipe5Class", equipe5.getGolsContra());
            dados.putInt("sgEquipe5Class", equipe5.getSaldoGols());

            dados.putInt("pEquipe6Class", equipe6.getPontos());
            dados.putInt("jEquipe6Class", equipe6.getJogos());
            dados.putInt("vEquipe6Class", equipe6.getVitorias());
            dados.putInt("eEquipe6Class", equipe6.getEmpates());
            dados.putInt("dEquipe6Class", equipe6.getDerrotas());
            dados.putInt("gpEquipe6Class", equipe6.getGolsPro());
            dados.putInt("gcEquipe6Class", equipe6.getGolsContra());
            dados.putInt("sgEquipe6Class", equipe6.getSaldoGols());

            dados.putInt("pEquipe7Class", equipe7.getPontos());
            dados.putInt("jEquipe7Class", equipe7.getJogos());
            dados.putInt("vEquipe7Class", equipe7.getVitorias());
            dados.putInt("eEquipe7Class", equipe7.getEmpates());
            dados.putInt("dEquipe7Class", equipe7.getDerrotas());
            dados.putInt("gpEquipe7Class", equipe7.getGolsPro());
            dados.putInt("gcEquipe7Class", equipe7.getGolsContra());
            dados.putInt("sgEquipe7Class", equipe7.getSaldoGols());

            dados.putInt("pEquipe8Class", equipe8.getPontos());
            dados.putInt("jEquipe8Class", equipe8.getJogos());
            dados.putInt("vEquipe8Class", equipe8.getVitorias());
            dados.putInt("eEquipe8Class", equipe8.getEmpates());
            dados.putInt("dEquipe8Class", equipe8.getDerrotas());
            dados.putInt("gpEquipe8Class", equipe8.getGolsPro());
            dados.putInt("gcEquipe8Class", equipe8.getGolsContra());
            dados.putInt("sgEquipe8Class", equipe8.getSaldoGols());

            dados.putInt("pEquipe9Class", equipe9.getPontos());
            dados.putInt("jEquipe9Class", equipe9.getJogos());
            dados.putInt("vEquipe9Class", equipe9.getVitorias());
            dados.putInt("eEquipe9Class", equipe9.getEmpates());
            dados.putInt("dEquipe9Class", equipe9.getDerrotas());
            dados.putInt("gpEquipe9Class", equipe9.getGolsPro());
            dados.putInt("gcEquipe9Class", equipe9.getGolsContra());
            dados.putInt("sgEquipe9Class", equipe9.getSaldoGols());

            dados.putInt("pEquipe10Class", equipe10.getPontos());
            dados.putInt("jEquipe10Class", equipe10.getJogos());
            dados.putInt("vEquipe10Class", equipe10.getVitorias());
            dados.putInt("eEquipe10Class", equipe10.getEmpates());
            dados.putInt("dEquipe10Class", equipe10.getDerrotas());
            dados.putInt("gpEquipe10Class", equipe10.getGolsPro());
            dados.putInt("gcEquipe10Class", equipe10.getGolsContra());
            dados.putInt("sgEquipe10Class", equipe10.getSaldoGols());

            dados.putInt("pEquipe11Class", equipe11.getPontos());
            dados.putInt("jEquipe11Class", equipe11.getJogos());
            dados.putInt("vEquipe11Class", equipe11.getVitorias());
            dados.putInt("eEquipe11Class", equipe11.getEmpates());
            dados.putInt("dEquipe11Class", equipe11.getDerrotas());
            dados.putInt("gpEquipe11Class", equipe11.getGolsPro());
            dados.putInt("gcEquipe11Class", equipe11.getGolsContra());
            dados.putInt("sgEquipe11Class", equipe11.getSaldoGols());

            dados.putInt("pEquipe12Class", equipe12.getPontos());
            dados.putInt("jEquipe12Class", equipe12.getJogos());
            dados.putInt("vEquipe12Class", equipe12.getVitorias());
            dados.putInt("eEquipe12Class", equipe12.getEmpates());
            dados.putInt("dEquipe12Class", equipe12.getDerrotas());
            dados.putInt("gpEquipe12Class", equipe12.getGolsPro());
            dados.putInt("gcEquipe12Class", equipe12.getGolsContra());
            dados.putInt("sgEquipe12Class", equipe12.getSaldoGols());

            dados.putInt("pEquipe13Class", equipe13.getPontos());
            dados.putInt("jEquipe13Class", equipe13.getJogos());
            dados.putInt("vEquipe13Class", equipe13.getVitorias());
            dados.putInt("eEquipe13Class", equipe13.getEmpates());
            dados.putInt("dEquipe13Class", equipe13.getDerrotas());
            dados.putInt("gpEquipe13Class", equipe13.getGolsPro());
            dados.putInt("gcEquipe13Class", equipe13.getGolsContra());
            dados.putInt("sgEquipe13Class", equipe13.getSaldoGols());

            dados.putInt("pEquipe14Class", equipe14.getPontos());
            dados.putInt("jEquipe14Class", equipe14.getJogos());
            dados.putInt("vEquipe14Class", equipe14.getVitorias());
            dados.putInt("eEquipe14Class", equipe14.getEmpates());
            dados.putInt("dEquipe14Class", equipe14.getDerrotas());
            dados.putInt("gpEquipe14Class", equipe14.getGolsPro());
            dados.putInt("gcEquipe14Class", equipe14.getGolsContra());
            dados.putInt("sgEquipe14Class", equipe14.getSaldoGols());

            dados.putInt("pEquipe15Class", equipe15.getPontos());
            dados.putInt("jEquipe15Class", equipe15.getJogos());
            dados.putInt("vEquipe15Class", equipe15.getVitorias());
            dados.putInt("eEquipe15Class", equipe15.getEmpates());
            dados.putInt("dEquipe15Class", equipe15.getDerrotas());
            dados.putInt("gpEquipe15Class", equipe15.getGolsPro());
            dados.putInt("gcEquipe15Class", equipe15.getGolsContra());
            dados.putInt("sgEquipe15Class", equipe15.getSaldoGols());

            dados.putInt("pEquipe16Class", equipe16.getPontos());
            dados.putInt("jEquipe16Class", equipe16.getJogos());
            dados.putInt("vEquipe16Class", equipe16.getVitorias());
            dados.putInt("eEquipe16Class", equipe16.getEmpates());
            dados.putInt("dEquipe16Class", equipe16.getDerrotas());
            dados.putInt("gpEquipe16Class", equipe16.getGolsPro());
            dados.putInt("gcEquipe16Class", equipe16.getGolsContra());
            dados.putInt("sgEquipe16Class", equipe16.getSaldoGols());
        }
        dados.apply();
    }

    private void salvarStatusFaseSharedPreferences() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putBoolean("finalizouPrimeiraFase", false);
        dados.apply();
    }

}