package joshu.practica1trim.Fragments;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import joshu.practica1trim.Adapters.Contacto;
import joshu.practica1trim.R;

/**
 * Created by joshu on 02/12/2015.
 */
public class DetailFragment extends android.app.Fragment {

    // Interfaz para notificación de eventos desde el fragmento.
    public interface OnDetailShownListener {
        // Cuando se selecciona una obra.
        public void onDetailShown(int position);
    }

    // Constantes.
    public static final String EXTRA_CONTACO = "contacto";
    public static final String EXTRA_POSITION = "position";

    // Vistas.
    private ImageView imgFoto;
    private TextView lblNombre,lblAge,lblTelefono,lblCity,lblEmail;

    // Variables
    private Contacto mContacto;
    private int mPosition;
    private OnDetailShownListener mListener;

    // Retorna una nueva instancia del fragmento configurado.
    public static DetailFragment newInstance(Contacto c, int position) {
        DetailFragment frgDetalle = new DetailFragment();
        Bundle argumentos = new Bundle();
        argumentos.putParcelable(EXTRA_CONTACO, c);
        argumentos.putInt(EXTRA_POSITION, position);
        frgDetalle.setArguments(argumentos);
        return frgDetalle;
    }

    // Retorna la vista que debe mostrar el fragmento.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Se infla el layout y se retorna la vista.
        return inflater.inflate(R.layout.detail_fragment, container, false);
    }

    // Cuando se vincula el fragmento a la actividad.
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            // La actividad actuar como listener cuando se seleccione una obra.
            mListener = (OnDetailShownListener) activity;
        } catch (ClassCastException e) {
            // La actividad no implementa la interfaz necesaria.
            throw new ClassCastException(activity.toString() + " debe implementar OnDetalleShownListener");
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
        initVistas();
        // Se obtiene la obra desde el bundle de parámetros.
        mContacto = this.getArguments().getParcelable(EXTRA_CONTACO);
        mPosition = getArguments().getInt(EXTRA_POSITION);
        // Si hay obra, se muestra.
        if (mContacto != null) {
            mostrarDetalle();
        }
        super.onActivityCreated(savedInstanceState);
    }

    // Obtiene e inicializa las vistas.
    private void initVistas() {
        if (getView() != null) {
            imgFoto = (ImageView) getView().findViewById(R.id.imageView);
            lblNombre = (TextView) getView().findViewById(R.id.nameTextView);
            lblAge = (TextView) getView().findViewById(R.id.ageTextView);
            lblTelefono = (TextView) getView().findViewById(R.id.telefonoTextView);
            lblCity = (TextView) getView().findViewById(R.id.cityTextView);
            lblEmail = (TextView) getView().findViewById(R.id.emailTextView);
        }
    }

    // Muestra el detalle de un album en las vistas correspondientes.
    void mostrarDetalle() {
        getActivity().setTitle(getResources().getString(R.string.detail_fragment_title));
        lblNombre.setText(mContacto.getName());
        lblAge.setText(String.valueOf(mContacto.getAge()));
        lblCity.setText(mContacto.getCity());
        lblTelefono.setText(mContacto.getTelefono());
        lblEmail.setText(mContacto.getEmail());
        imgFoto.setImageResource(R.drawable.android_icon);
        // Se notifica a la actividad.
        if (mListener != null) {
            mListener.onDetailShown(mPosition);
        }
    }
}
