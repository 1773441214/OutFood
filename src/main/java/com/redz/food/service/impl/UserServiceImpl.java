package com.redz.food.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redz.food.entity.User;
import com.redz.food.service.UserService;
import com.redz.food.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author rehe
* @description 针对表【user(用户信息)】的数据库操作Service实现
* @createDate 2022-09-06 14:22:47
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




