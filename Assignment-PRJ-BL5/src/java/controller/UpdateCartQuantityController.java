/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import db.CartDAO;
import db.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cart;

/**
 *
 * @author Admin
 */
public class UpdateCartQuantityController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            CartDAO cd = new CartDAO();
            HttpSession session = request.getSession();
            int productId = Integer.parseInt(request.getParameter("productId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int accountId = Integer.parseInt(request.getParameter("accountId"));
            ProductDAO pd = new ProductDAO();
            Map<Integer, Cart> carts = (Map<Integer, Cart>) session.getAttribute("carts");
            String quan = (String) session.getAttribute("quan");
            if (carts == null) {
                carts = new LinkedHashMap<>();
            }
            if (quantity <= pd.getProductQuantity(productId) && quantity > 0) {
                if (carts.containsKey(productId)) {
                    cd.updateCart(accountId, productId, quantity);
                    carts.get(productId).setQuantity(quantity);
                }
            } else {
                String[] split = quan.split("&&");
                String[] str = null;
                int temp = 0;
                for (int i = 0; i < split.length; i++) {
                    str = split[i].split(" ");
                    if (Integer.parseInt(str[0]) == productId) {
                        temp = Integer.parseInt(str[1]);
                        break;
                    }
                }
                if (carts.containsKey(productId)) {
                    cd.updateCart(accountId, productId, temp);
                    carts.get(productId).setQuantity(temp);
                }
            }
            session.setAttribute("carts", carts);
            response.sendRedirect("cart");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateCartQuantityController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateCartQuantityController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
