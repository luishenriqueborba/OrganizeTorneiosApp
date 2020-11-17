package com.innovatesolutions.organizetorneios.controller;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.Nullable;

import com.innovatesolutions.organizetorneios.api.AppDataBase;
import com.innovatesolutions.organizetorneios.datamodel.GrupoDataModel;
import com.innovatesolutions.organizetorneios.model.Grupo;

import java.util.List;

public class GrupoController extends AppDataBase {

    private static final String TABELA = GrupoDataModel.TABELA;
    private ContentValues dados;

    public GrupoController(@Nullable Context context) {
        super(context);
    }

    public boolean incluir(Grupo obj) {

        dados = new ContentValues();

        dados.put(GrupoDataModel.NOME, obj.getNome());
        dados.put(GrupoDataModel.QTD_EQUIPES, obj.getQtdEquipes());
        dados.put(GrupoDataModel.PRIMEIRO, obj.getPrimeiro());
        dados.put(GrupoDataModel.SEGUNDO, obj.getSegundo());
        dados.put(GrupoDataModel.TERCEIRO, obj.getTerceiro());
        dados.put(GrupoDataModel.QUARTO, obj.getQuarto());

        return insertGrupo(TABELA, dados);
    }

    public boolean alterar(Grupo obj) {

        dados = new ContentValues();

        dados.put(GrupoDataModel.ID, obj.getId());
        dados.put(GrupoDataModel.NOME, obj.getNome());
        dados.put(GrupoDataModel.PRIMEIRO, obj.getPrimeiro());
        dados.put(GrupoDataModel.SEGUNDO, obj.getSegundo());
        dados.put(GrupoDataModel.TERCEIRO, obj.getTerceiro());
        dados.put(GrupoDataModel.QUARTO, obj.getQuarto());

        return updateGrupo(TABELA, dados);
    }

    public boolean deletar(Grupo obj) {

        return deleteGrupo(TABELA, obj.getId());
    }

    public List<Grupo> listar() {

        return listGrupo(TABELA);
    }

    public int getUltimoID() {

        return getLastPK(TABELA);
    }

    public Grupo getGrupoByID(Grupo obj) {

        return getGrupoByID(GrupoDataModel.TABELA, obj);
    }

    public boolean deletarTabela() {

        return deleteTable(TABELA);
    }
}
