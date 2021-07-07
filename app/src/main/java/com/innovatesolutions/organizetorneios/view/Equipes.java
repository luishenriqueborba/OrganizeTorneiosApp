package com.innovatesolutions.organizetorneios.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.api.AppUtil;
import com.innovatesolutions.organizetorneios.controller.EquipeController;
import com.innovatesolutions.organizetorneios.controller.GrupoController;
import com.innovatesolutions.organizetorneios.model.Equipe;
import com.innovatesolutions.organizetorneios.model.Grupo;
import com.innovatesolutions.organizetorneios.model.Torneio;
import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;
import com.shashank.sony.fancydialoglib.Icon;

public class Equipes extends AppCompatActivity {

    private SharedPreferences preferences;
    private Equipe equipe1, equipe2, equipe3, equipe4, equipe5, equipe6, equipe7, equipe8, equipe9, equipe10, equipe11, equipe12, equipe13, equipe14, equipe15, equipe16;
    private Grupo grupo1, grupo2, grupo3, grupo4;
    private int grupo1ID, grupo2ID, grupo3ID, grupo4ID, equipe1ID, equipe2ID, equipe3ID, equipe4ID, equipe5ID, equipe6ID, equipe7ID, equipe8ID, equipe9ID, equipe10ID, equipe11ID, equipe12ID, equipe13ID, equipe14ID, equipe15ID, equipe16ID, qtdEquipes;
    private String nomeGrupo1, nomeGrupo2, nomeGrupo3, nomeGrupo4, nomeEquipe1, nomeEquipe2, nomeEquipe3, nomeEquipe4, nomeEquipe5, nomeEquipe6, nomeEquipe7, nomeEquipe8, nomeEquipe9, nomeEquipe10, nomeEquipe11, nomeEquipe12, nomeEquipe13, nomeEquipe14, nomeEquipe15, nomeEquipe16;
    private EquipeController equipeController;
    private GrupoController grupoController;
    private boolean sucesso;

    TextView txtNomeGrupoA, txtNomeGrupoB, txtNomeGrupoC, txtNomeGrupoD;
    EditText editEquipe1, editEquipe2, editEquipe3, editEquipe4, editEquipe5, editEquipe6, editEquipe7, editEquipe8, editEquipe9, editEquipe10, editEquipe11, editEquipe12, editEquipe13, editEquipe14, editEquipe15, editEquipe16;
    Button btnSalvarGrupoA, btnSalvarGrupoB, btnSalvarGrupoC, btnSalvarGrupoD, btnEditarGrupoA, btnEditarGrupoB, btnEditarGrupoC, btnEditarGrupoD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipes_quatro);

        restaurarSharedPreferences();
        switch (qtdEquipes) {
            case Torneio.TORNEIO_QUATRO_EQUIPES:
                setContentView(R.layout.activity_equipes_quatro);
                break;
            case Torneio.TORNEIO_DOZE_EQUIPES:
                setContentView(R.layout.activity_equipes_doze);
                break;
            case Torneio.TORNEIO_DEZESSEIS_EQUIPES:
                setContentView(R.layout.activity_equipes_dezesseis);
                break;
        }
        initFormulario();
        popularFormulario();
    }

    private void initFormulario() {
        editEquipe1 = findViewById(R.id.editEquipe1);
        editEquipe2 = findViewById(R.id.editEquipe2);
        editEquipe3 = findViewById(R.id.editEquipe3);
        editEquipe4 = findViewById(R.id.editEquipe4);
        txtNomeGrupoA = findViewById(R.id.txtNomeGrupoA);
        btnSalvarGrupoA = findViewById(R.id.btnSalvarGrupoA);
        btnEditarGrupoA = findViewById(R.id.btnEditarGrupoA);

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
        equipeController = new EquipeController(this);
        grupoController = new GrupoController(this);

        if (qtdEquipes > Torneio.TORNEIO_QUATRO_EQUIPES) {
            txtNomeGrupoB = findViewById(R.id.txtNomeGrupoB);
            txtNomeGrupoC = findViewById(R.id.txtNomeGrupoC);
            txtNomeGrupoD = findViewById(R.id.txtNomeGrupoD);
            editEquipe5 = findViewById(R.id.editEquipe5);
            editEquipe6 = findViewById(R.id.editEquipe6);
            editEquipe7 = findViewById(R.id.editEquipe7);
            editEquipe8 = findViewById(R.id.editEquipe8);
            editEquipe9 = findViewById(R.id.editEquipe9);
            editEquipe10 = findViewById(R.id.editEquipe10);
            editEquipe11 = findViewById(R.id.editEquipe11);
            editEquipe12 = findViewById(R.id.editEquipe12);
            btnSalvarGrupoB = findViewById(R.id.btnSalvarGrupoB);
            btnSalvarGrupoC = findViewById(R.id.btnSalvarGrupoC);
            btnSalvarGrupoD = findViewById(R.id.btnSalvarGrupoD);
            btnEditarGrupoB = findViewById(R.id.btnEditarGrupoB);
            btnEditarGrupoC = findViewById(R.id.btnEditarGrupoC);
            btnEditarGrupoD = findViewById(R.id.btnEditarGrupoD);

            grupo2 = new Grupo();
            grupo2.setId(grupo2ID);
            grupo3 = new Grupo();
            grupo3.setId(grupo3ID);
            grupo4 = new Grupo();
            grupo4.setId(grupo4ID);
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
        }
        if (qtdEquipes > Torneio.TORNEIO_DOZE_EQUIPES) {
            editEquipe13 = findViewById(R.id.editEquipe13);
            editEquipe14 = findViewById(R.id.editEquipe14);
            editEquipe15 = findViewById(R.id.editEquipe15);
            editEquipe16 = findViewById(R.id.editEquipe16);

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
        if (grupo1ID >= 1) { //if (grupo4ID >= 1) {
            grupo1 = grupoController.getGrupoByID(grupo1);
            equipe1 = equipeController.getEquipeByID(equipe1);
            equipe2 = equipeController.getEquipeByID(equipe2);
            equipe3 = equipeController.getEquipeByID(equipe3);
            equipe4 = equipeController.getEquipeByID(equipe4);

            txtNomeGrupoA.setText(grupo1.getNome());

            grupo1.setEquipe1(equipe1);
            editEquipe1.setText(grupo1.getEquipe1().getNome());
            grupo1.setEquipe2(equipe2);
            editEquipe2.setText(grupo1.getEquipe2().getNome());
            grupo1.setEquipe3(equipe3);
            editEquipe3.setText(grupo1.getEquipe3().getNome());

            if (qtdEquipes == Torneio.TORNEIO_QUATRO_EQUIPES || qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES)
            grupo1.setEquipe4(equipe4);
            editEquipe4.setText(grupo1.getEquipe4().getNome());

            if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES || qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
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
                txtNomeGrupoB.setText(grupo2.getNome());
                txtNomeGrupoC.setText(grupo3.getNome());
                txtNomeGrupoD.setText(grupo4.getNome());

                if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
                    grupo2.setEquipe1(equipe4);
                    editEquipe4.setText(grupo2.getEquipe1().getNome());
                    grupo2.setEquipe2(equipe5);
                    editEquipe5.setText(grupo2.getEquipe2().getNome());
                    grupo2.setEquipe3(equipe6);
                    editEquipe6.setText(grupo2.getEquipe3().getNome());

                    grupo3.setEquipe1(equipe7);
                    editEquipe7.setText(grupo3.getEquipe1().getNome());
                    grupo3.setEquipe2(equipe8);
                    editEquipe8.setText(grupo3.getEquipe2().getNome());
                    grupo3.setEquipe3(equipe9);
                    editEquipe9.setText(grupo3.getEquipe3().getNome());

                    grupo4.setEquipe1(equipe10);
                    editEquipe10.setText(grupo4.getEquipe1().getNome());
                    grupo4.setEquipe2(equipe11);
                    editEquipe11.setText(grupo4.getEquipe2().getNome());
                    grupo4.setEquipe3(equipe12);
                    editEquipe12.setText(grupo4.getEquipe3().getNome());
                }
                else if (qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
                    equipe13 = equipeController.getEquipeByID(equipe13);
                    equipe14 = equipeController.getEquipeByID(equipe14);
                    equipe15 = equipeController.getEquipeByID(equipe15);
                    equipe16 = equipeController.getEquipeByID(equipe16);

                    grupo2.setEquipe1(equipe5);
                    editEquipe5.setText(grupo2.getEquipe1().getNome());
                    grupo2.setEquipe2(equipe6);
                    editEquipe6.setText(grupo2.getEquipe2().getNome());
                    grupo2.setEquipe3(equipe7);
                    editEquipe7.setText(grupo2.getEquipe3().getNome());
                    grupo2.setEquipe4(equipe8);
                    editEquipe8.setText(grupo2.getEquipe4().getNome());

                    grupo3.setEquipe1(equipe9);
                    editEquipe9.setText(grupo3.getEquipe1().getNome());
                    grupo3.setEquipe2(equipe10);
                    editEquipe10.setText(grupo3.getEquipe2().getNome());
                    grupo3.setEquipe3(equipe11);
                    editEquipe11.setText(grupo3.getEquipe3().getNome());
                    grupo3.setEquipe4(equipe12);
                    editEquipe12.setText(grupo3.getEquipe4().getNome());

                    grupo4.setEquipe1(equipe13);
                    editEquipe13.setText(grupo4.getEquipe1().getNome());
                    grupo4.setEquipe2(equipe14);
                    editEquipe14.setText(grupo4.getEquipe2().getNome());
                    grupo4.setEquipe3(equipe15);
                    editEquipe15.setText(grupo4.getEquipe3().getNome());
                    grupo4.setEquipe4(equipe16);
                    editEquipe16.setText(grupo4.getEquipe4().getNome());

                }
            }
        } else {
            showFancyAlertDialog();
        }
    }

    private void showFancyAlertDialog() {
        new FancyAlertDialog.Builder(Equipes.this)
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
                        Intent intent = new Intent(Equipes.this, Dashboard.class);
                        startActivity(intent);
                    }
                })
                .build();
    }

    public void editarGrupoA(View view) {
        if (qtdEquipes == Torneio.TORNEIO_QUATRO_EQUIPES || qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
            btnSalvarGrupoA.setEnabled(true);
            btnEditarGrupoA.setEnabled(false);
            editEquipe1.setEnabled(true);
            editEquipe2.setEnabled(true);
            editEquipe3.setEnabled(true);
            editEquipe4.setEnabled(true);
        } else if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
            btnSalvarGrupoA.setEnabled(true);
            btnEditarGrupoA.setEnabled(false);
            editEquipe1.setEnabled(true);
            editEquipe2.setEnabled(true);
            editEquipe3.setEnabled(true);
        }
    }

    public void editarGrupoB(View view) {
        if (qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
            btnSalvarGrupoB.setEnabled(true);
            btnEditarGrupoB.setEnabled(false);
            editEquipe5.setEnabled(true);
            editEquipe6.setEnabled(true);
            editEquipe7.setEnabled(true);
            editEquipe8.setEnabled(true);
        } else if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
            btnSalvarGrupoB.setEnabled(true);
            btnEditarGrupoB.setEnabled(false);
            editEquipe4.setEnabled(true);
            editEquipe5.setEnabled(true);
            editEquipe6.setEnabled(true);
        }
    }

    public void editarGrupoC(View view) {
        if (qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
            btnSalvarGrupoC.setEnabled(true);
            btnEditarGrupoC.setEnabled(false);
            editEquipe9.setEnabled(true);
            editEquipe10.setEnabled(true);
            editEquipe11.setEnabled(true);
            editEquipe12.setEnabled(true);
        } else if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
            btnSalvarGrupoC.setEnabled(true);
            btnEditarGrupoC.setEnabled(false);
            editEquipe7.setEnabled(true);
            editEquipe8.setEnabled(true);
            editEquipe9.setEnabled(true);
        }
    }

    public void editarGrupoD(View view) {
        if (qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
            btnSalvarGrupoD.setEnabled(true);
            btnEditarGrupoD.setEnabled(false);
            editEquipe13.setEnabled(true);
            editEquipe14.setEnabled(true);
            editEquipe15.setEnabled(true);
            editEquipe16.setEnabled(true);
        } else if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
            btnSalvarGrupoD.setEnabled(true);
            btnEditarGrupoD.setEnabled(false);
            editEquipe10.setEnabled(true);
            editEquipe11.setEnabled(true);
            editEquipe12.setEnabled(true);
        }
    }

    public void salvarGrupoA(View view) {
        if (validarFormularioGrupoA()) {
            if (salvarA()) {
                Toast.makeText(this, "Dados Salvos com Sucesso...", Toast.LENGTH_SHORT).show();

                AppUtil.goNextScreen(Equipes.this, Dashboard.class, true);
                finish();
            } else
                Toast.makeText(this, "Falha ao salvar os dados...", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(getApplicationContext(), "Favor, preencher todos os campos!", Toast.LENGTH_SHORT).show();
    }

    public void salvarGrupoB(View view) {
        if (validarFormularioGrupoB()) {
            if (salvarB()) {
                Toast.makeText(this, "Dados Salvos com Sucesso...", Toast.LENGTH_SHORT).show();

                AppUtil.goNextScreen(Equipes.this, Dashboard.class, true);
                finish();
            } else
                Toast.makeText(this, "Falha ao salvar os dados...", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(getApplicationContext(), "Favor, preencher todos os campos!", Toast.LENGTH_SHORT).show();
    }

    public void salvarGrupoC(View view) {
        if (validarFormularioGrupoC()) {
            if (salvarC()) {
                Toast.makeText(this, "Dados Salvos com Sucesso...", Toast.LENGTH_SHORT).show();

                AppUtil.goNextScreen(Equipes.this, Dashboard.class, true);
                finish();
            } else
                Toast.makeText(this, "Falha ao salvar os dados...", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(getApplicationContext(), "Favor, preencher todos os campos!", Toast.LENGTH_SHORT).show();
    }

    public void salvarGrupoD(View view) {
        if (validarFormularioGrupoD()) {
            if (salvarD()) {
                Toast.makeText(this, "Dados Salvos com Sucesso...", Toast.LENGTH_SHORT).show();

                AppUtil.goNextScreen(Equipes.this, Dashboard.class, true);
                finish();
            } else
                Toast.makeText(this, "Falha ao salvar os dados...", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(getApplicationContext(), "Favor, preencher todos os campos!", Toast.LENGTH_SHORT).show();
    }

    private boolean validarFormularioGrupoA() {
        boolean retorno = true;
        if (qtdEquipes == Torneio.TORNEIO_QUATRO_EQUIPES || qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
            if (TextUtils.isEmpty(editEquipe1.getText().toString())) {
                editEquipe1.setError("*");
                editEquipe1.requestFocus();
                retorno = false;
            }
            if (TextUtils.isEmpty(editEquipe2.getText().toString())) {
                editEquipe2.setError("*");
                editEquipe2.requestFocus();
                retorno = false;
            }
            if (TextUtils.isEmpty(editEquipe3.getText().toString())) {
                editEquipe3.setError("*");
                editEquipe3.requestFocus();
                retorno = false;
            }
            if (TextUtils.isEmpty(editEquipe4.getText().toString())) {
                editEquipe4.setError("*");
                editEquipe4.requestFocus();
                retorno = false;
            }
        } else if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
            if (TextUtils.isEmpty(editEquipe1.getText().toString())) {
                editEquipe1.setError("*");
                editEquipe1.requestFocus();
                retorno = false;
            }
            if (TextUtils.isEmpty(editEquipe2.getText().toString())) {
                editEquipe2.setError("*");
                editEquipe2.requestFocus();
                retorno = false;
            }
            if (TextUtils.isEmpty(editEquipe3.getText().toString())) {
                editEquipe3.setError("*");
                editEquipe3.requestFocus();
                retorno = false;
            }
        }
        return retorno;
    }

    private boolean validarFormularioGrupoB() {
        boolean retorno = true;
        if (qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
            if (TextUtils.isEmpty(editEquipe5.getText().toString())) {
                editEquipe5.setError("*");
                editEquipe5.requestFocus();
                retorno = false;
            }
            if (TextUtils.isEmpty(editEquipe6.getText().toString())) {
                editEquipe6.setError("*");
                editEquipe6.requestFocus();
                retorno = false;
            }
            if (TextUtils.isEmpty(editEquipe7.getText().toString())) {
                editEquipe7.setError("*");
                editEquipe7.requestFocus();
                retorno = false;
            }
            if (TextUtils.isEmpty(editEquipe8.getText().toString())) {
                editEquipe8.setError("*");
                editEquipe8.requestFocus();
                retorno = false;
            }
        } else if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
            if (TextUtils.isEmpty(editEquipe4.getText().toString())) {
                editEquipe4.setError("*");
                editEquipe4.requestFocus();
                retorno = false;
            }
            if (TextUtils.isEmpty(editEquipe5.getText().toString())) {
                editEquipe5.setError("*");
                editEquipe5.requestFocus();
                retorno = false;
            }
            if (TextUtils.isEmpty(editEquipe6.getText().toString())) {
                editEquipe6.setError("*");
                editEquipe6.requestFocus();
                retorno = false;
            }
        }
        return retorno;
    }

    private boolean validarFormularioGrupoC() {
        boolean retorno = true;
        if (qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
            if (TextUtils.isEmpty(editEquipe9.getText().toString())) {
                editEquipe9.setError("*");
                editEquipe9.requestFocus();
                retorno = false;
            }
            if (TextUtils.isEmpty(editEquipe10.getText().toString())) {
                editEquipe10.setError("*");
                editEquipe10.requestFocus();
                retorno = false;
            }
            if (TextUtils.isEmpty(editEquipe11.getText().toString())) {
                editEquipe11.setError("*");
                editEquipe11.requestFocus();
                retorno = false;
            }
            if (TextUtils.isEmpty(editEquipe12.getText().toString())) {
                editEquipe12.setError("*");
                editEquipe12.requestFocus();
                retorno = false;
            }
        } else if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
            if (TextUtils.isEmpty(editEquipe7.getText().toString())) {
                editEquipe7.setError("*");
                editEquipe7.requestFocus();
                retorno = false;
            }
            if (TextUtils.isEmpty(editEquipe8.getText().toString())) {
                editEquipe8.setError("*");
                editEquipe8.requestFocus();
                retorno = false;
            }
            if (TextUtils.isEmpty(editEquipe9.getText().toString())) {
                editEquipe9.setError("*");
                editEquipe9.requestFocus();
                retorno = false;
            }
        }
        return retorno;
    }

    private boolean validarFormularioGrupoD() {
        boolean retorno = true;
        if (qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
            if (TextUtils.isEmpty(editEquipe13.getText().toString())) {
                editEquipe13.setError("*");
                editEquipe13.requestFocus();
                retorno = false;
            }
            if (TextUtils.isEmpty(editEquipe14.getText().toString())) {
                editEquipe14.setError("*");
                editEquipe14.requestFocus();
                retorno = false;
            }
            if (TextUtils.isEmpty(editEquipe15.getText().toString())) {
                editEquipe15.setError("*");
                editEquipe15.requestFocus();
                retorno = false;
            }
            if (TextUtils.isEmpty(editEquipe16.getText().toString())) {
                editEquipe16.setError("*");
                editEquipe16.requestFocus();
                retorno = false;
            }
        } else if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
            if (TextUtils.isEmpty(editEquipe10.getText().toString())) {
                editEquipe10.setError("*");
                editEquipe10.requestFocus();
                retorno = false;
            }
            if (TextUtils.isEmpty(editEquipe11.getText().toString())) {
                editEquipe11.setError("*");
                editEquipe11.requestFocus();
                retorno = false;
            }
            if (TextUtils.isEmpty(editEquipe12.getText().toString())) {
                editEquipe12.setError("*");
                editEquipe12.requestFocus();
                retorno = false;
            }
        }
        return retorno;
    }

    private boolean salvarA() {
        try {
            if (qtdEquipes == Torneio.TORNEIO_QUATRO_EQUIPES || qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
                //Editando Equipe 1
                equipe1.setId(equipe1ID);
                equipe1.setNome(editEquipe1.getText().toString());
                equipe1.setGrupoID(grupo1ID);
                if (equipeController.alterar(equipe1)) {
                    // obj salvo com sucesso no DB
                    sucesso = true;
                } else {
                    // falha ao salvar o obj  no DB
                    sucesso = false;
                    return sucesso;
                }
                grupo1.setEquipe1(equipe1);

                //Editando Equipe 2
                equipe2.setId(equipe2ID);
                equipe2.setNome(editEquipe2.getText().toString());
                equipe2.setGrupoID(grupo1ID);
                if (equipeController.alterar(equipe2)) {
                    sucesso = true;
                } else {
                    sucesso = false;
                    return sucesso;
                }
                grupo1.setEquipe2(equipe2);

                //Editando Equipe 3
                equipe3.setId(equipe3ID);
                equipe3.setNome(editEquipe3.getText().toString());
                equipe3.setGrupoID(grupo1ID);
                if (equipeController.alterar(equipe3)) {
                    sucesso = true;
                } else {
                    sucesso = false;
                    return sucesso;
                }
                grupo1.setEquipe3(equipe3);

                //Editando Equipe 4
                equipe4.setId(equipe4ID);
                equipe4.setNome(editEquipe4.getText().toString());
                equipe4.setGrupoID(grupo1ID);
                if (equipeController.alterar(equipe4)) {
                    // obj salvo com sucesso no DB
                    sucesso = true;
                } else {
                    // falha ao salvar o obj  no DB
                    sucesso = false;
                    return sucesso;
                }
                grupo1.setEquipe4(equipe4);

                salvarSharedPreferencesGA();
            } else if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
                //Editando Equipe 1
                equipe1.setId(equipe1ID);
                equipe1.setNome(editEquipe1.getText().toString());
                equipe1.setGrupoID(grupo1ID);
                if (equipeController.alterar(equipe1)) {
                    // obj salvo com sucesso no DB
                    sucesso = true;
                } else {
                    // falha ao salvar o obj  no DB
                    sucesso = false;
                    return sucesso;
                }
                grupo1.setEquipe1(equipe1);

                //Editando Equipe 2
                equipe2.setId(equipe2ID);
                equipe2.setNome(editEquipe2.getText().toString());
                equipe2.setGrupoID(grupo1ID);
                if (equipeController.alterar(equipe2)) {
                    sucesso = true;
                } else {
                    sucesso = false;
                    return sucesso;
                }
                grupo1.setEquipe2(equipe2);

                //Editando Equipe 3
                equipe3.setId(equipe3ID);
                equipe3.setNome(editEquipe3.getText().toString());
                equipe3.setGrupoID(grupo1ID);
                if (equipeController.alterar(equipe3)) {
                    sucesso = true;
                } else {
                    sucesso = false;
                    return sucesso;
                }
                grupo1.setEquipe3(equipe3);

                salvarSharedPreferencesGA();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Não foi possível alterar as equipes...", Toast.LENGTH_LONG).show();
        }
        return sucesso;
    }

    private boolean salvarB() {
        try {
            if (qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
                //Editando Equipe 5
                equipe5.setId(equipe5ID);
                equipe5.setNome(editEquipe5.getText().toString());
                equipe5.setGrupoID(grupo2ID);
                if (equipeController.alterar(equipe5)) {
                    sucesso = true;
                } else {
                    sucesso = false;
                    return sucesso;
                }
                grupo2.setEquipe1(equipe5);

                //Editando Equipe 6
                equipe6.setId(equipe6ID);
                equipe6.setNome(editEquipe6.getText().toString());
                equipe6.setGrupoID(grupo2ID);
                if (equipeController.alterar(equipe6)) {
                    sucesso = true;
                } else {
                    sucesso = false;
                    return sucesso;
                }
                grupo2.setEquipe2(equipe6);

                //Editando Equipe 7
                equipe7.setId(equipe7ID);
                equipe7.setNome(editEquipe7.getText().toString());
                equipe7.setGrupoID(grupo2ID);
                if (equipeController.alterar(equipe7)) {
                    // obj salvo com sucesso no DB
                    sucesso = true;
                } else {
                    // falha ao salvar o obj  no DB
                    sucesso = false;
                    return sucesso;
                }
                grupo2.setEquipe3(equipe7);

                //Editando Equipe 8
                equipe8.setId(equipe8ID);
                equipe8.setNome(editEquipe8.getText().toString());
                equipe8.setGrupoID(grupo2ID);
                if (equipeController.alterar(equipe8)) {
                    sucesso = true;
                } else {
                    sucesso = false;
                    return sucesso;
                }
                grupo2.setEquipe4(equipe8);

                salvarSharedPreferencesGB();
            } else if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
                //Editando Equipe 4
                equipe4.setId(equipe4ID);
                equipe4.setNome(editEquipe4.getText().toString());
                equipe4.setGrupoID(grupo2ID);
                if (equipeController.alterar(equipe4)) {
                    // obj salvo com sucesso no DB
                    sucesso = true;
                } else {
                    // falha ao salvar o obj  no DB
                    sucesso = false;
                    return sucesso;
                }
                grupo2.setEquipe1(equipe4);

                //Editando Equipe 5
                equipe5.setId(equipe5ID);
                equipe5.setNome(editEquipe5.getText().toString());
                equipe5.setGrupoID(grupo2ID);
                if (equipeController.alterar(equipe5)) {
                    sucesso = true;
                } else {
                    sucesso = false;
                    return sucesso;
                }
                grupo2.setEquipe2(equipe5);

                //Editando Equipe 6
                equipe6.setId(equipe6ID);
                equipe6.setNome(editEquipe6.getText().toString());
                equipe6.setGrupoID(grupo2ID);
                if (equipeController.alterar(equipe6)) {
                    sucesso = true;
                } else {
                    sucesso = false;
                    return sucesso;
                }
                grupo2.setEquipe3(equipe6);

                salvarSharedPreferencesGB();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Não foi possível alterar as equipes...", Toast.LENGTH_LONG).show();
        }
        return sucesso;
    }

    private boolean salvarC() {
        try {
            if (qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
                //Editando Equipe 9
                equipe9.setId(equipe9ID);
                equipe9.setNome(editEquipe9.getText().toString());
                equipe9.setGrupoID(grupo3ID);
                if (equipeController.alterar(equipe9)) {
                    sucesso = true;
                } else {
                    sucesso = false;
                    return sucesso;
                }
                grupo3.setEquipe1(equipe9);

                //Editando Equipe 10
                equipe10.setId(equipe10ID);
                equipe10.setNome(editEquipe10.getText().toString());
                equipe10.setGrupoID(grupo3ID);
                if (equipeController.alterar(equipe10)) {
                    // obj salvo com sucesso no DB
                    sucesso = true;
                } else {
                    // falha ao salvar o obj  no DB
                    sucesso = false;
                    return sucesso;
                }
                grupo3.setEquipe2(equipe10);

                //Editando Equipe 11
                equipe11.setId(equipe11ID);
                equipe11.setNome(editEquipe11.getText().toString());
                equipe11.setGrupoID(grupo3ID);
                if (equipeController.alterar(equipe11)) {
                    sucesso = true;
                } else {
                    sucesso = false;
                    return sucesso;
                }
                grupo3.setEquipe3(equipe11);

                //Editando Equipe 12
                equipe12.setId(equipe12ID);
                equipe12.setNome(editEquipe12.getText().toString());
                equipe12.setGrupoID(grupo3ID);
                if (equipeController.alterar(equipe12)) {
                    sucesso = true;
                } else {
                    sucesso = false;
                    return sucesso;
                }
                grupo3.setEquipe4(equipe12);

                salvarSharedPreferencesGC();
            } else if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {

                //Editando Equipe 7
                equipe7.setId(equipe7ID);
                equipe7.setNome(editEquipe7.getText().toString());
                equipe7.setGrupoID(grupo3ID);
                if (equipeController.alterar(equipe7)) {
                    // obj salvo com sucesso no DB
                    sucesso = true;
                } else {
                    // falha ao salvar o obj  no DB
                    sucesso = false;
                    return sucesso;
                }
                grupo3.setEquipe1(equipe7);

                //Editando Equipe 8
                equipe8.setId(equipe8ID);
                equipe8.setNome(editEquipe8.getText().toString());
                equipe8.setGrupoID(grupo3ID);
                if (equipeController.alterar(equipe8)) {
                    sucesso = true;
                } else {
                    sucesso = false;
                    return sucesso;
                }
                grupo3.setEquipe2(equipe8);

                //Editando Equipe 9
                equipe9.setId(equipe9ID);
                equipe9.setNome(editEquipe9.getText().toString());
                equipe9.setGrupoID(grupo3ID);
                if (equipeController.alterar(equipe9)) {
                    sucesso = true;
                } else {
                    sucesso = false;
                    return sucesso;
                }
                grupo3.setEquipe3(equipe9);

                salvarSharedPreferencesGC();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Não foi possível alterar as equipes...", Toast.LENGTH_LONG).show();
        }
        return sucesso;
    }

    private boolean salvarD() {
        try {
            if (qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
                //Editando Equipe 13
                equipe13.setId(equipe13ID);
                equipe13.setNome(editEquipe13.getText().toString());
                equipe13.setGrupoID(grupo4ID);
                if (equipeController.alterar(equipe13)) {
                    // obj salvo com sucesso no DB
                    sucesso = true;
                } else {
                    // falha ao salvar o obj  no DB
                    sucesso = false;
                    return sucesso;
                }
                grupo4.setEquipe1(equipe13);

                //Editando Equipe 14
                equipe14.setId(equipe14ID);
                equipe14.setNome(editEquipe14.getText().toString());
                equipe14.setGrupoID(grupo4ID);
                if (equipeController.alterar(equipe14)) {
                    sucesso = true;
                } else {
                    sucesso = false;
                    return sucesso;
                }
                grupo4.setEquipe2(equipe14);

                //Editando Equipe 15
                equipe15.setId(equipe15ID);
                equipe15.setNome(editEquipe15.getText().toString());
                equipe15.setGrupoID(grupo4ID);
                if (equipeController.alterar(equipe15)) {
                    sucesso = true;
                } else {
                    sucesso = false;
                    return sucesso;
                }
                grupo4.setEquipe3(equipe15);

                //Editando Equipe 16
                equipe16.setId(equipe16ID);
                equipe16.setNome(editEquipe16.getText().toString());
                equipe16.setGrupoID(grupo4ID);
                if (equipeController.alterar(equipe16)) {
                    sucesso = true;
                } else {
                    sucesso = false;
                    return sucesso;
                }
                grupo4.setEquipe4(equipe16);

                salvarSharedPreferencesGD();
            } else if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
                //Editando Equipe 10
                equipe10.setId(equipe10ID);
                equipe10.setNome(editEquipe10.getText().toString());
                equipe10.setGrupoID(grupo4ID);
                if (equipeController.alterar(equipe10)) {
                    // obj salvo com sucesso no DB
                    sucesso = true;
                } else {
                    // falha ao salvar o obj  no DB
                    sucesso = false;
                    return sucesso;
                }
                grupo4.setEquipe1(equipe10);

                //Editando Equipe 11
                equipe11.setId(equipe11ID);
                equipe11.setNome(editEquipe11.getText().toString());
                equipe11.setGrupoID(grupo4ID);
                if (equipeController.alterar(equipe11)) {
                    sucesso = true;
                } else {
                    sucesso = false;
                    return sucesso;
                }
                grupo4.setEquipe2(equipe11);

                //Editando Equipe 12
                equipe12.setId(equipe12ID);
                equipe12.setNome(editEquipe12.getText().toString());
                equipe12.setGrupoID(grupo4ID);
                if (equipeController.alterar(equipe12)) {
                    sucesso = true;
                } else {
                    sucesso = false;
                    return sucesso;
                }
                grupo4.setEquipe3(equipe12);

                salvarSharedPreferencesGD();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Não foi possível alterar as equipes...", Toast.LENGTH_LONG).show();
        }
        return sucesso;
    }

    public void voltar(View view) {
        AppUtil.goNextScreen(Equipes.this, Dashboard.class, true);
        finish();
    }

    @Override
    public void onBackPressed() {
        AppUtil.goNextScreen(Equipes.this, Dashboard.class, true);
        finish();
    }

    private void salvarSharedPreferencesGA() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        if (qtdEquipes == Torneio.TORNEIO_QUATRO_EQUIPES || qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
            dados.putString("nomeEquipe1", equipe1.getNome());
            dados.putString("nomeEquipe2", equipe2.getNome());
            dados.putString("nomeEquipe3", equipe3.getNome());
            dados.putString("nomeEquipe4", equipe4.getNome());
        } else if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
            dados.putString("nomeEquipe1", equipe1.getNome());
            dados.putString("nomeEquipe2", equipe2.getNome());
            dados.putString("nomeEquipe3", equipe3.getNome());
        }
        dados.apply();
    }

    private void salvarSharedPreferencesGB() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        if (qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
            dados.putString("nomeEquipe5", equipe5.getNome());
            dados.putString("nomeEquipe6", equipe6.getNome());
            dados.putString("nomeEquipe7", equipe7.getNome());
            dados.putString("nomeEquipe8", equipe8.getNome());
        } else if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
            dados.putString("nomeEquipe4", equipe4.getNome());
            dados.putString("nomeEquipe5", equipe5.getNome());
            dados.putString("nomeEquipe6", equipe6.getNome());
        }
        dados.apply();
    }

    private void salvarSharedPreferencesGC() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        if (qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
            dados.putString("nomeEquipe9", equipe9.getNome());
            dados.putString("nomeEquipe10", equipe10.getNome());
            dados.putString("nomeEquipe11", equipe11.getNome());
            dados.putString("nomeEquipe12", equipe12.getNome());
        } else if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
            dados.putString("nomeEquipe7", equipe7.getNome());
            dados.putString("nomeEquipe8", equipe8.getNome());
            dados.putString("nomeEquipe9", equipe9.getNome());
        }
        dados.apply();
    }

    private void salvarSharedPreferencesGD() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        if (qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
            dados.putString("nomeEquipe13", equipe13.getNome());
            dados.putString("nomeEquipe14", equipe14.getNome());
            dados.putString("nomeEquipe15", equipe15.getNome());
            dados.putString("nomeEquipe16", equipe16.getNome());
        } else if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES) {
            dados.putString("nomeEquipe10", equipe10.getNome());
            dados.putString("nomeEquipe11", equipe11.getNome());
            dados.putString("nomeEquipe12", equipe12.getNome());
        }
        dados.apply();
    }

    private void restaurarSharedPreferencesQtdEquipes() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);

        qtdEquipes = preferences.getInt("qtdEquipes", -1);
    }

    private void restaurarSharedPreferences() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);

        qtdEquipes = preferences.getInt("qtdEquipes", -1);

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

        if (qtdEquipes == Torneio.TORNEIO_DOZE_EQUIPES || qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
            grupo2ID = preferences.getInt("grupo2ID", -1);
            nomeGrupo2 = preferences.getString("nomeGrupo2", "");
            grupo3ID = preferences.getInt("grupo3ID", -1);
            nomeGrupo3 = preferences.getString("nomeGrupo3", "");
            grupo4ID = preferences.getInt("grupo4ID", -1);
            nomeGrupo4 = preferences.getString("nomeGrupo4", "");
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
        }
        if (qtdEquipes == Torneio.TORNEIO_DEZESSEIS_EQUIPES) {
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