package com.innovatesolutions.organizetorneios.view;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.adapter.JogadorArtilhariaListAdapter;
import com.innovatesolutions.organizetorneios.controller.EquipeController;
import com.innovatesolutions.organizetorneios.controller.JogadorController;
import com.innovatesolutions.organizetorneios.model.Equipe;
import com.innovatesolutions.organizetorneios.model.Jogador;

import java.util.ArrayList;

public class Artilharia extends AppCompatActivity {

    SharedPreferences preferences;

    AlertDialog.Builder builder;

    AlertDialog alert;

    Jogador jogador;

    JogadorController jogadorController;

    Equipe equipe;

    EquipeController equipeController;

    ArrayList<Jogador> dataSet;

    ListView listView;

    boolean possuiJogadores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artilharia);
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

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Artilharia.this, CadastrarJogador.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                return;
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Dashboard.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        return;
    }

}