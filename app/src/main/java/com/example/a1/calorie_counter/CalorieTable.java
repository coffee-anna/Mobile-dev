package com.example.a1.calorie_counter;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(tableName = "data")
public class CalorieTable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    public String food;
    public String calories;
    public String creationDateAndTime;
    public String total;
}
