package com.redz.food.service;

import com.redz.food.dto.SetmealDto;
import com.redz.food.entity.Setmeal;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
* @author rehe
* @description 针对表【setmeal(套餐)】的数据库操作Service
* @createDate 2022-09-06 14:22:35
*/
public interface SetmealService extends IService<Setmeal> {

    //新增套餐，同时要保持与菜品的关联关系
    void saveWithDish(SetmealDto setmealDto);

    SetmealDto getByIdWithDish(Long id);
}
