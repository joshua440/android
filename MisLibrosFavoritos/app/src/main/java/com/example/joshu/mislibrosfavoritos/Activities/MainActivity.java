package com.example.joshu.mislibrosfavoritos.Activities;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.joshu.mislibrosfavoritos.BddFicticia.Book;
import com.example.joshu.mislibrosfavoritos.Fragments.ListFragment;
import com.example.joshu.mislibrosfavoritos.R;

public class MainActivity  extends AppCompatActivity implements ListFragment.OnBookSelectedListener {

    // Variables.
    private FragmentManager mGestorFragmentos;

    // Al crear la actividad.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // La toolbar actuará como ActionBar.
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        // Se obtiene el gestor de fragmentos.
        mGestorFragmentos = getFragmentManager();
        // Si el fragmento de lista no está cargado ya, se carga.
        ListFragment frgLista = (ListFragment) mGestorFragmentos.findFragmentByTag("frgLista");
        if (frgLista == null) {
            // Se carga el fragmento de lista (sin añadirlo a la BackStack, ya
            // que es un fragmento fijo que además retendrá su estado entre
            // cambios de configuración).
            frgLista = new ListFragment();
            mGestorFragmentos.beginTransaction().replace(R.id.f1hueco, frgLista, "frgLista").commit();
        }
    }

    // Cuando en el fragmento frgLista se selecciona un Contacto.
    @Override
    public void onBookSelectedListener(Book book, int position) {
        // Se marca el contacto cuyo detalle ha sido mostrado.
        ListFragment frg = (ListFragment) mGestorFragmentos.findFragmentById(R.id.f1hueco);
        if (frg != null) {
            frg.marcarLibro(position);
        }
    }

    //toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Dependiendo del ítem pulsado.
        int id = item.getItemId();
        // Siguiente.
        if (id == R.id.mnuNext) {
            // Se inicia la actividad secundaria.
            startActivity(new Intent(this, SecondActivity.class));
            return true;
        }
        // Configuración.
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
