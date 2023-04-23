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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cart;

/**
 *
 * @author Admin
 */
public class OrderDetailDAO extends DBContext {

    public void saveCart(int orderId, Map<Integer, Cart> carts) {
        try {
            String sql = "INSERT INTO [dbo].[OrderDetail]\n"
                    + "           ([order_id]\n"
                    + "           ,[quantity]\n"
                    + "           ,[productId])\n"
                    + "     VALUES\n"
                    + "           (?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, orderId);
            for (Map.Entry<Integer, Cart> entry : carts.entrySet()) {
                Integer productId = entry.getKey();
                Cart cart = entry.getValue();
                st.setInt(2, cart.getQuantity());
                st.setInt(3, cart.getProduct().getId());
                st.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ShippingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteFromOrderDetail(int orderId) {
        try {
            String sql = "DELETE FROM [dbo].[OrderDetail]\n"
                    + "      WHERE order_id = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, orderId);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ShippingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Map<Integer, Integer> getProductInFoOrderDetail(int orderId) {
        Map<Integer, Integer> list = new LinkedHashMap<>();
        try {
            String sql = "SELECT [productId],[quantity]\n"
                    + "  FROM [ProjectPRO].[dbo].[OrderDetail]\n"
                    + "  where order_id = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, orderId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.put(rs.getInt(1), rs.getInt(2));
            }

            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ShippingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> list = new OrderDetailDAO().getProductInFoOrderDetail(18);
        for (Map.Entry<Integer, Integer> entry : list.entrySet()) {
            Integer productId = entry.getKey();
            Integer quantity = entry.getValue();
            System.out.println(productId + ":" + quantity);
        }
    }

    public void updateQuantityProduct(Map<Integer, Integer> listProdOd) {
        try {
            String sql = "UPDATE [dbo].[product]\n"
                    + "   SET \n"
                    + "      [quantity] = [quantity] - ?\n"
                    + " WHERE id = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            for (Map.Entry<Integer, Integer> entry : listProdOd.entrySet()) {
                Integer productId = entry.getKey();
                Integer quantity = entry.getValue();
                st.setInt(1, quantity);
                st.setInt(2, productId);
                st.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
