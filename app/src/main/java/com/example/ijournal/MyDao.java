package com.example.ijournal;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    void addEntry(JournalEntry entry);

    @Query("select * from entries")
    List<JournalEntry> getEntries();

}
