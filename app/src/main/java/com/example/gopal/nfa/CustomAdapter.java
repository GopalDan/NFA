package com.example.gopal.nfa;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

//import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squareup.picasso.Picasso;

/**
 * Created by Gopal on 10/28/2018.
 */

public class CustomAdapter extends ArrayAdapter<Event> {
    public CustomAdapter(Context context, List<Event> list){
        super(context,0,list);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        Event currentEvent = getItem(position);
        TextView webTitle = listItemView.findViewById(R.id.web_title);
        webTitle.setText(currentEvent.getmWebTitle());
       ImageView imageView = listItemView.findViewById(R.id.thumbnail);
//        try{
//            imageView.setImageResource(Integer.parseInt(currentEvent.getmThumbnailResourceId()));
//
//        }catch(NumberFormatException ex) {
//            // handle your exception
//            imageView.setImageResource(R.drawable.dummy);
//
//        }

        Picasso.get().load(currentEvent.getmThumbnailResourceId())
                .resize(40,40)
                .into(imageView);


        return listItemView;
    }

}
