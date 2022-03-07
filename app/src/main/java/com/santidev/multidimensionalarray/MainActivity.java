package com.santidev.multidimensionalarray;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Generar numeros aleatorios
    Random randInt = new Random();
    //Variable para conocer el identificador de la pregunta seleccionada
    int questionNumber = -1;

    String [][] countriesAndCapitals;

    TextView textViewQuestion;

    //variables para saber la posicion q tiene el pais, y cual tiene la capital
    final int COUNTRY = 0;
    final byte CAPITAL  = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicializamos el arrar de paises y capitales con
        // 5 arrays de 2 elementos cada uno
        //cada array tendra pais en primera posicion y capital en la segunda
        this.countriesAndCapitals = new String[5][2];

        //cargamos 5 paises con sus respectivas capitales
        countriesAndCapitals[0][this.COUNTRY] = "España";
        countriesAndCapitals[0][this.CAPITAL] = "Madrid";

        countriesAndCapitals[1][this.COUNTRY] = "Francia";
        countriesAndCapitals[1][this.CAPITAL] = "Paris";

        countriesAndCapitals[2][this.COUNTRY] = "Reino Unido";
        countriesAndCapitals[2][this.CAPITAL] = "Londres";

        countriesAndCapitals[3][this.COUNTRY] = "Italia";
        countriesAndCapitals[3][this.CAPITAL] = "Roma";

        countriesAndCapitals[4][this.COUNTRY] = "Alemania";
        countriesAndCapitals[4][this.CAPITAL] = "Berlin";

        textViewQuestion = (TextView) findViewById(R.id.textViewQuestion);


    }

    public void nextQuestion(View view){
        int nextQuestion = questionNumber;
        while (nextQuestion == questionNumber){
            nextQuestion = this.randInt.nextInt(this.countriesAndCapitals.length);
        }
        questionNumber= nextQuestion;

        String countryName = this.countriesAndCapitals[questionNumber][COUNTRY];
        String capitalName = this.countriesAndCapitals[questionNumber][CAPITAL];

        this.textViewQuestion.setText("La capital de " + countryName + " es " + capitalName);

    }
}