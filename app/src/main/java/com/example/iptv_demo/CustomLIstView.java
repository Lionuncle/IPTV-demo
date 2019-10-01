package com.example.iptv_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomLIstView extends BaseAdapter {
    private final Context context;
    private final String[] names;
    private final int[] image;
    private final LayoutInflater layoutInflater;
    public CustomLIstView(Context context, String[] names,int[] image){
        this.context = context;
        this.names = names;
        this.image = image;
        layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootView;
        rootView = layoutInflater.inflate(R.layout.listview,null);
        TextView tv = rootView.findViewById(R.id.textView);
        ImageView iv = rootView.findViewById(R.id.imageView);

        tv.setText(names[position]);
        iv.setImageResource(image[position]);

        return rootView;

    }
}
