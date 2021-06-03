package com.hack.idc.ramen.person;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hack.idc.ramen.R;

import java.util.ArrayList;


public class PersonAdapter extends ArrayAdapter<Person> {
    private Context m_Context;
    private int m_Resource;

    public PersonAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Person> people){
        super(context,resource, people);
        m_Context = context;
        m_Resource = resource;
    }

    public View getView(int position, @Nullable View converview, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(m_Context);

        converview = layoutInflater.inflate(m_Resource, parent, false);
        ImageView imageView = converview.findViewById(R.id.image);
        TextView txtName = converview.findViewById(R.id.txtName);
        TextView txtDes = converview.findViewById(R.id.txtDes);
        imageView.setImageResource(getItem(position).getImage());
        txtDes.setText(getItem(position).getDes());
        txtName.setText(getItem(position).getName());

        return converview;

    }
}
