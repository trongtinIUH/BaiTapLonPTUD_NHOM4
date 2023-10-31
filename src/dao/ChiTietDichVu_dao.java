package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTietDichVu;
import entity.HoaDonDatPhong;
import entity.SanPham;

public class ChiTietDichVu_dao {
	public ArrayList<ChiTietDichVu> getAllChiTietDichVu() {
		ArrayList<ChiTietDichVu> dsChiTietDichVu = new ArrayList<ChiTietDichVu>();
		try {
			ConnectDB.getInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from ChiTietDichVu";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				dsChiTietDichVu.add(new ChiTietDichVu(new HoaDonDatPhong(rs.getString(1)), new SanPham(rs.getString(2)), rs.getInt(3),  rs.getDouble(4)));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsChiTietDichVu;
	}
	
	public ArrayList<ChiTietDichVu> getChiTietDichVuTheoMaHD(String maHD) {
		ArrayList<ChiTietDichVu> dsChiTietDichVu = new ArrayList<ChiTietDichVu>();
		try {
			ConnectDB.getInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from ChiTietDichVu where maHD='"+ maHD +"'";
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				dsChiTietDichVu.add(new ChiTietDichVu(new HoaDonDatPhong(rs.getString(1)), new SanPham(rs.getString(2)), rs.getInt(3),  rs.getDouble(4)));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsChiTietDichVu;
	}
	
	public boolean addChiTietDV(ChiTietDichVu ctdv) {
		try {
			ConnectDB.getInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into ChiTietDichVu values(?,?,?,?)");
			stmt.setString(1, ctdv.getHoaDon().getMaHoaDon());
			stmt.setString(2, ctdv.getSanPham().getMaSanPham());
			stmt.setInt(3, ctdv.getSoLuong());
			stmt.setDouble(4, ctdv.getGia());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		}
		return n > 0;
	}
	
	public boolean UpdateChiTietDV(ChiTietDichVu cthd) {
		try {
			ConnectDB.getInstance();
		} catch (Exception e) {
			// TODO: handle exception
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update ChiTietDichVu set soLuong=?, giaBan=? where maSanPham=?");
			stmt.setInt(1, cthd.getSoLuong());
			stmt.setDouble(2, cthd.getGia());
			stmt.setString(3, cthd.getSanPham().getMaSanPham());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		}
		return n > 0;
	}
	
	public boolean deleteChiTietDV(String maSanPham) {
		try {
			ConnectDB.getInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from ChiTietDichVu where maSanPham = ?");
			stmt.setString(1, maSanPham);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		}
		return n > 0;
	}
}
