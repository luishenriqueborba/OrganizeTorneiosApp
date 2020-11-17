package com.innovatesolutions.organizetorneios.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.api.AppUtil;
import com.innovatesolutions.organizetorneios.controller.EquipeController;
import com.innovatesolutions.organizetorneios.model.Equipe;
import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;
import com.shashank.sony.fancydialoglib.Icon;

public class MelhorDefesa extends AppCompatActivity {

    TextView txtEquipe1, gcEquipe1,
            txtEquipe2, gcEquipe2,
            txtEquipe3, gcEquipe3,
            txtEquipe4, gcEquipe4,
            txtEquipe5, gcEquipe5,
            txtEquipe6, gcEquipe6,
            txtEquipe7, gcEquipe7,
            txtEquipe8, gcEquipe8,
            txtEquipe9, gcEquipe9,
            txtEquipe10, gcEquipe10,
            txtEquipe11, gcEquipe11,
            txtEquipe12, gcEquipe12,
            txtEquipe13, gcEquipe13,
            txtEquipe14, gcEquipe14,
            txtEquipe15, gcEquipe15,
            txtEquipe16, gcEquipe16;

    Equipe equipe1, equipe2, equipe3, equipe4, equipe5, equipe6, equipe7, equipe8, equipe9, equipe10, equipe11, equipe12, equipe13, equipe14, equipe15, equipe16;
    EquipeController equipeController;

    SharedPreferences preferences;

    int equipe1ID, equipe2ID, equipe3ID, equipe4ID, equipe5ID, equipe6ID, equipe7ID, equipe8ID, equipe9ID, equipe10ID, equipe11ID, equipe12ID, equipe13ID, equipe14ID, equipe15ID, equipe16ID, qtdEquipes;

    Equipe[] equipes;

    String nomeEquipe1, nomeEquipe2, nomeEquipe3, nomeEquipe4, nomeEquipe5, nomeEquipe6, nomeEquipe7, nomeEquipe8, nomeEquipe9, nomeEquipe10, nomeEquipe11, nomeEquipe12, nomeEquipe13, nomeEquipe14, nomeEquipe15, nomeEquipe16;

    private PublisherAdView mPublisherAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_melhor_defesa_quatro);

        restaurarSharedPreferencesQtdEquipes();

        switch (qtdEquipes) {

            case 4:
                setContentView(R.layout.activity_melhor_defesa_quatro);
                break;

            case 12:
                setContentView(R.layout.activity_melhor_defesa_doze);
                break;

            case 16:
                setContentView(R.layout.activity_melhor_defesa_dezesseis);
                break;
        }

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        mPublisherAdView = findViewById(R.id.publisherAdView);
        AdSize adSize = new AdSize(468, 60);
        mPublisherAdView.setAdSizes(adSize);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mPublisherAdView.loadAd(adRequest);

        restaurarSharedPreferences();
        initFormulario();
        popularFormulario();

    }

    private void initFormulario() {

        if (qtdEquipes == 4) {

            txtEquipe1 = findViewById(R.id.txtEquipe1);
            txtEquipe2 = findViewById(R.id.txtEquipe2);
            txtEquipe3 = findViewById(R.id.txtEquipe3);
            txtEquipe4 = findViewById(R.id.txtEquipe4);
            gcEquipe1 = findViewById(R.id.txtGolsContraEquipe1);
            gcEquipe2 = findViewById(R.id.txtGolsContraEquipe2);
            gcEquipe3 = findViewById(R.id.txtGolsContraEquipe3);
            gcEquipe4 = findViewById(R.id.txtGolsContraEquipe4);

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
        } else if (qtdEquipes == 12) {

            txtEquipe1 = findViewById(R.id.txtEquipe1);
            txtEquipe2 = findViewById(R.id.txtEquipe2);
            txtEquipe3 = findViewById(R.id.txtEquipe3);
            txtEquipe4 = findViewById(R.id.txtEquipe4);
            txtEquipe5 = findViewById(R.id.txtEquipe5);
            txtEquipe6 = findViewById(R.id.txtEquipe6);
            txtEquipe7 = findViewById(R.id.txtEquipe7);
            txtEquipe8 = findViewById(R.id.txtEquipe8);
            txtEquipe9 = findViewById(R.id.txtEquipe9);
            txtEquipe10 = findViewById(R.id.txtEquipe10);
            txtEquipe11 = findViewById(R.id.txtEquipe11);
            txtEquipe12 = findViewById(R.id.txtEquipe12);
            gcEquipe1 = findViewById(R.id.txtGolsContraEquipe1);
            gcEquipe2 = findViewById(R.id.txtGolsContraEquipe2);
            gcEquipe3 = findViewById(R.id.txtGolsContraEquipe3);
            gcEquipe4 = findViewById(R.id.txtGolsContraEquipe4);
            gcEquipe5 = findViewById(R.id.txtGolsContraEquipe5);
            gcEquipe6 = findViewById(R.id.txtGolsContraEquipe6);
            gcEquipe7 = findViewById(R.id.txtGolsContraEquipe7);
            gcEquipe8 = findViewById(R.id.txtGolsContraEquipe8);
            gcEquipe9 = findViewById(R.id.txtGolsContraEquipe9);
            gcEquipe10 = findViewById(R.id.txtGolsContraEquipe10);
            gcEquipe11 = findViewById(R.id.txtGolsContraEquipe11);
            gcEquipe12 = findViewById(R.id.txtGolsContraEquipe12);

            equipe1 = new Equipe();
            equipe1.setId(equipe1ID);
            equipe2 = new Equipe();
            equipe2.setId(equipe2ID);
            equipe3 = new Equipe();
            equipe3.setId(equipe3ID);
            equipe4 = new Equipe();
            equipe4.setId(equipe4ID);
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

            equipes = new Equipe[qtdEquipes];

            equipeController = new EquipeController(this);
        } else if (qtdEquipes == 16) {

            txtEquipe1 = findViewById(R.id.txtEquipe1);
            txtEquipe2 = findViewById(R.id.txtEquipe2);
            txtEquipe3 = findViewById(R.id.txtEquipe3);
            txtEquipe4 = findViewById(R.id.txtEquipe4);
            txtEquipe5 = findViewById(R.id.txtEquipe5);
            txtEquipe6 = findViewById(R.id.txtEquipe6);
            txtEquipe7 = findViewById(R.id.txtEquipe7);
            txtEquipe8 = findViewById(R.id.txtEquipe8);
            txtEquipe9 = findViewById(R.id.txtEquipe9);
            txtEquipe10 = findViewById(R.id.txtEquipe10);
            txtEquipe11 = findViewById(R.id.txtEquipe11);
            txtEquipe12 = findViewById(R.id.txtEquipe12);
            txtEquipe13 = findViewById(R.id.txtEquipe13);
            txtEquipe14 = findViewById(R.id.txtEquipe14);
            txtEquipe15 = findViewById(R.id.txtEquipe15);
            txtEquipe16 = findViewById(R.id.txtEquipe16);
            gcEquipe1 = findViewById(R.id.txtGolsContraEquipe1);
            gcEquipe2 = findViewById(R.id.txtGolsContraEquipe2);
            gcEquipe3 = findViewById(R.id.txtGolsContraEquipe3);
            gcEquipe4 = findViewById(R.id.txtGolsContraEquipe4);
            gcEquipe5 = findViewById(R.id.txtGolsContraEquipe5);
            gcEquipe6 = findViewById(R.id.txtGolsContraEquipe6);
            gcEquipe7 = findViewById(R.id.txtGolsContraEquipe7);
            gcEquipe8 = findViewById(R.id.txtGolsContraEquipe8);
            gcEquipe9 = findViewById(R.id.txtGolsContraEquipe9);
            gcEquipe10 = findViewById(R.id.txtGolsContraEquipe10);
            gcEquipe11 = findViewById(R.id.txtGolsContraEquipe11);
            gcEquipe12 = findViewById(R.id.txtGolsContraEquipe12);
            gcEquipe13 = findViewById(R.id.txtGolsContraEquipe13);
            gcEquipe14 = findViewById(R.id.txtGolsContraEquipe14);
            gcEquipe15 = findViewById(R.id.txtGolsContraEquipe15);
            gcEquipe16 = findViewById(R.id.txtGolsContraEquipe16);

            equipe1 = new Equipe();
            equipe1.setId(equipe1ID);
            equipe2 = new Equipe();
            equipe2.setId(equipe2ID);
            equipe3 = new Equipe();
            equipe3.setId(equipe3ID);
            equipe4 = new Equipe();
            equipe4.setId(equipe4ID);
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
            equipe13 = new Equipe();
            equipe13.setId(equipe13ID);
            equipe14 = new Equipe();
            equipe14.setId(equipe14ID);
            equipe15 = new Equipe();
            equipe15.setId(equipe15ID);
            equipe16 = new Equipe();
            equipe16.setId(equipe16ID);

            equipes = new Equipe[qtdEquipes];

            equipeController = new EquipeController(this);
        }

    }

    private void popularFormulario() {

        if (qtdEquipes == 4) {

            equipe1 = equipeController.getEquipeByID(equipe1);
            equipe2 = equipeController.getEquipeByID(equipe2);
            equipe3 = equipeController.getEquipeByID(equipe3);
            equipe4 = equipeController.getEquipeByID(equipe4);

            equipes[0] = equipe1;
            equipes[1] = equipe2;
            equipes[2] = equipe3;
            equipes[3] = equipe4;

            ordenaMelhorDefesa(equipes);

            txtEquipe1.setText(equipes[0].getNome());
            gcEquipe1.setText(String.valueOf(equipes[0].getGolsContra()));

            txtEquipe2.setText(equipes[1].getNome());
            gcEquipe2.setText(String.valueOf(equipes[1].getGolsContra()));

            txtEquipe3.setText(equipes[2].getNome());
            gcEquipe3.setText(String.valueOf(equipes[2].getGolsContra()));

            txtEquipe4.setText(equipes[3].getNome());
            gcEquipe4.setText(String.valueOf(equipes[3].getGolsContra()));
        } else if (qtdEquipes == 12) {

            equipe1 = equipeController.getEquipeByID(equipe1);
            equipe2 = equipeController.getEquipeByID(equipe2);
            equipe3 = equipeController.getEquipeByID(equipe3);
            equipe4 = equipeController.getEquipeByID(equipe4);
            equipe5 = equipeController.getEquipeByID(equipe5);
            equipe6 = equipeController.getEquipeByID(equipe6);
            equipe7 = equipeController.getEquipeByID(equipe7);
            equipe8 = equipeController.getEquipeByID(equipe8);
            equipe9 = equipeController.getEquipeByID(equipe9);
            equipe10 = equipeController.getEquipeByID(equipe10);
            equipe11 = equipeController.getEquipeByID(equipe11);
            equipe12 = equipeController.getEquipeByID(equipe12);

            equipes[0] = equipe1;
            equipes[1] = equipe2;
            equipes[2] = equipe3;
            equipes[3] = equipe4;
            equipes[4] = equipe5;
            equipes[5] = equipe6;
            equipes[6] = equipe7;
            equipes[7] = equipe8;
            equipes[8] = equipe9;
            equipes[9] = equipe10;
            equipes[10] = equipe11;
            equipes[11] = equipe12;

            ordenaMelhorDefesa(equipes);

            txtEquipe1.setText(equipes[0].getNome());
            gcEquipe1.setText(String.valueOf(equipes[0].getGolsContra()));
            txtEquipe2.setText(equipes[1].getNome());
            gcEquipe2.setText(String.valueOf(equipes[1].getGolsContra()));
            txtEquipe3.setText(equipes[2].getNome());
            gcEquipe3.setText(String.valueOf(equipes[2].getGolsContra()));
            txtEquipe4.setText(equipes[3].getNome());
            gcEquipe4.setText(String.valueOf(equipes[3].getGolsContra()));
            txtEquipe5.setText(equipes[4].getNome());
            gcEquipe5.setText(String.valueOf(equipes[4].getGolsContra()));
            txtEquipe6.setText(equipes[5].getNome());
            gcEquipe6.setText(String.valueOf(equipes[5].getGolsContra()));
            txtEquipe7.setText(equipes[6].getNome());
            gcEquipe7.setText(String.valueOf(equipes[6].getGolsContra()));
            txtEquipe8.setText(equipes[7].getNome());
            gcEquipe8.setText(String.valueOf(equipes[7].getGolsContra()));
            txtEquipe9.setText(equipes[8].getNome());
            gcEquipe9.setText(String.valueOf(equipes[8].getGolsContra()));
            txtEquipe10.setText(equipes[9].getNome());
            gcEquipe10.setText(String.valueOf(equipes[9].getGolsContra()));
            txtEquipe11.setText(equipes[10].getNome());
            gcEquipe11.setText(String.valueOf(equipes[10].getGolsContra()));
            txtEquipe12.setText(equipes[11].getNome());
            gcEquipe12.setText(String.valueOf(equipes[11].getGolsContra()));
        } else if (qtdEquipes == 16) {

            equipe1 = equipeController.getEquipeByID(equipe1);
            equipe2 = equipeController.getEquipeByID(equipe2);
            equipe3 = equipeController.getEquipeByID(equipe3);
            equipe4 = equipeController.getEquipeByID(equipe4);
            equipe5 = equipeController.getEquipeByID(equipe5);
            equipe6 = equipeController.getEquipeByID(equipe6);
            equipe7 = equipeController.getEquipeByID(equipe7);
            equipe8 = equipeController.getEquipeByID(equipe8);
            equipe9 = equipeController.getEquipeByID(equipe9);
            equipe10 = equipeController.getEquipeByID(equipe10);
            equipe11 = equipeController.getEquipeByID(equipe11);
            equipe12 = equipeController.getEquipeByID(equipe12);
            equipe13 = equipeController.getEquipeByID(equipe13);
            equipe14 = equipeController.getEquipeByID(equipe14);
            equipe15 = equipeController.getEquipeByID(equipe15);
            equipe16 = equipeController.getEquipeByID(equipe16);

            equipes[0] = equipe1;
            equipes[1] = equipe2;
            equipes[2] = equipe3;
            equipes[3] = equipe4;
            equipes[4] = equipe5;
            equipes[5] = equipe6;
            equipes[6] = equipe7;
            equipes[7] = equipe8;
            equipes[8] = equipe9;
            equipes[9] = equipe10;
            equipes[10] = equipe11;
            equipes[11] = equipe12;
            equipes[12] = equipe13;
            equipes[13] = equipe14;
            equipes[14] = equipe15;
            equipes[15] = equipe16;

            ordenaMelhorDefesa(equipes);

            txtEquipe1.setText(equipes[0].getNome());
            gcEquipe1.setText(String.valueOf(equipes[0].getGolsContra()));
            txtEquipe2.setText(equipes[1].getNome());
            gcEquipe2.setText(String.valueOf(equipes[1].getGolsContra()));
            txtEquipe3.setText(equipes[2].getNome());
            gcEquipe3.setText(String.valueOf(equipes[2].getGolsContra()));
            txtEquipe4.setText(equipes[3].getNome());
            gcEquipe4.setText(String.valueOf(equipes[3].getGolsContra()));
            txtEquipe5.setText(equipes[4].getNome());
            gcEquipe5.setText(String.valueOf(equipes[4].getGolsContra()));
            txtEquipe6.setText(equipes[5].getNome());
            gcEquipe6.setText(String.valueOf(equipes[5].getGolsContra()));
            txtEquipe7.setText(equipes[6].getNome());
            gcEquipe7.setText(String.valueOf(equipes[6].getGolsContra()));
            txtEquipe8.setText(equipes[7].getNome());
            gcEquipe8.setText(String.valueOf(equipes[7].getGolsContra()));
            txtEquipe9.setText(equipes[8].getNome());
            gcEquipe9.setText(String.valueOf(equipes[8].getGolsContra()));
            txtEquipe10.setText(equipes[9].getNome());
            gcEquipe10.setText(String.valueOf(equipes[9].getGolsContra()));
            txtEquipe11.setText(equipes[10].getNome());
            gcEquipe11.setText(String.valueOf(equipes[10].getGolsContra()));
            txtEquipe12.setText(equipes[11].getNome());
            gcEquipe12.setText(String.valueOf(equipes[11].getGolsContra()));
            txtEquipe13.setText(equipes[12].getNome());
            gcEquipe13.setText(String.valueOf(equipes[12].getGolsContra()));
            txtEquipe14.setText(equipes[13].getNome());
            gcEquipe14.setText(String.valueOf(equipes[13].getGolsContra()));
            txtEquipe15.setText(equipes[14].getNome());
            gcEquipe15.setText(String.valueOf(equipes[14].getGolsContra()));
            txtEquipe16.setText(equipes[15].getNome());
            gcEquipe16.setText(String.valueOf(equipes[15].getGolsContra()));

        } else alert();
    }

    private void alert() {

        new FancyAlertDialog.Builder(MelhorDefesa.this)
                .setTitle("Atenção")
                .setBackgroundColor(Color.parseColor("#303F9F"))  //Don't pass R.color.colorvalue
                .setMessage("Não foi possível recuperar os dados das equipes!")
                .setNegativeBtnText("Retornar")
                .setNegativeBtnBackground(Color.parseColor("#FFA9A7A8"))  //Don't pass R.color.colorvalue
                .setAnimation(Animation.POP)
                .isCancellable(true)
                .setIcon(R.mipmap.ic_launcher_round, Icon.Visible)
                .OnNegativeClicked(new FancyAlertDialogListener() {
                    @Override
                    public void OnClick() {
                        Intent intent = new Intent(MelhorDefesa.this, Dashboard.class);
                        startActivity(intent);
                    }
                })
                .build();
    }

    public void voltar(View view) {

        Intent intent = new Intent(MelhorDefesa.this, Dashboard.class);
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

    public static void ordenaMelhorDefesa(Equipe equipes[]) {

        boolean troca = true;
        Equipe equipeFake;

        while (troca) {
            troca = false;
            for (int i = 0; i < equipes.length - 1; i++) {
                if (equipes[i].getGolsContra() > equipes[i + 1].getGolsContra()) {
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

        if (qtdEquipes == 4) {

            preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
            equipe1ID = preferences.getInt("equipe1ID", -1);
            nomeEquipe1 = preferences.getString("nomeEquipe1", "");
            equipe2ID = preferences.getInt("equipe2ID", -1);
            nomeEquipe2 = preferences.getString("nomeEquipe2", "");
            equipe3ID = preferences.getInt("equipe3ID", -1);
            nomeEquipe3 = preferences.getString("nomeEquipe3", "");
            equipe4ID = preferences.getInt("equipe4ID", -1);
            nomeEquipe4 = preferences.getString("nomeEquipe4", "");
        } else if (qtdEquipes == 12) {

            preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
            equipe1ID = preferences.getInt("equipe1ID", -1);
            nomeEquipe1 = preferences.getString("nomeEquipe1", "");
            equipe2ID = preferences.getInt("equipe2ID", -1);
            nomeEquipe2 = preferences.getString("nomeEquipe2", "");
            equipe3ID = preferences.getInt("equipe3ID", -1);
            nomeEquipe3 = preferences.getString("nomeEquipe3", "");

            equipe4ID = preferences.getInt("equipe4ID", -1);
            nomeEquipe4 = preferences.getString("nomeEquipe4", "");
            equipe5ID = preferences.getInt("equipe5ID", -1);
            nomeEquipe5 = preferences.getString("nomeEquipe5", "");
            equipe6ID = preferences.getInt("equipe6ID", -1);
            nomeEquipe6 = preferences.getString("nomeEquipe6", "");

            equipe7ID = preferences.getInt("equipe7ID", -1);
            nomeEquipe7 = preferences.getString("nomeEquipe7", "");
            equipe8ID = preferences.getInt("equipe8ID", -1);
            nomeEquipe8 = preferences.getString("nomeEquipe8", "");
            equipe9ID = preferences.getInt("equipe9ID", -1);
            nomeEquipe9 = preferences.getString("nomeEquipe9", "");

            equipe10ID = preferences.getInt("equipe10ID", -1);
            nomeEquipe10 = preferences.getString("nomeEquipe10", "");
            equipe11ID = preferences.getInt("equipe11ID", -1);
            nomeEquipe11 = preferences.getString("nomeEquipe11", "");
            equipe12ID = preferences.getInt("equipe12ID", -1);
            nomeEquipe12 = preferences.getString("nomeEquipe12", "");
        } else if (qtdEquipes == 16) {

            preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
            equipe1ID = preferences.getInt("equipe1ID", -1);
            nomeEquipe1 = preferences.getString("nomeEquipe1", "");
            equipe2ID = preferences.getInt("equipe2ID", -1);
            nomeEquipe2 = preferences.getString("nomeEquipe2", "");
            equipe3ID = preferences.getInt("equipe3ID", -1);
            nomeEquipe3 = preferences.getString("nomeEquipe3", "");
            equipe4ID = preferences.getInt("equipe4ID", -1);
            nomeEquipe4 = preferences.getString("nomeEquipe4", "");

            equipe5ID = preferences.getInt("equipe5ID", -1);
            nomeEquipe5 = preferences.getString("nomeEquipe5", "");
            equipe6ID = preferences.getInt("equipe6ID", -1);
            nomeEquipe6 = preferences.getString("nomeEquipe6", "");
            equipe7ID = preferences.getInt("equipe7ID", -1);
            nomeEquipe7 = preferences.getString("nomeEquipe7", "");
            equipe8ID = preferences.getInt("equipe8ID", -1);
            nomeEquipe8 = preferences.getString("nomeEquipe8", "");

            equipe9ID = preferences.getInt("equipe9ID", -1);
            nomeEquipe9 = preferences.getString("nomeEquipe9", "");
            equipe10ID = preferences.getInt("equipe10ID", -1);
            nomeEquipe10 = preferences.getString("nomeEquipe10", "");
            equipe11ID = preferences.getInt("equipe11ID", -1);
            nomeEquipe11 = preferences.getString("nomeEquipe11", "");
            equipe12ID = preferences.getInt("equipe12ID", -1);
            nomeEquipe12 = preferences.getString("nomeEquipe12", "");

            equipe13ID = preferences.getInt("equipe13ID", -1);
            nomeEquipe13 = preferences.getString("nomeEquipe13", "");
            equipe14ID = preferences.getInt("equipe14ID", -1);
            nomeEquipe14 = preferences.getString("nomeEquipe14", "");
            equipe15ID = preferences.getInt("equipe15ID", -1);
            nomeEquipe15 = preferences.getString("nomeEquipe15", "");
            equipe16ID = preferences.getInt("equipe16ID", -1);
            nomeEquipe16 = preferences.getString("nomeEquipe16", "");
        }

    }
}