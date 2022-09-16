package com.redz.food.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redz.food.entity.ShoppingCart;
import com.redz.food.service.ShoppingCartService;
import com.redz.food.mapper.ShoppingCartMapper;
import org.springframework.stereotype.Service;

/**
* @author rehe
* @description 针对表【shopping_cart(购物车)】的数据库操作Service实现
* @createDate 2022-09-06 14:22:43
*/
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart>
    implements ShoppingCartService{

}




