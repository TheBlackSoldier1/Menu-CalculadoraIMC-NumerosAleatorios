package com.example.menu;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CalculadoraIMC extends AppCompatActivity {

    private EditText pesoInput;
    private EditText alturaInput;
    private RadioGroup tipogenero;
    private RadioButton hombreRadio;
    private RadioButton mujerRadio;
    private Button calculateButton;
    private TextView resultadoTXT;
    private Button backButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_imc);

        // Inicializar los componentes
        pesoInput = findViewById(R.id.weightInput);
        alturaInput = findViewById(R.id.heightInput);
        tipogenero = findViewById(R.id.genderGroup);
        hombreRadio = findViewById(R.id.maleRadio);
        mujerRadio = findViewById(R.id.femaleRadio);
        calculateButton = findViewById(R.id.calculateButton);
        resultadoTXT = findViewById(R.id.resultText);
        backButton2 = findViewById(R.id.backButton2);

        // Calcular IMC
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateIMC();
            }
        });

        // Volver al menú anterior
        backButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra la actividad y regresa a la anterior
            }
        });
    }

    private void calculateIMC() {
        String pesoStr = pesoInput.getText().toString();
        String alturaStr = alturaInput.getText().toString();

        // Verificar que los campos no estén vacíos y que los valores sean válidos
        if (!pesoStr.isEmpty() && !alturaStr.isEmpty()) {
            try {
                double peso = Double.parseDouble(pesoStr);
                double altura = Double.parseDouble(alturaStr);

                // Verificar que los valores sean mayores que 0
                if (peso > 0 && altura > 0) {
                    double imc = peso / (altura * altura);

                    // Seleccionar el género
                    int selectedGender = tipogenero.getCheckedRadioButtonId();
                    String gender = "";
                    if (selectedGender == R.id.maleRadio) {
                        gender = "Hombre";
                    } else if (selectedGender == R.id.femaleRadio) {
                        gender = "Mujer";
                    }

                    // Estado según el IMC
                    String imcResult;
                    if (imc < 18.5) {
                        imcResult = "Bajo peso";
                    } else if (imc >= 18.5 && imc <= 24.9) {
                        imcResult = "Peso normal";
                    } else if (imc >= 25 && imc <= 29.9) {
                        imcResult = "Sobrepeso";
                    } else {
                        imcResult = "Obesidad";
                    }

                    // Mostrar el resultado
                    resultadoTXT.setText(String.format("%s, tu IMC es: %.2f (%s)", gender, imc, imcResult));
                } else {
                    resultadoTXT.setText("Por favor, introduce valores válidos de peso y altura.");
                }
            } catch (NumberFormatException e) {
                resultadoTXT.setText("Por favor, introduce valores numéricos válidos.");
            }
        } else {
            resultadoTXT.setText("Por favor, introduce peso y altura.");
        }
    }
}
