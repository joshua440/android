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
public class OwnUniqueSelectDialogFragment extends DialogFragment {

    OwnUniqueSelectDialogListener listener;
    int mWhich;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder b = new AlertDialog.Builder(this.getActivity());
        //titulo
        b.setTitle("Seleccion simple");
        //lista de seleccion
        mWhich=0;
        b.setSingleChoiceItems(R.array.directList, mWhich,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                OwnUniqueSelectDialogFragment.this.mWhich=which;
            }
        });
        b.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onPositiveButtonClick(OwnUniqueSelectDialogFragment.this, mWhich);
            }
        });
        return b.create();
    }

    public interface OwnUniqueSelectDialogListener {
        public void onPositiveButtonClick(DialogFragment dialog,int which);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (OwnUniqueSelectDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()+" debe implementar OwnUniqueSelectDialogListener");
        }
    }
}
