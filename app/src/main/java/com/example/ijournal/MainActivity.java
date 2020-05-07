package com.example.ijournal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;
import androidx.room.Database;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    public static JournalDatabase journalDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        journalDatabase = Room.databaseBuilder(getApplicationContext(), JournalDatabase.class, "entries").allowMainThreadQueries().build();
        if (findViewById(R.id.fragmentContainer) != null) {
            if (savedInstanceState != null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragmentContainer, new MainFragment()).commit();
        }
    }
}

