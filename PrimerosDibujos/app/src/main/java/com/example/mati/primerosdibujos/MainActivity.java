package com.example.mati.primerosdibujos;

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

    public class Dibujo extends View{
        public Dibujo(Context context){
            super(context);
        }

        protected void onDraw(Canvas canvas){

            Paint pincel = new Paint();
            pincel.setColor(Color.RED);
            pincel.setStrokeWidth(70);
            pincel.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(500,500,80,pincel);

        }
    }
}
