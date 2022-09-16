package com.redz.food.service;

import com.redz.food.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author rehe
* @description 针对表【category(菜品及套餐分类)】的数据库操作Service
* @createDate 2022-09-06 14:21:35
*/
public interface CategoryService extends IService<Category> {
    void remove(Long id);
}
