//package com.example.a1.favourites;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class FavDB extends SQLiteOpenHelper {
//
//    private static int DB_VERSION = 1;
//    private static String DATABASE_NAME = "CoffeeDB";
//    private static String TABLE_NAME = "favoriteTable";
////    public static String KEY_ID = "id";
//    public static String ITEM_TITLE = "itemTitle";
//    public static String ITEM_IMAGE = "itemImage";
//    public static String FAVORITE_STATUS = "fStatus";
//    // dont forget write this spaces
//    private static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
//            "( ID INTEGER PRIMARY KEY AUTOINCREMENT,"
//            + ITEM_TITLE+ " TEXT,"
//            + ITEM_IMAGE + " TEXT," + FAVORITE_STATUS+" TEXT)";
//
//    public FavDB(Context context) { super(context,DATABASE_NAME,null,DB_VERSION);}
//
//    @Override
//    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        sqLiteDatabase.execSQL(CREATE_TABLE);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//
//    }
//
//    // create empty table
//    public void insertEmpty() {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        // enter your value
//        for (int x = 1; x < 11; x++) {
//            cv.put(FAVORITE_STATUS, "0");
//
//            db.insert(TABLE_NAME,null, cv);
//        }
//    }
//
//    // insert data into database
//    public void insertIntoTheDatabase(String item_title, String item_image) {
//        SQLiteDatabase db;
//        db = this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put(ITEM_TITLE, item_title);
//        cv.put(ITEM_IMAGE, item_image);
//        db.insert(TABLE_NAME,null, cv);
//        Log.d("FavDB Status", item_title + " - . " + cv);
//    }
//
//    // read all data
////    public List<AddPictureToFavourites> read_all_data() {
////
////        List<AddPictureToFavourites> data = new ArrayList<>();
////        SQLiteDatabase db = this.getReadableDatabase();
////        String sql = "select * from " + TABLE_NAME ;//+ " where " + KEY_ID+"="+id+"";
////        Cursor cursor = db.rawQuery(sql,null,null);
////
////        while (cursor.moveToNext()) {
////            String imagePath = cursor.getString(1);
////            String coffeeName = cursor.getString(2);
////            data.add(new AddPictureToFavourites(imagePath, coffeeName));
////        }
////
////        cursor.close();
////        db.close();
////        return data;
////    }
//
//
//    // remove line from database
////    public void remove_fav(String id) {
////        SQLiteDatabase db = this.getWritableDatabase();
////        String sql = "UPDATE " + TABLE_NAME;
////        db.execSQL(sql);
////        Log.d("remove", id.toString());
////
////    }
//
//    // select all favorite list
//
//    public Cursor select_all_favorite_list() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        String sql = "SELECT * FROM "+TABLE_NAME;
//        return db.rawQuery(sql,null,null);
//    }
//}
