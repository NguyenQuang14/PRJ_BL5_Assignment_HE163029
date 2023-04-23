/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import db.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author Admin
 */
public class AdminEditProduct extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        String imgsrc = request.getParameter("imgsrc");
        String nameprod = request.getParameter("nameprod");
        double priceprod = Double.parseDouble(request.getParameter("priceprod"));
        String descprod = request.getParameter("descprod");
        int quantityprod = Integer.parseInt(request.getParameter("quantityprod"));
        int cateidprod = Integer.parseInt(request.getParameter("cateidprod"));
//        int page = Integer.parseInt(request.getParameter("page"));
        ProductDAO d = new ProductDAO();
        Product product = new Product(nameprod, imgsrc, priceprod, descprod, quantityprod, cateidprod);
        d.adminAddNewProduct(product);
        request.setAttribute("mess", "add succ");
        request.getRequestDispatcher("admin-product").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int page = Integer.parseInt(request.getParameter("page"));
        int idprod = Integer.parseInt(request.getParameter("idprod"));
        String imgsrc = request.getParameter("imgsrc");
        String nameprod = request.getParameter("nameprod");
        double priceprod = Double.parseDouble(request.getParameter("priceprod"));
        String descprod = request.getParameter("descprod");
        int quantityprod = Integer.parseInt(request.getParameter("quantityprod"));
        int cateidprod = Integer.parseInt(request.getParameter("cateidprod"));
        ProductDAO d = new ProductDAO();
        Product product = new Product(nameprod, imgsrc, priceprod, descprod, quantityprod, cateidprod);
        d.adminEditProduct(product, idprod);
        request.setAttribute("mess", "update succ");
        request.setAttribute("page", page);
        request.getRequestDispatcher("admin-edit-info?productId="+idprod).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
