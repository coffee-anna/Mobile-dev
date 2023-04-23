//package com.example.a1.favourites;
//
//import android.content.Context;
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
//import com.bumptech.glide.Glide;
//import com.example.a1.R;
//
//import java.util.List;
//
//public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.ViewHolder> {
//
//    public final Context context;
//    private final List<FavouriteModel> list;
//    private final DeleteItemClickListner deleteItemClickListner;
//    private final FavouriteDao mFavoriteDao;
//
//    public FavouriteAdapter(Context context, FavouriteDao favouriteDao, List<FavouriteModel> list, DeleteItemClickListner deleteItemClickListner) {
//        this.context = context;
//        this.mFavoriteDao = favouriteDao;
//        this.list = list;
//        this.deleteItemClickListner = deleteItemClickListner;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.coffee_item, parent, false));
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
//        FavouriteModel model = list.get(position);
//
//        holder.coffeeName.setText(model.coffeeName);
//        holder.coffeeImage.setImageURI(Uri.parse(model.pictureUrl));
////        Glide.with(holder.itemView.getContext()).load(favourites.getPictureUrl()).into(holder.favouritesImage);
//
//        boolean isFavorite = mFavoriteDao.isFavorite(model.id);
//        if (isFavorite) {
//            holder.iv_favorite.setImageResource(R.drawable.ic_favorite);
//        } else {
//            holder.iv_favorite.setImageResource(R.drawable.ic_favorite_border);
//        }
//
//        holder.iv_favorite.setOnClickListener(view -> deleteItemClickListner.onItemDelete(position, list.get(position).id));
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public interface DeleteItemClickListner {
//        void onItemDelete(int position, int id);
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        public TextView coffeeName;
//        public ImageView coffeeImage;
//        public ImageView iv_favorite;
//
//        public ViewHolder(View view) {
//            super(view);
//
//            coffeeImage = view.findViewById(R.id.fav_coffee_imageView);
//            coffeeName = view.findViewById(R.id.fav_coffee_textView);
//            iv_favorite = view.findViewById(R.id.iv_favorite);
//        }
//    }
//}