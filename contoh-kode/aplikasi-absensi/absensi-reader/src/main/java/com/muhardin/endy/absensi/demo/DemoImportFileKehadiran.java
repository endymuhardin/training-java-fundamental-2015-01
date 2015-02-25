package com.muhardin.endy.absensi.demo;

import com.muhardin.endy.absensi.importer.file.ImporterKehadiranTextfile;
import com.muhardin.endy.absensi.importer.ImporterKehadiran;
import com.muhardin.endy.absensi.Kehadiran;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DemoImportFileKehadiran{
    public static void main(String[] xx) {
        try {
            File f = new File("src/main/resources/data.txt");
            
            ImporterKehadiran im
                    = new ImporterKehadiranTextfile(f);
            
            List<Kehadiran> hasil = im.importData();
            System.out.println("Jumlah data : "+hasil.size());
            
            tampilkanDaftarKehadiran(hasil);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DemoImportFileKehadiran.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "File gak ketemu gan", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void tampilkanDaftarKehadiran(List<Kehadiran> hasil) {
        System.out.println("============ Data Kehadiran ============");
        for (Kehadiran k : hasil) {
            System.out.println("--------------------------");
            System.out.println("ID Karyawan : "+k.getKaryawan().getId());
            System.out.println("Datang : "+k.getDatang());
            System.out.println("Pulang : "+k.getPulang());
        }
        System.out.println("============ Data Kehadiran ============");
    }
}