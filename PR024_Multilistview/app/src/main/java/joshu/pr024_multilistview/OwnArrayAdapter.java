package joshu.pr024_multilistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by joshu on 20/11/2015.
 */
public class OwnArrayAdapter extends ArrayAdapter<Alumno> {

    private ArrayList<Alumno> alumnList;

    public OwnArrayAdapter(Context context, ArrayList<Alumno> resource) {
        super(context,R.layout.row,resource);
    }

    private static class ViewHolder{

        public final TextView name, age;

        public ViewHolder(View view){
            name=(TextView)view.findViewById(R.id.name);
            age=(TextView)view.findViewById(R.id.age);
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
}