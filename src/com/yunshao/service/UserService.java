package com.yunshao.service;


import com.yunshao.dao.UserDao;
import com.yunshao.entity.Users;

public class UserService
{
    private UserDao userDao;

    /**
     * 通过用户名获取用户对象
     * @param loginName
     * @return
     */
    public Users selectUserByLoginName(String loginName)
    {
        return userDao.selectUsersByLoginName(loginName);
    }


    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
