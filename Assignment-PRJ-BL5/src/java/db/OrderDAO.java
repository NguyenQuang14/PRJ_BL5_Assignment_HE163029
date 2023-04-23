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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;
import model.OrderHistory;
import model.OrderHistory_Product;
import model.OrderHistory_Shipping;
import model.OrderInfo;

/**
 *
 * @author Admin
 */
public class OrderDAO extends DBContext {

    public int createReturnId(Order order) {
        String status = "false";
        try {
            String sql = "INSERT INTO [dbo].[Order]\n"
                    + "           ([accountId]\n"
                    + "           ,[totalPrice]\n"
                    + "           ,[note]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, order.getAccountId());
            st.setDouble(2, order.getTotalPrice());
            st.setString(3, order.getNote());
            st.setString(4, status);
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ArrayList<OrderInfo> getInfoOrder(int accountId) {
        ArrayList<OrderInfo> list = new ArrayList<>();
        String status = "false";
        try {
            String sql = "SELECT o.id, u.First_Name, u.Last_Name, u.PhoneNumber,  u.Email, o.totalPrice,o.createdDate from [Order] o inner join UserInfo u on o.accountId = u.AccountId\n"
                    + "where u.AccountId = ? and status = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, accountId);
            st.setString(2, "false");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                OrderInfo orderInfo = new OrderInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getString(7));
                list.add(orderInfo);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void sendToOrderHistory(Order order, int shippingId) {
        try {
            String sql = "INSERT INTO [dbo].[OrderHistory]\n"
                    + "           ([accountId]\n"
                    + "           ,[totalPrice]\n"
                    + "           ,[note]\n"
                    + "           ,[createdDate]\n"
                    + "           ,[shippingId]\n"
                    + "           ,[orderId])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, order.getAccountId());
            st.setDouble(2, order.getTotalPrice());
            st.setString(3, order.getNote());
            st.setDate(4, order.getCreatedDate());
            st.setInt(5, shippingId);
            st.setInt(6, order.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Order getOrderbyId(int orderId) {
        try {
            String sql = "SELECT [id]\n"
                    + "      ,[accountId]\n"
                    + "      ,[totalPrice]\n"
                    + "      ,[note]\n"
                    + "      ,[createdDate]\n"
                    + "  FROM [ProjectPRO].[dbo].[Order]\n"
                    + "  where [id] = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, orderId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Order order = new Order(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getString(4), rs.getDate(5));
                return order;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void deleteFromOrder(int orderId) {
        try {
            String sql = "DELETE FROM [dbo].[Order]\n"
                    + "      WHERE [id] = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, orderId);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<OrderHistory> getOrderHistory(int accountId) {
        ArrayList<OrderHistory> list = new ArrayList<>();
        try {
            String sql = "SELECT [id]\n"
                    + "      ,[accountId]\n"
                    + "      ,[totalPrice]\n"
                    + "      ,[note]\n"
                    + "      ,[createdDate]\n"
                    + "      ,[confirmDate]\n"
                    + "      ,[shippingId]\n"
                    + "      ,[orderId]\n"
                    + "  FROM [ProjectPRO].[dbo].[OrderHistory]\n"
                    + "  where [accountId] = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, accountId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                OrderHistory orderHistory = new OrderHistory(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getString(4), rs.getDate(5), rs.getDate(6), rs.getInt(7), rs.getInt(8));
                list.add(orderHistory);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<OrderHistory_Shipping> getOrderHistoryShipping() {
        ArrayList<OrderHistory_Shipping> list = new ArrayList<>();
        try {
            String sql = "select oh.shippingId, s.name, s.phone,s.address,oh.createdDate,oh.confirmDate from Shipping s inner join OrderHistory oh on s.id = oh.shippingId";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                OrderHistory_Shipping ohs = new OrderHistory_Shipping(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getDate(6));
                list.add(ohs);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<OrderHistory_Product> getOrderHistoryProduct() {
        ArrayList<OrderHistory_Product> list = new ArrayList<>();
        try {
            String sql = "select od.order_id,\n"
                    + "		p.name,\n"
                    + "		p.image,\n"
                    + "		p.price,		\n"
                    + "		od.quantity\n"
                    + "from OrderDetail od inner join product p on od.productId = p.id";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                OrderHistory_Product ohp = new OrderHistory_Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5));
                list.add(ohp);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void deleteFromOrderHistory(int ordHistoryId) {
        try {
            String sql = "DELETE FROM [dbo].[OrderHistory]\n"
                    + "      WHERE id = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, ordHistoryId);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Integer> getCheckedOrderId(int accountId) {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            String sql = "SELECT orderId\n"
                    + "  FROM [ProjectPRO].[dbo].[OrderHistory]\n"
                    + "  where accountId = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, accountId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateOrderStatus(int orderId) {
        try {
            String sql = "UPDATE [dbo].[Order]\n"
                    + "   SET   [status] = 'true'\n"
                    + " WHERE id = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, orderId);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<OrderHistory_Shipping> getOrderShipping() {
        ArrayList<OrderHistory_Shipping> list = new ArrayList<>();
        try {
            String sql = " select oh.id, s.name, s.phone,s.address, oh.createdDate, s.order_id from Shipping s inner join [Order] oh on s.order_id = oh.id";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                OrderHistory_Shipping ohs = new OrderHistory_Shipping(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getInt(6));
                list.add(ohs);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<OrderHistory_Product> getOrderProduct() {
        ArrayList<OrderHistory_Product> list = new ArrayList<>();
        try {
            String sql = "select od.order_id,\n"
                    + "		p.name,\n"
                    + "		p.image,\n"
                    + "		p.price,		\n"
                    + "		od.quantity\n"
                    + "from OrderDetail od inner join product p on od.productId = p.id";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                OrderHistory_Product ohp = new OrderHistory_Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5));
                list.add(ohp);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        OrderDAO od = new OrderDAO();
//        ArrayList<OrderHistory> odinfo = od.getOrderHistory(1);
//        ArrayList<OrderHistory_Product> odInfo_Prod = od.getOrderHistoryProduct();
//        ArrayList<OrderHistory_Shipping> odInfo_Ship = od.getOrderHistoryShipping();
//        for (OrderHistory of : odinfo) {
//            System.out.println("a");
//            System.out.println(of);
//        }
//        for (OrderHistory_Product op : odInfo_Prod) {
//             System.out.println("b");
//            System.out.println(op);
//        }
//        for (OrderHistory_Shipping os : odInfo_Ship) {
//             System.out.println("c");
//            System.out.println(os);
//        }
        Order order = od.getOrderbyId(24);
        System.out.println(order);
    }
}
