package me.xiaozhangup.hygentest;

import me.xiaozhangup.hygen.items.SkullBuilder;
import me.xiaozhangup.hygen.net.RepeatableInterString;
import me.xiaozhangup.hygen.text.Color;
import me.xiaozhangup.hygen.text.GradientColor;
import org.junit.jupiter.api.Test;

public class ColorTest {

    @Test
    public void run() {
    }

    @Test
    public void runInternet() {
//        var internat = new InternetString("https://github.com/HAPPYLAND-Dev/PluginFastTemplate/");
//        System.out.println(internat.request());

        var ir = new RepeatableInterString("https://github.com/HAPPYLAND-Dev/{name}", "{name}");
        System.out.println(ir.request("HayerQuest"));
        System.out.println(ir.request(".github"));
    }

}
