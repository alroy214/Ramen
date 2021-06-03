package com.hack.idc.ramen.ui.participants;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.hack.idc.ramen.R;
import com.hack.idc.ramen.databinding.FragmentParticipantsBinding;

import java.util.ArrayList;

public class ParticipantsFragment extends Fragment {

    private FragmentParticipantsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentParticipantsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textParticipants;
        ListView listView = root.findViewById(R.id.listView);
        ArrayList<Participants> arr = new ArrayList<>();
        arr.add(new Participants(R.drawable.strawhat, "monket.D Luffy", "Bounty - 1.5B$"));
        arr.add(new Participants(R.drawable.strawhat, "Roronoa Zoro", "Bounty - 500M$"));
        arr.add(new Participants(R.drawable.strawhat, "Vinsmoke Sanji", "Bounty - 700M$"));

        ParticipantsAdapter participantsAdapter = new ParticipantsAdapter(requireContext(), R.layout.list_row, arr);

        listView.setAdapter(participantsAdapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}