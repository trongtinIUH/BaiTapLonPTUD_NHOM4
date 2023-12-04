-- Switch to the master database to create the logins
go 
drop login NV
drop login QL
go
USE master;

-- Create logins
CREATE LOGIN QL WITH PASSWORD = 'QLpassword', CHECK_POLICY = OFF;
CREATE LOGIN NV WITH PASSWORD = 'NVpassword', CHECK_POLICY = OFF;

-- Switch to your database to create the users and roles
USE QuanLyCuaHangKaraoke4T;

-- Create users for the logins in the database
CREATE USER QL FOR LOGIN QL;
CREATE USER NV FOR LOGIN NV;

-- Create roles
CREATE ROLE role_QL AUTHORIZATION dbo;
CREATE ROLE role_NV AUTHORIZATION dbo;

-- Add the users to the roles
EXEC sp_addrolemember 'role_QL', 'QL';
EXEC sp_addrolemember 'role_NV', 'NV';

-- Grant permissions to admin
GRANT CREATE TABLE, CREATE PROCEDURE, CREATE VIEW, CREATE FUNCTION TO role_QL;
GRANT SELECT, INSERT, UPDATE, DELETE TO role_QL;

-- Grant SELECT permissions to user
GRANT SELECT ON LoaiPhong TO role_NV;
GRANT SELECT ON NhanVien TO role_NV;
GRANT SELECT ON Phong TO role_NV;
GRANT SELECT ON SanPham TO role_NV;
GRANT SELECT ON KhuyenMai TO role_NV;
GRANT SELECT ON KhachHang TO role_NV;
GRANT SELECT ON PhieuDatPhong TO role_NV;
GRANT SELECT ON HoaDonDatPhong TO role_NV;
GRANT SELECT ON ChiTietHoaDon TO role_NV;
GRANT SELECT ON ChiTietDichVu TO role_NV;
GRANT SELECT ON TempDatPhong TO role_NV;

-- Grant INSERT permissions to user
GRANT INSERT ON SanPham TO role_NV;
GRANT INSERT ON KhuyenMai TO role_NV;
GRANT INSERT ON KhachHang TO role_NV;
GRANT INSERT ON PhieuDatPhong TO role_NV;
GRANT INSERT ON HoaDonDatPhong TO role_NV;
GRANT INSERT ON ChiTietHoaDon TO role_NV;
GRANT INSERT ON ChiTietDichVu TO role_NV;
GRANT INSERT ON TempDatPhong TO role_NV;

-- Grant UPDATE permissions to user
GRANT UPDATE ON Phong TO role_NV;
GRANT UPDATE ON SanPham TO role_NV;
GRANT UPDATE ON KhuyenMai TO role_NV;
GRANT UPDATE ON KhachHang TO role_NV;
GRANT UPDATE ON PhieuDatPhong TO role_NV;
GRANT UPDATE ON HoaDonDatPhong TO role_NV;
GRANT UPDATE ON ChiTietHoaDon TO role_NV;
GRANT UPDATE ON ChiTietDichVu TO role_NV;
GRANT UPDATE ON TempDatPhong TO role_NV;

--Grant DELETE permissions to user
GRANT DELETE ON TempDatPhong TO role_NV;
