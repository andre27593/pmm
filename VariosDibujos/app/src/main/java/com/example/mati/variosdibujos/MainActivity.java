package com.example.mati.variosdibujos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
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

            this.setBackgroundColor(Color.BLACK);

            Paint punto = new Paint();
            punto.setColor(Color.CYAN);
            punto.setStrokeWidth(10);
            punto.setStyle(Paint.Style.STROKE);
            canvas.drawPoint(500,500,punto);


            Paint circulo = new Paint();
            circulo.setColor(Color.MAGENTA);
            circulo.setStrokeWidth(15);
            circulo.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(500,500,220,circulo);

            Paint cuadrado1 = new Paint();
            cuadrado1.setColor(Color.RED);
            cuadrado1.setStrokeWidth(100);
            cuadrado1.setStyle(Paint.Style.STROKE);
            canvas.drawRect(150,150,200,200,cuadrado1);

            Paint cuadrado2 = new Paint();
            cuadrado2.setColor(Color.BLUE);
            cuadrado2.setStrokeWidth(100);
            cuadrado2.setStyle(Paint.Style.STROKE);
            canvas.drawRect(900,200,850,150,cuadrado2);

            Paint cuadrado3 = new Paint();
            cuadrado3.setColor(Color.GREEN);
            cuadrado3.setStrokeWidth(100);
            cuadrado3.setStyle(Paint.Style.STROKE);
            canvas.drawRect(150,800,200,850,cuadrado3);

            Paint cuadrado4 = new Paint();
            cuadrado4.setColor(Color.YELLOW);
            cuadrado4.setStrokeWidth(100);
            cuadrado4.setStyle(Paint.Style.STROKE);
            canvas.drawRect(810,800,870,855,cuadrado4);

        }
    }
}
