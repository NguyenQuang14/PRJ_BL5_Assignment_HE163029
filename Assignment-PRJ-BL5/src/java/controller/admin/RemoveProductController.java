/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.admin;

import controller.authentication.BaseAuthController;
import db.DanhMucDAO;
import db.SanPhamDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.DanhMuc;
import model.SanPham;
import model.User;

/**
 *
 * @author admin
 */
public class RemoveProductController extends BaseAuthController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, User user) throws ServletException, IOException {
        if (!user.getRole().getRoleName().equals("admin")) {
            resp.getWriter().println("access denied");
        } else {
            int masp = Integer.parseInt(req.getParameter("pid"));
            SanPhamDAO ctx = new SanPhamDAO();
            ctx.delete(masp);
            DanhMucDAO dmctx = new DanhMucDAO();
            req.setAttribute("listdm", dmctx.all());
            req.setAttribute("noti", "Xoa thanh cong san pham voi ma so: " + masp);
            req.getRequestDispatcher("/jsps/admin-manage.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, User user) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
