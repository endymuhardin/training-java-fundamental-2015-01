package com.muhardin.endy.absensi.database;

import com.muhardin.endy.absensi.Karyawan;
import com.muhardin.endy.absensi.Kehadiran;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class KehadiranDao {
    
    private DataSource dataSource;

    public KehadiranDao(DataSource ds) {
        this.dataSource = ds;
    }
    
    public void simpan(Kehadiran k){
        try {
            Connection koneksi = dataSource.getConnection();
            
            String sql = "insert into kehadiran (id_karyawan, datang, pulang) ";
            sql += "values (?,?,?)";
            
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setInt(1, k.getKaryawan().getId());
            ps.setTimestamp(2, new java.sql.Timestamp(k.getDatang().getTime()));
            ps.setTimestamp(3, new java.sql.Timestamp(k.getPulang().getTime()));
            ps.executeUpdate();
            
            koneksi.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(KehadiranDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Kehadiran> cariKehadiran(Karyawan k, Date mulai, Date sampai, Integer awal, Integer baris){
        List<Kehadiran> hasil = new ArrayList<>();
        
        try {
            
            String sql = "select * from kehadiran "
                    + "where id_karyawan = ? and "
                    + "datang >= ? and datang <= ? "
                    + "order by datang "
                    + "limit ?,?";
            
            Connection koneksi = dataSource.getConnection();
            
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setInt(1, k.getId());
            ps.setTimestamp(2, new java.sql.Timestamp(mulai.getTime()));
            ps.setTimestamp(3, new java.sql.Timestamp(sampai.getTime()));
            ps.setInt(4, awal);
            ps.setInt(5, baris);
            
            ResultSet hasilQuery = ps.executeQuery();
            while(hasilQuery.next()){
                Kehadiran kh = new Kehadiran();
                kh.setId(hasilQuery.getInt("id"));
                
                Karyawan kr = new Karyawan();
                kr.setId(hasilQuery.getInt("id_karyawan"));
                kh.setKaryawan(kr);
                
                kh.setDatang(hasilQuery.getTimestamp("datang"));
                kh.setPulang(hasilQuery.getTimestamp("pulang"));
                
                hasil.add(kh);
            }
                    
            koneksi.close();
                    
        } catch (SQLException ex) {
            Logger.getLogger(KehadiranDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }

    public Integer hitungKehadiran(Karyawan k, Date mulai, Date sampai) {
        try {
            String sql = "select count(*) from kehadiran "
                    + "where id_karyawan = ? and "
                    + "datang >= ? and datang <= ? ";
            
            Connection koneksi = dataSource.getConnection();
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setInt(1, k.getId());
            ps.setTimestamp(2, new java.sql.Timestamp(mulai.getTime()));
            ps.setTimestamp(3, new java.sql.Timestamp(sampai.getTime()));
            
            ResultSet hasilQuery = ps.executeQuery();
            if(hasilQuery.next()){
                return hasilQuery.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KehadiranDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
