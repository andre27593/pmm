package com.example.mati.figurasaleatorias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void DrawShapes1 (View clickedButton){
        Intent intent1 = new Intent(this,DrawShapes1.class);
        startActivity(intent1);
    }

    public void DrawShapes2 (View clickedButton){
        Intent intent2 = new Intent(this,DrawShapes2.class);
        startActivity(intent2);
    }
}
