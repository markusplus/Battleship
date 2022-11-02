package com.example.hundirlaflota;

import android.content.Context;

public class Barco {
    private int[] barco;
    private int tamano, pos_X, pos_Y;
    private char orientacion;

    public Barco(int tam, Celda c, char orientacion) {
        barco = new int[tam];
        this.tamano = tam;
        this.pos_X = c.getPosX();
        this.pos_Y = c.getPosY();
        this.orientacion = orientacion;
        iniciaBarco();
    }

    public boolean iniciaBarco() {
        boolean result = true;
        int tamanoAux = tamano;
        int tamanoAux1 = tamano;
        if (orientacion == 'd') {
            while (tamanoAux > 0) {
                for (int i = pos_X; i < Datos.tablero[0].length; i++) {
                    if (Datos.tablero[i][pos_Y].getValor() == -1) {
                        tamanoAux--;
                    }
                }
            }
            if (tamanoAux == 0) {
                while(tamanoAux1>0) {
                    if (pos_X + tamano < Datos.tablero[0].length) {
                        Datos.tablero[pos_X + 1][pos_Y].setValor(0);
                        tamanoAux1--;
                    }
                    else{tamanoAux1=0; result = false;}
                }
            }
        }
        if (orientacion == 'i') {
            while (tamanoAux > 0) {
                for (int i = pos_X; i > 0; i--) {
                    if (Datos.tablero[i][pos_Y].getValor() == -1) {
                        tamanoAux--;
                    }
                }
            }
            if (tamanoAux == 0) {
                while(tamanoAux1>0) {
                    if (pos_X - tamano > 0) {
                        Datos.tablero[pos_X - 1][pos_Y].setValor(0);
                        tamanoAux1--;
                    }
                    else{tamanoAux1=0; result = false;}
                }
            }
        }
        if (orientacion == 't') {
            while (tamanoAux > 0) {
                for (int i = pos_Y; i > 0; i--) {
                    if (Datos.tablero[pos_X][i].getValor() == -1) {
                        tamanoAux--;
                    }
                }
            }
            if (tamanoAux == 0) {
                while(tamanoAux1>0) {
                    if (pos_Y - tamano > 0) {
                        Datos.tablero[pos_X][pos_Y - 1].setValor(0);
                        tamanoAux1--;
                    }
                    else{tamanoAux1=0; result = false;}
                }
            }
        }
        if (orientacion == 'b') {
            while (tamanoAux > 0) {
                for (int i = pos_Y; i < Datos.tablero.length; i++) {
                    if (Datos.tablero[pos_X][i].getValor() == -1) {
                        tamanoAux--;
                    }
                }
            }
            if (tamanoAux == 0) {
                while(tamanoAux1>0) {
                    if (pos_Y + tamano < Datos.tablero[0].length) {
                        Datos.tablero[pos_X][pos_Y + 1].setValor(0);
                        tamanoAux1--;
                    }
                    else{tamanoAux1=0; result = false;}
                }
            }
        }
        return result;
    }

    public int[] getBarco() {
        return barco;
    }

    public int getPos_X() {
        return pos_X;
    }

    public int getPos_Y() {
        return pos_Y;
    }

    public int getTamano() {
        return tamano;
    }

}
