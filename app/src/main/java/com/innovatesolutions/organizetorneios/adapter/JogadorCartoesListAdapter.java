package com.innovatesolutions.organizetorneios.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.snackbar.Snackbar;
import com.innovatesolutions.organizetorneios.R;
import com.innovatesolutions.organizetorneios.api.AppUtil;
import com.innovatesolutions.organizetorneios.controller.EquipeController;
import com.innovatesolutions.organizetorneios.controller.JogadorController;
import com.innovatesolutions.organizetorneios.model.Equipe;
import com.innovatesolutions.organizetorneios.model.Jogador;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class JogadorCartoesListAdapter extends ArrayAdapter<Jogador> implements View.OnClickListener {

    SharedPreferences preferences;

    Context context;

    ArrayList<Jogador> dados;

    Jogador jogador;

    JogadorController jogadorController;

    Equipe equipe;

    EquipeController equipeController;

    AlertDialog.Builder builder;

    AlertDialog alert;

    ViewHolder linha;

    int qtdJogadores;

    private static class ViewHolder {

        TextView txtNome;
        TextView txtNumero;
        TextView txtEquipe;
        TextView txtQtdCartoesAmarelos;
        TextView txtQtdCartoesVermelhos;
        ImageView imgAvatar;
        ImageView imgAdicionarCartaoAmarelo;
        ImageView imgRemoverCartaoAmarelo;
        ImageView imgAdicionarCartaoVermelho;
        ImageView imgRemoverCartaoVermelho;
        ImageView imgDeletarJogador;

    }


    public JogadorCartoesListAdapter(ArrayList<Jogador> dataSet, Context context) {
        super(context, R.layout.listview_jogadores_artilharia, dataSet);

        this.dados = dataSet;
        this.context = context;
    }

    public void atualizarLista(ArrayList<Jogador> novosDados) {

        this.dados.clear();
        this.dados.addAll(novosDados);

        notifyDataSetChanged();
    }

    public void registerDataSetObserver(DataSetObserver observer) {
        super.registerDataSetObserver(observer);
    }

    @Override
    public void onClick(View view) {

        int posicao = (Integer) view.getTag();

        Object object = getItem(posicao);

        jogador = (Jogador) object;

        jogadorController = new JogadorController(getContext());

        switch (view.getId()) {

            case R.id.imgAvatar:
                Snackbar.make(view, "Nome: " + jogador.getNome() + " | Amarelos: " + jogador.getCartaoAmarelo() + " | Vermelhos: " + jogador.getCartaoVermelho(), Snackbar.LENGTH_SHORT).setAction("No action", null).show();
                break;

            case R.id.imgAdicionarCartaoAmarelo:

                jogador.setCartaoAmarelo(jogador.getCartaoAmarelo() + 1);

                if (jogadorController.alterar(jogador)) {

                    atualizarLista(jogadorController.listarTodosJogadores());

                    notifyDataSetChanged();

                    if (dados == null) {

                        salvarSharedPreferences();
                    }

                } else
                    Toast.makeText(context, "Não foi possível fazer a alteração!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.imgRemoverCartaoAmarelo:

                jogador.setCartaoAmarelo(jogador.getCartaoAmarelo() - 1);

                if (jogadorController.alterar(jogador)) {

                    atualizarLista(jogadorController.listarTodosJogadores());

                    notifyDataSetChanged();

                    if (dados == null) {

                        salvarSharedPreferences();
                    }

                } else
                    Toast.makeText(context, "Não foi possível fazer a alteração!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.imgDeletarJogador:
                /**builder = new AlertDialog.Builder(getContext());
                 builder.setTitle("ALERTA");
                 builder.setMessage("Realmente deseja DELETAR essa equipe?");
                 builder.setCancelable(true);
                 builder.setIcon(R.mipmap.ic_launcher_round);

                 builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                @Override public void onClick(DialogInterface dialogInterface, int i) {

                if(jogadorController.deletar(jogador)){

                restaurarSharedPreferences();

                qtdJogadores += -1;

                atualizarLista(jogadorController.listarTodosJogadores());

                notifyDataSetChanged();

                if(dados == null){

                salvarSharedPreferences();
                }

                }

                }
                });

                 builder.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                @Override public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.cancel();

                }
                });

                 alert = builder.create();
                 alert.show();*/

                if (jogadorController.deletar(jogador)) {

                    restaurarSharedPreferences();

                    qtdJogadores = qtdJogadores - 1;

                    atualizarLista(jogadorController.listarTodosJogadores());

                    notifyDataSetChanged();

                    salvarSharedPreferences();

                    if (dados == null) {

                        salvarSharedPreferences();
                    }

                }
                break;
        }
    }

    @NonNull
    @Override
    public View getView(int position, View dataSet, @NonNull ViewGroup parent) {

        jogador = getItem(position);

        equipe = new Equipe();
        equipe.setId(jogador.getEquipeId());

        equipeController = new EquipeController(getContext());

        equipe = equipeController.getEquipeByID(equipe);

        if (dataSet == null) {

            linha = new JogadorCartoesListAdapter.ViewHolder();

            LayoutInflater layoutElencoList = LayoutInflater.from(getContext());

            dataSet = layoutElencoList.inflate(R.layout.listview_jogadores_artilharia, parent, false);

            linha.txtNome = dataSet.findViewById(R.id.txtNome);
            linha.txtNumero = dataSet.findViewById(R.id.txtNumero);
            linha.txtEquipe = dataSet.findViewById(R.id.txtEquipe);
            linha.txtQtdGols = dataSet.findViewById(R.id.txtQtdGols);
            linha.imgAvatar = dataSet.findViewById(R.id.imgAvatar);
            linha.imgAdicionarGols = dataSet.findViewById(R.id.imgAdicionarGol);
            linha.imgRemoverGols = dataSet.findViewById(R.id.imgRemoverGol);
            linha.imgDeletarJogador = dataSet.findViewById(R.id.imgDeletarJogador);

            dataSet.setTag(linha);
        } else {

            linha = (JogadorCartoesListAdapter.ViewHolder) dataSet.getTag();
        }

        linha.txtNome.setText(jogador.getNome());
        linha.txtNumero.setText(jogador.getNumero());
        linha.txtEquipe.setText(equipe.getNome());
        linha.txtQtdGols.setText(String.valueOf(jogador.getGols()));

        linha.imgAvatar.setOnClickListener(this);
        linha.imgAvatar.setTag(position);

        linha.imgAdicionarGols.setOnClickListener(this);
        linha.imgAdicionarGols.setTag(position);

        linha.imgRemoverGols.setOnClickListener(this);
        linha.imgRemoverGols.setTag(position);

        linha.imgDeletarJogador.setOnClickListener(this);
        linha.imgDeletarJogador.setTag(position);

        return dataSet;
    }

    private void restaurarSharedPreferences() {

        preferences = getContext().getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        qtdJogadores = preferences.getInt("qtdJogadores", -1);

    }

    private void salvarSharedPreferences() {

        preferences = getContext().getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putInt("qtdJogadores", qtdJogadores);
        dados.apply();

    }
}
