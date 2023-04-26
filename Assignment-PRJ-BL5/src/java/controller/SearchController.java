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
import java.util.ArrayList;
import model.SanPham;

/**
 *
 * @author admin
 */
public class SearchController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String sample = req.getParameter("q");
        SanPhamDAO ctx = new SanPhamDAO();
        ArrayList<SanPham> ls = ctx.getByStringContain(sample);
        
        req.setAttribute("splist", ls);
        req.getRequestDispatcher("/jsps/search.jsp").forward(req, resp);
    }
    
}
