package joshu.pr016v2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    private EditText editText;
    private ArrayAdapter<String> adaptador;
    private ArrayList<String> alumnos;
    private ListView listView;
    private ImageButton imageButton;
    private static final String STATE_ARRAY = "estado del array";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        if (savedInstanceState != null) {
            alumnos = savedInstanceState.getStringArrayList(STATE_ARRAY);
        } else {
            alumnos = new ArrayList<>();
        }
    }

    private void initViews() {
        imageButton = (ImageButton) findViewById(R.id.add);
        imageButton.setOnClickListener(this);
        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.txtNombre);
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkDatos(s.toString());
            }

        });
        checkDatos(editText.getText().toString());
        editText.setOnEditorActionListener(new OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String nombre = editText.getText().toString();
                    if (!TextUtils.isEmpty(nombre)) {
                        agregarAlumno(nombre);
                        return true;
                    }
                }
                return false;
            }
        });
        //lstAlumnos.setEmptyView(findViewById(R.id.lblNoHayAlumnos));
        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alumnos);
        listView.setAdapter(adaptador);
        listView.setOnItemClickListener(this);
    }

    private void checkDatos(String nombre) {
        imageButton.setEnabled(!TextUtils.isEmpty(nombre));
    }

    @Override
    public void onItemClick(AdapterView<?> lst, View v, int position, long id) {
        eliminarAlumno(lst.getItemAtPosition(position));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
                if (!TextUtils.isEmpty(editText.getText().toString())) {
                    agregarAlumno(editText.getText().toString());
                }
                break;
        }
    }

    private void agregarAlumno(String nombre) {
        adaptador.add(nombre);
        editText.setText("");
        checkDatos(editText.getText().toString());
    }

    private void eliminarAlumno(Object item) {
        adaptador.remove((String) item);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(STATE_ARRAY, alumnos);
    }
}
