package name.yluo.SmartBioViewer;

import android.graphics.Color;

public class CustomColor {
//    private static int color = Color.rgb(218, 0,41);
    private static int num = 0;
    private static int r = 0;
    private static int g = 218;
    private static int b = 0x29;

    public static int getNum() {
        return num;
    }

    public static int getColor(int i) {
        num = i;
        return calcColor(i);
    }

    private static int calcColor(int i) {
        if(i > 1000) i = 1000;
        if(i < 0) i = 0;
        r = (int) ((float)i*0.001*218);
        g = (int) ((float)(1000.0 - i)*0.001* 218);
        b = 0x29;
        return  Color.rgb(r, g, b);
    }

    public static int getDarkColor() {
        return Color.rgb(r, g, b);
    }

    public static int getTransColor() {
        return Color.argb(144, r, g, b);
    }
}
