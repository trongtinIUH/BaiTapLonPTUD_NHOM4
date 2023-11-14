package entity;

import java.io.Serializable;
import java.util.Objects;

public class Phong extends LoaiPhong implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maPhong;
	private LoaiPhong loaiPhong;

//	public enum TrangThai {
//		Trống, Chờ, Đang_sử_dụng, Đang_sửa_chữa
//	}

	private Enum_TrangThai trangThai;

	public Phong() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Phong(String maLoaiPhong, String tenLoaiPhong, int sucChua, double donGiaTheoGio) {
		super(maLoaiPhong, tenLoaiPhong, sucChua, donGiaTheoGio);
		// TODO Auto-generated constructor stub
	}

	public Phong(String maPhong, LoaiPhong loaiPhong, Enum_TrangThai trangThai) {
		super();
		this.maPhong = maPhong;
		this.loaiPhong = loaiPhong;
		this.trangThai = trangThai;
	}
	
	public Phong(String maPhong, Enum_TrangThai trangThai) {
		super();
		this.maPhong = maPhong;
		this.trangThai = trangThai;
	}

	public Phong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public Enum_TrangThai getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Enum_TrangThai trangThai) {
		this.trangThai = trangThai;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(maPhong);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phong other = (Phong) obj;
		return Objects.equals(maPhong, other.maPhong);
	}

	@Override
	public String toString() {
		return String.format("Phong [maPhong=%s, loaiPhong=%s, trangThai=%s]", maPhong, loaiPhong, trangThai);
	}

}
