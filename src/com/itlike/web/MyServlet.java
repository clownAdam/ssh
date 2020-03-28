package com.itlike.web;

import com.itlike.service.UserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MyServlet");
        ServletContext context = this.getServletContext();
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(context);
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();

    }

}
