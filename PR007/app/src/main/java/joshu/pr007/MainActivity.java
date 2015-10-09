package joshu.pr007;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final float DEFAULT_CUENTA = 0.00f;
    private static final int DEFAULT_PORCENTAJE = 2, DEFAULT_COMENSALES = 1;
    private TextView textView,textView2,textView3;
    private EditText editText,editText2,editText3,editText4,editText5,editText6;
    private Button button, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }
    public void initVistas(){
        textView=(TextView)findViewById(R.id.textView);
        textView2=(TextView)findViewById(R.id.textView3);
        textView3=(TextView)findViewById(R.id.textView6);
        editText=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);
        editText3=(EditText)findViewById(R.id.editText3);
        editText4=(EditText)findViewById(R.id.editText4);
        editText5=(EditText)findViewById(R.id.editText5);
        editText6=(EditText)findViewById(R.id.editText6);
        button=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button3);

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editText.setText("0");
                editText3.setText(String.valueOf(DEFAULT_PORCENTAJE));
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editText6.setText(String.valueOf(DEFAULT_COMENSALES));
            }
        });
    }
}
