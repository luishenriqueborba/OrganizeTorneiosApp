package com.innovatesolutions.organizetorneios.controller;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.Nullable;

import com.innovatesolutions.organizetorneios.api.AppDataBase;
import com.innovatesolutions.organizetorneios.datamodel.EquipeDataModel;
import com.innovatesolutions.organizetorneios.datamodel.JogadorDataModel;
import com.innovatesolutions.organizetorneios.datamodel.UsuarioDataModel;
import com.innovatesolutions.organizetorneios.model.Equipe;
import com.innovatesolutions.organizetorneios.model.Jogador;
import com.innovatesolutions.organizetorneios.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class JogadorController extends AppDataBase {

    private static final String TABELA = JogadorDataModel.TABELA;
    private ContentValues dados;

    public JogadorController(@Nullable Context context) {
        super(context);
    }

    public boolean incluir(Jogador obj) {

        dados = new ContentValues();

        dados.put(JogadorDataModel.FK, obj.getEquipeId());
        dados.put(JogadorDataModel.NOME, obj.getNome());
        dados.put(JogadorDataModel.NUMERO, obj.getNumero());
        dados.put(JogadorDataModel.GOLS, obj.getGols());
        dados.put(JogadorDataModel.CARTAO_AMARELO, obj.getCartaoAmarelo());
        dados.put(JogadorDataModel.CARTAO_VERMELHO, obj.getCartaoVermelho());

        return insertJogador(TABELA, dados);
    }

    public boolean alterar(Jogador obj) {

        dados = new ContentValues();

        dados.put(JogadorDataModel.ID, obj.getId());
        dados.put(JogadorDataModel.FK, obj.getEquipeId());
        dados.put(JogadorDataModel.NOME, obj.getNome());
        dados.put(JogadorDataModel.NUMERO, obj.getNumero());
        dados.put(JogadorDataModel.GOLS, obj.getGols());
        dados.put(JogadorDataModel.CARTAO_AMARELO, obj.getCartaoAmarelo());
        dados.put(JogadorDataModel.CARTAO_VERMELHO, obj.getCartaoVermelho());

        return updateJogador(TABELA, dados);
    }

    public boolean deletar(Jogador obj) {

        return deleteJogador(TABELA, obj.getId());
    }

    public List<Jogador> listar() {

        return listJogador(TABELA);
    }

    public ArrayList<Jogador> listarTodosJogadores() {

        return listAllPlayers(TABELA);
    }

    public Jogador getJogadorByID(Jogador obj) {

        obj = getJogadorByID(JogadorDataModel.TABELA, obj);

        return obj;
    }

    public int getUltimoID() {

        return getLastPK(TABELA);
    }

    public Usuario getUsuarioByID(Usuario obj) {

        obj = getUsuarioByID(UsuarioDataModel.TABELA, obj);


        return obj;
    }

    public Equipe getEquipeByFK(int idFK) {

        return getEquipeByFK(JogadorDataModel.TABELA, idFK);
    }

    public boolean deletarTabela() {

        return deleteTable(TABELA);
    }

}
