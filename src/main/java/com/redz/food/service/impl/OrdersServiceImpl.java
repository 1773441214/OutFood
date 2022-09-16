package com.redz.food.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redz.food.entity.Orders;
import com.redz.food.service.OrdersService;
import com.redz.food.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

/**
* @author rehe
* @description 针对表【orders(订单表)】的数据库操作Service实现
* @createDate 2022-09-06 14:22:31
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
    implements OrdersService{

}




