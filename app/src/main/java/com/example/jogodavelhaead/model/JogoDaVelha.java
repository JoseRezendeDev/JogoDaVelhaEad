package com.example.jogodavelhaead.model;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JogoDaVelha {
    private Posicao[] jogo;
    private List<List<Integer>> listaJogadasQueVencem;

    public JogoDaVelha(List<ImageView> imgViews) {
        jogo = new Posicao[9];

        int i;
        for (i=0;i<9;i++) {
            jogo[i] = new Posicao(i, Simbolo.BRANCO, imgViews.get(i));
        }

        listaJogadasQueVencem = new ArrayList<>();
        listaJogadasQueVencem.add(Arrays.asList(0, 1, 2));
        listaJogadasQueVencem.add(Arrays.asList(3, 4, 5));
        listaJogadasQueVencem.add(Arrays.asList(6, 7, 8));
        listaJogadasQueVencem.add(Arrays.asList(0, 3, 6));
        listaJogadasQueVencem.add(Arrays.asList(1, 4, 7));
        listaJogadasQueVencem.add(Arrays.asList(2, 5, 8));
        listaJogadasQueVencem.add(Arrays.asList(0, 4, 8));
        listaJogadasQueVencem.add(Arrays.asList(2, 4, 6));
    }

    public boolean fazerJogadaVoce(Posicao posicao) {
        if (posicao.getSimbolo().equals(Simbolo.BRANCO)) {
            posicao.setSimbolo(Simbolo.XIS);
            return true;
        }
        return false;
    }

    public int fazerJogadaMaquina() {
        while (!tudoPreenchido()) {
            Random r = new Random();
            int jogadaMaquina = r.nextInt((8 - 0) + 1) + 0;
            if (jogo[jogadaMaquina].getSimbolo().equals(Simbolo.BRANCO)) {
                jogo[jogadaMaquina].setSimbolo(Simbolo.CIRCULO);
                return jogadaMaquina;
            }
        }

        return -1;
    }

    public boolean tudoPreenchido(){
        for (Posicao p: jogo) {
            if (p.getSimbolo().equals(Simbolo.BRANCO))
                return false;
        }
        return true;
    }

    public Simbolo acabouJogo() {
        Simbolo simbolo;
        for (List<Integer> lista: listaJogadasQueVencem) {
            simbolo = haVencedor(lista.get(0), lista.get(1), lista.get(2));
            if (simbolo != null)
                return simbolo;
        }
        return null;
    }

    public Simbolo haVencedor(Integer a, Integer b, Integer c) {
        if (jogo[a].getSimbolo() == Simbolo.XIS
                && jogo[a].getSimbolo() == jogo[b].getSimbolo()
                && jogo[a].getSimbolo() == jogo[c].getSimbolo())
            return Simbolo.XIS;
        else if (jogo[a].getSimbolo() == Simbolo.CIRCULO
                && jogo[a].getSimbolo() == jogo[b].getSimbolo()
                && jogo[a].getSimbolo() == jogo[c].getSimbolo())
            return Simbolo.CIRCULO;
        return null;
    }

    public Posicao[] getJogo() {
        return jogo;
    }
}
