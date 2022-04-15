package handles;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class AdapterHandleFurnit<T extends HandleFurnit> extends ArrayAdapter<T> {

    public List<T> list;

    public AdapterHandleFurnit(@NonNull Context context, int resource, @NonNull List<T> objects) {
        super(context, resource, objects);
        this.list = objects;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View v = null;


        if (!list.get(position).getVisible()) {
            TextView tv = new TextView(getContext());
            tv.setVisibility(View.GONE);
            v = tv;
        }
        else {
            v = super.getDropDownView(position, null, parent);
        }
        return v;
    }
}
