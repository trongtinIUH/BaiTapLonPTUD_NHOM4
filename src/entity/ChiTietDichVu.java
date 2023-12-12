package entity;

import java.io.Serializable;

public class ChiTietDichVu  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HoaDonDatPhong hoaDon;
	private Phong phong;
	private SanPham sanPham;
	private int soLuong;
	private double gia;
	public ChiTietDichVu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietDichVu(HoaDonDatPhong hoaDon, Phong phong, SanPham sanPham, int soLuong, double gia) {
		super();
		this.hoaDon = hoaDon;
		this.phong = phong;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
		this.gia = gia;
	}
	
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public HoaDonDatPhong getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDonDatPhong hoaDon) {
		this.hoaDon = hoaDon;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ChiTietDichVu [hoaDon=" + hoaDon + ", phong=" + phong + ", sanPham=" + sanPham + ", soLuong=" + soLuong
				+ ", gia=" + gia + "]";
	}
	
	
	

	
	
}
