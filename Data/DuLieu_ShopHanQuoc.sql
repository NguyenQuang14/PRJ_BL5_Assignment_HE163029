
use DuLieu_ShopHanQuoc
go
--Bảng Danh Mục
create table DanhMucSanPham(
	MaDanhMuc int Identity primary key,
	TenDanhMuc nvarchar(100))
--Bảng Sản Phẩm
create table SanPham(
	MaSanPham int Identity primary key,
	MaDanhMuc int foreign key references DanhMucSanPham(MaDanhMuc),
	TenSanPham nvarchar(100),
	GiaBan float,
	MotaSanPham Ntext )
--Bảng Liên Hệ
create table LienHe(
	MaLienHe int identity primary key,
	HoTen nvarchar(500),
	Email varchar(100),
	NoiDung ntext)
--Bang User
create table Users(
	Account varchar(100) not null primary key,
	Password nvarchar(100) not null,
	Hoten nvarchar(50),
	SoDT varchar(20),
	DiaChi nvarchar(200))
--Bang Don Hang
create table DonHang(
	MaDonHang int identity primary key,
	NgayDatHang datetime,
	Hoten nvarchar(50),
	DiaChi nvarchar(200),
	Email nvarchar(100),
	SoDT varchar(20),
	SoLoaiSanPham int,
	TongTien float)
--Bang Don Hang Chi Tiet
create table DonHangChiTiet(
	MaDHCT int identity primary key,
	MaDonHang int foreign key references DonHang(MaDonHang),
	MaSanPham int foreign key references SanPham(MaSanPham),
	GiaBan float,
	SoLuongSP int,
	SoTien float)