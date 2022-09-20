package com.redz.food.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redz.food.dto.SetmealDto;
import com.redz.food.entity.Setmeal;
import com.redz.food.entity.SetmealDish;
import com.redz.food.service.SetmealDishService;
import com.redz.food.service.SetmealService;
import com.redz.food.mapper.SetmealMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author rehe
* @description 针对表【setmeal(套餐)】的数据库操作Service实现
* @createDate 2022-09-06 14:22:35
*/
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal>
    implements SetmealService{
    @Autowired
    private SetmealDishService setmealDishService;

    //新增套餐，同时要保持与菜品的关联关系
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveWithDish(SetmealDto setmealDto) {
        //保存套餐基本信息，操作setmeal，执行insert操作
        this.save(setmealDto);
        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();
        setmealDishes.stream().map((item)->{
            item.setSetmealId(String.valueOf(setmealDto.getId()));
            return item;
        }).collect(Collectors.toList());
        //保存套餐和菜品的关联信息，操作setmeal_dish，执行insert操作
        setmealDishService.saveBatch(setmealDishes);
    }

    @Override
    public SetmealDto getByIdWithDish(Long id) {
        //查询套餐基本信息
        Setmeal setmeal = this.getById(id);
        SetmealDto setmealDto = new SetmealDto();
        BeanUtils.copyProperties(setmeal, setmealDto);
        //查询套餐菜品信息
        LambdaQueryWrapper<SetmealDish> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(SetmealDish::getSetmealId,setmeal.getId());
        List<SetmealDish> list = setmealDishService.list(queryWrapper);
        setmealDto.setSetmealDishes(list);
        return setmealDto;
    }

}




