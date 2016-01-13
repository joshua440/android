package com.example.joshu.mislibrosfavoritos.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.joshu.mislibrosfavoritos.Activities.SecondActivity;
import com.example.joshu.mislibrosfavoritos.Adapters.OwnArrayAdapter;
import com.example.joshu.mislibrosfavoritos.BddFicticia.Book;
import com.example.joshu.mislibrosfavoritos.BddFicticia.Coleccion;
import com.example.joshu.mislibrosfavoritos.R;

/**
 * Created by joshu on 02/12/2015.
 */
public class CreateFragment extends android.app.Fragment {

    // Interfaz para notificación de eventos desde el fragmento.
    public interface OnCreateBookListener {
        // Cuando se selecciona una obra.
        public void onCreateBook(Book b, int position);
    }

    // Vistas.
    private ImageView imageView;
    private EditText nombreEditText,autorEditText,yearEditText,urlEditText,sinopsisEditText;

    // Variables
    private boolean editTitle,editAuthor,editYear,editUrl,editSinopsis;
    private OnCreateBookListener mListener;

    // Retorna una nueva instancia del fragmento configurado.
    public static CreateFragment newInstance() {
        CreateFragment frgDetalle = new CreateFragment();
        return frgDetalle;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    // Retorna la vista que debe mostrar el fragmento.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Se infla el layout y se retorna la vista.
        return inflater.inflate(R.layout.create_fragment, container, false);
    }

    // Cuando se vincula el fragmento a la actividad.
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            // La actividad actuar como listener cuando se seleccione una obra.
            mListener = (OnCreateBookListener) activity;
        } catch (ClassCastException e) {
            // La actividad no implementa la interfaz necesaria.
            throw new ClassCastException(activity.toString() + " debe implementar OnCreateBookListener");
        }
    }

    // Cuando se desvincula el fragmento de la actividad.
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    // Al terminarse de crear la actividad al completo.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // Se obtienen e inicializan las vistas.
        initViews();
        super.onActivityCreated(savedInstanceState);
    }

    // Obtiene e inicializa las vistas.
    private void initViews() {
        if (getView() != null) {
            imageView = (ImageView) getView().findViewById(R.id.imageView);
            nombreEditText = (EditText) getView().findViewById(R.id.newTitleEditText);
            autorEditText = (EditText) getView().findViewById(R.id.newAutorEditText);
            yearEditText = (EditText) getView().findViewById(R.id.newYearEditText);
            urlEditText = (EditText) getView().findViewById(R.id.newImageUrlEditText);
            sinopsisEditText= (EditText) getView().findViewById(R.id.newSinopsisEditText);

            editTitle=false;
            editAuthor=false;
            editYear=false;
            editUrl=false;
            editSinopsis=false;

            nombreEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus){
                        editTitle=nombreEditText.getText().toString().isEmpty();
                    }
                }
            });
            autorEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus){
                        editAuthor=autorEditText.getText().toString().isEmpty();
                    }
                }
            });
            yearEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus){
                        editYear=yearEditText.getText().toString().isEmpty();
                    }
                }
            });
            urlEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus){
                        editUrl=urlEditText.getText().toString().isEmpty();
                    }
                }
            });
            sinopsisEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus){
                        editSinopsis=sinopsisEditText.getText().toString().isEmpty();
                    }
                }
            });
        }
    }

    //creado desde fragmento
    //toolbar
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.second_activity_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Dependiendo del ítem pulsado.
        int id = item.getItemId();
        // Siguiente.
        if (id == R.id.addBook) {
            // Se crea el libro, recarga la lista de libros y cierra esta actividad.
            if (editTitle && editAuthor && editYear && editUrl && editSinopsis){
                //Book(String título, String autor, String urlPortada, String sinopsis, int añoPublicación)
                Coleccion.addBook( new Book( nombreEditText.getText().toString(),
                        autorEditText.getText().toString(), urlEditText.getText().toString(),
                        sinopsisEditText.getText().toString(), Integer.valueOf( yearEditText.getText().toString() ) ) );
                getActivity().finish();
                return true;
            }else{
                Toast toast = Toast.makeText(getActivity(), getResources().getString(R.string.error_creation_book), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                toast.show();
                return true;
            }

        }
        return super.onOptionsItemSelected(item);
    }

}
