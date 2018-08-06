package com.yunshao.service;

import com.yunshao.dao.ProductDao;
import com.yunshao.entity.Product;

import java.util.List;

public class ProductService
{
    private ProductDao productDao;


    public List<Product> selectAll()
    {
        return productDao.selectAll();
    }


    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
}
