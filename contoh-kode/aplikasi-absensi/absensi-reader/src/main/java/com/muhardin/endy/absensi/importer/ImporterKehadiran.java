package com.muhardin.endy.absensi.importer;

import java.util.List;
import com.muhardin.endy.absensi.Kehadiran;
import java.io.FileNotFoundException;

public interface ImporterKehadiran {
    public List<Kehadiran> importData() throws FileNotFoundException ;
}