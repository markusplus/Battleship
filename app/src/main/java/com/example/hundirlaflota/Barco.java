package com.example.hundirlaflota;

public class Barco {
    private int[] barco;
    private int tamano;

    public Barco(int tam){
        barco = new int[tam];
        this.tamano = tam;
    }

    public int[] getBarco() {
        return barco;
    }

    public int getTamano() {
        return tamano;
    }
}
