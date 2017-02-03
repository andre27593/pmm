package com.example.mati.proyectofinal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
        final TextView ebook = (TextView)view.findViewById(R.id.libro_ebook);
        final TextView formato = (TextView)view.findViewById(R.id.libro_formato);
        final TextView precio_final = (TextView)view.findViewById(R.id.libro_final);
        final TextView descuento = (TextView)view.findViewById(R.id.libro_descuento);

        final TextView titulo = (TextView)view.findViewById(R.id.libro_titulo);
        final TextView subtitulo = (TextView)view.findViewById(R.id.libro_subtitulo);
        final TextView autor = (TextView)view.findViewById(R.id.libro_autor);
        final TextView precio = (TextView)view.findViewById(R.id.libro_precio);
        final TextView genero = (TextView)view.findViewById(R.id.libro_genero);

        //PARA PASAR LOS DATOS AL FRAGMENTO USAMOS GETARGUMENTS
        Bundle miBundle = this.getArguments();

        Libros libros = (Libros) miBundle.getSerializable("datos");

        //DEFINIR LAS ETIQUETAS PARA GUARDAR LOS DATOS
        titulo.setText("Titulo " +libros.getTitulo());
        subtitulo.setText("Subtitulo " +libros.getSubtitulo());
        autor.setText("Autor " +libros.getAutor());
        precio.setText("Precio " +libros.getPrecio());
        genero.setText("Genero " +libros.getGenero());


        tipo.setText("Tipo de libro " +this.getArguments().getString("radiogroup"));

        //SI EL BOOLEANO ES TRUE, PASAMOS AL FRAGMENTO EL TEXTO DE SI HA ESCOGIDO EBOOK O NO Y LOS FORMATOS QUE HA SELECCIONADO
        if(this.getArguments().getBoolean("ebook")==true) {
            ebook.setText("Has escogido ebook");
            formato.setText("Formato ebook " +this.getArguments().getString("formato")+" "+this.getArguments().getString("formato1")
                    +" "+this.getArguments().getString("formato2")+" "+this.getArguments().getString("formato3")+" "+this.getArguments().getString("formato4"));
        }else{
            ebook.setText("No has escogido ebook");
        }

        //SI EL BOOLEANO ES TRUE, PASAMOS AL FRAGMENTO EL DESCUENTO Y EL PRECIO FINAL SI HA ESCOGIDO DE BOLSILLO Y EL EBOOK
        if(this.getArguments().getBoolean("dos")==true){
            descuento.setText("El descuento aplicado es " +this.getArguments().getDouble("descuento"));
            precio_final.setText("El precio después de aplicar el descuento es " +this.getArguments().getDouble("precio final"));
        }

        descuento.setText("El descuento aplicado es " +this.getArguments().getDouble("descuento"));
        precio_final.setText("El precio después de aplicar el descuento es " +this.getArguments().getDouble("precio final"));





        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                act = getActivity();
                Toast.makeText(act,"Su pedido se ha realizado. Gracias por su confianza",Toast.LENGTH_SHORT).show();

                confirmar.setVisibility(View.INVISIBLE);

                pregunta.setVisibility(View.INVISIBLE);


                /*Integer id =

                //HACEMOS UN SELECT DE LA TABLA USUARIOS PARA, COMPROBANDO EL USUARIO Y LA CONTRASEÑA, SABER SI EL USUARIO ESTÁ REGISTRADO
                Cursor login = bd.rawQuery("SELECT id FROM Usuarios WHERE id= " +id+,  null);

                //CON EL CURSOR, COMPROBAMOS LOS REGISTROS QUE HAY EN LA TABLA DE USUARIOS Y SI COINCIDEN CON LOS QUE INTRODUCIMOS
                //PASAMOS A LA PANTALLA DE LIBRERÍA, SI NO NOS QUEDAMOS AQUI
                if (login.moveToFirst()) {

                    String usu_correcto = login.getString(0);
                    String cont_correcta = login.getString(1);


                }
*/


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
