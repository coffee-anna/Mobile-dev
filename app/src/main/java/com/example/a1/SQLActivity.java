package com.example.a1;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;

import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class


public class SQLActivity extends AppCompatActivity {

    private EditText dataEditText;
    private RecyclerView dataRecyclerView;
    public Button saveButton;

    private DataAdapter dataAdapter;

    private AppDatabase appDatabase;

    private String owner;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.sql_activity);
////
////        dataEditText = findViewById(R.id.SQLDataEditText);
////        dataRecyclerView = findViewById(R.id.recyclerView);
////        saveButton = findViewById(R.id.saveButton);
////
////        SharedPreferences preferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
////        owner = preferences.getString("login", "");
////
////        appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name")
////                .allowMainThreadQueries()
////                .build();
////
////        List<DataTable> dataList = appDatabase.dataDao().getDataList(owner);
////        dataAdapter = new DataAdapter(this, dataList);
////        dataRecyclerView.setAdapter(dataAdapter);
////        dataRecyclerView.setLayoutManager(new LinearLayoutManager(this));
////
////        saveButton.setOnClickListener(v -> {
////            String value = dataEditText.getText().toString();
////            if (!value.isEmpty()) {
////                DataTable data = new DataTable();
////                data.setOwner(owner);
////                data.setValue(value);
////                data.setCreationDateTime(getDateTime());
////                appDatabase.dataDao().insertData(data);
////                dataAdapter.setDataList(appDatabase.dataDao().getDataList(owner));
////                dataAdapter.notifyDataSetChanged();
////                dataEditText.setText("");
////            }
////        });
////    }
////
//////    @Override
//////    protected void onDestroy() {
//////        super.onDestroy();
//////        appDatabase.close();
//////    }
////
////    String getDateTime() {
////        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/M/yy HH:mm");
////        return LocalDateTime.now().format(dateTimeFormatter);
////    }

}
