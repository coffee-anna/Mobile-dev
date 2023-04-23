package com.example.a1.calorie_counter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class History {
    private String id;
    private String date;
    private String item;
    private String totalCalories;

    @Override
    public String toString() {
        return item + " : " + totalCalories + " calories";
    }
}
