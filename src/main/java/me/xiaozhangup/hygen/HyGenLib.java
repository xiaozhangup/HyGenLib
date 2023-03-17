package me.xiaozhangup.hygen;

import org.bukkit.Bukkit;

public class HyGenLib {

    //Print server info message to console
    //This is useless, so don't do that!
    public static void printInfo() {
        Bukkit.getLogger().info(
                "\n" +
                        Bukkit.getVersion() + "\n" +
                        Bukkit.getMinecraftVersion() + "\n" +
                        Bukkit.getBukkitVersion() + "\n" +
                        Bukkit.getPluginsFolder()
        );
    }

}
