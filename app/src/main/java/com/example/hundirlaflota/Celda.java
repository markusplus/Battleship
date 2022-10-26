package com.example.hundirlaflota;

import android.content.Context;
import android.widget.ImageButton;

public class Celda extends androidx.appcompat.widget.AppCompatImageButton {
    private int x, y;

    public Celda(Context context) {
        super(context);
        this.setImageResource(R.mipmap.bordes);
        this.setBackground(null);
        //this.setImageAlpha(0);
        this.setScaleType(ScaleType.FIT_XY);
        this.setAdjustViewBounds(false);
        this.setPadding(0,0,0,0);
    }
    public Celda putPosicion(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }
}
