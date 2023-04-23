/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;

/**
 *
 * @author Admin
 */
public class CategoryDAO extends DBContext {

    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> list = new ArrayList<>();
        try {
            String sql = "select * from Category";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
//                Category category =  Category.builder()
//                                .id(rs.getInt(1))
//                                .name(rs.getString(2)).build();
                Category category = new Category(rs.getInt(1), rs.getString(2), rs.getInt(3));
                list.add(category);
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Category> list = new CategoryDAO().getAllCategories();
        for (Category c : list) {
            System.out.println(c);
        }
    }

    public void addNewCategory(String name) {
        String sql = "INSERT INTO [dbo].[Category]\n"
                + "           ([cname]\n"
                + "           ,[quantity])\n"
                + "     VALUES\n"
                + "           (?,0)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteCategory(int cateId) {
        String sql = "UPDATE [dbo].[product]\n"
                + "   SET \n"
                + "      [status] = 0\n"
                + " WHERE cateID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cateId);
            st.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Category getCategoryById(int cateId) {
        try {
            String sql = "select * from Category where cid = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cateId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Category(rs.getInt(1), rs.getString(2), rs.getInt(3));

            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateCategory(String name, int cateId) {
        String sql = "UPDATE [dbo].[Category]\n"
                + "   SET [cname] = ?\n"
                + " WHERE cid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setInt(2, cateId);
            st.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
