package utils;

public enum App {

    //Hangi uygulamayı test edeceğimizi belirtiyoruz.
    CALCULATOR("com.android.calculator2","Calculator");

    protected String appPackage;  //uygulamanın package adı ve activity adını tutuyor.
    protected String appActivity;


App(String appPackage, String appActivity) {
        this.appPackage = appPackage;
        this.appActivity = appActivity;
    }


}
