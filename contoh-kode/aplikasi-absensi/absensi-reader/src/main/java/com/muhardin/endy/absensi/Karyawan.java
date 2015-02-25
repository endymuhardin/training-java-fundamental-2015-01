package com.muhardin.endy.absensi;

public class Karyawan {

    public static Integer jumlahKaryawan = 0;
    public Integer id = 1;
    private String nip;
    public String nama;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    

}