package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class KhuyenMai implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maKhuyenMai;
	private String tenKhuyenMai;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	private float phanTramKhuyenMai;
	public KhuyenMai() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhuyenMai(String maKhuyenMai, String tenKhuyenMai, Date ngayBatDau, Date ngayKetThuc,
			float phanTramKhuyenMai) {
		super();
		this.maKhuyenMai = maKhuyenMai;
		this.tenKhuyenMai = tenKhuyenMai;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.phanTramKhuyenMai = phanTramKhuyenMai;
	}
	
	public KhuyenMai(String maKhuyenMai) {
		super();
		this.maKhuyenMai = maKhuyenMai;
	}
	
	public String getMaKhuyenMai() {
		return maKhuyenMai;
	}
	public void setMaKhuyenMai(String maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}
	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}
	public void setTenKhuyenMai(String tenKhuyenMai) {
		this.tenKhuyenMai = tenKhuyenMai;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public float getPhanTramKhuyenMai() {
		return phanTramKhuyenMai;
	}
	public void setPhanTramKhuyenMai(float phanTramKhuyenMai) {
		this.phanTramKhuyenMai = phanTramKhuyenMai;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maKhuyenMai);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhuyenMai other = (KhuyenMai) obj;
		return Objects.equals(maKhuyenMai, other.maKhuyenMai);
	}
	@Override
	public String toString() {
		return String.format(
				"KhuyenMai [maKhuyenMai=%s, tenKhuyenMai=%s, ngayBatDau=%s, ngayKetThuc=%s, phanTramKhuyenMai=%s]",
				maKhuyenMai, tenKhuyenMai, ngayBatDau, ngayKetThuc, phanTramKhuyenMai);
	}
	
	
}
