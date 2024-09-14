package com.example.menu;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class NumerosAleatorios extends AppCompatActivity {

    private EditText minRangeInput;
    private EditText maxRangeInput;
    private Button generateButton;
    private TextView randomNumberText;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeros_aleatorios);

        minRangeInput = findViewById(R.id.minRangeInput);
        maxRangeInput = findViewById(R.id.maxRangeInput);
        generateButton = findViewById(R.id.generateButton);
        randomNumberText = findViewById(R.id.randomNumberText);
        backButton = findViewById(R.id.backButton);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int minRange = Integer.parseInt(minRangeInput.getText().toString());
                    int maxRange = Integer.parseInt(maxRangeInput.getText().toString());
                    if (minRange < maxRange) {
                        Random random = new Random();
                        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
                        randomNumberText.setText(String.format("Número Aleatorio: %d", randomNumber));
                    } else {
                        randomNumberText.setText("El rango mínimo debe ser menor que el máximo.");
                    }
                } catch (NumberFormatException e) {
                    randomNumberText.setText("Por favor, ingresa valores válidos.");
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra la actividad y regresa a la anterior
            }
        });
    }
}