package com.muhardin.endy.absensi.demo;

import com.muhardin.endy.absensi.importer.file.ImporterKehadiranTextfile;
import com.muhardin.endy.absensi.importer.ImporterKehadiran;
import com.muhardin.endy.absensi.Kehadiran;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class DemoImportFileKehadiran{
    public static void main(String[] xx){
        File f = new File("src/main/resources/data.txt");

        ImporterKehadiran im 
                = new ImporterKehadiranTextfile(f);

        List<Kehadiran> hasil = im.importData();
        System.out.println("Jumlah data : "+hasil.size());
    }
}