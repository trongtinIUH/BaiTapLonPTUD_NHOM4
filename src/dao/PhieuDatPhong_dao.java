package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.Phong;

public class PhieuDatPhong_dao {
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
}
