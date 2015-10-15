package joshu.pr013;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initViews(){
        editText=(EditText)findViewById(R.id.editText);
        button=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviar(editText.getText().toString());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarOtra(editText.getText().toString());
            }
        });
    }

    public void enviar(String textToSend){
        Intent intencion=new Intent();
        intencion.setAction(Intent.ACTION_SEND);
        intencion.setType("text/plain");
        intencion.putExtra(android.content.Intent.EXTRA_TEXT, textToSend);

        startActivity(intencion);
    }

    public void enviarOtra(String textToSend){
        Intent intencion=new Intent(this, Main2Activity.class);
        intencion.putExtra(android.content.Intent.EXTRA_TEXT, textToSend);

        startActivity(intencion);
    }
}
