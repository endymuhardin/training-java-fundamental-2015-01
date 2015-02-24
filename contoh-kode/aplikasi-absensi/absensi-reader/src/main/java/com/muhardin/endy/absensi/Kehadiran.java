package com.muhardin.endy.absensi;

import java.util.Date;

public class Kehadiran {

    private Karyawan karyawan;
    private Date datang;
    private Date pulang;

    // getter dan setter
    public Karyawan getKaryawan(){
        return karyawan;
    }

    public void setKaryawan(Karyawan k){
        karyawan = k;
    }

    public Date getDatang(){
        return datang;
    }

    public void setDatang(Date k){
        datang = k;
    }

    public Date getPulang(){
        return pulang;
    }

    public void setPulang(Date k){
        pulang = k;
    }

}