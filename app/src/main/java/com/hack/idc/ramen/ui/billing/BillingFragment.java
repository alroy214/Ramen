package com.hack.idc.ramen.ui.billing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.hack.idc.ramen.databinding.FragmentBillingBinding;

public class BillingFragment extends Fragment {

    private FragmentBillingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBillingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textParticipants;
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}