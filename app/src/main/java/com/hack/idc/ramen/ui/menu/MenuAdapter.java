package com.hack.idc.ramen.ui.menu;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.hack.idc.ramen.R;
import com.hack.idc.ramen.Utils;

import java.util.ArrayList;


public class MenuAdapter extends ArrayAdapter<MenuItem> {
    private Context m_Context;
    private int m_Resource;
    private ArrayList<MenuItem> m_menu;
    private int m_total;
    private TextView m_sumView;

    public void setMenu(ArrayList<MenuItem> menu) {
        m_menu = menu;
        notifyDataSetChanged();
    }

    public MenuAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MenuItem> menu,
                       TextView textView){
        super(context,resource, menu);
        m_Context = context;
        m_Resource = resource;
        m_menu = menu;
        m_sumView = textView;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if(convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(m_Context);
            convertView = layoutInflater.inflate(m_Resource, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.image);
        TextView txtName = convertView.findViewById(R.id.txtName);
        TextView txtDes = convertView.findViewById(R.id.txtDes);
        TextView txtPrice = convertView.findViewById(R.id.txtPrice);

        ImageView imgAdd = convertView.findViewById(R.id.add);
        ImageView imgRemove = convertView.findViewById(R.id.remove);
        TextView txtCount = convertView.findViewById(R.id.txtCount);

        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getItem(position).getCount() == 0) {
                    txtCount.setTextColor(ContextCompat.getColor(m_Context, android.R.color.holo_blue_light));
                }
                txtCount.setText(""+getItem(position).increaseCount());
                m_total += getItem(position).m_Price;
                m_sumView.setText(m_total+"₪");
                if(m_total != 0) {
                    m_sumView.setTextColor(ContextCompat.getColor(m_Context, android.R.color.holo_blue_light));
                }
            }
        });

        imgRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getItem(position).getCount() == 1) {
                    txtCount.setTextColor(Color.BLACK);
                }
                if(getItem(position).getCount() != 0) {
                    m_total -= getItem(position).m_Price;
                    m_sumView.setText(m_total + "₪");
                    if(m_total == 0) {
                        m_sumView.setTextColor(Color.BLACK);
                    }
                }
                txtCount.setText(""+getItem(position).decreaseCount());
            }
        });

        if(m_menu.size() > position) {

            Glide.with(m_Context)
                    .load(m_menu.get(position).m_Image)
                    .centerCrop()
                    .override(100)
                    .placeholder(R.drawable.strawhat)
                    .into(imageView);
        }
        txtDes.setText(getItem(position).getIngredients());
        txtName.setText(getItem(position).getName());
        txtPrice.setText(getItem(position).getPrice()+"₪");



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
