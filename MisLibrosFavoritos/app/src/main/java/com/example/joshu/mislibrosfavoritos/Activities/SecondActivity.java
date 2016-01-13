package com.example.joshu.mislibrosfavoritos.Activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.joshu.mislibrosfavoritos.BddFicticia.Book;
import com.example.joshu.mislibrosfavoritos.Fragments.CreateFragment;
import com.example.joshu.mislibrosfavoritos.R;

/**
 * Created by joshu on 11/12/2015.
 */
public class SecondActivity extends AppCompatActivity implements CreateFragment.OnCreateBookListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        // La toolbar actuará como ActionBar.
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        // La ActionBar mostrará el icono de navegación.
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        //cargar fragmento
        FragmentManager gestorFragmentos = this.getFragmentManager();
        FragmentTransaction transaccion = gestorFragmentos.beginTransaction();
        CreateFragment createFragment = CreateFragment.newInstance();
        transaccion.replace(R.id.f2hueco, createFragment);
        transaccion.commit();

    }

    @Override
    public void onCreateBook(Book b, int position) {
        //obligado para usar el fragmento
    }

}
