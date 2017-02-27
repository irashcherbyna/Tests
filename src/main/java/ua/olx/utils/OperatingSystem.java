package ua.olx.utils;

public class OperatingSystem {

    private static String path = null;

    public static String getChromeDriverPath() {
        if(isWindows()){
            path = LoadProperties.getProperty("chrome_windows");
        }else if(isMac()){
            path =  LoadProperties.getProperty("chrome_mac");
        }else {
            path = LoadProperties.getProperty("chrome_linux");
        }
        return path;
    }

    public static String getIEDriverPath() {
        return path = LoadProperties.getProperty("ie_windows");
    }

    private static boolean isWindows(){
        String os = System.getProperty("os.name").toLowerCase();
        return (os.indexOf( "win" ) >= 0);
    }

    private static boolean isMac(){
        String os = System.getProperty("os.name").toLowerCase();
        return (os.indexOf( "mac" ) >= 0);
    }

    private static boolean isLinux(){
        String os = System.getProperty("os.name").toLowerCase();
        return (os.indexOf( "nix") >=0 || os.indexOf( "nux") >=0);
    }

}
