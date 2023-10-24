package entity;

import java.io.Serializable;
import java.util.Objects;

public class LoaiPhong  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maLoaiPhong;
	private String tenLoaiPhong;
	private int sucChua;
	private double donGiaTheoGio;
	public LoaiPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoaiPhong(String maLoaiPhong, String tenLoaiPhong, int sucChua, double donGiaTheoGio) {
		super();
		this.maLoaiPhong = maLoaiPhong;
		this.tenLoaiPhong = tenLoaiPhong;
		this.sucChua = sucChua;
		this.donGiaTheoGio = donGiaTheoGio;
	}
	public String getMaLoaiPhong() {
		return maLoaiPhong;
	}
	public void setMaLoaiPhong(String maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}
	public String getTenLoaiPhong() {
		return tenLoaiPhong;
	}
	public void setTenLoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong;
	}
	public int getSucChua() {
		return sucChua;
	}
	public void setSucChua(int sucChua) {
		this.sucChua = sucChua;
	}
	public double getDonGiaTheoGio() {
		return donGiaTheoGio;
	}
	public void setDonGiaTheoGio(double donGiaTheoGio) {
		this.donGiaTheoGio = donGiaTheoGio;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maLoaiPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiPhong other = (LoaiPhong) obj;
		return Objects.equals(maLoaiPhong, other.maLoaiPhong);
	}
	@Override
	public String toString() {
		return String.format("LoaiPhong [maLoaiPhong=%s, tenLoaiPhong=%s, sucChua=%s, donGiaTheoGio=%s]", maLoaiPhong,
				tenLoaiPhong, sucChua, donGiaTheoGio);
	}
	

}
