package joshua.pr004;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioButton r1, r2, r3, r4;
    private Button b1;
    private ImageView i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    public void initViews(){
        r1=(RadioButton)findViewById(R.id.radioButton1);
        r2=(RadioButton)findViewById(R.id.radioButton2);
        r3=(RadioButton)findViewById(R.id.radioButton3);
        r4=(RadioButton)findViewById(R.id.radioButton4);
        b1=(Button)findViewById(R.id.button);
        i1=(ImageView)findViewById(R.id.imageView);

        i1.setOnClickListener(this);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Me gusta", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onClick(View v) {
        // Dependiendo de la vista sobre la que se ha pulsado.
        switch (v.getId()) {
            case R.id.radioButton1:
                i1.setImageResource(R.drawable.spring);
                break;
            case R.id.radioButton2:
                i1.setImageResource(R.drawable.summer);
                break;
            case R.id.radioButton3:
                i1.setImageResource(R.drawable.autumn);
                break;
            case R.id.radioButton4:
                i1.setImageResource(R.drawable.winter);
                break;
        }
    }
}
