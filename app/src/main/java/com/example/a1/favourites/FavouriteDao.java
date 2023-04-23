//package com.example.a1.favourites;
//
//import androidx.room.Dao;
//import androidx.room.Insert;
//import androidx.room.OnConflictStrategy;
//import androidx.room.Query;
//
//import java.util.List;
//
//@Dao
//public interface FavouriteDao {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void insertAllData(FavouriteModel model);
//
//    @Query("SELECT * FROM favorite_table")
//    List<FavouriteModel> getAllData();
//
//    @Query("SELECT EXISTS (SELECT 1 FROM favorite_table WHERE id = :id)")
//    boolean isFavorite(int id);
//
//    @Query("DELETE FROM favorite_table WHERE id = :id")
//    void deleteData(int id);
//}