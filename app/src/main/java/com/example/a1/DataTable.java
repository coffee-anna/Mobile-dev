package com.example.a1;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(tableName = "data")
public class DataTable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    public String owner;
    public String value;
    public String creationDateTime;
}
