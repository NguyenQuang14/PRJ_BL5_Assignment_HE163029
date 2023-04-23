/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import db.AccountDAO;
import db.CartDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import model.Account;
import model.Cart;
import db.CartEntity;
import jakarta.servlet.http.Cookie;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class LoginController extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
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
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        boolean remember = true;
        if (cookies != null) {
            for (Cookie cooky : cookies) {
                if (cooky.getName().equals("username")) {
                    username = cooky.getValue();
                }
                if (cooky.getName().equals("password")) {
                    password = cooky.getValue();
                }
                if (username != null && password != null) {
                    break;
                }
            }
            if (username != null && password != null) {
                request.setAttribute("username", username);
                request.setAttribute("password", password);
                request.getSession().setAttribute("remember", remember);
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            }
        }
        response.sendRedirect("login.jsp");
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean remember = request.getParameter("selector") != null;
        Account account = new AccountDAO().login(username, password);
        HttpSession session = request.getSession();

        if (account != null) {
            if (remember) {
                Cookie usernameCookie = new Cookie("username", username);
                usernameCookie.setMaxAge(60 * 60 * 24 * 2);
                Cookie passwordCookie = new Cookie("password", password);
                passwordCookie.setMaxAge(60 * 60 * 24);
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
                session.setAttribute("remember", remember);
            } else {
                Cookie[] cookies = request.getCookies();
                for (Cookie cooky : cookies) {
                    if (cooky.getName().equals("username")) {
                        cooky.setMaxAge(0);
                        response.addCookie(cooky);
                    }
                    if (cooky.getName().equals("password")) {
                        cooky.setMaxAge(0);
                        response.addCookie(cooky);
                    }
                }
                session.removeAttribute("remember");
            }
            int accountId = account.getId();
            CartDAO cd = new CartDAO();
            ArrayList<CartEntity> list = cd.getCartEntityById(accountId);
            Map<Integer, Cart> carts = cd.getCartByCartEntity(list);
            session.setAttribute("account", account);
            session.setAttribute("carts", carts);
            response.sendRedirect("home");
        } else {
            request.setAttribute("mess", "wrong username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);

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
