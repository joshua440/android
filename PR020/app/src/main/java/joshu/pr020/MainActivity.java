package joshu.pr020;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initViews(){
        editText=(EditText)findViewById(R.id.editText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator = getMenuInflater();
        inflator.inflate(R.menu.mainactivitymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuApprobe:
                Toast.makeText(MainActivity.this,editText.getText().toString()+" ha aprobado",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuSuspend:
                Toast.makeText(MainActivity.this,editText.getText().toString()+" ha suspendido",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if( !editText.getText().toString().isEmpty() ) {
            menu.findItem(R.id.menuApprobe).setTitle(menu.findItem(R.id.menuApprobe).getTitle() + " a " + editText.getText().toString());
            menu.findItem(R.id.menuSuspend).setTitle(menu.findItem(R.id.menuSuspend).getTitle() + " a " + editText.getText().toString());
        } else {
            menu.findItem(R.id.menuApprobe).setTitle(getResources().getString(R.string.menuApproveTitle));
            menu.findItem(R.id.menuSuspend).setTitle(getResources().getString(R.string.menuSuspendTitle));
        }
        return super.onPrepareOptionsMenu(menu);
    }
}
