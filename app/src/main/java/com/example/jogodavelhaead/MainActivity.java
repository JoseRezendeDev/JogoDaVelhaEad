package com.example.jogodavelhaead;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jogodavelhaead.model.JogoDaVelha;
import com.example.jogodavelhaead.model.Posicao;
import com.example.jogodavelhaead.model.Simbolo;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView0;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;
    private ImageView imageView7;
    private ImageView imageView8;
    private TextView txtPontosVoce;
    private TextView txtPontosMaquina;
    private Button btnJogarNovamente;

    private JogoDaVelha jogoDaVelha;
    private int pontosVoce;
    private int pontosMaquina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView0 = findViewById(R.id.imageView0);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        txtPontosVoce = findViewById(R.id.pontosVoce);
        txtPontosMaquina = findViewById(R.id.pontosMaquina);
        btnJogarNovamente = findViewById(R.id.btnJogarNovamente);

        pontosVoce = 0;
        pontosMaquina = 0;

        jogarNovamente();

        habilitarListeners();

        btnJogarNovamente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogarNovamente();
            }
        });
    }

    public void atualizarJogo() {
        Posicao[] posicao = jogoDaVelha.getJogo();
        for (Posicao p: posicao){
            if (p.getSimbolo().equals(Simbolo.BRANCO))
                p.getImageView().setImageResource(android.R.color.white);
            else if (p.getSimbolo().equals(Simbolo.XIS))
                p.getImageView().setImageResource(R.drawable.xis);
            else if (p.getSimbolo().equals(Simbolo.CIRCULO))
                p.getImageView().setImageResource(R.drawable.circulo);
        }
    }

    public void habilitarListeners() {
        ImageListeners imgListeners = new ImageListeners();

        imageView0.setOnClickListener(imgListeners);
        imageView1.setOnClickListener(imgListeners);
        imageView2.setOnClickListener(imgListeners);
        imageView3.setOnClickListener(imgListeners);
        imageView4.setOnClickListener(imgListeners);
        imageView5.setOnClickListener(imgListeners);
        imageView6.setOnClickListener(imgListeners);
        imageView7.setOnClickListener(imgListeners);
        imageView8.setOnClickListener(imgListeners);
    }

    public void desabilitarListeners() {
        imageView0.setOnClickListener(null);
        imageView1.setOnClickListener(null);
        imageView2.setOnClickListener(null);
        imageView3.setOnClickListener(null);
        imageView4.setOnClickListener(null);
        imageView5.setOnClickListener(null);
        imageView6.setOnClickListener(null);
        imageView7.setOnClickListener(null);
        imageView8.setOnClickListener(null);
    }

    public Posicao verificarPosicaoClicada(ImageView img) {
        if (img.equals(imageView0))
            return jogoDaVelha.getJogo()[0];
        else if (img.equals(imageView1))
            return jogoDaVelha.getJogo()[1];
        else if (img.equals(imageView2))
            return jogoDaVelha.getJogo()[2];
        else if (img.equals(imageView3))
            return jogoDaVelha.getJogo()[3];
        else if (img.equals(imageView4))
            return jogoDaVelha.getJogo()[4];
        else if (img.equals(imageView5))
            return jogoDaVelha.getJogo()[5];
        else if (img.equals(imageView6))
            return jogoDaVelha.getJogo()[6];
        else if (img.equals(imageView7))
            return jogoDaVelha.getJogo()[7];
        else if (img.equals(imageView8))
            return jogoDaVelha.getJogo()[8];

        return null;
    }

    public void jogarNovamente() {
        jogoDaVelha = new JogoDaVelha(Arrays.asList(imageView0, imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8));

        for (Posicao p : jogoDaVelha.getJogo()) {
            p.getImageView().setImageResource(android.R.color.white);
        }

        habilitarListeners();
    }

    public void voceGanhou() {
        Toast.makeText(this, "VOCÊ GANHOU", Toast.LENGTH_SHORT).show();
        pontosVoce++;
        terminarJogo();
    }

    public void maquinaGanhou() {
        Toast.makeText(this, "VOCÊ PERDEU", Toast.LENGTH_SHORT).show();
        pontosMaquina++;
        terminarJogo();
    }

    public void terminarJogo() {
        desabilitarListeners();
        txtPontosVoce.setText(String.format("%d", pontosVoce));
        txtPontosMaquina.setText(String.format("%d", pontosMaquina));
    }

    class ImageListeners implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            ImageView img = (ImageView) v;

            Posicao posicaoJogadaVoce = verificarPosicaoClicada(img);
            if (jogoDaVelha.fazerJogadaVoce(posicaoJogadaVoce)) {
                atualizarJogo();
                Simbolo simbolo = jogoDaVelha.acabouJogo();
                if (simbolo == Simbolo.XIS) {
                    voceGanhou();
                    return;
                }
                jogoDaVelha.fazerJogadaMaquina();
                atualizarJogo();
                simbolo = jogoDaVelha.acabouJogo();
                if (simbolo == Simbolo.CIRCULO) {
                    maquinaGanhou();
                }
            }

            if (jogoDaVelha.tudoPreenchido()) {
                Toast.makeText(MainActivity.this, "EMPATOU", Toast.LENGTH_SHORT).show();
                terminarJogo();
            }
        }
    }
}
