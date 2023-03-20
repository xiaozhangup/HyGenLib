package me.xiaozhangup.hygen.items;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public class SkullBuilder extends ItemBuilder {

    String base64;
    String player;

    public SkullBuilder base64(String base64) {
        this.base64 = base64;
        return this;
    }

    public SkullBuilder player(String name) {
        this.player = name;
        return this;
    }

    public SkullBuilder player(Player player) {
        this.player = player.getName();
        return this;
    }

    @Override
    public ItemStack build() {
        ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta itemMeta = (SkullMeta) itemStack.getItemMeta();
        itemMeta.displayName(this.displayname);
        itemMeta.lore(this.lores);
        itemMeta.setCustomModelData(this.customId);

        if (this.base64 != null) {
            GameProfile profile = new GameProfile(UUID.randomUUID(), "");
            profile.getProperties().put("textures", new Property("textures",
                    this.base64));
            Field profileField;
            try {
                profileField = itemMeta.getClass().getDeclaredField("profile");
                profileField.setAccessible(true);
                profileField.set(itemMeta, profile);
            } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
                return null;
            }
        } else if (this.player != null) {
            itemMeta.setOwningPlayer(Bukkit.getOfflinePlayer(this.player));
        }

        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
