package com.redz.food.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redz.food.entity.OrderDetail;
import com.redz.food.service.OrderDetailService;
import com.redz.food.mapper.OrderDetailMapper;
import org.springframework.stereotype.Service;

/**
* @author rehe
* @description 针对表【order_detail(订单明细表)】的数据库操作Service实现
* @createDate 2022-09-06 14:22:24
*/
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail>
    implements OrderDetailService{

}




