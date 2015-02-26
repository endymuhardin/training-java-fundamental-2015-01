create table karyawan(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nama VARCHAR(255) NOT NULL
) ENGINE=InnoDB ;

create table kehadiran(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_karyawan INT NOT NULL,
    datang DATETIME NOT NULL,
    pulang DATETIME NOT NULL,
    FOREIGN KEY (id_karyawan) REFERENCES karyawan(id)
) Engine InnoDB ;

