package com.redz.food.service;

import com.redz.food.dto.DishDto;
import com.redz.food.entity.Dish;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
* @author rehe
* @description 针对表【dish(菜品管理)】的数据库操作Service
* @createDate 2022-09-06 14:21:59
*/
public interface DishService extends IService<Dish> {

    void saveWithFlavor(DishDto dishDto);

    DishDto getByIdWithFlavor(Long id);

    void updateWithFlavor(DishDto dishDto);
}
