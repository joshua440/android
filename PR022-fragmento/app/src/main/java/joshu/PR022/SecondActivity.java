package joshu.PR022;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by joshu on 12/11/2015.
 */
public class SecondActivity extends AppCompatActivity implements UnoFragment.CallBack {

    public static final String KEY_MSG="sdmsg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        loadFragments(getIntent().getStringExtra(KEY_MSG));
    }

    public static void start(Context context,String message){
        Intent intencion=new Intent(context,SecondActivity.class);
        intencion.putExtra(KEY_MSG, message);
        context.startActivity(intencion);

    }

    private void loadFragments(String msg) {
        FragmentManager gestorFragmentos= getSupportFragmentManager();
        gestorFragmentos.beginTransaction();
        FragmentTransaction transaccion=gestorFragmentos.beginTransaction();
        transaccion.replace(R.id.f2hueco, UnoFragment.newInstance(msg));//add lo colocaria otro encima del que hubiera
        transaccion.commit();
    }

    @Override
    public void pulsado(String msg) {

    }
}
