package joshu.pr018;

import android.animation.ObjectAnimator;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    private ListView listView;
    private ImageView imageView;
    private TextView textView;
    private View view;
    private Button button;

    private ArrayList<String> answers;
    private ObjectAnimator mObjectAnimator;
    private ArrayAdapter<String> mAdaptador;
    private int mPuntuacion = 100;
    private static final long INITIAL_COUNT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initViews(){
        imageView=(ImageView)findViewById(R.id.imageView);
        listView=(ListView)findViewById(R.id.listView);
        textView=(TextView)findViewById(R.id.textView2);
        view=findViewById(R.id.view);
        button=(Button)findViewById(R.id.button);

        Picasso.with(this).load("http://lorempixel.com/output/cats-q-c-150-150-3.jpg").into(imageView);
        button.setOnClickListener(this);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setOnItemClickListener(this);

    }

    @Override
    protected void onResume() {
        animarFondoContador();
        long INTERVAL_COUNT = 1000;
        new CountDownTimer(INITIAL_COUNT, INTERVAL_COUNT) {
            public void onTick(long millisUntilFinished) {
                textView.setText((millisUntilFinished / 1000) + "");
            }
            public void onFinish() {
                button.setVisibility(View.VISIBLE);
            }
        }.start();
        super.onResume();
    }
    private void animarFondoContador() {
        mObjectAnimator = ObjectAnimator.ofFloat(view, View.ROTATION, 0.0f, (INITIAL_COUNT / 1000) * 360.0f);
        mObjectAnimator.setDuration(INITIAL_COUNT);
        mObjectAnimator.setRepeatMode(ObjectAnimator.RESTART);
        mObjectAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        mObjectAnimator.setInterpolator(new LinearInterpolator());
        mObjectAnimator.start();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        button.setEnabled(true);
    }

    @Override
    public void onClick(View v) {

    }
}
