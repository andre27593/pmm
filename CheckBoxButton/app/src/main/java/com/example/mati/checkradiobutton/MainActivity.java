package com.example.mati.checkradiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox chkBoxCycling;
    CheckBox chkBoxTeaching;
    CheckBox chkBoxBlogging;
    Button btnHobby;
    TextView txtHobby;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialUISetup();

    }


    public void initialUISetup()
    {
        chkBoxCycling = (CheckBox) findViewById(R.id.chkBoxCycling);
        chkBoxTeaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
        chkBoxBlogging = (CheckBox) findViewById(R.id.chkBoxBlogging);
        //btnHobby = (Button)findViewById(R.id.btnHobby);
        txtHobby = (TextView)findViewById(R.id.txtHobby);


        chkBoxCycling.setOnCheckedChangeListener(new myCheckBoxChangeClicker()); //manipulador y clase anónima
        chkBoxTeaching.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
        chkBoxBlogging.setOnCheckedChangeListener(new myCheckBoxChangeClicker());


        //btnHobby.setOnClickListener(new View.OnClickListener() {
          //  public void onClick(View v){ //en el onclick gestiona el click
            //    getHobbyClick(v);
           // }
        //});
    }



    //public void getHobbyClick(View v) //gestiona las opciones que marcas, puedes marcar más de una
    //{
      //  String strMessage = "";
      //  if(chkBoxCycling.isChecked())
      //  {
        //    strMessage+="Cycling ";
      //  }
      //  if(chkBoxTeaching.isChecked())
      //  {
        //    strMessage+="Teaching ";
     //   }
       // if(chkBoxBlogging.isChecked())
       // {
        //    strMessage+="Blogging ";
       // }
       // showTextNotification(strMessage);
   // }


    class myCheckBoxChangeClicker implements CheckBox.OnCheckedChangeListener //tiene que implementar el método de la interfaz
    { @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) //manipuladores de los checkbox
    {
        if(isChecked)
        {

            if(buttonView==chkBoxCycling)
            {
                showTextNotification("Cycling");
            }
            if(buttonView==chkBoxTeaching)
            {
                showTextNotification("Teaching");
            }
            if(buttonView==chkBoxBlogging)
            {
                showTextNotification("BlackBlogging");
            }
        }else showTextNotification("No has seleccionado nada");
    }
    }// clase interna --> clase dentro de otra clase

    public void showTextNotification(String msgToDisplay)
    { Toast.makeText(this, msgToDisplay, Toast.LENGTH_SHORT).show();
    }
   // public void showTextNotification(String msgToDisplay) //saca en el texview las opciones que has seleccionado
   // {
     //   txtHobby.setText(msgToDisplay);
//Toast.makeText(this, msgToDisplay, Toast.LENGTH_SHORT).show();

    }






