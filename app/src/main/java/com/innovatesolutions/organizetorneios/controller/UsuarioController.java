package com.innovatesolutions.organizetorneios.controller;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.Nullable;

import com.innovatesolutions.organizetorneios.api.AppDataBase;
import com.innovatesolutions.organizetorneios.datamodel.UsuarioDataModel;
import com.innovatesolutions.organizetorneios.model.Usuario;

import java.util.List;

public class UsuarioController extends AppDataBase {

    private static final String TABELA = UsuarioDataModel.TABELA;
    private ContentValues dados;

    public UsuarioController(@Nullable Context context) {
        super(context);
    }

    public boolean incluir(Usuario obj) {

        dados = new ContentValues();

        dados.put(UsuarioDataModel.NOME, obj.getNome());
        dados.put(UsuarioDataModel.EMAIL, obj.getEmail());
        dados.put(UsuarioDataModel.SENHA, obj.getSenha());

        return insertUsuario(TABELA, dados);
    }

    public boolean alterar(Usuario obj) {

        dados = new ContentValues();

        dados.put(UsuarioDataModel.ID, obj.getId());
        dados.put(UsuarioDataModel.NOME, obj.getNome());
        dados.put(UsuarioDataModel.EMAIL, obj.getEmail());
        dados.put(UsuarioDataModel.SENHA, obj.getSenha());

        return updateUsuario(TABELA, dados);
    }

    public boolean deletar(Usuario obj) {

        return deleteUsuario(TABELA, obj.getId());
    }

    public List<Usuario> listar() {

        return listUsuario(TABELA);
    }

    public int getUltimoID() {

        return getLastPK(TABELA);
    }

    public Usuario getUsuarioByID(Usuario obj) {

        obj = getUsuarioByID(UsuarioDataModel.TABELA, obj);


        return obj;
    }

}
