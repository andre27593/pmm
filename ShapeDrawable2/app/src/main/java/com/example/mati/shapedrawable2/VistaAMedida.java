package com.example.mati.shapedrawable2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

public class VistaAMedida extends View {


        private ShapeDrawable miDrawable;

        public VistaAMedida(Context context, AttributeSet attrs){
            super(context,attrs);
        }
        public VistaAMedida(Context context) {
            super(context);
        }



        protected void onDraw(Canvas canvas){

            Paint pincel = new Paint();
            pincel.setColor(Color.MAGENTA);
            pincel.setStrokeWidth(40);
            pincel.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(500,200,10,pincel);

            int x=100, y=100;
            int ancho=350, alto=350;
            miDrawable = new ShapeDrawable(new OvalShape());
            miDrawable.getPaint().setColor(0xff0000ff);
            miDrawable.setBounds(x,y,x+ancho,y+alto);

            miDrawable.draw(canvas);
        }

}
