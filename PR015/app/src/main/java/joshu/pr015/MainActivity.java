package joshu.pr015;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView, textView2, textView3;
    private Button button;
    private Alumno mAlumno;
    public static final int RC_SM=440;
    public static final String SV_ALUMNO="440";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        if (savedInstanceState!=null){
            mAlumno=savedInstanceState.getParcelable(SV_ALUMNO);
            editText.setText(mAlumno.getDni());
            textView.setText(mAlumno.getNombre());
            textView2.setText(String.valueOf(mAlumno.getEdad()));
            textView3.setText(mAlumno.getSexo());
        }else{
            mAlumno=new Alumno();
        }

    }

    public void initViews() {
        button=(Button)findViewById(R.id.button);
        editText=(EditText)findViewById(R.id.editText);
        textView=(TextView)findViewById(R.id.textView3);
        textView2=(TextView)findViewById(R.id.textView);
        textView3=(TextView)findViewById(R.id.textView11);
        button.setEnabled(false);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAlumno.setDni(editText.getText().toString());
                askData(MainActivity.this, mAlumno);
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
                if (TextUtils.isEmpty(editText.getText())) {
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                }
            }
        });
    }

    public static void askData(Activity a, Alumno aux){
        Intent intento=new Intent(a,Main2Activity.class);
        intento.putExtra(Main2Activity.DR_DNI, aux);
        a.startActivityForResult(intento, RC_SM);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent answer) {
        if (resultCode == RESULT_OK && requestCode == RC_SM) {
            if ( answer.hasExtra( Main2Activity.DS_NAME_EDAD) ) {
                mAlumno=answer.getParcelableExtra(Main2Activity.DS_NAME_EDAD);
                textView.setText( mAlumno.getNombre() );
                textView2.setText( String.valueOf(mAlumno.getEdad()) );
                textView3.setText( mAlumno.getSexo() );
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(SV_ALUMNO,mAlumno);
    }
}
