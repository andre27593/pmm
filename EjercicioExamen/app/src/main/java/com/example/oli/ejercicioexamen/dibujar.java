package com.example.oli.ejercicioexamen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class dibujar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Dibujo(this));
    }

    public class Dibujo extends View {
        public Dibujo(Context context){
            super(context);
        }

        protected void onDraw(Canvas canvas){

            Paint circulo = new Paint();
            circulo.setColor(Color.RED);
            circulo.setStrokeWidth(10);
            circulo.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(500,500,130,circulo);

            Paint mini1 = new Paint();
            mini1.setColor(Color.BLUE);
            mini1.setStrokeWidth(10);
            mini1.setStyle(Paint.Style.FILL);
            canvas.drawCircle(450,500,20,mini1);

            Paint mini2 = new Paint();
            mini2.setColor(Color.BLUE);
            mini2.setStrokeWidth(10);
            mini2.setStyle(Paint.Style.FILL);
            canvas.drawCircle(550,500,20,mini2);




        }
    }

}
