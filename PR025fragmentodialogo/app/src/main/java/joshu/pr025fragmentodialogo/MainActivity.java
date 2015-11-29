package joshu.pr025fragmentodialogo;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
        implements  OwnSimpleDialogFragment.OwnSimpleDialogListener,
                    OwnYesNoDialogFragment.OwnYesNoDialogListener,
                    OwnDirectSelectDialogFragment.OwnDirectSelectedDialogListener,
                    OwnUniqueSelectDialogFragment.OwnUniqueSelectDialogListener,
                    OwnMultiSelectDialogFragment.OwnMultiSelectDialogListener{

    @Bind(R.id.button)
    Button button;
    @Bind(R.id.button2)
    Button button2;
    @Bind(R.id.button3)
    Button button3;
    @Bind(R.id.button4)
    Button button4;
    @Bind(R.id.button5)
    Button button5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

        @OnClick(R.id.button)
    public void simpleDialogFragmentGenerator() {
        DialogFragment owndialog = new OwnSimpleDialogFragment();
        owndialog.show(getSupportFragmentManager(), "MiDialogFragment");
    }

    @OnClick(R.id.button2)
    public void yesNoDialogFragmentGenerator() {
        DialogFragment owndialog = new OwnYesNoDialogFragment();
        owndialog.show(getSupportFragmentManager(), "MiDialogFragment");
    }

    @OnClick(R.id.button3)
    public void directSelectDialogFragmentGenerator() {
        DialogFragment owndialog = new OwnDirectSelectDialogFragment();
        owndialog.show(getSupportFragmentManager(), "MiDialogFragment");
    }

    @OnClick(R.id.button4)
    public void uniqueSelectDialogFragmentGenerator() {
        DialogFragment owndialog = new OwnUniqueSelectDialogFragment();
        owndialog.show(getSupportFragmentManager(), "MiDialogFragment");
    }

    @OnClick(R.id.button5)
    public void multiSelectDialogFragmentGenerator() {
        DialogFragment owndialog = new OwnMultiSelectDialogFragment();
        owndialog.show(getSupportFragmentManager(), "MiDialogFragment");
    }

    @Override
    public void onPositiveButtonClick(android.support.v4.app.DialogFragment dialog) {
        if (dialog instanceof OwnYesNoDialogFragment){
            Toast.makeText(this, R.string.yes, Toast.LENGTH_SHORT).show();
        }
        dialog.dismiss();
    }

    @Override
    public void onPositiveButtonClick(android.support.v4.app.DialogFragment dialog, int which) {
        if (dialog instanceof OwnDirectSelectDialogFragment){
            Toast.makeText(this, getResources().getStringArray(R.array.directList)[which], Toast.LENGTH_SHORT).show();
        } else if(dialog instanceof OwnUniqueSelectDialogFragment){
            Toast.makeText(this, getResources().getStringArray(R.array.directList)[which], Toast.LENGTH_SHORT).show();
        }
        dialog.dismiss();
    }

    @Override
    public void onNegativeButtonClick(android.support.v4.app.DialogFragment dialog) {
        if (dialog instanceof OwnYesNoDialogFragment){
            Toast.makeText(this, R.string.no, Toast.LENGTH_SHORT).show();
        }
        dialog.dismiss();
    }

    @Override
    public void onItemClick(android.support.v4.app.DialogFragment dialog, int which) {
        Toast.makeText(this, getResources().getStringArray(R.array.directList)[which], Toast.LENGTH_SHORT).show();
        dialog.dismiss();
    }

    @Override
    public void onPositiveButtonClick(OwnMultiSelectDialogFragment dialog, boolean[] selected) {
        String all="";
        for(int i=0;i<selected.length;i++) {
            if(selected[i]){
                all+=getResources().getStringArray(R.array.directList)[i]+" ";
            }
        }
        Toast.makeText(this, all, Toast.LENGTH_SHORT).show();
        dialog.dismiss();
    }
}
