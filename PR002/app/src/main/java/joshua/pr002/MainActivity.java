package joshua.pr002;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText,editText2,editText3;
    private Button btnNomApe,btnApeNom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initViews(){
        editText3=(EditText)findViewById(R.id.ediText3);
        editText=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);
        btnNomApe=(Button)findViewById(R.id.btnNomApe);
        btnApeNom=(Button)findViewById(R.id.btnApeNom);
    }

    public void btnNomApeOnClick(View v){
        editText3.setText(editText.getText().toString() + " " + editText2.getText().toString());
    }

    public void btnApeNomOnClick(View v){
        editText3.setText(editText2.getText().toString()+" "+editText.getText().toString());
    }
}
