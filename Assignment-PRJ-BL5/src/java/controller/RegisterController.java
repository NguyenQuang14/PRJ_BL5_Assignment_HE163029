/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import db.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.User;

/**
 *
 * @author admin
 */
public class RegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            User u = new User();
            
            u.setUsername(req.getParameter("username"));
            String password = req.getParameter("password");
            u.setFullName(req.getParameter("fullname"));
            u.setPhone(req.getParameter("phone"));
            u.setAddress(req.getParameter("address"));
            
            // Chac check sau... phai co validate
            UserDAO ctx = new UserDAO();
            ctx.insert(u, password);
            
            req.setAttribute("msg", "Dang ky thanh cong.\nVui long dang nhap de tien hanh su dung tai khoan vua tao!");
            req.getRequestDispatcher("/jsps/login.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            req.getRequestDispatcher("/jsps/register.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("");
        }
    }
    
}
