package com.example.ijournal;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class addEntry extends Fragment {
    private EditText entry;
    private Button addEntry;

    public addEntry() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_entry, container, false);
        final String date = MainFragment.selectedDate;
        entry = view.findViewById(R.id.enter_entry);
        addEntry = view.findViewById(R.id.finish_entry);
        addEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String finishedEntry = entry.getText().toString();
                JournalEntry newEntry = new JournalEntry();
                newEntry.setDate(date);
                newEntry.setEntry(finishedEntry);
                MainActivity.journalDatabase.myDao().addEntry(newEntry);
                Toast.makeText(getActivity(), "Entry Added!", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
