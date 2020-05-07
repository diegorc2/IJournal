package com.example.ijournal;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadEntry extends Fragment {
    private TextView entry;
    private TextView dateView;

    public ReadEntry() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_entry, container, false);
        entry = view.findViewById(R.id.entry_view);
        dateView = view.findViewById(R.id.date_view);
        String date = MainFragment.selectedDate;
        List<JournalEntry> list = MainActivity.journalDatabase.myDao().getEntries();
        String toRead = null;
        for (JournalEntry entry: list) {
            if (entry.getDate().equals(date)) {
                toRead = entry.getEntry();
            }
        }
        if (toRead != null) {
            entry.setText(toRead);
            dateView.setText(date);
        }   else {
            Toast.makeText(getActivity(), "No Entry Found for this Date!", Toast.LENGTH_SHORT).show();
        }
        return view;
    }

}
