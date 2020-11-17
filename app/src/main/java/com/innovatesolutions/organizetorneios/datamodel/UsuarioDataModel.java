package com.innovatesolutions.organizetorneios.datamodel;

public class UsuarioDataModel {

    public static final String TABELA = "usuario";
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String EMAIL = "email";
    public static final String SENHA = "senha";
    private static final String DATA_INC = "datainc";
    private static final String DATA_ALT = "dataalt";

    private static String query;

    public static String gerarTabela() {

        query = "CREATE TABLE " + TABELA + " ( ";
        query += ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        query += NOME + " TEXT, ";
        query += EMAIL + " TEXT, ";
        query += SENHA + " TEXT, ";
        query += DATA_INC + " datetime default current_timestamp, ";
        query += DATA_ALT + " datetime default current_timestamp ";
        query += ")";

        return query;
    }
}
