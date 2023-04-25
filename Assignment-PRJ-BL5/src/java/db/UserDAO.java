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
    public User get(String username, String password) {
        String sql = "select u.Account, u.[Password], u.Hoten, u.SoDT, u.DiaChi, u.[Role], ur.roleName from Users u\n" +
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
}
