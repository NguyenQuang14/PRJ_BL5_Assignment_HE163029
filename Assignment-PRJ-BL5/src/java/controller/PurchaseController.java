/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import db.SanPhamDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import model.SanPham;

/**
 *
 * @author admin
 */
public class PurchaseController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int masp = Integer.parseInt(req.getParameter("pid"));
        SanPhamDAO ctx = new SanPhamDAO();
        SanPham sp = ctx.get(masp);
        int soluong = Integer.parseInt(req.getParameter("soluong"));
        req.setAttribute("sp", sp);
        req.setAttribute("noti", "San pham da duoc them vao gio hang!");
        HashMap<SanPham, Integer> cart;
        if (req.getSession().getAttribute("cart") == null) {
            cart = new HashMap<SanPham, Integer>();
        } else {
            cart = (HashMap<SanPham, Integer>)req.getSession().getAttribute("cart");
        }
        boolean foundDuplicate = false;
        // Check ma sp
        for (SanPham s : cart.keySet()) {
            if (s.getMaSp() == masp) {
                foundDuplicate = true;
                cart.put(s, cart.get(s)+soluong);
                break;
            }
        }
        if (!foundDuplicate) {
            cart.put(sp, soluong);
        }
        
        System.out.println(cart);
        System.out.println(cart.size());
        req.getSession().setAttribute("cart", cart);
        req.getRequestDispatcher("/jsps/purchase.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int masp = Integer.parseInt(req.getParameter("pid"));
        SanPhamDAO ctx = new SanPhamDAO();
        req.setAttribute("sp", ctx.get(masp));
        req.getRequestDispatcher("/jsps/purchase.jsp").forward(req,resp);
    }
    
}
