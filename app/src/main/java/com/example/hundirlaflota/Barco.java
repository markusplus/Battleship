package com.example.hundirlaflota;

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
    }

    public boolean iniciaBarco() {
        boolean result = true;
        int tamanoAux = tamano;
        int cont = pos_X;
        int contAux = pos_X;
        int i = 0;
        if (orientacion == 'd') {
            if((pos_X+tamano-1) < Datos.tablero[0].length) {
                while(i < tamano) {
                    if (Datos.tablero[contAux][pos_Y].getValor() == -1) {
                        i++;
                        contAux++;
                    }
                }
                if(i == tamano) {
                    while (tamanoAux > 0) {
                        Datos.tablero[cont][pos_Y].setBackgroundResource(R.mipmap.barco_rojo);
                        cont++;
                        tamanoAux--;
                    }
                }
            }
            else{result = false;}
        }
        if (orientacion == 'i') {

        }
        if (orientacion == 't') {

        }
        if (orientacion == 'b') {

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
