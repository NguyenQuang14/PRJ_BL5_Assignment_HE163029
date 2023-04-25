/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

/**
 *
 * @author admin
 */
public class SanPhamDAO extends DBContext {
    public void insert() {
    
    }
    
    public ArrayList<SanPham> getByDanhMuc(int danhMuc) {
        ArrayList<SanPham> list = new ArrayList<>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "select s.MaSanPham, s.MaDanhMuc, ds.TenDanhMuc, s.TenSanPham, s.GiaBan, s.MotaSanPham, s.LinkAnh from SanPham s\n" +
"inner join DanhMucSanPham ds on s.MaDanhMuc = ds.MaDanhMuc\n" +
"where s.MaDanhMuc = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, danhMuc);
            rs = stm.executeQuery();
            while (rs.next()) {
                SanPham s = new SanPham();
                s.setMaSp(rs.getInt("MaSanPham"));
                
                DanhMuc dm = new DanhMuc();
                dm.setMaDMuc(rs.getInt("MaDanhMuc"));
                dm.setTenDMuc(rs.getString("TenDanhMuc"));
                
                s.setdMuc(dm);
                
                s.setMoTa(rs.getString("MotaSanPham"));
                s.setTenSp(rs.getString("TenSanPham"));
                s.setGiaBan(rs.getInt("GiaBan"));
                s.setLinkAnh(rs.getString("LinkAnh"));
                
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

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
        return list;
    }
    
    public void get() {
        
    }
}
