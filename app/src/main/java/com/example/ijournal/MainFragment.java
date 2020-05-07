package com.example.ijournal;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

    private Button readEntry;
    private Button addEntry;
    private CalendarView calendar;
    public static String selectedDate;
    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        readEntry = view.findViewById(R.id.read_button);
        addEntry = view.findViewById(R.id.add_entry);
        readEntry.setOnClickListener(this);
        addEntry.setOnClickListener(this);
        calendar = view.findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectedDate = year + "/" + month + "/" + dayOfMonth;
            }
        });
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_entry:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer, new addEntry()).addToBackStack(null).commit();
                break;

            case R.id.read_button:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer, new ReadEntry()).addToBackStack(null).commit();
                break;
        }
    }
}
