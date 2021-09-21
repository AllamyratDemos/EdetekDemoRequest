package Utils;

public class Helpers {

    public static String Title(){
       return Driver.get().getTitle();
    }

    public static void CurrentUrl(){
        Driver.get().getCurrentUrl();
    }

    public static void navigate(String url){
        Driver.get().navigate().to(url);
    }
}
