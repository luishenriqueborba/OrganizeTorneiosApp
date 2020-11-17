package com.innovatesolutions.organizetorneios.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.snackbar.Snackbar;
import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.adapter.JogadorArtilhariaListAdapter;
import com.innovatesolutions.organizetorneios.api.AppUtil;
import com.innovatesolutions.organizetorneios.controller.EquipeController;
import com.innovatesolutions.organizetorneios.controller.JogadorController;
import com.innovatesolutions.organizetorneios.model.Equipe;
import com.innovatesolutions.organizetorneios.model.Jogador;

import java.util.ArrayList;

public class Backup extends AppCompatActivity {

    SharedPreferences preferences;

    AlertDialog.Builder builder;

    AlertDialog alert;

    Jogador jogador;

    JogadorController jogadorController;

    Equipe equipe;

    EquipeController equipeController;

    ArrayList<Jogador> dataSet;

    ListView listView;

    JogadorArtilhariaListAdapter adapter;

    int qtdJogadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backup);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        jogadorController = new JogadorController(getApplicationContext());

        listView = findViewById(R.id.listviewJogadores);

        dataSet = jogadorController.listarTodosJogadores();

        final JogadorArtilhariaListAdapter adapter = new JogadorArtilhariaListAdapter(dataSet, getApplicationContext());

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                jogador = dataSet.get(position);

                Snackbar.make(view, "Nome: " + jogador.getNome() + " | Gols: " + jogador.getGols(), Snackbar.LENGTH_SHORT).setAction("No action", null).show();

            }
        });


        /**FloatingActionButton fab = findViewById(R.id.fabAddJogador);
         fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        Intent intent = new Intent(Artilharia.this, CadastrarJogador.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        return;
        }
        });*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.artilharia, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_add_jogador) {

            Intent intent = new Intent(Backup.this, CadastrarJogador.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void voltar(View view) {

        Intent intent = new Intent(Backup.this, Dashboard.class);
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

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        qtdJogadores = preferences.getInt("qtdJogadores", -1);

    }

    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("qtdJogadores", -1);
        dados.apply();

    }



}