package com.example.mati.holamundo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText miTexto = (EditText)findViewById(R.id.editText);
        final Button miBoton = (Button)findViewById(R.id.button);
        final TextView elSaludo = (TextView)findViewById(R.id.textView2);

        miBoton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){

                String mensajePaso = "Te saludo " +miTexto.getText();
                elSaludo.setText(mensajePaso);
            }



        });

    }
}
