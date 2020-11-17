package com.innovatesolutions.organizetorneios.fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.adapter.JogadorArtilhariaListAdapter;
import com.innovatesolutions.organizetorneios.controller.JogadorController;
import com.innovatesolutions.organizetorneios.model.Jogador;
import com.innovatesolutions.organizetorneios.view.Dashboard;

import java.util.ArrayList;

public class ListaArtilhariaFragment extends Fragment {

    SharedPreferences preferences;

    AlertDialog.Builder builder;

    AlertDialog alert;

    Jogador jogador;

    JogadorController jogadorController;

    ArrayList<Jogador> dataSet;

    ListView listView;

    int qtdJogadores;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_lista_artilharia, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        jogadorController = new JogadorController(getContext());

        listView = view.findViewById(R.id.listviewJogadores);

        dataSet = jogadorController.listarTodosJogadores();

        final JogadorArtilhariaListAdapter adapter = new JogadorArtilhariaListAdapter(dataSet, getContext());

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                jogador = dataSet.get(position);

                Snackbar.make(view, "Nome: " + jogador.getNome() + " | Gols: " + jogador.getGols(), Snackbar.LENGTH_SHORT).setAction("No action", null).show();

            }
        });
    }

    public void onBackPressed() {

        Intent intent = new Intent(getActivity(), Dashboard.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        return;
    }

}