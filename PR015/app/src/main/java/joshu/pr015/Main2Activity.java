package joshu.pr015;

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
    private Alumno mAlumno;
    private Boolean edtx1=false, edtx2=false;
    public static final String DR_DNI="dni", DS_NAME_EDAD ="nombre/edad";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mAlumno=getIntent().getParcelableExtra(DR_DNI);
        initViews();
    }

    public void initViews(){
        button=(Button)findViewById(R.id.button2);
        textView=(TextView)findViewById(R.id.textView8);
        textView.setText(mAlumno.getDni());
        editText=(EditText)findViewById(R.id.editText3);
        editText2=(EditText)findViewById(R.id.editText2);
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
        mAlumno.setNombre(editText.getText().toString());
        mAlumno.setEdad(Integer.valueOf(editText2.getText().toString()));
        resultado.putExtra(DS_NAME_EDAD,mAlumno);
        setResult(RESULT_OK, resultado);
        super.finish();
    }

}
