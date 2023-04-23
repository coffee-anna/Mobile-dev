//package com.example.a1.coffee;
//
//import android.content.Context;
//import android.content.SharedPreferences;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.example.a1.R;
//import com.example.a1.favourites.AddPictureToFavourites;
//import com.example.a1.favourites.FavDB;
//
//import java.util.List;
//
//import lombok.NonNull;
//
//public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.ViewHolder> {
//
//    private List<AddPictureToFavourites> dataList;
//    private Context context;
//    private FavDB favDB;
//
//    public CoffeeAdapter(Context context, List<AddPictureToFavourites> dataList){
//        this.context = context;
//        this.dataList = dataList;
//    }
//
//    public void setDataList(List<AddPictureToFavourites> dataList) {
//        this.dataList = dataList;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.coffee_item, parent, false);
//        favDB = new FavDB(context);
//
//        SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
//        boolean firstStart = prefs.getBoolean("firstStart", true);
//        if (firstStart) {
//            createTableOnFirstStart();
//        }
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        AddPictureToFavourites coffeeItem = dataList.get(position);
////        holder.coffee_name.setText(coffeeTable.getName());
////        readCursorData(coffeeItem, holder);
//
//        Glide.with(context)
//                .load(coffeeItem.getPictureUrl())
//                .into(holder.coffee_image);
//        holder.coffee_name.setText(coffeeItem.getCoffeeName());
//    }
//
//    @Override
//    public int getItemCount() {
//        return dataList.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//
//        private ImageView coffee_image;
//        private TextView coffee_name;
//        private Button favButton;
//
//        public ViewHolder (@NonNull View itemView){
//            super(itemView);
//
//            coffee_image = itemView.findViewById(R.id.coffee_image_view);
//            coffee_name = itemView.findViewById(R.id.coffee_name_text_view);
//            favButton = itemView.findViewById(R.id.save_to_favs);
//
//            //add to fav btn
//            favButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    int position = getAdapterPosition();
//                    AddPictureToFavourites coffeeItem = dataList.get(position);
//
//                    likeClick(coffeeItem, favButton);
//                }
//            });
//        }
//    }
//
//    private void createTableOnFirstStart() {
//        favDB.insertEmpty();
//
//        SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = prefs.edit();
//        editor.putBoolean("firstStart", false);
//        editor.apply();
//    }
//
////    private void readCursorData(AddPictureToFavourites coffeeItem, ViewHolder viewHolder) {
////        Cursor cursor = favDB.read_all_data(coffeeItem.getId());
////        SQLiteDatabase db = favDB.getReadableDatabase();
////        try {
////            while (cursor.moveToNext()) {
////                @SuppressLint("Range") String item_fav_status = cursor.getString(cursor.getColumnIndex(FavDB.FAVORITE_STATUS));
//////                coffeeItem.setFavStatus(item_fav_status);
////
////                //check fav status
////                if (item_fav_status != null && item_fav_status.equals("1")) {
////                    viewHolder.favButton.setBackgroundResource(R.drawable.ic_favorite_red_24dp);
////                } else if (item_fav_status != null && item_fav_status.equals("0")) {
////                    viewHolder.favButton.setBackgroundResource(R.drawable.ic_favorite_shadow_24dp);
////                }
////            }
////        } finally {
////            if (cursor != null && cursor.isClosed())
////                cursor.close();
////            db.close();
////        }
////
////    }
//
//    private void likeClick (AddPictureToFavourites coffeeItem, Button favBtn) {
//
//        favDB.insertIntoTheDatabase(coffeeItem.getCoffeeName(), coffeeItem.getPictureUrl());
//    }
//}
