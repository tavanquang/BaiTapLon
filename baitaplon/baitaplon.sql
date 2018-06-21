-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 07, 2018 lúc 06:57 AM
-- Phiên bản máy phục vụ: 10.1.26-MariaDB
-- Phiên bản PHP: 7.0.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `baitaplon`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_admin`
--

CREATE TABLE `tbl_admin` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `roles` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `tbl_admin`
--

INSERT INTO `tbl_admin` (`username`, `password`, `roles`) VALUES
('admin', '123', 'ROLE_ADMIN'),
('quang', '123', 'ROLE_USER');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_noi_dung_de_xuat`
--

CREATE TABLE `tbl_noi_dung_de_xuat` (
  `id` int(11) NOT NULL,
  `noi_dung_de_xuat` text,
  `so_ngay` int(11) DEFAULT NULL,
  `so_luong` int(11) DEFAULT NULL,
  `don_gia` double DEFAULT NULL,
  `thanh_tien` double DEFAULT NULL,
  `ghi_chu` varchar(255) DEFAULT NULL,
  `id_phieu_de_xuat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_phieu_chi`
--

CREATE TABLE `tbl_phieu_chi` (
  `id` int(11) NOT NULL,
  `nguoi_nhan_tien` varchar(100) NOT NULL,
  `dia_chi` varchar(250) DEFAULT NULL,
  `ly_do_chi` text,
  `so_tien` double DEFAULT NULL,
  `hinh_anh` varchar(250) DEFAULT NULL,
  `ngay_lap_phieu` date DEFAULT NULL,
  `giam_doc` varchar(100) DEFAULT NULL,
  `nguoi_lap_phieu` varchar(100) DEFAULT NULL,
  `trang_thai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `tbl_phieu_chi`
--

INSERT INTO `tbl_phieu_chi` (`id`, `nguoi_nhan_tien`, `dia_chi`, `ly_do_chi`, `so_tien`, `hinh_anh`, `ngay_lap_phieu`, `giam_doc`, `nguoi_lap_phieu`, `trang_thai`) VALUES
(1, 'Tạ Văn Quang', 'Công ty TNHH NCCSOFT', 'Thanh toán 10 cái màn hình máy tính', 80000000,'1', '2018-06-06', 'Mai Thế Hùng', 'Nguyễn Phương Anh', 0),
(2, 'Lê Thị Lương', 'Công ty TNHH NCCSOFT', 'Thanh toán 2 cái bàn phím', 600000, '2', '2018-06-06', 'Mai Thế Hùng', 'Nguyễn Phương Anh', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_phieu_de_xuat`
--

CREATE TABLE `tbl_phieu_de_xuat` (
  `id` int(11) NOT NULL,
  `kinh_gui` varchar(255) DEFAULT NULL,
  `nguoi_de_nghi` varchar(100) DEFAULT NULL,
  `ngay_bat_dau` date DEFAULT NULL,
  `ngay_hoan_thanh` date DEFAULT NULL,
  `noi_dung_de_xuat` varchar(255) DEFAULT NULL,
  `y_kien_lanh_dao` text,
  `ngay_de_xuat` date DEFAULT NULL,
  `nguoi_ke_toan` varchar(45) DEFAULT NULL,
  `giam_doc` varchar(45) DEFAULT NULL,
  `de_xuat_ngay_mua` date DEFAULT NULL,
  `tong_tien` double DEFAULT NULL,
  `trang_thai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tbl_admin`
--
ALTER TABLE `tbl_admin`
  ADD PRIMARY KEY (`username`);

--
-- Chỉ mục cho bảng `tbl_noi_dung_de_xuat`
--
ALTER TABLE `tbl_noi_dung_de_xuat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_phieu_de_xuat1_idx` (`id_phieu_de_xuat`);

--
-- Chỉ mục cho bảng `tbl_phieu_chi`
--
ALTER TABLE `tbl_phieu_chi`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tbl_phieu_de_xuat`
--
ALTER TABLE `tbl_phieu_de_xuat`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `tbl_noi_dung_de_xuat`
--
ALTER TABLE `tbl_noi_dung_de_xuat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `tbl_phieu_chi`
--
ALTER TABLE `tbl_phieu_chi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `tbl_noi_dung_de_xuat`
--
ALTER TABLE `tbl_noi_dung_de_xuat`
  ADD CONSTRAINT `fk_phieu_de_xuat1` FOREIGN KEY (`id_phieu_de_xuat`) REFERENCES `tbl_phieu_de_xuat` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
