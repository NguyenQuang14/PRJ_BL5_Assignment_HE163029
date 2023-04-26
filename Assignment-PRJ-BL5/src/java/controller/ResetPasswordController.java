/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.authentication.BaseAuthController;
import db.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.User;

/**
 *
 * @author admin
 */
public class ResetPasswordController extends BaseAuthController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, User user) throws ServletException, IOException {
        req.getRequestDispatcher("/jsps/password-reset.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, User user) throws ServletException, IOException {
        String oldpass = req.getParameter("oldpass");
        String oldpassrep = req.getParameter("oldpassrepeat");
        String newpass = req.getParameter("newpass");
        
        if (!oldpass.equals(oldpassrep)) {
            req.setAttribute("errmsg","Mat khau cu va mat khau cu nhap lai phai giong nhau!");
        } else {
            
            UserDAO checker = new UserDAO();
            
            if (!checker.isExist(user.getUsername(), oldpass)) {
                req.setAttribute("errmsg","Mat khau cu ban nhap vao khong dung!");
            } else {
                UserDAO updater = new UserDAO();
                updater.updatePassword(user.getUsername(), newpass);
                req.setAttribute("successmsg","Doi mat khau thanh cong!");
            } 
            
        }
        req.getRequestDispatcher("/jsps/password-reset.jsp").forward(req, resp);
    }
    
}
