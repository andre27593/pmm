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
            Paint linea3 = new Paint();
            Paint linea1 = new Paint();
            Paint linea2 = new Paint();
            Paint linea4 = new Paint();
            Paint linea5 = new Paint();
            Paint ventana1 = new Paint();
            Paint ventana2 = new Paint();


            circulo1.setColor(Color.BLACK);
            circulo1.setStrokeWidth(15);
            circulo1.setStyle(Paint.Style.STROKE);

            canvas.drawCircle(700, 500, 110, circulo1);

            circulo2.setColor(Color.BLACK);
            circulo2.setStrokeWidth(15);
            circulo2.setStyle(Paint.Style.STROKE);

            canvas.drawCircle(300, 500, 110, circulo2);

            linea1.setColor(Color.BLACK);
            linea1.setStrokeWidth(15);
            linea1.setStyle(Paint.Style.STROKE);

            canvas.drawLine(900, 500, 110, 500, linea1);

            linea2.setColor(Color.BLACK);
            linea2.setStrokeWidth(15);
            linea2.setStyle(Paint.Style.STROKE);

            canvas.drawLine(900, 500, 900, 180, linea2);

            linea3.setColor(Color.BLACK);
            linea3.setStrokeWidth(15);
            linea3.setStyle(Paint.Style.STROKE);

            canvas.drawLine(500, 150, 900, 180, linea3);

            linea4.setColor(Color.BLUE);
            linea4.setStrokeWidth(15);
            linea4.setStyle(Paint.Style.STROKE);

            canvas.drawLine(120, 280, 500, 150, linea4);

            linea5.setColor(Color.BLACK);
            linea5.setStrokeWidth(15);
            linea5.setStyle(Paint.Style.STROKE);

            canvas.drawLine(120, 500, 120, 280, linea5);

            ventana1.setColor(Color.BLUE);
            ventana1.setStrokeWidth(15);
            ventana1.setStyle(Paint.Style.FILL_AND_STROKE);

            canvas.drawLine(500, 150, 500, 280, ventana1);

            ventana1.setColor(Color.BLUE);
            ventana1.setStrokeWidth(15);
            ventana1.setStyle(Paint.Style.FILL_AND_STROKE);

            canvas.drawLine(120, 280, 500, 280, ventana1);



        }
    }
}
