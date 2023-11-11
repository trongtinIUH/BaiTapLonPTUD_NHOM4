package app;

public class DataManager {
    private static String userName;

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        DataManager.userName = userName;
    }
}