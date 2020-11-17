package com.innovatesolutions.organizetorneios.controller;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.Nullable;

import com.innovatesolutions.organizetorneios.api.AppDataBase;
import com.innovatesolutions.organizetorneios.datamodel.EquipeDataModel;
import com.innovatesolutions.organizetorneios.model.Equipe;

import java.util.ArrayList;
import java.util.List;

public class EquipeController extends AppDataBase {

    private static final String TABELA = EquipeDataModel.TABELA;
    private ContentValues dados;

    public EquipeController(@Nullable Context context) {
        super(context);
    }

    public boolean incluir(Equipe obj) {

        dados = new ContentValues();

        dados.put(EquipeDataModel.FK, obj.getGrupoID());
        dados.put(EquipeDataModel.NOME, obj.getNome());
        dados.put(EquipeDataModel.PONTOS, obj.getPontos());
        dados.put(EquipeDataModel.JOGOS, obj.getJogos());
        dados.put(EquipeDataModel.VITORIAS, obj.getVitorias());
        dados.put(EquipeDataModel.EMPATES, obj.getEmpates());
        dados.put(EquipeDataModel.DERROTAS, obj.getDerrotas());
        dados.put(EquipeDataModel.GOLS_PRO, obj.getGolsPro());
        dados.put(EquipeDataModel.GOLS_CONTRA, obj.getGolsContra());
        dados.put(EquipeDataModel.SALDO_GOLS, obj.getSaldoGols());

        return insertEquipe(TABELA, dados);
    }

    public boolean alterar(Equipe obj) {

        dados = new ContentValues();

        dados.put(EquipeDataModel.ID, obj.getId());
        dados.put(EquipeDataModel.FK, obj.getGrupoID());
        dados.put(EquipeDataModel.NOME, obj.getNome());
        dados.put(EquipeDataModel.PONTOS, obj.getPontos());
        dados.put(EquipeDataModel.JOGOS, obj.getJogos());
        dados.put(EquipeDataModel.VITORIAS, obj.getVitorias());
        dados.put(EquipeDataModel.EMPATES, obj.getEmpates());
        dados.put(EquipeDataModel.DERROTAS, obj.getDerrotas());
        dados.put(EquipeDataModel.GOLS_PRO, obj.getGolsPro());
        dados.put(EquipeDataModel.GOLS_CONTRA, obj.getGolsContra());
        dados.put(EquipeDataModel.SALDO_GOLS, obj.getSaldoGols());

        return updateEquipe(TABELA, dados);
    }

    public boolean deletar(Equipe obj) {

        return deleteEquipe(TABELA, obj.getId());
    }

    public List<Equipe> listar() {

        return listEquipe(TABELA);
    }

    public ArrayList<Equipe> listarTodasEquipes() {

        return listAllTeams(TABELA);
    }

    public int getUltimoID() {

        return getLastPK(TABELA);
    }

    public Equipe getEquipeByID(Equipe obj) {

        obj = getEquipeByID(EquipeDataModel.TABELA, obj);

        obj.setSaldoGols(obj.getGolsPro() - obj.getGolsContra());

        return obj;
    }

    public Equipe getEquipeByFK(int idFK) {

        return getEquipeByFK(EquipeDataModel.TABELA, idFK);
    }

    public boolean deletarTabela() {

        return deleteTable(TABELA);
    }

}
