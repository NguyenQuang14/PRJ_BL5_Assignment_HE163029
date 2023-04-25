/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package filter;

import db.AccountDAO;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author Admin
 */
@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/add-to-cart","/cart","/cart-to-checkout","/profile","/delete-cart"})
public class AuthenticationFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        //CheckLogin
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
       
        if (account != null) {
            chain.doFilter(request, response);
            return;
        } else {                        
            res.sendRedirect("http://localhost:8080/ShoppingVipPro/login.jsp");
        }
    }

    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {

    }

    /**
     * Return a String representation of this object.
     */
}
