package joshu.pr030asyntask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainActivity.Callbacks {

    private ProgressBar prbBarra;
    private TextView lblMensaje;
    private ProgressBar prbCirculo;
    private Button btnIniciar;

    private TareaSecundaria tarea;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    // Obtiene e inicializa las vistas.
    private void initVistas() {
        prbBarra = (ProgressBar) findViewById(R.id.prbBarra);
        lblMensaje = (TextView) findViewById(R.id.lblMensaje);
        prbCirculo = (ProgressBar) findViewById(R.id.prbCirculo);
        btnIniciar = (Button) findViewById(R.id.btnIniciar);
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciar();
            }
        });
    }

    // Cuando se hace click en btnIniciar.
    private void iniciar() {
        btnIniciar.setEnabled(false);
        // Se crea la tarea secundaria.
        tarea = new TareaSecundaria(this);
        // Lanzo la tarea secundaria indicando que debe hacer 10 trabajos.
        tarea.execute(10);
    }

    private void mostrarBarras() {
        prbBarra.setVisibility(View.VISIBLE);
        lblMensaje.setText(R.string.trabajando);
        lblMensaje.setVisibility(View.VISIBLE);
        prbCirculo.setVisibility(View.VISIBLE);
    }

    // Resetea las vistas.
    private void resetearVistas() {
        prbBarra.setVisibility(View.INVISIBLE);
        prbBarra.setProgress(0);
        prbCirculo.setVisibility(View.INVISIBLE);
        prbCirculo.setProgress(0);
        btnIniciar.setEnabled(true);
    }

    @Override
    public void onPreExecute() {
        // Se hacen visibles las vistas para el progreso.
        mostrarBarras();
    }

    @Override
    public void onProgressUpdate(int progress) {
        // Se actualiza la barra.
        lblMensaje.setText(getString(R.string.trabajando, progress, 10));
        prbBarra.setProgress(progress);
    }

    @Override
    public void onPostExecute(int result) {
        // Se muestra el mensaje de finalización.
        lblMensaje.setText(getResources().getQuantityString(
                R.plurals.realizadas, result, result));
        resetearVistas();
    }

    // Al pausar la actividad.
    @Override
    protected void onPause() {
        super.onPause();
        if (tarea != null) {
            // Se cancela la tarea.
            tarea.cancel(true);
            tarea = null;
        }
    }

    // Definimos una interfaz para que la actividad sea informada cuando se
    // haya finalizado la tarea.
    public interface Callbacks {
        void onPreExecute();

        void onProgressUpdate(int progress);

        void onPostExecute(int result);
    }
    // Clase interna para la Tarea Secundaria. Tipos recibidos:
// - Entrada: El tipo del valor recibido por doInBackground y que se pasa en
// el método execute().
// - Progreso: El tipo del valor recibido por onProgressUpdate y que se pasa
// al hacer publishProgress().
// - Salida: El tipo del valor recibido por onPostExecute y que corresponde
// al valor de retorno del doInBackground.
    class TareaSecundaria extends AsyncTask<Integer, Integer, Integer> {

        // Variables a nivel de clase.
        private Callbacks mListener;

        // Constructor.
        public TareaSecundaria(Callbacks listener) {
            mListener = listener;
        }

        // Llamado antes de lanzar el hilo secundario. Se ejecuta en el hilo
        // principal.
        @Override
        protected void onPreExecute() {
            mListener.onPreExecute();
        }

        // Llamado al lanzar el hilo secundario y corresponde al código que éste
        // ejecuta. Recibe lo que se le pase al método execute() cuando se
        // ejecute la tarea asíncrona. Se puede informar del progreso mediante
        // el método publishProgress().
        @Override
        protected Integer doInBackground(Integer... params) {
            int numTrabajos = params[0];
            // Se realizan los pasos.
            for (int i = 0; i < numTrabajos; i++) {
                // Se pone a trabajar.
                trabajar();
                // Si la tarea ha sido cancelada se sale del bucle.
                if (isCancelled()) {
                    break;
                }
                // Informa del progreso.
                publishProgress(i + 1);
            }
            // Se retorna el número de trabajos realizados.
            return numTrabajos;
        }

        // Cada vez que se llama a publishProgress()
        @Override
        protected void onProgressUpdate(Integer... values) {
            mListener.onProgressUpdate(values[0]);
        }

        @Override
        protected void onCancelled() {
            // Se libera el mListener.
            mListener = null;
        }

        // Es lanzado automáticamente cuando se termina de ejecutar
        // doInBackground. Recibe lo que haya retornado éste. Se ejecuta en el
        // hilo principal.
        @Override
        protected void onPostExecute(Integer result) {
            if (mListener != null) {
                mListener.onPostExecute(result);
            }
        }

        // Simula un trabajo de 1 segundo.
        private void trabajar() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
