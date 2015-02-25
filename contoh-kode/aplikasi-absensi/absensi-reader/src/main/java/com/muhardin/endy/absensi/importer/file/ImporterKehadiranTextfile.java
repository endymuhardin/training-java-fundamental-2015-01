package com.muhardin.endy.absensi.importer.file;

import com.muhardin.endy.absensi.Karyawan;
import com.muhardin.endy.absensi.importer.ImporterKehadiran;
import com.muhardin.endy.absensi.Kehadiran;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImporterKehadiranTextfile
        implements ImporterKehadiran {

    private File sumberData;

    // constructor, untuk membuat object dari class ini
    // harus menyediakan file sumber data
    public ImporterKehadiranTextfile(File f) {
        this.sumberData = f;
    }

    public List<Kehadiran> importData() throws FileNotFoundException {
        FileReader fr = new FileReader(sumberData);
        BufferedReader br = new BufferedReader(fr);
        
        String polaWaktu = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat parserWaktu = new SimpleDateFormat(polaWaktu);
        SortedMap<Integer, List<Date>> dataAbsensi = new TreeMap<Integer, List<Date>>();
        
        try {
            String data;
            while ((data = br.readLine()) != null) {
                konversiDataJadiMap(data, parserWaktu, dataAbsensi);
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(ImporterKehadiranTextfile.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal membaca file");
        }
        
        //tampilkanMapHasilParsing(dataAbsensi);
        List<Kehadiran> hasil = konversiMapJadiListKehadiran(dataAbsensi);
        return hasil;
    }

    private List<Kehadiran> konversiMapJadiListKehadiran(SortedMap<Integer, List<Date>> dataAbsensi) {
        List<Kehadiran> hasil = new ArrayList<Kehadiran>();
        for (Integer x : dataAbsensi.keySet()) {
            SortedMap<String, List<Date>> kehadiranHarian = parseKehadiranPerHari(dataAbsensi, x);
            
            Karyawan kr = new Karyawan();
            kr.setId(x);
            
            for (String harian : kehadiranHarian.keySet()) {
                List<Date> dataHariIni = kehadiranHarian.get(harian);
                if(dataHariIni.size() < 2){
                    continue;
                }
                
                Kehadiran k = new Kehadiran();
                k.setKaryawan(kr);
                k.setDatang(dataHariIni.get(0));
                k.setPulang(dataHariIni.get(dataHariIni.size() - 1));
                hasil.add(k);
            }
        }
        return hasil;
    }

    private void tampilkanMapHasilParsing(SortedMap<Integer, List<Date>> dataAbsensi) {
        System.out.println("============= Data Absensi =================");
        for (Integer x : dataAbsensi.keySet()) {
            SortedMap<String, List<Date>> kehadiranHarian = parseKehadiranPerHari(dataAbsensi, x);
            System.out.println("Data Absensi ID "+x+" : "+kehadiranHarian);
        }
        System.out.println("============= Data Absensi =================");
    }

    private SortedMap<String, List<Date>> parseKehadiranPerHari(SortedMap<Integer, List<Date>> dataAbsensi, Integer x) {
        SortedMap<String, List<Date>> kehadiranHarian = new TreeMap<String, List<Date>>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for (Date tap : dataAbsensi.get(x)) {
            String tanggal = formatter.format(tap);
            List<Date> dataHadirHarian = kehadiranHarian.get(tanggal);
            if(dataHadirHarian == null){
                dataHadirHarian = new ArrayList<Date>();
            }
            
            dataHadirHarian.add(tap);
            kehadiranHarian.put(tanggal, dataHadirHarian);
        }
        return kehadiranHarian;
    }

    private void konversiDataJadiMap(String data, SimpleDateFormat parserWaktu, SortedMap<Integer, List<Date>> dataAbsensi) throws NumberFormatException {
        System.out.println(data);
        String[] dipecah = data.trim().split("[\\s]+");
        //tampilkanHasilSplit(dipecah);
        
        try {
            // parsing data tanggal
            Date waktu = parserWaktu.parse(dipecah[1]+" "+dipecah[2]);
            System.out.println("Waktu : "+waktu);
            
            Integer id = Integer.valueOf(dipecah[0]);
            List<Date> dataAbsensiKaryawan = dataAbsensi.get(id);
            
            if(dataAbsensiKaryawan == null){
                dataAbsensiKaryawan = new ArrayList<Date>();
            }
            
            dataAbsensiKaryawan.add(waktu);
            dataAbsensi.put(id, dataAbsensiKaryawan);
            
        } catch (ParseException ex) {
            Logger.getLogger(ImporterKehadiranTextfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void tampilkanHasilSplit(String[] dipecah) {
        System.out.println("Jumlah data setelah split : "+dipecah.length);
        System.out.println("Data 1 "+dipecah[0]);
        System.out.println("Data 2 "+dipecah[1]);
        System.out.println("Data 3 "+dipecah[2]);
        System.out.println("Data 4 "+dipecah[3]);
        System.out.println("Data 5 "+dipecah[4]);
        System.out.println("Data 6 "+dipecah[5]);
        System.out.println("Data 7 "+dipecah[6]);
    }
}
