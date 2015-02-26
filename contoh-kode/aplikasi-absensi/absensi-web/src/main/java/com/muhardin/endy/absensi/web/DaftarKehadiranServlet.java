package com.muhardin.endy.absensi.web;

import com.muhardin.endy.absensi.Karyawan;
import com.muhardin.endy.absensi.Kehadiran;
import com.muhardin.endy.absensi.database.KaryawanDao;
import com.muhardin.endy.absensi.database.KehadiranDao;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DaftarKehadiranServlet extends HttpServlet {

    private KaryawanDao karyawanDao;
    private KehadiranDao kehadiranDao;
    
    public DaftarKehadiranServlet() {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://localhost/absensi");
        ds.setUser("root");
        ds.setPassword("admin");
        
        karyawanDao = new KaryawanDao(ds);
        kehadiranDao = new KehadiranDao(ds);
    }

    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // sediakan data karyawan untuk di combo
        List<Karyawan> semuaKaryawan = karyawanDao.semuaKaryawan();
        
        // masukkan ke request attribute supaya bisa dipakai di JSP
        req.setAttribute("dataKaryawan", semuaKaryawan);
        
        String id = req.getParameter("idKaryawan");
        if(id != null && !id.isEmpty()){
            try {
                Integer idKaryawan = Integer.valueOf(id);
                Karyawan k = new Karyawan();
                k.setId(idKaryawan);
                
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                
                // default value
                Date mulai = formatter.parse("2011-01-01");
                Date sampai = formatter.parse("2016-01-01");
                
                String strMulai = req.getParameter("mulai");
                if(strMulai != null && !strMulai.isEmpty()) {
                    mulai = formatter.parse(strMulai);
                }
                
                String strSampai = req.getParameter("sampai");
                if(strSampai != null && !strSampai.isEmpty()) {
                    sampai = formatter.parse(strSampai);
                }
                
                req.setAttribute("mulai", formatter.format(mulai));
                req.setAttribute("sampai", formatter.format(sampai));
                req.setAttribute("idPilihan", id);
                
                List<Kehadiran> dataKehadiran = kehadiranDao.cariKehadiran(k, mulai, sampai, 0, 10);
                req.setAttribute("dataKehadiran", dataKehadiran);
                
                
                
            } catch (ParseException ex) {
                Logger.getLogger(DaftarKehadiranServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        req.getRequestDispatcher("/WEB-INF/templates/jsp/kehadiran/list.jsp")
                .forward(req, resp);
    }
    
}
