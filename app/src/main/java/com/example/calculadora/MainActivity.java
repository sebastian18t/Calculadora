package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnHistorial;
    public TextView mostrar;
    public double dig1, dig2, result;
    int operador;
    public String opFinal="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mostrar= (TextView)findViewById(R.id.caja);
        btnHistorial= (Button) findViewById(R.id.btnhistorial);

        btnHistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }

    public void  openActivity2() {
        Intent intent = new Intent( MainActivity.this, Main2Activity.class);
        intent.putExtra("opFinal", opFinal); //ENVIO DE LA ULTIMA OPERACION AL ACTIVITY
        startActivity(intent);

    }

    //PARA PODER ASIGNAR LOS NUMEROS
    public void btn1(View view){
        String aux= mostrar.getText().toString();
        aux= aux + "1";
        mostrar.setText(aux);
    }

    public void btn2(View view){
        String aux= mostrar.getText().toString();
        aux= aux + "2";
        mostrar.setText(aux);
    }

    public void btn3(View view){
        String aux= mostrar.getText().toString();
        aux= aux + "3";
        mostrar.setText(aux);
    }

    public void btn4 (View view){
        String aux= mostrar.getText().toString();
        aux= aux + "4";
        mostrar.setText(aux);
    }

    public void btn5(View view){
        String aux= mostrar.getText().toString();
        aux= aux + "5";
        mostrar.setText(aux);
    }
    public void btn6(View view){
        String aux= mostrar.getText().toString();
        aux= aux + "6";
        mostrar.setText(aux);
    }

    public void btn7(View view){
        String aux= mostrar.getText().toString();
        aux= aux + "7";
        mostrar.setText(aux);
    }

    public void btn8(View view){
        String aux= mostrar.getText().toString();
        aux= aux + "8";
        mostrar.setText(aux);
    }
    public void btn9(View view){
        String aux= mostrar.getText().toString();
        aux= aux + "9";
        mostrar.setText(aux);
    }

    public void btn0(View view){
        String aux= mostrar.getText().toString();
        aux= aux + "0";
        mostrar.setText(aux);
    }

    public void btnPunto(View view){
        String aux= mostrar.getText().toString();
        aux= aux + ".";
        mostrar.setText(aux);
    }

    ///OPERACIONES

    public void btnsuma (View view){
        String aux= mostrar.getText().toString();
        dig1=Double.parseDouble(aux);
        operador=1;
        mostrar.setText("");
    }
    public void btnresta (View view){
        String aux= mostrar.getText().toString();
        dig1=Double.parseDouble(aux);
        operador=2;
        mostrar.setText("");
    }
    public void btnmulti (View view){
        String aux= mostrar.getText().toString();
        dig1=Double.parseDouble(aux);
        operador=3;
        mostrar.setText("");
    }
    public void btndivi (View view){
        String aux= mostrar.getText().toString();
        dig1=Double.parseDouble(aux);
        operador=4;
        mostrar.setText("");
    }
    public void btnpoten (View view){
        String aux= mostrar.getText().toString();
        dig1=Double.parseDouble(aux);
        operador=5;
        mostrar.setText("");
    }
    public void btnraiz (View view){
        String aux= mostrar.getText().toString();
        dig1=Integer.valueOf(aux);
        operador=6;
        mostrar.setText("√("+dig1+")");
    }

    public void btnclean (View view){
        dig1=0;
        dig2=0;
        result=0;
        mostrar.setText("");
    }

    public void btnbrr (View view){
        String aux= mostrar.getText().toString();
        if(!aux.equals("")){
            aux= aux.substring(0,aux.length()-1);
            mostrar.setText(aux);
        }
    }

    public void btnigual (View view){
        String aux= mostrar.getText().toString();

        if(!aux.equals("")){
            if (operador != 6){
                dig2 = Double.parseDouble(aux);
            }

            switch (operador){
                case 1:

                    result= dig1+dig2;
                    aux = String.valueOf(result);
                    opFinal=String.valueOf(dig1)+" + "+ String.valueOf(dig2)+" = "+ String.valueOf(result);
                    mostrar.setText(aux);
                    break;
                case 2:

                    result= dig1-dig2;
                    aux = String.valueOf(result);
                    opFinal=String.valueOf(dig1)+" - "+ String.valueOf(dig2)+" = "+ String.valueOf(result);
                    mostrar.setText(aux);
                    break;
                case 3:
                    result= dig1*dig2;
                    aux = String.valueOf(result);
                    opFinal=String.valueOf(dig1)+" * "+ String.valueOf(dig2)+" = "+ String.valueOf(result);
                    mostrar.setText(aux);
                    break;
                case 4:
                    if (dig2 != 0){

                        result= dig1/dig2;
                        aux = String.valueOf(result);
                        opFinal=String.valueOf(dig1)+" / "+ String.valueOf(dig2)+" = "+ String.valueOf(result);
                        mostrar.setText(aux);

                    }else mostrar.setText("Indefinido");
                    break;
                case 5:

                    result=Math.pow(dig1, dig2) ;
                    aux = String.valueOf(result);
                    opFinal=String.valueOf(dig1)+"^"+ String.valueOf(dig2)+" = "+ String.valueOf(result);
                    mostrar.setText(aux);
                    break;
                case 6:

                    result= Math.sqrt(dig1);
                    aux = String.valueOf(result);
                    opFinal="√("+String.valueOf(dig1)+") = "+ String.valueOf(result);
                    mostrar.setText(aux);
                    break;
                default:
                    mostrar.setText("ERROR");
            }
        }
    }



}