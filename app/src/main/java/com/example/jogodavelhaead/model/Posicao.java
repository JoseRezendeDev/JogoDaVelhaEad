package com.example.jogodavelhaead.model;

public class Posicao {
    private int id;
    private Simbolo simbolo;

    public Posicao(int id, Simbolo simbolo) {
        this.id = id;
        this.simbolo = simbolo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Simbolo getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(Simbolo simbolo) {
        this.simbolo = simbolo;
    }
}
