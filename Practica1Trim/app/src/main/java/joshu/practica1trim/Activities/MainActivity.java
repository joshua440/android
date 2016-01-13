package joshu.practica1trim.Activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import joshu.practica1trim.Adapters.Contacto;
import joshu.practica1trim.Adapters.ContactoList;
import joshu.practica1trim.Fragments.DetailFragment;
import joshu.practica1trim.Fragments.ListFragment;
import joshu.practica1trim.R;

public class MainActivity extends AppCompatActivity implements DetailFragment.OnDetailShownListener,ListFragment.OnContactoSelectedListener {

    // Variables.
    private FragmentManager mGestorFragmentos;

    // Vistas.
    private FrameLayout flDetalle;

    // Al crear la actividad.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // La toolbar actuará como ActionBar.
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        // Se obtienen las vistas.
        flDetalle = (FrameLayout) this.findViewById(R.id.f2hueco);
        // Se obtiene el gestor de fragmentos.
        mGestorFragmentos = getFragmentManager();
        // Si el fragmento de lista no está cargado ya, se carga.
        // MUY IMPORTANTE: Si no, se llama varias veces el onActivityCreated()
        // del fragmento.
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
    public void onContactoSelected(Contacto contacto, int position) {
        // Si hay FrameLayout de detalle (puede que no haya porque por el tamaño
        // del dispositivo tengamos dos actividades distintas).
        if (flDetalle != null) {
            // Se muestra el detalle del Contacto.
            mostrarFragmentoDetalle(contacto, position);
        } else {
            // Hay dos actividades. Se llama a la otra actividad pasándole la
            // obra a mostrar (cuya clase debe implementar Parcelable).
            Intent i = new Intent(this, SecondActivity.class);
            i.putExtra(DetailFragment.EXTRA_CONTACO, contacto);
            this.startActivity(i);
        }
    }

    // Carga el fragmento de detalle en el FrameLayout correspondiente.
    void mostrarFragmentoDetalle(Contacto c, int position) {
        // Se crea una nueva instancia del fragmento de detalle pasándole la
        // obra como parámetro.
        DetailFragment frgDetalle = DetailFragment.newInstance(c, position);
        // Se realiza la transacción y se añade a la BackStack especificando
        // como tag el índice de la lista.
        FragmentTransaction transaccion = mGestorFragmentos.beginTransaction();
        transaccion.replace(R.id.f2hueco, frgDetalle);
        transaccion.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        transaccion.addToBackStack(c.getName());
        transaccion.commit();
    }

    // Cuando se muestra un determinado detalle (necesario para la actualización
    // de la interfaz con la BackStack.
    @Override
    public void onDetailShown(int position) {
        // Se marca el contacto cuyo detalle ha sido mostrado.
        ListFragment frg = (ListFragment) mGestorFragmentos.findFragmentById(R.id.f1hueco);
        if (frg != null) {
            frg.marcarContacto(position);
        }
    }

}
