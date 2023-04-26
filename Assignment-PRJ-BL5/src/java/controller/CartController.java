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
public class CartController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<SanPham,Integer> cart = (HashMap<SanPham,Integer>) req.getSession().getAttribute("cart");
        int masp = Integer.parseInt(req.getParameter("spxoa"));
        for (SanPham s : cart.keySet()) {
            if (s.getMaSp() == masp) {
                cart.remove(s);
                break;
            }
        }
        req.getSession().setAttribute("cart", cart);
        req.getRequestDispatcher("/jsps/cart.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsps/cart.jsp").forward(req,resp);
    }
    
}
