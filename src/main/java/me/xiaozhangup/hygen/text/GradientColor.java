package me.xiaozhangup.hygen.text;

import java.util.ArrayList;
import java.util.List;

import static me.xiaozhangup.hygen.text.Convert.hex2RGB;
import static me.xiaozhangup.hygen.text.Convert.rgb2Hex;

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

        for (int i = 0; i < number; i++) {
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

    public Color color(int level) {
        return new Color(colors.get(level));
    }

    private int calculateColor(int a, int b, int step, int number) {
        return a + (b - a) * number / step;
    }

}
