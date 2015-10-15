package joshu.pr012ciclovida;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String STATE_CONTADOR = "estado del contador";
    public int mContador=0;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null){
            mContador=savedInstanceState.getInt(STATE_CONTADOR);
        }
        initViews();
    }

    public void initViews(){
        button=(Button)findViewById(R.id.button);
        textView=(TextView)findViewById(R.id.textView);
        textView.setText(String.valueOf(mContador));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContador++;
                textView.setText(String.valueOf(mContador));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_CONTADOR,mContador);
    }
}
