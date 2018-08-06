package com.yunshao.dao;

import com.yunshao.entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao
{
    private DBHelperBean dbHelperBean;

    public Users selectUsersByLoginName(String loginName)
    {
        String sql = "select id , loginName , password , userName from easybuy_user where loginName=?";
        Connection connection = dbHelperBean.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Users users = null;
        try
        {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1 , loginName);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                users = new Users();

                int id = resultSet.getInt("id");
                users.setId(id);

                String password = resultSet.getString("password");
                users.setPassword(password);

                String userName = resultSet.getString("userName");
                users.setUserName(userName);

                users.setLoginName(loginName);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally {
            //释放资源
            dbHelperBean.closeAll(connection , preparedStatement , resultSet);
        }
        return users;
    }

    public DBHelperBean getDbHelperBean() {
        return dbHelperBean;
    }
    public void setDbHelperBean(DBHelperBean dbHelperBean) {
        this.dbHelperBean = dbHelperBean;
    }
}
