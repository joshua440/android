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

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView, textView2;
    private Button button;
    public static final int RC_SM=440;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initViews() {
        button=(Button)findViewById(R.id.button);
        editText=(EditText)findViewById(R.id.editText);
        textView=(TextView)findViewById(R.id.textView);
        textView2=(TextView)findViewById(R.id.textView3);
        button.setEnabled(false);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askData(MainActivity.this, editText.getText().toString());
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
                if (TextUtils.isEmpty(editText.getText())){
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                }
            }
        });
    }

    public static void askData(Activity a, String dni){
        Intent intento=new Intent(a,Main2Activity.class);
        intento.putExtra(Main2Activity.DR_DNI,dni);
        a.startActivityForResult(intento, RC_SM);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent answer) {
        if (resultCode == RESULT_OK && requestCode == RC_SM) {
            if ( answer.hasExtra( Main2Activity.DS_NAME) && answer.hasExtra(Main2Activity.DS_AGE) ) {
                textView2.setText(answer.getStringExtra(Main2Activity.DS_NAME));
                textView.setText( String.valueOf(answer.getIntExtra(Main2Activity.DS_AGE,18)) );
            }
        }
    }
}
