package com.example.mati.transitiondrawable;

import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView imagen = new ImageView(this);
        setContentView(imagen);

        TransitionDrawable mi_transicion = (TransitionDrawable) getResources().getDrawable(R.drawable.transition,null);
        imagen.setImageDrawable(mi_transicion);
        mi_transicion.startTransition(2000);
    }
}
