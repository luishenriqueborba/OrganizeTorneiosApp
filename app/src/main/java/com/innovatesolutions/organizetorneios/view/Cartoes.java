package com.innovatesolutions.organizetorneios.view;

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
import com.innovatesolutions.organizetorneios.adapter.JogadorCartoesListAdapter;
import com.innovatesolutions.organizetorneios.api.AppUtil;
import com.innovatesolutions.organizetorneios.controller.JogadorController;
import com.innovatesolutions.organizetorneios.model.Jogador;

import java.util.ArrayList;

public class Cartoes extends AppCompatActivity {

    SharedPreferences preferences;

    Jogador jogador;

    JogadorController jogadorController;

    ArrayList<Jogador> dataSet;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartoes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        jogadorController = new JogadorController(getApplicationContext());

        listView = findViewById(R.id.listviewJogadoresCartoes);

        dataSet = jogadorController.listarTodosJogadores();

        final JogadorCartoesListAdapter adapter = new JogadorCartoesListAdapter(dataSet, getApplicationContext());

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                jogador = dataSet.get(position);

                Snackbar.make(view, "Nome: " + jogador.getNome() + " | CA: " + jogador.getCartaoAmarelo() + " | CV: " + jogador.getCartaoVermelho(), Snackbar.LENGTH_SHORT).setAction("No action", null).show();
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Cartoes.this, CadastrarJogador.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                return;

            }
        });
    }

    @Override
    public void onBackPressed() {
        limparTelaAnterior();
        Intent intent = new Intent(this, Dashboard.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        return;
    }

    private void limparTelaAnterior() {
        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putString("telaAnterior", "");
        dados.apply();
    }
}