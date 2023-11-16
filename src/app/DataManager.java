package app;

import java.util.ArrayList;

import entity.ChiTietDichVu;
import entity.TempThemDV;

public class DataManager {

	private static String userName;
	private static boolean thanhToan;
	private static boolean datPhong;
	private static String soDienThoaiKHDat = "";
    private static boolean chuyenPhong,datPhongCho,phongTrong;
    private static ArrayList<TempThemDV> ctdvTempList;
    private static double tongTienDV;
	private static boolean loadDV = false;

	public static boolean isLoadDV() {
		return loadDV;
	}

	public static void setLoadDV(boolean loadDV) {
		DataManager.loadDV = loadDV;
	}


	public static double getTongTienDV() {
		return tongTienDV;
	}

	public static void setTongTienDV(double tongTienDV) {
		DataManager.tongTienDV = tongTienDV;
	}

	public static ArrayList<TempThemDV> getCtdvTempList() {
		return ctdvTempList;
	}

	public static void setCtdvTempList(ArrayList<TempThemDV> ctdvTempList) {
		DataManager.ctdvTempList = ctdvTempList;
	}


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

	public static boolean isDatPhongCho() {
		return datPhongCho;
	}

	public static void setDatPhongCho(boolean datPhongCho) {
		DataManager.datPhongCho = datPhongCho;
	}

	public static boolean isChuyenPhongTrong() {
		return phongTrong;
	}

	public static void setChuyenPhongTrong(boolean phongTrong) {
		DataManager.phongTrong = phongTrong;
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