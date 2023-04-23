package com.example.a1.calorie_counter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.a1.R;
import java.util.List;

import lombok.NonNull;

public class CalorieAdapter extends RecyclerView.Adapter<CalorieAdapter.ViewHolder>{

    private List<CalorieTable> dataList;
    private Context context;

    public CalorieAdapter(Context context, List<CalorieTable> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    public void setDataList(List<CalorieTable> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public CalorieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new CalorieAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CalorieAdapter.ViewHolder holder, int position) {

        CalorieTable data = dataList.get(position);
//        holder.idTextView.setText(data.getId());
        holder.loginTextView.setText(data.getFood());
        holder.valueTextView.setText(data.getCalories());
        holder.dateTimeTextView.setText(data.getCreationDateAndTime());
//        holder.total.setText(data.getTotal());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        //        private TextView idTextView;
        private TextView loginTextView;
        private TextView valueTextView;
        private TextView dateTimeTextView;
        private TextView total;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//            idTextView = itemView.findViewById(R.id.idTextView);
            loginTextView = itemView.findViewById(R.id.loginTextView);
            valueTextView = itemView.findViewById(R.id.valueTextView);
            dateTimeTextView = itemView.findViewById(R.id.dateTimeTextView);
//            total = itemView.findViewById(R.id.CalorieTotal);
        }
    }
}
