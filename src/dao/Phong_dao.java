package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiPhong;
import entity.Phong;
import entity.Phong.TrangThai;

public class Phong_dao {
	public ArrayList<Phong> getallPhongs() {
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		try {
			ConnectDB.getInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from Phong";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				dsPhong.add(
						new Phong(rs.getString(1), new LoaiPhong(rs.getString(2)), TrangThai.valueOf(rs.getString(3))));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsPhong;
	}

	public Phong getPhongTheoMaPhong(String maPhong) {
		Phong ph = null;
		try {
			ConnectDB.getInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from Phong where maPhong = '" + maPhong + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				ph = new Phong(rs.getString(1), new LoaiPhong(rs.getString(2)), TrangThai.valueOf(rs.getString(3)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ph;
	}

	public ArrayList<Phong> getPhongTheoMaLoaiPhong(String maLoaiPhong) {
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		try {
			ConnectDB.getInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from Phong where maLoaiPhong = '" + maLoaiPhong + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				dsPhong.add(
						new Phong(rs.getString(1), new LoaiPhong(rs.getString(2)), TrangThai.valueOf(rs.getString(3))));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (dsPhong.isEmpty())
			return null;
		return dsPhong;
	}

	public ArrayList<Phong> getPhongTheoSucChua(String sucChua) {
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		try {
			ConnectDB.getInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "SELECT Phong.maPhong, Phong.maLoaiPhong, Phong.trangThai FROM Phong JOIN LoaiPhong ON Phong.maLoaiPhong = LoaiPhong.maLoaiPhong WHERE LoaiPhong.sucChua = '"
					+ sucChua + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				dsPhong.add(
						new Phong(rs.getString(1), new LoaiPhong(rs.getString(2)), TrangThai.valueOf(rs.getString(3))));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(dsPhong.isEmpty())
			return null;
		return dsPhong;
	}

	public boolean addPhong(Phong ph) {
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
			psmt = con.prepareStatement("insert into Phong values(?,?,?)");
			psmt.setString(1, ph.getMaPhong());
			psmt.setString(2, ph.getLoaiPhong().getMaLoaiPhong());
			psmt.setString(3, ph.getTrangThai().toString());
			n = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				psmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return n > 0;
	}

	public boolean updatePhong(Phong ph, String maPhongMoi) {
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
			psmt = con.prepareStatement("update Phong set maPhong = ?, maLoaiPhong=?, trangThai=? where maPhong=?");
			psmt.setString(1, maPhongMoi);
			psmt.setString(2, ph.getLoaiPhong().getMaLoaiPhong());
			psmt.setString(3, ph.getTrangThai().toString());
			psmt.setString(4, ph.getMaPhong());
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

	public boolean deletePhong(String maPhong) {
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
			psmt = con.prepareStatement("delete Phong where maPhong=?");
			psmt.setString(1, maPhong);
			n = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				psmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return n > 0;
	}
}
