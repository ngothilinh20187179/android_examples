package com.example.gmail;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.helper.widget.Layer;

import org.w3c.dom.Text;

import java.util.List;

public class EmailAdapter extends BaseAdapter {

    List<EmailModel> emails;
    boolean isFavourite = false;

    public EmailAdapter(List<EmailModel> emails) {
        this.emails = emails;
    }

    @Override
    public int getCount() {
        return emails.size();
    }

    @Override
    public Object getItem(int position) {
        return emails.get(position);
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.email_layout,null);

            viewHolder = new MyViewHolder();
            viewHolder.avatarText = view.findViewById(R.id.avatar_text);
            viewHolder.senderName = view.findViewById(R.id.sender_name);
            viewHolder.content = view.findViewById(R.id.content);
            viewHolder.favourite = view.findViewById(R.id.favourite);

            view.setTag(viewHolder);
        }
        else {
            viewHolder = (MyViewHolder) view.getTag();
        }

        EmailModel email = emails.get(position);

        viewHolder.senderName.setText(email.getSenderName());
        viewHolder.content.setText(email.getContent());
        viewHolder.avatarText.setText(email.getAvatarText());

        //viewHolder.favourite.setImageResource(email.getFavouriteImg());
        viewHolder.favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFavourite)
                {
                    viewHolder.favourite.setImageResource(R.drawable.ic_baseline_star_24);
                    notifyDataSetChanged();
                    isFavourite = true;
                }
                else {
                    viewHolder.favourite.setImageResource(R.drawable.ic_baseline_star_border_24);
                    notifyDataSetChanged();
                    isFavourite = false;
                }
            }
        });
        return view;
    }

    class MyViewHolder{
        TextView avatarText;
        TextView senderName;
        TextView content;
        ImageView favourite;
    }
}













