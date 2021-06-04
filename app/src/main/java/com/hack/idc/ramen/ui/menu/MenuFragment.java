package com.hack.idc.ramen.ui.menu;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hack.idc.ramen.R;
import com.hack.idc.ramen.Utils;
import com.hack.idc.ramen.databinding.FragmentManuBinding;
import com.hack.idc.ramen.ui.billing.SubCategory;
import com.hack.idc.ramen.ui.billing.SubCategoryAdapter;
import com.hack.idc.ramen.ui.billing.TopLinearLayoutManager;
import com.hack.idc.ramen.ui.participants.Participants;
import com.hack.idc.ramen.ui.participants.ParticipantsAdapter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MenuFragment extends Fragment implements SubCategoryAdapter.ISubCategoryAdapterItemCallback {

    private int selectedSubCategoryPosition = 0;
    private SubCategoryAdapter subCategoryAdapter;
    public RecyclerView rvSubCategory;
    ArrayList<SubCategory> subCategoryList;
    ArrayList<MenuItem> arr;
    ArrayList<MenuItem> searchedList;
    MenuAdapter menuAdapter;

    private FragmentManuBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentManuBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMenu;
        ListView listView = root.findViewById(R.id.listView);
        arr = new ArrayList<>();
        searchedList = new ArrayList<>();

        subCategoryList = new ArrayList<>();
        subCategoryList.add(new SubCategory(1,1,"Breakfast"));
        subCategoryList.add(new SubCategory(2,2,"Salad"));
        subCategoryList.add(new SubCategory(3,3,"Drinks"));
        subCategoryList.add(new SubCategory(4,4,"Sandwiches"));
        subCategoryList.add(new SubCategory(4,4,"Dessert"));


        // set sub-categories
        rvSubCategory = binding.rvSubCategory;
        rvSubCategory.setLayoutManager(new TopLinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL));
        subCategoryAdapter = new SubCategoryAdapter(subCategoryList);
        rvSubCategory.setAdapter(subCategoryAdapter);
        subCategoryAdapter.getItem(0).isSelected = true;
        subCategoryAdapter.subCategoryAdapterItemCallback = this;


        arr.add(new MenuItem(1, "https://i1.wp.com/blog.hellofresh.com/wp-content/uploads/2016/10/HF160920_Global_Blog_All_About_Apples_15_low-1.jpg?fit=3180%2C2120&ssl=1", "Apples", "Devil Fruit",5));
        arr.add(new MenuItem(2,"https://images-prod.healthline.com/hlcmsresource/images/AN_images/benefits-of-pears-1296x728-feature.jpg", "Pears", "Swords", 7));
        arr.add(new MenuItem(3, "https://i1.sndcdn.com/artworks-RQWHFSCsE5BVWyEg-mwYHUQ-t500x500.jpg", "Peaches", "Ubasiri", 8));

        searchedList.addAll(arr);


        menuAdapter = new MenuAdapter(requireContext(), R.layout.list_row, searchedList, binding.sum);



        listView.setAdapter(menuAdapter);


        binding.editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                updateFilteredList(s.toString());
            }
        });

        return root;
    }

    private void updateFilteredList(String text) {
        searchedList = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i).getName().startsWith(text))
            searchedList.add(arr.get(i));
        }
        menuAdapter.setMenu(searchedList);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onSubCategoryItemCallback(int position)
    {
        selectedSubCategoryPosition = position;

        for (int index = 0; index < subCategoryList.size(); index++)
        {
            subCategoryList.get(index).isSelected = false;
        }

        subCategoryList.get(position).isSelected = true;
        subCategoryAdapter.notifyDataSetChanged();

        rvSubCategory.smoothScrollToPosition(position);
    }
}