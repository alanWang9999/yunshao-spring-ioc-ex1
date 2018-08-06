package com.yunshao.servlet;

import com.yunshao.dao.DBHelperBean;
import com.yunshao.entity.Users;
import com.yunshao.listener.MySpringContextLoaderListener;
import com.yunshao.service.UserService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DoLoginServlet" , urlPatterns = "/DoLoginServlet")
public class DoLoginServlet extends HttpServlet
{
    public static final String SESSION_ATTRIBUTE_LOGIN_USER = "sessionLoginUser";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request  , response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //获取提交的参数
        String loginName = request.getParameter("loginName");
        String pwd = request.getParameter("pwd");


        //首先获取spring上下文环境对象
        ApplicationContext ac = (ApplicationContext) request.getServletContext().getAttribute(MySpringContextLoaderListener.WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        UserService userService = ac.getBean(UserService.class);

        Users users = userService.selectUserByLoginName(loginName);
        if(users == null)//说明用户不存在,用户名输入错误
        {
            request.setAttribute("msg" , "用户名输入错误!!!!");
            request.getRequestDispatcher("login.jsp").forward(request , response);
        } else if(!users.getPassword().equals(pwd))
        {
            request.setAttribute("msg" , "密码输入错误!!!!");
            request.getRequestDispatcher("login.jsp").forward(request , response);
        } else
        {
            request.getSession().setAttribute(SESSION_ATTRIBUTE_LOGIN_USER , users);
            response.sendRedirect("/ProductListServlet");
        }

    }
}
