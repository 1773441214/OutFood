package com.redz.food.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redz.food.entity.DishFlavor;
import com.redz.food.service.DishFlavorService;
import com.redz.food.mapper.DishFlavorMapper;
import org.springframework.stereotype.Service;

/**
* @author rehe
* @description 针对表【dish_flavor(菜品口味关系表)】的数据库操作Service实现
* @createDate 2022-09-06 14:22:12
*/
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor>
    implements DishFlavorService{

}




