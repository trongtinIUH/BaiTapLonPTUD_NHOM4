package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ChiTietHoaDon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HoaDonDatPhong hoaDon;
	private Phong phong;
	private Date gioNhanPhong;
	private Date gioTraPhong;
	private double soGioHat;
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
	public Date getGioNhanPhong() {
		return gioNhanPhong;
	}
	public void setGioNhanPhong(Date gioNhanPhong) {
		this.gioNhanPhong = gioNhanPhong;
	}
	public Date getGioTraPhong() {
		return gioTraPhong;
	}
	public void setGioTraPhong(Date gioTraPhong) {
		this.gioTraPhong = gioTraPhong;
	}
	public double getSoGioHat() {
		return soGioHat;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public ChiTietHoaDon(HoaDonDatPhong hoaDon, Phong phong, Date gioNhanPhong, Date gioTraPhong, double soGioHat) {
		super();
		this.hoaDon = hoaDon;
		this.phong = phong;
		this.gioNhanPhong = gioNhanPhong;
		this.gioTraPhong = gioTraPhong;
		this.soGioHat = soGioHat;
	}
	public ChiTietHoaDon() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(gioNhanPhong, gioTraPhong, hoaDon, phong, soGioHat);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDon other = (ChiTietHoaDon) obj;
		return Objects.equals(gioNhanPhong, other.gioNhanPhong) && Objects.equals(gioTraPhong, other.gioTraPhong)
				&& Objects.equals(hoaDon, other.hoaDon) && Objects.equals(phong, other.phong)
				&& Double.doubleToLongBits(soGioHat) == Double.doubleToLongBits(other.soGioHat);
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [hoaDon=" + hoaDon + ", phong=" + phong + ", gioNhanPhong=" + gioNhanPhong
				+ ", gioTraPhong=" + gioTraPhong + ", soGioHat=" + soGioHat + "]";
	}
	
}
