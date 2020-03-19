package com.example.jogodavelhaead.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JogoDaVelha {
    private Posicao[] jogo;

    public JogoDaVelha() {
        jogo = new Posicao[9];

        int i;
        for (i=0;i<9;i++) {
            jogo[i] = new Posicao(i, Simbolo.BRANCO);
        }
    }

    public void fazerJogadaVoce(int i) {
        jogo[i] = new Posicao(i, Simbolo.XIS);
    }

    public int fazerJogadaMaquina() {
        Random r = new Random();
        int jogadaMaquina = r.nextInt((8 - 0) + 1) + 0;

        jogo[jogadaMaquina] = new Posicao(jogadaMaquina, Simbolo.CIRCULO);
        return jogadaMaquina;
    }
}
