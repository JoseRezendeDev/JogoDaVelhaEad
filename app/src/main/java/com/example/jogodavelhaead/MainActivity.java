package com.example.jogodavelhaead;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.jogodavelhaead.model.JogoDaVelha;

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
    private JogoDaVelha jogoDaVelha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jogoDaVelha = new JogoDaVelha();

        imageView0 = findViewById(R.id.imageView0);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);

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

    class ImageListeners implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            ImageView img = (ImageView) v;

            img.setImageResource(R.drawable.xis);

            int jogadaVoceInt = -1;
            if (img.equals(imageView0))
                jogadaVoceInt = 0;
            else if (img.equals(imageView1))
                jogadaVoceInt = 1;
            else if (img.equals(imageView2))
                jogadaVoceInt = 2;
            else if (img.equals(imageView3))
                jogadaVoceInt = 3;
            else if (img.equals(imageView4))
                jogadaVoceInt = 4;
            else if (img.equals(imageView5))
                jogadaVoceInt = 5;
            else if (img.equals(imageView6))
                jogadaVoceInt = 6;
            else if (img.equals(imageView7))
                jogadaVoceInt = 7;
            else if (img.equals(imageView8))
                jogadaVoceInt = 8;

            jogoDaVelha.fazerJogadaVoce(jogadaVoceInt);
            int jogadaMaquinaInt = jogoDaVelha.fazerJogadaMaquina();

            switch (jogadaMaquinaInt) {
                case 0:
                    imageView0.setImageResource(R.drawable.circulo);
                case 1:
                    imageView1.setImageResource(R.drawable.circulo);
                case 2:
                    imageView2.setImageResource(R.drawable.circulo);
                case 3:
                    imageView3.setImageResource(R.drawable.circulo);
                case 4:
                    imageView4.setImageResource(R.drawable.circulo);
                case 5:
                    imageView5.setImageResource(R.drawable.circulo);
                case 6:
                    imageView6.setImageResource(R.drawable.circulo);
                case 7:
                    imageView7.setImageResource(R.drawable.circulo);
                case 8:
                    imageView8.setImageResource(R.drawable.circulo);
            }
        }
    }
}
