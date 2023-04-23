package com.example.a1.calorie_counter;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {CalorieTable.class}, version = 2)
public abstract class CalorieDatabase extends RoomDatabase {
    public abstract CalorieDataDao dataDao();
}
