package com.yunshao.dao;

import com.yunshao.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao
{
    private DBHelperBean dbHelperBean;

    public List<Product> selectAll()
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Product> list = new ArrayList<Product>();
        try
        {
            connection = dbHelperBean.getConnection();
            String sql = "select id , name , price from easybuy_product";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                list.add(product);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally {
            dbHelperBean.closeAll(connection , preparedStatement , resultSet);
        }
        return list;
    }

    public DBHelperBean getDbHelperBean() {
        return dbHelperBean;
    }

    public void setDbHelperBean(DBHelperBean dbHelperBean) {
        this.dbHelperBean = dbHelperBean;
    }
}
