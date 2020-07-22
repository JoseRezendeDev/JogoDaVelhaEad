package com.example.jogodavelhaead.model;

import android.widget.ImageView;

public class Posicao {
    private int id;
    private Simbolo simbolo;
    private ImageView imageView;

    public Posicao(int id, Simbolo simbolo, ImageView imageView) {
        this.id = id;
        this.simbolo = simbolo;
        this.imageView = imageView;
    }

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

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}
