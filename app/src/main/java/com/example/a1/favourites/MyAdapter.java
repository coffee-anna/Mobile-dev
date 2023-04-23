//package com.example.a1.favourites;
//
//import android.net.Uri;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.a1.R;
//
//import java.util.List;
//
//public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
//
//    private final List<MyModel> list;
//    private final FavouriteDao favoriteDao;
//
//    public MyAdapter(List<MyModel> list, FavouriteDao favoriteDao) {
//        this.list = list;
//        this.favoriteDao = favoriteDao;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coffee_item, parent, false);
//        return new ViewHolder(view);
//    }
//
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//
//        MyModel model = list.get(position);
//        holder.coffeeImage.setImageURI(Uri.parse(model.coffeeImage));
//        holder.coffeeName.setText(model.coffeeName);
//
//        boolean isFavorite = favoriteDao.isFavorite(model.id);
//        if (isFavorite) {
//            holder.iv_favorite.setImageResource(R.drawable.ic_favorite);
//        } else {
//            holder.iv_favorite.setImageResource(R.drawable.ic_favorite_border);
//        }
//
//        holder.iv_favorite.setOnClickListener(view -> {
//            boolean isCurrentlyFavorite = favoriteDao.isFavorite(model.id);
//            if (isCurrentlyFavorite) {
//                favoriteDao.deleteData(model.id);
//                holder.iv_favorite.setImageResource(R.drawable.ic_favorite_border);
//            } else {
//                favoriteDao.insertAllData(new FavouriteModel(model.id, model.coffeeImage, model.coffeeName));
//                holder.iv_favorite.setImageResource(R.drawable.ic_favorite);
//            }
//        });
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        public TextView coffeeName;
//        public ImageView coffeeImage;
//        public ImageView iv_favorite;
//
//        public ViewHolder(View view) {
//            super(view);
//            iv_favorite = view.findViewById(R.id.iv_favorite);
//            coffeeName = view.findViewById(R.id.fav_coffee_textView);
//            coffeeImage = view.findViewById(R.id.fav_coffee_imageView);
//
//        }
//    }
//}
