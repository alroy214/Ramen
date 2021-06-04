package com.hack.idc.ramen.ui.billing;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.hack.idc.ramen.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.SubCategoryViewHolder>
{
    private final ArrayList<SubCategory> subCategoryList;
    public ISubCategoryAdapterItemCallback subCategoryAdapterItemCallback;

    public static class SubCategoryViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txtSubCategoryName;

        public SubCategoryViewHolder(View view)
        {
            super(view);
            txtSubCategoryName = view.findViewById(R.id.txtSubCategory);
        }
    }

    public interface ISubCategoryAdapterItemCallback
    {
        void onSubCategoryItemCallback(int position);
    }

    public SubCategoryAdapter(ArrayList<SubCategory> subCategoryList)
    {
        this.subCategoryList = subCategoryList;
    }

    @NotNull
    @Override
    public SubCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sub_category_item, parent, false);

        Log.d("TAG", "onBindViewHolder: BOOP");
        return new SubCategoryViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(SubCategoryViewHolder holder, final int position)
    {
        final SubCategory subCategoryItem = subCategoryList.get(position);
        holder.txtSubCategoryName.setText(subCategoryItem.name);

        Log.d("TAG", "onBindViewHolder: " + position);

        if (subCategoryItem.isSelected)
        {
            holder.txtSubCategoryName.setBackgroundResource(R.drawable.sub_category_selected_item);
            holder.txtSubCategoryName.setTextColor(Color.parseColor("#FFFFFF"));
        } else
        {
            holder.txtSubCategoryName.setBackgroundResource(R.drawable.sub_category_item);
            holder.txtSubCategoryName.setTextColor(Color.parseColor("#3F51B5"));
        }

        holder.txtSubCategoryName.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (subCategoryAdapterItemCallback != null)
                {
                    subCategoryAdapterItemCallback.onSubCategoryItemCallback(position);
                }
            }
        });
    }

    @Override
    public int getItemCount()
    {

        Log.d("TAG", "onBindViewHolder: " + subCategoryList.size());
        return subCategoryList.size();
    }



    public SubCategory getItem(int position)
    {
        return subCategoryList.get(position);
    }
}