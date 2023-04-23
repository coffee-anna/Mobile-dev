package com.example.a1.calorie_counter;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.a1.AppDatabase;
import com.example.a1.DataAdapter;
import com.example.a1.DataTable;
import com.example.a1.R;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private EditText CalorieFoodName, CalorieFoodCalories;
    private RecyclerView CalRecyclerView;
    public Button saveButton;

    private CalorieAdapter dataAdapter;

    private CalorieDatabase appDatabase;

    private String date;

    private int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calorie_list);

        CalorieFoodName = findViewById(R.id.CalorieFoodName);
        CalorieFoodCalories = findViewById(R.id.CalorieFoodCalories);
        CalRecyclerView = findViewById(R.id.CalRecyclerView);
        saveButton = findViewById(R.id.CalSaveButton);
//        TextView CalorieTotal = findViewById(R.id.CalorieTotal);

        SharedPreferences preferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
        date = preferences.getString("date", "");

        appDatabase = Room.databaseBuilder(getApplicationContext(), CalorieDatabase.class, "database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        List<CalorieTable> dataList = appDatabase.dataDao().getCalorieDataList(date);
        dataAdapter = new CalorieAdapter(this, dataList);
        CalRecyclerView.setAdapter(dataAdapter);
        CalRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        saveButton.setOnClickListener(v -> {
            String name = CalorieFoodName.getText().toString();
            String cal = CalorieFoodCalories.getText().toString();
//            String ttl = CalorieTotal.getText().toString();

            if (!name.isEmpty() && !cal.isEmpty()) {
                CalorieTable data = new CalorieTable();
                data.setFood(name);
                data.setCalories(cal);

                total += Integer.parseInt(cal);
                data.setTotal(String.valueOf(total));
//                data.setTotal(total);

                data.setCreationDateAndTime(date);
                appDatabase.dataDao().insertCalorieData(data);
                dataAdapter.setDataList(appDatabase.dataDao().getCalorieDataList(date));
                dataAdapter.notifyDataSetChanged();
                CalorieFoodName.setText("");
                CalorieFoodCalories.setText("");


//                CalorieTotal.setText(String.valueOf(total));
            }
        });
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        appDatabase.close();
//    }

    String getDateTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/M/yy HH:mm");
        return LocalDateTime.now().format(dateTimeFormatter);
    }
}
