//package com.example.a1.favourites;
//
//import androidx.room.ColumnInfo;
//import androidx.room.Entity;
//import androidx.room.Index;
//import androidx.room.PrimaryKey;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;
//
//@AllArgsConstructor
//@Entity(tableName = "favorite_table") //,
//        //indices = {@Index(value = {"pictureUrl"}, unique = true),
//          //         @Index(value = {"coffeeName"}, unique = true)})
//public class FavouriteModel {
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "id")
//    public int id;
//
//    @ColumnInfo(name = "pictureUrl")
//    public String pictureUrl;
//
//    @ColumnInfo(name = "coffeeName")
//    public String coffeeName;
//}