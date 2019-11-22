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
    public String dig1="", dig2="", aux="",opFinal="", display="";
    public Double result;
    int operador=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mostrar= (TextView)findViewById(R.id.caja);
        btnHistorial= (Button) findViewById(R.id.btnhistorial);

        btnHistorial.setOnClickListener(new View.OnClickListener() { //ESCUCHA DEL BOTON HISTORIAL
            @Override
            public void onClick(View v) {
                openActivity2(); //AL PRESIONAR EL BOTON HISTORIAL, ACTIVA EL INTENT
            }
        });
    }

   ///LLAMADO AL ACTIVITY
    public void  openActivity2() {
        Intent intent = new Intent( MainActivity.this, Main2Activity.class);
        intent.putExtra("opFinal", opFinal); //ENVIO DE LA ULTIMA OPERACION AL ACTIVITY
        startActivity(intent);

    }

    //TOMAR EL VALOR DE LOS BOTONES Y CONCATENARLO EN UNA VARIABLE
    public void numerador(View v){
        Button b = (Button) v;
        String valor = b.getText().toString();

        if(operador !=  0){
            dig2=dig2+valor;
            display=display+valor; //DISPLAY MUESTRA EN PANTALLA LA OPERACION QUE SE ESTA HACIENDO
            mostrar.setText(display);
        }else{

            dig1=dig1+valor;
            mostrar.setText(dig1);
        }

    }

    ///OPERADORES
    public void btnSuma (View view){
        if (!dig1.equals("")){
            operador=1;
            display=dig1+" + ";
            mostrar.setText(display);
        }

    }
    public void btnResta (View view){
        if (!dig1.equals("")){
            operador=2;
            display=dig1+" - ";
            mostrar.setText(display);
        }

    }
    public void btnMulti (View view){
        if (!dig1.equals("")){
            operador=3;
            display=dig1+" * ";
            mostrar.setText(display);
        }

    }
    public void btnDivi (View view){
        if (!dig1.equals("")){
            operador=4;
            display=dig1+" / ";
            mostrar.setText(display);
        }

    }
    public void btnPoten (View view){
        if (!dig1.equals("")){
            operador=5;
            display=dig1+" ^ ";
            mostrar.setText(display);
        }

    }
    public void btnRaiz (View view){
        if (!dig1.equals("")){
            operador=6;
            mostrar.setText("√("+dig1+")");
        }

    }

    public void btnClean (View view){ //Limpia todos los valores de la calculadora
        dig1="";
        dig2="";
        result=0.0;
        operador=0;
        mostrar.setText("");
    }

    public void btnBrr (View view){ //BORRA UNO A UNO LOS NUMEROS QUE SE HAYAN INSERTADO

            if (!dig2.equals("") && dig2 != null){
                dig2= dig2.substring(0,dig2.length()-1);

                if (dig2.equals("")){
                    switch (operador){
                        case 1:
                            display=dig1+" + ";
                            mostrar.setText(display);
                            break;
                        case 2:
                            display=dig1+" - ";
                            mostrar.setText(display);
                            break;
                        case 3:
                            display=dig1+" * ";
                            mostrar.setText(display);
                            break;
                        case 4:
                            display=dig1+" / ";
                            mostrar.setText(display);
                            break;
                        case 5:
                            display=dig1+" ^ ";
                            mostrar.setText(display);
                            break;
                        case 6:
                            display = "√("+dig1+")";
                            mostrar.setText(display);
                            break;
                    }

                }else{
                    switch (operador){
                        case 1:
                            display=dig1+" + "+dig2;
                            mostrar.setText(display);
                            break;
                        case 2:
                            display=dig1+" - "+dig2;
                            mostrar.setText(display);
                            break;
                        case 3:
                            display=dig1+" * "+dig2;
                            mostrar.setText(display);
                            break;
                        case 4:
                            display=dig1+" / "+dig2;
                            mostrar.setText(display);
                            break;
                        case 5:
                            display=dig1+" ^ "+dig2;
                            mostrar.setText(display);
                            break;
                    }
                }

            }else if(operador != 0){

                operador=0;
                mostrar.setText(dig1);
            }else if (!dig1.equals("")&& dig2 != null){

                dig1= dig1.substring(0,dig1.length()-1);
                mostrar.setText(dig1);
            }
    }

    public void btnIgual (View view){ //REALIZA LA OPERACION MATEMATICA  Y LA MUESTRA EN PANTALLA

        if(dig1 != "" &&  operador != 0 && dig2 != ""){

            switch (operador){
                case 1:

                    result= Double.parseDouble(dig1)+ Double.parseDouble(dig2);
                    aux = String.valueOf(result);
                    opFinal=dig1+" + "+ dig2+" = "+ String.valueOf(result);
                    mostrar.setText(opFinal);
                    dig1=String.valueOf(result);
                    dig2="";
                    break;
                case 2:

                    result= Double.parseDouble(dig1) - Double.parseDouble(dig2);
                    aux = String.valueOf(result);
                    opFinal=dig1+" - "+ dig2+" = "+ String.valueOf(result);
                    mostrar.setText(opFinal);
                    dig1=String.valueOf(result);
                    dig2="";
                    break;
                case 3:

                    result= Double.parseDouble(dig1) * Double.parseDouble(dig2);
                    aux = String.valueOf(result);
                    opFinal=dig1+" * "+ dig2+" = "+ String.valueOf(result);
                    mostrar.setText(opFinal);
                    dig1=String.valueOf(result);
                    dig2="";
                    break;
                case 4:

                    if (!dig2.equals("0")){

                        result= Double.parseDouble(dig1) / Double.parseDouble(dig2);
                        aux = String.valueOf(result);
                        opFinal=dig1+" / "+ dig2+" = "+ String.valueOf(result);
                        mostrar.setText(opFinal);
                        dig1=String.valueOf(result);
                        dig2="";

                    }else{ mostrar.setText("Infinito");}
                    break;
                case 5:

                    result= Math.pow(Double.parseDouble(dig1), Double.parseDouble(dig2)) ;
                    aux = String.valueOf(result);
                    opFinal=dig1+" ^ "+ dig2+" = "+ String.valueOf(result);
                    mostrar.setText(opFinal);
                    dig1=String.valueOf(result);
                    dig2="";
                    break;
                default:
                    mostrar.setText("ERROR");
            }
        }else if (!dig1.equals("") &&  operador == 6){

                result= Math.sqrt(Double.parseDouble(dig1));
                aux = String.valueOf(result);
                opFinal="√("+dig1+") = "+ String.valueOf(result);
                mostrar.setText(opFinal);
                dig1=String.valueOf(result);
                dig2="";
        }
    }

}