package joshu.pr013;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView textView;
    public static final String INTENT_TEXT="440";
    private String text="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text=getIntent().getStringExtra(INTENT_TEXT);
        initViews();
    }

    public void initViews(){
        textView=(TextView)findViewById(R.id.textView);
        textView.setText(text);
    }
}
