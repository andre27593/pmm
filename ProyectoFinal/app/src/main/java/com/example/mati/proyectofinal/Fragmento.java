package com.example.mati.proyectofinal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragmento.OnFragmentInteractionListener} interface
 * to handle interaction events.
 +
 */
public class Fragmento extends Fragment {


    private OnFragmentInteractionListener mListener;

    Activity act;
    Fragmento fragmento;


    public Fragmento() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragmento, container, false);

        final Button confirmar = (Button)view.findViewById(R.id.confirmar);

        final TextView pregunta = (TextView)view.findViewById(R.id.pregunta);

        final TextView tipo = (TextView)view.findViewById(R.id.libro_tipo);
        final TextView formato = (TextView)view.findViewById(R.id.libro_formato);
        final TextView ebook = (TextView)view.findViewById(R.id.libro_ebook);

        Bundle miBundle = this.getArguments();






        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                act = getActivity();
                Toast.makeText(act,"Su pedido se ha realizado. Gracias por su confianza",Toast.LENGTH_SHORT).show();

                confirmar.setVisibility(View.INVISIBLE);

                pregunta.setVisibility(View.INVISIBLE);


            }
        });






        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
