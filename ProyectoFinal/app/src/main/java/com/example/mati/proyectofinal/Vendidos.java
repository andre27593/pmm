package com.example.mati.proyectofinal;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class Vendidos extends android.app.DialogFragment {

    public static Vendidos newInstance(String valor){

        Vendidos vendidos = new Vendidos();

        return vendidos;

    }

    //DEFINIR EL DIALOG FRAGMENT Y UN BOTON PARA VOLVER A LA LIBRERÍA
    public Dialog onCreateDialog(Bundle savedInstanceState){


        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);

        ViewGroup dialogview = (ViewGroup) inflater.inflate(R.layout.activity_vendidos, null);


        Button volver = (Button) dialogview.findViewById(R.id.volver);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return new AlertDialog.Builder(getActivity()).setView(dialogview).create();

    }

}
