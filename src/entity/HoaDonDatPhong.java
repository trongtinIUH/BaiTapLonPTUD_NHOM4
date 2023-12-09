package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class HoaDonDatPhong implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maHoaDon;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	private Date ngayLapHoaDon;
	private boolean trangThai;
	private KhuyenMai khuyenMai;
	private double tienKhachDua;
	
	public HoaDonDatPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDonDatPhong(String maHoaDon, KhachHang khachHang, NhanVien nhanVien, Date ngayLapHoaDon,
			boolean trangThai, KhuyenMai khuyenMai, double tienKhachDua) {
		super();
		this.maHoaDon = maHoaDon;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.trangThai = trangThai;
		this.khuyenMai = khuyenMai;
		this.tienKhachDua = tienKhachDua;
	}
	
	public HoaDonDatPhong(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public Date getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}
	public void setNgayLapHoaDon(Date ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}
	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}
	public double getTienKhachDua() {
		return tienKhachDua;
	}
	public void setTienKhachDua(double tienKhachDua) {
		this.tienKhachDua = tienKhachDua;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public double tinhTongTienThanhToan(double tongTienPhong, double tongTienDV, float phanTramKhuyenMai) {
		return ((tongTienPhong + tongTienDV) *  (100 - phanTramKhuyenMai * 100)/ 100)*1.1;
	}
	
	public double tinhTienTraLai(double tongTienPhong, double tongTienDV, float phanTramKhuyenMai, double tienKhachDua) {
		double tongTien = tinhTongTienThanhToan(tongTienPhong, tongTienDV, phanTramKhuyenMai);
		return tongTien - tienKhachDua;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDonDatPhong other = (HoaDonDatPhong) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}
	@Override
	public String toString() {
		return String.format(
				"HoaDonDatPhong [maHoaDon=%s, khachHang=%s, nhanVien=%s, ngayLapHoaDon=%s, trangThai=%s, khuyenMai=%s, tienKhachDua=%s]",
				maHoaDon, khachHang, nhanVien, ngayLapHoaDon, trangThai, khuyenMai, tienKhachDua);
	}
	
	
}
