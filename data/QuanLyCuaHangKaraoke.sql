use master
go
DROP DATABASE IF EXISTS QuanLyCuaHangKaraoke4T;

go

create database QuanLyCuaHangKaraoke4T
go

use QuanLyCuaHangKaraoke4T
go

CREATE TABLE NhanVien
(
	maNhanVien varchar(20) not null primary key,
	hoTen nvarchar(100) not null,
	soDienThoai varchar(20) not null,
	gioiTinh bit not null,
	ngaySinh date not null,
	chucVu nvarchar(50) not null,
	anhDaiDien varchar(50) not null
)
go


CREATE TABLE TaiKhoan
(
	maTaiKhoan VARCHAR(20) NOT NULL UNIQUE,
	matkhau VARCHAR(255) NOT NULL,
	trangThai BIT NOT NULL,
	roleName NVARCHAR(100) NOT NULL,
	PRIMARY KEY (maTaiKhoan),
	FOREIGN KEY (maTaiKhoan) REFERENCES NhanVien(maNhanVien)
)


CREATE TABLE LoaiPhong
(
	maLoaiPhong varchar(20) not null primary key,
	tenLoaiPhong nvarchar(100),
	sucChua int not null,
	donGiaTheoGio money not null
)
go

CREATE TABLE Phong
(
	maPhong varchar(20) not null primary key,
	maLoaiPhong varchar(20) not null foreign key references LoaiPhong(maLoaiPhong) on delete cascade,
	trangThai nvarchar(50) not null
)
go

CREATE TABLE SanPham
(
	maSanPham varchar(20) not null primary key,
	tenSanPham nvarchar(100) not null,
	ngaySanXuat date not null,
	loaiSanPham nvarchar(100),
	donGiaNhap money not null,
	donViTinh varchar(20) not null,
	soLuongTon int not null,
	hinhAnh nvarchar(200) not null
)
go

CREATE TABLE KhuyenMai
(
	maKhuyenMai varchar(20) not null primary key,
	tenKhuyenMai nvarchar(50),
	ngayBatDau Date not null,
	ngayKetThuc Date not null,
	phanTramKhuyenMai float not null
)
go

CREATE TABLE KhachHang
(
	maKhachHang varchar(20) not null primary key,
	hoTen nvarchar(100) not null,
	soDienThoai varchar(20) not null,
	gioiTinh bit not null
)
go

CREATE TABLE PhieuDatPhong (
    maPhieu varchar(20) not null primary key,
	maPhong varchar(20) not null foreign key references Phong(maPhong) on delete cascade,
	maNhanVien varchar(20) not null foreign key references NhanVien(maNhanVien) on delete cascade,
	maKhachHang varchar(20) not null foreign key references KhachHang(maKhachHang) on delete cascade,
    ngayGioDatPhong datetime not null,
    ngayGioNhanPhong datetime not null,
    soNguoiHat int not null,
    CONSTRAINT CHK_SoNguoiHat CHECK (soNguoiHat > 0)
)
go

CREATE TABLE HoaDonDatPhong(
    maHoaDon varchar(20) not null primary key,
	maKhachHang varchar(20) not null foreign key references KhachHang(maKhachHang) on delete cascade,
	maNhanVien varchar(20) not null foreign key references NhanVien(maNhanVien) on delete cascade,
    ngayLapHoaDon date not null,
    trangThai bit not null,
	maKhuyenMai varchar(20) foreign key references KhuyenMai(maKhuyenMai) on delete cascade,
    tienKhachDua money,
	--CONSTRAINT CHK_ngayLapHoaDon CHECK (ngayLapHoaDon >= GETDATE()),
	CONSTRAINT CHK_tienKhachDua CHECK (tienKhachDua >= 0)
)
go


CREATE TABLE ChiTietHoaDon (
    maHoaDon varchar(20) not null,
    maPhong varchar(20) not null,
	primary key(maHoaDon,maPhong),
	gioNhanPhong datetime not null,
    gioTraPhong datetime null,
    soGioHat float,
	foreign key(maHoaDon) references HoaDonDatPhong(maHoaDon) on delete cascade,
	foreign key(maPhong) references Phong(maPhong) on delete cascade,
	CONSTRAINT CHK_soGioHat CHECK (soGioHat >= 0)
)
go

CREATE TABLE ChiTietDichVu (
    maHoaDon varchar(20) not null,
    maSanPham varchar(20) not null,
	primary key(maHoaDon,maSanPham),
    soLuong int not null,
    giaBan float not null,
	foreign key(maHoaDon) references HoaDonDatPhong(maHoaDon) on delete cascade,
	foreign key(maSanPham) references SanPham(maSanPham) on delete cascade,
    CONSTRAINT CHK_SoLuong CHECK (soLuong > 0),
    CONSTRAINT CHK_Gia CHECK (giaBan > 0)
)

go

CREATE TABLE TempDatPhong (
    maPhong varchar(20) not null,
	soNguoi int not null
)
go


--Nhân viên
insert into NhanVien values('2001001',N'Trần Văn Sơn', '0933900911', 1, '1995-2-5 08:00:00.000', N'Nhân viên quản lý', 'D:\BaiTapLonPTUD_NHOM4\image\son2001001.jpg')
insert into NhanVien values('2110001',N'Lê Hương Trà', '0822911911', 0, '2001-7-7 09:00:00.000', N'Nhân viên phục vụ', 'D:\BaiTapLonPTUD_NHOM4\image\Tra2110002.jpg')
insert into NhanVien values('2211001',N'Vũ Văn Hà', '0826812977', 1, '2000-7-30 14:00:00.000', N'Nhân viên phục vụ', 'D:\BaiTapLonPTUD_NHOM4\image\Ha2211003.jpg')
insert into NhanVien values('2211002',N'Nguyễn Thái Sỹ', '0344211955', 1, '1999-5-22 09:00:00.000', N'Nhân viên phục vụ', 'D:\BaiTapLonPTUD_NHOM4\image\Sy2211002.jpg')
insert into NhanVien values('2311001',N'Lê Tuyết Nhi', '0663765198', 0, '2002-7-9 12:00:00.000', N'Nhân viên phục vụ', 'D:\BaiTapLonPTUD_NHOM4\image\Nhi2311001.jpg')
insert into NhanVien values('2200003',N'Nguyễn Thị Hạnh', '0911645222', 0, '1998-11-30 14:00:00.000', N'Nhân viên quản lý', 'D:\BaiTapLonPTUD_NHOM4\image\Hanh2200003.jpg')
insert into NhanVien values('2211004',N'Phạm Văn Đạt', '0877124518', 1, '1999-3-2 10:00:00.000', N'Nhân viên phục vụ', 'D:\BaiTapLonPTUD_NHOM4\image\Dat2201004.jpg')
insert into NhanVien values('2111002',N'Phan Văn Đức', '0455050198', 1, '2001-9-5 09:00:00.000', N'Nhân viên phục vụ', 'D:\BaiTapLonPTUD_NHOM4\image\Duc2111002.jpg')
insert into NhanVien values('2010002',N'Vũ Thị Minh', '0119456771', 0, '2000-2-8 12:00:00.000', N'Nhân viên phục vụ', 'D:\BaiTapLonPTUD_NHOM4\image\Minh2010002.jpg')
insert into NhanVien values('2110003',N'Nguyễn Quỳnh Như', '0455912090', 0, '1998-12-3 07:00:00.000', N'Nhân viên phục vụ', 'D:\BaiTapLonPTUD_NHOM4\image\Nhu2110003.jpg')
insert into NhanVien values('2301002',N'Nguyễn Văn Bá Nhân', '0821643221', 1, '2000-9-10 18:00:00.000', N'Nhân viên quản lý', 'D:\BaiTapLonPTUD_NHOM4\image\Nhan2301002.jpg')
insert into NhanVien values('2210005',N'Nguyễn Thị Minh Ngọc', '0775298641', 0, '2001-8-22 17:00:00.000', N'Nhân viên phục vụ', 'D:\BaiTapLonPTUD_NHOM4\image\Ngoc2210005.jpg')
insert into NhanVien values('2311003',N'Lê Văn Thành', '0988328785', 1, '1999-9-25 08:00:00.000', N'Nhân viên phục vụ', 'D:\BaiTapLonPTUD_NHOM4\image\Thanh2311003.jpg')
insert into NhanVien values('2210006',N'Nguyễn Thị Như Hoa', '0821734226', 0, '2000-8-17 11:00:00.000', N'Nhân viên phục vụ', 'D:\BaiTapLonPTUD_NHOM4\image\Hoa2210006.jpg')
insert into NhanVien values('2110004',N'Lê Thị Đào', '0967432230', 0, '1994-1-20 09:00:00.000', N'Nhân viên phục vụ', 'D:\BaiTapLonPTUD_NHOM4\image\Dao2110004.jpg')
go

--Tài khoản
insert into TaiKhoan values('2001001', 'Son2001001', 1, N'Quản lý')
insert into TaiKhoan values('2110001', 'Tra2110002', 0, N'Nhân viên')
insert into TaiKhoan values('2211001', 'Ha2211003', 0, N'Nhân viên')
insert into TaiKhoan values('2211002', 'Sy2211002', 1, N'Nhân viên')
insert into TaiKhoan values('2311001', 'Nhi2311001', 0, N'Nhân viên')
insert into TaiKhoan values('2200003', 'Hanh2200003', 0, N'Quản lý')
insert into TaiKhoan values('2211004', 'Dat2201004', 1, N'Nhân viên')
insert into TaiKhoan values('2111002', 'Duc2111002', 0, N'Nhân viên')
insert into TaiKhoan values('2010002', 'Minh2010002', 0, N'Nhân viên')
insert into TaiKhoan values('2110003', 'Nhu2110003', 1, N'Nhân viên')
insert into TaiKhoan values('2301002', 'Nhan2301002', 0, N'Quản lý')
insert into TaiKhoan values('2210005', 'Ngoc2210005', 0, N'Nhân viên')
insert into TaiKhoan values('2311003', 'Thanh2311003', 0, N'Nhân viên')
insert into TaiKhoan values('2210006', 'Hoa2210006', 0, N'Nhân viên')
insert into TaiKhoan values('2110004', 'Dao2110004', 0, N'Nhân viên')
go

--Loại phòng
insert into LoaiPhong values('PT5', N'Phòng thường', 5, 70000)
insert into LoaiPhong values('PT10', N'Phòng thường', 10, 140000)
insert into LoaiPhong values('PT15', N'Phòng thường', 15, 210000)
insert into LoaiPhong values('PT20', N'Phòng thường', 20, 280000)
insert into LoaiPhong values('PV5', N'Phòng VIP', 5, 150000)
insert into LoaiPhong values('PV10', N'Phòng VIP', 10, 300000)
insert into LoaiPhong values('PV20', N'Phòng VIP', 20, 600000)
insert into LoaiPhong values('PV30', N'Phòng VIP', 30, 850000)
go

--Phòng
insert into Phong values('101','PT5',N'Đang_sử_dụng')
insert into Phong values('102','PT20',N'Đang_sử_dụng')
insert into Phong values('103','PT15',N'Đang_sửa_chữa')
insert into Phong values('104','PT10',N'Trống')
insert into Phong values('105','PV5',N'Đang_sử_dụng')
insert into Phong values('201','PT15',N'Chờ')
insert into Phong values('202','PV20',N'Trống')
insert into Phong values('203','PT10',N'Đang_sử_dụng')
insert into Phong values('204','PV10',N'Trống')
insert into Phong values('205','PT5',N'Trống')
insert into Phong values('206','PT5',N'Chờ')
insert into Phong values('301','PT15',N'Chờ')
insert into Phong values('302','PT20',N'Trống')
insert into Phong values('303','PT15',N'Đang_sửa_chữa')
insert into Phong values('304','PT10',N'Trống')
insert into Phong values('305','PV10',N'Đang_sử_dụng')
insert into Phong values('306','PV20',N'Trống')
insert into Phong values('401','PV30',N'Đang_sử_dụng')
insert into Phong values('402','PV30',N'Trống')
insert into Phong values('403','PV10',N'Đang_sử_dụng')
insert into Phong values('404','PV5',N'Trống')
go

--Sản phẩm
insert into SanPham values('SP001', N'Bia Tiger nâu', '2023-9-20 07:00:00.000', N'Bia', 10000, N'Lon', 18000, 'D:\BaiTapLonPTUD_NHOM4\image\BiaTigerNau001.jpg')
insert into SanPham values('SP002', N'Bia Tiger bạc', '2023-10-2 08:00:00.000', N'Bia', 17000, N'Lon', 10000, 'D:\BaiTapLonPTUD_NHOM4\image\BiaTigerBac002.jpg')
insert into SanPham values('SP003', N'Nước ngọt pepsi', '2023-9-22 15:00:00.000', N'Nước ngọt', 10500, N'Lon', 23000, 'D:\BaiTapLonPTUD_NHOM4\image\NuocNgotPepsi003.jpg')
insert into SanPham values('SP004', N'Nước ngọt Coca cola', '2023-8-17 10:00:00.000', N'Nước ngọt', 11000, N'Lon', 12000, 'D:\BaiTapLonPTUD_NHOM4\image\NuocNgotCoca004.jpg')
insert into SanPham values('SP005', N'Bia 333 Sài Gòn', '2023-9-28 09:00:00.000', N'Bia', 12000, N'Lon', 9000, 'D:\BaiTapLonPTUD_NHOM4\image\Bia333005.jpg')
insert into SanPham values('SP006', N'Nước ngọt 7 up', '2023-9-10 10:00:00.000', N'Nước ngọt', 10000, N'Lon', 15000, 'D:\BaiTapLonPTUD_NHOM4\image\NuocNgot7Up006.jpg')
insert into SanPham values('SP007', N'Trà Ô Long', '2023-9-29 07:00:00.000', N'Nước ngọt', 12000, N'Chai', 6000, 'D:\BaiTapLonPTUD_NHOM4\image\TraOlong007.jpg')
insert into SanPham values('SP008', N'Khô mực xé', '2023-10-11 07:00:00.000', N'Thức ăn', 90000, N'phần', 5000, 'D:\BaiTapLonPTUD_NHOM4\image\KhoMucXe008.jpg')
insert into SanPham values('SP009', N'Xúc xích nướng tiêu', '2023-10-11 18:00:00.000', N'Thức ăn', 40000, N'Phần', 2000, 'D:\BaiTapLonPTUD_NHOM4\image\XucXichNuongTieu009.jpg')
insert into SanPham values('SP010', N'Khoai tây chiên', '2023-10-10 20:00:00.000', N'Thức ăn', 35000, N'Phần', 600, 'D:\BaiTapLonPTUD_NHOM4\image\KhoaiTayChien010.jpg')
insert into SanPham values('SP011', N'Chả giò Bum', '2023-10-12 17:00:00.000', N'Thức ăn', 90000, N'Phần', 700, 'D:\BaiTapLonPTUD_NHOM4\image\ChaGioBum011.jpg')
insert into SanPham values('SP012', N'Bò lúc lắc khoai tây', '2023-10-10 15:00:00.000', N'Thức ăn', 170000, N'Phần', 200, 'D:\BaiTapLonPTUD_NHOM4\image\BoLucLac012.jpg')
insert into SanPham values('SP013', N'Tôm nướng muối ớt', '2023-10-20 13:00:00.000', N'Thức ăn', 210000, N'Phần', 800, 'D:\BaiTapLonPTUD_NHOM4\image\TomNuong013.jpg')
insert into SanPham values('SP014', N'Cá lòng tong chiên giòn', '2023-10-14 07:00:00.000', N'Thức ăn', 80000, N'Phần', 400, 'D:\BaiTapLonPTUD_NHOM4\image\CaLongTongChien014.jpg')
insert into SanPham values('SP015', N'Ba rọi xông khói cuộn tôm', '2023-10-15 08:00:00.000', N'Thức ăn', 150000, N'Phần', 250, 'D:\BaiTapLonPTUD_NHOM4\image\BaRoiXongKhoiCuonTom015.jpg')
insert into SanPham values('SP016', N'Cánh gà chiên nước mắm', '2023-10-13 09:00:00.000', N'Thức ăn', 120000, N'Phần', 1000, 'D:\BaiTapLonPTUD_NHOM4\image\CanhGaChienNuocMam016.jpg')
insert into SanPham values('SP017', N'Lẩu thái chua cay', '2023-10-14 10:00:00.000', N'Thức ăn', 200000, N'Phần', 180, 'D:\BaiTapLonPTUD_NHOM4\image\LauThaiChuaCay017.jpg')
insert into SanPham values('SP018', N'Lẩu lươn chua cay', '2023-10-15 12:00:00.000', N'Thức ăn', 190000, N'Phần', 200, 'D:\BaiTapLonPTUD_NHOM4\image\LauLuonChuaCay018.jpg')
insert into SanPham values('SP019', N'Lẩu dê', '2023-10-15 06:00:00.000', N'Thức ăn', 240000, N'Phần', 100, 'D:\BaiTapLonPTUD_NHOM4\image\LauDe019.jpg')
insert into SanPham values('SP020', N'Ốc tỏi nướng mỡ hành', '2023-10-10 09:00:00.000', N'Thức ăn', 130000, N'Phần', 150, 'D:\BaiTapLonPTUD_NHOM4\image\OcToi020.jpg')
insert into SanPham values('SP021', N'Trái cây tráng miệng', '2023-10-10 07:00:00.000', N'Thức ăn', 10000, N'Phần', 2000, 'D:\BaiTapLonPTUD_NHOM4\image\TraiCayTrangMieng021.jpg')
insert into SanPham values('SP022', N'Chanh muối', '2023-10-10 17:00:00.000', N'Đồ uống', 60000, N'Ly', 100, 'D:\BaiTapLonPTUD_NHOM4\image\ChanhMuoi022.jpg')
insert into SanPham values('SP023', N'Sữa tươi', '2023-10-11 07:00:00.000', N'Đồ uống', 40000, N'Ly', 100, 'D:\BaiTapLonPTUD_NHOM4\image\SuaTuoi023.jpg')
insert into SanPham values('SP024', N'Cà phê sữa', '2023-10-12 20:00:00.000', N'Đồ uống', 30000, N'Ly', 150, 'D:\BaiTapLonPTUD_NHOM4\image\CaPheSua024.jpg')
insert into SanPham values('SP025', N'Soda chanh', '2023-10-20 18:00:00.000', N'Đồ uống', 45000, N'Ly', 200, 'D:\BaiTapLonPTUD_NHOM4\image\SodaChanh025.jpg')
insert into SanPham values('SP026', N'Trà gừng đá/nóng', '2023-10-14 18:00:00.000', N'Đồ uống', 90000, N'Ly', 80, 'D:\BaiTapLonPTUD_NHOM4\image\TraGungDaNong026.jpg')
go


--Khuyến mãi
insert into KhuyenMai values('KM201023', N'Khuyến mãi ngày lễ 20/10', '2023-10-20 00:00:00.000', '2023-10-21 00:00:00.000', 0.02)
insert into KhuyenMai values('KM300423', N'Khuyến mãi ngày lễ 30/4, 1/5', '2023-4-29 00:00:00.000', '2023-5-2 00:00:00.000', 0.05)
insert into KhuyenMai values('KM201022', N'Khuyến mãi ngày lễ 20/10', '2022-10-20 00:00:00.000', '2022-10-21 00:00:00.000', 0.02)
insert into KhuyenMai values('KM020922', N'Khuyến mãi ngày lễ Quốc Khánh', '2022-9-1 00:00:00.000', '2022-9-3 00:00:00.000', 0.03)
insert into KhuyenMai values('KM020923', N'Khuyến mãi ngày lễ Quốc Khánh', '2023-9-1 00:00:00.000', '2023-9-3 00:00:00.000', 0.03)
insert into KhuyenMai values('KM300422', N'Khuyến mãi ngày lễ 30/4, 1/5', '2022-4-29 00:00:00.000', '2022-5-2 00:00:00.000', 0.05)
insert into KhuyenMai values('KM010121', N'Khuyến mãi ngày tết Dương Lịch', '2021-1-1 00:00:00.000', '2021-1-2 00:00:00.000', 0.04)
insert into KhuyenMai values('KM010122', N'Khuyến mãi ngày tết Dương Lịch', '2022-1-1 00:00:00.000', '2022-1-2 00:00:00.000', 0.04)
insert into KhuyenMai values('KM010123', N'Khuyến mãi ngày tết Dương Lịch', '2023-1-1 00:00:00.000', '2023-1-2 00:00:00.000', 0.04)
insert into KhuyenMai values('KM200820', N'Khuyến mãi ngày khai trương', '2023-8-20 00:00:00.000', '2023-8-21 00:00:00.000', 0.1)
go


--Khách hàng
insert into KhachHang values ('KH00000000', N'Nguyễn Văn A', '0000000000', 1)
insert into KhachHang values('KH231010001', N'Lương Văn Hòa', '0788343289', 1)
insert into KhachHang values('KH231010002', N'Trần Thị Lan', '0654212611', 0)
insert into KhachHang values('KH231010003', N'Nguyễn Chí Nam', '0433212922', 1)
insert into KhachHang values('KH231011001', N'Dương Văn Tiến', '0446712349', 1)
insert into KhachHang values('KH231011002', N'Nguyễn Tăng Nhật Minh', '0444289744', 1)
insert into KhachHang values('KH231012001', N'Trần Thị Thu Thủy', '0677344261', 0)
insert into KhachHang values('KH231013001', N'Nguyễn Ngọc Tân', '0212999568', 1)
insert into KhachHang values('KH231014001', N'Trần Thị Lan Chi', '0688519418', 0)
insert into KhachHang values('KH231020001', N'Lê Văn Việt', '0788222194', 1)
insert into KhachHang values('KH231015001', N'Phạm Gia Khải', '0654323943', 1)
go

--PhieuDatPhong
insert into PhieuDatPhong values('PDP2310100001', '305', '2211001', 'KH231010001', '2023-10-10 11:00:00.000', '2023-10-10 11:00:00.000', 9)
insert into PhieuDatPhong values('PDP2310100002', '306', '2211001', 'KH231010001', '2023-10-10 11:00:00.000', '2023-10-10 11:00:00.000', 17)
insert into PhieuDatPhong values('PDP2310100003', '204', '2211001', 'KH231010002', '2023-10-10 15:00:00.000', '2023-10-10 15:00:00.000', 8)
insert into PhieuDatPhong values('PDP2310100004', '102', '2211001', 'KH231010003', '2023-10-10 13:00:00.000', '2023-10-10 18:00:00.000', 14)
insert into PhieuDatPhong values('PDP2310100005', '101', '2211001', 'KH231010003', '2023-10-10 13:00:00.000', '2023-10-10 18:30:00.000', 4)

insert into PhieuDatPhong values('PDP2310110001', '401', '2111002', 'KH231011001', '2023-10-11 8:00:00.000', '2023-10-11 8:00:00.000', 24)
insert into PhieuDatPhong values('PDP2310110002', '203', '2111002', 'KH231011002', '2023-10-11 20:00:00.000', '2023-10-11 20:00:00.000', 7)

insert into PhieuDatPhong values('PDP2310120001', '404', '2301002', 'KH231012001', '2023-10-12 20:00:00.000', '2023-10-12 20:00:00.000', 5)
insert into PhieuDatPhong values('PDP2310130001', '306', '2010002', 'KH231013001', '2023-10-13 15:00:00.000', '2023-10-13 15:00:00.000', 18)
insert into PhieuDatPhong values('PDP2310140001', '105', '2001001', 'KH231014001', '2023-10-14 12:00:00.000', '2023-10-14 12:00:00.000', 5)
insert into PhieuDatPhong values('PDP2310200001', '206', '2110004', 'KH231020001', '2023-10-20 07:00:00.000', '2023-10-20 21:00:00.000', 4)
insert into PhieuDatPhong values('PDP2310150001', '403', '2311001', 'KH231015001', '2023-10-15 21:00:00.000', '2023-10-15 21:00:00.000', 10)
insert into PhieuDatPhong values('PDP2209010001', '403', '2001001', 'KH231015001', '2024-09-01 19:00:00.000', '2024-09-01 19:00:00.000', 25)
insert into PhieuDatPhong values('PDP2208010001', '404', '2110004', 'KH231014001', '2024-08-01 18:00:00.000', '2024-08-01 18:00:00.000', 3)
insert into PhieuDatPhong values('PDP2207150001', '306', '2311001', 'KH231014001', '2024-07-15 17:00:00.000', '2024-07-15 17:00:00.000', 17)
go


--HoaDonDatPhong
insert into HoaDonDatPhong values('HD2310100001', 'KH231010001', '2211001', '2023-10-10 14:00:00.000', 1, null, 4500000)
insert into HoaDonDatPhong values('HD2310100002', 'KH231010002', '2211001', '2023-10-10 19:00:00.000', 1, null, 1200000)
insert into HoaDonDatPhong values('HD2310100003', 'KH231010003', '2211001', '2023-10-10 21:00:00.000', 1, null, 3000000)

insert into HoaDonDatPhong values('HD2310110001', 'KH231011001', '2111002', '2023-10-11 8:00:00.000', 1, null, 2000000)
insert into HoaDonDatPhong values('HD2310110002', 'KH231011002', '2111002', '2023-10-12 00:00:00.000', 1, null, 4000000)

insert into HoaDonDatPhong values('HD2310120001', 'KH231012001', '2301002', '2023-10-13 00:00:00.000', 1, null, 2000000)
insert into HoaDonDatPhong values('HD2310130001', 'KH231013001', '2010002', '2023-10-13 20:00:00.000', 1, null, 1500000)
insert into HoaDonDatPhong values('HD2310140001', 'KH231014001', '2001001', '2023-10-14 15:00:00.000', 1, null, 2000000)
insert into HoaDonDatPhong values('HD2310200001', 'KH231020001', '2110004', '2023-10-21 00:00:00.000', 0, 'KM201023', 0)
insert into HoaDonDatPhong values('HD2310150001', 'KH231015001', '2311001', '2024-10-15 23:00:00.000', 0, null, 0)
insert into HoaDonDatPhong values('HD2409010001', 'KH231015001', '2311001', '2024-09-02 01:00:00.000', 0, null, 0)
insert into HoaDonDatPhong values('HD2408010001', 'KH231014001', '2001001', '2024-08-01 21:00:00.000', 1, null, 10000000)
insert into HoaDonDatPhong values('HD2407150001', 'KH231014001', '2001001', '2024-07-15 19:00:00.000', 1, null, 10000000)
go

--ChiTietHoaDon
insert into ChiTietHoaDon values('HD2310100001', '305', '2023-10-10 11:00:00.000', '2023-10-10 14:00:00.000', 3)
insert into ChiTietHoaDon values('HD2310100001', '306', '2023-10-10 11:00:00.000', '2023-10-10 14:00:00.000', 3)
insert into ChiTietHoaDon values('HD2310100002', '204', '2023-10-10 15:00:00.000', '2023-10-10 19:00:00.000', 4)
insert into ChiTietHoaDon values('HD2310100003', '102', '2023-10-10 18:00:00.000', '2023-10-10 21:00:00.000', 3)
insert into ChiTietHoaDon values('HD2310100003', '101', '2023-10-10 18:30:00.000', '2023-10-10 21:00:00.000', 2.5)

insert into ChiTietHoaDon values('HD2310110001', '401', '2023-10-11 8:00:00.000', '2023-10-11 8:00:00.000', 0)
insert into ChiTietHoaDon values('HD2310110002', '203', '2023-10-11 20:00:00.000', '2023-10-12 00:00:00.000', 4)

insert into ChiTietHoaDon values('HD2310120001', '404', '2023-10-12 20:00:00.000', '2023-10-13 00:00:00.000', 4)
insert into ChiTietHoaDon values('HD2310130001', '306', '2023-10-13 15:00:00.000', '2023-10-13 20:00:00.000', 5)
insert into ChiTietHoaDon values('HD2310140001', '105', '2023-10-14 12:00:00.000', '2023-10-14 15:00:00.000', 3)
insert into ChiTietHoaDon values('HD2310200001', '206', '2023-10-20 21:00:00.000', '2023-10-21 00:00:00.000', 3)
insert into ChiTietHoaDon values('HD2310150001', '403', '2024-10-15 21:00:00.000', '2024-10-15 23:00:00.000', 2)
insert into ChiTietHoaDon values('HD2409010001', '403', '2024-09-01 22:00:00.000', '2024-09-02 01:00:00.000', 3)
insert into ChiTietHoaDon values('HD2408010001', '404', '2024-08-01 18:00:00.000', '2024-08-01 21:00:00.000', 3)
insert into ChiTietHoaDon values('HD2407150001', '306', '2024-07-15 17:00:00.000', '2024-07-15 19:00:00.000',2)
go


--ChiTietDichVu
insert into ChiTietDichVu values('HD2310100001', 'SP001', 50, 9500)
insert into ChiTietDichVu values('HD2310100001', 'SP013', 5, 210000)
insert into ChiTietDichVu values('HD2310100001', 'SP014', 3, 80000)
insert into ChiTietDichVu values('HD2310100001', 'SP017', 6 , 195000)
insert into ChiTietDichVu values('HD2310100001', 'SP021', 4, 9000)

insert into ChiTietDichVu values('HD2310100002', 'SP003', 30, 10000)
insert into ChiTietDichVu values('HD2310100002', 'SP008', 10, 85000)
insert into ChiTietDichVu values('HD2310100002', 'SP012', 4, 165000)

insert into ChiTietDichVu values('HD2310100003', 'SP002', 25, 10000)
insert into ChiTietDichVu values('HD2310100003', 'SP014', 7, 80000)
insert into ChiTietDichVu values('HD2310100003', 'SP018', 3, 180000)
insert into ChiTietDichVu values('HD2310100003', 'SP021', 4, 9000)

insert into ChiTietDichVu values('HD2310110001', 'SP016', 2, 115000)
insert into ChiTietDichVu values('HD2310110001', 'SP023', 5, 40000)

insert into ChiTietDichVu values('HD2310110002', 'SP010', 10, 35000)
insert into ChiTietDichVu values('HD2310110002', 'SP011', 14, 90000)

insert into ChiTietDichVu values('HD2310120001', 'SP020', 5, 120000)
insert into ChiTietDichVu values('HD2310120001', 'SP003', 25, 10000)

insert into ChiTietDichVu values('HD2310130001', 'SP024', 23, 30000)
insert into ChiTietDichVu values('HD2310130001', 'SP025', 25, 45000)
insert into ChiTietDichVu values('HD2310130001', 'SP026', 20, 90000)

insert into ChiTietDichVu values('HD2310140001', 'SP015', 6, 140000)

insert into ChiTietDichVu values('HD2310200001', 'SP014', 4, 80000)
insert into ChiTietDichVu values('HD2310200001', 'SP018', 9, 180000)

insert into ChiTietDichVu values('HD2310150001', 'SP001', 27, 9500)
insert into ChiTietDichVu values('HD2310150001', 'SP014', 9, 80000)

insert into ChiTietDichVu values('HD2409010001', 'SP001', 27, 9500)
insert into ChiTietDichVu values('HD2409010001', 'SP014', 9, 80000)

insert into ChiTietDichVu values('HD2408010001', 'SP024', 40, 30000)
insert into ChiTietDichVu values('HD2408010001', 'SP025', 25, 45000)
insert into ChiTietDichVu values('HD2408010001', 'SP026', 20, 90000)

insert into ChiTietDichVu values('HD2407150001', 'SP024', 40, 30000)
insert into ChiTietDichVu values('HD2407150001', 'SP025', 25, 45000)
insert into ChiTietDichVu values('HD2407150001', 'SP026', 20, 90000)
insert into ChiTietDichVu values('HD2407150001', 'SP014', 20, 80000)
insert into ChiTietDichVu values('HD2407150001', 'SP001', 25, 9500)
insert into ChiTietDichVu values('HD2407150001', 'SP018', 20, 180000)

--thêm tmp
insert into TempDatPhong values('000','00')
go

--select * from NhanVien
--select * from TaiKhoan
--select * from ChiTietLuong
--select * from LoaiPhong
--select * from Phong
--select * from SanPham
--select * from KhuyenMai
--select * from KhachHang
--select * from PhieuDatPhong
--select * from HoaDonDatPhong
--select * from ChiTietHoaDon
--select * from  ChiTietDichVu
