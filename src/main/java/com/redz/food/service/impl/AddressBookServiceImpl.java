package com.redz.food.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redz.food.entity.AddressBook;
import com.redz.food.service.AddressBookService;
import com.redz.food.mapper.AddressBookMapper;
import org.springframework.stereotype.Service;

/**
* @author rehe
* @description 针对表【address_book(地址管理)】的数据库操作Service实现
* @createDate 2022-09-05 16:25:39
*/
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook>
    implements AddressBookService{

}




