package com.muhardin.endy.absensi.web;

import com.muhardin.endy.absensi.Karyawan;
import com.muhardin.endy.absensi.database.KaryawanDao;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DaftarKehadiranServlet extends HttpServlet {

    private KaryawanDao karyawanDao;
    
    public DaftarKehadiranServlet() {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://localhost/absensi");
        ds.setUser("root");
        ds.setPassword("admin");
        
        karyawanDao = new KaryawanDao(ds);
    }

    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // sediakan data karyawan untuk di combo
        List<Karyawan> semuaKaryawan = karyawanDao.semuaKaryawan();
        
        // masukkan ke request attribute supaya bisa dipakai di JSP
        req.setAttribute("dataKaryawan", semuaKaryawan);
        
        req.getRequestDispatcher("/WEB-INF/templates/jsp/kehadiran/list.jsp")
                .forward(req, resp);
    }
    
}
