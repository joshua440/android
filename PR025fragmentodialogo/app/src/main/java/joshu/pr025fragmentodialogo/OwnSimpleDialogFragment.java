package joshu.pr025fragmentodialogo;


import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by joshu on 26/11/2015.
 */
public class OwnSimpleDialogFragment extends DialogFragment {

    OwnSimpleDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder b = new AlertDialog.Builder(this.getActivity());
        //titulo
        b.setTitle("Simple");
        //contenido de dialogo
        b.setMessage("Prueba de dialogo simple");
        //agrega/sustituye botones del dialogo
        b.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onPositiveButtonClick(OwnSimpleDialogFragment.this);
            }
        });
        return b.create();
    }

    public interface OwnSimpleDialogListener {
        public void onPositiveButtonClick(DialogFragment dialog);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (OwnSimpleDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()+" debe implementar OwnSimpleDialogListener");
        }
    }

}
