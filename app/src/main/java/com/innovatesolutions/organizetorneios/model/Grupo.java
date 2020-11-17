package com.innovatesolutions.organizetorneios.model;

public class Grupo {

    private int id;
    private String nome;
    private int qtdEquipes;
    private String primeiro;
    private String segundo;
    private String terceiro;
    private String quarto;
    private Equipe equipe1;
    private Equipe equipe2;
    private Equipe equipe3;
    private Equipe equipe4;

    public Grupo() {
        this.id = id;
        this.nome = nome;
        this.qtdEquipes = qtdEquipes;
        this.primeiro = primeiro;
        this.segundo = segundo;
        this.terceiro = terceiro;
        this.quarto = quarto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdEquipes() {
        return qtdEquipes;
    }

    public void setQtdEquipes(int qtdEquipes) {
        this.qtdEquipes = qtdEquipes;
    }

    public String getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(String primeiro) {
        this.primeiro = primeiro;
    }

    public String getSegundo() {
        return segundo;
    }

    public void setSegundo(String segundo) {
        this.segundo = segundo;
    }

    public String getTerceiro() {
        return terceiro;
    }

    public void setTerceiro(String terceiro) {
        this.terceiro = terceiro;
    }

    public String getQuarto() {
        return quarto;
    }

    public void setQuarto(String quarto) {
        this.quarto = quarto;
    }

    public Equipe getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(Equipe equipe1) {
        this.equipe1 = equipe1;
    }

    public Equipe getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(Equipe equipe2) {
        this.equipe2 = equipe2;
    }

    public Equipe getEquipe3() {
        return equipe3;
    }

    public void setEquipe3(Equipe equipe3) {
        this.equipe3 = equipe3;
    }

    public Equipe getEquipe4() {
        return equipe4;
    }

    public void setEquipe4(Equipe equipe4) {
        this.equipe4 = equipe4;
    }
}
