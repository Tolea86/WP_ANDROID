package com.tolea.pw_lab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class SuperAdapter extends ArrayAdapter<ColorObject> {

    private List<ColorObject> colors;

    Context contextGlobal;

    TextView colorName;
    RelativeLayout exampleBox;

    private final LayoutInflater mInflater;

    public SuperAdapter(Context context) {
        super(context, R.layout.color_list_item);
        contextGlobal = context;

        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<ColorObject> data) {

        clear();
        if (data != null) {
            addAll(data);
            notifyDataSetChanged();
        }
        colors = data;
    }

    public ColorObject getItem(int position) {
        return colors.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view;
        if (convertView == null) {
            view =  mInflater.inflate(R.layout.color_list_item, parent, false);
        } else {
            view = convertView;
        }

        colorName = (TextView) view.findViewById(R.id.colorName);

        exampleBox = (RelativeLayout) view.findViewById(R.id.exampleBox);

        final ColorObject currentColor = colors.get(position);

        colorName.setText("Color Name : " + currentColor.getName());
        exampleBox.setBackgroundColor(currentColor.getColor());

        return view;
    }
}
