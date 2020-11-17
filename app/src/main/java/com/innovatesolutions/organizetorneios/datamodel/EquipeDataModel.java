package com.innovatesolutions.organizetorneios.datamodel;

public class EquipeDataModel {

    public static final String TABELA = "equipe";
    public static final String ID = "id";
    public static final String FK = "grupoID";
    public static final String NOME = "nome";
    public static final String PONTOS = "pontos";
    public static final String JOGOS = "jogos";
    public static final String VITORIAS = "vitorias";
    public static final String EMPATES = "empates";
    public static final String DERROTAS = "derrotas";
    public static final String GOLS_PRO = "golsPro";
    public static final String GOLS_CONTRA = "golsContra";
    public static final String SALDO_GOLS = "saldoGols";
    private static final String DATA_INC = "datainc";
    private static final String DATA_ALT = "dataalt";

    private static String query;

    public static String gerarTabela() {

        query = "CREATE TABLE " + TABELA + " ( ";
        query += ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        query += FK + " INTEGER, ";
        query += NOME + " TEXT, ";
        query += PONTOS + " INTEGER, ";
        query += JOGOS + " INTEGER, ";
        query += VITORIAS + " INTEGER, ";
        query += EMPATES + " INTEGER, ";
        query += DERROTAS + " INTEGER, ";
        query += GOLS_PRO + " INTEGER, ";
        query += GOLS_CONTRA + " INTEGER, ";
        query += SALDO_GOLS + " INTEGER, ";
        query += DATA_INC + " datetime default current_timestamp, ";
        query += DATA_ALT + " datetime default current_timestamp, ";
        query += "FOREIGN KEY(" + FK + ") REFERENCES grupo(id) ";
        query += ")";

        return query;
    }


}
