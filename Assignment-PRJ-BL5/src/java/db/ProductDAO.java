/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

/**
 *
 * @author ADMIN
 */
public class ProductDAO extends DBContext {

    public void delete(String id) {
        String sql = "delete from Product where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update(Product s) {
        String sql = "update product set id=?,name=?,image=?,price=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, s.getId());
            st.setString(2, s.getName());
            st.setString(3, s.getImage());
            st.setDouble(4, s.getPrice());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int getProductQuantity(int id) throws SQLException {
        String sql = "select quantity from Product where id = ?";
        PreparedStatement st = connection.prepareStatement(sql);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    public boolean existedProduct(String id) {
        String sql = "select * from Product where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public void insert(Product s) {
        String sql = "insert into student values(?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, s.getId());
            st.setString(2, s.getName());
            st.setString(3, s.getImage());
            st.setDouble(4, s.getPrice());
            ResultSet rs = st.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<Product> getListByPage(ArrayList<Product> list1, int start, int end) {
        ArrayList<Product> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(list1.get(i));
        }
        return list;
    }

    public ArrayList<Product> getProductWithNumber(int start, int end) {
        ArrayList<Product> list = new ArrayList<>();
        try {
            String sql = "select * from Product where status = 1 order by id\n"
                    + "offset ? row fetch next ? rows only";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, start);
            st.setInt(2, end);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
//                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),rs.getString(5), rs.getInt(6), rs.getInt(7));
                Product product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
                list.add(product);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Product> getProductWithPagging(int page, int PAGE_SIZE) {
        ArrayList<Product> list = new ArrayList<>();
        try {
            String sql = "select * from Product where status = 1 order by id\n"
                    + "offset (?-1)*? row fetch next ? rows only";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, page);
            st.setInt(2, PAGE_SIZE);
            st.setInt(3, PAGE_SIZE);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
                list.add(product);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Product> getProductWithPaggingSortBy(int page, int PAGE_SIZE, int selectId) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "select * from Product where status = 1 order by id offset (?-1)*? row fetch next ? rows only";
        if (selectId == 1) {
            sql = "select * from Product where status = 1 order by name offset (?-1)*? row fetch next ? rows only";
        } else if (selectId == 2) {
            sql = "select * from Product where status = 1 order by price offset (?-1)*? row fetch next ? rows only";
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, page);
            st.setInt(2, PAGE_SIZE);
            st.setInt(3, PAGE_SIZE);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
                list.add(product);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int getTotalProduct() {
        ArrayList<Product> list = new ArrayList<>();
        try {
            String sql = "select count(id) from Product where status = 1";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ArrayList<Product> getAll() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "select * from Product where status = 1";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
                list.add(product);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) throws SQLException {
        ProductDAO d = new ProductDAO();
        int num = 0;
        num = d.getProductQuantity(12);
        System.out.println(num);
    }

    public ArrayList<Product> getProductsByCategoryId(int categoryId) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "select * from product where cateID = ? and status = 1";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, categoryId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
                list.add(product);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Product getProductById(int productId) {
        String sql = "select * from product where id = ? and status = 1";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, productId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
                return product;
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void adminEditProduct(Product product, int idprod) {
        String sql = "UPDATE [dbo].[product]\n"
                + "   SET \n"
                + "      [name] = ?\n"
                + "      ,[image] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[quantity] = ?\n"
                + "      ,[cateID] = ?\n"
                + " WHERE [product].id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, product.getName());
            st.setString(2, product.getImage());
            st.setDouble(3, product.getPrice());
            st.setString(4, product.getDescription());
            st.setInt(5, product.getQuantity());
            st.setInt(6, product.getCategoryId());
            st.setInt(7, idprod);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void adminDeleteProduct(int productId) {
        String sql = "UPDATE [dbo].[product]\n"
                + "   SET [status] = 0\n"
                + " WHERE id =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, productId);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void adminAddNewProduct(Product product) {
        String sql = "INSERT INTO [dbo].[product]\n"
                + "           ([name]\n"
                + "           ,[image]\n"
                + "           ,[price]\n"
                + "           ,[description]\n"
                + "           ,[quantity]\n"
                + "           ,[cateID])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, product.getName());
            st.setString(2, product.getImage());
            st.setDouble(3, product.getPrice());
            st.setString(4, product.getDescription());
            st.setInt(5, product.getQuantity());
            st.setInt(6, product.getCategoryId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
