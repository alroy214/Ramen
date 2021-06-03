package com.hack.idc.ramen.ui.participants;

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


public class ParticipantsAdapter extends ArrayAdapter<Participants> {
    private Context m_Context;
    private int m_Resource;

    public ParticipantsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Participants> people){
        super(context,resource, people);
        m_Context = context;
        m_Resource = resource;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if(convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(m_Context);
            convertView = layoutInflater.inflate(m_Resource, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.image);
        TextView txtName = convertView.findViewById(R.id.txtName);
        TextView txtDes = convertView.findViewById(R.id.txtDes);
        imageView.setImageResource(getItem(position).getImage());
        txtDes.setText(getItem(position).getDes());
        txtName.setText(getItem(position).getName());

        return convertView;

    }
}
