package utils;

public enum Device {

    //burada hangi cihaz aracığıyla test yapacağız

    HUAWEI("L2N4C19923015627","11","P30 lite","Android");

    protected String udid;
    protected String version;
    protected String deviceName;
    protected String platformName;

    Device(String udid, String version, String deviceName, String platformName) {
        this.udid = "";
        this.version = "";
        this.deviceName = "";
        this.platformName = "";
    }


}
