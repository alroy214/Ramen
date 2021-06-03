package com.hack.idc.ramen.ui.menu;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.hack.idc.ramen.R;
import com.hack.idc.ramen.Utils;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;


public class MenuAdapter extends ArrayAdapter<MenuItem> {
    private Context m_Context;
    private int m_Resource;
    private ArrayList<MenuItem> m_people;

    public MenuAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MenuItem> people){
        super(context,resource, people);
        m_Context = context;
        m_Resource = resource;
        m_people = people;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if(convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(m_Context);
            convertView = layoutInflater.inflate(m_Resource, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.image);
        TextView txtName = convertView.findViewById(R.id.txtName);
        TextView txtDes = convertView.findViewById(R.id.txtDes);

        Glide.with(m_Context)
            .load(m_people.get(position).m_Image)
            .centerCrop()
                .override(100)
                .placeholder(R.drawable.strawhat)
                .into(imageView);
        txtDes.setText(getItem(position).getIngredients());
        txtName.setText(getItem(position).getName());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Log.d("TAG", "onCreateView: " + Utils.getJSON("http://ec2-54-152-100-165.compute-1.amazonaws.com:5000/menu", m_Context));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
            }
        });

        return convertView;

    }
}
