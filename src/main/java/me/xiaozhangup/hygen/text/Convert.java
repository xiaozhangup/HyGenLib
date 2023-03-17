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

}
