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

    int primeiroID, segundoID, terceiroID, qtdEquipes;
    Equipe equipe1F, equipe2F, equipe3F;

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
        AppUtil.limpaRegistros(getApplicationContext());
        salvarSharedPreferences();

        Intent intent = new Intent(Final.this, EscolherTorneio.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
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