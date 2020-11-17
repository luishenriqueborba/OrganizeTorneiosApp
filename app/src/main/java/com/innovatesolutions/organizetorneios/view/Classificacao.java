package com.innovatesolutions.organizetorneios.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.api.AppUtil;
import com.innovatesolutions.organizetorneios.controller.EquipeController;
import com.innovatesolutions.organizetorneios.controller.GrupoController;
import com.innovatesolutions.organizetorneios.model.Equipe;
import com.innovatesolutions.organizetorneios.model.Grupo;
import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;
import com.shashank.sony.fancydialoglib.Icon;

public class Classificacao extends AppCompatActivity {

    TextView txtNomeGrupoA, txtNomeGrupoB, txtNomeGrupoC, txtNomeGrupoD,
            txtEquipe1, pEquipe1, jEquipe1, vEquipe1, eEquipe1, dEquipe1, gpEquipe1, gcEquipe1, sgEquipe1,
            txtEquipe2, pEquipe2, jEquipe2, vEquipe2, eEquipe2, dEquipe2, gpEquipe2, gcEquipe2, sgEquipe2,
            txtEquipe3, pEquipe3, jEquipe3, vEquipe3, eEquipe3, dEquipe3, gpEquipe3, gcEquipe3, sgEquipe3,
            txtEquipe4, pEquipe4, jEquipe4, vEquipe4, eEquipe4, dEquipe4, gpEquipe4, gcEquipe4, sgEquipe4,
            txtEquipe5, pEquipe5, jEquipe5, vEquipe5, eEquipe5, dEquipe5, gpEquipe5, gcEquipe5, sgEquipe5,
            txtEquipe6, pEquipe6, jEquipe6, vEquipe6, eEquipe6, dEquipe6, gpEquipe6, gcEquipe6, sgEquipe6,
            txtEquipe7, pEquipe7, jEquipe7, vEquipe7, eEquipe7, dEquipe7, gpEquipe7, gcEquipe7, sgEquipe7,
            txtEquipe8, pEquipe8, jEquipe8, vEquipe8, eEquipe8, dEquipe8, gpEquipe8, gcEquipe8, sgEquipe8,
            txtEquipe9, pEquipe9, jEquipe9, vEquipe9, eEquipe9, dEquipe9, gpEquipe9, gcEquipe9, sgEquipe9,
            txtEquipe10, pEquipe10, jEquipe10, vEquipe10, eEquipe10, dEquipe10, gpEquipe10, gcEquipe10, sgEquipe10,
            txtEquipe11, pEquipe11, jEquipe11, vEquipe11, eEquipe11, dEquipe11, gpEquipe11, gcEquipe11, sgEquipe11,
            txtEquipe12, pEquipe12, jEquipe12, vEquipe12, eEquipe12, dEquipe12, gpEquipe12, gcEquipe12, sgEquipe12,
            txtEquipe13, pEquipe13, jEquipe13, vEquipe13, eEquipe13, dEquipe13, gpEquipe13, gcEquipe13, sgEquipe13,
            txtEquipe14, pEquipe14, jEquipe14, vEquipe14, eEquipe14, dEquipe14, gpEquipe14, gcEquipe14, sgEquipe14,
            txtEquipe15, pEquipe15, jEquipe15, vEquipe15, eEquipe15, dEquipe15, gpEquipe15, gcEquipe15, sgEquipe15,
            txtEquipe16, pEquipe16, jEquipe16, vEquipe16, eEquipe16, dEquipe16, gpEquipe16, gcEquipe16, sgEquipe16;

    Equipe equipe1, equipe2, equipe3, equipe4, equipe5, equipe6, equipe7, equipe8, equipe9, equipe10, equipe11, equipe12, equipe13, equipe14, equipe15, equipe16;

    Grupo grupo1, grupo2, grupo3, grupo4;

    EquipeController equipeController;

    GrupoController grupoController;

    SharedPreferences preferences;

    int grupo1ID, grupo2ID, grupo3ID, grupo4ID, equipe1ID, equipe2ID, equipe3ID, equipe4ID, equipe5ID, equipe6ID, equipe7ID, equipe8ID, equipe9ID, equipe10ID, equipe11ID, equipe12ID, equipe13ID, equipe14ID, equipe15ID, equipe16ID, qtdEquipes, quantidade1 = 4, quantidade2 = 3,
            pEquipe1Class, jEquipe1Class, vEquipe1Class, eEquipe1Class, dEquipe1Class, gpEquipe1Class, gcEquipe1Class, sgEquipe1Class,
            pEquipe2Class, jEquipe2Class, vEquipe2Class, eEquipe2Class, dEquipe2Class, gpEquipe2Class, gcEquipe2Class, sgEquipe2Class,
            pEquipe3Class, jEquipe3Class, vEquipe3Class, eEquipe3Class, dEquipe3Class, gpEquipe3Class, gcEquipe3Class, sgEquipe3Class,
            pEquipe4Class, jEquipe4Class, vEquipe4Class, eEquipe4Class, dEquipe4Class, gpEquipe4Class, gcEquipe4Class, sgEquipe4Class,
            pEquipe5Class, jEquipe5Class, vEquipe5Class, eEquipe5Class, dEquipe5Class, gpEquipe5Class, gcEquipe5Class, sgEquipe5Class,
            pEquipe6Class, jEquipe6Class, vEquipe6Class, eEquipe6Class, dEquipe6Class, gpEquipe6Class, gcEquipe6Class, sgEquipe6Class,
            pEquipe7Class, jEquipe7Class, vEquipe7Class, eEquipe7Class, dEquipe7Class, gpEquipe7Class, gcEquipe7Class, sgEquipe7Class,
            pEquipe8Class, jEquipe8Class, vEquipe8Class, eEquipe8Class, dEquipe8Class, gpEquipe8Class, gcEquipe8Class, sgEquipe8Class,
            pEquipe9Class, jEquipe9Class, vEquipe9Class, eEquipe9Class, dEquipe9Class, gpEquipe9Class, gcEquipe9Class, sgEquipe9Class,
            pEquipe10Class, jEquipe10Class, vEquipe10Class, eEquipe10Class, dEquipe10Class, gpEquipe10Class, gcEquipe10Class, sgEquipe10Class,
            pEquipe11Class, jEquipe11Class, vEquipe11Class, eEquipe11Class, dEquipe11Class, gpEquipe11Class, gcEquipe11Class, sgEquipe11Class,
            pEquipe12Class, jEquipe12Class, vEquipe12Class, eEquipe12Class, dEquipe12Class, gpEquipe12Class, gcEquipe12Class, sgEquipe12Class,
            pEquipe13Class, jEquipe13Class, vEquipe13Class, eEquipe13Class, dEquipe13Class, gpEquipe13Class, gcEquipe13Class, sgEquipe13Class,
            pEquipe14Class, jEquipe14Class, vEquipe14Class, eEquipe14Class, dEquipe14Class, gpEquipe14Class, gcEquipe14Class, sgEquipe14Class,
            pEquipe15Class, jEquipe15Class, vEquipe15Class, eEquipe15Class, dEquipe15Class, gpEquipe15Class, gcEquipe15Class, sgEquipe15Class,
            pEquipe16Class, jEquipe16Class, vEquipe16Class, eEquipe16Class, dEquipe16Class, gpEquipe16Class, gcEquipe16Class, sgEquipe16Class;

    Equipe[] equipes, equipesA, equipesB, equipesC, equipesD;

    String nomeGrupo1, nomeGrupo2, nomeGrupo3, nomeGrupo4, nomeEquipe1, nomeEquipe2, nomeEquipe3, nomeEquipe4, nomeEquipe5, nomeEquipe6, nomeEquipe7, nomeEquipe8, nomeEquipe9, nomeEquipe10, nomeEquipe11, nomeEquipe12, nomeEquipe13, nomeEquipe14, nomeEquipe15, nomeEquipe16;

    boolean finalizouPrimeiraFase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classificacao_quatro);

        restaurarSharedPreferencesQtdEquipes();

        switch (qtdEquipes) {

            case 4:
                setContentView(R.layout.activity_classificacao_quatro);
                break;

            case 12:
                setContentView(R.layout.activity_classificacao_doze);
                break;

            case 16:
                setContentView(R.layout.activity_classificacao_dezesseis);
                break;
        }

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
            txtNomeGrupoA = findViewById(R.id.txtNomeGrupo);
            pEquipe1 = findViewById(R.id.txtPontosEquipe1);
            pEquipe2 = findViewById(R.id.txtPontosEquipe2);
            pEquipe3 = findViewById(R.id.txtPontosEquipe3);
            pEquipe4 = findViewById(R.id.txtPontosEquipe4);
            jEquipe1 = findViewById(R.id.txtJogosEquipe1);
            jEquipe2 = findViewById(R.id.txtJogosEquipe2);
            jEquipe3 = findViewById(R.id.txtJogosEquipe3);
            jEquipe4 = findViewById(R.id.txtJogosEquipe4);
            vEquipe1 = findViewById(R.id.txtVitoriasEquipe1);
            vEquipe2 = findViewById(R.id.txtVitoriasEquipe2);
            vEquipe3 = findViewById(R.id.txtVitoriasEquipe3);
            vEquipe4 = findViewById(R.id.txtVitoriasEquipe4);
            eEquipe1 = findViewById(R.id.txtEmpatesEquipe1);
            eEquipe2 = findViewById(R.id.txtEmpatesEquipe2);
            eEquipe3 = findViewById(R.id.txtEmpatesEquipe3);
            eEquipe4 = findViewById(R.id.txtEmpatesEquipe4);
            dEquipe1 = findViewById(R.id.txtDerrotasEquipe1);
            dEquipe2 = findViewById(R.id.txtDerrotasEquipe2);
            dEquipe3 = findViewById(R.id.txtDerrotasEquipe3);
            dEquipe4 = findViewById(R.id.txtDerrotasEquipe4);
            gpEquipe1 = findViewById(R.id.txtGolsProEquipe1);
            gpEquipe2 = findViewById(R.id.txtGolsProEquipe2);
            gpEquipe3 = findViewById(R.id.txtGolsProEquipe3);
            gpEquipe4 = findViewById(R.id.txtGolsProEquipe4);
            gcEquipe1 = findViewById(R.id.txtGolsContraEquipe1);
            gcEquipe2 = findViewById(R.id.txtGolsContraEquipe2);
            gcEquipe3 = findViewById(R.id.txtGolsContraEquipe3);
            gcEquipe4 = findViewById(R.id.txtGolsContraEquipe4);
            sgEquipe1 = findViewById(R.id.txtSaldoGolsEquipe1);
            sgEquipe2 = findViewById(R.id.txtSaldoGolsEquipe2);
            sgEquipe3 = findViewById(R.id.txtSaldoGolsEquipe3);
            sgEquipe4 = findViewById(R.id.txtSaldoGolsEquipe4);

            equipe1 = new Equipe();
            equipe1.setId(equipe1ID);

            equipe2 = new Equipe();
            equipe2.setId(equipe2ID);

            equipe3 = new Equipe();
            equipe3.setId(equipe3ID);

            equipe4 = new Equipe();
            equipe4.setId(equipe4ID);

            grupo1 = new Grupo();
            grupo1.setId(grupo1ID);

            equipes = new Equipe[quantidade1];

            equipeController = new EquipeController(this);
            grupoController = new GrupoController(this);
        } else if (qtdEquipes == 12) {

            txtNomeGrupoA = findViewById(R.id.txtNomeGrupoA);
            txtNomeGrupoB = findViewById(R.id.txtNomeGrupoB);
            txtNomeGrupoC = findViewById(R.id.txtNomeGrupoC);
            txtNomeGrupoD = findViewById(R.id.txtNomeGrupoD);
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
            pEquipe1 = findViewById(R.id.txtPontosEquipe1);
            pEquipe2 = findViewById(R.id.txtPontosEquipe2);
            pEquipe3 = findViewById(R.id.txtPontosEquipe3);
            pEquipe4 = findViewById(R.id.txtPontosEquipe4);
            pEquipe5 = findViewById(R.id.txtPontosEquipe5);
            pEquipe6 = findViewById(R.id.txtPontosEquipe6);
            pEquipe7 = findViewById(R.id.txtPontosEquipe7);
            pEquipe8 = findViewById(R.id.txtPontosEquipe8);
            pEquipe9 = findViewById(R.id.txtPontosEquipe9);
            pEquipe10 = findViewById(R.id.txtPontosEquipe10);
            pEquipe11 = findViewById(R.id.txtPontosEquipe11);
            pEquipe12 = findViewById(R.id.txtPontosEquipe12);
            jEquipe1 = findViewById(R.id.txtJogosEquipe1);
            jEquipe2 = findViewById(R.id.txtJogosEquipe2);
            jEquipe3 = findViewById(R.id.txtJogosEquipe3);
            jEquipe4 = findViewById(R.id.txtJogosEquipe4);
            jEquipe5 = findViewById(R.id.txtJogosEquipe5);
            jEquipe6 = findViewById(R.id.txtJogosEquipe6);
            jEquipe7 = findViewById(R.id.txtJogosEquipe7);
            jEquipe8 = findViewById(R.id.txtJogosEquipe8);
            jEquipe9 = findViewById(R.id.txtJogosEquipe9);
            jEquipe10 = findViewById(R.id.txtJogosEquipe10);
            jEquipe11 = findViewById(R.id.txtJogosEquipe11);
            jEquipe12 = findViewById(R.id.txtJogosEquipe12);
            vEquipe1 = findViewById(R.id.txtVitoriasEquipe1);
            vEquipe2 = findViewById(R.id.txtVitoriasEquipe2);
            vEquipe3 = findViewById(R.id.txtVitoriasEquipe3);
            vEquipe4 = findViewById(R.id.txtVitoriasEquipe4);
            vEquipe5 = findViewById(R.id.txtVitoriasEquipe5);
            vEquipe6 = findViewById(R.id.txtVitoriasEquipe6);
            vEquipe7 = findViewById(R.id.txtVitoriasEquipe7);
            vEquipe8 = findViewById(R.id.txtVitoriasEquipe8);
            vEquipe9 = findViewById(R.id.txtVitoriasEquipe9);
            vEquipe10 = findViewById(R.id.txtVitoriasEquipe10);
            vEquipe11 = findViewById(R.id.txtVitoriasEquipe11);
            vEquipe12 = findViewById(R.id.txtVitoriasEquipe12);
            eEquipe1 = findViewById(R.id.txtEmpatesEquipe1);
            eEquipe2 = findViewById(R.id.txtEmpatesEquipe2);
            eEquipe3 = findViewById(R.id.txtEmpatesEquipe3);
            eEquipe4 = findViewById(R.id.txtEmpatesEquipe4);
            eEquipe5 = findViewById(R.id.txtEmpatesEquipe5);
            eEquipe6 = findViewById(R.id.txtEmpatesEquipe6);
            eEquipe7 = findViewById(R.id.txtEmpatesEquipe7);
            eEquipe8 = findViewById(R.id.txtEmpatesEquipe8);
            eEquipe9 = findViewById(R.id.txtEmpatesEquipe9);
            eEquipe10 = findViewById(R.id.txtEmpatesEquipe10);
            eEquipe11 = findViewById(R.id.txtEmpatesEquipe11);
            eEquipe12 = findViewById(R.id.txtEmpatesEquipe12);
            dEquipe1 = findViewById(R.id.txtDerrotasEquipe1);
            dEquipe2 = findViewById(R.id.txtDerrotasEquipe2);
            dEquipe3 = findViewById(R.id.txtDerrotasEquipe3);
            dEquipe4 = findViewById(R.id.txtDerrotasEquipe4);
            dEquipe5 = findViewById(R.id.txtDerrotasEquipe5);
            dEquipe6 = findViewById(R.id.txtDerrotasEquipe6);
            dEquipe7 = findViewById(R.id.txtDerrotasEquipe7);
            dEquipe8 = findViewById(R.id.txtDerrotasEquipe8);
            dEquipe9 = findViewById(R.id.txtDerrotasEquipe9);
            dEquipe10 = findViewById(R.id.txtDerrotasEquipe10);
            dEquipe11 = findViewById(R.id.txtDerrotasEquipe11);
            dEquipe12 = findViewById(R.id.txtDerrotasEquipe12);
            gpEquipe1 = findViewById(R.id.txtGolsProEquipe1);
            gpEquipe2 = findViewById(R.id.txtGolsProEquipe2);
            gpEquipe3 = findViewById(R.id.txtGolsProEquipe3);
            gpEquipe4 = findViewById(R.id.txtGolsProEquipe4);
            gpEquipe5 = findViewById(R.id.txtGolsProEquipe5);
            gpEquipe6 = findViewById(R.id.txtGolsProEquipe6);
            gpEquipe7 = findViewById(R.id.txtGolsProEquipe7);
            gpEquipe8 = findViewById(R.id.txtGolsProEquipe8);
            gpEquipe9 = findViewById(R.id.txtGolsProEquipe9);
            gpEquipe10 = findViewById(R.id.txtGolsProEquipe10);
            gpEquipe11 = findViewById(R.id.txtGolsProEquipe11);
            gpEquipe12 = findViewById(R.id.txtGolsProEquipe12);
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
            sgEquipe1 = findViewById(R.id.txtSaldoGolsEquipe1);
            sgEquipe2 = findViewById(R.id.txtSaldoGolsEquipe2);
            sgEquipe3 = findViewById(R.id.txtSaldoGolsEquipe3);
            sgEquipe4 = findViewById(R.id.txtSaldoGolsEquipe4);
            sgEquipe5 = findViewById(R.id.txtSaldoGolsEquipe5);
            sgEquipe6 = findViewById(R.id.txtSaldoGolsEquipe6);
            sgEquipe7 = findViewById(R.id.txtSaldoGolsEquipe7);
            sgEquipe8 = findViewById(R.id.txtSaldoGolsEquipe8);
            sgEquipe9 = findViewById(R.id.txtSaldoGolsEquipe9);
            sgEquipe10 = findViewById(R.id.txtSaldoGolsEquipe10);
            sgEquipe11 = findViewById(R.id.txtSaldoGolsEquipe11);
            sgEquipe12 = findViewById(R.id.txtSaldoGolsEquipe12);

            grupo1 = new Grupo();
            grupo1.setId(grupo1ID);
            equipe1 = new Equipe();
            equipe1.setId(equipe1ID);
            equipe2 = new Equipe();
            equipe2.setId(equipe2ID);
            equipe3 = new Equipe();
            equipe3.setId(equipe3ID);

            grupo2 = new Grupo();
            grupo2.setId(grupo2ID);
            equipe4 = new Equipe();
            equipe4.setId(equipe4ID);
            equipe5 = new Equipe();
            equipe5.setId(equipe5ID);
            equipe6 = new Equipe();
            equipe6.setId(equipe6ID);

            grupo3 = new Grupo();
            grupo3.setId(grupo3ID);
            equipe7 = new Equipe();
            equipe7.setId(equipe7ID);
            equipe8 = new Equipe();
            equipe8.setId(equipe8ID);
            equipe9 = new Equipe();
            equipe9.setId(equipe9ID);

            grupo4 = new Grupo();
            grupo4.setId(grupo4ID);
            equipe10 = new Equipe();
            equipe10.setId(equipe10ID);
            equipe11 = new Equipe();
            equipe11.setId(equipe11ID);
            equipe12 = new Equipe();
            equipe12.setId(equipe12ID);

            equipesA = new Equipe[quantidade2];
            equipesB = new Equipe[quantidade2];
            equipesC = new Equipe[quantidade2];
            equipesD = new Equipe[quantidade2];

            equipeController = new EquipeController(this);
            grupoController = new GrupoController(this);
        } else if (qtdEquipes == 16) {

            txtNomeGrupoA = findViewById(R.id.txtNomeGrupoA);
            txtNomeGrupoB = findViewById(R.id.txtNomeGrupoB);
            txtNomeGrupoC = findViewById(R.id.txtNomeGrupoC);
            txtNomeGrupoD = findViewById(R.id.txtNomeGrupoD);
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
            pEquipe1 = findViewById(R.id.txtPontosEquipe1);
            pEquipe2 = findViewById(R.id.txtPontosEquipe2);
            pEquipe3 = findViewById(R.id.txtPontosEquipe3);
            pEquipe4 = findViewById(R.id.txtPontosEquipe4);
            pEquipe5 = findViewById(R.id.txtPontosEquipe5);
            pEquipe6 = findViewById(R.id.txtPontosEquipe6);
            pEquipe7 = findViewById(R.id.txtPontosEquipe7);
            pEquipe8 = findViewById(R.id.txtPontosEquipe8);
            pEquipe9 = findViewById(R.id.txtPontosEquipe9);
            pEquipe10 = findViewById(R.id.txtPontosEquipe10);
            pEquipe11 = findViewById(R.id.txtPontosEquipe11);
            pEquipe12 = findViewById(R.id.txtPontosEquipe12);
            pEquipe13 = findViewById(R.id.txtPontosEquipe13);
            pEquipe14 = findViewById(R.id.txtPontosEquipe14);
            pEquipe15 = findViewById(R.id.txtPontosEquipe15);
            pEquipe16 = findViewById(R.id.txtPontosEquipe16);
            jEquipe1 = findViewById(R.id.txtJogosEquipe1);
            jEquipe2 = findViewById(R.id.txtJogosEquipe2);
            jEquipe3 = findViewById(R.id.txtJogosEquipe3);
            jEquipe4 = findViewById(R.id.txtJogosEquipe4);
            jEquipe5 = findViewById(R.id.txtJogosEquipe5);
            jEquipe6 = findViewById(R.id.txtJogosEquipe6);
            jEquipe7 = findViewById(R.id.txtJogosEquipe7);
            jEquipe8 = findViewById(R.id.txtJogosEquipe8);
            jEquipe9 = findViewById(R.id.txtJogosEquipe9);
            jEquipe10 = findViewById(R.id.txtJogosEquipe10);
            jEquipe11 = findViewById(R.id.txtJogosEquipe11);
            jEquipe12 = findViewById(R.id.txtJogosEquipe12);
            jEquipe13 = findViewById(R.id.txtJogosEquipe13);
            jEquipe14 = findViewById(R.id.txtJogosEquipe14);
            jEquipe15 = findViewById(R.id.txtJogosEquipe15);
            jEquipe16 = findViewById(R.id.txtJogosEquipe16);
            vEquipe1 = findViewById(R.id.txtVitoriasEquipe1);
            vEquipe2 = findViewById(R.id.txtVitoriasEquipe2);
            vEquipe3 = findViewById(R.id.txtVitoriasEquipe3);
            vEquipe4 = findViewById(R.id.txtVitoriasEquipe4);
            vEquipe5 = findViewById(R.id.txtVitoriasEquipe5);
            vEquipe6 = findViewById(R.id.txtVitoriasEquipe6);
            vEquipe7 = findViewById(R.id.txtVitoriasEquipe7);
            vEquipe8 = findViewById(R.id.txtVitoriasEquipe8);
            vEquipe9 = findViewById(R.id.txtVitoriasEquipe9);
            vEquipe10 = findViewById(R.id.txtVitoriasEquipe10);
            vEquipe11 = findViewById(R.id.txtVitoriasEquipe11);
            vEquipe12 = findViewById(R.id.txtVitoriasEquipe12);
            vEquipe13 = findViewById(R.id.txtVitoriasEquipe13);
            vEquipe14 = findViewById(R.id.txtVitoriasEquipe14);
            vEquipe15 = findViewById(R.id.txtVitoriasEquipe15);
            vEquipe16 = findViewById(R.id.txtVitoriasEquipe16);
            eEquipe1 = findViewById(R.id.txtEmpatesEquipe1);
            eEquipe2 = findViewById(R.id.txtEmpatesEquipe2);
            eEquipe3 = findViewById(R.id.txtEmpatesEquipe3);
            eEquipe4 = findViewById(R.id.txtEmpatesEquipe4);
            eEquipe5 = findViewById(R.id.txtEmpatesEquipe5);
            eEquipe6 = findViewById(R.id.txtEmpatesEquipe6);
            eEquipe7 = findViewById(R.id.txtEmpatesEquipe7);
            eEquipe8 = findViewById(R.id.txtEmpatesEquipe8);
            eEquipe9 = findViewById(R.id.txtEmpatesEquipe9);
            eEquipe10 = findViewById(R.id.txtEmpatesEquipe10);
            eEquipe11 = findViewById(R.id.txtEmpatesEquipe11);
            eEquipe12 = findViewById(R.id.txtEmpatesEquipe12);
            eEquipe13 = findViewById(R.id.txtEmpatesEquipe13);
            eEquipe14 = findViewById(R.id.txtEmpatesEquipe14);
            eEquipe15 = findViewById(R.id.txtEmpatesEquipe15);
            eEquipe16 = findViewById(R.id.txtEmpatesEquipe16);
            dEquipe1 = findViewById(R.id.txtDerrotasEquipe1);
            dEquipe2 = findViewById(R.id.txtDerrotasEquipe2);
            dEquipe3 = findViewById(R.id.txtDerrotasEquipe3);
            dEquipe4 = findViewById(R.id.txtDerrotasEquipe4);
            dEquipe5 = findViewById(R.id.txtDerrotasEquipe5);
            dEquipe6 = findViewById(R.id.txtDerrotasEquipe6);
            dEquipe7 = findViewById(R.id.txtDerrotasEquipe7);
            dEquipe8 = findViewById(R.id.txtDerrotasEquipe8);
            dEquipe9 = findViewById(R.id.txtDerrotasEquipe9);
            dEquipe10 = findViewById(R.id.txtDerrotasEquipe10);
            dEquipe11 = findViewById(R.id.txtDerrotasEquipe11);
            dEquipe12 = findViewById(R.id.txtDerrotasEquipe12);
            dEquipe13 = findViewById(R.id.txtDerrotasEquipe13);
            dEquipe14 = findViewById(R.id.txtDerrotasEquipe14);
            dEquipe15 = findViewById(R.id.txtDerrotasEquipe15);
            dEquipe16 = findViewById(R.id.txtDerrotasEquipe16);
            gpEquipe1 = findViewById(R.id.txtGolsProEquipe1);
            gpEquipe2 = findViewById(R.id.txtGolsProEquipe2);
            gpEquipe3 = findViewById(R.id.txtGolsProEquipe3);
            gpEquipe4 = findViewById(R.id.txtGolsProEquipe4);
            gpEquipe5 = findViewById(R.id.txtGolsProEquipe5);
            gpEquipe6 = findViewById(R.id.txtGolsProEquipe6);
            gpEquipe7 = findViewById(R.id.txtGolsProEquipe7);
            gpEquipe8 = findViewById(R.id.txtGolsProEquipe8);
            gpEquipe9 = findViewById(R.id.txtGolsProEquipe9);
            gpEquipe10 = findViewById(R.id.txtGolsProEquipe10);
            gpEquipe11 = findViewById(R.id.txtGolsProEquipe11);
            gpEquipe12 = findViewById(R.id.txtGolsProEquipe12);
            gpEquipe13 = findViewById(R.id.txtGolsProEquipe13);
            gpEquipe14 = findViewById(R.id.txtGolsProEquipe14);
            gpEquipe15 = findViewById(R.id.txtGolsProEquipe15);
            gpEquipe16 = findViewById(R.id.txtGolsProEquipe16);
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
            sgEquipe1 = findViewById(R.id.txtSaldoGolsEquipe1);
            sgEquipe2 = findViewById(R.id.txtSaldoGolsEquipe2);
            sgEquipe3 = findViewById(R.id.txtSaldoGolsEquipe3);
            sgEquipe4 = findViewById(R.id.txtSaldoGolsEquipe4);
            sgEquipe5 = findViewById(R.id.txtSaldoGolsEquipe5);
            sgEquipe6 = findViewById(R.id.txtSaldoGolsEquipe6);
            sgEquipe7 = findViewById(R.id.txtSaldoGolsEquipe7);
            sgEquipe8 = findViewById(R.id.txtSaldoGolsEquipe8);
            sgEquipe9 = findViewById(R.id.txtSaldoGolsEquipe9);
            sgEquipe10 = findViewById(R.id.txtSaldoGolsEquipe10);
            sgEquipe11 = findViewById(R.id.txtSaldoGolsEquipe11);
            sgEquipe12 = findViewById(R.id.txtSaldoGolsEquipe12);
            sgEquipe13 = findViewById(R.id.txtSaldoGolsEquipe13);
            sgEquipe14 = findViewById(R.id.txtSaldoGolsEquipe14);
            sgEquipe15 = findViewById(R.id.txtSaldoGolsEquipe15);
            sgEquipe16 = findViewById(R.id.txtSaldoGolsEquipe16);

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

            grupo2 = new Grupo();
            grupo2.setId(grupo2ID);
            equipe5 = new Equipe();
            equipe5.setId(equipe5ID);
            equipe6 = new Equipe();
            equipe6.setId(equipe6ID);
            equipe7 = new Equipe();
            equipe7.setId(equipe7ID);
            equipe8 = new Equipe();
            equipe8.setId(equipe8ID);

            grupo3 = new Grupo();
            grupo3.setId(grupo3ID);
            equipe9 = new Equipe();
            equipe9.setId(equipe9ID);
            equipe10 = new Equipe();
            equipe10.setId(equipe10ID);
            equipe11 = new Equipe();
            equipe11.setId(equipe11ID);
            equipe12 = new Equipe();
            equipe12.setId(equipe12ID);

            grupo4 = new Grupo();
            grupo4.setId(grupo4ID);
            equipe13 = new Equipe();
            equipe13.setId(equipe13ID);
            equipe14 = new Equipe();
            equipe14.setId(equipe14ID);
            equipe15 = new Equipe();
            equipe15.setId(equipe15ID);
            equipe16 = new Equipe();
            equipe16.setId(equipe16ID);

            equipesA = new Equipe[quantidade1];
            equipesB = new Equipe[quantidade1];
            equipesC = new Equipe[quantidade1];
            equipesD = new Equipe[quantidade1];

            equipeController = new EquipeController(this);
            grupoController = new GrupoController(this);

        }
    }

    private void popularFormulario() {

        if (qtdEquipes == 4) {

            if (finalizouPrimeiraFase) {

                if (grupo1ID >= 1) {

                    grupo1 = grupoController.getGrupoByID(grupo1);
                    equipe1 = equipeController.getEquipeByID(equipe1);
                    equipe2 = equipeController.getEquipeByID(equipe2);
                    equipe3 = equipeController.getEquipeByID(equipe3);
                    equipe4 = equipeController.getEquipeByID(equipe4);

                    grupo1.setNome("Grupo A");

                    equipe1.setPontos(pEquipe1Class);
                    equipe1.setJogos(jEquipe1Class);
                    equipe1.setVitorias(vEquipe1Class);
                    equipe1.setEmpates(eEquipe1Class);
                    equipe1.setDerrotas(dEquipe1Class);
                    equipe1.setGolsPro(gpEquipe1Class);
                    equipe1.setGolsContra(gcEquipe1Class);
                    equipe1.setSaldoGols(sgEquipe1Class);

                    equipe2.setPontos(pEquipe2Class);
                    equipe2.setJogos(jEquipe2Class);
                    equipe2.setVitorias(vEquipe2Class);
                    equipe2.setEmpates(eEquipe2Class);
                    equipe2.setDerrotas(dEquipe2Class);
                    equipe2.setGolsPro(gpEquipe2Class);
                    equipe2.setGolsContra(gcEquipe2Class);
                    equipe2.setSaldoGols(sgEquipe2Class);

                    equipe3.setPontos(pEquipe3Class);
                    equipe3.setJogos(jEquipe3Class);
                    equipe3.setVitorias(vEquipe3Class);
                    equipe3.setEmpates(eEquipe3Class);
                    equipe3.setDerrotas(dEquipe3Class);
                    equipe3.setGolsPro(gpEquipe3Class);
                    equipe3.setGolsContra(gcEquipe3Class);
                    equipe3.setSaldoGols(sgEquipe3Class);

                    equipe4.setPontos(pEquipe4Class);
                    equipe4.setJogos(jEquipe4Class);
                    equipe4.setVitorias(vEquipe4Class);
                    equipe4.setEmpates(eEquipe4Class);
                    equipe4.setDerrotas(dEquipe4Class);
                    equipe4.setGolsPro(gpEquipe4Class);
                    equipe4.setGolsContra(gcEquipe4Class);
                    equipe4.setSaldoGols(sgEquipe4Class);

                    equipes[0] = equipe1;
                    equipes[1] = equipe2;
                    equipes[2] = equipe3;
                    equipes[3] = equipe4;

                    txtNomeGrupoA.setText(grupo1.getNome());

                    ordenaGrupo(equipes);

                    grupo1.setEquipe1(equipes[0]);
                    txtEquipe1.setText(grupo1.getEquipe1().getNome());
                    pEquipe1.setText(String.valueOf(grupo1.getEquipe1().getPontos()));
                    jEquipe1.setText(String.valueOf(grupo1.getEquipe1().getJogos()));
                    vEquipe1.setText(String.valueOf(grupo1.getEquipe1().getVitorias()));
                    eEquipe1.setText(String.valueOf(grupo1.getEquipe1().getEmpates()));
                    dEquipe1.setText(String.valueOf(grupo1.getEquipe1().getDerrotas()));
                    gpEquipe1.setText(String.valueOf(grupo1.getEquipe1().getGolsPro()));
                    gcEquipe1.setText(String.valueOf(grupo1.getEquipe1().getGolsContra()));
                    sgEquipe1.setText(String.valueOf(grupo1.getEquipe1().getSaldoGols()));

                    grupo1.setEquipe2(equipes[1]);
                    txtEquipe2.setText(grupo1.getEquipe2().getNome());
                    pEquipe2.setText(String.valueOf(grupo1.getEquipe2().getPontos()));
                    jEquipe2.setText(String.valueOf(grupo1.getEquipe2().getJogos()));
                    vEquipe2.setText(String.valueOf(grupo1.getEquipe2().getVitorias()));
                    eEquipe2.setText(String.valueOf(grupo1.getEquipe2().getEmpates()));
                    dEquipe2.setText(String.valueOf(grupo1.getEquipe2().getDerrotas()));
                    gpEquipe2.setText(String.valueOf(grupo1.getEquipe2().getGolsPro()));
                    gcEquipe2.setText(String.valueOf(grupo1.getEquipe2().getGolsContra()));
                    sgEquipe2.setText(String.valueOf(grupo1.getEquipe2().getSaldoGols()));

                    grupo1.setEquipe3(equipes[2]);
                    txtEquipe3.setText(grupo1.getEquipe3().getNome());
                    pEquipe3.setText(String.valueOf(grupo1.getEquipe3().getPontos()));
                    jEquipe3.setText(String.valueOf(grupo1.getEquipe3().getJogos()));
                    vEquipe3.setText(String.valueOf(grupo1.getEquipe3().getVitorias()));
                    eEquipe3.setText(String.valueOf(grupo1.getEquipe3().getEmpates()));
                    dEquipe3.setText(String.valueOf(grupo1.getEquipe3().getDerrotas()));
                    gpEquipe3.setText(String.valueOf(grupo1.getEquipe3().getGolsPro()));
                    gcEquipe3.setText(String.valueOf(grupo1.getEquipe3().getGolsContra()));
                    sgEquipe3.setText(String.valueOf(grupo1.getEquipe3().getSaldoGols()));

                    grupo1.setEquipe4(equipes[3]);
                    txtEquipe4.setText(grupo1.getEquipe4().getNome());
                    pEquipe4.setText(String.valueOf(grupo1.getEquipe4().getPontos()));
                    jEquipe4.setText(String.valueOf(grupo1.getEquipe4().getJogos()));
                    vEquipe4.setText(String.valueOf(grupo1.getEquipe4().getVitorias()));
                    eEquipe4.setText(String.valueOf(grupo1.getEquipe4().getEmpates()));
                    dEquipe4.setText(String.valueOf(grupo1.getEquipe4().getDerrotas()));
                    gpEquipe4.setText(String.valueOf(grupo1.getEquipe4().getGolsPro()));
                    gcEquipe4.setText(String.valueOf(grupo1.getEquipe4().getGolsContra()));
                    sgEquipe4.setText(String.valueOf(grupo1.getEquipe4().getSaldoGols()));

                } else {

                    new FancyAlertDialog.Builder(Classificacao.this)
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
                                    Intent intent = new Intent(Classificacao.this, Dashboard.class);
                                    startActivity(intent);
                                }
                            })
                            .build();
                }

            } else {

                if (grupo1ID >= 1) {

                    grupo1 = grupoController.getGrupoByID(grupo1);
                    equipe1 = equipeController.getEquipeByID(equipe1);
                    equipe2 = equipeController.getEquipeByID(equipe2);
                    equipe3 = equipeController.getEquipeByID(equipe3);
                    equipe4 = equipeController.getEquipeByID(equipe4);

                    equipes[0] = equipe1;
                    equipes[1] = equipe2;
                    equipes[2] = equipe3;
                    equipes[3] = equipe4;

                    txtNomeGrupoA.setText(grupo1.getNome());

                    ordenaGrupo(equipes);

                    grupo1.setEquipe1(equipes[0]);
                    txtEquipe1.setText(grupo1.getEquipe1().getNome());
                    pEquipe1.setText(String.valueOf(grupo1.getEquipe1().getPontos()));
                    jEquipe1.setText(String.valueOf(grupo1.getEquipe1().getJogos()));
                    vEquipe1.setText(String.valueOf(grupo1.getEquipe1().getVitorias()));
                    eEquipe1.setText(String.valueOf(grupo1.getEquipe1().getEmpates()));
                    dEquipe1.setText(String.valueOf(grupo1.getEquipe1().getDerrotas()));
                    gpEquipe1.setText(String.valueOf(grupo1.getEquipe1().getGolsPro()));
                    gcEquipe1.setText(String.valueOf(grupo1.getEquipe1().getGolsContra()));
                    sgEquipe1.setText(String.valueOf(grupo1.getEquipe1().getSaldoGols()));

                    grupo1.setEquipe2(equipes[1]);
                    txtEquipe2.setText(grupo1.getEquipe2().getNome());
                    pEquipe2.setText(String.valueOf(grupo1.getEquipe2().getPontos()));
                    jEquipe2.setText(String.valueOf(grupo1.getEquipe2().getJogos()));
                    vEquipe2.setText(String.valueOf(grupo1.getEquipe2().getVitorias()));
                    eEquipe2.setText(String.valueOf(grupo1.getEquipe2().getEmpates()));
                    dEquipe2.setText(String.valueOf(grupo1.getEquipe2().getDerrotas()));
                    gpEquipe2.setText(String.valueOf(grupo1.getEquipe2().getGolsPro()));
                    gcEquipe2.setText(String.valueOf(grupo1.getEquipe2().getGolsContra()));
                    sgEquipe2.setText(String.valueOf(grupo1.getEquipe2().getSaldoGols()));

                    grupo1.setEquipe3(equipes[2]);
                    txtEquipe3.setText(grupo1.getEquipe3().getNome());
                    pEquipe3.setText(String.valueOf(grupo1.getEquipe3().getPontos()));
                    jEquipe3.setText(String.valueOf(grupo1.getEquipe3().getJogos()));
                    vEquipe3.setText(String.valueOf(grupo1.getEquipe3().getVitorias()));
                    eEquipe3.setText(String.valueOf(grupo1.getEquipe3().getEmpates()));
                    dEquipe3.setText(String.valueOf(grupo1.getEquipe3().getDerrotas()));
                    gpEquipe3.setText(String.valueOf(grupo1.getEquipe3().getGolsPro()));
                    gcEquipe3.setText(String.valueOf(grupo1.getEquipe3().getGolsContra()));
                    sgEquipe3.setText(String.valueOf(grupo1.getEquipe3().getSaldoGols()));

                    grupo1.setEquipe4(equipes[3]);
                    txtEquipe4.setText(grupo1.getEquipe4().getNome());
                    pEquipe4.setText(String.valueOf(grupo1.getEquipe4().getPontos()));
                    jEquipe4.setText(String.valueOf(grupo1.getEquipe4().getJogos()));
                    vEquipe4.setText(String.valueOf(grupo1.getEquipe4().getVitorias()));
                    eEquipe4.setText(String.valueOf(grupo1.getEquipe4().getEmpates()));
                    dEquipe4.setText(String.valueOf(grupo1.getEquipe4().getDerrotas()));
                    gpEquipe4.setText(String.valueOf(grupo1.getEquipe4().getGolsPro()));
                    gcEquipe4.setText(String.valueOf(grupo1.getEquipe4().getGolsContra()));
                    sgEquipe4.setText(String.valueOf(grupo1.getEquipe4().getSaldoGols()));

                } else {

                    new FancyAlertDialog.Builder(Classificacao.this)
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
                                    Intent intent = new Intent(Classificacao.this, Dashboard.class);
                                    startActivity(intent);
                                }
                            })
                            .build();
                }
            }

        } else if (qtdEquipes == 12) {

            if (finalizouPrimeiraFase) {

                if (grupo4ID >= 1) {

                    grupo1 = grupoController.getGrupoByID(grupo1);
                    equipe1 = equipeController.getEquipeByID(equipe1);
                    equipe2 = equipeController.getEquipeByID(equipe2);
                    equipe3 = equipeController.getEquipeByID(equipe3);
                    grupo2 = grupoController.getGrupoByID(grupo2);
                    equipe4 = equipeController.getEquipeByID(equipe4);
                    equipe5 = equipeController.getEquipeByID(equipe5);
                    equipe6 = equipeController.getEquipeByID(equipe6);
                    grupo3 = grupoController.getGrupoByID(grupo3);
                    equipe7 = equipeController.getEquipeByID(equipe7);
                    equipe8 = equipeController.getEquipeByID(equipe8);
                    equipe9 = equipeController.getEquipeByID(equipe9);
                    grupo4 = grupoController.getGrupoByID(grupo4);
                    equipe10 = equipeController.getEquipeByID(equipe10);
                    equipe11 = equipeController.getEquipeByID(equipe11);
                    equipe12 = equipeController.getEquipeByID(equipe12);

                    grupo1.setNome("Grupo A");
                    grupo2.setNome("Grupo B");
                    grupo3.setNome("Grupo C");
                    grupo4.setNome("Grupo D");

                    equipe1.setPontos(pEquipe1Class);
                    equipe1.setJogos(jEquipe1Class);
                    equipe1.setVitorias(vEquipe1Class);
                    equipe1.setEmpates(eEquipe1Class);
                    equipe1.setDerrotas(dEquipe1Class);
                    equipe1.setGolsPro(gpEquipe1Class);
                    equipe1.setGolsContra(gcEquipe1Class);
                    equipe1.setSaldoGols(sgEquipe1Class);

                    equipe2.setPontos(pEquipe2Class);
                    equipe2.setJogos(jEquipe2Class);
                    equipe2.setVitorias(vEquipe2Class);
                    equipe2.setEmpates(eEquipe2Class);
                    equipe2.setDerrotas(dEquipe2Class);
                    equipe2.setGolsPro(gpEquipe2Class);
                    equipe2.setGolsContra(gcEquipe2Class);
                    equipe2.setSaldoGols(sgEquipe2Class);

                    equipe3.setPontos(pEquipe3Class);
                    equipe3.setJogos(jEquipe3Class);
                    equipe3.setVitorias(vEquipe3Class);
                    equipe3.setEmpates(eEquipe3Class);
                    equipe3.setDerrotas(dEquipe3Class);
                    equipe3.setGolsPro(gpEquipe3Class);
                    equipe3.setGolsContra(gcEquipe3Class);
                    equipe3.setSaldoGols(sgEquipe3Class);

                    equipe4.setPontos(pEquipe4Class);
                    equipe4.setJogos(jEquipe4Class);
                    equipe4.setVitorias(vEquipe4Class);
                    equipe4.setEmpates(eEquipe4Class);
                    equipe4.setDerrotas(dEquipe4Class);
                    equipe4.setGolsPro(gpEquipe4Class);
                    equipe4.setGolsContra(gcEquipe4Class);
                    equipe4.setSaldoGols(sgEquipe4Class);

                    equipe5.setPontos(pEquipe5Class);
                    equipe5.setJogos(jEquipe5Class);
                    equipe5.setVitorias(vEquipe5Class);
                    equipe5.setEmpates(eEquipe5Class);
                    equipe5.setDerrotas(dEquipe5Class);
                    equipe5.setGolsPro(gpEquipe5Class);
                    equipe5.setGolsContra(gcEquipe5Class);
                    equipe5.setSaldoGols(sgEquipe5Class);

                    equipe5.setPontos(pEquipe5Class);
                    equipe5.setJogos(jEquipe5Class);
                    equipe5.setVitorias(vEquipe5Class);
                    equipe5.setEmpates(eEquipe5Class);
                    equipe5.setDerrotas(dEquipe5Class);
                    equipe5.setGolsPro(gpEquipe5Class);
                    equipe5.setGolsContra(gcEquipe5Class);
                    equipe5.setSaldoGols(sgEquipe5Class);

                    equipe6.setPontos(pEquipe6Class);
                    equipe6.setJogos(jEquipe6Class);
                    equipe6.setVitorias(vEquipe6Class);
                    equipe6.setEmpates(eEquipe6Class);
                    equipe6.setDerrotas(dEquipe6Class);
                    equipe6.setGolsPro(gpEquipe6Class);
                    equipe6.setGolsContra(gcEquipe6Class);
                    equipe6.setSaldoGols(sgEquipe6Class);

                    equipe7.setPontos(pEquipe7Class);
                    equipe7.setJogos(jEquipe7Class);
                    equipe7.setVitorias(vEquipe7Class);
                    equipe7.setEmpates(eEquipe7Class);
                    equipe7.setDerrotas(dEquipe7Class);
                    equipe7.setGolsPro(gpEquipe7Class);
                    equipe7.setGolsContra(gcEquipe7Class);
                    equipe7.setSaldoGols(sgEquipe7Class);

                    equipe8.setPontos(pEquipe8Class);
                    equipe8.setJogos(jEquipe8Class);
                    equipe8.setVitorias(vEquipe8Class);
                    equipe8.setEmpates(eEquipe8Class);
                    equipe8.setDerrotas(dEquipe8Class);
                    equipe8.setGolsPro(gpEquipe8Class);
                    equipe8.setGolsContra(gcEquipe8Class);
                    equipe8.setSaldoGols(sgEquipe8Class);

                    equipe9.setPontos(pEquipe9Class);
                    equipe9.setJogos(jEquipe9Class);
                    equipe9.setVitorias(vEquipe9Class);
                    equipe9.setEmpates(eEquipe9Class);
                    equipe9.setDerrotas(dEquipe9Class);
                    equipe9.setGolsPro(gpEquipe9Class);
                    equipe9.setGolsContra(gcEquipe9Class);
                    equipe9.setSaldoGols(sgEquipe9Class);

                    equipe10.setPontos(pEquipe10Class);
                    equipe10.setJogos(jEquipe10Class);
                    equipe10.setVitorias(vEquipe10Class);
                    equipe10.setEmpates(eEquipe10Class);
                    equipe10.setDerrotas(dEquipe10Class);
                    equipe10.setGolsPro(gpEquipe10Class);
                    equipe10.setGolsContra(gcEquipe10Class);
                    equipe10.setSaldoGols(sgEquipe10Class);

                    equipe11.setPontos(pEquipe11Class);
                    equipe11.setJogos(jEquipe11Class);
                    equipe11.setVitorias(vEquipe11Class);
                    equipe11.setEmpates(eEquipe11Class);
                    equipe11.setDerrotas(dEquipe11Class);
                    equipe11.setGolsPro(gpEquipe11Class);
                    equipe11.setGolsContra(gcEquipe11Class);
                    equipe11.setSaldoGols(sgEquipe11Class);

                    equipe12.setPontos(pEquipe12Class);
                    equipe12.setJogos(jEquipe12Class);
                    equipe12.setVitorias(vEquipe12Class);
                    equipe12.setEmpates(eEquipe12Class);
                    equipe12.setDerrotas(dEquipe12Class);
                    equipe12.setGolsPro(gpEquipe12Class);
                    equipe12.setGolsContra(gcEquipe12Class);
                    equipe12.setSaldoGols(sgEquipe12Class);

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

                    //Grupo 1
                    txtNomeGrupoA.setText(grupo1.getNome());
                    grupo1.setEquipe1(equipesA[0]);
                    txtEquipe1.setText(grupo1.getEquipe1().getNome());
                    pEquipe1.setText(String.valueOf(grupo1.getEquipe1().getPontos()));
                    jEquipe1.setText(String.valueOf(grupo1.getEquipe1().getJogos()));
                    vEquipe1.setText(String.valueOf(grupo1.getEquipe1().getVitorias()));
                    eEquipe1.setText(String.valueOf(grupo1.getEquipe1().getEmpates()));
                    dEquipe1.setText(String.valueOf(grupo1.getEquipe1().getDerrotas()));
                    gpEquipe1.setText(String.valueOf(grupo1.getEquipe1().getGolsPro()));
                    gcEquipe1.setText(String.valueOf(grupo1.getEquipe1().getGolsContra()));
                    sgEquipe1.setText(String.valueOf(grupo1.getEquipe1().getSaldoGols()));

                    grupo1.setEquipe2(equipesA[1]);
                    txtEquipe2.setText(grupo1.getEquipe2().getNome());
                    pEquipe2.setText(String.valueOf(grupo1.getEquipe2().getPontos()));
                    jEquipe2.setText(String.valueOf(grupo1.getEquipe2().getJogos()));
                    vEquipe2.setText(String.valueOf(grupo1.getEquipe2().getVitorias()));
                    eEquipe2.setText(String.valueOf(grupo1.getEquipe2().getEmpates()));
                    dEquipe2.setText(String.valueOf(grupo1.getEquipe2().getDerrotas()));
                    gpEquipe2.setText(String.valueOf(grupo1.getEquipe2().getGolsPro()));
                    gcEquipe2.setText(String.valueOf(grupo1.getEquipe2().getGolsContra()));
                    sgEquipe2.setText(String.valueOf(grupo1.getEquipe2().getSaldoGols()));

                    grupo1.setEquipe3(equipesA[2]);
                    txtEquipe3.setText(grupo1.getEquipe3().getNome());
                    pEquipe3.setText(String.valueOf(grupo1.getEquipe3().getPontos()));
                    jEquipe3.setText(String.valueOf(grupo1.getEquipe3().getJogos()));
                    vEquipe3.setText(String.valueOf(grupo1.getEquipe3().getVitorias()));
                    eEquipe3.setText(String.valueOf(grupo1.getEquipe3().getEmpates()));
                    dEquipe3.setText(String.valueOf(grupo1.getEquipe3().getDerrotas()));
                    gpEquipe3.setText(String.valueOf(grupo1.getEquipe3().getGolsPro()));
                    gcEquipe3.setText(String.valueOf(grupo1.getEquipe3().getGolsContra()));
                    sgEquipe3.setText(String.valueOf(grupo1.getEquipe3().getSaldoGols()));


                    //Grupo 2
                    txtNomeGrupoB.setText(grupo2.getNome());
                    grupo2.setEquipe1(equipesB[0]);
                    txtEquipe4.setText(grupo2.getEquipe1().getNome());
                    pEquipe4.setText(String.valueOf(grupo2.getEquipe1().getPontos()));
                    jEquipe4.setText(String.valueOf(grupo2.getEquipe1().getJogos()));
                    vEquipe4.setText(String.valueOf(grupo2.getEquipe1().getVitorias()));
                    eEquipe4.setText(String.valueOf(grupo2.getEquipe1().getEmpates()));
                    dEquipe4.setText(String.valueOf(grupo2.getEquipe1().getDerrotas()));
                    gpEquipe4.setText(String.valueOf(grupo2.getEquipe1().getGolsPro()));
                    gcEquipe4.setText(String.valueOf(grupo2.getEquipe1().getGolsContra()));
                    sgEquipe4.setText(String.valueOf(grupo2.getEquipe1().getSaldoGols()));

                    grupo2.setEquipe2(equipesB[1]);
                    txtEquipe5.setText(grupo2.getEquipe2().getNome());
                    pEquipe5.setText(String.valueOf(grupo2.getEquipe2().getPontos()));
                    jEquipe5.setText(String.valueOf(grupo2.getEquipe2().getJogos()));
                    vEquipe5.setText(String.valueOf(grupo2.getEquipe2().getVitorias()));
                    eEquipe5.setText(String.valueOf(grupo2.getEquipe2().getEmpates()));
                    dEquipe5.setText(String.valueOf(grupo2.getEquipe2().getDerrotas()));
                    gpEquipe5.setText(String.valueOf(grupo2.getEquipe2().getGolsPro()));
                    gcEquipe5.setText(String.valueOf(grupo2.getEquipe2().getGolsContra()));
                    sgEquipe5.setText(String.valueOf(grupo2.getEquipe2().getSaldoGols()));

                    grupo2.setEquipe3(equipesB[2]);
                    txtEquipe6.setText(grupo2.getEquipe3().getNome());
                    pEquipe6.setText(String.valueOf(grupo2.getEquipe3().getPontos()));
                    jEquipe6.setText(String.valueOf(grupo2.getEquipe3().getJogos()));
                    vEquipe6.setText(String.valueOf(grupo2.getEquipe3().getVitorias()));
                    eEquipe6.setText(String.valueOf(grupo2.getEquipe3().getEmpates()));
                    dEquipe6.setText(String.valueOf(grupo2.getEquipe3().getDerrotas()));
                    gpEquipe6.setText(String.valueOf(grupo2.getEquipe3().getGolsPro()));
                    gcEquipe6.setText(String.valueOf(grupo2.getEquipe3().getGolsContra()));
                    sgEquipe6.setText(String.valueOf(grupo2.getEquipe3().getSaldoGols()));


                    //Grupo 3
                    txtNomeGrupoC.setText(grupo3.getNome());
                    grupo3.setEquipe1(equipesC[0]);
                    txtEquipe7.setText(grupo3.getEquipe1().getNome());
                    pEquipe7.setText(String.valueOf(grupo3.getEquipe1().getPontos()));
                    jEquipe7.setText(String.valueOf(grupo3.getEquipe1().getJogos()));
                    vEquipe7.setText(String.valueOf(grupo3.getEquipe1().getVitorias()));
                    eEquipe7.setText(String.valueOf(grupo3.getEquipe1().getEmpates()));
                    dEquipe7.setText(String.valueOf(grupo3.getEquipe1().getDerrotas()));
                    gpEquipe7.setText(String.valueOf(grupo3.getEquipe1().getGolsPro()));
                    gcEquipe7.setText(String.valueOf(grupo3.getEquipe1().getGolsContra()));
                    sgEquipe7.setText(String.valueOf(grupo3.getEquipe1().getSaldoGols()));

                    grupo3.setEquipe2(equipesC[1]);
                    txtEquipe8.setText(grupo3.getEquipe2().getNome());
                    pEquipe8.setText(String.valueOf(grupo3.getEquipe2().getPontos()));
                    jEquipe8.setText(String.valueOf(grupo3.getEquipe2().getJogos()));
                    vEquipe8.setText(String.valueOf(grupo3.getEquipe2().getVitorias()));
                    eEquipe8.setText(String.valueOf(grupo3.getEquipe2().getEmpates()));
                    dEquipe8.setText(String.valueOf(grupo3.getEquipe2().getDerrotas()));
                    gpEquipe8.setText(String.valueOf(grupo3.getEquipe2().getGolsPro()));
                    gcEquipe8.setText(String.valueOf(grupo3.getEquipe2().getGolsContra()));
                    sgEquipe8.setText(String.valueOf(grupo3.getEquipe2().getSaldoGols()));

                    grupo3.setEquipe3(equipesC[2]);
                    txtEquipe9.setText(grupo3.getEquipe3().getNome());
                    pEquipe9.setText(String.valueOf(grupo3.getEquipe3().getPontos()));
                    jEquipe9.setText(String.valueOf(grupo3.getEquipe3().getJogos()));
                    vEquipe9.setText(String.valueOf(grupo3.getEquipe3().getVitorias()));
                    eEquipe9.setText(String.valueOf(grupo3.getEquipe3().getEmpates()));
                    dEquipe9.setText(String.valueOf(grupo3.getEquipe3().getDerrotas()));
                    gpEquipe9.setText(String.valueOf(grupo3.getEquipe3().getGolsPro()));
                    gcEquipe9.setText(String.valueOf(grupo3.getEquipe3().getGolsContra()));
                    sgEquipe9.setText(String.valueOf(grupo3.getEquipe3().getSaldoGols()));


                    //Grupo 4
                    txtNomeGrupoD.setText(grupo4.getNome());
                    grupo4.setEquipe1(equipesD[0]);
                    txtEquipe10.setText(grupo4.getEquipe1().getNome());
                    pEquipe10.setText(String.valueOf(grupo4.getEquipe1().getPontos()));
                    jEquipe10.setText(String.valueOf(grupo4.getEquipe1().getJogos()));
                    vEquipe10.setText(String.valueOf(grupo4.getEquipe1().getVitorias()));
                    eEquipe10.setText(String.valueOf(grupo4.getEquipe1().getEmpates()));
                    dEquipe10.setText(String.valueOf(grupo4.getEquipe1().getDerrotas()));
                    gpEquipe10.setText(String.valueOf(grupo4.getEquipe1().getGolsPro()));
                    gcEquipe10.setText(String.valueOf(grupo4.getEquipe1().getGolsContra()));
                    sgEquipe10.setText(String.valueOf(grupo4.getEquipe1().getSaldoGols()));

                    grupo4.setEquipe2(equipesD[1]);
                    txtEquipe11.setText(grupo4.getEquipe2().getNome());
                    pEquipe11.setText(String.valueOf(grupo4.getEquipe2().getPontos()));
                    jEquipe11.setText(String.valueOf(grupo4.getEquipe2().getJogos()));
                    vEquipe11.setText(String.valueOf(grupo4.getEquipe2().getVitorias()));
                    eEquipe11.setText(String.valueOf(grupo4.getEquipe2().getEmpates()));
                    dEquipe11.setText(String.valueOf(grupo4.getEquipe2().getDerrotas()));
                    gpEquipe11.setText(String.valueOf(grupo4.getEquipe2().getGolsPro()));
                    gcEquipe11.setText(String.valueOf(grupo4.getEquipe2().getGolsContra()));
                    sgEquipe11.setText(String.valueOf(grupo4.getEquipe2().getSaldoGols()));

                    grupo4.setEquipe3(equipesD[2]);
                    txtEquipe12.setText(grupo4.getEquipe3().getNome());
                    pEquipe12.setText(String.valueOf(grupo4.getEquipe3().getPontos()));
                    jEquipe12.setText(String.valueOf(grupo4.getEquipe3().getJogos()));
                    vEquipe12.setText(String.valueOf(grupo4.getEquipe3().getVitorias()));
                    eEquipe12.setText(String.valueOf(grupo4.getEquipe3().getEmpates()));
                    dEquipe12.setText(String.valueOf(grupo4.getEquipe3().getDerrotas()));
                    gpEquipe12.setText(String.valueOf(grupo4.getEquipe3().getGolsPro()));
                    gcEquipe12.setText(String.valueOf(grupo4.getEquipe3().getGolsContra()));
                    sgEquipe12.setText(String.valueOf(grupo4.getEquipe3().getSaldoGols()));

                } else {

                    new FancyAlertDialog.Builder(Classificacao.this)
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
                                    Intent intent = new Intent(Classificacao.this, Dashboard.class);
                                    startActivity(intent);
                                }
                            })
                            .build();
                }
            } else {

                if (grupo4ID >= 1) {

                    grupo1 = grupoController.getGrupoByID(grupo1);
                    equipe1 = equipeController.getEquipeByID(equipe1);
                    equipe2 = equipeController.getEquipeByID(equipe2);
                    equipe3 = equipeController.getEquipeByID(equipe3);
                    grupo2 = grupoController.getGrupoByID(grupo2);
                    equipe4 = equipeController.getEquipeByID(equipe4);
                    equipe5 = equipeController.getEquipeByID(equipe5);
                    equipe6 = equipeController.getEquipeByID(equipe6);
                    grupo3 = grupoController.getGrupoByID(grupo3);
                    equipe7 = equipeController.getEquipeByID(equipe7);
                    equipe8 = equipeController.getEquipeByID(equipe8);
                    equipe9 = equipeController.getEquipeByID(equipe9);
                    grupo4 = grupoController.getGrupoByID(grupo4);
                    equipe10 = equipeController.getEquipeByID(equipe10);
                    equipe11 = equipeController.getEquipeByID(equipe11);
                    equipe12 = equipeController.getEquipeByID(equipe12);

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

                    //Grupo 1
                    txtNomeGrupoA.setText(grupo1.getNome());
                    grupo1.setEquipe1(equipesA[0]);
                    txtEquipe1.setText(grupo1.getEquipe1().getNome());
                    pEquipe1.setText(String.valueOf(grupo1.getEquipe1().getPontos()));
                    jEquipe1.setText(String.valueOf(grupo1.getEquipe1().getJogos()));
                    vEquipe1.setText(String.valueOf(grupo1.getEquipe1().getVitorias()));
                    eEquipe1.setText(String.valueOf(grupo1.getEquipe1().getEmpates()));
                    dEquipe1.setText(String.valueOf(grupo1.getEquipe1().getDerrotas()));
                    gpEquipe1.setText(String.valueOf(grupo1.getEquipe1().getGolsPro()));
                    gcEquipe1.setText(String.valueOf(grupo1.getEquipe1().getGolsContra()));
                    sgEquipe1.setText(String.valueOf(grupo1.getEquipe1().getSaldoGols()));

                    grupo1.setEquipe2(equipesA[1]);
                    txtEquipe2.setText(grupo1.getEquipe2().getNome());
                    pEquipe2.setText(String.valueOf(grupo1.getEquipe2().getPontos()));
                    jEquipe2.setText(String.valueOf(grupo1.getEquipe2().getJogos()));
                    vEquipe2.setText(String.valueOf(grupo1.getEquipe2().getVitorias()));
                    eEquipe2.setText(String.valueOf(grupo1.getEquipe2().getEmpates()));
                    dEquipe2.setText(String.valueOf(grupo1.getEquipe2().getDerrotas()));
                    gpEquipe2.setText(String.valueOf(grupo1.getEquipe2().getGolsPro()));
                    gcEquipe2.setText(String.valueOf(grupo1.getEquipe2().getGolsContra()));
                    sgEquipe2.setText(String.valueOf(grupo1.getEquipe2().getSaldoGols()));

                    grupo1.setEquipe3(equipesA[2]);
                    txtEquipe3.setText(grupo1.getEquipe3().getNome());
                    pEquipe3.setText(String.valueOf(grupo1.getEquipe3().getPontos()));
                    jEquipe3.setText(String.valueOf(grupo1.getEquipe3().getJogos()));
                    vEquipe3.setText(String.valueOf(grupo1.getEquipe3().getVitorias()));
                    eEquipe3.setText(String.valueOf(grupo1.getEquipe3().getEmpates()));
                    dEquipe3.setText(String.valueOf(grupo1.getEquipe3().getDerrotas()));
                    gpEquipe3.setText(String.valueOf(grupo1.getEquipe3().getGolsPro()));
                    gcEquipe3.setText(String.valueOf(grupo1.getEquipe3().getGolsContra()));
                    sgEquipe3.setText(String.valueOf(grupo1.getEquipe3().getSaldoGols()));


                    //Grupo 2
                    txtNomeGrupoB.setText(grupo2.getNome());
                    grupo2.setEquipe1(equipesB[0]);
                    txtEquipe4.setText(grupo2.getEquipe1().getNome());
                    pEquipe4.setText(String.valueOf(grupo2.getEquipe1().getPontos()));
                    jEquipe4.setText(String.valueOf(grupo2.getEquipe1().getJogos()));
                    vEquipe4.setText(String.valueOf(grupo2.getEquipe1().getVitorias()));
                    eEquipe4.setText(String.valueOf(grupo2.getEquipe1().getEmpates()));
                    dEquipe4.setText(String.valueOf(grupo2.getEquipe1().getDerrotas()));
                    gpEquipe4.setText(String.valueOf(grupo2.getEquipe1().getGolsPro()));
                    gcEquipe4.setText(String.valueOf(grupo2.getEquipe1().getGolsContra()));
                    sgEquipe4.setText(String.valueOf(grupo2.getEquipe1().getSaldoGols()));

                    grupo2.setEquipe2(equipesB[1]);
                    txtEquipe5.setText(grupo2.getEquipe2().getNome());
                    pEquipe5.setText(String.valueOf(grupo2.getEquipe2().getPontos()));
                    jEquipe5.setText(String.valueOf(grupo2.getEquipe2().getJogos()));
                    vEquipe5.setText(String.valueOf(grupo2.getEquipe2().getVitorias()));
                    eEquipe5.setText(String.valueOf(grupo2.getEquipe2().getEmpates()));
                    dEquipe5.setText(String.valueOf(grupo2.getEquipe2().getDerrotas()));
                    gpEquipe5.setText(String.valueOf(grupo2.getEquipe2().getGolsPro()));
                    gcEquipe5.setText(String.valueOf(grupo2.getEquipe2().getGolsContra()));
                    sgEquipe5.setText(String.valueOf(grupo2.getEquipe2().getSaldoGols()));

                    grupo2.setEquipe3(equipesB[2]);
                    txtEquipe6.setText(grupo2.getEquipe3().getNome());
                    pEquipe6.setText(String.valueOf(grupo2.getEquipe3().getPontos()));
                    jEquipe6.setText(String.valueOf(grupo2.getEquipe3().getJogos()));
                    vEquipe6.setText(String.valueOf(grupo2.getEquipe3().getVitorias()));
                    eEquipe6.setText(String.valueOf(grupo2.getEquipe3().getEmpates()));
                    dEquipe6.setText(String.valueOf(grupo2.getEquipe3().getDerrotas()));
                    gpEquipe6.setText(String.valueOf(grupo2.getEquipe3().getGolsPro()));
                    gcEquipe6.setText(String.valueOf(grupo2.getEquipe3().getGolsContra()));
                    sgEquipe6.setText(String.valueOf(grupo2.getEquipe3().getSaldoGols()));


                    //Grupo 3
                    txtNomeGrupoC.setText(grupo3.getNome());
                    grupo3.setEquipe1(equipesC[0]);
                    txtEquipe7.setText(grupo3.getEquipe1().getNome());
                    pEquipe7.setText(String.valueOf(grupo3.getEquipe1().getPontos()));
                    jEquipe7.setText(String.valueOf(grupo3.getEquipe1().getJogos()));
                    vEquipe7.setText(String.valueOf(grupo3.getEquipe1().getVitorias()));
                    eEquipe7.setText(String.valueOf(grupo3.getEquipe1().getEmpates()));
                    dEquipe7.setText(String.valueOf(grupo3.getEquipe1().getDerrotas()));
                    gpEquipe7.setText(String.valueOf(grupo3.getEquipe1().getGolsPro()));
                    gcEquipe7.setText(String.valueOf(grupo3.getEquipe1().getGolsContra()));
                    sgEquipe7.setText(String.valueOf(grupo3.getEquipe1().getSaldoGols()));

                    grupo3.setEquipe2(equipesC[1]);
                    txtEquipe8.setText(grupo3.getEquipe2().getNome());
                    pEquipe8.setText(String.valueOf(grupo3.getEquipe2().getPontos()));
                    jEquipe8.setText(String.valueOf(grupo3.getEquipe2().getJogos()));
                    vEquipe8.setText(String.valueOf(grupo3.getEquipe2().getVitorias()));
                    eEquipe8.setText(String.valueOf(grupo3.getEquipe2().getEmpates()));
                    dEquipe8.setText(String.valueOf(grupo3.getEquipe2().getDerrotas()));
                    gpEquipe8.setText(String.valueOf(grupo3.getEquipe2().getGolsPro()));
                    gcEquipe8.setText(String.valueOf(grupo3.getEquipe2().getGolsContra()));
                    sgEquipe8.setText(String.valueOf(grupo3.getEquipe2().getSaldoGols()));

                    grupo3.setEquipe3(equipesC[2]);
                    txtEquipe9.setText(grupo3.getEquipe3().getNome());
                    pEquipe9.setText(String.valueOf(grupo3.getEquipe3().getPontos()));
                    jEquipe9.setText(String.valueOf(grupo3.getEquipe3().getJogos()));
                    vEquipe9.setText(String.valueOf(grupo3.getEquipe3().getVitorias()));
                    eEquipe9.setText(String.valueOf(grupo3.getEquipe3().getEmpates()));
                    dEquipe9.setText(String.valueOf(grupo3.getEquipe3().getDerrotas()));
                    gpEquipe9.setText(String.valueOf(grupo3.getEquipe3().getGolsPro()));
                    gcEquipe9.setText(String.valueOf(grupo3.getEquipe3().getGolsContra()));
                    sgEquipe9.setText(String.valueOf(grupo3.getEquipe3().getSaldoGols()));


                    //Grupo 4
                    txtNomeGrupoD.setText(grupo4.getNome());
                    grupo4.setEquipe1(equipesD[0]);
                    txtEquipe10.setText(grupo4.getEquipe1().getNome());
                    pEquipe10.setText(String.valueOf(grupo4.getEquipe1().getPontos()));
                    jEquipe10.setText(String.valueOf(grupo4.getEquipe1().getJogos()));
                    vEquipe10.setText(String.valueOf(grupo4.getEquipe1().getVitorias()));
                    eEquipe10.setText(String.valueOf(grupo4.getEquipe1().getEmpates()));
                    dEquipe10.setText(String.valueOf(grupo4.getEquipe1().getDerrotas()));
                    gpEquipe10.setText(String.valueOf(grupo4.getEquipe1().getGolsPro()));
                    gcEquipe10.setText(String.valueOf(grupo4.getEquipe1().getGolsContra()));
                    sgEquipe10.setText(String.valueOf(grupo4.getEquipe1().getSaldoGols()));

                    grupo4.setEquipe2(equipesD[1]);
                    txtEquipe11.setText(grupo4.getEquipe2().getNome());
                    pEquipe11.setText(String.valueOf(grupo4.getEquipe2().getPontos()));
                    jEquipe11.setText(String.valueOf(grupo4.getEquipe2().getJogos()));
                    vEquipe11.setText(String.valueOf(grupo4.getEquipe2().getVitorias()));
                    eEquipe11.setText(String.valueOf(grupo4.getEquipe2().getEmpates()));
                    dEquipe11.setText(String.valueOf(grupo4.getEquipe2().getDerrotas()));
                    gpEquipe11.setText(String.valueOf(grupo4.getEquipe2().getGolsPro()));
                    gcEquipe11.setText(String.valueOf(grupo4.getEquipe2().getGolsContra()));
                    sgEquipe11.setText(String.valueOf(grupo4.getEquipe2().getSaldoGols()));

                    grupo4.setEquipe3(equipesD[2]);
                    txtEquipe12.setText(grupo4.getEquipe3().getNome());
                    pEquipe12.setText(String.valueOf(grupo4.getEquipe3().getPontos()));
                    jEquipe12.setText(String.valueOf(grupo4.getEquipe3().getJogos()));
                    vEquipe12.setText(String.valueOf(grupo4.getEquipe3().getVitorias()));
                    eEquipe12.setText(String.valueOf(grupo4.getEquipe3().getEmpates()));
                    dEquipe12.setText(String.valueOf(grupo4.getEquipe3().getDerrotas()));
                    gpEquipe12.setText(String.valueOf(grupo4.getEquipe3().getGolsPro()));
                    gcEquipe12.setText(String.valueOf(grupo4.getEquipe3().getGolsContra()));
                    sgEquipe12.setText(String.valueOf(grupo4.getEquipe3().getSaldoGols()));

                } else {

                    new FancyAlertDialog.Builder(Classificacao.this)
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
                                    Intent intent = new Intent(Classificacao.this, Dashboard.class);
                                    startActivity(intent);
                                }
                            })
                            .build();
                }
            }

        } else if (qtdEquipes == 16) {

            if (finalizouPrimeiraFase) {

                if (grupo4ID >= 1) {

                    grupo1 = grupoController.getGrupoByID(grupo1);
                    equipe1 = equipeController.getEquipeByID(equipe1);
                    equipe2 = equipeController.getEquipeByID(equipe2);
                    equipe3 = equipeController.getEquipeByID(equipe3);
                    equipe4 = equipeController.getEquipeByID(equipe4);
                    grupo2 = grupoController.getGrupoByID(grupo2);
                    equipe5 = equipeController.getEquipeByID(equipe5);
                    equipe6 = equipeController.getEquipeByID(equipe6);
                    equipe7 = equipeController.getEquipeByID(equipe7);
                    equipe8 = equipeController.getEquipeByID(equipe8);
                    grupo3 = grupoController.getGrupoByID(grupo3);
                    equipe9 = equipeController.getEquipeByID(equipe9);
                    equipe10 = equipeController.getEquipeByID(equipe10);
                    equipe11 = equipeController.getEquipeByID(equipe11);
                    equipe12 = equipeController.getEquipeByID(equipe12);
                    grupo4 = grupoController.getGrupoByID(grupo4);
                    equipe13 = equipeController.getEquipeByID(equipe13);
                    equipe14 = equipeController.getEquipeByID(equipe14);
                    equipe15 = equipeController.getEquipeByID(equipe15);
                    equipe16 = equipeController.getEquipeByID(equipe16);

                    grupo1.setNome("Grupo A");
                    grupo2.setNome("Grupo B");
                    grupo3.setNome("Grupo C");
                    grupo4.setNome("Grupo D");

                    equipe1.setPontos(pEquipe1Class);
                    equipe1.setJogos(jEquipe1Class);
                    equipe1.setVitorias(vEquipe1Class);
                    equipe1.setEmpates(eEquipe1Class);
                    equipe1.setDerrotas(dEquipe1Class);
                    equipe1.setGolsPro(gpEquipe1Class);
                    equipe1.setGolsContra(gcEquipe1Class);
                    equipe1.setSaldoGols(sgEquipe1Class);

                    equipe2.setPontos(pEquipe2Class);
                    equipe2.setJogos(jEquipe2Class);
                    equipe2.setVitorias(vEquipe2Class);
                    equipe2.setEmpates(eEquipe2Class);
                    equipe2.setDerrotas(dEquipe2Class);
                    equipe2.setGolsPro(gpEquipe2Class);
                    equipe2.setGolsContra(gcEquipe2Class);
                    equipe2.setSaldoGols(sgEquipe2Class);

                    equipe3.setPontos(pEquipe3Class);
                    equipe3.setJogos(jEquipe3Class);
                    equipe3.setVitorias(vEquipe3Class);
                    equipe3.setEmpates(eEquipe3Class);
                    equipe3.setDerrotas(dEquipe3Class);
                    equipe3.setGolsPro(gpEquipe3Class);
                    equipe3.setGolsContra(gcEquipe3Class);
                    equipe3.setSaldoGols(sgEquipe3Class);

                    equipe4.setPontos(pEquipe4Class);
                    equipe4.setJogos(jEquipe4Class);
                    equipe4.setVitorias(vEquipe4Class);
                    equipe4.setEmpates(eEquipe4Class);
                    equipe4.setDerrotas(dEquipe4Class);
                    equipe4.setGolsPro(gpEquipe4Class);
                    equipe4.setGolsContra(gcEquipe4Class);
                    equipe4.setSaldoGols(sgEquipe4Class);

                    equipe5.setPontos(pEquipe5Class);
                    equipe5.setJogos(jEquipe5Class);
                    equipe5.setVitorias(vEquipe5Class);
                    equipe5.setEmpates(eEquipe5Class);
                    equipe5.setDerrotas(dEquipe5Class);
                    equipe5.setGolsPro(gpEquipe5Class);
                    equipe5.setGolsContra(gcEquipe5Class);
                    equipe5.setSaldoGols(sgEquipe5Class);

                    equipe5.setPontos(pEquipe5Class);
                    equipe5.setJogos(jEquipe5Class);
                    equipe5.setVitorias(vEquipe5Class);
                    equipe5.setEmpates(eEquipe5Class);
                    equipe5.setDerrotas(dEquipe5Class);
                    equipe5.setGolsPro(gpEquipe5Class);
                    equipe5.setGolsContra(gcEquipe5Class);
                    equipe5.setSaldoGols(sgEquipe5Class);

                    equipe6.setPontos(pEquipe6Class);
                    equipe6.setJogos(jEquipe6Class);
                    equipe6.setVitorias(vEquipe6Class);
                    equipe6.setEmpates(eEquipe6Class);
                    equipe6.setDerrotas(dEquipe6Class);
                    equipe6.setGolsPro(gpEquipe6Class);
                    equipe6.setGolsContra(gcEquipe6Class);
                    equipe6.setSaldoGols(sgEquipe6Class);

                    equipe7.setPontos(pEquipe7Class);
                    equipe7.setJogos(jEquipe7Class);
                    equipe7.setVitorias(vEquipe7Class);
                    equipe7.setEmpates(eEquipe7Class);
                    equipe7.setDerrotas(dEquipe7Class);
                    equipe7.setGolsPro(gpEquipe7Class);
                    equipe7.setGolsContra(gcEquipe7Class);
                    equipe7.setSaldoGols(sgEquipe7Class);

                    equipe8.setPontos(pEquipe8Class);
                    equipe8.setJogos(jEquipe8Class);
                    equipe8.setVitorias(vEquipe8Class);
                    equipe8.setEmpates(eEquipe8Class);
                    equipe8.setDerrotas(dEquipe8Class);
                    equipe8.setGolsPro(gpEquipe8Class);
                    equipe8.setGolsContra(gcEquipe8Class);
                    equipe8.setSaldoGols(sgEquipe8Class);

                    equipe9.setPontos(pEquipe9Class);
                    equipe9.setJogos(jEquipe9Class);
                    equipe9.setVitorias(vEquipe9Class);
                    equipe9.setEmpates(eEquipe9Class);
                    equipe9.setDerrotas(dEquipe9Class);
                    equipe9.setGolsPro(gpEquipe9Class);
                    equipe9.setGolsContra(gcEquipe9Class);
                    equipe9.setSaldoGols(sgEquipe9Class);

                    equipe10.setPontos(pEquipe10Class);
                    equipe10.setJogos(jEquipe10Class);
                    equipe10.setVitorias(vEquipe10Class);
                    equipe10.setEmpates(eEquipe10Class);
                    equipe10.setDerrotas(dEquipe10Class);
                    equipe10.setGolsPro(gpEquipe10Class);
                    equipe10.setGolsContra(gcEquipe10Class);
                    equipe10.setSaldoGols(sgEquipe10Class);

                    equipe11.setPontos(pEquipe11Class);
                    equipe11.setJogos(jEquipe11Class);
                    equipe11.setVitorias(vEquipe11Class);
                    equipe11.setEmpates(eEquipe11Class);
                    equipe11.setDerrotas(dEquipe11Class);
                    equipe11.setGolsPro(gpEquipe11Class);
                    equipe11.setGolsContra(gcEquipe11Class);
                    equipe11.setSaldoGols(sgEquipe11Class);

                    equipe12.setPontos(pEquipe12Class);
                    equipe12.setJogos(jEquipe12Class);
                    equipe12.setVitorias(vEquipe12Class);
                    equipe12.setEmpates(eEquipe12Class);
                    equipe12.setDerrotas(dEquipe12Class);
                    equipe12.setGolsPro(gpEquipe12Class);
                    equipe12.setGolsContra(gcEquipe12Class);
                    equipe12.setSaldoGols(sgEquipe12Class);

                    equipe13.setPontos(pEquipe13Class);
                    equipe13.setJogos(jEquipe13Class);
                    equipe13.setVitorias(vEquipe13Class);
                    equipe13.setEmpates(eEquipe13Class);
                    equipe13.setDerrotas(dEquipe13Class);
                    equipe13.setGolsPro(gpEquipe13Class);
                    equipe13.setGolsContra(gcEquipe13Class);
                    equipe13.setSaldoGols(sgEquipe13Class);

                    equipe14.setPontos(pEquipe14Class);
                    equipe14.setJogos(jEquipe14Class);
                    equipe14.setVitorias(vEquipe14Class);
                    equipe14.setEmpates(eEquipe14Class);
                    equipe14.setDerrotas(dEquipe14Class);
                    equipe14.setGolsPro(gpEquipe14Class);
                    equipe14.setGolsContra(gcEquipe14Class);
                    equipe14.setSaldoGols(sgEquipe14Class);

                    equipe15.setPontos(pEquipe15Class);
                    equipe15.setJogos(jEquipe15Class);
                    equipe15.setVitorias(vEquipe15Class);
                    equipe15.setEmpates(eEquipe15Class);
                    equipe15.setDerrotas(dEquipe15Class);
                    equipe15.setGolsPro(gpEquipe15Class);
                    equipe15.setGolsContra(gcEquipe15Class);
                    equipe15.setSaldoGols(sgEquipe15Class);

                    equipe16.setPontos(pEquipe16Class);
                    equipe16.setJogos(jEquipe16Class);
                    equipe16.setVitorias(vEquipe16Class);
                    equipe16.setEmpates(eEquipe16Class);
                    equipe16.setDerrotas(dEquipe16Class);
                    equipe16.setGolsPro(gpEquipe16Class);
                    equipe16.setGolsContra(gcEquipe16Class);
                    equipe16.setSaldoGols(sgEquipe16Class);

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

                    //Grupo 1
                    txtNomeGrupoA.setText(grupo1.getNome());
                    grupo1.setEquipe1(equipesA[0]);
                    txtEquipe1.setText(grupo1.getEquipe1().getNome());
                    pEquipe1.setText(String.valueOf(grupo1.getEquipe1().getPontos()));
                    jEquipe1.setText(String.valueOf(grupo1.getEquipe1().getJogos()));
                    vEquipe1.setText(String.valueOf(grupo1.getEquipe1().getVitorias()));
                    eEquipe1.setText(String.valueOf(grupo1.getEquipe1().getEmpates()));
                    dEquipe1.setText(String.valueOf(grupo1.getEquipe1().getDerrotas()));
                    gpEquipe1.setText(String.valueOf(grupo1.getEquipe1().getGolsPro()));
                    gcEquipe1.setText(String.valueOf(grupo1.getEquipe1().getGolsContra()));
                    sgEquipe1.setText(String.valueOf(grupo1.getEquipe1().getSaldoGols()));

                    grupo1.setEquipe2(equipesA[1]);
                    txtEquipe2.setText(grupo1.getEquipe2().getNome());
                    pEquipe2.setText(String.valueOf(grupo1.getEquipe2().getPontos()));
                    jEquipe2.setText(String.valueOf(grupo1.getEquipe2().getJogos()));
                    vEquipe2.setText(String.valueOf(grupo1.getEquipe2().getVitorias()));
                    eEquipe2.setText(String.valueOf(grupo1.getEquipe2().getEmpates()));
                    dEquipe2.setText(String.valueOf(grupo1.getEquipe2().getDerrotas()));
                    gpEquipe2.setText(String.valueOf(grupo1.getEquipe2().getGolsPro()));
                    gcEquipe2.setText(String.valueOf(grupo1.getEquipe2().getGolsContra()));
                    sgEquipe2.setText(String.valueOf(grupo1.getEquipe2().getSaldoGols()));

                    grupo1.setEquipe3(equipesA[2]);
                    txtEquipe3.setText(grupo1.getEquipe3().getNome());
                    pEquipe3.setText(String.valueOf(grupo1.getEquipe3().getPontos()));
                    jEquipe3.setText(String.valueOf(grupo1.getEquipe3().getJogos()));
                    vEquipe3.setText(String.valueOf(grupo1.getEquipe3().getVitorias()));
                    eEquipe3.setText(String.valueOf(grupo1.getEquipe3().getEmpates()));
                    dEquipe3.setText(String.valueOf(grupo1.getEquipe3().getDerrotas()));
                    gpEquipe3.setText(String.valueOf(grupo1.getEquipe3().getGolsPro()));
                    gcEquipe3.setText(String.valueOf(grupo1.getEquipe3().getGolsContra()));
                    sgEquipe3.setText(String.valueOf(grupo1.getEquipe3().getSaldoGols()));

                    grupo1.setEquipe4(equipesA[3]);
                    txtEquipe4.setText(grupo1.getEquipe4().getNome());
                    pEquipe4.setText(String.valueOf(grupo1.getEquipe4().getPontos()));
                    jEquipe4.setText(String.valueOf(grupo1.getEquipe4().getJogos()));
                    vEquipe4.setText(String.valueOf(grupo1.getEquipe4().getVitorias()));
                    eEquipe4.setText(String.valueOf(grupo1.getEquipe4().getEmpates()));
                    dEquipe4.setText(String.valueOf(grupo1.getEquipe4().getDerrotas()));
                    gpEquipe4.setText(String.valueOf(grupo1.getEquipe4().getGolsPro()));
                    gcEquipe4.setText(String.valueOf(grupo1.getEquipe4().getGolsContra()));
                    sgEquipe4.setText(String.valueOf(grupo1.getEquipe4().getSaldoGols()));


                    //Grupo 2
                    txtNomeGrupoB.setText(grupo2.getNome());
                    grupo2.setEquipe1(equipesB[0]);
                    txtEquipe5.setText(grupo2.getEquipe1().getNome());
                    pEquipe5.setText(String.valueOf(grupo2.getEquipe1().getPontos()));
                    jEquipe5.setText(String.valueOf(grupo2.getEquipe1().getJogos()));
                    vEquipe5.setText(String.valueOf(grupo2.getEquipe1().getVitorias()));
                    eEquipe5.setText(String.valueOf(grupo2.getEquipe1().getEmpates()));
                    dEquipe5.setText(String.valueOf(grupo2.getEquipe1().getDerrotas()));
                    gpEquipe5.setText(String.valueOf(grupo2.getEquipe1().getGolsPro()));
                    gcEquipe5.setText(String.valueOf(grupo2.getEquipe1().getGolsContra()));
                    sgEquipe5.setText(String.valueOf(grupo2.getEquipe1().getSaldoGols()));

                    grupo2.setEquipe2(equipesB[1]);
                    txtEquipe6.setText(grupo2.getEquipe2().getNome());
                    pEquipe6.setText(String.valueOf(grupo2.getEquipe2().getPontos()));
                    jEquipe6.setText(String.valueOf(grupo2.getEquipe2().getJogos()));
                    vEquipe6.setText(String.valueOf(grupo2.getEquipe2().getVitorias()));
                    eEquipe6.setText(String.valueOf(grupo2.getEquipe2().getEmpates()));
                    dEquipe6.setText(String.valueOf(grupo2.getEquipe2().getDerrotas()));
                    gpEquipe6.setText(String.valueOf(grupo2.getEquipe2().getGolsPro()));
                    gcEquipe6.setText(String.valueOf(grupo2.getEquipe2().getGolsContra()));
                    sgEquipe6.setText(String.valueOf(grupo2.getEquipe2().getSaldoGols()));

                    grupo2.setEquipe3(equipesB[2]);
                    txtEquipe7.setText(grupo2.getEquipe3().getNome());
                    pEquipe7.setText(String.valueOf(grupo2.getEquipe3().getPontos()));
                    jEquipe7.setText(String.valueOf(grupo2.getEquipe3().getJogos()));
                    vEquipe7.setText(String.valueOf(grupo2.getEquipe3().getVitorias()));
                    eEquipe7.setText(String.valueOf(grupo2.getEquipe3().getEmpates()));
                    dEquipe7.setText(String.valueOf(grupo2.getEquipe3().getDerrotas()));
                    gpEquipe7.setText(String.valueOf(grupo2.getEquipe3().getGolsPro()));
                    gcEquipe7.setText(String.valueOf(grupo2.getEquipe3().getGolsContra()));
                    sgEquipe7.setText(String.valueOf(grupo2.getEquipe3().getSaldoGols()));

                    grupo2.setEquipe4(equipesB[3]);
                    txtEquipe8.setText(grupo2.getEquipe4().getNome());
                    pEquipe8.setText(String.valueOf(grupo2.getEquipe4().getPontos()));
                    jEquipe8.setText(String.valueOf(grupo2.getEquipe4().getJogos()));
                    vEquipe8.setText(String.valueOf(grupo2.getEquipe4().getVitorias()));
                    eEquipe8.setText(String.valueOf(grupo2.getEquipe4().getEmpates()));
                    dEquipe8.setText(String.valueOf(grupo2.getEquipe4().getDerrotas()));
                    gpEquipe8.setText(String.valueOf(grupo2.getEquipe4().getGolsPro()));
                    gcEquipe8.setText(String.valueOf(grupo2.getEquipe4().getGolsContra()));
                    sgEquipe8.setText(String.valueOf(grupo2.getEquipe4().getSaldoGols()));


                    //Grupo 3
                    txtNomeGrupoC.setText(grupo3.getNome());
                    grupo3.setEquipe1(equipesC[0]);
                    txtEquipe9.setText(grupo3.getEquipe1().getNome());
                    pEquipe9.setText(String.valueOf(grupo3.getEquipe1().getPontos()));
                    jEquipe9.setText(String.valueOf(grupo3.getEquipe1().getJogos()));
                    vEquipe9.setText(String.valueOf(grupo3.getEquipe1().getVitorias()));
                    eEquipe9.setText(String.valueOf(grupo3.getEquipe1().getEmpates()));
                    dEquipe9.setText(String.valueOf(grupo3.getEquipe1().getDerrotas()));
                    gpEquipe9.setText(String.valueOf(grupo3.getEquipe1().getGolsPro()));
                    gcEquipe9.setText(String.valueOf(grupo3.getEquipe1().getGolsContra()));
                    sgEquipe9.setText(String.valueOf(grupo3.getEquipe1().getSaldoGols()));

                    grupo3.setEquipe2(equipesC[1]);
                    txtEquipe10.setText(grupo3.getEquipe2().getNome());
                    pEquipe10.setText(String.valueOf(grupo3.getEquipe2().getPontos()));
                    jEquipe10.setText(String.valueOf(grupo3.getEquipe2().getJogos()));
                    vEquipe10.setText(String.valueOf(grupo3.getEquipe2().getVitorias()));
                    eEquipe10.setText(String.valueOf(grupo3.getEquipe2().getEmpates()));
                    dEquipe10.setText(String.valueOf(grupo3.getEquipe2().getDerrotas()));
                    gpEquipe10.setText(String.valueOf(grupo3.getEquipe2().getGolsPro()));
                    gcEquipe10.setText(String.valueOf(grupo3.getEquipe2().getGolsContra()));
                    sgEquipe10.setText(String.valueOf(grupo3.getEquipe2().getSaldoGols()));

                    grupo3.setEquipe3(equipesC[2]);
                    txtEquipe11.setText(grupo3.getEquipe3().getNome());
                    pEquipe11.setText(String.valueOf(grupo3.getEquipe3().getPontos()));
                    jEquipe11.setText(String.valueOf(grupo3.getEquipe3().getJogos()));
                    vEquipe11.setText(String.valueOf(grupo3.getEquipe3().getVitorias()));
                    eEquipe11.setText(String.valueOf(grupo3.getEquipe3().getEmpates()));
                    dEquipe11.setText(String.valueOf(grupo3.getEquipe3().getDerrotas()));
                    gpEquipe11.setText(String.valueOf(grupo3.getEquipe3().getGolsPro()));
                    gcEquipe11.setText(String.valueOf(grupo3.getEquipe3().getGolsContra()));
                    sgEquipe11.setText(String.valueOf(grupo3.getEquipe3().getSaldoGols()));

                    grupo3.setEquipe4(equipesC[3]);
                    txtEquipe12.setText(grupo3.getEquipe4().getNome());
                    pEquipe12.setText(String.valueOf(grupo3.getEquipe4().getPontos()));
                    jEquipe12.setText(String.valueOf(grupo3.getEquipe4().getJogos()));
                    vEquipe12.setText(String.valueOf(grupo3.getEquipe4().getVitorias()));
                    eEquipe12.setText(String.valueOf(grupo3.getEquipe4().getEmpates()));
                    dEquipe12.setText(String.valueOf(grupo3.getEquipe4().getDerrotas()));
                    gpEquipe12.setText(String.valueOf(grupo3.getEquipe4().getGolsPro()));
                    gcEquipe12.setText(String.valueOf(grupo3.getEquipe4().getGolsContra()));
                    sgEquipe12.setText(String.valueOf(grupo3.getEquipe4().getSaldoGols()));


                    //Grupo 4
                    txtNomeGrupoD.setText(grupo4.getNome());
                    grupo4.setEquipe1(equipesD[0]);
                    txtEquipe13.setText(grupo4.getEquipe1().getNome());
                    pEquipe13.setText(String.valueOf(grupo4.getEquipe1().getPontos()));
                    jEquipe13.setText(String.valueOf(grupo4.getEquipe1().getJogos()));
                    vEquipe13.setText(String.valueOf(grupo4.getEquipe1().getVitorias()));
                    eEquipe13.setText(String.valueOf(grupo4.getEquipe1().getEmpates()));
                    dEquipe13.setText(String.valueOf(grupo4.getEquipe1().getDerrotas()));
                    gpEquipe13.setText(String.valueOf(grupo4.getEquipe1().getGolsPro()));
                    gcEquipe13.setText(String.valueOf(grupo4.getEquipe1().getGolsContra()));
                    sgEquipe13.setText(String.valueOf(grupo4.getEquipe1().getSaldoGols()));

                    grupo4.setEquipe2(equipesD[1]);
                    txtEquipe14.setText(grupo4.getEquipe2().getNome());
                    pEquipe14.setText(String.valueOf(grupo4.getEquipe2().getPontos()));
                    jEquipe14.setText(String.valueOf(grupo4.getEquipe2().getJogos()));
                    vEquipe14.setText(String.valueOf(grupo4.getEquipe2().getVitorias()));
                    eEquipe14.setText(String.valueOf(grupo4.getEquipe2().getEmpates()));
                    dEquipe14.setText(String.valueOf(grupo4.getEquipe2().getDerrotas()));
                    gpEquipe14.setText(String.valueOf(grupo4.getEquipe2().getGolsPro()));
                    gcEquipe14.setText(String.valueOf(grupo4.getEquipe2().getGolsContra()));
                    sgEquipe14.setText(String.valueOf(grupo4.getEquipe2().getSaldoGols()));

                    grupo4.setEquipe3(equipesD[2]);
                    txtEquipe15.setText(grupo4.getEquipe3().getNome());
                    pEquipe15.setText(String.valueOf(grupo4.getEquipe3().getPontos()));
                    jEquipe15.setText(String.valueOf(grupo4.getEquipe3().getJogos()));
                    vEquipe15.setText(String.valueOf(grupo4.getEquipe3().getVitorias()));
                    eEquipe15.setText(String.valueOf(grupo4.getEquipe3().getEmpates()));
                    dEquipe15.setText(String.valueOf(grupo4.getEquipe3().getDerrotas()));
                    gpEquipe15.setText(String.valueOf(grupo4.getEquipe3().getGolsPro()));
                    gcEquipe15.setText(String.valueOf(grupo4.getEquipe3().getGolsContra()));
                    sgEquipe15.setText(String.valueOf(grupo4.getEquipe3().getSaldoGols()));

                    grupo4.setEquipe4(equipesD[3]);
                    txtEquipe16.setText(grupo4.getEquipe4().getNome());
                    pEquipe16.setText(String.valueOf(grupo4.getEquipe4().getPontos()));
                    jEquipe16.setText(String.valueOf(grupo4.getEquipe4().getJogos()));
                    vEquipe16.setText(String.valueOf(grupo4.getEquipe4().getVitorias()));
                    eEquipe16.setText(String.valueOf(grupo4.getEquipe4().getEmpates()));
                    dEquipe16.setText(String.valueOf(grupo4.getEquipe4().getDerrotas()));
                    gpEquipe16.setText(String.valueOf(grupo4.getEquipe4().getGolsPro()));
                    gcEquipe16.setText(String.valueOf(grupo4.getEquipe4().getGolsContra()));
                    sgEquipe16.setText(String.valueOf(grupo4.getEquipe4().getSaldoGols()));

                } else {

                    new FancyAlertDialog.Builder(Classificacao.this)
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
                                    Intent intent = new Intent(Classificacao.this, Dashboard.class);
                                    startActivity(intent);
                                }
                            })
                            .build();
                }
            } else {

                if (grupo4ID >= 1) {

                    grupo1 = grupoController.getGrupoByID(grupo1);
                    equipe1 = equipeController.getEquipeByID(equipe1);
                    equipe2 = equipeController.getEquipeByID(equipe2);
                    equipe3 = equipeController.getEquipeByID(equipe3);
                    equipe4 = equipeController.getEquipeByID(equipe4);
                    grupo2 = grupoController.getGrupoByID(grupo2);
                    equipe5 = equipeController.getEquipeByID(equipe5);
                    equipe6 = equipeController.getEquipeByID(equipe6);
                    equipe7 = equipeController.getEquipeByID(equipe7);
                    equipe8 = equipeController.getEquipeByID(equipe8);
                    grupo3 = grupoController.getGrupoByID(grupo3);
                    equipe9 = equipeController.getEquipeByID(equipe9);
                    equipe10 = equipeController.getEquipeByID(equipe10);
                    equipe11 = equipeController.getEquipeByID(equipe11);
                    equipe12 = equipeController.getEquipeByID(equipe12);
                    grupo4 = grupoController.getGrupoByID(grupo4);
                    equipe13 = equipeController.getEquipeByID(equipe13);
                    equipe14 = equipeController.getEquipeByID(equipe14);
                    equipe15 = equipeController.getEquipeByID(equipe15);
                    equipe16 = equipeController.getEquipeByID(equipe16);

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

                    //Grupo 1
                    txtNomeGrupoA.setText(grupo1.getNome());
                    grupo1.setEquipe1(equipesA[0]);
                    txtEquipe1.setText(grupo1.getEquipe1().getNome());
                    pEquipe1.setText(String.valueOf(grupo1.getEquipe1().getPontos()));
                    jEquipe1.setText(String.valueOf(grupo1.getEquipe1().getJogos()));
                    vEquipe1.setText(String.valueOf(grupo1.getEquipe1().getVitorias()));
                    eEquipe1.setText(String.valueOf(grupo1.getEquipe1().getEmpates()));
                    dEquipe1.setText(String.valueOf(grupo1.getEquipe1().getDerrotas()));
                    gpEquipe1.setText(String.valueOf(grupo1.getEquipe1().getGolsPro()));
                    gcEquipe1.setText(String.valueOf(grupo1.getEquipe1().getGolsContra()));
                    sgEquipe1.setText(String.valueOf(grupo1.getEquipe1().getSaldoGols()));

                    grupo1.setEquipe2(equipesA[1]);
                    txtEquipe2.setText(grupo1.getEquipe2().getNome());
                    pEquipe2.setText(String.valueOf(grupo1.getEquipe2().getPontos()));
                    jEquipe2.setText(String.valueOf(grupo1.getEquipe2().getJogos()));
                    vEquipe2.setText(String.valueOf(grupo1.getEquipe2().getVitorias()));
                    eEquipe2.setText(String.valueOf(grupo1.getEquipe2().getEmpates()));
                    dEquipe2.setText(String.valueOf(grupo1.getEquipe2().getDerrotas()));
                    gpEquipe2.setText(String.valueOf(grupo1.getEquipe2().getGolsPro()));
                    gcEquipe2.setText(String.valueOf(grupo1.getEquipe2().getGolsContra()));
                    sgEquipe2.setText(String.valueOf(grupo1.getEquipe2().getSaldoGols()));

                    grupo1.setEquipe3(equipesA[2]);
                    txtEquipe3.setText(grupo1.getEquipe3().getNome());
                    pEquipe3.setText(String.valueOf(grupo1.getEquipe3().getPontos()));
                    jEquipe3.setText(String.valueOf(grupo1.getEquipe3().getJogos()));
                    vEquipe3.setText(String.valueOf(grupo1.getEquipe3().getVitorias()));
                    eEquipe3.setText(String.valueOf(grupo1.getEquipe3().getEmpates()));
                    dEquipe3.setText(String.valueOf(grupo1.getEquipe3().getDerrotas()));
                    gpEquipe3.setText(String.valueOf(grupo1.getEquipe3().getGolsPro()));
                    gcEquipe3.setText(String.valueOf(grupo1.getEquipe3().getGolsContra()));
                    sgEquipe3.setText(String.valueOf(grupo1.getEquipe3().getSaldoGols()));

                    grupo1.setEquipe4(equipesA[3]);
                    txtEquipe4.setText(grupo1.getEquipe4().getNome());
                    pEquipe4.setText(String.valueOf(grupo1.getEquipe4().getPontos()));
                    jEquipe4.setText(String.valueOf(grupo1.getEquipe4().getJogos()));
                    vEquipe4.setText(String.valueOf(grupo1.getEquipe4().getVitorias()));
                    eEquipe4.setText(String.valueOf(grupo1.getEquipe4().getEmpates()));
                    dEquipe4.setText(String.valueOf(grupo1.getEquipe4().getDerrotas()));
                    gpEquipe4.setText(String.valueOf(grupo1.getEquipe4().getGolsPro()));
                    gcEquipe4.setText(String.valueOf(grupo1.getEquipe4().getGolsContra()));
                    sgEquipe4.setText(String.valueOf(grupo1.getEquipe4().getSaldoGols()));


                    //Grupo 2
                    txtNomeGrupoB.setText(grupo2.getNome());
                    grupo2.setEquipe1(equipesB[0]);
                    txtEquipe5.setText(grupo2.getEquipe1().getNome());
                    pEquipe5.setText(String.valueOf(grupo2.getEquipe1().getPontos()));
                    jEquipe5.setText(String.valueOf(grupo2.getEquipe1().getJogos()));
                    vEquipe5.setText(String.valueOf(grupo2.getEquipe1().getVitorias()));
                    eEquipe5.setText(String.valueOf(grupo2.getEquipe1().getEmpates()));
                    dEquipe5.setText(String.valueOf(grupo2.getEquipe1().getDerrotas()));
                    gpEquipe5.setText(String.valueOf(grupo2.getEquipe1().getGolsPro()));
                    gcEquipe5.setText(String.valueOf(grupo2.getEquipe1().getGolsContra()));
                    sgEquipe5.setText(String.valueOf(grupo2.getEquipe1().getSaldoGols()));

                    grupo2.setEquipe2(equipesB[1]);
                    txtEquipe6.setText(grupo2.getEquipe2().getNome());
                    pEquipe6.setText(String.valueOf(grupo2.getEquipe2().getPontos()));
                    jEquipe6.setText(String.valueOf(grupo2.getEquipe2().getJogos()));
                    vEquipe6.setText(String.valueOf(grupo2.getEquipe2().getVitorias()));
                    eEquipe6.setText(String.valueOf(grupo2.getEquipe2().getEmpates()));
                    dEquipe6.setText(String.valueOf(grupo2.getEquipe2().getDerrotas()));
                    gpEquipe6.setText(String.valueOf(grupo2.getEquipe2().getGolsPro()));
                    gcEquipe6.setText(String.valueOf(grupo2.getEquipe2().getGolsContra()));
                    sgEquipe6.setText(String.valueOf(grupo2.getEquipe2().getSaldoGols()));

                    grupo2.setEquipe3(equipesB[2]);
                    txtEquipe7.setText(grupo2.getEquipe3().getNome());
                    pEquipe7.setText(String.valueOf(grupo2.getEquipe3().getPontos()));
                    jEquipe7.setText(String.valueOf(grupo2.getEquipe3().getJogos()));
                    vEquipe7.setText(String.valueOf(grupo2.getEquipe3().getVitorias()));
                    eEquipe7.setText(String.valueOf(grupo2.getEquipe3().getEmpates()));
                    dEquipe7.setText(String.valueOf(grupo2.getEquipe3().getDerrotas()));
                    gpEquipe7.setText(String.valueOf(grupo2.getEquipe3().getGolsPro()));
                    gcEquipe7.setText(String.valueOf(grupo2.getEquipe3().getGolsContra()));
                    sgEquipe7.setText(String.valueOf(grupo2.getEquipe3().getSaldoGols()));

                    grupo2.setEquipe4(equipesB[3]);
                    txtEquipe8.setText(grupo2.getEquipe4().getNome());
                    pEquipe8.setText(String.valueOf(grupo2.getEquipe4().getPontos()));
                    jEquipe8.setText(String.valueOf(grupo2.getEquipe4().getJogos()));
                    vEquipe8.setText(String.valueOf(grupo2.getEquipe4().getVitorias()));
                    eEquipe8.setText(String.valueOf(grupo2.getEquipe4().getEmpates()));
                    dEquipe8.setText(String.valueOf(grupo2.getEquipe4().getDerrotas()));
                    gpEquipe8.setText(String.valueOf(grupo2.getEquipe4().getGolsPro()));
                    gcEquipe8.setText(String.valueOf(grupo2.getEquipe4().getGolsContra()));
                    sgEquipe8.setText(String.valueOf(grupo2.getEquipe4().getSaldoGols()));


                    //Grupo 3
                    txtNomeGrupoC.setText(grupo3.getNome());
                    grupo3.setEquipe1(equipesC[0]);
                    txtEquipe9.setText(grupo3.getEquipe1().getNome());
                    pEquipe9.setText(String.valueOf(grupo3.getEquipe1().getPontos()));
                    jEquipe9.setText(String.valueOf(grupo3.getEquipe1().getJogos()));
                    vEquipe9.setText(String.valueOf(grupo3.getEquipe1().getVitorias()));
                    eEquipe9.setText(String.valueOf(grupo3.getEquipe1().getEmpates()));
                    dEquipe9.setText(String.valueOf(grupo3.getEquipe1().getDerrotas()));
                    gpEquipe9.setText(String.valueOf(grupo3.getEquipe1().getGolsPro()));
                    gcEquipe9.setText(String.valueOf(grupo3.getEquipe1().getGolsContra()));
                    sgEquipe9.setText(String.valueOf(grupo3.getEquipe1().getSaldoGols()));

                    grupo3.setEquipe2(equipesC[1]);
                    txtEquipe10.setText(grupo3.getEquipe2().getNome());
                    pEquipe10.setText(String.valueOf(grupo3.getEquipe2().getPontos()));
                    jEquipe10.setText(String.valueOf(grupo3.getEquipe2().getJogos()));
                    vEquipe10.setText(String.valueOf(grupo3.getEquipe2().getVitorias()));
                    eEquipe10.setText(String.valueOf(grupo3.getEquipe2().getEmpates()));
                    dEquipe10.setText(String.valueOf(grupo3.getEquipe2().getDerrotas()));
                    gpEquipe10.setText(String.valueOf(grupo3.getEquipe2().getGolsPro()));
                    gcEquipe10.setText(String.valueOf(grupo3.getEquipe2().getGolsContra()));
                    sgEquipe10.setText(String.valueOf(grupo3.getEquipe2().getSaldoGols()));

                    grupo3.setEquipe3(equipesC[2]);
                    txtEquipe11.setText(grupo3.getEquipe3().getNome());
                    pEquipe11.setText(String.valueOf(grupo3.getEquipe3().getPontos()));
                    jEquipe11.setText(String.valueOf(grupo3.getEquipe3().getJogos()));
                    vEquipe11.setText(String.valueOf(grupo3.getEquipe3().getVitorias()));
                    eEquipe11.setText(String.valueOf(grupo3.getEquipe3().getEmpates()));
                    dEquipe11.setText(String.valueOf(grupo3.getEquipe3().getDerrotas()));
                    gpEquipe11.setText(String.valueOf(grupo3.getEquipe3().getGolsPro()));
                    gcEquipe11.setText(String.valueOf(grupo3.getEquipe3().getGolsContra()));
                    sgEquipe11.setText(String.valueOf(grupo3.getEquipe3().getSaldoGols()));

                    grupo3.setEquipe4(equipesC[3]);
                    txtEquipe12.setText(grupo3.getEquipe4().getNome());
                    pEquipe12.setText(String.valueOf(grupo3.getEquipe4().getPontos()));
                    jEquipe12.setText(String.valueOf(grupo3.getEquipe4().getJogos()));
                    vEquipe12.setText(String.valueOf(grupo3.getEquipe4().getVitorias()));
                    eEquipe12.setText(String.valueOf(grupo3.getEquipe4().getEmpates()));
                    dEquipe12.setText(String.valueOf(grupo3.getEquipe4().getDerrotas()));
                    gpEquipe12.setText(String.valueOf(grupo3.getEquipe4().getGolsPro()));
                    gcEquipe12.setText(String.valueOf(grupo3.getEquipe4().getGolsContra()));
                    sgEquipe12.setText(String.valueOf(grupo3.getEquipe4().getSaldoGols()));


                    //Grupo 4
                    txtNomeGrupoD.setText(grupo4.getNome());
                    grupo4.setEquipe1(equipesD[0]);
                    txtEquipe13.setText(grupo4.getEquipe1().getNome());
                    pEquipe13.setText(String.valueOf(grupo4.getEquipe1().getPontos()));
                    jEquipe13.setText(String.valueOf(grupo4.getEquipe1().getJogos()));
                    vEquipe13.setText(String.valueOf(grupo4.getEquipe1().getVitorias()));
                    eEquipe13.setText(String.valueOf(grupo4.getEquipe1().getEmpates()));
                    dEquipe13.setText(String.valueOf(grupo4.getEquipe1().getDerrotas()));
                    gpEquipe13.setText(String.valueOf(grupo4.getEquipe1().getGolsPro()));
                    gcEquipe13.setText(String.valueOf(grupo4.getEquipe1().getGolsContra()));
                    sgEquipe13.setText(String.valueOf(grupo4.getEquipe1().getSaldoGols()));

                    grupo4.setEquipe2(equipesD[1]);
                    txtEquipe14.setText(grupo4.getEquipe2().getNome());
                    pEquipe14.setText(String.valueOf(grupo4.getEquipe2().getPontos()));
                    jEquipe14.setText(String.valueOf(grupo4.getEquipe2().getJogos()));
                    vEquipe14.setText(String.valueOf(grupo4.getEquipe2().getVitorias()));
                    eEquipe14.setText(String.valueOf(grupo4.getEquipe2().getEmpates()));
                    dEquipe14.setText(String.valueOf(grupo4.getEquipe2().getDerrotas()));
                    gpEquipe14.setText(String.valueOf(grupo4.getEquipe2().getGolsPro()));
                    gcEquipe14.setText(String.valueOf(grupo4.getEquipe2().getGolsContra()));
                    sgEquipe14.setText(String.valueOf(grupo4.getEquipe2().getSaldoGols()));

                    grupo4.setEquipe3(equipesD[2]);
                    txtEquipe15.setText(grupo4.getEquipe3().getNome());
                    pEquipe15.setText(String.valueOf(grupo4.getEquipe3().getPontos()));
                    jEquipe15.setText(String.valueOf(grupo4.getEquipe3().getJogos()));
                    vEquipe15.setText(String.valueOf(grupo4.getEquipe3().getVitorias()));
                    eEquipe15.setText(String.valueOf(grupo4.getEquipe3().getEmpates()));
                    dEquipe15.setText(String.valueOf(grupo4.getEquipe3().getDerrotas()));
                    gpEquipe15.setText(String.valueOf(grupo4.getEquipe3().getGolsPro()));
                    gcEquipe15.setText(String.valueOf(grupo4.getEquipe3().getGolsContra()));
                    sgEquipe15.setText(String.valueOf(grupo4.getEquipe3().getSaldoGols()));

                    grupo4.setEquipe4(equipesD[3]);
                    txtEquipe16.setText(grupo4.getEquipe4().getNome());
                    pEquipe16.setText(String.valueOf(grupo4.getEquipe4().getPontos()));
                    jEquipe16.setText(String.valueOf(grupo4.getEquipe4().getJogos()));
                    vEquipe16.setText(String.valueOf(grupo4.getEquipe4().getVitorias()));
                    eEquipe16.setText(String.valueOf(grupo4.getEquipe4().getEmpates()));
                    dEquipe16.setText(String.valueOf(grupo4.getEquipe4().getDerrotas()));
                    gpEquipe16.setText(String.valueOf(grupo4.getEquipe4().getGolsPro()));
                    gcEquipe16.setText(String.valueOf(grupo4.getEquipe4().getGolsContra()));
                    sgEquipe16.setText(String.valueOf(grupo4.getEquipe4().getSaldoGols()));

                } else {

                    new FancyAlertDialog.Builder(Classificacao.this)
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
                                    Intent intent = new Intent(Classificacao.this, Dashboard.class);
                                    startActivity(intent);
                                }
                            })
                            .build();
                }
            }
        }

    }

    public static void ordenaGrupo(Equipe equipes[]) {

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

    public void voltar(View view) {

        Intent intent = new Intent(Classificacao.this, Dashboard.class);
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

    private void restaurarSharedPreferencesQtdEquipes() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        qtdEquipes = preferences.getInt("qtdEquipes", -1);
        finalizouPrimeiraFase = preferences.getBoolean("finalizouPrimeiraFase", false);
        pEquipe1Class = preferences.getInt("pEquipe1Class", -1);
        jEquipe1Class = preferences.getInt("jEquipe1Class", -1);
        vEquipe1Class = preferences.getInt("vEquipe1Class", -1);
        eEquipe1Class = preferences.getInt("eEquipe1Class", -1);
        dEquipe1Class = preferences.getInt("dEquipe1Class", -1);
        gpEquipe1Class = preferences.getInt("gpEquipe1Class", -1);
        gcEquipe1Class = preferences.getInt("gcEquipe1Class", -1);
        sgEquipe1Class = preferences.getInt("sgEquipe1Class", -1);
        pEquipe2Class = preferences.getInt("pEquipe2Class", -1);
        jEquipe2Class = preferences.getInt("jEquipe2Class", -1);
        vEquipe2Class = preferences.getInt("vEquipe2Class", -1);
        eEquipe2Class = preferences.getInt("eEquipe2Class", -1);
        dEquipe2Class = preferences.getInt("dEquipe2Class", -1);
        gpEquipe2Class = preferences.getInt("gpEquipe2Class", -1);
        gcEquipe2Class = preferences.getInt("gcEquipe2Class", -1);
        sgEquipe2Class = preferences.getInt("sgEquipe2Class", -1);
        pEquipe3Class = preferences.getInt("pEquipe3Class", -1);
        jEquipe3Class = preferences.getInt("jEquipe3Class", -1);
        vEquipe3Class = preferences.getInt("vEquipe3Class", -1);
        eEquipe3Class = preferences.getInt("eEquipe3Class", -1);
        dEquipe3Class = preferences.getInt("dEquipe3Class", -1);
        gpEquipe3Class = preferences.getInt("gpEquipe3Class", -1);
        gcEquipe3Class = preferences.getInt("gcEquipe3Class", -1);
        sgEquipe3Class = preferences.getInt("sgEquipe3Class", -1);
        pEquipe4Class = preferences.getInt("pEquipe4Class", -1);
        jEquipe4Class = preferences.getInt("jEquipe4Class", -1);
        vEquipe4Class = preferences.getInt("vEquipe4Class", -1);
        eEquipe4Class = preferences.getInt("eEquipe4Class", -1);
        dEquipe4Class = preferences.getInt("dEquipe4Class", -1);
        gpEquipe4Class = preferences.getInt("gpEquipe4Class", -1);
        gcEquipe4Class = preferences.getInt("gcEquipe4Class", -1);
        sgEquipe4Class = preferences.getInt("sgEquipe4Class", -1);
        pEquipe5Class = preferences.getInt("pEquipe5Class", -1);
        jEquipe5Class = preferences.getInt("jEquipe5Class", -1);
        vEquipe5Class = preferences.getInt("vEquipe5Class", -1);
        eEquipe5Class = preferences.getInt("eEquipe5Class", -1);
        dEquipe5Class = preferences.getInt("dEquipe5Class", -1);
        gpEquipe5Class = preferences.getInt("gpEquipe5Class", -1);
        gcEquipe5Class = preferences.getInt("gcEquipe5Class", -1);
        sgEquipe5Class = preferences.getInt("sgEquipe5Class", -1);
        pEquipe6Class = preferences.getInt("pEquipe6Class", -1);
        jEquipe6Class = preferences.getInt("jEquipe6Class", -1);
        vEquipe6Class = preferences.getInt("vEquipe6Class", -1);
        eEquipe6Class = preferences.getInt("eEquipe6Class", -1);
        dEquipe6Class = preferences.getInt("dEquipe6Class", -1);
        gpEquipe6Class = preferences.getInt("gpEquipe6Class", -1);
        gcEquipe6Class = preferences.getInt("gcEquipe6Class", -1);
        sgEquipe6Class = preferences.getInt("sgEquipe6Class", -1);
        pEquipe7Class = preferences.getInt("pEquipe7Class", -1);
        jEquipe7Class = preferences.getInt("jEquipe7Class", -1);
        vEquipe7Class = preferences.getInt("vEquipe7Class", -1);
        eEquipe7Class = preferences.getInt("eEquipe7Class", -1);
        dEquipe7Class = preferences.getInt("dEquipe7Class", -1);
        gpEquipe7Class = preferences.getInt("gpEquipe7Class", -1);
        gcEquipe7Class = preferences.getInt("gcEquipe7Class", -1);
        sgEquipe7Class = preferences.getInt("sgEquipe7Class", -1);
        pEquipe8Class = preferences.getInt("pEquipe8Class", -1);
        jEquipe8Class = preferences.getInt("jEquipe8Class", -1);
        vEquipe8Class = preferences.getInt("vEquipe8Class", -1);
        eEquipe8Class = preferences.getInt("eEquipe8Class", -1);
        dEquipe8Class = preferences.getInt("dEquipe8Class", -1);
        gpEquipe8Class = preferences.getInt("gpEquipe8Class", -1);
        gcEquipe8Class = preferences.getInt("gcEquipe8Class", -1);
        sgEquipe8Class = preferences.getInt("sgEquipe8Class", -1);
        pEquipe9Class = preferences.getInt("pEquipe9Class", -1);
        jEquipe9Class = preferences.getInt("jEquipe9Class", -1);
        vEquipe9Class = preferences.getInt("vEquipe9Class", -1);
        eEquipe9Class = preferences.getInt("eEquipe9Class", -1);
        dEquipe9Class = preferences.getInt("dEquipe9Class", -1);
        gpEquipe9Class = preferences.getInt("gpEquipe9Class", -1);
        gcEquipe9Class = preferences.getInt("gcEquipe9Class", -1);
        sgEquipe9Class = preferences.getInt("sgEquipe9Class", -1);
        pEquipe10Class = preferences.getInt("pEquipe10Class", -1);
        jEquipe10Class = preferences.getInt("jEquipe10Class", -1);
        vEquipe10Class = preferences.getInt("vEquipe10Class", -1);
        eEquipe10Class = preferences.getInt("eEquipe10Class", -1);
        dEquipe10Class = preferences.getInt("dEquipe10Class", -1);
        gpEquipe10Class = preferences.getInt("gpEquipe10Class", -1);
        gcEquipe10Class = preferences.getInt("gcEquipe10Class", -1);
        sgEquipe10Class = preferences.getInt("sgEquipe10Class", -1);
        pEquipe11Class = preferences.getInt("pEquipe11Class", -1);
        jEquipe11Class = preferences.getInt("jEquipe11Class", -1);
        vEquipe11Class = preferences.getInt("vEquipe11Class", -1);
        eEquipe11Class = preferences.getInt("eEquipe11Class", -1);
        dEquipe11Class = preferences.getInt("dEquipe11Class", -1);
        gpEquipe11Class = preferences.getInt("gpEquipe11Class", -1);
        gcEquipe11Class = preferences.getInt("gcEquipe11Class", -1);
        sgEquipe11Class = preferences.getInt("sgEquipe11Class", -1);
        pEquipe12Class = preferences.getInt("pEquipe12Class", -1);
        jEquipe12Class = preferences.getInt("jEquipe12Class", -1);
        vEquipe12Class = preferences.getInt("vEquipe12Class", -1);
        eEquipe12Class = preferences.getInt("eEquipe12Class", -1);
        dEquipe12Class = preferences.getInt("dEquipe12Class", -1);
        gpEquipe12Class = preferences.getInt("gpEquipe12Class", -1);
        gcEquipe12Class = preferences.getInt("gcEquipe12Class", -1);
        sgEquipe12Class = preferences.getInt("sgEquipe12Class", -1);
        pEquipe13Class = preferences.getInt("pEquipe13Class", -1);
        jEquipe13Class = preferences.getInt("jEquipe13Class", -1);
        vEquipe13Class = preferences.getInt("vEquipe13Class", -1);
        eEquipe13Class = preferences.getInt("eEquipe13Class", -1);
        dEquipe13Class = preferences.getInt("dEquipe13Class", -1);
        gpEquipe13Class = preferences.getInt("gpEquipe13Class", -1);
        gcEquipe13Class = preferences.getInt("gcEquipe13Class", -1);
        sgEquipe13Class = preferences.getInt("sgEquipe13Class", -1);
        pEquipe14Class = preferences.getInt("pEquipe14Class", -1);
        jEquipe14Class = preferences.getInt("jEquipe14Class", -1);
        vEquipe14Class = preferences.getInt("vEquipe14Class", -1);
        eEquipe14Class = preferences.getInt("eEquipe14Class", -1);
        dEquipe14Class = preferences.getInt("dEquipe14Class", -1);
        gpEquipe14Class = preferences.getInt("gpEquipe14Class", -1);
        gcEquipe14Class = preferences.getInt("gcEquipe14Class", -1);
        sgEquipe14Class = preferences.getInt("sgEquipe14Class", -1);
        pEquipe15Class = preferences.getInt("pEquipe15Class", -1);
        jEquipe15Class = preferences.getInt("jEquipe15Class", -1);
        vEquipe15Class = preferences.getInt("vEquipe15Class", -1);
        eEquipe15Class = preferences.getInt("eEquipe15Class", -1);
        dEquipe15Class = preferences.getInt("dEquipe15Class", -1);
        gpEquipe15Class = preferences.getInt("gpEquipe15Class", -1);
        gcEquipe15Class = preferences.getInt("gcEquipe15Class", -1);
        sgEquipe15Class = preferences.getInt("sgEquipe15Class", -1);
        pEquipe16Class = preferences.getInt("pEquipe16Class", -1);
        jEquipe16Class = preferences.getInt("jEquipe16Class", -1);
        vEquipe16Class = preferences.getInt("vEquipe16Class", -1);
        eEquipe16Class = preferences.getInt("eEquipe16Class", -1);
        dEquipe16Class = preferences.getInt("dEquipe16Class", -1);
        gpEquipe16Class = preferences.getInt("gpEquipe16Class", -1);
        gcEquipe16Class = preferences.getInt("gcEquipe16Class", -1);
        sgEquipe16Class = preferences.getInt("sgEquipe16Class", -1);

    }

    private void restaurarSharedPreferences() {

        if (qtdEquipes == 4) {

            preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
            grupo1ID = preferences.getInt("grupo1ID", -1);
            nomeGrupo1 = preferences.getString("nomeGrupo1", "");
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
            grupo1ID = preferences.getInt("grupo1ID", -1);
            nomeGrupo1 = preferences.getString("nomeGrupo1", "");
            equipe1ID = preferences.getInt("equipe1ID", -1);
            nomeEquipe1 = preferences.getString("nomeEquipe1", "");
            equipe2ID = preferences.getInt("equipe2ID", -1);
            nomeEquipe2 = preferences.getString("nomeEquipe2", "");
            equipe3ID = preferences.getInt("equipe3ID", -1);
            nomeEquipe3 = preferences.getString("nomeEquipe3", "");

            grupo2ID = preferences.getInt("grupo2ID", -1);
            nomeGrupo2 = preferences.getString("nomeGrupo2", "");
            equipe4ID = preferences.getInt("equipe4ID", -1);
            nomeEquipe4 = preferences.getString("nomeEquipe4", "");
            equipe5ID = preferences.getInt("equipe5ID", -1);
            nomeEquipe5 = preferences.getString("nomeEquipe5", "");
            equipe6ID = preferences.getInt("equipe6ID", -1);
            nomeEquipe6 = preferences.getString("nomeEquipe6", "");

            grupo3ID = preferences.getInt("grupo3ID", -1);
            nomeGrupo3 = preferences.getString("nomeGrupo3", "");
            equipe7ID = preferences.getInt("equipe7ID", -1);
            nomeEquipe7 = preferences.getString("nomeEquipe7", "");
            equipe8ID = preferences.getInt("equipe8ID", -1);
            nomeEquipe8 = preferences.getString("nomeEquipe8", "");
            equipe9ID = preferences.getInt("equipe9ID", -1);
            nomeEquipe9 = preferences.getString("nomeEquipe9", "");

            grupo4ID = preferences.getInt("grupo4ID", -1);
            nomeGrupo4 = preferences.getString("nomeGrupo4", "");
            equipe10ID = preferences.getInt("equipe10ID", -1);
            nomeEquipe10 = preferences.getString("nomeEquipe10", "");
            equipe11ID = preferences.getInt("equipe11ID", -1);
            nomeEquipe11 = preferences.getString("nomeEquipe11", "");
            equipe12ID = preferences.getInt("equipe12ID", -1);
            nomeEquipe12 = preferences.getString("nomeEquipe12", "");

        } else if (qtdEquipes == 16) {

            preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
            grupo1ID = preferences.getInt("grupo1ID", -1);
            nomeGrupo1 = preferences.getString("nomeGrupo1", "");
            equipe1ID = preferences.getInt("equipe1ID", -1);
            nomeEquipe1 = preferences.getString("nomeEquipe1", "");
            equipe2ID = preferences.getInt("equipe2ID", -1);
            nomeEquipe2 = preferences.getString("nomeEquipe2", "");
            equipe3ID = preferences.getInt("equipe3ID", -1);
            nomeEquipe3 = preferences.getString("nomeEquipe3", "");
            equipe4ID = preferences.getInt("equipe4ID", -1);
            nomeEquipe4 = preferences.getString("nomeEquipe4", "");

            grupo2ID = preferences.getInt("grupo2ID", -1);
            nomeGrupo2 = preferences.getString("nomeGrupo2", "");
            equipe5ID = preferences.getInt("equipe5ID", -1);
            nomeEquipe5 = preferences.getString("nomeEquipe5", "");
            equipe6ID = preferences.getInt("equipe6ID", -1);
            nomeEquipe6 = preferences.getString("nomeEquipe6", "");
            equipe7ID = preferences.getInt("equipe7ID", -1);
            nomeEquipe7 = preferences.getString("nomeEquipe7", "");
            equipe8ID = preferences.getInt("equipe8ID", -1);
            nomeEquipe8 = preferences.getString("nomeEquipe8", "");

            grupo3ID = preferences.getInt("grupo3ID", -1);
            nomeGrupo3 = preferences.getString("nomeGrupo3", "");
            equipe9ID = preferences.getInt("equipe9ID", -1);
            nomeEquipe9 = preferences.getString("nomeEquipe9", "");
            equipe10ID = preferences.getInt("equipe10ID", -1);
            nomeEquipe10 = preferences.getString("nomeEquipe10", "");
            equipe11ID = preferences.getInt("equipe11ID", -1);
            nomeEquipe11 = preferences.getString("nomeEquipe11", "");
            equipe12ID = preferences.getInt("equipe12ID", -1);
            nomeEquipe12 = preferences.getString("nomeEquipe12", "");

            grupo4ID = preferences.getInt("grupo4ID", -1);
            nomeGrupo4 = preferences.getString("nomeGrupo4", "");
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