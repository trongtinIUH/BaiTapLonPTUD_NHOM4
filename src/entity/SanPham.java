package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class SanPham implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maSanPham;
	private String tenSanPham;
	private Date ngaySanXuat;
	private String noiSanXuat;
	private double donGia;
	private int soLuongTon;
	private String hinhAnh;
	private String donViTinh;
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SanPham(String maSanPham, String tenSanPham, Date ngaySanXuat, String noiSanXuat, double donGia,
			int soLuongTon, String hinhAnh, String donViTinh) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.ngaySanXuat = ngaySanXuat;
		this.noiSanXuat = noiSanXuat;
		this.donGia = donGia;
		this.soLuongTon = soLuongTon;
		this.hinhAnh = hinhAnh;
		this.donViTinh = donViTinh;
	}
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public Date getNgaySanXuat() {
		return ngaySanXuat;
	}
	public void setNgaySanXuat(Date ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}
	public String getNoiSanXuat() {
		return noiSanXuat;
	}
	public void setNoiSanXuat(String noiSanXuat) {
		this.noiSanXuat = noiSanXuat;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maSanPham);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Objects.equals(maSanPham, other.maSanPham);
	}
	@Override
	public String toString() {
		return String.format(
				"SanPham [maSanPham=%s, tenSanPham=%s, ngaySanXuat=%s, noiSanXuat=%s, donGia=%s, soLuongTon=%s, hinhAnh=%s, donViTinh=%s]",
				maSanPham, tenSanPham, ngaySanXuat, noiSanXuat, donGia, soLuongTon, hinhAnh, donViTinh);
	}
	
	
}
