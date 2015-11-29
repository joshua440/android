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
public class OwnYesNoDialogFragment extends DialogFragment {

    OwnYesNoDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder b = new AlertDialog.Builder(this.getActivity());
        //titulo
        b.setTitle("YesNo");
        //contenido de dialogo
        b.setMessage("¿Este dialogo se ha ejecutado correctamente?");
        //agrega/sustituye botones del dialogo
        b.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onPositiveButtonClick(OwnYesNoDialogFragment.this);
            }
        });
        b.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onNegativeButtonClick(OwnYesNoDialogFragment.this);
            }
        });
        return b.create();
    }

    public interface OwnYesNoDialogListener {
        public void onPositiveButtonClick(DialogFragment dialog);
        public void onNegativeButtonClick(DialogFragment dialog);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (OwnYesNoDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()+" debe implementar OwnYesNoDialogListener");
        }
    }

}
