package com.hack.idc.ramen.ui.menu;

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
import com.hack.idc.ramen.databinding.FragmentManuBinding;
import com.hack.idc.ramen.person.Person;
import com.hack.idc.ramen.person.PersonAdapter;

import java.util.ArrayList;

public class MenuFragment extends Fragment {

    private FragmentManuBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentManuBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMenu;
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}