package me.xiaozhangup.hygen.text;

import net.kyori.adventure.text.Component;

public class Convert {

    @Deprecated
    public static String color(String text) {
        return text.replace("&", "§");
    }

    @Deprecated
    public static String remove(String text) {
        return text.replace("§", "");
    }

    public static Component component(String text) {
        return Component.text(remove(text));
    }

    public static String rgb2Hex(int r, int g, int b) {
        return String.format("#%02X%02X%02X", r, g, b);
    }

    public static int[] hex2RGB(String hexStr) {
        if (hexStr != null && hexStr.length() == 7) {
            int[] rgb = new int[3];
            rgb[0] = Integer.valueOf(hexStr.substring(1, 3), 16);
            rgb[1] = Integer.valueOf(hexStr.substring(3, 5), 16);
            rgb[2] = Integer.valueOf(hexStr.substring(5, 7), 16);
            return rgb;
        }
        return null;
    }

}
