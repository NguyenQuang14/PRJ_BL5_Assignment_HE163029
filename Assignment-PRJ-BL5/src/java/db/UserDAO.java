/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

/**
 *
 * @author admin
 */
public class UserDAO extends DBContext {
    
    public void insert(User u, String password) {
        PreparedStatement stm = null;
        try {
            String sql = "insert into Users (Account, [Password], Hoten, SoDT, DiaChi, [Role]) values \n" +
            "(?,?,?,?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, u.getUsername());
            stm.setString(2, password);
            stm.setString(3, u.getFullName());
            stm.setString(4, u.getPhone());
            stm.setString(5, u.getAddress());
            stm.setInt(6, 1); // 1 de gan cho khach hang
            
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public User get(String username, String password) {
        String sql = "select u.Account, u.Hoten, u.SoDT, u.DiaChi, u.[Role], ur.roleName from Users u\n" +
"inner join UserRoles ur on u.[Role] = ur.roleId\n" +
"where Account = ? and [Password] = ?";
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();
            if(rs.next())
            {
                User s = new User();
                s.setUsername(username);
                s.setFullName(rs.getString("Hoten"));
                s.setPhone(rs.getString("SoDT"));
                s.setAddress(rs.getString("DiaChi"));
                
                UserRole ur = new UserRole();
                ur.setRoleId(rs.getInt("Role"));
                ur.setRoleName(rs.getString("roleName"));
                
                s.setRole(ur);
                
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public boolean isExist(String username, String password) {
        String sql = "select Account from Users\n" +
                     " where Account = ? and [Password] = ?";
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();
            if(rs.next())
            {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public void updatePassword(String username, String newpass) {
        PreparedStatement stm = null;
        try {
            String sql = "update Users\n" +
                        "set [Password] = ? where Account = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, newpass);
            stm.setString(2, username);
            
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
