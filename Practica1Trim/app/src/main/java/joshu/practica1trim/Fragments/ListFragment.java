package joshu.practica1trim.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;

import joshu.practica1trim.Adapters.Contacto;
import joshu.practica1trim.Adapters.ContactoList;
import joshu.practica1trim.Adapters.OwnArrayAdapter;
import joshu.practica1trim.R;

/**
 * Created by joshu on 02/12/2015.
 */
public class ListFragment extends android.app.Fragment implements AdapterView.OnItemClickListener {

    // Interfaz para notificación de eventos desde el fragmento.
    public interface OnContactoSelectedListener {
        // Cuando se selecciona una obra.
        public void onContactoSelected(Contacto Contacto, int position);
    }

    // Vistas.
    private ListView lstContactos;

    private OnContactoSelectedListener mListener;
    private int mItemSeleccionado;

    // Cuando se crea el fragmento.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Se mantendrá la instancia del fragmento al cambiar la configuración.
        setRetainInstance(true);
        super.onCreate(savedInstanceState);
        //se avisa que va a agregar un menu a la toolbar
        setHasOptionsMenu(true);
    }

    // Retorna la vista que mostrará el fragmento.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Se infla el layout del fragmento y se retorna la vista.
        return inflater.inflate(R.layout.list_fragment, container, false);
    }

    // Cuando se vincula el fragmento a la actividad.
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            // La actividad actuará como listener cuando se seleccione una obra.
            mListener = (OnContactoSelectedListener) activity;
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
        // Se comprueba si existe el fragmento de detalle y por tanto se usan
        // dos paneles.
        FrameLayout flDetalle = (FrameLayout) getActivity().findViewById( R.id.f2hueco);
        boolean mDosPaneles = flDetalle != null && flDetalle.getVisibility() == View.VISIBLE;
        // El fragmento actuará como listener cuando se pulse sobre un elemento
        // de la lista.
        lstContactos.setOnItemClickListener(this);
        if (mDosPaneles) {
            pulsarItem(mItemSeleccionado);
        } else {
            marcarContacto(mItemSeleccionado);
        }
    }

    // Obtiene e inicializa las vistas.
    private void initVistas() {
        if (getView() != null) {
            // Se crea el adaptador y se asigna al ListView.
            lstContactos = (ListView) getView().findViewById(R.id.listListView);
            OwnArrayAdapter mAdaptador = new OwnArrayAdapter(this.getActivity(), getDatos());
            lstContactos.setAdapter(mAdaptador);
        }
    }

    // Retorna el ArrayList de datos para la lista.
    private ArrayList<Contacto> getDatos() {
        //Inicializo lista de contactos
        ContactoList.addDefaultContactos();
        return ContactoList.getList();
    }

    // Al pulsar sobre un elemento de la lista.
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        // Se pulsa sobre el item.
        pulsarItem(position);
    }

    // Cuando se "pulsa" sobre un elemento. Recibe la posición.
    private void pulsarItem(int position) {
        // Se marca la obra seleccionada (por defecto la 0).
        marcarContacto(position);
        // Se muestra el detalle de la obra.
        if (mListener != null) {
            // Se llama al método correspondiente del listener.
            mListener.onContactoSelected(
                    (Contacto) lstContactos.getItemAtPosition(position), position);
        }
    }

    // Marca el contacto seleccionado. Recibe su posicion
    public void marcarContacto(int position) {
        mItemSeleccionado = position;
        Contacto c = (Contacto) lstContactos.getItemAtPosition(mItemSeleccionado);
        lstContactos.setItemChecked(mItemSeleccionado, true);
        lstContactos.setSelection(mItemSeleccionado);
        getActivity().setTitle(getResources().getString(R.string.list_fragment_title));
    }

    //creado desde fragmento
    //toolbar
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.activity_main_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Dependiendo del ítem pulsado.
        int id = item.getItemId();
        // Siguiente.
        if (id == R.id.menuAdd) {
            //llamar a fragmento de creacion de contacto
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
