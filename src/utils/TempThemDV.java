package utils;

public class TempThemDV {
	private String maPhong;
	private String maSP;
	private String tenSP;
	private int soLuong;
	private double donGia;
	public String getMaSP() {
		return maSP;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public TempThemDV(String maPhong, String maSP, String tenSP, int soLuong, double donGia) {
		super();
		this.maPhong = maPhong;
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}
	public TempThemDV() {
		super();
	}
	
	
	
}
