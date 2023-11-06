package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entity.HoaDonDatPhong;
import entity.KhachHang;
import entity.KhuyenMai;
import entity.NhanVien;
import entity.SanPham;

public class HoaDon_dao {
	public ArrayList<HoaDonDatPhong> getAllHoaDonDatPhong() {
		ArrayList<HoaDonDatPhong> dsHoaDonDatPhong = new ArrayList<HoaDonDatPhong>();
		try {
			ConnectDB.getInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from HoaDonDatPhong";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				dsHoaDonDatPhong.add(new HoaDonDatPhong(rs.getString(1), new KhachHang(rs.getString(2)), 
				new NhanVien(rs.getString(3)), rs.getDate(4), rs.getBoolean(5), new KhuyenMai(rs.getString(6) != null ? rs.getString(6) : "NULL"), rs.getDouble(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHoaDonDatPhong;
	}
	
	public ArrayList<HoaDonDatPhong> getHoaDonDatPhongTheoMaHD(String maHD) {
		ArrayList<HoaDonDatPhong> dsHoaDonDatPhong = new ArrayList<HoaDonDatPhong>();
		try {
			ConnectDB.getInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from HoaDonDatPhong where maHoaDon like '%"+maHD+"%'";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				dsHoaDonDatPhong.add(new HoaDonDatPhong(rs.getString(1), new KhachHang(rs.getString(2)), 
				new NhanVien(rs.getString(3)), rs.getDate(4), rs.getBoolean(5), new KhuyenMai(rs.getString(6) != null ? rs.getString(6) : "NULL"), rs.getDouble(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHoaDonDatPhong;
	}
	public ArrayList<HoaDonDatPhong> getHoaDonDatPhongTheoTenKH(String tenKH) {
		ArrayList<HoaDonDatPhong> dsHoaDonDatPhong = new ArrayList<HoaDonDatPhong>();
		try {
			ConnectDB.getInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select maHoaDon, hd.maKhachHang, maNhanVien, ngayLapHoaDon, trangThai, maKhuyenMai, tienKhachDua "
					+ "from HoaDonDatPhong hd join KhachHang kh on kh.maKhachHang = hd.maKhachHang "
					+ "where kh.hoTen like N'%"+ tenKH + "%'";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				dsHoaDonDatPhong.add(new HoaDonDatPhong(rs.getString(1), new KhachHang(rs.getString(2)), 
				new NhanVien(rs.getString(3)), rs.getDate(4), rs.getBoolean(5), new KhuyenMai(rs.getString(6) != null ? rs.getString(6) : "NULL"), rs.getDouble(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHoaDonDatPhong;
	}
	public ArrayList<HoaDonDatPhong> getHoaDonDatPhongTheoMaNV(String maNV) {
		ArrayList<HoaDonDatPhong> dsHoaDonDatPhong = new ArrayList<HoaDonDatPhong>();
		try {
			ConnectDB.getInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from HoaDonDatPhong where maNhanVien = '"+maNV+"'";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				dsHoaDonDatPhong.add(new HoaDonDatPhong(rs.getString(1), new KhachHang(rs.getString(2)), 
				new NhanVien(rs.getString(3)), rs.getDate(4), rs.getBoolean(5), new KhuyenMai(rs.getString(6) != null ? rs.getString(6) : "NULL"), rs.getDouble(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHoaDonDatPhong;
	}
	public ArrayList<HoaDonDatPhong> getHoaDonTheoNgayLapHD(String ngayLapHD) {
		ArrayList<HoaDonDatPhong> dsHoaDonDatPhong = new ArrayList<HoaDonDatPhong>();
		try {
			ConnectDB.getInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from HoaDonDatPhong where ngayLapHoaDon = '"+ngayLapHD+"'";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				dsHoaDonDatPhong.add(new HoaDonDatPhong(rs.getString(1), new KhachHang(rs.getString(2)), 
				new NhanVien(rs.getString(3)), rs.getDate(4), rs.getBoolean(5), new KhuyenMai(rs.getString(6) != null ? rs.getString(6) : "NULL"), rs.getDouble(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHoaDonDatPhong;
	}
	
	public ArrayList<HoaDonDatPhong> getHoaDonTheoThang(String thang, int nam) {
		ArrayList<HoaDonDatPhong> dsHoaDonDatPhong = new ArrayList<HoaDonDatPhong>();
		try {
			ConnectDB.getInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from HoaDonDatPhong "
					+ "where MONTH(ngayLapHoaDon) = '"+thang+"' AND YEAR(ngayLapHoaDon) = '"+nam+"'";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				dsHoaDonDatPhong.add(new HoaDonDatPhong(rs.getString(1), new KhachHang(rs.getString(2)), 
				new NhanVien(rs.getString(3)), rs.getDate(4), rs.getBoolean(5), new KhuyenMai(rs.getString(6) != null ? rs.getString(6) : "NULL"), rs.getDouble(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHoaDonDatPhong;
	}
	
	public boolean updateHoaDon(String maHD, Date ngayLap, Boolean status, String maNV) {
		try {
			ConnectDB.getInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement psmt = null;
		int n = 0;
		try {
			psmt = con.prepareStatement("update HoaDonDatPhong set maNhanVien=?, ngayLapHoaDon=?, trangThai=? where maHoaDon=?");
			psmt.setString(1, maNV);
			psmt.setDate(2, (java.sql.Date) ngayLap);
			psmt.setBoolean(3, status);
			psmt.setString(4, maHD);
			n = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
		}finally {
			try {
				psmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return n > 0;
	}
	public boolean deleteHoaDon(String maHD) {
		try {
			ConnectDB.getInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement psmt = null;
		int n = 0;
		try {
			psmt = con.prepareStatement("delete HoaDonDatPhong where maHoaDon=?");
			psmt.setString(1, maHD);
			n = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				psmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return n > 0;
	}
}
