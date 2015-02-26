package com.muhardin.endy.absensi.database.demo;

import com.muhardin.endy.absensi.Karyawan;
import com.muhardin.endy.absensi.Kehadiran;
import com.muhardin.endy.absensi.database.KehadiranDao;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.List;

public class DemoKehadiranDao {
    public static void main(String[] args) throws Exception {
        // inisialisasi database driver
        Class.forName("com.mysql.jdbc.Driver");
        
        // inisialisasi data source
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://localhost/absensi");
        ds.setUser("root");
        ds.setPassword("admin");
        
        // sampel data
        Karyawan kr = new Karyawan();
        kr.setId(99);
        
        SimpleDateFormat formatterWaktu = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Kehadiran kh = new Kehadiran();
        kh.setKaryawan(kr);
        kh.setDatang(formatterWaktu.parse("2015-02-01 08:00:00"));
        kh.setPulang(formatterWaktu.parse("2015-02-01 17:00:00"));
        
        System.out.println("Datang : "+kh.getDatang());
        
        // mari kita insert
        KehadiranDao kd = new KehadiranDao(ds);
        kd.simpan(kh);
        
        // mari kita select
        List<Kehadiran> hasilQuery = kd.cariKehadiran(kr, 
                formatterWaktu.parse("2015-02-01 08:00:00"), 
                formatterWaktu.parse("2015-02-27 08:00:00"), 
                0, 100);
        
        for (Kehadiran kx : hasilQuery) {
            System.out.println("Karyawan : "+kx.getKaryawan().getId());
            System.out.println("Datang : "+kx.getDatang());
            System.out.println("Pulang : "+kx.getPulang());
        }
    }
    
    public void koneksiOdbc() throws Exception {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection koneksiOdbc = DriverManager.getConnection("jdbc:odbc:NamaDSN", "username", "password");
    }
}
