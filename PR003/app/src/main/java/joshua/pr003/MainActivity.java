package joshua.pr003;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private CheckBox checkBox1;
    private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initViews(){
        editText1 =(EditText)findViewById(R.id.editText);
        checkBox1 =(CheckBox)findViewById(R.id.checkBox);
        button1 =(Button)findViewById(R.id.button);

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Modo educado activado",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Modo educado desactivado",
                            Toast.LENGTH_LONG).show();
                }

            }
        });
        /*button1.setOnClickListener(new View.OnClickListener() {
            String cad = "";
            if(checkbox1.ischecked)
            {
                cad="";
            }else {

            }

            public void onClick(View v) {
                Toast.makeText(MainActivity.this, cad,
                        Toast.LENGTH_LONG).show();
            }
        });*/
    }



}
