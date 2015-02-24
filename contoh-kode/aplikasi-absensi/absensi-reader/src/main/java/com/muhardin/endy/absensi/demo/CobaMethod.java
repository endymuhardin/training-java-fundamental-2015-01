package com.muhardin.endy.absensi.demo;

public class CobaMethod {
    public void add(Integer x, Integer y){
        System.out.println(x + y);        
    }

    public Integer tambah(Integer x, Integer y){
        return x + y;
    }

    public static void main(String[] xx){
        CobaMethod c = new CobaMethod();

        System.out.println("------ Add ------");
        //Integer hasil = c.add(3,4);
        //System.out.println("Hasil : "+hasil);

        System.out.println("----- Tambah ----");
        Integer hasil2 = c.tambah(3,4);
        System.out.println("Hasil 2 : "+hasil2);
    }
}