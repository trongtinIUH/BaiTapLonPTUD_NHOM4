package app;

public class DataManager {
    private static String userName;
    private static boolean chuyenPhong;
    private static boolean thanhToan;

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
    
    public static boolean isThanhToan() {
        return thanhToan;
    }

    public static void setThanhToan(boolean thanhToan) {
        DataManager.thanhToan = thanhToan;
    }
}