package joshu.PR022;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements UnoFragment.CallBack{

    private Button button;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragments("Magic",R.id.f1hueco);
        initViews();
    }

    private void initViews(){
        msg="";
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(findViewById(R.id.f2hueco)==null){
                    loadFragments("Hello",R.id.f1hueco);
                    SecondActivity.start(MainActivity.this,"MLP");
                } else {
                    loadFragments("Hello", R.id.f2hueco);
                }

            }
        });
    }

    private void loadFragments(String msg, int id) {
        FragmentManager gestorFragmentos= getSupportFragmentManager();
        gestorFragmentos.beginTransaction();
        FragmentTransaction transaccion=gestorFragmentos.beginTransaction();
        transaccion.replace(id, UnoFragment.newInstance(msg));//add lo colocaria otro encima del que hubiera
        transaccion.commit();
    }

    @Override
    public void pulsado(String msg) {
        this.msg=msg;
        if(findViewById(R.id.f2hueco)==null){
            loadFragments(msg,R.id.f1hueco);
            SecondActivity.start(MainActivity.this,msg);
        } else {
            loadFragments(msg, R.id.f2hueco);
        }
    }
}
