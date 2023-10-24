package entity;

import java.io.Serializable;

public class ChiTietHoaDon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HoaDonDatPhong hoaDon;
	private Phong phong;
	private double soGioHat;
	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietHoaDon(HoaDonDatPhong hoaDon, Phong phong, double soGioHat) {
		super();
		this.hoaDon = hoaDon;
		this.phong = phong;
		this.soGioHat = soGioHat;
	}
	public HoaDonDatPhong getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDonDatPhong hoaDon) {
		this.hoaDon = hoaDon;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public double getSoGioHat() {
		return soGioHat;
	}
	public void setSoGioHat(double soGioHat) {
		this.soGioHat = soGioHat;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return String.format("ChiTietHoaDon [hoaDon=%s, phong=%s, soGioHat=%s]", hoaDon, phong, soGioHat);
	}
	
	

}
