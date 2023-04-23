package com.example.a1;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {DataTable.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DataDao dataDao();
}
