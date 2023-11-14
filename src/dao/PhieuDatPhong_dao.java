package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.Phong;

public class PhieuDatPhong_dao {
	public ArrayList<PhieuDatPhong> getAllsPhieuDatPhong() {
		ArrayList<PhieuDatPhong> dspdp = new ArrayList<PhieuDatPhong>();
		try {
			ConnectDB.getInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from PhieuDatPhong";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Phong p = new Phong(rs.getString(2));
				NhanVien nv = new NhanVien(rs.getString(3));
				KhachHang kh = new KhachHang(rs.getString(4));
				LocalDateTime ngayGioDatPhong = rs.getTimestamp("ngayGioDatPhong").toLocalDateTime();
				LocalDateTime ngayGioNhanPhong = rs.getTimestamp("ngayGioNhanPhong").toLocalDateTime();
				dspdp.add(
						new PhieuDatPhong(rs.getString(1), p, nv, kh, ngayGioDatPhong, ngayGioNhanPhong, rs.getInt(7)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dspdp;
	}

	public PhieuDatPhong getPhieuDatPhongTheoMa(String maPhong) {
		PhieuDatPhong pdp = null;
		try {
			ConnectDB.getInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from PhieuDatPhong where maPhong = '" + maPhong + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Phong p = new Phong(rs.getString(2));
				NhanVien nv = new NhanVien(rs.getString(3));
				KhachHang kh = new KhachHang(rs.getString(4));
				LocalDateTime ngayGioDatPhong = rs.getTimestamp(5).toLocalDateTime();
				LocalDateTime ngayGioNhanPhong = rs.getTimestamp(6).toLocalDateTime();
				pdp = new PhieuDatPhong(rs.getString(1), p, nv, kh, ngayGioDatPhong, ngayGioNhanPhong, rs.getInt(7));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return pdp;
	}

	public ArrayList<PhieuDatPhong> getDanhsachPhieuDatPhongTheoMa(String maPhong) {
		ArrayList<PhieuDatPhong> dsPDP = new ArrayList<PhieuDatPhong>();
		try {
			ConnectDB.getInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from PhieuDatPhong where maPhong = '" + maPhong + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Phong p = new Phong(rs.getString(2));
				NhanVien nv = new NhanVien(rs.getString(3));
				KhachHang kh = new KhachHang(rs.getString(4));
				LocalDateTime ngayGioDatPhong = rs.getTimestamp(5).toLocalDateTime();
				LocalDateTime ngayGioNhanPhong = rs.getTimestamp(6).toLocalDateTime();
				dsPDP.add(
						new PhieuDatPhong(rs.getString(1), p, nv, kh, ngayGioDatPhong, ngayGioNhanPhong, rs.getInt(7)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsPDP;
	}

	public boolean addPhieuDatPhong(PhieuDatPhong pdp) {
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
			psmt = con.prepareStatement("insert into PhieuDatPhong values(?,?,?,?,?,?,?)");
			psmt.setString(1, pdp.getMaPhieu());
			psmt.setString(2, pdp.getPhong().getMaPhong());
			psmt.setString(3, pdp.getNhanVien().getMaNhanVien());
			psmt.setString(4, pdp.getKhachHang().getMaKhachHang());
			psmt.setObject(5, pdp.getNgayGioDatPhong());
			psmt.setObject(6, pdp.getNgayGioNhanPhong());
			psmt.setInt(7, pdp.getSoNguoiHat());
			n = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	// lấy dữ liệu đưa lên hiển phòng chờ
	public ArrayList<PhieuDatPhong> getPhieuDatPhongInfo() {
		ArrayList<PhieuDatPhong> list = new ArrayList<>();
		try {
			ConnectDB.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "SELECT p.maPhong, lp.tenLoaiPhong, pdp.soNguoiHat, pdp.ngayGioDatPhong, pdp.ngayGioNhanPhong, lp.donGiaTheoGio, kh.hoTen "
					+ "FROM PhieuDatPhong pdp " + "JOIN Phong p ON pdp.maPhong = p.maPhong "
					+ "JOIN LoaiPhong lp ON p.maLoaiPhong = lp.maLoaiPhong "
					+ "JOIN KhachHang kh ON pdp.maKhachHang = kh.maKhachHang";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				PhieuDatPhong pdp = new PhieuDatPhong();
				pdp.setMaPhieu(rs.getString("maPhong"));
				pdp.setSoNguoiHat(rs.getInt("soNguoiHat"));

				// Chuyển đổi java.sql.Timestamp sang java.time.LocalDateTime
				LocalDateTime ngayGioDatPhong = rs.getTimestamp("ngayGioDatPhong").toLocalDateTime();
				LocalDateTime ngayGioNhanPhong = rs.getTimestamp("ngayGioNhanPhong").toLocalDateTime();

				pdp.setNgayGioDatPhong(ngayGioDatPhong);
				pdp.setNgayGioNhanPhong(ngayGioNhanPhong);

				Phong phong = new Phong(rs.getString("maPhong"));

				LoaiPhong loaiPhong = new LoaiPhong();
				loaiPhong.setTenLoaiPhong(rs.getString("tenLoaiPhong"));
				loaiPhong.setDonGiaTheoGio(rs.getDouble("donGiaTheoGio"));

				phong.setLoaiPhong(loaiPhong);
				pdp.setPhong(phong);

				KhachHang khachHang = new KhachHang();
				khachHang.setHoTen(rs.getString("hoTen"));
				pdp.setKhachHang(khachHang);

				list.add(pdp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public PhieuDatPhong timThongTinPhieuDatPhongTheoMaPhong(String maPhong) {
		PhieuDatPhong pdp = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT p.maPhong, lp.tenLoaiPhong, pdp.soNguoiHat, pdp.ngayGioDatPhong, pdp.ngayGioNhanPhong, lp.donGiaTheoGio, kh.hoTen "
					+ "FROM PhieuDatPhong pdp " + "JOIN Phong p ON pdp.maPhong = p.maPhong "
					+ "JOIN LoaiPhong lp ON p.maLoaiPhong = lp.maLoaiPhong "
					+ "JOIN KhachHang kh ON pdp.maKhachHang = kh.maKhachHang " + "WHERE p.maPhong = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, maPhong);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Phong phong = new Phong(rs.getString("maPhong"));
				phong.getLoaiPhong().setTenLoaiPhong(rs.getString("tenLoaiPhong"));

				KhachHang kh = new KhachHang();
				kh.setHoTen(rs.getString("hoTen"));

				// Chuyển đổi java.sql.Timestamp sang java.time.LocalDateTime
				LocalDateTime ngayGioDatPhong = rs.getTimestamp("ngayGioDatPhong").toLocalDateTime();
				LocalDateTime ngayGioNhanPhong = rs.getTimestamp("ngayGioNhanPhong").toLocalDateTime();

				pdp = new PhieuDatPhong(phong, kh, ngayGioDatPhong, ngayGioNhanPhong, rs.getInt("soNguoiHat"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pdp;

	}
}
