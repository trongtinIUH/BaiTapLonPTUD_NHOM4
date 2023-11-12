package app;

public class DataManager {
    private static String userName;
    private static boolean chuyenPhong,datPhongCho;

    public static boolean isChuyenPhong() {
		return chuyenPhong;
	}

	public static void setChuyenPhong(boolean chuyenPhong) {
		DataManager.chuyenPhong = chuyenPhong;
	}
    public static boolean isDatPhongCho() {
		return datPhongCho;
	}
	public static void setDatPhongCho(boolean datPhongCho) {
		DataManager.datPhongCho = datPhongCho;
	}
	public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        DataManager.userName = userName;
    }
}