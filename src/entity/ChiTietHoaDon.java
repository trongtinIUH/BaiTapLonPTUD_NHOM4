package entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class ChiTietHoaDon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HoaDonDatPhong hoaDon;
	private Phong phong;
	private Timestamp gioNhanPhong;
	private Timestamp gioTraPhong;
	private double soGioHat;
	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietHoaDon(HoaDonDatPhong hoaDon, Phong phong,  Timestamp gioNhanPhong, Timestamp gioTraPhong, double soGioHat) {
		super();
		this.hoaDon = hoaDon;
		this.phong = phong;
		this.gioNhanPhong = gioNhanPhong;
		this.gioTraPhong = gioTraPhong;
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
	
	public Timestamp getGioNhanPhong() {
		return gioNhanPhong;
	}
	public void setGioNhanPhong(Timestamp gioNhanPhong) {
		this.gioNhanPhong = gioNhanPhong;
	}
	public Timestamp getGioTraPhong() {
		return gioTraPhong;
	}
	public void setGioTraPhong(Timestamp gioTraPhong) {
		this.gioTraPhong = gioTraPhong;
	}
	@Override
	public String toString() {
		return String.format("ChiTietHoaDon [hoaDon=%s, phong=%s, soGioHat=%s]", hoaDon, phong, soGioHat);
	}
	
	

}
