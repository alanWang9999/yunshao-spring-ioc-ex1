package com.yunshao.servlet;

import com.yunshao.entity.Product;
import com.yunshao.listener.MySpringContextLoaderListener;
import com.yunshao.service.ProductService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductListServlet" , urlPatterns = "/ProductListServlet")
public class ProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request , response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //获取spring上下文环境对象
        ApplicationContext ac = (ApplicationContext) request.getServletContext().getAttribute(MySpringContextLoaderListener.WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        //利用spring上下文环境对象获取service层对象
        ProductService productService = ac.getBean(ProductService.class);


        List<Product> list =productService.selectAll();
        request.setAttribute("productList" , list);

        request.getRequestDispatcher("product_list.jsp").forward(request , response);
    }
}
