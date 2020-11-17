package com.innovatesolutions.organizetorneios.datamodel;

public class JogadorDataModel {

    public static final String TABELA = "jogador";
    public static final String ID = "id";
    public static final String FK = "equipeId";
    public static final String NOME = "nome";
    public static final String NUMERO = "numero";
    public static final String GOLS = "gols";
    public static final String CARTAO_AMARELO = "cartao_amarelo";
    public static final String CARTAO_VERMELHO = "cartao_vermelho";
    private static final String DATA_INC = "datainc";
    private static final String DATA_ALT = "dataalt";

    private static String query;

    public static String gerarTabela() {

        query = "CREATE TABLE " + TABELA + " ( ";
        query += ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        query += FK + " INTEGER, ";
        query += NOME + " TEXT, ";
        query += NUMERO + " TEXT, ";
        query += GOLS + " INTEGER, ";
        query += CARTAO_AMARELO + " INTEGER, ";
        query += CARTAO_VERMELHO + " INTEGER, ";
        query += DATA_INC + " datetime default current_timestamp, ";
        query += DATA_ALT + " datetime default current_timestamp, ";
        query += "FOREIGN KEY(" + FK + ") REFERENCES equipe(id) ";
        query += ")";

        return query;
    }


}
