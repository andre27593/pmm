package com.example.mati.proysumaresta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText num1 = (EditText) findViewById(R.id.editText);
        final EditText num2 = (EditText) findViewById(R.id.editText2);

        final RadioButton sumar = (RadioButton) findViewById(R.id.radioButton);
        final RadioButton restar = (RadioButton) findViewById(R.id.radioButton2);

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);

        final TextView resultado = (TextView) findViewById(R.id.textView);

        sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(R.id.radioButton == radioGroup.getCheckedRadioButtonId()){

                    int numero1 = Integer.valueOf(num1.getText().toString());
                    int numero2 = Integer.valueOf(num2.getText().toString());

                    int resul = numero1 + numero2;

                    resultado.setText(resul);

                }

            }
        });




    }
}
