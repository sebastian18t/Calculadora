package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView pantHistorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        pantHistorial= (TextView)findViewById(R.id.historial);
        String datos= getIntent().getStringExtra("opFinal");
        pantHistorial.setText("Ultima Operacion:"+datos); //TOMA LOS DATOS QUE LE ENVIA EL OTRO ACTIVITY Y LOS MUESTRA

    }
}
