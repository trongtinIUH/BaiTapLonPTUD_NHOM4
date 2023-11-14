package app;

public class DataManager {
	private static String userName;
	private static boolean chuyenPhong;
	private static boolean datPhong;
	private static String soDienThoaiKHDat = "";

	public static String getSoDienThoaiKHDat() {
		return soDienThoaiKHDat;
	}

	public static void setSoDienThoaiKHDat(String soDienThoaiKHDat) {
		DataManager.soDienThoaiKHDat = soDienThoaiKHDat;
	}

	public static boolean isDatPhong() {
		return datPhong;
	}

	public static void setDatPhong(boolean datPhong) {
		DataManager.datPhong = datPhong;
	}

	public static boolean isChuyenPhong() {
		return chuyenPhong;
	}

	public static void setChuyenPhong(boolean chuyenPhong) {
		DataManager.chuyenPhong = chuyenPhong;
	}

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		DataManager.userName = userName;
	}
}