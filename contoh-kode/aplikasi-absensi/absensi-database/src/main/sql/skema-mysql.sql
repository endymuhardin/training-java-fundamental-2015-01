create table karyawan(
    id INT PRIMARY KEY,
    nama VARCHAR(255) NOT NULL
) ENGINE=InnoDB ;

create table kehadiran(
    id INT PRIMARY KEY,
    id_karyawan INT NOT NULL,
    datang DATETIME NOT NULL,
    pulang DATETIME NOT NULL,
    FOREIGN KEY (id_karyawan) REFERENCES karyawan(id)
) Engine InnoDB ;

