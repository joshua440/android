package joshu.pr025fragmentodialogo;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by joshu on 27/11/2015.
 */
public class OwnDirectSelectDialogFragment extends DialogFragment {

    OwnDirectSelectedDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder b = new AlertDialog.Builder(this.getActivity());
        //titulo
        b.setTitle("Seleccion directa");
        //lista de seleccion
        b.setItems(R.array.directList, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onItemClick(OwnDirectSelectDialogFragment.this,which);
            }
        });
        return b.create();
    }

    public interface OwnDirectSelectedDialogListener {
        public void onItemClick(DialogFragment dialog,int which);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (OwnDirectSelectedDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()+" debe implementar OwnDirectSelectedDialogListener");
        }
    }
}
