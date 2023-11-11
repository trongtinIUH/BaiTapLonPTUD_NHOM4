package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;
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
				dspdp.add(new PhieuDatPhong(rs.getString(1), p, nv, kh, rs.getDate(5), rs.getDate(6), rs.getInt(7)));
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
				pdp = new PhieuDatPhong(rs.getString(1), p, nv, kh, rs.getDate(5), rs.getDate(6), rs.getInt(7));
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
				dsPDP.add( new PhieuDatPhong(rs.getString(1), p, nv, kh, rs.getDate(5), rs.getDate(6), rs.getInt(7)));
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
			psmt.setDate(5, pdp.getNgayGioDatPhong());
			psmt.setDate(6, pdp.getNgayGioNhanPhong());
			psmt.setInt(7, pdp.getSoNguoiHat());
			n = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				psmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
}
