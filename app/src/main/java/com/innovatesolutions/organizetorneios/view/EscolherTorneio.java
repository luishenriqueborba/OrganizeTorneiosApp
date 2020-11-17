package com.innovatesolutions.organizetorneios.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.api.AppUtil;
import com.innovatesolutions.organizetorneios.model.Usuario;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;
import com.shashank.sony.fancydialoglib.Icon;

public class EscolherTorneio extends AppCompatActivity {

    private long backPressedTime;

    private PublisherAdView mPublisherAdView;

    private PublisherInterstitialAd mPublisherInterstitialAd;

    Usuario usuario;

    private SharedPreferences preferences;

    int qtdEquipes;

    String nomeEquipe1;

    TextView txtNomeUsuario;
    Button btnQuatroEquipes, btnDozeEquipes, btnDezesseisEquipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_torneio);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        mPublisherInterstitialAd = new PublisherInterstitialAd(this);
        mPublisherInterstitialAd.setAdUnitId(getString(R.string.anuncioIntersticial1));
        mPublisherInterstitialAd.loadAd(new PublisherAdRequest.Builder().build());

        mPublisherAdView = findViewById(R.id.publisherAdView);
        AdSize adSize = new AdSize(300, 50);
        mPublisherAdView.setAdSizes(adSize);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mPublisherAdView.loadAd(adRequest);

        initFormulario();

        verificaTorneioAnterior();

        btnQuatroEquipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                qtdEquipes = 4;

                salvarSharedPreferences();

                if (mPublisherInterstitialAd.isLoaded()) {
                    mPublisherInterstitialAd.show();

                    mPublisherInterstitialAd.setAdListener(new AdListener() {
                        @Override
                        public void onAdClosed() {

                            Intent novaTela = new Intent(EscolherTorneio.this, CadastrarGrupos.class);
                            startActivity(novaTela);
                            finish();
                            return;
                        }

                    });


                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");

                    Intent novaTela = new Intent(EscolherTorneio.this, CadastrarGrupos.class);
                    startActivity(novaTela);
                    finish();
                    return;
                }

            }
        });

        btnDozeEquipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                qtdEquipes = 12;

                salvarSharedPreferences();

                if (mPublisherInterstitialAd.isLoaded()) {
                    mPublisherInterstitialAd.show();

                    mPublisherInterstitialAd.setAdListener(new AdListener() {
                        @Override
                        public void onAdClosed() {

                            Intent novaTela = new Intent(EscolherTorneio.this, CadastrarGrupos.class);
                            startActivity(novaTela);
                            finish();
                            return;
                        }

                    });

                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");

                    Intent novaTela = new Intent(EscolherTorneio.this, CadastrarGrupos.class);
                    startActivity(novaTela);
                    finish();
                    return;
                }

            }
        });

        btnDezesseisEquipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                qtdEquipes = 16;

                salvarSharedPreferences();

                Intent novaTela = new Intent(EscolherTorneio.this, CadastrarGrupos.class);
                startActivity(novaTela);
                finish();
                return;

            }
        });
    }

    private void initFormulario() {

        txtNomeUsuario = findViewById(R.id.txtNomeUsuario);
        btnQuatroEquipes = findViewById(R.id.btnQuatroEquipes);
        btnDozeEquipes = findViewById(R.id.btnDozeEquipes);
        btnDezesseisEquipes = findViewById(R.id.btnDezesseisEquipes);

        usuario = new Usuario();

        restaurarSharedPreferences();

        txtNomeUsuario.setText("Bem vindo, " + usuario.getNome() + ".");
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

    private void verificaTorneioAnterior() {

        if (nomeEquipe1 != "") {

            new FancyAlertDialog.Builder(this)
                    .setTitle("ATENÇÃO")
                    .setBackgroundColor(Color.parseColor("#303F9F"))
                    .setMessage("Você havia iniciado um torneio anteriormente!\nDeseja continuá-lo?")
                    .setNegativeBtnText("NÃO")
                    .setNegativeBtnBackground(Color.parseColor("#FF4081"))
                    .setPositiveBtnText("SIM")
                    .setPositiveBtnBackground(Color.parseColor("#4ECA25"))
                    .isCancellable(true)
                    .setIcon(R.mipmap.ic_launcher_round, Icon.Visible)
                    .OnPositiveClicked(new FancyAlertDialogListener() {
                        @Override
                        public void OnClick() {
                            Toast.makeText(getApplicationContext(), "Continue seu torneio...", Toast.LENGTH_SHORT).show();

                            Intent novaTela = new Intent(EscolherTorneio.this, Dashboard.class);
                            novaTela.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(novaTela);
                            finish();
                            return;

                        }
                    })
                    .OnNegativeClicked(new FancyAlertDialogListener() {
                        @Override
                        public void OnClick() {
                            Toast.makeText(getApplicationContext(), "OK, inicie um novo torneio...", Toast.LENGTH_SHORT).show();

                        }
                    })
                    .build();
        }
    }

    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("qtdEquipes", qtdEquipes);
        dados.putInt("equipe1ID", -1);
        dados.putInt("equipe2ID", -1);
        dados.putInt("equipe3ID", -1);
        dados.putInt("equipe4ID", -1);
        dados.putInt("equipe5ID", -1);
        dados.putInt("equipe6ID", -1);
        dados.putInt("equipe7ID", -1);
        dados.putInt("equipe8ID", -1);
        dados.putInt("equipe9ID", -1);
        dados.putInt("equipe10ID", -1);
        dados.putInt("equipe11ID", -1);
        dados.putInt("equipe12ID", -1);
        dados.putInt("equipe13ID", -1);
        dados.putInt("equipe14ID", -1);
        dados.putInt("equipe15ID", -1);
        dados.putInt("equipe16ID", -1);
        dados.putString("nomeEquipe1", "");
        dados.putString("nomeEquipe2", "");
        dados.putString("nomeEquipe3", "");
        dados.putString("nomeEquipe4", "");
        dados.putString("nomeEquipe5", "");
        dados.putString("nomeEquipe6", "");
        dados.putString("nomeEquipe7", "");
        dados.putString("nomeEquipe8", "");
        dados.putString("nomeEquipe9", "");
        dados.putString("nomeEquipe10", "");
        dados.putString("nomeEquipe11", "");
        dados.putString("nomeEquipe12", "");
        dados.putString("nomeEquipe13", "");
        dados.putString("nomeEquipe14", "");
        dados.putString("nomeEquipe15", "");
        dados.putString("nomeEquipe16", "");
        dados.putInt("grupoID", -1);
        dados.putInt("grupo1ID", -1);
        dados.putInt("grupo2ID", -1);
        dados.putInt("grupo3ID", -1);
        dados.putInt("grupo4ID", -1);
        dados.putString("nomeGrupo", "");
        dados.putString("nomeGrupo1", "");
        dados.putString("nomeGrupo2", "");
        dados.putString("nomeGrupo3", "");
        dados.putString("nomeGrupo4", "");
        dados.putBoolean("finalizouPrimeiraFase", false);
        dados.putBoolean("finalizouQuartas", false);
        dados.putBoolean("finalizouSemi", false);
        dados.putBoolean("finalizouTerceiro", false);
        dados.putBoolean("finalizouFinal", false);
        dados.putString("placarEquipe1J1", "");
        dados.putString("placarEquipe1J2", "");
        dados.putString("placarEquipe1J3", "");
        dados.putString("placarEquipe2J1", "");
        dados.putString("placarEquipe2J2", "");
        dados.putString("placarEquipe2J3", "");
        dados.putString("placarEquipe3J1", "");
        dados.putString("placarEquipe3J2", "");
        dados.putString("placarEquipe3J3", "");
        dados.putString("placarEquipe4J1", "");
        dados.putString("placarEquipe4J2", "");
        dados.putString("placarEquipe4J3", "");
        dados.putString("placarEquipe5J1", "");
        dados.putString("placarEquipe5J2", "");
        dados.putString("placarEquipe5J3", "");
        dados.putString("placarEquipe6J1", "");
        dados.putString("placarEquipe6J2", "");
        dados.putString("placarEquipe6J3", "");
        dados.putString("placarEquipe7J1", "");
        dados.putString("placarEquipe7J2", "");
        dados.putString("placarEquipe7J3", "");
        dados.putString("placarEquipe8J1", "");
        dados.putString("placarEquipe8J2", "");
        dados.putString("placarEquipe8J3", "");
        dados.putString("placarEquipe9J1", "");
        dados.putString("placarEquipe9J2", "");
        dados.putString("placarEquipe9J3", "");
        dados.putString("placarEquipe10J1", "");
        dados.putString("placarEquipe10J2", "");
        dados.putString("placarEquipe10J3", "");
        dados.putString("placarEquipe11J1", "");
        dados.putString("placarEquipe11J2", "");
        dados.putString("placarEquipe11J3", "");
        dados.putString("placarEquipe12J1", "");
        dados.putString("placarEquipe12J2", "");
        dados.putString("placarEquipe12J3", "");
        dados.putString("placarEquipe13J1", "");
        dados.putString("placarEquipe13J2", "");
        dados.putString("placarEquipe13J3", "");
        dados.putString("placarEquipe14J1", "");
        dados.putString("placarEquipe14J2", "");
        dados.putString("placarEquipe14J3", "");
        dados.putString("placarEquipe15J1", "");
        dados.putString("placarEquipe15J2", "");
        dados.putString("placarEquipe15J3", "");
        dados.putString("placarEquipe16J1", "");
        dados.putString("placarEquipe16J2", "");
        dados.putString("placarEquipe16J3", "");
        dados.putInt("primeiroAID", -1);
        dados.putInt("primeiroBID", -1);
        dados.putInt("primeiroCID", -1);
        dados.putInt("primeiroDID", -1);
        dados.putInt("segundoAID", -1);
        dados.putInt("segundoBID", -1);
        dados.putInt("segundoCID", -1);
        dados.putInt("segundoDID", -1);
        dados.putInt("terceiroAID", -1);
        dados.putInt("terceiroBID", -1);
        dados.putInt("terceiroCID", -1);
        dados.putInt("terceiroDID", -1);
        dados.putString("nomePrimeiroA", "");
        dados.putString("nomePrimeiroB", "");
        dados.putString("nomePrimeiroC", "");
        dados.putString("nomePrimeiroD", "");
        dados.putString("nomeSegundoA", "");
        dados.putString("nomeSegundoB", "");
        dados.putString("nomeSegundoC", "");
        dados.putString("nomeSegundoD", "");
        dados.putString("nomeTerceiroA", "");
        dados.putString("nomeTerceiroB", "");
        dados.putString("nomeTerceiroC", "");
        dados.putString("nomeTerceiroD", "");
        dados.putInt("pEquipe1Class", -1);
        dados.putInt("jEquipe1Class", -1);
        dados.putInt("vEquipe1Class", -1);
        dados.putInt("eEquipe1Class", -1);
        dados.putInt("dEquipe1Class", -1);
        dados.putInt("gpEquipe1Class", -1);
        dados.putInt("gcEquipe1Class", -1);
        dados.putInt("sgEquipe1Class", -1);
        dados.putInt("pEquipe2Class", -1);
        dados.putInt("jEquipe2Class", -1);
        dados.putInt("vEquipe2Class", -1);
        dados.putInt("eEquipe2Class", -1);
        dados.putInt("dEquipe2Class", -1);
        dados.putInt("gpEquipe2Class", -1);
        dados.putInt("gcEquipe2Class", -1);
        dados.putInt("sgEquipe2Class", -1);
        dados.putInt("pEquipe3Class", -1);
        dados.putInt("jEquipe3Class", -1);
        dados.putInt("vEquipe3Class", -1);
        dados.putInt("eEquipe3Class", -1);
        dados.putInt("dEquipe3Class", -1);
        dados.putInt("gpEquipe3Class", -1);
        dados.putInt("gcEquipe3Class", -1);
        dados.putInt("sgEquipe3Class", -1);
        dados.putInt("pEquipe4Class", -1);
        dados.putInt("jEquipe4Class", -1);
        dados.putInt("vEquipe4Class", -1);
        dados.putInt("eEquipe4Class", -1);
        dados.putInt("dEquipe4Class", -1);
        dados.putInt("gpEquipe4Class", -1);
        dados.putInt("gcEquipe4Class", -1);
        dados.putInt("sgEquipe4Class", -1);
        dados.putInt("pEquipe5Class", -1);
        dados.putInt("jEquipe5Class", -1);
        dados.putInt("vEquipe5Class", -1);
        dados.putInt("eEquipe5Class", -1);
        dados.putInt("dEquipe5Class", -1);
        dados.putInt("gpEquipe5Class", -1);
        dados.putInt("gcEquipe5Class", -1);
        dados.putInt("sgEquipe5Class", -1);
        dados.putInt("pEquipe6Class", -1);
        dados.putInt("jEquipe6Class", -1);
        dados.putInt("vEquipe6Class", -1);
        dados.putInt("eEquipe6Class", -1);
        dados.putInt("dEquipe6Class", -1);
        dados.putInt("gpEquipe6Class", -1);
        dados.putInt("gcEquipe6Class", -1);
        dados.putInt("sgEquipe6Class", -1);
        dados.putInt("pEquipe7Class", -1);
        dados.putInt("jEquipe7Class", -1);
        dados.putInt("vEquipe7Class", -1);
        dados.putInt("eEquipe7Class", -1);
        dados.putInt("dEquipe7Class", -1);
        dados.putInt("gpEquipe7Class", -1);
        dados.putInt("gcEquipe7Class", -1);
        dados.putInt("sgEquipe7Class", -1);
        dados.putInt("pEquipe8Class", -1);
        dados.putInt("jEquipe8Class", -1);
        dados.putInt("vEquipe8Class", -1);
        dados.putInt("eEquipe8Class", -1);
        dados.putInt("dEquipe8Class", -1);
        dados.putInt("gpEquipe8Class", -1);
        dados.putInt("gcEquipe8Class", -1);
        dados.putInt("sgEquipe8Class", -1);
        dados.putInt("pEquipe9Class", -1);
        dados.putInt("jEquipe9Class", -1);
        dados.putInt("vEquipe9Class", -1);
        dados.putInt("eEquipe9Class", -1);
        dados.putInt("dEquipe9Class", -1);
        dados.putInt("gpEquipe9Class", -1);
        dados.putInt("gcEquipe9Class", -1);
        dados.putInt("sgEquipe9Class", -1);
        dados.putInt("pEquipe10Class", -1);
        dados.putInt("jEquipe10Class", -1);
        dados.putInt("vEquipe10Class", -1);
        dados.putInt("eEquipe10Class", -1);
        dados.putInt("dEquipe10Class", -1);
        dados.putInt("gpEquipe10Class", -1);
        dados.putInt("gcEquipe10Class", -1);
        dados.putInt("sgEquipe10Class", -1);
        dados.putInt("pEquipe11Class", -1);
        dados.putInt("jEquipe11Class", -1);
        dados.putInt("vEquipe11Class", -1);
        dados.putInt("eEquipe11Class", -1);
        dados.putInt("dEquipe11Class", -1);
        dados.putInt("gpEquipe11Class", -1);
        dados.putInt("gcEquipe11Class", -1);
        dados.putInt("sgEquipe11Class", -1);
        dados.putInt("pEquipe12Class", -1);
        dados.putInt("jEquipe12Class", -1);
        dados.putInt("vEquipe12Class", -1);
        dados.putInt("eEquipe12Class", -1);
        dados.putInt("dEquipe12Class", -1);
        dados.putInt("gpEquipe12Class", -1);
        dados.putInt("gcEquipe12Class", -1);
        dados.putInt("sgEquipe12Class", -1);
        dados.putInt("pEquipe13Class", -1);
        dados.putInt("jEquipe13Class", -1);
        dados.putInt("vEquipe13Class", -1);
        dados.putInt("eEquipe13Class", -1);
        dados.putInt("dEquipe13Class", -1);
        dados.putInt("gpEquipe13Class", -1);
        dados.putInt("gcEquipe13Class", -1);
        dados.putInt("sgEquipe13Class", -1);
        dados.putInt("pEquipe14Class", -1);
        dados.putInt("jEquipe14Class", -1);
        dados.putInt("vEquipe14Class", -1);
        dados.putInt("eEquipe14Class", -1);
        dados.putInt("dEquipe14Class", -1);
        dados.putInt("gpEquipe14Class", -1);
        dados.putInt("gcEquipe14Class", -1);
        dados.putInt("sgEquipe14Class", -1);
        dados.putInt("pEquipe15Class", -1);
        dados.putInt("jEquipe15Class", -1);
        dados.putInt("vEquipe15Class", -1);
        dados.putInt("eEquipe15Class", -1);
        dados.putInt("dEquipe15Class", -1);
        dados.putInt("gpEquipe15Class", -1);
        dados.putInt("gcEquipe15Class", -1);
        dados.putInt("sgEquipe15Class", -1);
        dados.putInt("pEquipe16Class", -1);
        dados.putInt("jEquipe16Class", -1);
        dados.putInt("vEquipe16Class", -1);
        dados.putInt("eEquipe16Class", -1);
        dados.putInt("dEquipe16Class", -1);
        dados.putInt("gpEquipe16Class", -1);
        dados.putInt("gcEquipe16Class", -1);
        dados.putInt("sgEquipe16Class", -1);
        dados.putInt("pEquipe1Quartas", -1);
        dados.putInt("jEquipe1Quartas", -1);
        dados.putInt("vEquipe1Quartas", -1);
        dados.putInt("eEquipe1Quartas", -1);
        dados.putInt("dEquipe1Quartas", -1);
        dados.putInt("gpEquipe1Quartas", -1);
        dados.putInt("gcEquipe1Quartas", -1);
        dados.putInt("sgEquipe1Quartas", -1);
        dados.putInt("pEquipe2Quartas", -1);
        dados.putInt("jEquipe2Quartas", -1);
        dados.putInt("vEquipe2Quartas", -1);
        dados.putInt("eEquipe2Quartas", -1);
        dados.putInt("dEquipe2Quartas", -1);
        dados.putInt("gpEquipe2Quartas", -1);
        dados.putInt("gcEquipe2Quartas", -1);
        dados.putInt("sgEquipe2Quartas", -1);
        dados.putInt("pEquipe3Quartas", -1);
        dados.putInt("jEquipe3Quartas", -1);
        dados.putInt("vEquipe3Quartas", -1);
        dados.putInt("eEquipe3Quartas", -1);
        dados.putInt("dEquipe3Quartas", -1);
        dados.putInt("gpEquipe3Quartas", -1);
        dados.putInt("gcEquipe3Quartas", -1);
        dados.putInt("sgEquipe3Quartas", -1);
        dados.putInt("pEquipe4Quartas", -1);
        dados.putInt("jEquipe4Quartas", -1);
        dados.putInt("vEquipe4Quartas", -1);
        dados.putInt("eEquipe4Quartas", -1);
        dados.putInt("dEquipe4Quartas", -1);
        dados.putInt("gpEquipe4Quartas", -1);
        dados.putInt("gcEquipe4Quartas", -1);
        dados.putInt("sgEquipe4Quartas", -1);
        dados.putInt("pEquipe5Quartas", -1);
        dados.putInt("jEquipe5Quartas", -1);
        dados.putInt("vEquipe5Quartas", -1);
        dados.putInt("eEquipe5Quartas", -1);
        dados.putInt("dEquipe5Quartas", -1);
        dados.putInt("gpEquipe5Quartas", -1);
        dados.putInt("gcEquipe5Quartas", -1);
        dados.putInt("sgEquipe5Quartas", -1);
        dados.putInt("pEquipe6Quartas", -1);
        dados.putInt("jEquipe6Quartas", -1);
        dados.putInt("vEquipe6Quartas", -1);
        dados.putInt("eEquipe6Quartas", -1);
        dados.putInt("dEquipe6Quartas", -1);
        dados.putInt("gpEquipe6Quartas", -1);
        dados.putInt("gcEquipe6Quartas", -1);
        dados.putInt("sgEquipe6Quartas", -1);
        dados.putInt("pEquipe7Quartas", -1);
        dados.putInt("jEquipe7Quartas", -1);
        dados.putInt("vEquipe7Quartas", -1);
        dados.putInt("eEquipe7Quartas", -1);
        dados.putInt("dEquipe7Quartas", -1);
        dados.putInt("gpEquipe7Quartas", -1);
        dados.putInt("gcEquipe7Quartas", -1);
        dados.putInt("sgEquipe7Quartas", -1);
        dados.putInt("pEquipe8Quartas", -1);
        dados.putInt("jEquipe8Quartas", -1);
        dados.putInt("vEquipe8Quartas", -1);
        dados.putInt("eEquipe8Quartas", -1);
        dados.putInt("dEquipe8Quartas", -1);
        dados.putInt("gpEquipe8Quartas", -1);
        dados.putInt("gcEquipe8Quartas", -1);
        dados.putInt("sgEquipe8Quartas", -1);
        dados.putInt("pEquipe1Semi", -1);
        dados.putInt("jEquipe1Semi", -1);
        dados.putInt("vEquipe1Semi", -1);
        dados.putInt("eEquipe1Semi", -1);
        dados.putInt("dEquipe1Semi", -1);
        dados.putInt("gpEquipe1Semi", -1);
        dados.putInt("gcEquipe1Semi", -1);
        dados.putInt("sgEquipe1Semi", -1);
        dados.putInt("pEquipe2Semi", -1);
        dados.putInt("jEquipe2Semi", -1);
        dados.putInt("vEquipe2Semi", -1);
        dados.putInt("eEquipe2Semi", -1);
        dados.putInt("dEquipe2Semi", -1);
        dados.putInt("gpEquipe2Semi", -1);
        dados.putInt("gcEquipe2Semi", -1);
        dados.putInt("sgEquipe2Semi", -1);
        dados.putInt("pEquipe3Semi", -1);
        dados.putInt("jEquipe3Semi", -1);
        dados.putInt("vEquipe3Semi", -1);
        dados.putInt("eEquipe3Semi", -1);
        dados.putInt("dEquipe3Semi", -1);
        dados.putInt("gpEquipe3Semi", -1);
        dados.putInt("gcEquipe3Semi", -1);
        dados.putInt("sgEquipe3Semi", -1);
        dados.putInt("pEquipe4Semi", -1);
        dados.putInt("jEquipe4Semi", -1);
        dados.putInt("vEquipe4Semi", -1);
        dados.putInt("eEquipe4Semi", -1);
        dados.putInt("dEquipe4Semi", -1);
        dados.putInt("gpEquipe4Semi", -1);
        dados.putInt("gcEquipe4Semi", -1);
        dados.putInt("sgEquipe4Semi", -1);
        dados.putInt("pEquipe1Ter", -1);
        dados.putInt("jEquipe1Ter", -1);
        dados.putInt("vEquipe1Ter", -1);
        dados.putInt("eEquipe1Ter", -1);
        dados.putInt("dEquipe1Ter", -1);
        dados.putInt("gpEquipe1Ter", -1);
        dados.putInt("gcEquipe1Ter", -1);
        dados.putInt("sgEquipe1Ter", -1);
        dados.putInt("pEquipe2Ter", -1);
        dados.putInt("jEquipe2Ter", -1);
        dados.putInt("vEquipe2Ter", -1);
        dados.putInt("eEquipe2Ter", -1);
        dados.putInt("dEquipe2Ter", -1);
        dados.putInt("gpEquipe2Ter", -1);
        dados.putInt("gcEquipe2Ter", -1);
        dados.putInt("sgEquipe2Ter", -1);
        dados.putInt("pEquipe1Final", -1);
        dados.putInt("jEquipe1Final", -1);
        dados.putInt("vEquipe1Final", -1);
        dados.putInt("eEquipe1Final", -1);
        dados.putInt("dEquipe1Final", -1);
        dados.putInt("gpEquipe1Final", -1);
        dados.putInt("gcEquipe1Final", -1);
        dados.putInt("sgEquipe1Final", -1);
        dados.putInt("pEquipe2Final", -1);
        dados.putInt("jEquipe2Final", -1);
        dados.putInt("vEquipe2Final", -1);
        dados.putInt("eEquipe2Final", -1);
        dados.putInt("dEquipe2Final", -1);
        dados.putInt("gpEquipe2Final", -1);
        dados.putInt("gcEquipe2Final", -1);
        dados.putInt("sgEquipe2Final", -1);
        dados.putInt("vencedor1QuartasGrupoID", -1);
        dados.putInt("vencedor2QuartasGrupoID", -1);
        dados.putInt("vencedor3QuartasGrupoID", -1);
        dados.putInt("vencedor4QuartasGrupoID", -1);
        dados.putInt("vencedor1QuartasID", -1);
        dados.putInt("vencedor2QuartasID", -1);
        dados.putInt("vencedor3QuartasID", -1);
        dados.putInt("vencedor4QuartasID", -1);
        dados.putString("nomeVencedor1Quartas", "");
        dados.putString("nomeVencedor2Quartas", "");
        dados.putString("nomeVencedor3Quartas", "");
        dados.putString("nomeVencedor4Quartas", "");
        dados.putInt("vencedor1SemiGrupoID", -1);
        dados.putInt("vencedor2SemiGrupoID", -1);
        dados.putInt("perdedor1SemiGrupoID", -1);
        dados.putInt("perdedor2SemiGrupoID", -1);
        dados.putInt("vencedor1SemiID", -1);
        dados.putInt("vencedor2SemiID", -1);
        dados.putInt("perdedor1SemiID", -1);
        dados.putInt("perdedor2SemiID", -1);
        dados.putString("nomeVencedor1Semi", "");
        dados.putString("nomeVencedor2Semi", "");
        dados.putString("nomePerdedor1Semi", "");
        dados.putString("nomePerdedor2Semi", "");
        dados.putString("placarEquipe1Quartas", "");
        dados.putString("placarEquipe2Quartas", "");
        dados.putString("placarEquipe3Quartas", "");
        dados.putString("placarEquipe4Quartas", "");
        dados.putString("placarEquipe5Quartas", "");
        dados.putString("placarEquipe6Quartas", "");
        dados.putString("placarEquipe7Quartas", "");
        dados.putString("placarEquipe8Quartas", "");
        dados.putString("placarEquipe1Semi", "");
        dados.putString("placarEquipe2Semi", "");
        dados.putString("placarEquipe3Semi", "");
        dados.putString("placarEquipe4Semi", "");
        dados.putString("placarEquipe1Terceiro", "");
        dados.putString("placarEquipe2Terceiro", "");
        dados.putString("placarEquipe1Final", "");
        dados.putString("placarEquipe2Final", "");
        dados.putInt("terceiroGrupoID", -1);
        dados.putInt("terceiroID", -1);
        dados.putString("nomeTerceiro", "");
        dados.putInt("segundoGrupoID", -1);
        dados.putInt("segundoID", -1);
        dados.putString("nomeSegundo", "");
        dados.putInt("primeiroGrupoID", -1);
        dados.putInt("primeiroID", -1);
        dados.putString("nomePrimeiro", "");

        dados.apply();

    }

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        usuario.setNome(preferences.getString("nomeUsuario", "NULO"));
        qtdEquipes = preferences.getInt("qtdEquipes", -1);
        nomeEquipe1 = preferences.getString("nomeEquipe1", "");
    }
}