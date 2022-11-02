package com.example.hundirlaflota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private double width, height;
    private DisplayMetrics metrics;
    private LinearLayout verticalLayout;
    private LinearLayout verticalLayout1;
    private static final int TAM_X = 10, TAM_Y = 10;
    private ConstraintLayout fondo;
    public TextView texto;

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

        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        iniciaTablero(TAM_X,TAM_Y, verticalLayout);
        iniciaTablero(TAM_X,TAM_Y, verticalLayout1);
    }

    public void iniciaTablero(int x, int y, LinearLayout layout) {
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
            for(int i = 0; i < x; i++) {
                Celda celdaAuxiliar = new Celda(this).putPosicion(i,j);
                celdaAuxiliar.setValor(-1);     //Una celda sin barcos tiene el valor de -1
                Datos.tablero[i][j] = celdaAuxiliar;
                celdaAuxiliar.setLayoutParams(new LinearLayout.LayoutParams(150,150));
                celdaAuxiliar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Barco b = new Barco(3,celdaAuxiliar,'d');
                        texto.setText(""+Datos.tablero[celdaAuxiliar.getPosX()+1][celdaAuxiliar.getPosY()].getValor());
                    }
                });
                //Datos.tableroCeldas[i][j] = celdaAuxiliar;
                layoutAuxiliar.addView(celdaAuxiliar);
            }
            layout.addView(layoutAuxiliar);
        }
    }
}