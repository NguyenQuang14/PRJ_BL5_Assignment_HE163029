/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.admin;

import controller.authentication.BaseAuthController;
import db.DanhMucDAO;
import db.SanPhamDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;
import model.DanhMuc;
import model.SanPham;
import model.User;
import org.apache.tomcat.jakartaee.commons.compress.utils.FileNameUtils;
import util.RandomString;

/**
 *
 * @author admin
 */

@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class EditProductController extends BaseAuthController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, User user) throws ServletException, IOException {
        if (!user.getRole().getRoleName().equals("admin")) {
            resp.getWriter().println("access denied");
        } else {
            int masp = Integer.parseInt(req.getParameter("pid"));
            SanPhamDAO spctx = new SanPhamDAO();
            SanPham sp = spctx.get(masp);
            DanhMucDAO ctx = new DanhMucDAO();
            ArrayList<DanhMuc> ls = ctx.all();
            
            req.setAttribute("dmlist", ls);
            req.setAttribute("sp", sp);
            req.getRequestDispatcher("/jsps/admin-editpage.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, User user) throws ServletException, IOException {
        if (!user.getRole().getRoleName().equals("admin")) {
            resp.getWriter().println("access denied");
            return;
        } else {
            String webRootPath = getServletContext().getRealPath("/").replace('\\', '/');
            String newFileName = RandomString.generate();
            SanPham sp = new SanPham();
            sp.setMaSp(Integer.parseInt(req.getParameter("masp")));
            sp.setTenSp(req.getParameter("tensanpham"));
            sp.setGiaBan(Integer.parseInt(req.getParameter("giaban")));
            sp.setMoTa(req.getParameter("motasanpham"));
            
            DanhMuc dm = new DanhMuc();
            dm.setMaDMuc(Integer.parseInt(req.getParameter("danhmuc")));
            
            sp.setdMuc(dm);
            sp.setLinkAnh(req.getParameter("prevlinkanh"));
            Part filePart = req.getPart("linkanh");
            if (filePart.getSize()>0) { // check if user selected file
                String extension = FileNameUtils.getExtension(filePart.getSubmittedFileName());
                String newFile = newFileName + "." + extension;
                filePart.write((webRootPath + "images/" + newFile).replace('/', '\\'));
                sp.setLinkAnh(newFile);
            }
            
            DanhMucDAO ctxdm = new DanhMucDAO();
            ArrayList<DanhMuc> list = ctxdm.all();
            
            req.setAttribute("listdm", list);
            SanPhamDAO ctx = new SanPhamDAO();
            ctx.update(sp);
            req.setAttribute("noti", "Cap nhat thanh cong san pham voi ma so: " + sp.getMaSp());
            req.getRequestDispatcher("/jsps/admin-manage.jsp").forward(req,resp);
        }
    }
    
}
