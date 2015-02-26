package com.muhardin.endy.absensi.web;

public class PagingHelper {
    
    private Integer dataPerHalaman;
    private Integer halamanSekarang;
    private Integer jumlahData;

    public Integer getDataPerHalaman() {
        return dataPerHalaman;
    }

    public void setDataPerHalaman(Integer dataPerHalaman) {
        this.dataPerHalaman = dataPerHalaman;
    }

    public Integer getHalamanSekarang() {
        return halamanSekarang;
    }

    public void setHalamanSekarang(Integer halamanSekarang) {
        this.halamanSekarang = halamanSekarang;
    }

    public Integer getJumlahHalaman() {
        return (jumlahData / dataPerHalaman) + 1;
    }

    public Integer getJumlahData() {
        return jumlahData;
    }

    public void setJumlahData(Integer jumlahData) {
        this.jumlahData = jumlahData;
    }
    
    public Integer getPosisiSekarang(){
        return (halamanSekarang - 1) * dataPerHalaman;
    }
    
}
