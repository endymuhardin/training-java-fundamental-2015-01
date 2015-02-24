package com.muhardin.endy.absensi.importer.file;

import com.muhardin.endy.absensi.importer.ImporterKehadiran;
import com.muhardin.endy.absensi.Kehadiran;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ImporterKehadiranTextfile 
                    implements ImporterKehadiran {
    
    private File sumberData;

    // constructor, untuk membuat object dari class ini
    // harus menyediakan file sumber data
    public ImporterKehadiranTextfile(File f){
        this.sumberData = f;
    }

    public List<Kehadiran> importData(){
        FileReader fr = null;
        BufferedReader br = null;
        List<Kehadiran> hasil = new ArrayList<Kehadiran>();
        try {
            System.out.println("Nanti memproses file di sini");
            fr = new FileReader(sumberData);
            br = new BufferedReader(fr);
            String data = br.readLine();
            while(data != null){
                System.out.println(data);
                data = br.readLine();
            }   
        } catch (Exception ex) {
            Logger.getLogger(ImporterKehadiranTextfile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(br != null){
                    br.close();
                }
                
                if(fr != null){
                    fr.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ImporterKehadiranTextfile.class.getName()).log(Level.SEVERE, null, ex);
            }
            return hasil;
        }
    }
}