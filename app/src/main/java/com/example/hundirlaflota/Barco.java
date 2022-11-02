package com.example.hundirlaflota;

import android.content.Context;

public class Barco {
    private int[] barco;
    private int tamano, pos_X, pos_Y;
    private char orientacion;

    public Barco(int tam, Celda c, char orientacion) {
        barco = new int[tam];
        for(int i = 0; i < barco.length; i++) {
            barco[i] = 0;
        }
        this.tamano = tam;
        this.pos_X = c.getPosX();
        this.pos_Y = c.getPosY();
        this.orientacion = orientacion;
        iniciaBarco();
    }

    public boolean iniciaBarco() {
        boolean result = true;
        int tamanoAux = tamano;
        int cont = 0;
        boolean fin = false;
        if (orientacion == 'd') {
            while (!fin) {
                for (int i = pos_X; i < Datos.tablero[0].length; i++) {
                    if(tamanoAux>0) {
                        if (Datos.tablero[i][pos_Y].getValor() == -1) {
                            tamanoAux--;
                        }
                    }
                    else{fin = true;}
                }
            }
            if (tamanoAux == 0) {
                Datos.tablero[pos_X][pos_Y].setValor(barco[cont]);
                int pos_XAux = pos_X+1;
                while(cont<barco.length) {
                    if (pos_X + tamano < Datos.tablero[0].length) {
                        Datos.tablero[pos_XAux][pos_Y].setValor(barco[cont]);
                        pos_XAux++;
                        cont++;
                    }
                }
            }
        }
        if (orientacion == 'i') {
            while (!fin) {
                for (int i = pos_X; i > 0; i--) {
                    if(tamanoAux>0) {
                        if (Datos.tablero[i][pos_Y].getValor() == -1) {
                            tamanoAux--;
                        }
                    }
                    else{fin = true;}
                }
            }
            if (tamanoAux == 0) {
                Datos.tablero[pos_X][pos_Y].setValor(barco[cont]);
                int pos_XAux = pos_X-1;
                while(cont<barco.length) {
                    if (pos_X - tamano < Datos.tablero[0].length) {
                        Datos.tablero[pos_XAux][pos_Y].setValor(barco[cont]);
                        pos_XAux--;
                        cont++;
                    }
                }
            }
        }
        if (orientacion == 't') {
            while (!fin) {
                for (int i = pos_Y; i > 0; i--) {
                    if(tamanoAux>0) {
                        if (Datos.tablero[pos_X][i].getValor() == -1) {
                            tamanoAux--;
                        }
                    }
                    else{fin = true;}
                }
            }
            if (tamanoAux == 0) {
                Datos.tablero[pos_X][pos_Y].setValor(barco[cont]);
                int pos_XAux = pos_X-1;
                while(cont<barco.length) {
                    if (pos_X - tamano < Datos.tablero[0].length) {
                        Datos.tablero[pos_XAux][pos_Y].setValor(barco[cont]);
                        pos_XAux--;
                        cont++;
                    }
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
                while(cont < barco.length) {
                    if (pos_Y + tamano < Datos.tablero[0].length) {
                        Datos.tablero[pos_X][pos_Y + 1].setValor(0);
                        cont++;
                    }
                    else{cont = barco.length; result = false;}
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
