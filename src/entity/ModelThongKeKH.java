package entity;

public class ModelThongKeKH {
	private String maKH;
	private String tenKH;
	private double TongSoGioHat;
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public double getTongSoGioHat() {
		return TongSoGioHat;
	}
	public void setTongSoGioHat(double tongSoGioHat) {
		TongSoGioHat = tongSoGioHat;
	}
	public ModelThongKeKH(String maKH, String tenKH, double tongSoGioHat) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		TongSoGioHat = tongSoGioHat;
	}
	public ModelThongKeKH() {
		super();
	}
	@Override
	public String toString() {
		return "ModelThongKeKH [maKH=" + maKH + ", tenKH=" + tenKH + ", TongSoGioHat=" + TongSoGioHat + "]";
	}
	
	
}
