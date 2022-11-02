package com.example.hundirlaflota;

import android.content.Context;
import android.widget.ImageButton;

public class Celda extends androidx.appcompat.widget.AppCompatImageButton {
    private int x, y;
    private int valor;

    public Celda(Context context) {
        super(context);
        this.setImageResource(R.mipmap.bordes);
        this.setBackground(null);
        this.setScaleType(ScaleType.FIT_XY);
        this.setAdjustViewBounds(false);
        this.setPadding(0,0,0,0);
    }
    public Celda putPosicion(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public void setValor(int v) {
        this.valor = v;
    }

    public int getValor() {
        return this.valor;
    }

    public int getPosX() {
        return x;
    }
    public int getPosY() {
        return y;
    }
}
