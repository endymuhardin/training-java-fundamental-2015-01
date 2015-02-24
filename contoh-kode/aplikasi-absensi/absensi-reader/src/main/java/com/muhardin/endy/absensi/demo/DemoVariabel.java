package com.muhardin.endy.absensi.demo;

import com.muhardin.endy.absensi.Karyawan;

public class DemoVariabel {
    
    public static void main(String[] x){

        Karyawan.jumlahKaryawan = 10;
        System.out.println("Jumlah : "+Karyawan.jumlahKaryawan);
        //k.id = 7; // instance variable, harus ada instance dulu, baru bisa diisi

        Karyawan k = new Karyawan();
        k.jumlahKaryawan = 1;
        k.id = 1;
        k.nama = "Endy";
        System.out.println("ID     : "+k.id);
        System.out.println("Nama   : "+k.nama);
        System.out.println("Jumlah : "+k.jumlahKaryawan);

        Karyawan k2 = new Karyawan();
        k2.jumlahKaryawan = 2;
        k2.id = 2;
        k2.nama = "Adi";
        System.out.println("ID     : "+k2.id);
        System.out.println("Nama   : "+k2.nama);
        System.out.println("Jumlah : "+k2.jumlahKaryawan);

        System.out.println("ID     : "+k.id);
        System.out.println("Nama   : "+k.nama);
        System.out.println("Jumlah : "+k.jumlahKaryawan);
    }
}