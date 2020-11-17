package com.innovatesolutions.organizetorneios.model;

public class Jogador {

    private int id;
    private int equipeId;
    private String nome;
    private String numero;
    private int gols;
    private int cartaoAmarelo;
    private int cartaoVermelho;

    public Jogador() {
        this.id = id;
        this.equipeId = equipeId;
        this.nome = nome;
        this.numero = numero;
        this.gols = gols;
        this.cartaoAmarelo = cartaoAmarelo;
        this.cartaoVermelho = cartaoVermelho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEquipeId() {
        return equipeId;
    }

    public void setEquipeId(int equipeId) {
        this.equipeId = equipeId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    public int getCartaoAmarelo() {
        return cartaoAmarelo;
    }

    public void setCartaoAmarelo(int cartaoAmarelo) {
        this.cartaoAmarelo = cartaoAmarelo;
    }

    public int getCartaoVermelho() {
        return cartaoVermelho;
    }

    public void setCartaoVermelho(int cartaoVermelho) {
        this.cartaoVermelho = cartaoVermelho;
    }
}


