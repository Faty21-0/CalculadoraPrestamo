package com.tuusuario.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etMonto, etTasa, etMeses;
    private TextView tvResultado;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMonto = findViewById(R.id.etMonto);
        etTasa = findViewById(R.id.etTasa);
        etMeses = findViewById(R.id.etMeses);
        tvResultado = findViewById(R.id.tvResultado);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularPrestamo();
            }
        });
    }

    private void calcularPrestamo() {
        try {
            double monto = Double.parseDouble(etMonto.getText().toString());
            double tasaAnual = Double.parseDouble(etTasa.getText().toString());
            int meses = Integer.parseInt(etMeses.getText().toString());

            double tasaMensual = (tasaAnual / 100) / 12;
            double cuota = (monto * tasaMensual) / (1 - Math.pow(1 + tasaMensual, -meses));

            tvResultado.setText(String.format("Cuota mensual: %.2f", cuota));
        } catch (NumberFormatException e) {
            tvResultado.setText("Por favor, ingrese valores válidos.");
        }
    }
}
