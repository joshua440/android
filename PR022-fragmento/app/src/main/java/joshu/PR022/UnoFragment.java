package joshu.PR022;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by joshu on 12/11/2015.
 */
public class UnoFragment extends Fragment {

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
        ((TextView)getView().findViewById(R.id.textView)).setText(txt);
    }

    public static UnoFragment newInstance(String mensaje) {
        Bundle bundle=new Bundle();
        bundle.putString(KEY_TEXT,mensaje);
        UnoFragment frg=new UnoFragment();
        frg.setArguments(bundle);
        return frg;
    }
}
