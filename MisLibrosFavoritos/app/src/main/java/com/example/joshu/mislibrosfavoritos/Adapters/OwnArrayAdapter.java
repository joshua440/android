package com.example.joshu.mislibrosfavoritos.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.joshu.mislibrosfavoritos.BddFicticia.Book;
import com.example.joshu.mislibrosfavoritos.R;

import java.util.ArrayList;

/**
 * Created by joshu on 11/12/2015.
 */
public class OwnArrayAdapter extends ArrayAdapter<Book> {
    // Variables.
    private final ArrayList<Book> mDatos;
    private final LayoutInflater mInflador;

    // Constructor.
    public OwnArrayAdapter(Context contexto, ArrayList<Book> datos) {
        super(contexto, 0, datos);
        this.mDatos = datos;
        // Se obtiene un objeto inflador de layouts.
        mInflador = LayoutInflater.from(contexto);
    }

    // Cuando se debe pintar un elemento de la lista.
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        // Si no se puede reciclar.
        if (convertView == null) {
            // Se obtiene la vista-fila inflando el layout.
            convertView = mInflador.inflate(R.layout.libros_row, parent, false);
            // Se crea el contenedor de vistas para la vista-fila.
            holder = new ViewHolder(convertView);
            // Se almacena el contenedor en la vista.
            convertView.setTag(holder);
        }
        // Si se puede reciclar.
        else {
            // Se obtiene el contenedor de vistas desde la vista reciclada.
            holder = (ViewHolder) convertView.getTag();
        }
        // Se escriben los datos en las vistas del contenedor de vistas.
        onBindViewHolder(holder, position);
        // Se retorna la vista que representa el elemento.
        return convertView;
    }

    // Cuando se deben escribir los datos en la vista del elemento.
    private void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(mDatos.get(position));
    }

    // Contenedor de vistas para la vista-fila.
    static class ViewHolder {

        // El contenedor de vistas para un elemento de la lista debe contener...
        private final TextView lblTitulo;
        private final TextView lblAutor;
        private final TextView lblYear;

        // El constructor recibe la vista-fila.
        public ViewHolder(View itemView) {
            // Se obtienen las vistas de la vista-fila.
            lblTitulo = (TextView) itemView.findViewById(R.id.nameTextView);
            lblAutor = (TextView) itemView.findViewById(R.id.autorTextView);
            lblYear = (TextView) itemView.findViewById(R.id.yearTextView);
        }

        // Escribe los datos de la obra en las vistas.
        public void bind(Book b) {
            lblTitulo.setText(b.getTítulo());
            lblAutor.setText(b.getAutor());
            lblYear.setText(String.valueOf(b.getAñoPublicación()));
        }

    }
}
