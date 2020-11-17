package com.innovatesolutions.organizetorneios.datamodel;

public class GrupoDataModel {

    public static final String TABELA = "grupo";
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String QTD_EQUIPES = "qtdequipes";
    public static final String PRIMEIRO = "primeiro";
    public static final String SEGUNDO = "segundo";
    public static final String TERCEIRO = "terceiro";
    public static final String QUARTO = "quarto";
    private static final String DATA_INC = "datainc";
    private static final String DATA_ALT = "dataalt";

    private static String query;

    public static String gerarTabela() {

        query = "CREATE TABLE " + TABELA + " ( ";
        query += ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        query += NOME + " TEXT, ";
        query += QTD_EQUIPES + " TEXT, ";
        query += PRIMEIRO + " TEXT, ";
        query += SEGUNDO + " TEXT, ";
        query += TERCEIRO + " TEXT, ";
        query += QUARTO + " TEXT, ";
        query += DATA_INC + " datetime default current_timestamp, ";
        query += DATA_ALT + " datetime default current_timestamp ";
        query += ")";

        return query;
    }


}
