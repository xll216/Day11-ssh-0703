package com.lanou.service.impl;

import com.lanou.dao.UserDao;
import com.lanou.service.UserService;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;//持有的dao层对象

    @Override
    public boolean login(String name, String psw) {
        return userDao.login(name, psw);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
