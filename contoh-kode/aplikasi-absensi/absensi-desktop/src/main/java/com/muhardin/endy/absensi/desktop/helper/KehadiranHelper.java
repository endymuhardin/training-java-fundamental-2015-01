package com.muhardin.endy.absensi.desktop.helper;

import com.muhardin.endy.absensi.Karyawan;
import com.muhardin.endy.absensi.Kehadiran;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KehadiranHelper {
    public static List<Karyawan> generateDaftarKaryawan(List<Kehadiran> dataKehadiran){
        List<Karyawan> hasil = new ArrayList<>();
        
        Set<Integer> daftarId = new HashSet<>();
        for (Kehadiran kehadiran : dataKehadiran) {
            if(daftarId.add(kehadiran.getKaryawan().getId())){
                Karyawan k = kehadiran.getKaryawan();
                k.setNama("Karyawan "+k.getId());
                hasil.add(k);
            }
        }
        
        return hasil;
    }
    
    public static List<Kehadiran> cariKehadiran(Karyawan karyawan, List<Kehadiran> data){
        List<Kehadiran> hasil = new ArrayList<>();
        
        for (Kehadiran k : data) {
            if(!karyawan.getId().equals(k.getKaryawan().getId())){
                continue;
            }
            hasil.add(k);
        }
        
        return hasil;
    }
}
