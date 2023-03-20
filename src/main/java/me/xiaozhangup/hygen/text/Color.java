package me.xiaozhangup.hygen.text;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;

import static me.xiaozhangup.hygen.text.Convert.hex2RGB;

public class Color {

    String color;

    public Color(String color) {
        this.color = color;
    }

    public GradientColor gradient(String c2) {
        return new GradientColor(color, c2);
    }

    public String get() {
        return this.color;
    }

    public String mini(String text) {
        return "<color:" + color + ">" + text + "</color>";
    }

    public Component component(String text) {
        return Component.text(text).color(this.toColor());
    }

    public TextColor toColor() {
        var rgb = hex2RGB(this.color);
        return TextColor.color(rgb[0], rgb[1], rgb[2]);
    }

}
