package entity;

import java.util.Objects;

public class Temp {
	private String maPhong;
	private String loaiPhong;
	private Enum_TrangThai trangThai;
	private double gia;
	private int soNguoi;
	public Temp(String maPhong, String loaiPhong, Enum_TrangThai trangThai, double gia, int soNguoi) {
		super();
		this.maPhong = maPhong;
		this.loaiPhong = loaiPhong;
		this.trangThai = trangThai;
		this.gia = gia;
		this.soNguoi = soNguoi;
	}
	public Temp() {
		super();
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	public Enum_TrangThai getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(Enum_TrangThai trangThai) {
		this.trangThai = trangThai;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public int getSoNguoi() {
		return soNguoi;
	}
	public void setSoNguoi(int soNguoi) {
		this.soNguoi = soNguoi;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Temp other = (Temp) obj;
		return Objects.equals(maPhong, other.maPhong);
	}
	@Override
	public String toString() {
		return "TempList [maPhong=" + maPhong + ", loaiPhong=" + loaiPhong + ", trangThai=" + trangThai + ", gia=" + gia
				+ ", soNguoi=" + soNguoi + "]";
	}
	
	
}
