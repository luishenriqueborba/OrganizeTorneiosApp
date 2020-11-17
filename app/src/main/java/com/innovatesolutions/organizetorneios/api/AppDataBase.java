package com.innovatesolutions.organizetorneios.api;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.innovatesolutions.organizetorneios.datamodel.EquipeDataModel;
import com.innovatesolutions.organizetorneios.datamodel.GrupoDataModel;
import com.innovatesolutions.organizetorneios.datamodel.JogadorDataModel;
import com.innovatesolutions.organizetorneios.datamodel.UsuarioDataModel;
import com.innovatesolutions.organizetorneios.model.Equipe;
import com.innovatesolutions.organizetorneios.model.Grupo;
import com.innovatesolutions.organizetorneios.model.Jogador;
import com.innovatesolutions.organizetorneios.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class AppDataBase extends SQLiteOpenHelper {

    private static final String DB_NAME = "torneioDB.sqlite";
    public static final int DB_VERSION = 1;

    Cursor cursor;

    SQLiteDatabase db;

    Context context;

    public AppDataBase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        this.context = context;

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Criar as tabelas

        //Usuário
        try {
            //Executar o que quero
            db.execSQL(UsuarioDataModel.gerarTabela());

            Log.i(AppUtil.LOG_APP1, "Tabela Usuario: " + UsuarioDataModel.gerarTabela());

        } catch (SQLException e) {
            //Capturar o erro
            Log.e(AppUtil.LOG_APP1, "Erro tabela Usuario" + e.getMessage());
        }

        //Equipe
        try {
            //Executar o que quero
            db.execSQL(EquipeDataModel.gerarTabela());

            Log.i(AppUtil.LOG_APP2, "Tabela Equipe: " + EquipeDataModel.gerarTabela());

        } catch (SQLException e) {
            //Capturar o erro
            Log.e(AppUtil.LOG_APP2, "Erro tabela Equipe" + e.getMessage());
        }

        //Grupo
        try {
            //Executar o que quero
            db.execSQL(GrupoDataModel.gerarTabela());

            Log.i(AppUtil.LOG_APP1, "Tabela Grupo: " + GrupoDataModel.gerarTabela());

        } catch (SQLException e) {
            //Capturar o erro
            Log.e(AppUtil.LOG_APP1, "Erro tabela Grupo" + e.getMessage());
        }

        //Jogador
        try {
            //Executar o que quero
            db.execSQL(JogadorDataModel.gerarTabela());

            Log.i(AppUtil.LOG_APP2, "Tabela Jogador: " + JogadorDataModel.gerarTabela());

        } catch (SQLException e) {
            //Capturar o erro
            Log.e(AppUtil.LOG_APP2, "Erro tabela Jogador" + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //Atualizar banco de dados
    }

    /**
     * Incluir dados no banco de dados
     *
     * @return
     */
    public boolean insertUsuario(String tabela, ContentValues dados) {

        boolean sucesso = true;

        try {
            Log.i(AppUtil.LOG_APP1, tabela + " insert() executado com sucesso.");
            sucesso = db.insert(tabela, null, dados) > 0;

        } catch (SQLException e) {
            Log.e(AppUtil.LOG_APP1, tabela + " falhou ao executar o insert(): " + e.getMessage());
        }

        return sucesso;
    }

    /**
     * Atualizar dados do banco de dados
     *
     * @return
     */
    public boolean updateUsuario(String tabela, ContentValues dados) {

        boolean sucesso = true;

        try {

            int id = dados.getAsInteger("id");

            Log.i(AppUtil.LOG_APP1, tabela + " update() executado com sucesso.");
            sucesso = db.update(tabela, dados, "id=?", new String[]{Integer.toString(id)}) > 0;

        } catch (SQLException e) {
            Log.e(AppUtil.LOG_APP1, tabela + " falhou ao executar o update(): " + e.getMessage());
        }

        return sucesso;
    }

    /**
     * Excluir dados do banco de dados
     *
     * @return
     */
    public boolean deleteUsuario(String tabela, int id) {

        boolean sucesso = true;

        try {
            Log.i(AppUtil.LOG_APP1, tabela + " delete() executado com sucesso.");
            sucesso = db.delete(tabela, "id=?", new String[]{Integer.toString(id)}) > 0;

        } catch (SQLException e) {
            Log.e(AppUtil.LOG_APP1, tabela + " falhou ao executar o delete(): " + e.getMessage());
        }

        return sucesso;
    }

    /**
     * Listar dados do banco de dados
     *
     * @return
     */
    public List<Usuario> listUsuario(String tabela) {

        List<Usuario> list = new ArrayList<>();

        Usuario usuario;

        //Select no DB

        String sql = "SELECT * FROM " + tabela;

        try {

            cursor = db.rawQuery(sql, null);

            if (cursor.moveToFirst()) {

                do {
                    usuario = new Usuario();

                    usuario.setId(cursor.getInt(cursor.getColumnIndex(UsuarioDataModel.ID)));
                    usuario.setNome(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.NOME)));
                    usuario.setEmail(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.EMAIL)));
                    usuario.setSenha(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.SENHA)));

                    list.add(usuario);

                } while (cursor.moveToNext());

                Log.i(AppUtil.LOG_APP1, tabela + " list() executado com sucesso.");
            }
        } catch (SQLException e) {

            Log.e(AppUtil.LOG_APP1, tabela + " falhou ao executar o list(): " + e.getMessage());
        }
        return list;
    }

    public Usuario getUsuarioByID(String tabela, Usuario obj) {

        Usuario usuario = new Usuario();

        String sql = "SELECT * FROM " + tabela + " WHERE id = " + obj.getId();

        try {

            cursor = db.rawQuery(sql, null);

            if (cursor.moveToNext()) {

                usuario.setNome(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.NOME)));
                usuario.setEmail(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.EMAIL)));
                usuario.setSenha(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.SENHA)));
            }

        } catch (SQLException e) {

            Log.e(AppUtil.LOG_APP1, "ERRO getUsuarioByID" + obj.getId());
            Log.e(AppUtil.LOG_APP1, "ERRO " + e.getMessage());
        }

        return usuario;
    }


    //Equipes

    /**
     * Incluir dados no banco de dados
     *
     * @return
     */
    public boolean insertEquipe(String tabela, ContentValues dados) {

        boolean sucesso = true;

        try {
            Log.i(AppUtil.LOG_APP2, tabela + " insert() executado com sucesso.");
            sucesso = db.insert(tabela, null, dados) > 0;

        } catch (SQLException e) {
            Log.e(AppUtil.LOG_APP2, tabela + " falhou ao executar o insert(): " + e.getMessage());
        }

        return sucesso;
    }

    /**
     * Atualizar dados do banco de dados
     *
     * @return
     */
    public boolean updateEquipe(String tabela, ContentValues dados) {

        boolean sucesso = true;

        try {

            int id = dados.getAsInteger("id");

            Log.i(AppUtil.LOG_APP2, tabela + " update() executado com sucesso.");
            sucesso = db.update(tabela, dados, "id=?", new String[]{Integer.toString(id)}) > 0;

        } catch (SQLException e) {
            Log.e(AppUtil.LOG_APP2, tabela + " falhou ao executar o update(): " + e.getMessage());
        }

        return sucesso;
    }

    /**
     * Excluir dados do banco de dados
     *
     * @return
     */
    public boolean deleteEquipe(String tabela, int id) {

        boolean sucesso = true;

        try {
            Log.i(AppUtil.LOG_APP2, tabela + " delete() executado com sucesso.");
            sucesso = db.delete(tabela, "id=?", new String[]{Integer.toString(id)}) > 0;

        } catch (SQLException e) {
            Log.e(AppUtil.LOG_APP2, tabela + " falhou ao executar o delete(): " + e.getMessage());
        }

        return sucesso;
    }

    /**
     * Listar dados do banco de dados
     *
     * @return
     */
    public List<Equipe> listEquipe(String tabela) {

        List<Equipe> list = new ArrayList<>();

        Equipe equipe;

        //Select no DB

        String sql = "SELECT * FROM " + tabela;

        try {

            cursor = db.rawQuery(sql, null);

            if (cursor.moveToFirst()) {

                do {
                    equipe = new Equipe();

                    equipe.setId(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.ID)));
                    equipe.setGrupoID(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.FK)));
                    equipe.setNome(cursor.getString(cursor.getColumnIndex(EquipeDataModel.NOME)));
                    equipe.setPontos(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.PONTOS)));
                    equipe.setJogos(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.JOGOS)));
                    equipe.setVitorias(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.VITORIAS)));
                    equipe.setEmpates(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.EMPATES)));
                    equipe.setDerrotas(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.DERROTAS)));
                    equipe.setGolsPro(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.GOLS_PRO)));
                    equipe.setGolsContra(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.GOLS_CONTRA)));
                    equipe.setSaldoGols(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.GOLS_PRO) - cursor.getColumnIndex(EquipeDataModel.GOLS_CONTRA)));

                    list.add(equipe);

                } while (cursor.moveToNext());

                Log.i(AppUtil.LOG_APP2, tabela + " list() executado com sucesso.");
            }
        } catch (SQLException e) {

            Log.e(AppUtil.LOG_APP2, tabela + " falhou ao executar o list(): " + e.getMessage());
        }
        return list;
    }

    public ArrayList<Equipe> listAllTeams(String tabela) {

        ArrayList<Equipe> list = new ArrayList<>();

        Equipe equipe;

        //Select no DB

        String sql = "SELECT * FROM " + tabela;

        try {

            cursor = db.rawQuery(sql, null);

            if (cursor.moveToFirst()) {

                do {
                    equipe = new Equipe();

                    equipe.setId(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.ID)));
                    equipe.setGrupoID(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.FK)));
                    equipe.setNome(cursor.getString(cursor.getColumnIndex(EquipeDataModel.NOME)));
                    equipe.setPontos(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.PONTOS)));
                    equipe.setJogos(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.JOGOS)));
                    equipe.setVitorias(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.VITORIAS)));
                    equipe.setEmpates(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.EMPATES)));
                    equipe.setDerrotas(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.DERROTAS)));
                    equipe.setGolsPro(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.GOLS_PRO)));
                    equipe.setGolsContra(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.GOLS_CONTRA)));

                    list.add(equipe);

                } while (cursor.moveToNext());

                Log.i(AppUtil.LOG_APP2, tabela + " listAllTeams() executado com sucesso.");
            }
        } catch (SQLException e) {

            Log.e(AppUtil.LOG_APP2, tabela + " falhou ao executar o listAllTeams(): " + e.getMessage());
        }

        cursor.close();

        return list;
    }

    public Equipe getEquipeByID(String tabela, Equipe obj) {

        Equipe equipe = new Equipe();

        String sql = "SELECT * FROM " + tabela + " WHERE id = " + obj.getId();

        try {

            cursor = db.rawQuery(sql, null);

            if (cursor.moveToNext()) {

                equipe.setNome(cursor.getString(cursor.getColumnIndex(EquipeDataModel.NOME)));
                equipe.setPontos(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.PONTOS)));
                equipe.setJogos(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.JOGOS)));
                equipe.setVitorias(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.VITORIAS)));
                equipe.setEmpates(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.EMPATES)));
                equipe.setDerrotas(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.DERROTAS)));
                equipe.setGolsPro(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.GOLS_PRO)));
                equipe.setGolsContra(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.GOLS_CONTRA)));

            }

        } catch (SQLException e) {

            Log.e(AppUtil.LOG_APP2, "ERRO getEquipeByID" + obj.getId());
            Log.e(AppUtil.LOG_APP2, "ERRO " + e.getMessage());
        }

        return equipe;
    }


    //Grupos

    /**
     * Incluir dados no banco de dados
     *
     * @return
     */
    public boolean insertGrupo(String tabela, ContentValues dados) {

        boolean sucesso = true;

        try {
            Log.i(AppUtil.LOG_APP3, tabela + " insert() executado com sucesso.");
            sucesso = db.insert(tabela, null, dados) > 0;

        } catch (SQLException e) {
            Log.e(AppUtil.LOG_APP3, tabela + " falhou ao executar o insert(): " + e.getMessage());
        }

        return sucesso;
    }

    /**
     * Atualizar dados do banco de dados
     *
     * @return
     */
    public boolean updateGrupo(String tabela, ContentValues dados) {

        boolean sucesso = true;

        try {

            int id = dados.getAsInteger("id");

            Log.i(AppUtil.LOG_APP3, tabela + " update() executado com sucesso.");
            sucesso = db.update(tabela, dados, "id=?", new String[]{Integer.toString(id)}) > 0;

        } catch (SQLException e) {
            Log.e(AppUtil.LOG_APP3, tabela + " falhou ao executar o update(): " + e.getMessage());
        }

        return sucesso;
    }

    /**
     * Excluir dados do banco de dados
     *
     * @return
     */
    public boolean deleteGrupo(String tabela, int id) {

        boolean sucesso = true;

        try {
            Log.i(AppUtil.LOG_APP3, tabela + " delete() executado com sucesso.");
            sucesso = db.delete(tabela, "id=?", new String[]{Integer.toString(id)}) > 0;

        } catch (SQLException e) {
            Log.e(AppUtil.LOG_APP3, tabela + " falhou ao executar o delete(): " + e.getMessage());
        }

        return sucesso;
    }

    /**
     * Listar dados do banco de dados
     *
     * @return
     */
    public List<Grupo> listGrupo(String tabela) {

        List<Grupo> list = new ArrayList<>();

        Grupo grupo;

        //Select no DB

        String sql = "SELECT * FROM " + tabela;

        try {

            cursor = db.rawQuery(sql, null);

            if (cursor.moveToFirst()) {

                do {
                    grupo = new Grupo();

                    grupo.setId(cursor.getInt(cursor.getColumnIndex(GrupoDataModel.ID)));
                    grupo.setNome(cursor.getString(cursor.getColumnIndex(GrupoDataModel.NOME)));
                    grupo.setQtdEquipes(cursor.getInt(cursor.getColumnIndex(GrupoDataModel.QTD_EQUIPES)));
                    grupo.setPrimeiro(cursor.getString(cursor.getColumnIndex(GrupoDataModel.PRIMEIRO)));
                    grupo.setSegundo(cursor.getString(cursor.getColumnIndex(GrupoDataModel.SEGUNDO)));
                    grupo.setTerceiro(cursor.getString(cursor.getColumnIndex(GrupoDataModel.TERCEIRO)));
                    grupo.setQuarto(cursor.getString(cursor.getColumnIndex(GrupoDataModel.QUARTO)));

                    list.add(grupo);

                } while (cursor.moveToNext());

                Log.i(AppUtil.LOG_APP3, tabela + " list() executado com sucesso.");
            }
        } catch (SQLException e) {

            Log.e(AppUtil.LOG_APP3, tabela + " falhou ao executar o list(): " + e.getMessage());
        }
        return list;
    }

    public int getLastPK(String tabela) {

        String sql = "SELECT seq FROM sqlite_sequence WHERE name = '" + tabela + "'";

        try {

            cursor = db.rawQuery(sql, null);

            if (cursor.moveToFirst()) {

                do {

                    return cursor.getInt(cursor.getColumnIndex("seq"));


                } while (cursor.moveToNext());

            }
        } catch (SQLException e) {

            Log.e(AppUtil.LOG_APP1, tabela + " falhou ao recuperar ultimo ID: " + e.getMessage());
        }
        return -1;
    }

    public Grupo getGrupoByID(String tabela, Grupo obj) {

        Grupo grupo = new Grupo();

        int id = obj.getId();

        String sql = "SELECT * FROM " + tabela + " WHERE id = " + id;

        try {

            cursor = db.rawQuery(sql, null);

            if (cursor.moveToNext()) {

                grupo.setNome(cursor.getString(cursor.getColumnIndex(GrupoDataModel.NOME)));

            }

        } catch (SQLException e) {

            Log.e(AppUtil.LOG_APP2, "ERRO getGrupoByID" + obj.getId());
            Log.e(AppUtil.LOG_APP2, "ERRO " + e.getMessage());
        }

        return grupo;
    }


    public Equipe getEquipeByFK(String tabela, int idFK) {

        Equipe equipe = new Equipe();

        String sql = "SELECT * FROM " + tabela + " WHERE grupoID = " + idFK;

        try {

            cursor = db.rawQuery(sql, null);

            if (cursor.moveToNext()) {

                equipe.setId(cursor.getInt(cursor.getColumnIndex(EquipeDataModel.ID)));
                equipe.setNome(cursor.getString(cursor.getColumnIndex(GrupoDataModel.NOME)));

            }

        } catch (SQLException e) {

            Log.e(AppUtil.LOG_APP2, "ERRO getEquipeByFK" + idFK);
            Log.e(AppUtil.LOG_APP2, "ERRO " + e.getMessage());
        }

        return equipe;
    }

    //Jogador

    public boolean insertJogador(String tabela, ContentValues dados) {

        boolean sucesso = true;

        try {
            Log.i(AppUtil.LOG_APP3, tabela + " insert() executado com sucesso.");
            sucesso = db.insert(tabela, null, dados) > 0;

        } catch (SQLException e) {
            Log.e(AppUtil.LOG_APP3, tabela + " falhou ao executar o insert(): " + e.getMessage());
        }

        return sucesso;
    }

    /**
     * Atualizar dados do banco de dados
     *
     * @return
     */
    public boolean updateJogador(String tabela, ContentValues dados) {

        boolean sucesso = true;

        try {

            int id = dados.getAsInteger("id");

            Log.i(AppUtil.LOG_APP4, tabela + " update() executado com sucesso.");
            sucesso = db.update(tabela, dados, "id=?", new String[]{Integer.toString(id)}) > 0;

        } catch (SQLException e) {
            Log.e(AppUtil.LOG_APP4, tabela + " falhou ao executar o update(): " + e.getMessage());
        }

        return sucesso;
    }

    /**
     * Excluir dados do banco de dados
     *
     * @return
     */
    public boolean deleteJogador(String tabela, int id) {

        boolean sucesso = true;

        try {
            Log.i(AppUtil.LOG_APP4, tabela + " delete() executado com sucesso.");
            sucesso = db.delete(tabela, "id=?", new String[]{Integer.toString(id)}) > 0;

        } catch (SQLException e) {
            Log.e(AppUtil.LOG_APP4, tabela + " falhou ao executar o delete(): " + e.getMessage());
        }

        return sucesso;
    }

    /**
     * Listar dados do banco de dados
     *
     * @return
     */
    public List<Jogador> listJogador(String tabela) {

        List<Jogador> list = new ArrayList<>();

        Jogador jogador;

        //Select no DB

        String sql = "SELECT * FROM " + tabela;

        try {

            cursor = db.rawQuery(sql, null);

            if (cursor.moveToFirst()) {

                do {
                    jogador = new Jogador();

                    jogador.setId(cursor.getInt(cursor.getColumnIndex(JogadorDataModel.ID)));
                    jogador.setEquipeId(cursor.getInt(cursor.getColumnIndex(JogadorDataModel.FK)));
                    jogador.setNome(cursor.getString(cursor.getColumnIndex(JogadorDataModel.NOME)));
                    jogador.setNumero(cursor.getString(cursor.getColumnIndex(JogadorDataModel.NUMERO)));
                    jogador.setGols(cursor.getInt(cursor.getColumnIndex(JogadorDataModel.GOLS)));
                    jogador.setCartaoAmarelo(cursor.getInt(cursor.getColumnIndex(JogadorDataModel.CARTAO_AMARELO)));
                    jogador.setCartaoVermelho(cursor.getInt(cursor.getColumnIndex(JogadorDataModel.CARTAO_VERMELHO)));

                    list.add(jogador);

                } while (cursor.moveToNext());

                Log.i(AppUtil.LOG_APP4, tabela + " list() executado com sucesso.");
            }
        } catch (SQLException e) {

            Log.e(AppUtil.LOG_APP4, tabela + " falhou ao executar o list(): " + e.getMessage());
        }
        return list;
    }

    public ArrayList<Jogador> listAllPlayers(String tabela) {

        ArrayList<Jogador> list = new ArrayList<>();

        Jogador jogador;

        //Select no DB

        String sql = "SELECT * FROM " + tabela + " ORDER BY " + JogadorDataModel.GOLS + " DESC";

        try {

            cursor = db.rawQuery(sql, null);

            if (cursor.moveToFirst()) {

                do {
                    jogador = new Jogador();

                    jogador.setId(cursor.getInt(cursor.getColumnIndex(JogadorDataModel.ID)));
                    jogador.setEquipeId(cursor.getInt(cursor.getColumnIndex(JogadorDataModel.FK)));
                    jogador.setNome(cursor.getString(cursor.getColumnIndex(JogadorDataModel.NOME)));
                    jogador.setNumero(cursor.getString(cursor.getColumnIndex(JogadorDataModel.NUMERO)));
                    jogador.setGols(cursor.getInt(cursor.getColumnIndex(JogadorDataModel.GOLS)));
                    jogador.setCartaoAmarelo(cursor.getInt(cursor.getColumnIndex(JogadorDataModel.CARTAO_AMARELO)));
                    jogador.setCartaoVermelho(cursor.getInt(cursor.getColumnIndex(JogadorDataModel.CARTAO_VERMELHO)));

                    list.add(jogador);

                } while (cursor.moveToNext());

                Log.i(AppUtil.LOG_APP4, tabela + " listAllPlayers() executado com sucesso.");
            }
        } catch (SQLException e) {

            Log.e(AppUtil.LOG_APP4, tabela + " falhou ao executar o listAllPlayers(): " + e.getMessage());
        }

        cursor.close();

        return list;
    }

    public Jogador getJogadorByID(String tabela, Jogador obj) {

        Jogador jogador = new Jogador();

        String sql = "SELECT * FROM " + tabela + " WHERE id = " + obj.getId();

        try {

            cursor = db.rawQuery(sql, null);

            if (cursor.moveToNext()) {

                jogador.setEquipeId(cursor.getInt(cursor.getColumnIndex(JogadorDataModel.FK)));
                jogador.setNome(cursor.getString(cursor.getColumnIndex(JogadorDataModel.NOME)));
                jogador.setNumero(cursor.getString(cursor.getColumnIndex(JogadorDataModel.NUMERO)));
                jogador.setGols(cursor.getInt(cursor.getColumnIndex(JogadorDataModel.GOLS)));
                jogador.setCartaoAmarelo(cursor.getInt(cursor.getColumnIndex(JogadorDataModel.CARTAO_AMARELO)));
                jogador.setCartaoVermelho(cursor.getInt(cursor.getColumnIndex(JogadorDataModel.CARTAO_VERMELHO)));
            }

        } catch (SQLException e) {

            Log.e(AppUtil.LOG_APP4, "ERRO getJogadorByID" + obj.getId());
            Log.e(AppUtil.LOG_APP4, "ERRO " + e.getMessage());
        }

        return jogador;
    }

    //Deletar tabela
    public boolean deleteTable(String tabela) {

        boolean sucesso = true;

        db.execSQL("drop table if exists " + tabela + ";");

        return sucesso;
    }

}


