package com.example.mati.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView lblMensaje = (TextView) findViewById(R.id.LblSeleccion);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.gruporb);

       // rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { Solo saca el ID

         //   public void onCheckedChanged(RadioGroup group, int checkedId) {
           //     lblMensaje.setText("ID opción seleccionada: " + checkedId);
           // }
        //});


        rg.clearCheck();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { //saca tanto la opción que marcas como el ID
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String textoOpcion = "";
                if (group.getCheckedRadioButtonId() == R.id.radio1)
                    textoOpcion += "OPCION 1 con ID:" + checkedId;
                if (group.getCheckedRadioButtonId() == R.id.radio2)
                    textoOpcion += "OPCION 2 con ID:" + checkedId;
                lblMensaje.setText(textoOpcion);
            }
        });
    }

}

