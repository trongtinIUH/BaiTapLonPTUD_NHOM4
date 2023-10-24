package entity;

import java.io.Serializable;
import java.util.Objects;

public class ChiTietDichVu  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maChiTietDichVu;
	private HoaDonDatPhong hoaDon;
	private SanPham sanPham;
	private int soLuong;
	private double gia;
	
	public ChiTietDichVu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChiTietDichVu(String maChiTietDichVu, HoaDonDatPhong hoaDon, SanPham sanPham, int soLuong, double gia) {
		super();
		this.maChiTietDichVu = maChiTietDichVu;
		this.hoaDon = hoaDon;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
		this.gia = gia;
	}

	public String getMaChiTietDichVu() {
		return maChiTietDichVu;
	}

	public void setMaChiTietDichVu(String maChiTietDichVu) {
		this.maChiTietDichVu = maChiTietDichVu;
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

	@Override
	public int hashCode() {
		return Objects.hash(maChiTietDichVu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietDichVu other = (ChiTietDichVu) obj;
		return Objects.equals(maChiTietDichVu, other.maChiTietDichVu);
	}

	@Override
	public String toString() {
		return String.format("ChiTietDichVu [maChiTietDichVu=%s, hoaDon=%s, sanPham=%s, soLuong=%s, gia=%s]",
				maChiTietDichVu, hoaDon, sanPham, soLuong, gia);
	}
	
	
	
}
