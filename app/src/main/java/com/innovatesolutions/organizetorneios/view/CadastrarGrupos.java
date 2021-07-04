package com.innovatesolutions.organizetorneios.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.api.AppUtil;
import com.innovatesolutions.organizetorneios.controller.EquipeController;
import com.innovatesolutions.organizetorneios.controller.GrupoController;
import com.innovatesolutions.organizetorneios.model.Equipe;
import com.innovatesolutions.organizetorneios.model.Grupo;
import com.innovatesolutions.organizetorneios.model.Torneio;

public class CadastrarGrupos extends AppCompatActivity {

    private SharedPreferences preferences;
    private Equipe equipe1, equipe2, equipe3, equipe4, equipe5, equipe6, equipe7, equipe8, equipe9, equipe10, equipe11, equipe12, equipe13, equipe14, equipe15, equipe16;
    private Grupo grupo1, grupo2, grupo3, grupo4;
    private int ultimoID, grupoID, qtdEquipes;

    EditText editEquipe1, editEquipe2, editEquipe3, editEquipe4, editEquipe5, editEquipe6, editEquipe7, editEquipe8, editEquipe9, editEquipe10, editEquipe11, editEquipe12, editEquipe13, editEquipe14, editEquipe15, editEquipe16;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_grupos_quatro);

        restaurarSharedPreferencesQtdEquipes();
        switch (qtdEquipes) {
            case Torneio.TORNEIO_QUATRO_EQUIPES:
                setContentView(R.layout.activity_cadastrar_grupos_quatro);
                break;
            case Torneio.TORNEIO_DOZE_EQUIPES:
                setContentView(R.layout.activity_cadastrar_grupos_doze);
                break;
            case Torneio.TORNEIO_DEZESSEIS_EQUIPES:
                setContentView(R.layout.activity_cadastrar_grupos_dezesseis);
                break;
        }
        initFormulario();

        btnSalvar.setOnClickListener(view ->
                salvarFormulario());
    }

    private void initFormulario() {
        editEquipe1 = findViewById(R.id.editEquipe1);
        editEquipe2 = findViewById(R.id.editEquipe2);
        editEquipe3 = findViewById(R.id.editEquipe3);
        editEquipe4 = findViewById(R.id.editEquipe4);
        if (qtdEquipes > Torneio.TORNEIO_QUATRO_EQUIPES) {
            editEquipe5 = findViewById(R.id.editEquipe5);
            editEquipe6 = findViewById(R.id.editEquipe6);
            editEquipe7 = findViewById(R.id.editEquipe7);
            editEquipe8 = findViewById(R.id.editEquipe8);
            editEquipe9 = findViewById(R.id.editEquipe9);
            editEquipe10 = findViewById(R.id.editEquipe10);
            editEquipe11 = findViewById(R.id.editEquipe11);
            editEquipe12 = findViewById(R.id.editEquipe12);
        }
        if (qtdEquipes > Torneio.TORNEIO_DOZE_EQUIPES) {
            editEquipe13 = findViewById(R.id.editEquipe13);
            editEquipe14 = findViewById(R.id.editEquipe14);
            editEquipe15 = findViewById(R.id.editEquipe15);
            editEquipe16 = findViewById(R.id.editEquipe16);
        }
        btnSalvar = findViewById(R.id.btnSalvar);
    }

    private void salvarFormulario() {
        if (validarFormulario()) {
            salvarSharedPreferencesPlacares();

            EquipeController equipeController = new EquipeController(getApplicationContext());
            GrupoController grupoController = new GrupoController(getApplicationContext());

            grupo1 = new Grupo();
            grupo1.setNome("Grupo A");
            /**
             * Grupo 1 e Equipes
             */
            grupoController.incluir(grupo1);
            grupoID = grupoController.getUltimoID();
            salvarSharedPreferencesG1();

            equipe1 = new Equipe();
            equipe1.setNome(editEquipe1.getText().toString());
            equipe1.setGrupoID(grupoID);
            equipeController.incluir(equipe1);
            ultimoID = equipeController.getUltimoID();
            grupo1.setEquipe1(equipe1);
            salvarSharedPreferencesE1();

            equipe2 = new Equipe();
            equipe2.setNome(editEquipe2.getText().toString());
            equipe2.setGrupoID(grupoID);
            equipeController.incluir(equipe2);
            ultimoID = equipeController.getUltimoID();
            grupo1.setEquipe2(equipe2);
            salvarSharedPreferencesE2();

            equipe3 = new Equipe();
            equipe3.setNome(editEquipe3.getText().toString());
            equipe3.setGrupoID(grupoID);
            equipeController.incluir(equipe3);
            ultimoID = equipeController.getUltimoID();
            grupo1.setEquipe3(equipe3);
            salvarSharedPreferencesE3();

            if (qtdEquipes == Torneio.TORNEIO_QUATRO_EQUIPES || qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
                equipe4 = new Equipe();
                equipe4.setNome(editEquipe4.getText().toString());
                equipe4.setGrupoID(grupoID);
                equipeController.incluir(equipe4);
                ultimoID = equipeController.getUltimoID();
                grupo1.setEquipe4(equipe4);
                salvarSharedPreferencesE4();
            }
            if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES || qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
                grupo2 = new Grupo();
                grupo2.setNome("Grupo B");

                grupo3 = new Grupo();
                grupo3.setNome("Grupo C");

                grupo4 = new Grupo();
                grupo4.setNome("Grupo D");

                if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
                    /**
                     * Grupo 2 e Equipes
                     */
                    grupoController.incluir(grupo2);
                    grupoID = grupoController.getUltimoID();
                    salvarSharedPreferencesG2();

                    equipe4 = new Equipe();
                    equipe4.setNome(editEquipe4.getText().toString());
                    equipe4.setGrupoID(grupoID);
                    equipeController.incluir(equipe4);
                    ultimoID = equipeController.getUltimoID();
                    grupo2.setEquipe1(equipe4);
                    salvarSharedPreferencesE4();

                    equipe5 = new Equipe();
                    equipe5.setNome(editEquipe5.getText().toString());
                    equipe5.setGrupoID(grupoID);
                    equipeController.incluir(equipe5);
                    ultimoID = equipeController.getUltimoID();
                    grupo2.setEquipe2(equipe5);
                    salvarSharedPreferencesE5();

                    equipe6 = new Equipe();
                    equipe6.setNome(editEquipe6.getText().toString());
                    equipe6.setGrupoID(grupoID);
                    equipeController.incluir(equipe6);
                    ultimoID = equipeController.getUltimoID();
                    grupo2.setEquipe3(equipe6);
                    salvarSharedPreferencesE6();

                    /**
                     * Grupo 3 e Equipes
                     */
                    grupoController.incluir(grupo3);
                    grupoID = grupoController.getUltimoID();
                    salvarSharedPreferencesG3();

                    equipe7 = new Equipe();
                    equipe7.setNome(editEquipe7.getText().toString());
                    equipe7.setGrupoID(grupoID);
                    equipeController.incluir(equipe7);
                    ultimoID = equipeController.getUltimoID();
                    grupo3.setEquipe1(equipe7);
                    salvarSharedPreferencesE7();

                    equipe8 = new Equipe();
                    equipe8.setNome(editEquipe8.getText().toString());
                    equipe8.setGrupoID(grupoID);
                    equipeController.incluir(equipe8);
                    ultimoID = equipeController.getUltimoID();
                    grupo3.setEquipe2(equipe8);
                    salvarSharedPreferencesE8();

                    equipe9 = new Equipe();
                    equipe9.setNome(editEquipe9.getText().toString());
                    equipe9.setGrupoID(grupoID);
                    equipeController.incluir(equipe9);
                    ultimoID = equipeController.getUltimoID();
                    grupo3.setEquipe3(equipe9);
                    salvarSharedPreferencesE9();

                    /**
                     * Grupo 4 e Equipes
                     */
                    grupoController.incluir(grupo4);
                    grupoID = grupoController.getUltimoID();
                    salvarSharedPreferencesG4();

                    equipe10 = new Equipe();
                    equipe10.setNome(editEquipe10.getText().toString());
                    equipe10.setGrupoID(grupoID);
                    equipeController.incluir(equipe10);
                    ultimoID = equipeController.getUltimoID();
                    grupo4.setEquipe1(equipe10);
                    salvarSharedPreferencesE10();

                    equipe11 = new Equipe();
                    equipe11.setNome(editEquipe11.getText().toString());
                    equipe11.setGrupoID(grupoID);
                    equipeController.incluir(equipe11);
                    ultimoID = equipeController.getUltimoID();
                    grupo4.setEquipe2(equipe11);
                    salvarSharedPreferencesE11();

                    equipe12 = new Equipe();
                    equipe12.setNome(editEquipe12.getText().toString());
                    equipe12.setGrupoID(grupoID);
                    equipeController.incluir(equipe12);
                    ultimoID = equipeController.getUltimoID();
                    grupo4.setEquipe3(equipe12);
                    salvarSharedPreferencesE12();
                } else if (qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
                    /**
                     * Grupo 2 e Equipes
                     */
                    grupoController.incluir(grupo2);
                    grupoID = grupoController.getUltimoID();
                    salvarSharedPreferencesG2();

                    equipe5 = new Equipe();
                    equipe5.setNome(editEquipe5.getText().toString());
                    equipe5.setGrupoID(grupoID);
                    equipeController.incluir(equipe5);
                    ultimoID = equipeController.getUltimoID();
                    grupo2.setEquipe1(equipe5);
                    salvarSharedPreferencesE5();

                    equipe6 = new Equipe();
                    equipe6.setNome(editEquipe6.getText().toString());
                    equipe6.setGrupoID(grupoID);
                    equipeController.incluir(equipe6);
                    ultimoID = equipeController.getUltimoID();
                    grupo2.setEquipe2(equipe6);
                    salvarSharedPreferencesE6();

                    equipe7 = new Equipe();
                    equipe7.setNome(editEquipe7.getText().toString());
                    equipe7.setGrupoID(grupoID);
                    equipeController.incluir(equipe7);
                    ultimoID = equipeController.getUltimoID();
                    grupo2.setEquipe3(equipe7);
                    salvarSharedPreferencesE7();

                    equipe8 = new Equipe();
                    equipe8.setNome(editEquipe8.getText().toString());
                    equipe8.setGrupoID(grupoID);
                    equipeController.incluir(equipe8);
                    ultimoID = equipeController.getUltimoID();
                    grupo2.setEquipe4(equipe8);
                    salvarSharedPreferencesE8();

                    /**
                     * Grupo 3 e Equipes
                     */
                    grupoController.incluir(grupo3);
                    grupoID = grupoController.getUltimoID();
                    salvarSharedPreferencesG3();

                    equipe9 = new Equipe();
                    equipe9.setNome(editEquipe9.getText().toString());
                    equipe9.setGrupoID(grupoID);
                    equipeController.incluir(equipe9);
                    ultimoID = equipeController.getUltimoID();
                    grupo3.setEquipe1(equipe9);
                    salvarSharedPreferencesE9();

                    equipe10 = new Equipe();
                    equipe10.setNome(editEquipe10.getText().toString());
                    equipe10.setGrupoID(grupoID);
                    equipeController.incluir(equipe10);
                    ultimoID = equipeController.getUltimoID();
                    grupo3.setEquipe2(equipe10);
                    salvarSharedPreferencesE10();

                    equipe11 = new Equipe();
                    equipe11.setNome(editEquipe11.getText().toString());
                    equipe11.setGrupoID(grupoID);
                    equipeController.incluir(equipe11);
                    ultimoID = equipeController.getUltimoID();
                    grupo3.setEquipe3(equipe11);
                    salvarSharedPreferencesE11();

                    equipe12 = new Equipe();
                    equipe12.setNome(editEquipe12.getText().toString());
                    equipe12.setGrupoID(grupoID);
                    equipeController.incluir(equipe12);
                    ultimoID = equipeController.getUltimoID();
                    grupo3.setEquipe4(equipe12);
                    salvarSharedPreferencesE12();

                    /**
                     * Grupo 4 e Equipes
                     */
                    grupoController.incluir(grupo4);
                    grupoID = grupoController.getUltimoID();
                    salvarSharedPreferencesG4();

                    equipe13 = new Equipe();
                    equipe13.setNome(editEquipe13.getText().toString());
                    equipe13.setGrupoID(grupoID);
                    equipeController.incluir(equipe13);
                    ultimoID = equipeController.getUltimoID();
                    grupo4.setEquipe1(equipe13);
                    salvarSharedPreferencesE13();

                    equipe14 = new Equipe();
                    equipe14.setNome(editEquipe14.getText().toString());
                    equipe14.setGrupoID(grupoID);
                    equipeController.incluir(equipe14);
                    ultimoID = equipeController.getUltimoID();
                    grupo4.setEquipe2(equipe14);
                    salvarSharedPreferencesE14();

                    equipe15 = new Equipe();
                    equipe15.setNome(editEquipe15.getText().toString());
                    equipe15.setGrupoID(grupoID);
                    equipeController.incluir(equipe15);
                    ultimoID = equipeController.getUltimoID();
                    grupo4.setEquipe3(equipe15);
                    salvarSharedPreferencesE15();

                    equipe16 = new Equipe();
                    equipe16.setNome(editEquipe16.getText().toString());
                    equipe16.setGrupoID(grupoID);
                    equipeController.incluir(equipe16);
                    ultimoID = equipeController.getUltimoID();
                    grupo4.setEquipe4(equipe16);
                    salvarSharedPreferencesE16();
                }
            }
            AppUtil.goNextScreen(CadastrarGrupos.this, Dashboard.class, true);
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Favor, preencher todos os campos!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validarFormulario() {
        if (TextUtils.isEmpty(editEquipe1.getText().toString())) {
            editEquipe1.setError("*");
            editEquipe1.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(editEquipe2.getText().toString())) {
            editEquipe2.setError("*");
            editEquipe2.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(editEquipe3.getText().toString())) {
            editEquipe3.setError("*");
            editEquipe3.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(editEquipe4.getText().toString())) {
            editEquipe4.setError("*");
            editEquipe4.requestFocus();
            return false;
        }
        if (qtdEquipes > Torneio.TORNEIO_QUATRO_EQUIPES) {
            if (TextUtils.isEmpty(editEquipe5.getText().toString())) {
                editEquipe5.setError("*");
                editEquipe5.requestFocus();
                return false;
            }
            if (TextUtils.isEmpty(editEquipe6.getText().toString())) {
                editEquipe6.setError("*");
                editEquipe6.requestFocus();
                return false;
            }
            if (TextUtils.isEmpty(editEquipe7.getText().toString())) {
                editEquipe7.setError("*");
                editEquipe7.requestFocus();
                return false;
            }
            if (TextUtils.isEmpty(editEquipe8.getText().toString())) {
                editEquipe8.setError("*");
                editEquipe8.requestFocus();
                return false;
            }
            if (TextUtils.isEmpty(editEquipe9.getText().toString())) {
                editEquipe9.setError("*");
                editEquipe9.requestFocus();
                return false;
            }
            if (TextUtils.isEmpty(editEquipe10.getText().toString())) {
                editEquipe10.setError("*");
                editEquipe10.requestFocus();
                return false;
            }
            if (TextUtils.isEmpty(editEquipe11.getText().toString())) {
                editEquipe11.setError("*");
                editEquipe11.requestFocus();
                return false;
            }
            if (TextUtils.isEmpty(editEquipe12.getText().toString())) {
                editEquipe12.setError("*");
                editEquipe12.requestFocus();
                return false;
            }
        }
        if (qtdEquipes > Torneio.TORNEIO_DOZE_EQUIPES) {
            if (TextUtils.isEmpty(editEquipe13.getText().toString())) {
                editEquipe13.setError("*");
                editEquipe13.requestFocus();
                return false;
            }
            if (TextUtils.isEmpty(editEquipe14.getText().toString())) {
                editEquipe14.setError("*");
                editEquipe14.requestFocus();
                return false;
            }
            if (TextUtils.isEmpty(editEquipe15.getText().toString())) {
                editEquipe15.setError("*");
                editEquipe15.requestFocus();
                return false;
            }
            if (TextUtils.isEmpty(editEquipe16.getText().toString())) {
                editEquipe16.setError("*");
                editEquipe16.requestFocus();
                return false;
            }
        }
        return true;
    }

    public void voltar(View view) {
        AppUtil.goNextScreen(CadastrarGrupos.this, EscolherTorneio.class, true);
        finish();
    }

    @Override
    public void onBackPressed() {
        AppUtil.goNextScreen(CadastrarGrupos.this, EscolherTorneio.class, true);
        finish();
    }

    private void restaurarSharedPreferencesQtdEquipes() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        qtdEquipes = preferences.getInt("qtdEquipes", -1);
    }

    private void salvarSharedPreferencesPlacares() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        if (qtdEquipes == Torneio.TORNEIO_QUATRO_EQUIPES) {
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
        } else if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
            dados.putString("placarEquipe1J1", "");
            dados.putString("placarEquipe1J2", "");
            dados.putString("placarEquipe2J1", "");
            dados.putString("placarEquipe2J2", "");
            dados.putString("placarEquipe3J1", "");
            dados.putString("placarEquipe3J2", "");
            dados.putString("placarEquipe4J1", "");
            dados.putString("placarEquipe4J2", "");
            dados.putString("placarEquipe5J1", "");
            dados.putString("placarEquipe5J2", "");
            dados.putString("placarEquipe6J1", "");
            dados.putString("placarEquipe6J2", "");
            dados.putString("placarEquipe7J1", "");
            dados.putString("placarEquipe7J2", "");
            dados.putString("placarEquipe8J1", "");
            dados.putString("placarEquipe8J2", "");
            dados.putString("placarEquipe9J1", "");
            dados.putString("placarEquipe9J2", "");
            dados.putString("placarEquipe10J1", "");
            dados.putString("placarEquipe10J2", "");
            dados.putString("placarEquipe11J1", "");
            dados.putString("placarEquipe11J2", "");
            dados.putString("placarEquipe12J1", "");
            dados.putString("placarEquipe12J2", "");
        } else if (qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
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
        }
        dados.apply();
    }

    private void salvarSharedPreferencesG1() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("grupo1ID", grupoID);
        dados.putString("nomeGrupo1", grupo1.getNome());
        dados.apply();
    }

    private void salvarSharedPreferencesG2() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("grupo2ID", grupoID);
        dados.putString("nomeGrupo2", grupo2.getNome());
        dados.apply();
    }

    private void salvarSharedPreferencesG3() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("grupo3ID", grupoID);
        dados.putString("nomeGrupo3", grupo3.getNome());
        dados.apply();
    }

    private void salvarSharedPreferencesG4() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("grupo4ID", grupoID);
        dados.putString("nomeGrupo4", grupo4.getNome());
        dados.apply();
    }

    private void salvarSharedPreferencesE1() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("equipe1ID", ultimoID);
        dados.putString("nomeEquipe1", equipe1.getNome());
        dados.apply();
    }

    private void salvarSharedPreferencesE2() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("equipe2ID", ultimoID);
        dados.putString("nomeEquipe2", equipe2.getNome());
        dados.apply();
    }

    private void salvarSharedPreferencesE3() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("equipe3ID", ultimoID);
        dados.putString("nomeEquipe3", equipe3.getNome());
        dados.apply();
    }

    private void salvarSharedPreferencesE4() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("equipe4ID", ultimoID);
        dados.putString("nomeEquipe4", equipe4.getNome());
        dados.apply();
    }

    private void salvarSharedPreferencesE5() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("equipe5ID", ultimoID);
        dados.putString("nomeEquipe5", equipe5.getNome());
        dados.apply();
    }

    private void salvarSharedPreferencesE6() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("equipe6ID", ultimoID);
        dados.putString("nomeEquipe6", equipe6.getNome());
        dados.apply();
    }

    private void salvarSharedPreferencesE7() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("equipe7ID", ultimoID);
        dados.putString("nomeEquipe7", equipe7.getNome());
        dados.apply();
    }

    private void salvarSharedPreferencesE8() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("equipe8ID", ultimoID);
        dados.putString("nomeEquipe8", equipe8.getNome());
        dados.apply();
    }

    private void salvarSharedPreferencesE9() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("equipe9ID", ultimoID);
        dados.putString("nomeEquipe9", equipe9.getNome());
        dados.apply();
    }

    private void salvarSharedPreferencesE10() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("equipe10ID", ultimoID);
        dados.putString("nomeEquipe10", equipe10.getNome());
        dados.apply();
    }

    private void salvarSharedPreferencesE11() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("equipe11ID", ultimoID);
        dados.putString("nomeEquipe11", equipe11.getNome());
        dados.apply();
    }

    private void salvarSharedPreferencesE12() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("equipe12ID", ultimoID);
        dados.putString("nomeEquipe12", equipe12.getNome());
        dados.apply();
    }

    private void salvarSharedPreferencesE13() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("equipe13ID", ultimoID);
        dados.putString("nomeEquipe13", equipe13.getNome());
        dados.apply();
    }

    private void salvarSharedPreferencesE14() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("equipe14ID", ultimoID);
        dados.putString("nomeEquipe14", equipe14.getNome());
        dados.apply();
    }

    private void salvarSharedPreferencesE15() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("equipe15ID", ultimoID);
        dados.putString("nomeEquipe15", equipe15.getNome());
        dados.apply();
    }

    private void salvarSharedPreferencesE16() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("equipe16ID", ultimoID);
        dados.putString("nomeEquipe16", equipe16.getNome());
        dados.apply();
    }
}
