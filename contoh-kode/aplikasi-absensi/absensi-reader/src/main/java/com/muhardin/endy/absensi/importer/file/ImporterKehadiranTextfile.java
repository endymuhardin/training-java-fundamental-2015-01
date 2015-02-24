package com.muhardin.endy.absensi.importer.file;

import com.muhardin.endy.absensi.importer.ImporterKehadiran;
import com.muhardin.endy.absensi.Kehadiran;
import java.util.ArrayList;
import java.util.List;
import java.io.File;


public class ImporterKehadiranTextfile 
                    implements ImporterKehadiran {
    
    private File sumberData;

    // constructor, untuk membuat object dari class ini
    // harus menyediakan file sumber data
    public ImporterKehadiranTextfile(File f){
        this.sumberData = f;
    }

    public List<Kehadiran> importData(){
        List<Kehadiran> hasil = new ArrayList<Kehadiran>();
        
        System.out.println("Nanti memproses file di sini");

        return hasil;
    }
}