package com.redz.food.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.redz.food.entity.Setmeal;
import com.redz.food.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
