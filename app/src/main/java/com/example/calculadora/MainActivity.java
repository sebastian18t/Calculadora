package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button btnHistorial;
    public TextView pantalla;
    public String dig1="", dig2="",opFinal="", mostrar="", aux="";
    public Double result;
    public DecimalFormat format = new DecimalFormat("#.###");
    int operador=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       pantalla= (TextView)findViewById(R.id.caja);
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
        String valor = b.getText().toString() ;

        if(operador !=  0){
            dig2=dig2+valor;
           mostrar=mostrar+valor; //DISPLAY MUESTRA EN PANTALLA LA OPERACION QUE SE ESTA HACIENDO
           pantalla.setText(mostrar);
        }else{

            dig1=dig1+valor;
           pantalla.setText(dig1);
        }

    }

    ///OPERADORES
    public void operacion (View view){
        Button b = (Button) view;
        String valor = b.getText().toString() ;

        if (!dig1.equals("")){

            switch (valor){
                case "+":
                    operador=1;
                   mostrar=dig1+" + ";
                   pantalla.setText(mostrar);
                    break;
                case "-":
                    operador=2;
                   mostrar=dig1+" - ";
                    pantalla.setText(mostrar);
                    break;
                case "*":
                    operador=3;
                   mostrar=dig1+" * ";
                    pantalla.setText(mostrar);
                    break;
                case "/":
                    operador=4;
                   mostrar=dig1+" / ";
                    pantalla.setText(mostrar);
                    break;
                case "x^":
                    operador=5;
                   mostrar=dig1+" ^ ";
                    pantalla.setText(mostrar);
                    break;
                case "√":
                    operador=6;
                   pantalla.setText("√("+dig1+")");
                    break;
            }
        }
    }

    public void btnClean (View view){ //Limpia todos los valores de la calculadora
        dig1="";
        dig2="";
        result=0.0;
        operador=0;
       pantalla.setText("");
    }

    public void btnBrr (View view){ //BORRA UNO A UNO LOS NUMEROS QUE SE HAYAN INSERTADO

            if (!dig2.equals("") && dig2 != null){
                dig2= dig2.substring(0,dig2.length()-1); //ELIMINA EL ULTIMO ELEMENTO DEL ARREGLO.

                if (dig2.equals("")){
                    switch (operador){
                        case 1:
                           mostrar=dig1+" + ";
                            pantalla.setText(mostrar);
                            break;
                        case 2:
                           mostrar=dig1+" - ";
                            pantalla.setText(mostrar);
                            break;
                        case 3:
                           mostrar=dig1+" * ";
                            pantalla.setText(mostrar);
                            break;
                        case 4:
                           mostrar=dig1+" / ";
                            pantalla.setText(mostrar);
                            break;
                        case 5:
                           mostrar=dig1+" ^ ";
                            pantalla.setText(mostrar);
                            break;
                        case 6:
                           mostrar = "√("+dig1+")";
                            pantalla.setText(mostrar);
                            break;
                    }

                }else{
                    switch (operador){
                        case 1:
                           mostrar=dig1+" + "+dig2;
                            pantalla.setText(mostrar);
                            break;
                        case 2:
                           mostrar=dig1+" - "+dig2;
                            pantalla.setText(mostrar);
                            break;
                        case 3:
                           mostrar=dig1+" * "+dig2;
                            pantalla.setText(mostrar);
                            break;
                        case 4:
                           mostrar=dig1+" / "+dig2;
                            pantalla.setText(mostrar);
                            break;
                        case 5:
                           mostrar=dig1+" ^ "+dig2;
                            pantalla.setText(mostrar);
                            break;
                    }
                }

            }else if(operador != 0){

                operador=0;
               pantalla.setText(dig1);
            }else if (!dig1.equals("")&& dig2 != null){

                dig1= dig1.substring(0,dig1.length()-1);
               pantalla.setText(dig1);
            }
    }

    public void btnIgual (View view){ //REALIZA LA OPERACION MATEMATICA  Y LA MUESTRA EN PANTALLA

        if(dig1 != "" &&  operador != 0 && dig2 != ""){

            switch (operador){
                case 1: //SUMA

                    result=Double.parseDouble(dig1)+ Double.parseDouble(dig2);
                    aux =format.format(result);  //CONTIENE EL VALOR RESULTANTE DE LA OPERACION
                    opFinal=dig1+" + "+ dig2+" = "+ aux;  //CONTIENE LA ECUACION FINAL MAS SU RESULTADO, ESTO ES PARA ENVIAR AL HISTORIAL
                    pantalla.setText(opFinal);
                    dig1=aux; //SE AÑADE EL VALOR DEL RESULTADO AL DIG1 PARA PODER CONTINUAR REALIZANDO OPERACIONES
                    dig2="";
                    break;
                case 2://RESTA

                    result= Double.parseDouble(dig1) - Double.parseDouble(dig2);
                    aux =format.format(result);
                    opFinal=dig1+" - "+ dig2+" = "+ aux;
                    pantalla.setText(opFinal);
                    dig1=aux;
                    dig2="";
                    break;
                case 3: //MULTIPLICACION

                    result= Double.parseDouble(dig1) * Double.parseDouble(dig2);
                    aux =format.format(result);
                    opFinal=dig1+" * "+ dig2+" = "+ aux;
                    pantalla.setText(opFinal);
                    dig1=aux;
                    dig2="";
                    break;
                case 4: //DIVISION

                    if (!dig2.equals("0")){

                        result= Double.parseDouble(dig1) / Double.parseDouble(dig2);
                        aux =format.format(result);
                        opFinal=dig1+" / "+ dig2+" = "+ aux;
                        pantalla.setText(opFinal);
                        dig1=aux;
                        dig2="";

                    }else{pantalla.setText("Infinito");}
                    break;
                case 5: //POTENCIA

                    result= Math.pow(Double.parseDouble(dig1), Double.parseDouble(dig2)) ;
                    aux =format.format(result);
                    opFinal=dig1+" ^ "+ dig2+" = "+ aux;
                    pantalla.setText(opFinal);
                    dig1=aux;
                    dig2="";
                    break;
                default:
                   pantalla.setText("ERROR");
            }
        }else if (!dig1.equals("") &&  operador == 6){ //ESTE ES PARA EL CASO DE LA RAIZ CUADRADA DONDE SOLO SE UTILIZA UN VALOR

                result= Math.sqrt(Double.parseDouble(dig1));
                aux =format.format(result);
                opFinal="√("+dig1+") = "+ aux;
                pantalla.setText(opFinal);
                dig1=aux;
                dig2="";
        }
    }

}