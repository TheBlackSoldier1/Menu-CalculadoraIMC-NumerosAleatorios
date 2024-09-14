package com.example.menu;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    private Button btnRangoAleatorio;
    private Button btnCalculadoraIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu); // Asegúrate de que el nombre del archivo XML es activity_menu.xml

        // Inicializar los elementos de la interfaz
        btnRangoAleatorio = findViewById(R.id.btn_rango_aleatorio);
        btnCalculadoraIMC = findViewById(R.id.btn_calculadora_imc);

        // Configurar el botón "RangoAleatorioDeNumeros"
        btnRangoAleatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad de rango aleatorio
                Intent intent = new Intent(Menu.this, NumerosAleatorios.class);
                startActivity(intent);
            }
        });

        // Configurar el botón "Calculadora IMC"
        btnCalculadoraIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad de calculadora IMC
                Intent intent = new Intent(Menu.this, CalculadoraIMC.class);
                startActivity(intent);
            }
        });
    }
}
