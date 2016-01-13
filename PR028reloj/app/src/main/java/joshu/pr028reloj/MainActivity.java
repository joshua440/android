package joshu.pr028reloj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public TextView textView;
    private Button button;
    private Thread secondThread;
    private final SimpleDateFormat formateador = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initViews(){
        button=(Button)findViewById(R.id.button);
        textView=(TextView)findViewById(R.id.textView);
        secondThread=new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button:
                        if (button.getText().toString().equals(getString(R.string.buttonContinueText))) {
                            iniciar();
                        } else {
                            parar();
                        }
                        break;
                }
            }
        });
    }

    private void iniciar() {
        // Se crea el hilo pasándole el tiempo guardado al objeto Crono.
        secondThread = new Thread(new Reloj(), "Secundario");
        // Se inicia el hilo.
        secondThread.start();
        // Se cambia el texto del botón.
        button.setText(R.string.buttonStopText);
    }

    private void parar() {
        // Se interrumple el hilo.
        secondThread.interrupt();
        // Se cambia el texto del botón.
        button.setText(R.string.buttonContinueText);
    }

    private class Reloj implements Runnable {

        // Variables a nivel de clase.
        final SimpleDateFormat formateador = new SimpleDateFormat("HH:mm:ss");

        @Override
        public void run() {
            while (true) {
                // Se obtiene la representación en cadena de la hora actual.
                // La variable debe ser final para que se pueda enviar en el
                // Runnable que se envía al hilo principal.
                final String cadena = formateador.format(new Date());
                // Se envía la actualización al hilo principal.
                textView.post(new Runnable() {

                    @Override
                    public void run() {
                        textView.setText(cadena);
                    }

                });
                // Espera un segundo.
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // Se finaliza el hilo si se produce la interrupción
                    // mientras se duerme.
                    return;
                }
            }
        }

    }
}
