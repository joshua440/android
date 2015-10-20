package joshu.pr014;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private EditText editText, editText2;
    private TextView textView;
    private Button button;
    private Boolean edtx1=false, edtx2=false;
    public static final String DR_DNI="dni", DS_NAME="nombre", DS_AGE="edad";
    private String textDni="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textDni=getIntent().getStringExtra(DR_DNI);
        initViews();
    }

    public void initViews(){
        button=(Button)findViewById(R.id.button2);
        textView=(TextView)findViewById(R.id.textView8);
        textView.setText(textDni);
        editText=(EditText)findViewById(R.id.editText2);
        editText2=(EditText)findViewById(R.id.editText3);
        button.setEnabled(false);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(editText.getText()) && TextUtils.isEmpty(editText2.getText())) {
                    edtx1=false;
                } else {
                    edtx1=true;
                }
                editSynchro();
            }
        });
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(editText.getText()) && TextUtils.isEmpty(editText2.getText())) {
                    edtx2=false;
                } else {
                    edtx2=true;
                }
                editSynchro();
            }
        });
    }

    public void editSynchro(){
        if (edtx1&&edtx2){
            button.setEnabled(true);
        } else {
            button.setEnabled(false);
        }
    }

    @Override
    public void finish() {
        Intent resultado = new Intent();
        resultado.putExtra(DS_NAME, editText2.getText().toString());
        resultado.putExtra(DS_AGE, Integer.valueOf(editText.getText().toString()));
        setResult(RESULT_OK, resultado);
        super.finish();
    }

}
