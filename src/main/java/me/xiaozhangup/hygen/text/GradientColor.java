package me.xiaozhangup.hygen.text;

import java.util.ArrayList;
import java.util.List;

public class GradientColor {

    List<String> colors;
    String c1;
    String c2;

    public GradientColor(String c1, String c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public GradientColor step(int number) {
        var a = hex2RGB(c1);
        var b = hex2RGB(c2);

        List<String> colors = new ArrayList<>();

        for (int i = 0; i < number; i++){
            int aR = a[0];
            int aG = a[1];
            int aB = a[2];
            int bR = b[0];
            int bG = b[1];
            int bB = b[2];

            colors.add(rgb2Hex(
                    calculateColor(aR, bR, number - 1, i),
                    calculateColor(aG, bG, number - 1, i),
                    calculateColor(aB, bB, number - 1, i)
            ));
        }

        this.colors = colors;
        return this;
    }

    public String color(int level) {
        return colors.get(level);
    }

    private int calculateColor(int a, int b, int step, int number) {
        return a + (b-a) * number / step;
    }

    private String rgb2Hex(int r,int g,int b){
        return String.format("#%02X%02X%02X", r,g,b);
    }

    private int[] hex2RGB(String hexStr){
        if(hexStr != null && hexStr.length() == 7){
            int[] rgb = new int[3];
            rgb[0] = Integer.valueOf(hexStr.substring( 1, 3 ), 16);
            rgb[1] = Integer.valueOf(hexStr.substring( 3, 5 ), 16);
            rgb[2] = Integer.valueOf(hexStr.substring( 5, 7 ), 16);
            return rgb;
        }
        return null;
    }

}
