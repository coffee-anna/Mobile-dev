package com.example.a1.calorie_counter;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import java.util.List;

@Dao
public interface CalorieDataDao {

    @Query("SELECT * FROM data WHERE creationDateAndTime=:owner")
    List<CalorieTable> getCalorieDataList(String owner);

    @Insert
    void insertCalorieData(CalorieTable data);
}
