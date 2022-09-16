package com.redz.food.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redz.food.dto.DishDto;
import com.redz.food.entity.Dish;
import com.redz.food.entity.DishFlavor;
import com.redz.food.service.DishFlavorService;
import com.redz.food.service.DishService;
import com.redz.food.mapper.DishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author rehe
* @description 针对表【dish(菜品管理)】的数据库操作Service实现
* @createDate 2022-09-06 14:21:59
*/
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish>
    implements DishService{
    @Autowired
    private DishFlavorService dishFlavorService;

    @Override
    @Transactional
    public void saveWithFlavor(DishDto dishDto) {
        //保存菜品基本信息到菜品表dish
        this.save(dishDto);

        Long dishid = dishDto.getId();
        //菜品口味
        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors = flavors.stream().map((item) -> {
            item.setDishId(dishid);
            return item;
        }).collect(Collectors.toList());
        //dishFlavorService.saveBatch(dishDto.getFlavors());
        //保存菜品口味到菜品数据表dish_flavor
        dishFlavorService.saveBatch(flavors);
    }
}




