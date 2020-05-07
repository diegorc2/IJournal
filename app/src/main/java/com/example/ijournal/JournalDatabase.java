package com.example.ijournal;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {JournalEntry.class}, version = 1)
public abstract class JournalDatabase extends RoomDatabase {
    public abstract MyDao myDao();
}
