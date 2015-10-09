package joshu.pr009;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText,editText2;
    private TextInputLayout textInputLayout, textInputLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    public void initViews(){
        editText=(EditText)findViewById(R.id.editText2);
        editText2=(EditText)findViewById(R.id.editText3);
        textInputLayout=(TextInputLayout)findViewById(R.id.tilTelefono);
        textInputLayout2=(TextInputLayout)findViewById(R.id.tilCorreo);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!editText.getText().toString().isEmpty()){
                    if(!editText.getText().toString().matches("[6-9]{1}[0-9]{8}")){
                        textInputLayout.setError("Numero de telefono invalido");
                    } else {
                        textInputLayout.setErrorEnabled(false);
                    }
                } else {
                    textInputLayout.setErrorEnabled(false);
                }
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
                if(!editText2.getText().toString().isEmpty()){
                    if(!editText2.getText().toString().matches(".*[@]{1}.*[.]{1}[a-z]{3}")){
                        textInputLayout2.setError("Numero de telefono invalido");
                    } else {
                        textInputLayout2.setErrorEnabled(false);
                    }
                }else {
                    textInputLayout2.setErrorEnabled(false);
                }

            }
        });
    }
}
