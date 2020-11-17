package com.innovatesolutions.organizetorneios.view;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.api.AppUtil;
import com.innovatesolutions.organizetorneios.controller.EquipeController;
import com.innovatesolutions.organizetorneios.controller.GrupoController;
import com.innovatesolutions.organizetorneios.model.Equipe;
import com.innovatesolutions.organizetorneios.model.Grupo;

public class Final extends AppCompatActivity {

    TextView txtTituloFinal, txtPrimeiro, txtSegundo, txtTerceiro;

    String pasta = "fonts/";
    String fontBanger = "Bangers.ttf";

    EquipeController equipeController;

    GrupoController grupoController;

    AlertDialog.Builder builder;
    AlertDialog alert;

    SharedPreferences preferences;

    Button btnEncerrar;

    //DELETAR REGISTROS DB
    int primeiroID, segundoID, terceiroID, grupoID, grupo1ID, grupo2ID, grupo3ID, grupo4ID, equipe1ID, equipe2ID, equipe3ID, equipe4ID, equipe5ID, equipe6ID, equipe7ID, equipe8ID, equipe9ID, equipe10ID, equipe11ID, equipe12ID, equipe13ID, equipe14ID, equipe15ID, equipe16ID, qtdEquipes;
    Equipe equipe1F, equipe2F, equipe3F, equipe1, equipe2, equipe3, equipe4, equipe5, equipe6, equipe7, equipe8, equipe9, equipe10, equipe11, equipe12, equipe13, equipe14, equipe15, equipe16;

    Grupo grupo, grupo1, grupo2, grupo3, grupo4;

    String nomePrimeiro, nomeSegundo, nomeTerceiro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final2);

        String mensagem = getString(R.string.mensagemNotificacaoVersaoPremium);
        String titulo = getString(R.string.tituloNotificacaoVersaoPremium);

        //notificarUsuario(mensagem, titulo);

        restaurarSharedPreferences();

        initFormulario();

        popularFormulario();

    }

    private void initFormulario() {

        txtTituloFinal = findViewById(R.id.txtTituloFinal);

        Typeface font = Typeface.createFromAsset(getAssets(), pasta + fontBanger);
        txtTituloFinal.setTypeface(font);

        txtPrimeiro = findViewById(R.id.txtPrimeiro);
        txtSegundo = findViewById(R.id.txtSegundo);
        txtTerceiro = findViewById(R.id.txtTerceiro);

        btnEncerrar = findViewById(R.id.btnEncerrar);

        equipe1F = new Equipe();
        equipe1F.setId(primeiroID);

        equipe2F = new Equipe();
        equipe2F.setId(segundoID);

        equipe3F = new Equipe();
        equipe3F.setId(terceiroID);

        equipeController = new EquipeController(this);
        grupoController = new GrupoController(this);

    }

    private void popularFormulario() {

        if (terceiroID >= 1) {

            equipe1F = equipeController.getEquipeByID(equipe1F);
            equipe2F = equipeController.getEquipeByID(equipe2F);
            equipe3F = equipeController.getEquipeByID(equipe3F);

            txtPrimeiro.setText(equipe1F.getNome());
            txtSegundo.setText(equipe2F.getNome());
            txtTerceiro.setText(equipe3F.getNome());

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

                    Intent intent = new Intent(Final.this, Dashboard.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            });

            alert = builder.create();
            alert.show();
        }

    }

    public void encerrar(View view) {

        limpaRegistros();

        salvarSharedPreferences();

        Intent intent = new Intent(Final.this, EscolherTorneio.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        return;
    }

    private void limpaRegistros() {

        if (qtdEquipes == 4) {

            equipe1 = new Equipe();
            equipe1.setId(equipe1ID);

            equipe2 = new Equipe();
            equipe2.setId(equipe2ID);

            equipe3 = new Equipe();
            equipe3.setId(equipe3ID);

            equipe4 = new Equipe();
            equipe4.setId(equipe4ID);

            grupo = new Grupo();
            grupo.setId(grupoID);

            equipeController.deletar(equipe1);
            equipeController.deletar(equipe2);
            equipeController.deletar(equipe3);
            equipeController.deletar(equipe4);
            grupoController.deletar(grupo);
        } else if (qtdEquipes == 12) {

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

            equipeController.deletar(equipe1);
            equipeController.deletar(equipe2);
            equipeController.deletar(equipe3);
            equipeController.deletar(equipe4);
            equipeController.deletar(equipe5);
            equipeController.deletar(equipe6);
            equipeController.deletar(equipe7);
            equipeController.deletar(equipe8);
            equipeController.deletar(equipe9);
            equipeController.deletar(equipe10);
            equipeController.deletar(equipe11);
            equipeController.deletar(equipe12);
            grupoController.deletar(grupo1);
            grupoController.deletar(grupo2);
            grupoController.deletar(grupo3);
            grupoController.deletar(grupo4);
        } else if (qtdEquipes == 16) {

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

            equipeController.deletar(equipe1);
            equipeController.deletar(equipe2);
            equipeController.deletar(equipe3);
            equipeController.deletar(equipe4);
            equipeController.deletar(equipe5);
            equipeController.deletar(equipe6);
            equipeController.deletar(equipe7);
            equipeController.deletar(equipe8);
            equipeController.deletar(equipe9);
            equipeController.deletar(equipe10);
            equipeController.deletar(equipe11);
            equipeController.deletar(equipe12);
            equipeController.deletar(equipe13);
            equipeController.deletar(equipe14);
            equipeController.deletar(equipe15);
            equipeController.deletar(equipe16);
            grupoController.deletar(grupo1);
            grupoController.deletar(grupo2);
            grupoController.deletar(grupo3);
            grupoController.deletar(grupo4);
        }
    }

    private void notificarUsuario(String mensagem,
                                  String titulo) {

        NotificationCompat.Builder notificacao =
                new NotificationCompat.Builder(getBaseContext());

        notificacao.setContentTitle(titulo);
        notificacao.setContentText(mensagem);
        notificacao.setPriority(Notification.PRIORITY_HIGH);


        notificacao.setLargeIcon(
                BitmapFactory.decodeResource(getBaseContext().getResources(),
                        R.mipmap.ic_launcher_round));

        notificacao.setSmallIcon(R.drawable.iconfinder_trophy);

        Intent intent =
                new Intent(getBaseContext(), NotificacaoVersaoPremium.class);

        PendingIntent pendingIntent =
                PendingIntent.getActivity(getBaseContext(), 100,
                        intent, PendingIntent.FLAG_UPDATE_CURRENT);

        notificacao.setAutoCancel(true);
        notificacao.setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager)
                        getBaseContext().getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(9000, notificacao.build());
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this, MataMata.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        return;

    }

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);

        primeiroID = preferences.getInt("primeiroID", -1);
        nomePrimeiro = preferences.getString("nomePrimeiro", "");
        segundoID = preferences.getInt("segundoID", -1);
        nomeSegundo = preferences.getString("nomeSegundo", "");
        terceiroID = preferences.getInt("terceiroID", -1);
        nomeTerceiro = preferences.getString("nomeTerceiro", "");

        equipe1ID = preferences.getInt("equipe1ID", -1);
        equipe2ID = preferences.getInt("equipe2ID", -1);
        equipe3ID = preferences.getInt("equipe3ID", -1);
        equipe4ID = preferences.getInt("equipe4ID", -1);
        equipe5ID = preferences.getInt("equipe5ID", -1);
        equipe6ID = preferences.getInt("equipe6ID", -1);
        equipe7ID = preferences.getInt("equipe7ID", -1);
        equipe8ID = preferences.getInt("equipe8ID", -1);
        equipe9ID = preferences.getInt("equipe9ID", -1);
        equipe10ID = preferences.getInt("equipe10ID", -1);
        equipe11ID = preferences.getInt("equipe11ID", -1);
        equipe12ID = preferences.getInt("equipe12ID", -1);
        equipe13ID = preferences.getInt("equipe13ID", -1);
        equipe14ID = preferences.getInt("equipe14ID", -1);
        equipe15ID = preferences.getInt("equipe15ID", -1);
        equipe16ID = preferences.getInt("equipe16ID", -1);
        grupoID = preferences.getInt("grupoID", -1);
        grupo1ID = preferences.getInt("grupo1ID", -1);
        grupo2ID = preferences.getInt("grupo2ID", -1);
        grupo3ID = preferences.getInt("grupo3ID", -1);
        grupo4ID = preferences.getInt("grupo4ID", -1);
        qtdEquipes = preferences.getInt("qtdEquipes", -1);

    }

    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("qtdEquipes", 0);
        dados.putString("nomeEquipe1", "");
        dados.apply();

    }
}