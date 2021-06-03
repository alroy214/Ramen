package com.hack.idc.ramen.ui.menu;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.hack.idc.ramen.R;
import com.hack.idc.ramen.Utils;
import com.hack.idc.ramen.databinding.FragmentManuBinding;
import com.hack.idc.ramen.ui.participants.Participants;
import com.hack.idc.ramen.ui.participants.ParticipantsAdapter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MenuFragment extends Fragment {

    private FragmentManuBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentManuBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMenu;
        ListView listView = root.findViewById(R.id.listView);
        ArrayList<MenuItem> arr = new ArrayList<>();
        /*
            int m_Id;
    String m_Image;
    String m_Name;
    String m_Ingredients;
    String m_Price;
         */
        arr.add(new MenuItem(1, "https://i1.wp.com/blog.hellofresh.com/wp-content/uploads/2016/10/HF160920_Global_Blog_All_About_Apples_15_low-1.jpg?fit=3180%2C2120&ssl=1", "Apples", "Devil Fruit","100"));
        arr.add(new MenuItem(2,"https://images-prod.healthline.com/hlcmsresource/images/AN_images/benefits-of-pears-1296x728-feature.jpg", "Pears", "Swords", "200"));
        arr.add(new MenuItem(3, "https://i1.sndcdn.com/artworks-RQWHFSCsE5BVWyEg-mwYHUQ-t500x500.jpg", "Peaches", "Ubasiri", "300"));

        MenuAdapter menuAdapter = new MenuAdapter(requireContext(), R.layout.list_row, arr);

        listView.setAdapter(menuAdapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}