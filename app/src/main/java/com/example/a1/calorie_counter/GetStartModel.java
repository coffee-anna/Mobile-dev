package com.example.a1.calorie_counter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetStartModel {
    Double currentWeight;
    Double targetWeight;
    Double currentCalories;
    Double targetCalories;
}
