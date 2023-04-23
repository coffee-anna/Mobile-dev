package com.example.a1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import lombok.NonNull;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<DataTable> dataList;
    private Context context;

    public DataAdapter(Context context, List<DataTable> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    public void setDataList(List<DataTable> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        DataTable data = dataList.get(position);
//        holder.idTextView.setText(data.getId());
        holder.loginTextView.setText(data.getOwner());
        holder.valueTextView.setText(data.getValue());
        holder.dateTimeTextView.setText(data.getCreationDateTime());
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//            idTextView = itemView.findViewById(R.id.idTextView);
            loginTextView = itemView.findViewById(R.id.loginTextView);
            valueTextView = itemView.findViewById(R.id.valueTextView);
            dateTimeTextView = itemView.findViewById(R.id.dateTimeTextView);
        }
    }
}
