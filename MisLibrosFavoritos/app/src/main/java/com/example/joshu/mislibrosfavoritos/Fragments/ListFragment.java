package com.example.joshu.mislibrosfavoritos.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.joshu.mislibrosfavoritos.Adapters.OwnArrayAdapter;
import com.example.joshu.mislibrosfavoritos.BddFicticia.Book;
import com.example.joshu.mislibrosfavoritos.BddFicticia.Coleccion;
import com.example.joshu.mislibrosfavoritos.R;

import java.util.ArrayList;

/**
 * Created by joshu on 02/12/2015.
 */
public class ListFragment extends android.app.Fragment implements AdapterView.OnItemClickListener {

    // Interfaz para notificación de eventos desde el fragmento.
    public interface OnBookSelectedListener {
        // Cuando se selecciona una obra.
        public void onBookSelectedListener(Book book, int position);
    }

    // Vistas.
    private ListView lstBooks;
    private OwnArrayAdapter mAdaptador;
    private OnBookSelectedListener mListener;
    private int mItemSeleccionado;
    private CardView sinopsis;
    private TextView sinopsisTitulo, sinopsisContenido;
    private ImageView sinopsisClose;

    // Cuando se crea el fragmento.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Se mantendrá la instancia del fragmento al cambiar la configuración.
        setRetainInstance(true);
        super.onCreate(savedInstanceState);
    }

    // Retorna la vista que mostrará el fragmento.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Se infla el layout del fragmento y se retorna la vista.
        return inflater.inflate(R.layout.list_fragment, container, false);
    }

    @Override
    public void onResume() {
        mAdaptador.setNotifyOnChange(true);
        super.onResume();
    }

    // Cuando se vincula el fragmento a la actividad.
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            // La actividad actuará como listener cuando se seleccione una obra.
            mListener = (OnBookSelectedListener) activity;
        } catch (ClassCastException e) {
            // La actividad no implementa la interfaz necesaria.
            throw new ClassCastException(activity.toString() + " debe implementar OnContactoSeleccionadoListener");
        }
    }

    // Cuando se desvincula el fragmento de la actividad.
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    // Cuando se ha terminado de crear la actividad al completo.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Se obtienen e inicializan las vistas.
        initVistas();
        // El fragmento actuará como listener cuando se pulse sobre un elemento
        // de la lista.
        lstBooks.setOnItemClickListener(this);
        //marcarLibro(mItemSeleccionado);
    }

    // Obtiene e inicializa las vistas.
    private void initVistas() {
        if (getView() != null) {
            // Se crea el adaptador y se asigna al ListView.
            lstBooks = (ListView) getView().findViewById(R.id.listListView);
            mAdaptador = new OwnArrayAdapter(this.getActivity(), getDatos());
            lstBooks.setAdapter(mAdaptador);

            // Se obtienen las vistas.
            sinopsis = (CardView) getView().findViewById(R.id.cardView);
            sinopsisTitulo=(TextView) getView().findViewById(R.id.tituloCardviewTextView);
            sinopsisContenido=(TextView) getView().findViewById(R.id.sinopsisTextViewCardView);
            sinopsisClose=(ImageView) getView().findViewById(R.id.closeImageViewCardView);
            //Onclic para ocultar el cardview
            sinopsisClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sinopsis.setVisibility(View.GONE);
                }
            });
        }
    }

    // Retorna el ArrayList de datos para la lista.
    private ArrayList<Book> getDatos() {
        Coleccion.addDefaultBooks();
        return Coleccion.getBooks();
    }

    // Al pulsar sobre un elemento de la lista.
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Se pulsa sobre el item.
        pulsarItem(position);
    }

    // Cuando se "pulsa" sobre un elemento. Recibe la posición.
    private void pulsarItem(int position) {
        // Se marca la obra seleccionada (por defecto la 0).
        marcarLibro(position);
        // Se muestra el detalle de la obra.
        if (mListener != null) {
            // Se llama al método correspondiente del listener.
            mListener.onBookSelectedListener(
                    (Book) lstBooks.getItemAtPosition(position), position);
        }
    }

    // Marca la obra seleccionada. Recibe la obra.
    public void marcarLibro(int position) {
        mItemSeleccionado = position;
        Book b = (Book) lstBooks.getItemAtPosition(mItemSeleccionado);
        lstBooks.setItemChecked(mItemSeleccionado, true);
        lstBooks.setSelection(mItemSeleccionado);
        //Mostramos el cardView oculto con su respectiva sinopsis
        sinopsisTitulo.setText(b.getTítulo());
        sinopsisContenido.setText(b.getSinopsis());
        sinopsis.setVisibility(View.VISIBLE);
        //getActivity().setTitle(b.getTítulo());
    }
}
