package com.example.a1.calorie_counter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Eat {
    String food;
    String calories;

    @Override
    public String toString() {
        return food+","+calories;
    }
}
