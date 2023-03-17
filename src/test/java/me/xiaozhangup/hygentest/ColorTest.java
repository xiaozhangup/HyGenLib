package me.xiaozhangup.hygentest;

import me.xiaozhangup.hygen.net.InternetString;
import me.xiaozhangup.hygen.net.RepetitionInternetString;
import me.xiaozhangup.hygen.text.Color;
import me.xiaozhangup.hygen.text.GradientColor;
import org.junit.jupiter.api.Test;

public class ColorTest {

    @Test
    public void run() {
        var colorg = new GradientColor("#ffffff", "#000000").step(100);
        System.out.println(colorg.color(10));

        var color = new Color("#ffffff");
        System.out.println(color.use("草"));
    }

    @Test
    public void runInternet() {
//        var internat = new InternetString("https://github.com/HAPPYLAND-Dev/PluginFastTemplate/");
//        System.out.println(internat.request());

        var ir = new RepetitionInternetString("https://github.com/HAPPYLAND-Dev/{name}", "{name}");
        System.out.println(ir.request("HayerQuest"));
        System.out.println(ir.request(".github"));
    }

}
