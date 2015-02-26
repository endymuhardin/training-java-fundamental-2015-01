package com.muhardin.endy.absensi.database;

import com.muhardin.endy.absensi.Karyawan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class KaryawanDao {

    private DataSource dataSource;
    
    public KaryawanDao(DataSource ds) {
        this.dataSource = ds;
    }

    public void simpan(Karyawan k) {
        try (Connection koneksi = dataSource.getConnection()) {
            String sql = "insert into karyawan (id, nama) ";
            sql += "values (?, ?)";

            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setInt(1, k.getId());
            ps.setString(2, k.getNama());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(KehadiranDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
