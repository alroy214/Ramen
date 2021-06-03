package com.hack.idc.ramen.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.hack.idc.ramen.R;
import com.hack.idc.ramen.databinding.FragmentHomeBinding;
import com.hack.idc.ramen.person.Person;
import com.hack.idc.ramen.person.PersonAdapter;

import java.util.ArrayList;

public class MenuFragment extends Fragment {

    private MenuViewModel menuViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        menuViewModel =
                new ViewModelProvider(this).get(MenuViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        menuViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });



        ListView listView = root.findViewById(R.id.listView);
        ArrayList<Person> arr = new ArrayList<>();
        arr.add(new Person(R.drawable.strawhat, "monket.D Luffy", "Bounty - 1.5B$"));
        arr.add(new Person(R.drawable.strawhat, "Roronoa Zoro", "Bounty - 500M$"));
        arr.add(new Person(R.drawable.strawhat, "Vinsmoke Sanji", "Bounty - 700M$"));

        PersonAdapter personAdapter = new PersonAdapter(getContext(), R.layout.list_row, arr);

        listView.setAdapter(personAdapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}