package com.example.mati.examenconcesionario;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by mati on 21/11/16.
 */

public class Dibujar extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Dibujo(this));


    }

    public class Dibujo extends View {
        public Dibujo(Context context) {
            super(context);
        }


        protected void onDraw(Canvas canvas) {

            Paint circulo1 = new Paint();
            Paint circulo2 = new Paint();
            Paint coche1 = new Paint();
            Paint coche2 = new Paint();
            Paint coche3 = new Paint();


            circulo1.setColor(Color.BLACK);
            circulo1.setStrokeWidth(15);
            circulo1.setStyle(Paint.Style.STROKE);

            canvas.drawCircle(700, 500, 140, circulo1);

            circulo2.setColor(Color.BLACK);
            circulo2.setStrokeWidth(15);
            circulo2.setStyle(Paint.Style.STROKE);

            canvas.drawCircle(300, 500, 140, circulo2);

            coche1.setColor(Color.BLACK);
            coche1.setStrokeWidth(15);
            coche1.setStyle(Paint.Style.STROKE);

            canvas.drawLine(400, 500, 600, 500, coche1);

            coche2.setColor(Color.BLACK);
            coche2.setStrokeWidth(15);
            coche2.setStyle(Paint.Style.STROKE);

            canvas.drawLine(800, 500, 100, 500, coche2);


        }
    }
}
