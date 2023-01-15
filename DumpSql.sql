-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 01, 2016 at 08:07 PM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tapsp`
--

-- --------------------------------------------------------

--
-- Table structure for table `fakultas`
--

CREATE TABLE IF NOT EXISTS `fakultas` (
`id_fakultas` int(11) NOT NULL,
  `id_univ` int(11) NOT NULL,
  `nama_fakultas` varchar(256) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `fakultas`
--

INSERT INTO `fakultas` (`id_fakultas`, `id_univ`, `nama_fakultas`, `flag`) VALUES
(1, 1, 'Fakultas Ilmu Komputer', 1),
(2, 1, 'Fakultas Ilmu Budaya', 1),
(3, 1, 'Fakultas Kedokteran', 1),
(4, 2, 'Fakultas Kedokteran', 1),
(5, 3, 'Fakultas Teknik', 1);

-- --------------------------------------------------------

--
-- Table structure for table `gaji`
--

CREATE TABLE IF NOT EXISTS `gaji` (
`id_gaji` int(11) NOT NULL,
  `id_prodi` int(11) NOT NULL,
  `role` varchar(32) DEFAULT NULL,
  `nominal` int(11) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `gaji`
--

INSERT INTO `gaji` (`id_gaji`, `id_prodi`, `role`, `nominal`) VALUES
(1, 1, 'Dekan', 15000000),
(2, 1, 'Wakil Dekan', 12000000),
(3, 1, 'Dosen', 10000000),
(4, 1, 'Staf Pendukung', 7000000);

-- --------------------------------------------------------

--
-- Table structure for table `irs`
--

CREATE TABLE IF NOT EXISTS `irs` (
`id_irs` int(11) NOT NULL,
  `id_term` int(11) DEFAULT NULL,
  `npm` varchar(32) DEFAULT NULL,
  `id_kelas` int(11) DEFAULT NULL,
  `status` varchar(32) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `irs`
--

INSERT INTO `irs` (`id_irs`, `id_term`, `npm`, `id_kelas`, `status`, `flag`) VALUES
(1, 3, '123', 1, 'menungu', 1),
(2, 3, '123', 3, 'menunggu', 1),
(3, 3, '123', 5, 'disetujui', 1),
(4, 3, '125', 2, 'ditolak', 1),
(5, 3, '125', 5, 'menunggu', 1);

-- --------------------------------------------------------

--
-- Table structure for table `jadwal_kuliah`
--

CREATE TABLE IF NOT EXISTS `jadwal_kuliah` (
`id_jadwal` int(11) NOT NULL,
  `id_kelas` int(11) DEFAULT NULL,
  `ruang` varchar(32) DEFAULT NULL,
  `hari` varchar(32) DEFAULT NULL,
  `jam` time DEFAULT NULL,
  `banyak_sks` int(11) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `jadwal_kuliah`
--

INSERT INTO `jadwal_kuliah` (`id_jadwal`, `id_kelas`, `ruang`, `hari`, `jam`, `banyak_sks`, `flag`) VALUES
(1, 1, 'R 2302', 'Senin', '08:00:00', 2, 1),
(2, 1, 'R 2302', 'Rabu', '08:00:00', 2, 1),
(3, 2, 'R 2301', 'Selasa', '13:00:00', 3, 1),
(4, 3, 'R 2307', 'Senin', '15:00:00', 3, 1),
(5, 4, 'R 2306', 'Selasa', '10:00:00', 2, 1),
(6, 4, 'R 2306', 'Kamis', '10:00:00', 2, 1),
(7, 5, 'R 2300', 'Jumat', '08:00:00', 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `kehadiran_dosen`
--

CREATE TABLE IF NOT EXISTS `kehadiran_dosen` (
`id_kehadiran_dosen` int(11) NOT NULL,
  `id_jadwal` int(11) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `nik` varchar(32) DEFAULT NULL,
  `is_hadir` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `kehadiran_dosen`
--

INSERT INTO `kehadiran_dosen` (`id_kehadiran_dosen`, `id_jadwal`, `tanggal`, `nik`, `is_hadir`) VALUES
(1, 7, '2017-01-01', '1000000003', 1),
(2, 7, '2017-01-08', '1000000003', 1),
(3, 7, '2017-01-15', '1000000003', 1),
(4, 7, '2017-01-22', '1000000003', 1);

-- --------------------------------------------------------

--
-- Table structure for table `kehadiran_mahasiswa`
--

CREATE TABLE IF NOT EXISTS `kehadiran_mahasiswa` (
`id_kehadiran_mahasiswa` int(11) NOT NULL,
  `id_jadwal` int(11) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `npm` varchar(32) DEFAULT NULL,
  `is_hadir` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `kehadiran_mahasiswa`
--

INSERT INTO `kehadiran_mahasiswa` (`id_kehadiran_mahasiswa`, `id_jadwal`, `tanggal`, `npm`, `is_hadir`) VALUES
(1, 7, '2017-01-01', '123', 1),
(2, 7, '2017-01-08', '123', 1),
(3, 7, '2017-01-15', '123', 1),
(4, 7, '2017-01-22', '123', 1);

-- --------------------------------------------------------

--
-- Table structure for table `kelas`
--

CREATE TABLE IF NOT EXISTS `kelas` (
`id_kelas` int(11) NOT NULL,
  `nama_kelas` varchar(256) DEFAULT NULL,
  `id_mata_kuliah` int(11) DEFAULT NULL,
  `id_term` int(11) DEFAULT NULL,
  `dosen` varchar(32) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `kelas`
--

INSERT INTO `kelas` (`id_kelas`, `nama_kelas`, `id_mata_kuliah`, `id_term`, `dosen`, `flag`) VALUES
(1, 'DDP A', 1, 3, '1000000003', 1),
(2, 'DDP B', 1, 3, '1000000003', 1),
(3, 'OS A', 4, 3, '1000000005', 1),
(4, 'OS B', 4, 3, '1000000005', 1),
(5, 'Matdas A', 3, 3, '1000000003', 1);

-- --------------------------------------------------------

--
-- Table structure for table `kurikulum`
--

CREATE TABLE IF NOT EXISTS `kurikulum` (
`id_kurikulum` int(11) NOT NULL,
  `id_prodi` int(11) NOT NULL,
  `nama_kurikulum` varchar(256) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `kurikulum`
--

INSERT INTO `kurikulum` (`id_kurikulum`, `id_prodi`, `nama_kurikulum`) VALUES
(1, 1, 'Kurikulum 2010'),
(2, 1, 'kurikulum 2016');

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE IF NOT EXISTS `mahasiswa` (
  `npm` varchar(32) NOT NULL,
  `id_prodi` int(11) DEFAULT NULL,
  `id_kurikulum` int(11) DEFAULT NULL,
  `nama` varchar(256) DEFAULT NULL,
  `ipk` double DEFAULT NULL,
  `angkatan` int(11) DEFAULT NULL,
  `status` varchar(32) DEFAULT NULL,
  `pembimbing` varchar(32) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`npm`, `id_prodi`, `id_kurikulum`, `nama`, `ipk`, `angkatan`, `status`, `pembimbing`, `flag`) VALUES
('123', 1, 1, 'Ahmad Rowadi', 0, 2014, 'aktif', '1000000000', 1),
('124', 2, 1, 'Izhar Azhari', 0, 2014, 'aktif', '1000000000', 1),
('125', 1, 1, 'Belania Ahmadi', 0, 2015, 'aktif', '1000000001', 1);

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa_matakuliah`
--

CREATE TABLE IF NOT EXISTS `mahasiswa_matakuliah` (
`id` int(11) NOT NULL,
  `npm` varchar(32) DEFAULT NULL,
  `id_mata_kuliah` int(11) DEFAULT NULL,
  `nilai` double DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `mahasiswa_matakuliah`
--

INSERT INTO `mahasiswa_matakuliah` (`id`, `npm`, `id_mata_kuliah`, `nilai`, `status`) VALUES
(1, '123', 2, 3.5, 1),
(2, '125', 1, 3.7, 1),
(3, '124', 5, 4, 1),
(4, '125', 2, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `mata_kuliah`
--

CREATE TABLE IF NOT EXISTS `mata_kuliah` (
`id_mata_kuliah` int(11) NOT NULL,
  `id_prodi` int(11) NOT NULL,
  `nama` varchar(256) DEFAULT NULL,
  `sks` int(11) DEFAULT NULL,
  `deskripsi` varchar(256) DEFAULT NULL,
  `is_wajib` tinyint(1) DEFAULT NULL,
  `prasyarat_min_sks` int(11) DEFAULT NULL,
  `prasayarat_min_semester` int(11) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `mata_kuliah`
--

INSERT INTO `mata_kuliah` (`id_mata_kuliah`, `id_prodi`, `nama`, `sks`, `deskripsi`, `is_wajib`, `prasyarat_min_sks`, `prasayarat_min_semester`, `flag`) VALUES
(1, 1, 'DDP 1', 4, 'Dasar Dasar Pemrograman', 1, 0, 0, 1),
(2, 1, 'Fisika Dasar 1', 3, 'Fisika tingkat bawah', 1, 0, 0, 1),
(3, 1, 'Matematika Dasar 1', 3, 'Matematika dasar tingkat bawah', 1, 0, 0, 1),
(4, 1, 'OS', 4, 'Operation System', 1, 50, 0, 1),
(5, 2, 'PPSI', 3, 'Prinsip-prinsip Sistem Informasi', 1, 0, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `pembimbing_mahasiswa`
--

CREATE TABLE IF NOT EXISTS `pembimbing_mahasiswa` (
`id` int(11) NOT NULL,
  `npm_mhs` varchar(32) DEFAULT NULL,
  `nik` varchar(32) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `pembimbing_mahasiswa`
--

INSERT INTO `pembimbing_mahasiswa` (`id`, `npm_mhs`, `nik`, `update_time`) VALUES
(1, '123', '1000000001', '2016-10-31 17:00:00'),
(2, '124', '1000000000', '2016-11-30 17:00:00'),
(3, '125', '1000000001', '2016-11-30 17:00:00'),
(4, '123', '1000000000', '2016-11-30 17:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `prasyarat`
--

CREATE TABLE IF NOT EXISTS `prasyarat` (
`id` int(11) NOT NULL,
  `id_mata_kuliah` int(11) NOT NULL,
  `id_mata_kuliah_prasyarat` int(11) NOT NULL,
  `flag` tinyint(1) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `prasyarat`
--

INSERT INTO `prasyarat` (`id`, `id_mata_kuliah`, `id_mata_kuliah_prasyarat`, `flag`) VALUES
(1, 4, 1, 1),
(2, 4, 2, 1),
(3, 4, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `prodi`
--

CREATE TABLE IF NOT EXISTS `prodi` (
`id_prodi` int(11) NOT NULL,
  `id_fakultas` int(11) NOT NULL,
  `nama_prodi` varchar(256) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `prodi`
--

INSERT INTO `prodi` (`id_prodi`, `id_fakultas`, `nama_prodi`, `flag`) VALUES
(1, 1, 'Ilmu Komputer', 1),
(2, 1, 'Sistem Informasi', 1),
(3, 2, 'Bahasa Jepang', 1),
(4, 2, 'Bahasa Indonesia', 1);

-- --------------------------------------------------------

--
-- Table structure for table `staf`
--

CREATE TABLE IF NOT EXISTS `staf` (
  `nik` varchar(32) NOT NULL,
  `id_prodi` int(11) NOT NULL,
  `nama` varchar(256) DEFAULT NULL,
  `role` varchar(32) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `staf`
--

INSERT INTO `staf` (`nik`, `id_prodi`, `nama`, `role`, `flag`) VALUES
('1000000000', 1, 'Muhammad Luqman', 'Dekan', 1),
('1000000001', 1, 'Fahri Ahmadi', 'Wakil Dekan', 1),
('1000000002', 1, 'Muhammad Lutfi', 'Wakil Dekan', 1),
('1000000003', 1, 'Anto', 'Dosen', 1),
('1000000004', 1, 'Ani', 'Staf Pendukung ', 1),
('1000000005', 1, 'Yanto', 'Dosen', 1);

-- --------------------------------------------------------

--
-- Table structure for table `term`
--

CREATE TABLE IF NOT EXISTS `term` (
`id_term` int(11) NOT NULL,
  `tahun` varchar(32) DEFAULT NULL,
  `semester` int(11) DEFAULT NULL,
  `tanggal_mulai` date DEFAULT NULL,
  `tanggal_selesai` date DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `term`
--

INSERT INTO `term` (`id_term`, `tahun`, `semester`, `tanggal_mulai`, `tanggal_selesai`, `flag`) VALUES
(1, '2015/2016', 2, '2016-01-01', '2016-05-30', 1),
(2, '2016/2017', 1, '2016-06-01', '2016-12-30', 1),
(3, '2016/2017', 2, '2017-01-01', '2017-05-30', 1);

-- --------------------------------------------------------

--
-- Table structure for table `univ`
--

CREATE TABLE IF NOT EXISTS `univ` (
`id_univ` int(11) NOT NULL,
  `nama_univ` varchar(256) DEFAULT NULL,
  `url` varchar(256) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `univ`
--

INSERT INTO `univ` (`id_univ`, `nama_univ`, `url`, `flag`) VALUES
(1, 'Universitas Indonesia', 'ui.ac.id', 1),
(2, 'Universitas Diponegoro', 'undip.ac.id', 1),
(3, 'Universitas Sebelas Maret', 'uns.ac.id', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
`id_user` int(11) NOT NULL,
  `id_prodi` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(256) NOT NULL,
  `role` varchar(32) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `id_prodi`, `username`, `password`, `role`, `flag`) VALUES
(1, 1, 'admin', 'admin', 'ROLE_SIAK', 1),
(2, 2, 'user1', 'user', 'ROLE_SIAK', 1),
(3, 1, 'adminhr', 'admin', 'ROLE_HR', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `fakultas`
--
ALTER TABLE `fakultas`
 ADD PRIMARY KEY (`id_fakultas`);

--
-- Indexes for table `gaji`
--
ALTER TABLE `gaji`
 ADD PRIMARY KEY (`id_gaji`);

--
-- Indexes for table `irs`
--
ALTER TABLE `irs`
 ADD PRIMARY KEY (`id_irs`);

--
-- Indexes for table `jadwal_kuliah`
--
ALTER TABLE `jadwal_kuliah`
 ADD PRIMARY KEY (`id_jadwal`);

--
-- Indexes for table `kehadiran_dosen`
--
ALTER TABLE `kehadiran_dosen`
 ADD PRIMARY KEY (`id_kehadiran_dosen`);

--
-- Indexes for table `kehadiran_mahasiswa`
--
ALTER TABLE `kehadiran_mahasiswa`
 ADD PRIMARY KEY (`id_kehadiran_mahasiswa`);

--
-- Indexes for table `kelas`
--
ALTER TABLE `kelas`
 ADD PRIMARY KEY (`id_kelas`);

--
-- Indexes for table `kurikulum`
--
ALTER TABLE `kurikulum`
 ADD PRIMARY KEY (`id_kurikulum`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
 ADD PRIMARY KEY (`npm`);

--
-- Indexes for table `mahasiswa_matakuliah`
--
ALTER TABLE `mahasiswa_matakuliah`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mata_kuliah`
--
ALTER TABLE `mata_kuliah`
 ADD PRIMARY KEY (`id_mata_kuliah`);

--
-- Indexes for table `pembimbing_mahasiswa`
--
ALTER TABLE `pembimbing_mahasiswa`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `prasyarat`
--
ALTER TABLE `prasyarat`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `prodi`
--
ALTER TABLE `prodi`
 ADD PRIMARY KEY (`id_prodi`);

--
-- Indexes for table `staf`
--
ALTER TABLE `staf`
 ADD PRIMARY KEY (`nik`);

--
-- Indexes for table `term`
--
ALTER TABLE `term`
 ADD PRIMARY KEY (`id_term`);

--
-- Indexes for table `univ`
--
ALTER TABLE `univ`
 ADD PRIMARY KEY (`id_univ`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`id_user`), ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fakultas`
--
ALTER TABLE `fakultas`
MODIFY `id_fakultas` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `gaji`
--
ALTER TABLE `gaji`
MODIFY `id_gaji` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `irs`
--
ALTER TABLE `irs`
MODIFY `id_irs` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `jadwal_kuliah`
--
ALTER TABLE `jadwal_kuliah`
MODIFY `id_jadwal` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `kehadiran_dosen`
--
ALTER TABLE `kehadiran_dosen`
MODIFY `id_kehadiran_dosen` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `kehadiran_mahasiswa`
--
ALTER TABLE `kehadiran_mahasiswa`
MODIFY `id_kehadiran_mahasiswa` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `kelas`
--
ALTER TABLE `kelas`
MODIFY `id_kelas` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `kurikulum`
--
ALTER TABLE `kurikulum`
MODIFY `id_kurikulum` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `mahasiswa_matakuliah`
--
ALTER TABLE `mahasiswa_matakuliah`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `mata_kuliah`
--
ALTER TABLE `mata_kuliah`
MODIFY `id_mata_kuliah` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `pembimbing_mahasiswa`
--
ALTER TABLE `pembimbing_mahasiswa`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `prasyarat`
--
ALTER TABLE `prasyarat`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `prodi`
--
ALTER TABLE `prodi`
MODIFY `id_prodi` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `term`
--
ALTER TABLE `term`
MODIFY `id_term` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `univ`
--
ALTER TABLE `univ`
MODIFY `id_univ` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
