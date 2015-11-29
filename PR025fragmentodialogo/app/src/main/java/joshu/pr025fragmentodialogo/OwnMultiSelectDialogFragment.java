package joshu.pr025fragmentodialogo;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import java.util.Arrays;

/**
 * Created by joshu on 27/11/2015.
 */
public class OwnMultiSelectDialogFragment extends DialogFragment {

    OwnMultiSelectDialogListener listener;
    boolean [] selected;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder b = new AlertDialog.Builder(this.getActivity());
        //titulo
        b.setTitle("Seleccion multiple");
        //lista de seleccion
        selected= new boolean[getResources().getStringArray(R.array.directList).length];
        Arrays.fill(selected,false);
        b.setMultiChoiceItems(R.array.directList,new boolean[getResources().getStringArray(R.array.directList).length],new DialogInterface.OnMultiChoiceClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                OwnMultiSelectDialogFragment.this.selected[which]=isChecked;
            }
        });
        b.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onPositiveButtonClick(OwnMultiSelectDialogFragment.this, selected);
            }
        });
        return b.create();
    }

    public interface OwnMultiSelectDialogListener {
        public void onPositiveButtonClick(OwnMultiSelectDialogFragment dialog, boolean[] selected);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (OwnMultiSelectDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()+" debe implementar OwnMultiSelectDialogListener");
        }
    }
}
