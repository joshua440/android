package joshu.practica1trim.Activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import joshu.practica1trim.Adapters.Contacto;
import joshu.practica1trim.Fragments.DetailFragment;
import joshu.practica1trim.R;

public class SecondActivity extends AppCompatActivity implements DetailFragment.OnDetailShownListener {

    // Al crear la actividad.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // La toolbar actuará como ActionBar.
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        // Cargo el fragmento de detalle en el FrameLayout.
        FragmentManager gestorFragmentos = this.getFragmentManager();
        FragmentTransaction transaccion = gestorFragmentos.beginTransaction();
        DetailFragment frgDetalle = DetailFragment.newInstance(
                (Contacto) getIntent().getExtras().getParcelable(
                        DetailFragment.EXTRA_CONTACO), getIntent().getExtras()
                        .getInt(DetailFragment.EXTRA_POSITION));
        transaccion.replace(R.id.f2hueco, frgDetalle);
        transaccion.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDetailShown(int position) {
        // Es obligatorio que toda actividad que utilice el fragmento
        // DetalleActivity implemente la interfaz OnDetallaShownListner, aunque
        // en este caso no se hace nada.

    }
}
