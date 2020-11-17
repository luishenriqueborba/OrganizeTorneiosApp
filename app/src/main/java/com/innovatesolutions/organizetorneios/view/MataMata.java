package com.innovatesolutions.organizetorneios.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.api.AppUtil;
import com.innovatesolutions.organizetorneios.controller.EquipeController;
import com.innovatesolutions.organizetorneios.controller.GrupoController;
import com.innovatesolutions.organizetorneios.model.Equipe;
import com.innovatesolutions.organizetorneios.model.Grupo;

public class MataMata extends AppCompatActivity {

    TextView txtEquipe1, txtEquipe2, txtEquipe3, txtEquipe4, txtEquipe5, txtEquipe6, txtEquipe7, txtEquipe8, txtEquipe1Semi, txtEquipe2Semi, txtEquipe3Semi, txtEquipe4Semi, txtEquipe1Terceiro, txtEquipe2Terceiro, txtEquipe1Final, txtEquipe2Final;

    EditText editPlacarEquipe1, editPlacarEquipe2, editPlacarEquipe3, editPlacarEquipe4, editPlacarEquipe5, editPlacarEquipe6, editPlacarEquipe7, editPlacarEquipe8, editPlacarEquipe1Semi, editPlacarEquipe2Semi, editPlacarEquipe3Semi, editPlacarEquipe4Semi, editPlacarEquipe1Terceiro, editPlacarEquipe2Terceiro, editPlacarEquipe1Final, editPlacarEquipe2Final;

    AlertDialog.Builder builder;
    AlertDialog alert;

    Grupo grupo1, grupo2, grupo3, grupo4;
    GrupoController grupoController;

    Equipe equipe1, equipe2, equipe3, equipe4, equipe5, equipe6, equipe7, equipe8, equipe1S, equipe2S, equipe3S, equipe4S, equipe1T, equipe2T, equipe1F, equipe2F, equipeMula1, equipeMula2;
    EquipeController equipeController;

    SharedPreferences preferences;

    int i, j, grupo1ID, grupo2ID, grupo3ID, grupo4ID, vencedor1QuartasGrupoID, vencedor2QuartasGrupoID, vencedor3QuartasGrupoID, vencedor4QuartasGrupoID, perdedor1SemiGrupoID, perdedor2SemiGrupoID, vencedor1SemiGrupoID, vencedor2SemiGrupoID, primeiroAID, segundoAID, terceiroAID, primeiroBID, segundoBID, terceiroBID, primeiroCID, segundoCID, terceiroCID, primeiroDID, segundoDID, terceiroDID, vencedor1QuartasID, vencedor2QuartasID, vencedor3QuartasID, vencedor4QuartasID, vencedor1SemiID, vencedor2SemiID, perdedor1SemiID, perdedor2SemiID, placarA, placarB, quantidade1 = 3, quantidade2 = 2, quantidadeSemi = 4, qtdEquipes,
            pEquipe1Quartas, jEquipe1Quartas, vEquipe1Quartas, eEquipe1Quartas, dEquipe1Quartas, gpEquipe1Quartas, gcEquipe1Quartas, sgEquipe1Quartas,
            pEquipe2Quartas, jEquipe2Quartas, vEquipe2Quartas, eEquipe2Quartas, dEquipe2Quartas, gpEquipe2Quartas, gcEquipe2Quartas, sgEquipe2Quartas,
            pEquipe3Quartas, jEquipe3Quartas, vEquipe3Quartas, eEquipe3Quartas, dEquipe3Quartas, gpEquipe3Quartas, gcEquipe3Quartas, sgEquipe3Quartas,
            pEquipe4Quartas, jEquipe4Quartas, vEquipe4Quartas, eEquipe4Quartas, dEquipe4Quartas, gpEquipe4Quartas, gcEquipe4Quartas, sgEquipe4Quartas,
            pEquipe5Quartas, jEquipe5Quartas, vEquipe5Quartas, eEquipe5Quartas, dEquipe5Quartas, gpEquipe5Quartas, gcEquipe5Quartas, sgEquipe5Quartas,
            pEquipe6Quartas, jEquipe6Quartas, vEquipe6Quartas, eEquipe6Quartas, dEquipe6Quartas, gpEquipe6Quartas, gcEquipe6Quartas, sgEquipe6Quartas,
            pEquipe7Quartas, jEquipe7Quartas, vEquipe7Quartas, eEquipe7Quartas, dEquipe7Quartas, gpEquipe7Quartas, gcEquipe7Quartas, sgEquipe7Quartas,
            pEquipe8Quartas, jEquipe8Quartas, vEquipe8Quartas, eEquipe8Quartas, dEquipe8Quartas, gpEquipe8Quartas, gcEquipe8Quartas, sgEquipe8Quartas,
            pEquipe1Semi, jEquipe1Semi, vEquipe1Semi, eEquipe1Semi, dEquipe1Semi, gpEquipe1Semi, gcEquipe1Semi, sgEquipe1Semi,
            pEquipe2Semi, jEquipe2Semi, vEquipe2Semi, eEquipe2Semi, dEquipe2Semi, gpEquipe2Semi, gcEquipe2Semi, sgEquipe2Semi,
            pEquipe3Semi, jEquipe3Semi, vEquipe3Semi, eEquipe3Semi, dEquipe3Semi, gpEquipe3Semi, gcEquipe3Semi, sgEquipe3Semi,
            pEquipe4Semi, jEquipe4Semi, vEquipe4Semi, eEquipe4Semi, dEquipe4Semi, gpEquipe4Semi, gcEquipe4Semi, sgEquipe4Semi,
            pEquipe1Ter, jEquipe1Ter, vEquipe1Ter, eEquipe1Ter, dEquipe1Ter, gpEquipe1Ter, gcEquipe1Ter, sgEquipe1Ter,
            pEquipe2Ter, jEquipe2Ter, vEquipe2Ter, eEquipe2Ter, dEquipe2Ter, gpEquipe2Ter, gcEquipe2Ter, sgEquipe2Ter,
            pEquipe1Final, jEquipe1Final, vEquipe1Final, eEquipe1Final, dEquipe1Final, gpEquipe1Final, gcEquipe1Final, sgEquipe1Final,
            pEquipe2Final, jEquipe2Final, vEquipe2Final, eEquipe2Final, dEquipe2Final, gpEquipe2Final, gcEquipe2Final, sgEquipe2Final;

    Equipe[] equipes, equipesA, equipesB, equipesC, equipesD, mula1, mula2;

    Button btnFinalizarQuartas, btnFinalizarSemi, btnFinalizarTerceiro, btnFinalizar;

    boolean sucesso, trocaTela, conseguiu, empate, finalizouQuartas, finalizouSemi, finalizouTerceiro, finalizouFinal;

    String nomeGrupo1, nomeGrupo2, nomeGrupo3, nomeGrupo4, nomePrimeiroA, nomeSegundoA, nomeTerceiroA, nomePrimeiroB, nomeSegundoB, nomeTerceiroB, nomePrimeiroC, nomeSegundoC, nomeTerceiroC, nomePrimeiroD, nomeSegundoD, nomeTerceiroD, nomeVencedor1Quartas, nomeVencedor2Quartas, nomeVencedor3Quartas, nomeVencedor4Quartas, nomeVencedor1Semi, nomeVencedor2Semi, nomePerdedor1Semi, nomePerdedor2Semi,
            placarEquipe1Quartas,
            placarEquipe2Quartas,
            placarEquipe3Quartas,
            placarEquipe4Quartas,
            placarEquipe5Quartas,
            placarEquipe6Quartas,
            placarEquipe7Quartas,
            placarEquipe8Quartas,
            placarEquipe1Semi,
            placarEquipe2Semi,
            placarEquipe3Semi,
            placarEquipe4Semi,
            placarEquipe1Terceiro,
            placarEquipe2Terceiro,
            placarEquipe1Final,
            placarEquipe2Final;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mata_mata_doze);

        restaurarSharedPreferencesQtdEquipes();

        switch (qtdEquipes) {

            case 4:
                setContentView(R.layout.activity_mata_mata_quatro);
                restaurarSharedPreferences();
                initFormulario();
                popularFormulario();

                if (finalizouFinal) {

                    finalizarTorneioFake();
                }

                break;

            case 12:
            case 16:
                setContentView(R.layout.activity_mata_mata_doze);
                restaurarSharedPreferencesQuartas();
                initFormularioQuartas();
                popularFormularioQuartas();

                if (finalizouQuartas) {

                    finalizarQuartas(null);

                    if (finalizouSemi) {

                        finalizarSemi(null);

                        if (finalizouTerceiro) {

                            finalizarTerceiro(null);

                            if (finalizouFinal) {

                                finalizarTorneioFake();
                            }
                        }
                    }
                }
                break;
        }

    }

    private void initFormulario() {

        txtEquipe1 = findViewById(R.id.txtEquipe1);
        txtEquipe2 = findViewById(R.id.txtEquipe2);

        editPlacarEquipe1Final = findViewById(R.id.editPlacarEquipe1);
        editPlacarEquipe2Final = findViewById(R.id.editPlacarEquipe2);

        btnFinalizar = findViewById(R.id.btnFinalizar);

        equipe1 = new Equipe();
        equipe1.setId(primeiroAID);

        equipe2 = new Equipe();
        equipe2.setId(segundoAID);

        grupo1 = new Grupo();
        grupo1.setId(grupo1ID);

        equipes = new Equipe[quantidade1];
        mula2 = new Equipe[quantidade2];

        equipeController = new EquipeController(this);
        grupoController = new GrupoController(this);

    }

    private void popularFormulario() {

        if (grupo1ID >= 1) {

            grupo1 = grupoController.getGrupoByID(grupo1);
            equipe1 = equipeController.getEquipeByID(equipe1);
            equipe2 = equipeController.getEquipeByID(equipe2);

            equipes[0] = equipe1;
            equipes[1] = equipe2;

            grupo1.setEquipe1(equipes[0]);
            txtEquipe1.setText(grupo1.getEquipe1().getNome());

            grupo1.setEquipe2(equipes[1]);
            txtEquipe2.setText(grupo1.getEquipe2().getNome());

            editPlacarEquipe1Final.setText(placarEquipe1Final);
            editPlacarEquipe2Final.setText(placarEquipe2Final);

            trocaTela = true;

        } else {

            builder = new AlertDialog.Builder(this);
            builder.setTitle("ATENÇÃO:");
            builder.setMessage("Não foi possível recuperar os dados das equipes!");
            builder.setCancelable(true);
            builder.setIcon(R.mipmap.ic_launcher_round);

            builder.setPositiveButton("RETORNAR", new Dialog.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.cancel();

                    Intent intent = new Intent(MataMata.this, Dashboard.class);
                    startActivity(intent);
                }
            });

            alert = builder.create();
            alert.show();

        }
    }

    private void initFormularioQuartas() {

        txtEquipe1 = findViewById(R.id.txtEquipe1);
        txtEquipe2 = findViewById(R.id.txtEquipe2);
        txtEquipe3 = findViewById(R.id.txtEquipe3);
        txtEquipe4 = findViewById(R.id.txtEquipe4);
        txtEquipe5 = findViewById(R.id.txtEquipe5);
        txtEquipe6 = findViewById(R.id.txtEquipe6);
        txtEquipe7 = findViewById(R.id.txtEquipe7);
        txtEquipe8 = findViewById(R.id.txtEquipe8);

        editPlacarEquipe1 = findViewById(R.id.editPlacarEquipe1);
        editPlacarEquipe2 = findViewById(R.id.editPlacarEquipe2);
        editPlacarEquipe3 = findViewById(R.id.editPlacarEquipe3);
        editPlacarEquipe4 = findViewById(R.id.editPlacarEquipe4);
        editPlacarEquipe5 = findViewById(R.id.editPlacarEquipe5);
        editPlacarEquipe6 = findViewById(R.id.editPlacarEquipe6);
        editPlacarEquipe7 = findViewById(R.id.editPlacarEquipe7);
        editPlacarEquipe8 = findViewById(R.id.editPlacarEquipe8);

        btnFinalizarQuartas = findViewById(R.id.btnFinalizarQuartas);
        btnFinalizarSemi = findViewById(R.id.btnFinalizarSemi);
        btnFinalizarTerceiro = findViewById(R.id.btnFinalizarTerceiro);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        equipe1 = new Equipe();
        equipe1.setId(primeiroAID);
        equipe2 = new Equipe();
        equipe2.setId(segundoAID);
        equipe3 = new Equipe();
        equipe3.setId(primeiroBID);
        equipe4 = new Equipe();
        equipe4.setId(segundoBID);
        equipe5 = new Equipe();
        equipe5.setId(primeiroCID);
        equipe6 = new Equipe();
        equipe6.setId(segundoCID);
        equipe7 = new Equipe();
        equipe7.setId(primeiroDID);
        equipe8 = new Equipe();
        equipe8.setId(segundoDID);

        equipeMula1 = new Equipe();
        equipeMula2 = new Equipe();

        grupo1 = new Grupo();
        grupo1.setId(grupo1ID);
        grupo2 = new Grupo();
        grupo2.setId(grupo2ID);
        grupo3 = new Grupo();
        grupo3.setId(grupo3ID);
        grupo4 = new Grupo();
        grupo4.setId(grupo4ID);

        equipesA = new Equipe[quantidade1];
        equipesB = new Equipe[quantidade1];
        equipesC = new Equipe[quantidade1];
        equipesD = new Equipe[quantidade1];
        mula1 = new Equipe[quantidadeSemi];
        mula2 = new Equipe[quantidadeSemi];

        equipeController = new EquipeController(this);
        grupoController = new GrupoController(this);

    }

    private void initFormularioSemi() {

        txtEquipe1Semi = findViewById(R.id.txtEquipe1Semi);
        txtEquipe2Semi = findViewById(R.id.txtEquipe2Semi);
        txtEquipe3Semi = findViewById(R.id.txtEquipe3Semi);
        txtEquipe4Semi = findViewById(R.id.txtEquipe4Semi);
        editPlacarEquipe1Semi = findViewById(R.id.editPlacarEquipe1Semi);
        editPlacarEquipe2Semi = findViewById(R.id.editPlacarEquipe2Semi);
        editPlacarEquipe3Semi = findViewById(R.id.editPlacarEquipe3Semi);
        editPlacarEquipe4Semi = findViewById(R.id.editPlacarEquipe4Semi);

        equipe1S = new Equipe();
        equipe1S.setId(vencedor1QuartasID);
        equipe2S = new Equipe();
        equipe2S.setId(vencedor2QuartasID);
        equipe3S = new Equipe();
        equipe3S.setId(vencedor3QuartasID);
        equipe4S = new Equipe();
        equipe4S.setId(vencedor4QuartasID);
    }

    private void initFormularioTerceiro() {

        txtEquipe1Terceiro = findViewById(R.id.txtEquipe1Terceiro);
        txtEquipe2Terceiro = findViewById(R.id.txtEquipe2Terceiro);
        editPlacarEquipe1Terceiro = findViewById(R.id.editPlacarEquipe1Terceiro);
        editPlacarEquipe2Terceiro = findViewById(R.id.editPlacarEquipe2Terceiro);

        equipe1T = new Equipe();
        equipe1T.setId(perdedor1SemiID);
        equipe2T = new Equipe();
        equipe2T.setId(perdedor2SemiID);
    }

    private void initFormularioFinal() {

        txtEquipe1Final = findViewById(R.id.txtEquipe1Final);
        txtEquipe2Final = findViewById(R.id.txtEquipe2Final);
        editPlacarEquipe1Final = findViewById(R.id.editPlacarEquipe1Final);
        editPlacarEquipe2Final = findViewById(R.id.editPlacarEquipe2Final);

        equipe1F = new Equipe();
        equipe1F.setId(vencedor1SemiID);
        equipe2F = new Equipe();
        equipe2F.setId(vencedor2SemiID);
    }

    private void popularFormularioQuartas() {

        if (grupo4ID >= 1) {

            grupo1 = grupoController.getGrupoByID(grupo1);
            grupo2 = grupoController.getGrupoByID(grupo2);
            grupo3 = grupoController.getGrupoByID(grupo3);
            grupo4 = grupoController.getGrupoByID(grupo4);
            equipe1 = equipeController.getEquipeByID(equipe1);
            equipe2 = equipeController.getEquipeByID(equipe2);
            equipe3 = equipeController.getEquipeByID(equipe3);
            equipe4 = equipeController.getEquipeByID(equipe4);
            equipe5 = equipeController.getEquipeByID(equipe5);
            equipe6 = equipeController.getEquipeByID(equipe6);
            equipe7 = equipeController.getEquipeByID(equipe7);
            equipe8 = equipeController.getEquipeByID(equipe8);

            equipesA[0] = equipe1;
            equipesA[1] = equipe2;
            equipesB[0] = equipe3;
            equipesB[1] = equipe4;
            equipesC[0] = equipe5;
            equipesC[1] = equipe6;
            equipesD[0] = equipe7;
            equipesD[1] = equipe8;

            //1ºA X 2ºD
            grupo1.setEquipe1(equipesA[0]);
            txtEquipe1.setText(grupo1.getEquipe1().getNome());
            grupo4.setEquipe2(equipesD[1]);
            txtEquipe2.setText(grupo4.getEquipe2().getNome());

            //1ºB X 2ºC
            grupo2.setEquipe1(equipesB[0]);
            txtEquipe3.setText(grupo2.getEquipe1().getNome());
            grupo3.setEquipe2(equipesC[1]);
            txtEquipe4.setText(grupo3.getEquipe2().getNome());

            //1ºC X 2ºB
            grupo3.setEquipe1(equipesC[0]);
            txtEquipe5.setText(grupo3.getEquipe1().getNome());
            grupo2.setEquipe2(equipesB[1]);
            txtEquipe6.setText(grupo2.getEquipe2().getNome());

            //1ºD X 2ºA
            grupo4.setEquipe1(equipesD[0]);
            txtEquipe7.setText(grupo4.getEquipe1().getNome());
            grupo1.setEquipe2(equipesA[1]);
            txtEquipe8.setText(grupo1.getEquipe2().getNome());

            editPlacarEquipe1.setText(placarEquipe1Quartas);
            editPlacarEquipe2.setText(placarEquipe2Quartas);
            editPlacarEquipe3.setText(placarEquipe3Quartas);
            editPlacarEquipe4.setText(placarEquipe4Quartas);
            editPlacarEquipe5.setText(placarEquipe5Quartas);
            editPlacarEquipe6.setText(placarEquipe6Quartas);
            editPlacarEquipe7.setText(placarEquipe7Quartas);
            editPlacarEquipe8.setText(placarEquipe8Quartas);

            trocaTela = true;

        } else {

            builder = new AlertDialog.Builder(this);
            builder.setTitle("ATENÇÃO:");
            builder.setMessage("Não foi possível recuperar os dados das equipes!");
            builder.setCancelable(true);
            builder.setIcon(R.mipmap.ic_launcher_round);

            builder.setPositiveButton("RETORNAR", new Dialog.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.cancel();

                    Intent intent = new Intent(MataMata.this, Dashboard.class);
                    startActivity(intent);
                }
            });

            alert = builder.create();
            alert.show();
        }

    }

    private void popularFormularioSemi() {

        if (grupo4ID >= 1) {

            equipe1S = equipeController.getEquipeByID(equipe1S);
            equipe2S = equipeController.getEquipeByID(equipe2S);
            equipe3S = equipeController.getEquipeByID(equipe3S);
            equipe4S = equipeController.getEquipeByID(equipe4S);

            txtEquipe1Semi.setText(mula1[0].getNome());
            txtEquipe2Semi.setText(mula1[1].getNome());
            txtEquipe3Semi.setText(mula1[2].getNome());
            txtEquipe4Semi.setText(mula1[3].getNome());

            editPlacarEquipe1Semi.setText(placarEquipe1Semi);
            editPlacarEquipe2Semi.setText(placarEquipe2Semi);
            editPlacarEquipe3Semi.setText(placarEquipe3Semi);
            editPlacarEquipe4Semi.setText(placarEquipe4Semi);

            salvarSharedPreferencesInitSemi();

        } else {

            builder = new AlertDialog.Builder(this);
            builder.setTitle("ATENÇÃO:");
            builder.setMessage("Não foi possível recuperar os dados das equipes!");
            builder.setCancelable(true);
            builder.setIcon(R.mipmap.ic_launcher_round);

            builder.setPositiveButton("RETORNAR", new Dialog.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.cancel();

                    Intent intent = new Intent(MataMata.this, Dashboard.class);
                    startActivity(intent);
                }
            });

            alert = builder.create();
            alert.show();
        }

    }

    private void popularFormularioTerceiro() {

        if (grupo4ID >= 1) {

            equipe1T = equipeController.getEquipeByID(equipe1T);
            equipe2T = equipeController.getEquipeByID(equipe2T);

            txtEquipe1Terceiro.setText(mula2[2].getNome());
            txtEquipe2Terceiro.setText(mula2[3].getNome());

            editPlacarEquipe1Terceiro.setText(placarEquipe1Terceiro);
            editPlacarEquipe2Terceiro.setText(placarEquipe2Terceiro);

            salvarSharedPreferencesInitTerceiro();

        } else {

            builder = new AlertDialog.Builder(this);
            builder.setTitle("ATENÇÃO:");
            builder.setMessage("Não foi possível recuperar os dados das equipes!");
            builder.setCancelable(true);
            builder.setIcon(R.mipmap.ic_launcher_round);

            builder.setPositiveButton("RETORNAR", new Dialog.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.cancel();

                    Intent intent = new Intent(MataMata.this, Dashboard.class);
                    startActivity(intent);
                }
            });

            alert = builder.create();
            alert.show();
        }

    }

    private void popularFormularioFinal() {

        if (grupo4ID >= 1) {

            equipe1F = equipeController.getEquipeByID(equipe1F);
            equipe2F = equipeController.getEquipeByID(equipe2F);

            txtEquipe1Final.setText(mula2[0].getNome());
            txtEquipe2Final.setText(mula2[1].getNome());

            editPlacarEquipe1Final.setText(placarEquipe1Final);
            editPlacarEquipe2Final.setText(placarEquipe2Final);

            salvarSharedPreferencesInitFinal();

        } else {

            builder = new AlertDialog.Builder(this);
            builder.setTitle("ATENÇÃO:");
            builder.setMessage("Não foi possível recuperar os dados das equipes!");
            builder.setCancelable(true);
            builder.setIcon(R.mipmap.ic_launcher_round);

            builder.setPositiveButton("RETORNAR", new Dialog.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.cancel();

                    Intent intent = new Intent(MataMata.this, Dashboard.class);
                    startActivity(intent);
                }
            });

            alert = builder.create();
            alert.show();
        }

    }

    public boolean salvarJogoQuartas(Equipe equipe1, Equipe equipe2, EditText placarEquipe1, EditText placarEquipe2, int E1ID, int G1ID, int E2ID, int G2ID) {

        placarA = Integer.parseInt(placarEquipe1.getText().toString());
        placarB = Integer.parseInt(placarEquipe2.getText().toString());

        if (placarA > placarB) {

            equipe1.setId(E1ID);
            equipe1.setGrupoID(G1ID);
            equipe1.setJogos(equipe1.getJogos() + 1);
            equipe1.setPontos(equipe1.getPontos() + 3);
            equipe1.setVitorias(equipe1.getVitorias() + 1);
            equipe1.setGolsPro(equipe1.getGolsPro() + placarA);
            equipe1.setGolsContra(equipe1.getGolsContra() + placarB);
            if (equipeController.alterar(equipe1)) {
                mula1[i] = equipe1;
                // obj salvo com sucesso no DB
                sucesso = true;
            } else {
                // falha ao salvar o obj  no DB
                sucesso = false;
                return sucesso;
            }

            equipe2.setId(E2ID);
            equipe2.setGrupoID(G2ID);
            equipe2.setJogos(equipe2.getJogos() + 1);
            equipe2.setDerrotas(equipe2.getDerrotas() + 1);
            equipe2.setGolsPro(equipe2.getGolsPro() + placarB);
            equipe2.setGolsContra(equipe2.getGolsContra() + placarA);
            if (equipeController.alterar(equipe2)) {
                mula2[j] = equipe2;
                sucesso = true;
            } else {
                sucesso = false;
                return sucesso;
            }

        } else if (placarA < placarB) {

            equipe2.setId(E2ID);
            equipe2.setGrupoID(G2ID);
            equipe2.setJogos(equipe2.getJogos() + 1);
            equipe2.setPontos(equipe2.getPontos() + 3);
            equipe2.setVitorias(equipe2.getVitorias() + 1);
            equipe2.setGolsPro(equipe2.getGolsPro() + placarB);
            equipe2.setGolsContra(equipe2.getGolsContra() + placarA);
            if (equipeController.alterar(equipe2)) {
                mula1[i] = equipe2;
                // obj salvo com sucesso no DB
                sucesso = true;
            } else {
                // falha ao salvar o obj  no DB
                sucesso = false;
                return sucesso;
            }

            equipe1.setId(E1ID);
            equipe1.setGrupoID(G1ID);
            equipe1.setJogos(equipe1.getJogos() + 1);
            equipe1.setDerrotas(equipe1.getDerrotas() + 1);
            equipe1.setGolsPro(equipe1.getGolsPro() + placarA);
            equipe1.setGolsContra(equipe1.getGolsContra() + placarB);
            if (equipeController.alterar(equipe1)) {
                mula2[j] = equipe1;
                sucesso = true;
            } else {
                sucesso = false;
                return sucesso;
            }

        } else {

            empate = true;
            trocaTela = false;
            sucesso = false;
            return sucesso;

            //Versão Grátis não dispõe da função penaltis, logo não permite empate.
            /**
             equipe1.setId(E1ID);
             equipe1.setGrupoID(G1ID);
             equipe1.setJogos(equipe1.getJogos() + 1);
             equipe1.setPontos(equipe1.getPontos() + 1);
             equipe1.setEmpates(equipe1.getEmpates() + 1);
             equipe1.setGolsPro(equipe1.getGolsPro() + placarA);
             equipe1.setGolsContra(equipe1.getGolsContra() + placarB);
             if (equipeController.alterar(equipe1)) {
             // obj salvo com sucesso no DB
             sucesso = true;
             } else {
             // falha ao salvar o obj  no DB
             sucesso = false;
             return sucesso;
             }

             equipe2.setId(E2ID);
             equipe2.setGrupoID(G2ID);
             equipe2.setJogos(equipe2.getJogos() + 1);
             equipe2.setPontos(equipe2.getPontos() + 1);
             equipe2.setEmpates(equipe2.getEmpates() + 1);
             equipe2.setGolsPro(equipe2.getGolsPro() + placarB);
             equipe2.setGolsContra(equipe2.getGolsContra() + placarA);
             if (equipeController.alterar(equipe2)) {
             sucesso = true;
             } else {
             sucesso = false;
             return sucesso;
             }*/
        }

        return sucesso;

    }

    public boolean salvarJogoSemi(Equipe equipe1, Equipe equipe2, EditText placarEquipe1, EditText placarEquipe2, int E1ID, int G1ID, int E2ID, int G2ID) {

        placarA = Integer.parseInt(placarEquipe1.getText().toString());
        placarB = Integer.parseInt(placarEquipe2.getText().toString());

        if (placarA > placarB) {

            equipe1.setId(E1ID);
            equipe1.setGrupoID(G1ID);
            equipe1.setJogos(equipe1.getJogos() + 1);
            equipe1.setPontos(equipe1.getPontos() + 3);
            equipe1.setVitorias(equipe1.getVitorias() + 1);
            equipe1.setGolsPro(equipe1.getGolsPro() + placarA);
            equipe1.setGolsContra(equipe1.getGolsContra() + placarB);
            if (equipeController.alterar(equipe1)) {
                mula2[i] = equipe1;
                // obj salvo com sucesso no DB
                sucesso = true;
            } else {
                // falha ao salvar o obj  no DB
                sucesso = false;
                return sucesso;
            }

            equipe2.setId(E2ID);
            equipe2.setGrupoID(G2ID);
            equipe2.setJogos(equipe2.getJogos() + 1);
            equipe2.setDerrotas(equipe2.getDerrotas() + 1);
            equipe2.setGolsPro(equipe2.getGolsPro() + placarB);
            equipe2.setGolsContra(equipe2.getGolsContra() + placarA);
            if (equipeController.alterar(equipe2)) {
                mula2[j] = equipe2;
                sucesso = true;
            } else {
                sucesso = false;
                return sucesso;
            }

        } else if (placarA < placarB) {

            equipe2.setId(E2ID);
            equipe2.setGrupoID(G2ID);
            equipe2.setJogos(equipe2.getJogos() + 1);
            equipe2.setPontos(equipe2.getPontos() + 3);
            equipe2.setVitorias(equipe2.getVitorias() + 1);
            equipe2.setGolsPro(equipe2.getGolsPro() + placarB);
            equipe2.setGolsContra(equipe2.getGolsContra() + placarA);
            if (equipeController.alterar(equipe2)) {
                mula2[i] = equipe2;
                // obj salvo com sucesso no DB
                sucesso = true;
            } else {
                // falha ao salvar o obj  no DB
                sucesso = false;
                return sucesso;
            }

            equipe1.setId(E1ID);
            equipe1.setGrupoID(G1ID);
            equipe1.setJogos(equipe1.getJogos() + 1);
            equipe1.setDerrotas(equipe1.getDerrotas() + 1);
            equipe1.setGolsPro(equipe1.getGolsPro() + placarA);
            equipe1.setGolsContra(equipe1.getGolsContra() + placarB);
            if (equipeController.alterar(equipe1)) {
                mula2[j] = equipe1;
                sucesso = true;
            } else {
                sucesso = false;
                return sucesso;
            }

        } else {

            empate = true;
            trocaTela = false;
            sucesso = false;
            return sucesso;

            //Versão Grátis não dispõe da função penaltis, logo não permite empate.
            /**
             equipe1.setId(E1ID);
             equipe1.setGrupoID(G1ID);
             equipe1.setJogos(equipe1.getJogos() + 1);
             equipe1.setPontos(equipe1.getPontos() + 1);
             equipe1.setEmpates(equipe1.getEmpates() + 1);
             equipe1.setGolsPro(equipe1.getGolsPro() + placarA);
             equipe1.setGolsContra(equipe1.getGolsContra() + placarB);
             if (equipeController.alterar(equipe1)) {
             // obj salvo com sucesso no DB
             sucesso = true;
             } else {
             // falha ao salvar o obj  no DB
             sucesso = false;
             return sucesso;
             }

             equipe2.setId(E2ID);
             equipe2.setGrupoID(G2ID);
             equipe2.setJogos(equipe2.getJogos() + 1);
             equipe2.setPontos(equipe2.getPontos() + 1);
             equipe2.setEmpates(equipe2.getEmpates() + 1);
             equipe2.setGolsPro(equipe2.getGolsPro() + placarB);
             equipe2.setGolsContra(equipe2.getGolsContra() + placarA);
             if (equipeController.alterar(equipe2)) {
             sucesso = true;
             } else {
             sucesso = false;
             return sucesso;
             }*/
        }

        return sucesso;

    }

    public boolean salvarJogoTerceiro(Equipe equipe1, Equipe equipe2, EditText placarEquipe1, EditText placarEquipe2, int E1ID, int G1ID, int E2ID, int G2ID) {

        placarA = Integer.parseInt(placarEquipe1.getText().toString());
        placarB = Integer.parseInt(placarEquipe2.getText().toString());

        if (placarA > placarB) {

            equipe1.setId(E1ID);
            equipe1.setGrupoID(G1ID);
            equipe1.setJogos(equipe1.getJogos() + 1);
            equipe1.setPontos(equipe1.getPontos() + 3);
            equipe1.setVitorias(equipe1.getVitorias() + 1);
            equipe1.setGolsPro(equipe1.getGolsPro() + placarA);
            equipe1.setGolsContra(equipe1.getGolsContra() + placarB);
            if (equipeController.alterar(equipe1)) {
                mula2[2] = equipe1;
                // obj salvo com sucesso no DB
                sucesso = true;
            } else {
                // falha ao salvar o obj  no DB
                sucesso = false;
                return sucesso;
            }

            equipe2.setId(E2ID);
            equipe2.setGrupoID(G2ID);
            equipe2.setJogos(equipe2.getJogos() + 1);
            equipe2.setDerrotas(equipe2.getDerrotas() + 1);
            equipe2.setGolsPro(equipe2.getGolsPro() + placarB);
            equipe2.setGolsContra(equipe2.getGolsContra() + placarA);
            if (equipeController.alterar(equipe2)) {
                mula2[3] = equipe2;
                sucesso = true;
            } else {
                sucesso = false;
                return sucesso;
            }

        } else if (placarA < placarB) {

            equipe2.setId(E2ID);
            equipe2.setGrupoID(G2ID);
            equipe2.setJogos(equipe2.getJogos() + 1);
            equipe2.setPontos(equipe2.getPontos() + 3);
            equipe2.setVitorias(equipe2.getVitorias() + 1);
            equipe2.setGolsPro(equipe2.getGolsPro() + placarB);
            equipe2.setGolsContra(equipe2.getGolsContra() + placarA);
            if (equipeController.alterar(equipe2)) {
                mula2[2] = equipe2;
                // obj salvo com sucesso no DB
                sucesso = true;
            } else {
                // falha ao salvar o obj  no DB
                sucesso = false;
                return sucesso;
            }

            equipe1.setId(E1ID);
            equipe1.setGrupoID(G1ID);
            equipe1.setJogos(equipe1.getJogos() + 1);
            equipe1.setDerrotas(equipe1.getDerrotas() + 1);
            equipe1.setGolsPro(equipe1.getGolsPro() + placarA);
            equipe1.setGolsContra(equipe1.getGolsContra() + placarB);
            if (equipeController.alterar(equipe1)) {
                mula2[3] = equipe1;
                sucesso = true;
            } else {
                sucesso = false;
                return sucesso;
            }

        } else {

            empate = true;
            trocaTela = false;
            sucesso = false;
            return sucesso;

            //Versão Grátis não dispõe da função penaltis, logo não permite empate.
            /**
             equipe1.setId(E1ID);
             equipe1.setGrupoID(G1ID);
             equipe1.setJogos(equipe1.getJogos() + 1);
             equipe1.setPontos(equipe1.getPontos() + 1);
             equipe1.setEmpates(equipe1.getEmpates() + 1);
             equipe1.setGolsPro(equipe1.getGolsPro() + placarA);
             equipe1.setGolsContra(equipe1.getGolsContra() + placarB);
             if (equipeController.alterar(equipe1)) {
             // obj salvo com sucesso no DB
             sucesso = true;
             } else {
             // falha ao salvar o obj  no DB
             sucesso = false;
             return sucesso;
             }

             equipe2.setId(E2ID);
             equipe2.setGrupoID(G2ID);
             equipe2.setJogos(equipe2.getJogos() + 1);
             equipe2.setPontos(equipe2.getPontos() + 1);
             equipe2.setEmpates(equipe2.getEmpates() + 1);
             equipe2.setGolsPro(equipe2.getGolsPro() + placarB);
             equipe2.setGolsContra(equipe2.getGolsContra() + placarA);
             if (equipeController.alterar(equipe2)) {
             sucesso = true;
             } else {
             sucesso = false;
             return sucesso;
             }*/

        }

        return sucesso;

    }

    public boolean salvarJogoFinal(Equipe equipe1, Equipe equipe2, EditText placarEquipe1, EditText placarEquipe2, int E1ID, int G1ID, int E2ID, int G2ID) {

        placarA = Integer.parseInt(placarEquipe1.getText().toString());
        placarB = Integer.parseInt(placarEquipe2.getText().toString());

        if (placarA > placarB) {

            equipe1.setId(E1ID);
            equipe1.setGrupoID(G1ID);
            equipe1.setJogos(equipe1.getJogos() + 1);
            equipe1.setPontos(equipe1.getPontos() + 3);
            equipe1.setVitorias(equipe1.getVitorias() + 1);
            equipe1.setGolsPro(equipe1.getGolsPro() + placarA);
            equipe1.setGolsContra(equipe1.getGolsContra() + placarB);
            if (equipeController.alterar(equipe1)) {
                mula2[0] = equipe1;
                // obj salvo com sucesso no DB
                sucesso = true;
            } else {
                // falha ao salvar o obj  no DB
                sucesso = false;
                return sucesso;
            }

            equipe2.setId(E2ID);
            equipe2.setGrupoID(G2ID);
            equipe2.setJogos(equipe2.getJogos() + 1);
            equipe2.setDerrotas(equipe2.getDerrotas() + 1);
            equipe2.setGolsPro(equipe2.getGolsPro() + placarB);
            equipe2.setGolsContra(equipe2.getGolsContra() + placarA);
            if (equipeController.alterar(equipe2)) {
                mula2[1] = equipe2;
                sucesso = true;
            } else {
                sucesso = false;
                return sucesso;
            }

        } else if (placarA < placarB) {

            equipe2.setId(E2ID);
            equipe2.setGrupoID(G2ID);
            equipe2.setJogos(equipe2.getJogos() + 1);
            equipe2.setPontos(equipe2.getPontos() + 3);
            equipe2.setVitorias(equipe2.getVitorias() + 1);
            equipe2.setGolsPro(equipe2.getGolsPro() + placarB);
            equipe2.setGolsContra(equipe2.getGolsContra() + placarA);
            if (equipeController.alterar(equipe2)) {
                mula2[0] = equipe2;
                // obj salvo com sucesso no DB
                sucesso = true;
            } else {
                // falha ao salvar o obj  no DB
                sucesso = false;
                return sucesso;
            }

            equipe1.setId(E1ID);
            equipe1.setGrupoID(G1ID);
            equipe1.setJogos(equipe1.getJogos() + 1);
            equipe1.setDerrotas(equipe1.getDerrotas() + 1);
            equipe1.setGolsPro(equipe1.getGolsPro() + placarA);
            equipe1.setGolsContra(equipe1.getGolsContra() + placarB);
            if (equipeController.alterar(equipe1)) {
                mula2[1] = equipe1;
                sucesso = true;
            } else {
                sucesso = false;
                return sucesso;
            }

        } else {

            empate = true;
            trocaTela = false;
            sucesso = false;
            return sucesso;

            //Versão Grátis não dispõe da função penaltis, logo não permite empate.
            /**
             equipe1.setId(E1ID);
             equipe1.setGrupoID(G1ID);
             equipe1.setJogos(equipe1.getJogos() + 1);
             equipe1.setPontos(equipe1.getPontos() + 1);
             equipe1.setEmpates(equipe1.getEmpates() + 1);
             equipe1.setGolsPro(equipe1.getGolsPro() + placarA);
             equipe1.setGolsContra(equipe1.getGolsContra() + placarB);
             if (equipeController.alterar(equipe1)) {
             // obj salvo com sucesso no DB
             sucesso = true;
             } else {
             // falha ao salvar o obj  no DB
             sucesso = false;
             return sucesso;
             }

             equipe2.setId(E2ID);
             equipe2.setGrupoID(G2ID);
             equipe2.setJogos(equipe2.getJogos() + 1);
             equipe2.setPontos(equipe2.getPontos() + 1);
             equipe2.setEmpates(equipe2.getEmpates() + 1);
             equipe2.setGolsPro(equipe2.getGolsPro() + placarB);
             equipe2.setGolsContra(equipe2.getGolsContra() + placarA);
             if (equipeController.alterar(equipe2)) {
             sucesso = true;
             } else {
             sucesso = false;
             return sucesso;
             }*/

        }

        return sucesso;

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

    public void finalizarQuartas(View view) {

        restaurarSharedPreferencesInitQuartas();

        equipe1.setId(primeiroAID);
        equipe2.setId(segundoAID);
        equipe3.setId(primeiroBID);
        equipe4.setId(segundoBID);
        equipe5.setId(primeiroCID);
        equipe6.setId(segundoCID);
        equipe7.setId(primeiroDID);
        equipe8.setId(segundoDID);
        equipe1.setGrupoID(grupo1ID);
        equipe2.setGrupoID(grupo1ID);
        equipe3.setGrupoID(grupo2ID);
        equipe4.setGrupoID(grupo2ID);
        equipe5.setGrupoID(grupo3ID);
        equipe6.setGrupoID(grupo3ID);
        equipe7.setGrupoID(grupo4ID);
        equipe8.setGrupoID(grupo4ID);

        equipe1.setJogos(jEquipe1Quartas);
        equipe2.setJogos(jEquipe2Quartas);
        equipe3.setJogos(jEquipe3Quartas);
        equipe4.setJogos(jEquipe4Quartas);
        equipe5.setJogos(jEquipe5Quartas);
        equipe6.setJogos(jEquipe6Quartas);
        equipe7.setJogos(jEquipe7Quartas);
        equipe8.setJogos(jEquipe8Quartas);

        equipe1.setPontos(pEquipe1Quartas);
        equipe2.setPontos(pEquipe2Quartas);
        equipe3.setPontos(pEquipe3Quartas);
        equipe4.setPontos(pEquipe4Quartas);
        equipe5.setPontos(pEquipe5Quartas);
        equipe6.setPontos(pEquipe6Quartas);
        equipe7.setPontos(pEquipe7Quartas);
        equipe8.setPontos(pEquipe8Quartas);

        equipe1.setVitorias(vEquipe1Quartas);
        equipe2.setVitorias(vEquipe2Quartas);
        equipe3.setVitorias(vEquipe3Quartas);
        equipe4.setVitorias(vEquipe4Quartas);
        equipe5.setVitorias(vEquipe5Quartas);
        equipe6.setVitorias(vEquipe6Quartas);
        equipe7.setVitorias(vEquipe7Quartas);
        equipe8.setVitorias(vEquipe8Quartas);

        equipe1.setEmpates(eEquipe1Quartas);
        equipe2.setEmpates(eEquipe2Quartas);
        equipe3.setEmpates(eEquipe3Quartas);
        equipe4.setEmpates(eEquipe4Quartas);
        equipe5.setEmpates(eEquipe5Quartas);
        equipe6.setEmpates(eEquipe6Quartas);
        equipe7.setEmpates(eEquipe7Quartas);
        equipe8.setEmpates(eEquipe8Quartas);

        equipe1.setDerrotas(dEquipe1Quartas);
        equipe2.setDerrotas(dEquipe2Quartas);
        equipe3.setDerrotas(dEquipe3Quartas);
        equipe4.setDerrotas(dEquipe4Quartas);
        equipe5.setDerrotas(dEquipe5Quartas);
        equipe6.setDerrotas(dEquipe6Quartas);
        equipe7.setDerrotas(dEquipe7Quartas);
        equipe8.setDerrotas(dEquipe8Quartas);

        equipe1.setGolsPro(gpEquipe1Quartas);
        equipe2.setGolsPro(gpEquipe2Quartas);
        equipe3.setGolsPro(gpEquipe3Quartas);
        equipe4.setGolsPro(gpEquipe4Quartas);
        equipe5.setGolsPro(gpEquipe5Quartas);
        equipe6.setGolsPro(gpEquipe6Quartas);
        equipe7.setGolsPro(gpEquipe7Quartas);
        equipe8.setGolsPro(gpEquipe8Quartas);

        equipe1.setGolsContra(gcEquipe1Quartas);
        equipe2.setGolsContra(gcEquipe2Quartas);
        equipe3.setGolsContra(gcEquipe3Quartas);
        equipe4.setGolsContra(gcEquipe4Quartas);
        equipe5.setGolsContra(gcEquipe5Quartas);
        equipe6.setGolsContra(gcEquipe6Quartas);
        equipe7.setGolsContra(gcEquipe7Quartas);
        equipe8.setGolsContra(gcEquipe8Quartas);

        equipeController.alterar(equipe1);
        equipeController.alterar(equipe2);
        equipeController.alterar(equipe3);
        equipeController.alterar(equipe4);
        equipeController.alterar(equipe5);
        equipeController.alterar(equipe6);
        equipeController.alterar(equipe7);
        equipeController.alterar(equipe8);

        if (validarFormularioJogo(editPlacarEquipe1, editPlacarEquipe2) && validarFormularioJogo(editPlacarEquipe3, editPlacarEquipe4) && validarFormularioJogo(editPlacarEquipe5, editPlacarEquipe6) && validarFormularioJogo(editPlacarEquipe7, editPlacarEquipe8)) {

            i = 0;
            if (salvarJogoQuartas(equipe1, equipe8, editPlacarEquipe1, editPlacarEquipe2, primeiroAID, grupo1ID, segundoDID, grupo4ID)) {
                i++;
                if (salvarJogoQuartas(equipe3, equipe6, editPlacarEquipe3, editPlacarEquipe4, primeiroBID, grupo2ID, segundoCID, grupo3ID)) {
                    i++;
                    if (salvarJogoQuartas(equipe5, equipe4, editPlacarEquipe5, editPlacarEquipe6, primeiroCID, grupo3ID, segundoBID, grupo2ID)) {
                        i++;
                        if (salvarJogoQuartas(equipe7, equipe2, editPlacarEquipe7, editPlacarEquipe8, primeiroDID, grupo4ID, segundoAID, grupo1ID)) {

                            //ordenaGrupo(equipesA);
                            //ordenaGrupo(equipesB);
                            //ordenaGrupo(equipesC);
                            //ordenaGrupo(equipesD);

                            salvarSharedPreferencesQuartas();

                            restaurarSharedPreferencesSemi();

                            initFormularioSemi();

                            btnFinalizarSemi.setEnabled(true);
                            //btnFinalizarQuartas.setEnabled(false);
                            editPlacarEquipe1Semi.setEnabled(true);
                            editPlacarEquipe2Semi.setEnabled(true);
                            editPlacarEquipe3Semi.setEnabled(true);
                            editPlacarEquipe4Semi.setEnabled(true);

                            popularFormularioSemi();

                            conseguiu = true;

                        } else alert2();
                    } else alert2();
                } else alert2();
            } else alert2();
        } else alert();
    }

    public void finalizarSemi(View view) {

        restaurarSharedPreferencesInitSemi();

        equipe1S.setId(vencedor1QuartasID);
        equipe2S.setId(vencedor2QuartasID);
        equipe3S.setId(vencedor3QuartasID);
        equipe4S.setId(vencedor4QuartasID);

        equipe1S.setGrupoID(vencedor1QuartasGrupoID);
        equipe2S.setGrupoID(vencedor2QuartasGrupoID);
        equipe3S.setGrupoID(vencedor3QuartasGrupoID);
        equipe4S.setGrupoID(vencedor4QuartasGrupoID);

        equipe1S.setJogos(jEquipe1Semi);
        equipe2S.setJogos(jEquipe2Semi);
        equipe3S.setJogos(jEquipe3Semi);
        equipe4S.setJogos(jEquipe4Semi);

        equipe1S.setPontos(pEquipe1Semi);
        equipe2S.setPontos(pEquipe2Semi);
        equipe3S.setPontos(pEquipe3Semi);
        equipe4S.setPontos(pEquipe4Semi);

        equipe1S.setVitorias(vEquipe1Semi);
        equipe2S.setVitorias(vEquipe2Semi);
        equipe3S.setVitorias(vEquipe3Semi);
        equipe4S.setVitorias(vEquipe4Semi);

        equipe1S.setEmpates(eEquipe1Semi);
        equipe2S.setEmpates(eEquipe2Semi);
        equipe3S.setEmpates(eEquipe3Semi);
        equipe4S.setEmpates(eEquipe4Semi);

        equipe1S.setDerrotas(dEquipe1Semi);
        equipe2S.setDerrotas(dEquipe2Semi);
        equipe3S.setDerrotas(dEquipe3Semi);
        equipe4S.setDerrotas(dEquipe4Semi);

        equipe1S.setGolsPro(gpEquipe1Semi);
        equipe2S.setGolsPro(gpEquipe2Semi);
        equipe3S.setGolsPro(gpEquipe3Semi);
        equipe4S.setGolsPro(gpEquipe4Semi);

        equipe1S.setGolsContra(gcEquipe1Semi);
        equipe2S.setGolsContra(gcEquipe2Semi);
        equipe3S.setGolsContra(gcEquipe3Semi);
        equipe4S.setGolsContra(gcEquipe4Semi);

        equipeController.alterar(equipe1S);
        equipeController.alterar(equipe2S);
        equipeController.alterar(equipe3S);
        equipeController.alterar(equipe4S);


        if (validarFormularioJogo(editPlacarEquipe1Semi, editPlacarEquipe2Semi) && validarFormularioJogo(editPlacarEquipe3Semi, editPlacarEquipe4Semi)) {

            i = 0;
            j = 2;
            if (salvarJogoSemi(equipe1S, equipe2S, editPlacarEquipe1Semi, editPlacarEquipe2Semi, vencedor1QuartasID, vencedor1QuartasGrupoID, vencedor2QuartasID, vencedor2QuartasGrupoID)) {
                i++;
                j++;
                if (salvarJogoSemi(equipe3S, equipe4S, editPlacarEquipe3Semi, editPlacarEquipe4Semi, vencedor3QuartasID, vencedor3QuartasGrupoID, vencedor4QuartasID, vencedor4QuartasGrupoID)) {
                    i++;
                    j++;

                    //ordenaGrupo(equipesA);
                    //ordenaGrupo(equipesB);
                    //ordenaGrupo(equipesC);
                    //ordenaGrupo(equipesD);

                    salvarSharedPreferencesSemi();

                    restaurarSharedPreferencesTerceiro();

                    initFormularioTerceiro();

                    editPlacarEquipe1.setEnabled(false);
                    editPlacarEquipe2.setEnabled(false);
                    editPlacarEquipe3.setEnabled(false);
                    editPlacarEquipe4.setEnabled(false);
                    editPlacarEquipe5.setEnabled(false);
                    editPlacarEquipe6.setEnabled(false);
                    editPlacarEquipe7.setEnabled(false);
                    editPlacarEquipe8.setEnabled(false);
                    btnFinalizarQuartas.setEnabled(false);

                    btnFinalizarTerceiro.setEnabled(true);
                    //btnFinalizarSemi.setEnabled(false);
                    editPlacarEquipe1Terceiro.setEnabled(true);
                    editPlacarEquipe2Terceiro.setEnabled(true);

                    popularFormularioTerceiro();

                    conseguiu = true;

                } else alert2();
            } else alert2();
        } else alert();
    }

    public void finalizarTerceiro(View view) {

        restaurarSharedPreferencesInitTerceiro();

        equipe1T.setId(perdedor1SemiID);
        equipe2T.setId(perdedor2SemiID);

        equipe1T.setGrupoID(perdedor1SemiGrupoID);
        equipe2T.setGrupoID(perdedor2SemiGrupoID);

        equipe1T.setJogos(jEquipe1Ter);
        equipe2T.setJogos(jEquipe2Ter);

        equipe1T.setPontos(pEquipe1Ter);
        equipe2T.setPontos(pEquipe2Ter);

        equipe1T.setVitorias(vEquipe1Ter);
        equipe2T.setVitorias(vEquipe2Ter);

        equipe1T.setEmpates(eEquipe1Ter);
        equipe2T.setEmpates(eEquipe2Ter);

        equipe1T.setDerrotas(dEquipe1Ter);
        equipe2T.setDerrotas(dEquipe2Ter);

        equipe1T.setGolsPro(gpEquipe1Ter);
        equipe2T.setGolsPro(gpEquipe2Ter);

        equipe1T.setGolsContra(gcEquipe1Ter);
        equipe2T.setGolsContra(gcEquipe2Ter);

        equipeController.alterar(equipe1T);
        equipeController.alterar(equipe2T);

        if (validarFormularioJogo(editPlacarEquipe1Terceiro, editPlacarEquipe2Terceiro)) {
            if (salvarJogoTerceiro(equipe1T, equipe2T, editPlacarEquipe1Terceiro, editPlacarEquipe2Terceiro, perdedor1SemiID, perdedor1SemiGrupoID, perdedor2SemiID, perdedor2SemiGrupoID)) {

                //ordenaGrupo(equipesA);
                //ordenaGrupo(equipesB);
                //ordenaGrupo(equipesC);
                //ordenaGrupo(equipesD);

                salvarSharedPreferencesTerceiro();

                restaurarSharedPreferencesFinal();

                initFormularioFinal();

                editPlacarEquipe1Semi.setEnabled(false);
                editPlacarEquipe2Semi.setEnabled(false);
                editPlacarEquipe3Semi.setEnabled(false);
                editPlacarEquipe4Semi.setEnabled(false);
                btnFinalizarSemi.setEnabled(false);

                btnFinalizar.setEnabled(true);
                //btnFinalizarTerceiro.setEnabled(false);
                editPlacarEquipe1Final.setEnabled(true);
                editPlacarEquipe2Final.setEnabled(true);

                popularFormularioFinal();

                conseguiu = true;

            } else alert2();
        } else alert();

    }

    public void finalizarTorneio(View view) {

        if (qtdEquipes == 4) {

            restaurarSharedPreferencesInitFinal();

            equipe1.setId(primeiroAID);
            equipe2.setId(segundoAID);

            equipe1.setGrupoID(grupo1ID);
            equipe2.setGrupoID(grupo1ID);

            equipe1.setJogos(jEquipe1Final);
            equipe2.setJogos(jEquipe2Final);

            equipe1.setPontos(pEquipe1Final);
            equipe2.setPontos(pEquipe2Final);

            equipe1.setVitorias(vEquipe1Final);
            equipe2.setVitorias(vEquipe2Final);

            equipe1.setEmpates(eEquipe1Final);
            equipe2.setEmpates(eEquipe2Final);

            equipe1.setDerrotas(dEquipe1Final);
            equipe2.setDerrotas(dEquipe2Final);

            equipe1.setGolsPro(gpEquipe1Final);
            equipe2.setGolsPro(gpEquipe2Final);

            equipe1.setGolsContra(gcEquipe1Final);
            equipe2.setGolsContra(gcEquipe2Final);

            equipeController.alterar(equipe1);
            equipeController.alterar(equipe2);

            if (validarFormularioJogo(editPlacarEquipe1Final, editPlacarEquipe2Final)) {

                if (salvarJogoFinal(equipe1, equipe2, editPlacarEquipe1Final, editPlacarEquipe2Final, primeiroAID, grupo1ID, segundoAID, grupo1ID)) {

                    //ordenaGrupo(equipes);
                }


                if (trocaTela) {

                    salvarSharedPreferencesFinal();

                    conseguiu = true;

                    Intent intent = new Intent(MataMata.this, Final.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                    return;

                } else {

                    if (empate) {

                        alert2();

                        //Reset dessas variáveis
                        trocaTela = true;
                        sucesso = true;
                        empate = false;
                    } else
                        Toast.makeText(this, "Falha ao salvar os dados...", Toast.LENGTH_SHORT).show();
                }
            } else alert();

        } else if (qtdEquipes == 12 || qtdEquipes == 16) {

            restaurarSharedPreferencesInitFinal();

            equipe1F.setId(vencedor1SemiID);
            equipe2F.setId(vencedor2SemiID);

            equipe1F.setGrupoID(vencedor1SemiGrupoID);
            equipe2F.setGrupoID(vencedor2SemiGrupoID);

            equipe1F.setJogos(jEquipe1Final);
            equipe2F.setJogos(jEquipe2Final);

            equipe1F.setPontos(pEquipe1Final);
            equipe2F.setPontos(pEquipe2Final);

            equipe1F.setVitorias(vEquipe1Final);
            equipe2F.setVitorias(vEquipe2Final);

            equipe1F.setEmpates(eEquipe1Final);
            equipe2F.setEmpates(eEquipe2Final);

            equipe1F.setDerrotas(dEquipe1Final);
            equipe2F.setDerrotas(dEquipe2Final);

            equipe1F.setGolsPro(gpEquipe1Final);
            equipe2F.setGolsPro(gpEquipe2Final);

            equipe1F.setGolsContra(gcEquipe1Final);
            equipe2F.setGolsContra(gcEquipe2Final);

            equipeController.alterar(equipe1F);
            equipeController.alterar(equipe2F);

            if (validarFormularioJogo(editPlacarEquipe1Final, editPlacarEquipe2Final)) {
                if (salvarJogoFinal(equipe1F, equipe2F, editPlacarEquipe1Final, editPlacarEquipe2Final, vencedor1SemiID, vencedor1SemiGrupoID, vencedor2SemiID, vencedor2SemiGrupoID)) {

                    //ordenaGrupo(equipesA);
                    //ordenaGrupo(equipesB);
                    //ordenaGrupo(equipesC);
                    //ordenaGrupo(equipesD);
                }

                if (trocaTela) {

                    salvarSharedPreferencesFinal();

                    editPlacarEquipe1Terceiro.setEnabled(false);
                    editPlacarEquipe2Terceiro.setEnabled(false);
                    btnFinalizarTerceiro.setEnabled(false);

                    conseguiu = true;

                    Intent intent = new Intent(MataMata.this, Final.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                    return;

                } else alert2();

            } else alert();
        }
    }

    public void finalizarTorneioFake() {

        if (qtdEquipes == 4) {

            restaurarSharedPreferencesInitFinal();

            equipe1.setId(primeiroAID);
            equipe2.setId(segundoAID);

            equipe1.setGrupoID(grupo1ID);
            equipe2.setGrupoID(grupo1ID);

            equipe1.setJogos(jEquipe1Final);
            equipe2.setJogos(jEquipe2Final);

            equipe1.setPontos(pEquipe1Final);
            equipe2.setPontos(pEquipe2Final);

            equipe1.setVitorias(vEquipe1Final);
            equipe2.setVitorias(vEquipe2Final);

            equipe1.setEmpates(eEquipe1Final);
            equipe2.setEmpates(eEquipe2Final);

            equipe1.setDerrotas(dEquipe1Final);
            equipe2.setDerrotas(dEquipe2Final);

            equipe1.setGolsPro(gpEquipe1Final);
            equipe2.setGolsPro(gpEquipe2Final);

            equipe1.setGolsContra(gcEquipe1Final);
            equipe2.setGolsContra(gcEquipe2Final);

            equipeController.alterar(equipe1);
            equipeController.alterar(equipe2);

            if (validarFormularioJogo(editPlacarEquipe1Final, editPlacarEquipe2Final)) {

                if (salvarJogoFinal(equipe1, equipe2, editPlacarEquipe1Final, editPlacarEquipe2Final, primeiroAID, grupo1ID, segundoAID, grupo1ID)) {

                    //ordenaGrupo(equipes);
                }

            } else alert();

        } else if (qtdEquipes == 12 || qtdEquipes == 16) {

            restaurarSharedPreferencesInitFinal();

            equipe1F.setId(vencedor1SemiID);
            equipe2F.setId(vencedor2SemiID);

            equipe1F.setGrupoID(vencedor1SemiGrupoID);
            equipe2F.setGrupoID(vencedor2SemiGrupoID);

            equipe1F.setJogos(jEquipe1Final);
            equipe2F.setJogos(jEquipe2Final);

            equipe1F.setPontos(pEquipe1Final);
            equipe2F.setPontos(pEquipe2Final);

            equipe1F.setVitorias(vEquipe1Final);
            equipe2F.setVitorias(vEquipe2Final);

            equipe1F.setEmpates(eEquipe1Final);
            equipe2F.setEmpates(eEquipe2Final);

            equipe1F.setDerrotas(dEquipe1Final);
            equipe2F.setDerrotas(dEquipe2Final);

            equipe1F.setGolsPro(gpEquipe1Final);
            equipe2F.setGolsPro(gpEquipe2Final);

            equipe1F.setGolsContra(gcEquipe1Final);
            equipe2F.setGolsContra(gcEquipe2Final);

            equipeController.alterar(equipe1F);
            equipeController.alterar(equipe2F);

            if (validarFormularioJogo(editPlacarEquipe1Final, editPlacarEquipe2Final)) {
                if (salvarJogoFinal(equipe1F, equipe2F, editPlacarEquipe1Final, editPlacarEquipe2Final, vencedor1SemiID, vencedor1SemiGrupoID, vencedor2SemiID, vencedor2SemiGrupoID)) {

                    //ordenaGrupo(equipesA);
                    //ordenaGrupo(equipesB);
                    //ordenaGrupo(equipesC);
                    //ordenaGrupo(equipesD);
                }

            } else alert();
        }
    }

    public void alert() {
        builder = new AlertDialog.Builder(this);
        builder.setTitle("ALERTA");
        builder.setMessage("Você deve preencher o placar de todos os jogos para continuar!");
        builder.setCancelable(true);
        builder.setIcon(R.mipmap.ic_launcher_round);

        builder.setPositiveButton("OK", new Dialog.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.cancel();
            }
        });

        alert = builder.create();
        alert.show();
    }

    public void alert2() {

        if (empate) {

            builder = new AlertDialog.Builder(this);
            builder.setTitle("ATENÇÃO:");
            builder.setMessage("Nessa fase da competição todo jogo deve ter um vencedor!");
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

            //Reset dessas variáveis
            trocaTela = true;
            sucesso = true;
            empate = false;

        } else
            Toast.makeText(this, "Falha ao salvar os dados...", Toast.LENGTH_SHORT).show();
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
                } else if (equipes[i].getPontos() == equipes[i + 1].getPontos()) {
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

        Intent intent = new Intent(MataMata.this, Dashboard.class);
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

    }

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);

        grupo1ID = preferences.getInt("grupo1ID", -1);
        nomeGrupo1 = preferences.getString("nomeGrupo1", "");
        primeiroAID = preferences.getInt("primeiroAID", -1);
        nomePrimeiroA = preferences.getString("nomePrimeiroA", "");
        segundoAID = preferences.getInt("segundoAID", -1);
        nomeSegundoA = preferences.getString("nomeSegundoA", "");

        placarEquipe1Final = preferences.getString("placarEquipe1Final", "");
        placarEquipe2Final = preferences.getString("placarEquipe2Final", "");
        finalizouFinal = preferences.getBoolean("finalizouFinal", false);

    }

    private void restaurarSharedPreferencesQuartas() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);

        grupo1ID = preferences.getInt("grupo1ID", -1);
        nomeGrupo1 = preferences.getString("nomeGrupo1", "");
        primeiroAID = preferences.getInt("primeiroAID", -1);
        nomePrimeiroA = preferences.getString("nomePrimeiroA", "");
        segundoAID = preferences.getInt("segundoAID", -1);
        nomeSegundoA = preferences.getString("nomeSegundoA", "");
        terceiroAID = preferences.getInt("terceiroAID", -1);
        nomeTerceiroA = preferences.getString("nomeTerceiroA", "");

        grupo2ID = preferences.getInt("grupo2ID", -1);
        nomeGrupo2 = preferences.getString("nomeGrupo2", "");
        primeiroBID = preferences.getInt("primeiroBID", -1);
        nomePrimeiroB = preferences.getString("nomePrimeiroB", "");
        segundoBID = preferences.getInt("segundoBID", -1);
        nomeSegundoB = preferences.getString("nomeSegundoB", "");
        terceiroBID = preferences.getInt("terceiroBID", -1);
        nomeTerceiroB = preferences.getString("nomeTerceiroB", "");

        grupo3ID = preferences.getInt("grupo3ID", -1);
        nomeGrupo3 = preferences.getString("nomeGrupo3", "");
        primeiroCID = preferences.getInt("primeiroCID", -1);
        nomePrimeiroC = preferences.getString("nomePrimeiroC", "");
        segundoCID = preferences.getInt("segundoCID", -1);
        nomeSegundoC = preferences.getString("nomeSegundoC", "");
        terceiroCID = preferences.getInt("terceiroCID", -1);
        nomeTerceiroC = preferences.getString("nomeTerceiroC", "");

        grupo4ID = preferences.getInt("grupo4ID", -1);
        nomeGrupo4 = preferences.getString("nomeGrupo4", "");
        primeiroDID = preferences.getInt("primeiroDID", -1);
        nomePrimeiroD = preferences.getString("nomePrimeiroD", "");
        segundoDID = preferences.getInt("segundoDID", -1);
        nomeSegundoD = preferences.getString("nomeSegundoD", "");
        terceiroDID = preferences.getInt("terceiroDID", -1);
        nomeTerceiroD = preferences.getString("nomeTerceiroD", "");

        placarEquipe1Quartas = preferences.getString("placarEquipe1Quartas", "");
        placarEquipe2Quartas = preferences.getString("placarEquipe2Quartas", "");
        placarEquipe3Quartas = preferences.getString("placarEquipe3Quartas", "");
        placarEquipe4Quartas = preferences.getString("placarEquipe4Quartas", "");
        placarEquipe5Quartas = preferences.getString("placarEquipe5Quartas", "");
        placarEquipe6Quartas = preferences.getString("placarEquipe6Quartas", "");
        placarEquipe7Quartas = preferences.getString("placarEquipe7Quartas", "");
        placarEquipe8Quartas = preferences.getString("placarEquipe8Quartas", "");
        finalizouQuartas = preferences.getBoolean("finalizouQuartas", false);


    }

    private void restaurarSharedPreferencesSemi() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);

        vencedor1QuartasGrupoID = preferences.getInt("vencedor1QuartasGrupoID", -1);
        vencedor1QuartasID = preferences.getInt("vencedor1QuartasID", -1);
        nomeVencedor1Quartas = preferences.getString("nomeVencedor1Quartas", "");
        vencedor2QuartasGrupoID = preferences.getInt("vencedor2QuartasGrupoID", -1);
        vencedor2QuartasID = preferences.getInt("vencedor2QuartasID", -1);
        nomeVencedor2Quartas = preferences.getString("nomeVencedor2Quartas", "");
        vencedor3QuartasGrupoID = preferences.getInt("vencedor3QuartasGrupoID", -1);
        vencedor3QuartasID = preferences.getInt("vencedor3QuartasID", -1);
        nomeVencedor3Quartas = preferences.getString("nomeVencedor3Quartas", "");
        vencedor4QuartasGrupoID = preferences.getInt("vencedor4QuartasGrupoID", -1);
        vencedor4QuartasID = preferences.getInt("vencedor4QuartasID", -1);
        nomeVencedor4Quartas = preferences.getString("nomeVencedor4Quartas", "");

        placarEquipe1Semi = preferences.getString("placarEquipe1Semi", "");
        placarEquipe2Semi = preferences.getString("placarEquipe2Semi", "");
        placarEquipe3Semi = preferences.getString("placarEquipe3Semi", "");
        placarEquipe4Semi = preferences.getString("placarEquipe4Semi", "");
        finalizouSemi = preferences.getBoolean("finalizouSemi", false);

    }

    private void restaurarSharedPreferencesTerceiro() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);

        perdedor1SemiGrupoID = preferences.getInt("perdedor1SemiGrupoID", -1);
        perdedor1SemiID = preferences.getInt("perdedor1SemiID", -1);
        nomePerdedor1Semi = preferences.getString("nomePerdedor1Semi", "");
        perdedor2SemiGrupoID = preferences.getInt("perdedor2SemiGrupoID", -1);
        perdedor2SemiID = preferences.getInt("perdedor2SemiID", -1);
        nomePerdedor2Semi = preferences.getString("nomePerdedor2Semi", "");

        placarEquipe1Terceiro = preferences.getString("placarEquipe1Terceiro", "");
        placarEquipe2Terceiro = preferences.getString("placarEquipe2Terceiro", "");
        finalizouTerceiro = preferences.getBoolean("finalizouTerceiro", false);
    }

    private void restaurarSharedPreferencesFinal() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);

        vencedor1SemiGrupoID = preferences.getInt("vencedor1SemiGrupoID", -1);
        vencedor1SemiID = preferences.getInt("vencedor1SemiID", -1);
        nomeVencedor1Semi = preferences.getString("nomeVencedor1Semi", "");
        vencedor2SemiGrupoID = preferences.getInt("vencedor2SemiGrupoID", -1);
        vencedor2SemiID = preferences.getInt("vencedor2SemiID", -1);
        nomeVencedor2Semi = preferences.getString("nomeVencedor2Semi", "");

        placarEquipe1Final = preferences.getString("placarEquipe1Final", "");
        placarEquipe2Final = preferences.getString("placarEquipe2Final", "");
        finalizouFinal = preferences.getBoolean("finalizouFinal", false);
    }

    private void restaurarSharedPreferencesInitQuartas() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);

        pEquipe1Quartas = preferences.getInt("pEquipe1Quartas", -1);
        jEquipe1Quartas = preferences.getInt("jEquipe1Quartas", -1);
        vEquipe1Quartas = preferences.getInt("vEquipe1Quartas", -1);
        eEquipe1Quartas = preferences.getInt("eEquipe1Quartas", -1);
        dEquipe1Quartas = preferences.getInt("dEquipe1Quartas", -1);
        gpEquipe1Quartas = preferences.getInt("gpEquipe1Quartas", -1);
        gcEquipe1Quartas = preferences.getInt("gcEquipe1Quartas", -1);
        sgEquipe1Quartas = preferences.getInt("sgEquipe1Quartas", -1);
        pEquipe2Quartas = preferences.getInt("pEquipe2Quartas", -1);
        jEquipe2Quartas = preferences.getInt("jEquipe2Quartas", -1);
        vEquipe2Quartas = preferences.getInt("vEquipe2Quartas", -1);
        eEquipe2Quartas = preferences.getInt("eEquipe2Quartas", -1);
        dEquipe2Quartas = preferences.getInt("dEquipe2Quartas", -1);
        gpEquipe2Quartas = preferences.getInt("gpEquipe2Quartas", -1);
        gcEquipe2Quartas = preferences.getInt("gcEquipe2Quartas", -1);
        sgEquipe2Quartas = preferences.getInt("sgEquipe2Quartas", -1);
        pEquipe3Quartas = preferences.getInt("pEquipe3Quartas", -1);
        jEquipe3Quartas = preferences.getInt("jEquipe3Quartas", -1);
        vEquipe3Quartas = preferences.getInt("vEquipe3Quartas", -1);
        eEquipe3Quartas = preferences.getInt("eEquipe3Quartas", -1);
        dEquipe3Quartas = preferences.getInt("dEquipe3Quartas", -1);
        gpEquipe3Quartas = preferences.getInt("gpEquipe3Quartas", -1);
        gcEquipe3Quartas = preferences.getInt("gcEquipe3Quartas", -1);
        sgEquipe3Quartas = preferences.getInt("sgEquipe3Quartas", -1);
        pEquipe4Quartas = preferences.getInt("pEquipe4Quartas", -1);
        jEquipe4Quartas = preferences.getInt("jEquipe4Quartas", -1);
        vEquipe4Quartas = preferences.getInt("vEquipe4Quartas", -1);
        eEquipe4Quartas = preferences.getInt("eEquipe4Quartas", -1);
        dEquipe4Quartas = preferences.getInt("dEquipe4Quartas", -1);
        gpEquipe4Quartas = preferences.getInt("gpEquipe4Quartas", -1);
        gcEquipe4Quartas = preferences.getInt("gcEquipe4Quartas", -1);
        sgEquipe4Quartas = preferences.getInt("sgEquipe4Quartas", -1);
        pEquipe5Quartas = preferences.getInt("pEquipe5Quartas", -1);
        jEquipe5Quartas = preferences.getInt("jEquipe5Quartas", -1);
        vEquipe5Quartas = preferences.getInt("vEquipe5Quartas", -1);
        eEquipe5Quartas = preferences.getInt("eEquipe5Quartas", -1);
        dEquipe5Quartas = preferences.getInt("dEquipe5Quartas", -1);
        gpEquipe5Quartas = preferences.getInt("gpEquipe5Quartas", -1);
        gcEquipe5Quartas = preferences.getInt("gcEquipe5Quartas", -1);
        sgEquipe5Quartas = preferences.getInt("sgEquipe5Quartas", -1);
        pEquipe6Quartas = preferences.getInt("pEquipe6Quartas", -1);
        jEquipe6Quartas = preferences.getInt("jEquipe6Quartas", -1);
        vEquipe6Quartas = preferences.getInt("vEquipe6Quartas", -1);
        eEquipe6Quartas = preferences.getInt("eEquipe6Quartas", -1);
        dEquipe6Quartas = preferences.getInt("dEquipe6Quartas", -1);
        gpEquipe6Quartas = preferences.getInt("gpEquipe6Quartas", -1);
        gcEquipe6Quartas = preferences.getInt("gcEquipe6Quartas", -1);
        sgEquipe6Quartas = preferences.getInt("sgEquipe6Quartas", -1);
        pEquipe7Quartas = preferences.getInt("pEquipe7Quartas", -1);
        jEquipe7Quartas = preferences.getInt("jEquipe7Quartas", -1);
        vEquipe7Quartas = preferences.getInt("vEquipe7Quartas", -1);
        eEquipe7Quartas = preferences.getInt("eEquipe7Quartas", -1);
        dEquipe7Quartas = preferences.getInt("dEquipe7Quartas", -1);
        gpEquipe7Quartas = preferences.getInt("gpEquipe7Quartas", -1);
        gcEquipe7Quartas = preferences.getInt("gcEquipe7Quartas", -1);
        sgEquipe7Quartas = preferences.getInt("sgEquipe7Quartas", -1);
        pEquipe8Quartas = preferences.getInt("pEquipe8Quartas", -1);
        jEquipe8Quartas = preferences.getInt("jEquipe8Quartas", -1);
        vEquipe8Quartas = preferences.getInt("vEquipe8Quartas", -1);
        eEquipe8Quartas = preferences.getInt("eEquipe8Quartas", -1);
        dEquipe8Quartas = preferences.getInt("dEquipe8Quartas", -1);
        gpEquipe8Quartas = preferences.getInt("gpEquipe8Quartas", -1);
        gcEquipe8Quartas = preferences.getInt("gcEquipe8Quartas", -1);
        sgEquipe8Quartas = preferences.getInt("sgEquipe8Quartas", -1);
    }

    private void restaurarSharedPreferencesInitSemi() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);

        pEquipe1Semi = preferences.getInt("pEquipe1Semi", -1);
        jEquipe1Semi = preferences.getInt("jEquipe1Semi", -1);
        vEquipe1Semi = preferences.getInt("vEquipe1Semi", -1);
        eEquipe1Semi = preferences.getInt("eEquipe1Semi", -1);
        dEquipe1Semi = preferences.getInt("dEquipe1Semi", -1);
        gpEquipe1Semi = preferences.getInt("gpEquipe1Semi", -1);
        gcEquipe1Semi = preferences.getInt("gcEquipe1Semi", -1);
        sgEquipe1Semi = preferences.getInt("sgEquipe1Semi", -1);
        pEquipe2Semi = preferences.getInt("pEquipe2Semi", -1);
        jEquipe2Semi = preferences.getInt("jEquipe2Semi", -1);
        vEquipe2Semi = preferences.getInt("vEquipe2Semi", -1);
        eEquipe2Semi = preferences.getInt("eEquipe2Semi", -1);
        dEquipe2Semi = preferences.getInt("dEquipe2Semi", -1);
        gpEquipe2Semi = preferences.getInt("gpEquipe2Semi", -1);
        gcEquipe2Semi = preferences.getInt("gcEquipe2Semi", -1);
        sgEquipe2Semi = preferences.getInt("sgEquipe2Semi", -1);
        pEquipe3Semi = preferences.getInt("pEquipe3Semi", -1);
        jEquipe3Semi = preferences.getInt("jEquipe3Semi", -1);
        vEquipe3Semi = preferences.getInt("vEquipe3Semi", -1);
        eEquipe3Semi = preferences.getInt("eEquipe3Semi", -1);
        dEquipe3Semi = preferences.getInt("dEquipe3Semi", -1);
        gpEquipe3Semi = preferences.getInt("gpEquipe3Semi", -1);
        gcEquipe3Semi = preferences.getInt("gcEquipe3Semi", -1);
        sgEquipe3Semi = preferences.getInt("sgEquipe3Semi", -1);
        pEquipe4Semi = preferences.getInt("pEquipe4Semi", -1);
        jEquipe4Semi = preferences.getInt("jEquipe4Semi", -1);
        vEquipe4Semi = preferences.getInt("vEquipe4Semi", -1);
        eEquipe4Semi = preferences.getInt("eEquipe4Semi", -1);
        dEquipe4Semi = preferences.getInt("dEquipe4Semi", -1);
        gpEquipe4Semi = preferences.getInt("gpEquipe4Semi", -1);
        gcEquipe4Semi = preferences.getInt("gcEquipe4Semi", -1);
        sgEquipe4Semi = preferences.getInt("sgEquipe4Semi", -1);

    }

    private void restaurarSharedPreferencesInitTerceiro() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);

        pEquipe1Ter = preferences.getInt("pEquipe1Ter", -1);
        jEquipe1Ter = preferences.getInt("jEquipe1Ter", -1);
        vEquipe1Ter = preferences.getInt("vEquipe1Ter", -1);
        eEquipe1Ter = preferences.getInt("eEquipe1Ter", -1);
        dEquipe1Ter = preferences.getInt("dEquipe1Ter", -1);
        gpEquipe1Ter = preferences.getInt("gpEquipe1Ter", -1);
        gcEquipe1Ter = preferences.getInt("gcEquipe1Ter", -1);
        sgEquipe1Ter = preferences.getInt("sgEquipe1Ter", -1);
        pEquipe2Ter = preferences.getInt("pEquipe2Ter", -1);
        jEquipe2Ter = preferences.getInt("jEquipe2Ter", -1);
        vEquipe2Ter = preferences.getInt("vEquipe2Ter", -1);
        eEquipe2Ter = preferences.getInt("eEquipe2Ter", -1);
        dEquipe2Ter = preferences.getInt("dEquipe2Ter", -1);
        gpEquipe2Ter = preferences.getInt("gpEquipe2Ter", -1);
        gcEquipe2Ter = preferences.getInt("gcEquipe2Ter", -1);
        sgEquipe2Ter = preferences.getInt("sgEquipe2Ter", -1);

    }

    private void restaurarSharedPreferencesInitFinal() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);

        pEquipe1Final = preferences.getInt("pEquipe1Final", -1);
        jEquipe1Final = preferences.getInt("jEquipe1Final", -1);
        vEquipe1Final = preferences.getInt("vEquipe1Final", -1);
        eEquipe1Final = preferences.getInt("eEquipe1Final", -1);
        dEquipe1Final = preferences.getInt("dEquipe1Final", -1);
        gpEquipe1Final = preferences.getInt("gpEquipe1Final", -1);
        gcEquipe1Final = preferences.getInt("gcEquipe1Final", -1);
        sgEquipe1Final = preferences.getInt("sgEquipe1Final", -1);
        pEquipe2Final = preferences.getInt("pEquipe2Final", -1);
        jEquipe2Final = preferences.getInt("jEquipe2Final", -1);
        vEquipe2Final = preferences.getInt("vEquipe2Final", -1);
        eEquipe2Final = preferences.getInt("eEquipe2Final", -1);
        dEquipe2Final = preferences.getInt("dEquipe2Final", -1);
        gpEquipe2Final = preferences.getInt("gpEquipe2Final", -1);
        gcEquipe2Final = preferences.getInt("gcEquipe2Final", -1);
        sgEquipe2Final = preferences.getInt("sgEquipe2Final", -1);

    }

    private void salvarSharedPreferencesInitSemi() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("pEquipe1Semi", mula1[0].getPontos());
        dados.putInt("jEquipe1Semi", mula1[0].getJogos());
        dados.putInt("vEquipe1Semi", mula1[0].getVitorias());
        dados.putInt("eEquipe1Semi", mula1[0].getEmpates());
        dados.putInt("dEquipe1Semi", mula1[0].getDerrotas());
        dados.putInt("gpEquipe1Semi", mula1[0].getGolsPro());
        dados.putInt("gcEquipe1Semi", mula1[0].getGolsContra());
        dados.putInt("sgEquipe1Semi", mula1[0].getSaldoGols());

        dados.putInt("pEquipe2Semi", mula1[1].getPontos());
        dados.putInt("jEquipe2Semi", mula1[1].getJogos());
        dados.putInt("vEquipe2Semi", mula1[1].getVitorias());
        dados.putInt("eEquipe2Semi", mula1[1].getEmpates());
        dados.putInt("dEquipe2Semi", mula1[1].getDerrotas());
        dados.putInt("gpEquipe2Semi", mula1[1].getGolsPro());
        dados.putInt("gcEquipe2Semi", mula1[1].getGolsContra());
        dados.putInt("sgEquipe2Semi", mula1[1].getSaldoGols());

        dados.putInt("pEquipe3Semi", mula1[2].getPontos());
        dados.putInt("jEquipe3Semi", mula1[2].getJogos());
        dados.putInt("vEquipe3Semi", mula1[2].getVitorias());
        dados.putInt("eEquipe3Semi", mula1[2].getEmpates());
        dados.putInt("dEquipe3Semi", mula1[2].getDerrotas());
        dados.putInt("gpEquipe3Semi", mula1[2].getGolsPro());
        dados.putInt("gcEquipe3Semi", mula1[2].getGolsContra());
        dados.putInt("sgEquipe3Semi", mula1[2].getSaldoGols());

        dados.putInt("pEquipe4Semi", mula1[3].getPontos());
        dados.putInt("jEquipe4Semi", mula1[3].getJogos());
        dados.putInt("vEquipe4Semi", mula1[3].getVitorias());
        dados.putInt("eEquipe4Semi", mula1[3].getEmpates());
        dados.putInt("dEquipe4Semi", mula1[3].getDerrotas());
        dados.putInt("gpEquipe4Semi", mula1[3].getGolsPro());
        dados.putInt("gcEquipe4Semi", mula1[3].getGolsContra());
        dados.putInt("sgEquipe4Semi", mula1[3].getSaldoGols());

        dados.apply();
    }

    private void salvarSharedPreferencesInitTerceiro() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("pEquipe1Ter", mula2[2].getPontos());
        dados.putInt("jEquipe1Ter", mula2[2].getJogos());
        dados.putInt("vEquipe1Ter", mula2[2].getVitorias());
        dados.putInt("eEquipe1Ter", mula2[2].getEmpates());
        dados.putInt("dEquipe1Ter", mula2[2].getDerrotas());
        dados.putInt("gpEquipe1Ter", mula2[2].getGolsPro());
        dados.putInt("gcEquipe1Ter", mula2[2].getGolsContra());
        dados.putInt("sgEquipe1Ter", mula2[2].getSaldoGols());

        dados.putInt("pEquipe2Ter", mula2[3].getPontos());
        dados.putInt("jEquipe2Ter", mula2[3].getJogos());
        dados.putInt("vEquipe2Ter", mula2[3].getVitorias());
        dados.putInt("eEquipe2Ter", mula2[3].getEmpates());
        dados.putInt("dEquipe2Ter", mula2[3].getDerrotas());
        dados.putInt("gpEquipe2Ter", mula2[3].getGolsPro());
        dados.putInt("gcEquipe2Ter", mula2[3].getGolsContra());
        dados.putInt("sgEquipe2Ter", mula2[3].getSaldoGols());

        dados.apply();

    }

    private void salvarSharedPreferencesInitFinal() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("pEquipe1Final", mula2[0].getPontos());
        dados.putInt("jEquipe1Final", mula2[0].getJogos());
        dados.putInt("vEquipe1Final", mula2[0].getVitorias());
        dados.putInt("eEquipe1Final", mula2[0].getEmpates());
        dados.putInt("dEquipe1Final", mula2[0].getDerrotas());
        dados.putInt("gpEquipe1Final", mula2[0].getGolsPro());
        dados.putInt("gcEquipe1Final", mula2[0].getGolsContra());
        dados.putInt("sgEquipe1Final", mula2[0].getSaldoGols());

        dados.putInt("pEquipe2Final", mula2[1].getPontos());
        dados.putInt("jEquipe2Final", mula2[1].getJogos());
        dados.putInt("vEquipe2Final", mula2[1].getVitorias());
        dados.putInt("eEquipe2Final", mula2[1].getEmpates());
        dados.putInt("dEquipe2Final", mula2[1].getDerrotas());
        dados.putInt("gpEquipe2Final", mula2[1].getGolsPro());
        dados.putInt("gcEquipe2Final", mula2[1].getGolsContra());
        dados.putInt("sgEquipe2Final", mula2[1].getSaldoGols());

        dados.apply();

    }

    private void salvarSharedPreferencesQuartas() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("vencedor1QuartasGrupoID", mula1[0].getGrupoID());
        dados.putInt("vencedor1QuartasID", mula1[0].getId());
        dados.putString("nomeVencedor1Quartas", mula1[0].getNome());
        dados.putInt("vencedor2QuartasGrupoID", mula1[1].getGrupoID());
        dados.putInt("vencedor2QuartasID", mula1[1].getId());
        dados.putString("nomeVencedor2Quartas", mula1[1].getNome());
        dados.putInt("vencedor3QuartasGrupoID", mula1[2].getGrupoID());
        dados.putInt("vencedor3QuartasID", mula1[2].getId());
        dados.putString("nomeVencedor3Quartas", mula1[2].getNome());
        dados.putInt("vencedor4QuartasGrupoID", mula1[3].getGrupoID());
        dados.putInt("vencedor4QuartasID", mula1[3].getId());
        dados.putString("nomeVencedor4Quartas", mula1[3].getNome());

        dados.putString("placarEquipe1Quartas", editPlacarEquipe1.getText().toString());
        dados.putString("placarEquipe2Quartas", editPlacarEquipe2.getText().toString());
        dados.putString("placarEquipe3Quartas", editPlacarEquipe3.getText().toString());
        dados.putString("placarEquipe4Quartas", editPlacarEquipe4.getText().toString());
        dados.putString("placarEquipe5Quartas", editPlacarEquipe5.getText().toString());
        dados.putString("placarEquipe6Quartas", editPlacarEquipe6.getText().toString());
        dados.putString("placarEquipe7Quartas", editPlacarEquipe7.getText().toString());
        dados.putString("placarEquipe8Quartas", editPlacarEquipe8.getText().toString());
        dados.putBoolean("finalizouQuartas", true);

        dados.apply();

    }

    private void salvarSharedPreferencesSemi() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("vencedor1SemiGrupoID", mula2[0].getGrupoID());
        dados.putInt("vencedor1SemiID", mula2[0].getId());
        dados.putString("nomeVencedor1Semi", mula2[0].getNome());
        dados.putInt("vencedor2SemiGrupoID", mula2[1].getGrupoID());
        dados.putInt("vencedor2SemiID", mula2[1].getId());
        dados.putString("nomeVencedor2Semi", mula2[1].getNome());

        dados.putInt("perdedor1SemiGrupoID", mula2[2].getGrupoID());
        dados.putInt("perdedor1SemiID", mula2[2].getId());
        dados.putString("nomePerdedor1Semi", mula2[2].getNome());
        dados.putInt("perdedor2SemiGrupoID", mula2[3].getGrupoID());
        dados.putInt("perdedor2SemiID", mula2[3].getId());
        dados.putString("nomePerdedor2Semi", mula2[3].getNome());

        dados.putString("placarEquipe1Semi", editPlacarEquipe1Semi.getText().toString());
        dados.putString("placarEquipe2Semi", editPlacarEquipe2Semi.getText().toString());
        dados.putString("placarEquipe3Semi", editPlacarEquipe3Semi.getText().toString());
        dados.putString("placarEquipe4Semi", editPlacarEquipe4Semi.getText().toString());
        dados.putBoolean("finalizouSemi", true);

        dados.apply();

    }

    private void salvarSharedPreferencesTerceiro() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("terceiroGrupoID", mula2[2].getGrupoID());
        dados.putInt("terceiroID", mula2[2].getId());
        dados.putString("nomeTerceiro", mula2[2].getNome());

        dados.putString("placarEquipe1Terceiro", editPlacarEquipe1Terceiro.getText().toString());
        dados.putString("placarEquipe2Terceiro", editPlacarEquipe2Terceiro.getText().toString());
        dados.putBoolean("finalizouTerceiro", true);


        dados.apply();

    }

    private void salvarSharedPreferencesFinal() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("primeiroGrupoID", mula2[0].getGrupoID());
        dados.putInt("primeiroID", mula2[0].getId());
        dados.putString("nomePrimeiro", mula2[0].getNome());
        dados.putInt("segundoGrupoID", mula2[1].getGrupoID());
        dados.putInt("segundoID", mula2[1].getId());
        dados.putString("nomeSegundo", mula2[1].getNome());

        dados.putString("placarEquipe1Final", editPlacarEquipe1Final.getText().toString());
        dados.putString("placarEquipe2Final", editPlacarEquipe2Final.getText().toString());
        dados.putBoolean("finalizouFinal", true);

        dados.apply();

    }

}