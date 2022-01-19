package com.example.externalstorage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    List<Model> files;

    public Adapter(List<Model> files){
        this.files = files;
    }

    @Override
    public int getCount() {
        return files.size();
    }

    @Override
    public Object getItem(int position) {
        return files.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        MyViewHolder viewHolder;
        if(view == null)
        {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_file_name,null);
            viewHolder = new MyViewHolder();
            viewHolder.file = view.findViewById(R.id.textView);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (MyViewHolder) view.getTag();
        }

        Model file = files.get(position);
        viewHolder.file.setText(file.getFile());

        return view;
    }
    class MyViewHolder{
        TextView file;
    }
}
