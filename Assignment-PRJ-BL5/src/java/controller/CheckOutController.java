/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import db.CartDAO;
import db.OrderDAO;
import db.OrderDetailDAO;
import db.ShippingDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.Map;
import model.Cart;
import model.Order;
import model.Shipping;

/**
 *
 * @author Admin
 */
public class CheckOutController extends HttpServlet {

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
            int accountId = Integer.parseInt(request.getParameter("accountId"));
            String fName = request.getParameter("firstname");
            String lName = request.getParameter("lastname");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String note = request.getParameter("note");
            String address = request.getParameter("address");
            String detailAddress = request.getParameter("detailaddress");
            HttpSession session = request.getSession();
            Map<Integer, Cart> carts = (Map<Integer, Cart>) session.getAttribute("carts");
            if (carts == null) {
                carts = new LinkedHashMap<>();
            }
            double totalMoney = 0;
            for (Map.Entry<Integer, Cart> entry : carts.entrySet()) {
                Integer productId = entry.getKey();
                Cart cart = entry.getValue();
                totalMoney += cart.getQuantity() * cart.getProduct().getPrice();
            }
            String finalAddress = detailAddress + " " + address;
            String fullName = fName + " " + lName;
            if (request.getParameter("terms") != null) {
                // luu vao order
                Order order = new Order(accountId, totalMoney, note);
                int orderId = new OrderDAO().createReturnId(order);
                // luu vao shipping
                ShippingDAO sd = new ShippingDAO();
                Shipping shipping = new Shipping(fullName, phone, finalAddress, orderId);
                int shippingId = sd.createReturnId(shipping);

                //luu vao orderdetail
                OrderDetailDAO ord = new OrderDetailDAO();
                ord.saveCart(orderId, carts);
                session.removeAttribute("carts");
                CartDAO cd = new CartDAO();
                cd.removeFromCart(accountId);
                if (request.getParameter("selector") != null) {
                    if (request.getParameter("selector").equals("pp")) {
                        request.setAttribute("totalMoney", totalMoney);
                        request.setAttribute("fullName", fullName);
                        request.getRequestDispatcher("creditCard.jsp").forward(request, response);
                        return;
                    }
                    request.getRequestDispatcher("thanks.jsp").forward(request, response);
                    return;
                } else {
                    request.getRequestDispatcher("cart-to-checkout?accountId=" + accountId).forward(request, response);
                }
            }else{
                request.getRequestDispatcher("cart-to-checkout?accountId=" + accountId).forward(request, response);
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
