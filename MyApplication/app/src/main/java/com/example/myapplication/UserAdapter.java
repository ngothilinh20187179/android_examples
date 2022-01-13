package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends BaseAdapter {
    List<UserModel> users;

    public UserAdapter(List<UserModel> users){
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_layout,null);
            viewHolder = new MyViewHolder();
            viewHolder.avatar = view.findViewById(R.id.imageView);
            viewHolder.userName = view.findViewById(R.id.user_name);
            viewHolder.email = view.findViewById(R.id.email);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (MyViewHolder) view.getTag();
        }

        UserModel user = users.get(position);
        viewHolder.avatar.setText(user.getAvatar());
        viewHolder.userName.setText(user.getUsername());
        viewHolder.email.setText(user.getEmail());

        return view;
    }
    class MyViewHolder{
        TextView avatar;
        TextView userName;
        TextView email;
    }
}
