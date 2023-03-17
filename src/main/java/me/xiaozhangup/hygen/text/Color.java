package me.xiaozhangup.hygen.text;

public class Color {

    String color;

    public Color(String color) {
        this.color = color;
    }

    public GradientColor gradient(String c2) {
        return new GradientColor(color, c2);
    }

    public String use(String text) {
        return "<color:" + color + ">" + text + "</color>";
    }

}
