package joshu.pr021;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Alumno> alumnList = new ArrayList<Alumno>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    public void initViews(){
        listView=(ListView)findViewById(R.id.listView);
        alumnList.add(new Alumno("a","600091377"));
        alumnList.add(new Alumno("b","600091377"));
        alumnList.add(new Alumno("c","600091377"));
        alumnList.add(new Alumno("d","600091377"));
        alumnList.add(new Alumno("e","600091377"));
        alumnList.add(new Alumno("f","600091377"));
        alumnList.add(new Alumno("g","600091377"));
        alumnList.add(new Alumno("h","600091377"));
    }
}
