/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;
import model.Shipping;

/**
 *
 * @author Admin
 */
public class ShippingDAO extends DBContext {

    public int createReturnId(Shipping shipping) {
        try {
            String sql = "INSERT INTO [dbo].[Shipping]\n"
                    + "           ([name]\n"
                    + "           ,[phone]\n"
                    + "           ,[address]\n"
                    + "           ,[order_id])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, shipping.getName());
            st.setString(2, shipping.getPhone());
            st.setString(3, shipping.getAddress());
            st.setInt(4, shipping.getOrderId());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShippingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void deleteFromShipping(int orderId) {
        try {
            String sql = "DELETE FROM [dbo].[Shipping]\n"
                    + "      WHERE order_id = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, orderId);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ShippingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getShippingId(int orderId) {
        try {
            String sql = "SELECT [id]\n"
                    + "  FROM [ProjectPRO].[dbo].[Shipping]\n"
                    + "  where [order_id] = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, orderId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {                
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShippingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
