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
import model.Product;

/**
 *
 * @author Admin
 */
public class CartDAO extends DBContext {

    public void AddToCart(int AccountId, int productId, int Amount) {
        try {
            String sql = "INSERT INTO [dbo].[Cart]\n"
                    + "           ([AccountID]\n"
                    + "           ,[ProductID]\n"
                    + "           ,[Amount])\n"
                    + "     VALUES\n"
                    + "           (?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, AccountId);
            st.setInt(2, productId);
            st.setInt(3, Amount);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateCart(int AccountId, int productId, int Amount) {
        try {
            String sql = "update cart set Amount=" + Amount
                    + "where AccountID=" + AccountId + "and ProductID=" + productId;
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteFromCart(int AccountId, int productId) {
        try {
            String sql = "DELETE FROM [dbo].[Cart]\n"
                    + "      WHERE AccountID= ? and  ProductID= ?  ";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, AccountId);
            st.setInt(2, productId);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<CartEntity> getCartEntityById(int id) {
        try {
            ArrayList<CartEntity> list = new ArrayList<>();
            String sql = "select*from Cart where AccountID =" + id;
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                CartEntity cart = new CartEntity(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                list.add(cart);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Map<Integer, Cart> getCartByCartEntity(ArrayList<CartEntity> list) {
        Map<Integer, Cart> listCart = new LinkedHashMap<>();
        for (CartEntity cartEntity : list) {

            if (listCart.containsKey(cartEntity.getProductID())) {
                int oldQuantity = listCart.get(cartEntity.getProductID()).getQuantity();
                listCart.get(cartEntity.getProductID()).setQuantity(oldQuantity + 1);
            } else {
                Product product = new ProductDAO().getProductById(cartEntity.getProductID());
                Cart cart = new Cart(cartEntity.getAccountID(), product, 1);
                listCart.put(cartEntity.getProductID(), new Cart(cartEntity.getAccountID(), product, 1));
            }
        }
        return listCart;
    }

    public static void main(String[] args) {
        ArrayList<CartEntity> list = new CartDAO().getCartEntityById(1);
        for (CartEntity cartEntity : list) {
            System.out.println(cartEntity);
        }
        Map<Integer, Cart> listcart = new CartDAO().getCartByCartEntity(list);
        for (Map.Entry<Integer, Cart> entry : listcart.entrySet()) {
            Integer productId = entry.getKey();
            Cart cart = entry.getValue();
            System.out.println(cart);

        }
    }

    public void removeFromCart(int accountId) {
        try {
            String sql = "DELETE FROM [dbo].[Cart]\n"
                    + "      WHERE AccountID = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, accountId);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
