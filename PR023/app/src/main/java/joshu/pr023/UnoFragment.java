package joshu.pr023;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by joshu on 12/11/2015.
 */
public class UnoFragment extends Fragment {

    public interface CallBack{
        public void pulsado(String msg);
    }
    public CallBack listener;
    private Button button;
    private EditText editText;
    private TextView textView;
    public static final String KEY_TEXT="text";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_uno, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle=getArguments();
        String txt=bundle.getString(KEY_TEXT);
        textView=(TextView)getView().findViewById(R.id.textView);
        textView.setText(txt);
        editText=(EditText)getView().findViewById(R.id.editText);
        button=(Button)getView().findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                listener.pulsado(editText.getText().toString());
            }
        });
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener= (CallBack) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement CallBack interface to work");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }

    public static UnoFragment newInstance(String mensaje) {
        Bundle bundle=new Bundle();
        bundle.putString(KEY_TEXT,mensaje);
        UnoFragment frg=new UnoFragment();
        frg.setArguments(bundle);
        return frg;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.mainactivitymenufromfragment, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuFragment:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
