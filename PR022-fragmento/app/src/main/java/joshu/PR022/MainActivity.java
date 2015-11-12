package joshu.PR022;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragments("Friendship is Magic");
        initViews();
    }

    private void initViews(){
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                loadFragments("Hello everypony");
                SecondActivity.start(MainActivity.this,"MLP");
            }
        });
    }

    private void loadFragments(String msg) {
        FragmentManager gestorFragmentos= getSupportFragmentManager();
        gestorFragmentos.beginTransaction();
        FragmentTransaction transaccion=gestorFragmentos.beginTransaction();
        transaccion.replace(R.id.f1huevo, UnoFragment.newInstance(msg));//add lo colocaria otro encima del que hubiera
        transaccion.commit();
    }
}
