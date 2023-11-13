package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ModelThongKe;

public class ThongKe_dao {
	public ArrayList<ModelThongKe> thongKeTheoNam(String yearStart, String yearEnd){
		ArrayList<ModelThongKe> lists = new ArrayList<ModelThongKe>();
		try {
			ConnectDB.getInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "DECLARE @namBatDau int = "+yearStart+" "
					+ "DECLARE @namKetThuc int = "+yearEnd+" "
					+ "SELECT "
					+ "    YEAR(ngayLapHoaDon) AS nam, "
					+ "    SUM(tongTienSauKhuyenMai) AS tongDoanhThu, "
					+ "    SUM(tienPhong) AS tongTienPhong, "
					+ "    SUM(tienDichVu) AS tongTienDichVu "
					+ "FROM "
					+ "("
					+ "    SELECT "
					+ "        hd.ngayLapHoaDon, "
					+ "        (lp.donGiaTheoGio * cthd.soGioHat + ctdv.giaBan * ctdv.soLuong) * (1 - COALESCE(km.phanTramKhuyenMai, 0) / 100) AS tongTienSauKhuyenMai,\r\n"
					+ "        lp.donGiaTheoGio * cthd.soGioHat AS tienPhong, "
					+ "        ctdv.giaBan * ctdv.soLuong AS tienDichVu "
					+ "    FROM HoaDonDatPhong hd "
					+ "    LEFT JOIN ChiTietHoaDon cthd ON cthd.maHoaDon = hd.maHoaDon "
					+ "    LEFT JOIN Phong p ON p.maPhong = cthd.maPhong "
					+ "    LEFT JOIN LoaiPhong lp ON lp.maLoaiPhong = p.maLoaiPhong "
					+ "    LEFT JOIN ChiTietDichVu ctdv ON ctdv.maHoaDon = hd.maHoaDon "
					+ "    LEFT JOIN KhuyenMai km ON km.maKhuyenMai = hd.maKhuyenMai "
					+ ") AS KQ "
					+ "WHERE YEAR(ngayLapHoaDon) BETWEEN @namBatDau AND @namKetThuc "
					+ "GROUP BY YEAR(ngayLapHoaDon)";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				lists.add(new ModelThongKe(rs.getString(1) + "", rs.getDouble(2), rs.getDouble(3), rs.getDouble(4)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lists;
	}
	
	public ArrayList<ModelThongKe> updateCboYear(){
		ArrayList<ModelThongKe> yearLists = new ArrayList<ModelThongKe>();
		try {
			ConnectDB.getInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select YEAR(ngayLapHoaDon) as nam "
					+ "from HoaDonDatPhong "
					+ "group by YEAR(ngayLapHoaDon)";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				yearLists.add(new ModelThongKe(rs.getString(1) + ""));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return yearLists;
	}
	
	public ArrayList<ModelThongKe> updateCboMonth(){
		ArrayList<ModelThongKe> lists = new ArrayList<ModelThongKe>();
		try {
			ConnectDB.getInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select MONTH(ngayLapHoaDon) as thang "
					+ "from HoaDonDatPhong "
					+ "group by Month(ngayLapHoaDon)";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				ModelThongKe modelTK = new ModelThongKe();
				modelTK.setMonth(rs.getString(1));
				lists.add(modelTK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lists;
	}
}
