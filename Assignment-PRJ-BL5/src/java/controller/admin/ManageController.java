/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.admin;

import controller.authentication.BaseAuthController;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.User;

/**
 *
 * @author admin
 */
public class ManageController extends BaseAuthController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, User user) throws ServletException, IOException {
        if (!user.getRole().getRoleName().equals("admin")) {
            resp.getWriter().println("access denied");
        } else {
            
            req.getRequestDispatcher("/jsps/admin-manage.jsp").forward(req,resp);
        }
        
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, User user) throws ServletException, IOException {
        if (!user.getRole().getRoleName().equals("admin")) {
            resp.getWriter().println("access denied");
            return;
        } else {
            
            req.getRequestDispatcher("/jsps/admin-manage.jsp").forward(req,resp);
        }
            
        
        
    }
}
