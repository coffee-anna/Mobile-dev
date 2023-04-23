package com.example.a1;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DataDao {
    @Query("SELECT * FROM data WHERE owner=:owner")
    List<DataTable> getDataList(String owner);

    @Insert
    void insertData(DataTable data);
}
