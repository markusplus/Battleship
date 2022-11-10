package com.example.hundirlaflota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private double width, height;
    private DisplayMetrics metrics;
    private LinearLayout verticalLayout;
    private LinearLayout verticalLayout1;
    private static final int TAM_X = 10, TAM_Y = 10;
    private ConstraintLayout fondo;
    public TextView texto;
    private int contBarcos, contBarcosAux;
    private int cont;
    private int[] tamanosBarco, tamanosBarcoAux;
    private Context context;
    private Random rnd;
    private boolean fin;
    private boolean finPosicionamiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verticalLayout = (LinearLayout) findViewById(R.id.verticalLayout);
        verticalLayout.setBackgroundResource(R.mipmap.mar);
        verticalLayout1 = (LinearLayout) findViewById(R.id.verticalLayout1);
        verticalLayout1.setBackgroundResource(R.mipmap.mar);
        fondo = (ConstraintLayout) findViewById(R.id.fondo);
        texto = (TextView) findViewById(R.id.textView);
        contBarcos = 0;
        contBarcosAux = 0;
        context = this;
        cont = 0;
        fin = false;
        tamanosBarco = new int[]{4, 3, 3, 3, 2, 2, 2, 1};
        tamanosBarcoAux = tamanosBarco;
        System.out.println(tamanosBarco[2]);
        texto.setText("Siguiente barco: " + tamanosBarco[contBarcos] + " casillas");

        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        iniciaTableroJugador(TAM_X, TAM_Y, verticalLayout);
        iniciaTableroIA(TAM_X, TAM_Y, verticalLayout1);
    }

    public void iniciaTableroJugador(int x, int y, LinearLayout layout) {
        finPosicionamiento = false;
        Datos.tablero = new Celda[x][y];
        for (int j = 0; j < y; j++) {
            LinearLayout layoutAuxiliar = new LinearLayout(this);
            layoutAuxiliar.setOrientation(LinearLayout.HORIZONTAL);
            layoutAuxiliar.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                    )
            );
            for (int i = 0; i < x; i++) {
                Celda celdaAuxiliar = new Celda(this).putPosicion(i, j);
                celdaAuxiliar.setValor(-1);     //Una celda sin barcos tiene el valor de -1
                Datos.tablero[i][j] = celdaAuxiliar;
                celdaAuxiliar.setLayoutParams(new LinearLayout.LayoutParams(150, 150));
                celdaAuxiliar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Celda celdaAuxiliar = (Celda) view;

                        if (contBarcos != tamanosBarco.length + 1 && !finPosicionamiento) {
                            Dialog dialog = new Dialog(context);
                            dialog.setContentView(R.layout.custom_dialog);
                            Button dialogButtonTop = dialog.findViewById(R.id.button_top);
                            Button dialogButtonBottom = dialog.findViewById(R.id.button_bottom);
                            Button dialogButtonLeft = dialog.findViewById(R.id.button_left);
                            Button dialogButtonRight = dialog.findViewById(R.id.button_right);
                            TextView tam_input = dialog.findViewById(R.id.info_barco);
                            tam_input.setText("Construyendo barco de " + tamanosBarco[contBarcos] + " casillas");
                            dialog.show();
                            dialogButtonTop.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    if(tamanosBarco[contBarcos] > 1) {
                                        Barco b = new Barco(tamanosBarco[contBarcos], celdaAuxiliar, 't');
                                        b.iniciaBarcoJugador();
                                        contBarcos++;
                                        texto.setText("Siguiente barco: " + tamanosBarco[contBarcos] + " casillas");
                                        //Datos.tablero[b.getPos_X()][b.getPos_Y()].setValor(0);
                                        dialog.dismiss();
                                    }
                                    else if(tamanosBarco[contBarcos] == 1 && !finPosicionamiento){
                                        Datos.tablero[celdaAuxiliar.getPosX()][celdaAuxiliar.getPosY()].setBackgroundResource(R.mipmap.barco_verde);
                                        Datos.tablero[celdaAuxiliar.getPosX()][celdaAuxiliar.getPosY()].setValor(0);
                                        finPosicionamiento = true;
                                        dialog.dismiss();
                                    }
                                }
                            });
                            dialogButtonBottom.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    if(tamanosBarco[contBarcos] > 1) {
                                        Barco b = new Barco(tamanosBarco[contBarcos], celdaAuxiliar, 'b');
                                        b.iniciaBarcoJugador();
                                        contBarcos++;
                                        texto.setText("Siguiente barco: " + tamanosBarco[contBarcos] + " casillas");
                                        //Datos.tablero[b.getPos_X()][b.getPos_Y()].setValor(0);
                                        dialog.dismiss();
                                    }
                                    else if(tamanosBarco[contBarcos] ==1 && !finPosicionamiento){
                                        Datos.tablero[celdaAuxiliar.getPosX()][celdaAuxiliar.getPosY()].setBackgroundResource(R.mipmap.barco_verde);
                                        Datos.tablero[celdaAuxiliar.getPosX()][celdaAuxiliar.getPosY()].setValor(0);
                                        finPosicionamiento = true;
                                        dialog.dismiss();
                                    }
                                }
                            });
                            dialogButtonLeft.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    if(tamanosBarco[contBarcos] > 1) {
                                        Barco b = new Barco(tamanosBarco[contBarcos], celdaAuxiliar, 'i');
                                        b.iniciaBarcoJugador();
                                        contBarcos++;
                                        texto.setText("Siguiente barco: " + tamanosBarco[contBarcos] + " casillas");
                                        //Datos.tablero[b.getPos_X()][b.getPos_Y()].setValor(0);
                                        dialog.dismiss();
                                    }
                                    else if(tamanosBarco[contBarcos] == 1 && !finPosicionamiento){
                                        Datos.tablero[celdaAuxiliar.getPosX()][celdaAuxiliar.getPosY()].setBackgroundResource(R.mipmap.barco_verde);
                                        Datos.tablero[celdaAuxiliar.getPosX()][celdaAuxiliar.getPosY()].setValor(0);
                                        finPosicionamiento = true;
                                        dialog.dismiss();
                                    }
                                }
                            });
                            dialogButtonRight.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    if(tamanosBarco[contBarcos] > 1) {
                                        Barco b = new Barco(tamanosBarco[contBarcos], celdaAuxiliar, 'd');
                                        b.iniciaBarcoJugador();
                                        contBarcos++;
                                        texto.setText("Siguiente barco: " + tamanosBarco[contBarcos] + " casillas");
                                        //Datos.tablero[b.getPos_X()][b.getPos_Y()].setValor(0);
                                        dialog.dismiss();
                                    }
                                    else if(tamanosBarco[contBarcos] == 1 && !finPosicionamiento){
                                        Datos.tablero[celdaAuxiliar.getPosX()][celdaAuxiliar.getPosY()].setBackgroundResource(R.mipmap.barco_verde);
                                        Datos.tablero[celdaAuxiliar.getPosX()][celdaAuxiliar.getPosY()].setValor(0);
                                        finPosicionamiento = true;
                                        dialog.dismiss();
                                    }
                                }
                            });
                        }
                    }
                });
                //Datos.tableroCeldas[i][j] = celdaAuxiliar;
                layoutAuxiliar.addView(celdaAuxiliar);
            }
            layout.addView(layoutAuxiliar);
        }
    }

    private Barco[] iniciaTableroIA(int x, int y, LinearLayout layout) {
        int contIA = 0;
        Barco[] barcos = new Barco[9];
        Datos.tablero1 = new Celda[x][y];
        for (int j = 0; j < y; j++) {
            LinearLayout layoutAuxiliar = new LinearLayout(this);
            layoutAuxiliar.setOrientation(LinearLayout.HORIZONTAL);
            layoutAuxiliar.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                    )
            );
            for (int i = 0; i < x; i++) {
                Celda celdaAuxiliar = new Celda(this).putPosicion(i, j);
                celdaAuxiliar.setValor(-1);     //Una celda sin barcos tiene el valor de -1
                Datos.tablero1[i][j] = celdaAuxiliar;
                celdaAuxiliar.setLayoutParams(new LinearLayout.LayoutParams(150, 150));
                layoutAuxiliar.addView(celdaAuxiliar);
            }
            layout.addView(layoutAuxiliar);
        }
        rnd = new Random();
        while (contBarcosAux > 0) {
            int randX = rnd.nextInt(x);
            int randY = rnd.nextInt(y);
            char o = 0;
            int randO = rnd.nextInt(4);
            switch (randO) {
                case 0:
                    o = 'i';
                    break;
                case 1:
                    o = 'd';
                    break;
                case 2:
                    o = 't';
                    break;
                case 3:
                    o = 'b';
                    break;
            }
            Barco b = new Barco(tamanosBarcoAux[contBarcosAux], randX, randY, o);
            if (b.iniciaBarcoIA())
                barcos[contIA] = b;
            contIA++;
            contBarcosAux--;
        }
        return barcos;
    }
}