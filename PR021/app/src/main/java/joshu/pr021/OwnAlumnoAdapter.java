package joshu.pr021;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by joshu on 06/11/2015.
 */
public class OwnAlumnoAdapter extends ArrayAdapter<Alumno>{

    private ArrayList<Alumno> alumnList;

    public OwnAlumnoAdapter(Context context, ArrayList<Alumno> resource) {
        super(context,R.layout.row,resource);
    }

    private static class ViewHolder{

        public final TextView name, tlf;
        public final ImageView imageView;

        public ViewHolder(View view){
            name=(TextView)view.findViewById(R.id.name);
            tlf=(TextView)view.findViewById(R.id.tlf);
            imageView=(ImageView)view.findViewById(R.id.view);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
    private void onBindViewHolder(ViewHolder holder, int position) {
        Alumno alumno = alumnList.get(position);
        holder.name.setText(alumno.getName());
        holder.tlf.setText(alumno.getTelefono());
        holder.imageView.setOnClickListener(new PopupMenuOnClickListener(alumnList.get(position)));

    }

    private class PopupMenuOnClickListener implements OnClickListener {

        private final Alumno mAlumno;

        public PopupMenuOnClickListener(Alumno alumno) {
            mAlumno = alumno;
        }

        @Override
        public void onClick(View v) {
            PopupMenu popup = new PopupMenu(getContext(), v);
            MenuInflater inflador = popup.getMenuInflater();
            inflador.inflate(R.menu.itemlistmenu, popup.getMenu());
            popup.setOnMenuItemClickListener(new PopupMenuOnMenuItemClickListener(mAlumno));
            popup.show();
        }
    }

    private class PopupMenuOnMenuItemClickListener implements OnMenuItemClickListener {

        final Alumno alumno;

        public PopupMenuOnMenuItemClickListener(Alumno alumno) {
            this.alumno = alumno;
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menuCall:
                    Toast.makeText(getContext(), getContext().getString(R.string.itemCallTitle)+" "+alumno.getName(), Toast.LENGTH_LONG).show();
                    break;
                case R.id.menuSendMessage:
                    Toast.makeText(getContext(), getContext().getString(R.string.menuSendMsgTitle)+" "+alumno.getName(), Toast.LENGTH_LONG).show();
                    break;
            }
            return true;
        }
    }
}
