package entity;

import java.io.Serializable;
import java.sql.Date;

public class ChiTietLuong implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NhanVien nhanVien;
	private Date gioBatDauLam;
	private Date gioKetThucLam;
	private double soGioLam;
	private double tienLuong;
	private enum CaTruc {
		  Ca_Trưa,
		  Ca_Chiều, 
		  Ca_Tối 
		}
	 public CaTruc caTruc;
	public ChiTietLuong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietLuong(NhanVien nhanVien, Date gioBatDauLam, Date gioKetThucLam, double soGioLam, double tienLuong,
			CaTruc caTruc) {
		super();
		this.nhanVien = nhanVien;
		this.gioBatDauLam = gioBatDauLam;
		this.gioKetThucLam = gioKetThucLam;
		this.soGioLam = soGioLam;
		this.tienLuong = tienLuong;
		this.caTruc = caTruc;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public Date getGioBatDauLam() {
		return gioBatDauLam;
	}
	public void setGioBatDauLam(Date gioBatDauLam) {
		this.gioBatDauLam = gioBatDauLam;
	}
	public Date getGioKetThucLam() {
		return gioKetThucLam;
	}
	public void setGioKetThucLam(Date gioKetThucLam) {
		this.gioKetThucLam = gioKetThucLam;
	}
	public double getSoGioLam() {
		return soGioLam;
	}
	public void setSoGioLam(double soGioLam) {
		this.soGioLam = soGioLam;
	}
	public double getTienLuong() {
		return tienLuong;
	}

	
	
	public CaTruc getCaTruc() {
		return caTruc;
	}
	public void setCaTruc(CaTruc caTruc) {
		this.caTruc = caTruc;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return String.format(
				"ChiTietLuong [nhanVien=%s, gioBatDauLam=%s, gioKetThucLam=%s, soGioLam=%s, tienLuong=%s, caTruc=%s]",
				nhanVien, gioBatDauLam, gioKetThucLam, soGioLam, tienLuong, caTruc);
	}
	 
	

}
