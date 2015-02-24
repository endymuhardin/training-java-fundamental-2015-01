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
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DemoImportFileKehadiran.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "File gak ketemu gan", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}