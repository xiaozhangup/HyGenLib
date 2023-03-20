package me.xiaozhangup.hygen.items;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemBuilder {
    Component displayname;
    List<Component> lores;
    Material material;
    int customId;

    public ItemBuilder(ItemStack itemStack) {
        this.displayname = itemStack.displayName();
        this.lores = itemStack.lore();
        this.material = itemStack.getType();

        if (itemStack.hasItemMeta() && itemStack.getItemMeta().hasCustomModelData()) {
            this.customId = itemStack.getItemMeta().getCustomModelData();
        }
    }

    public ItemBuilder(Material material) {
        this.material = material;
    }

    public ItemBuilder() {}

    public ItemBuilder material(Material material) {
        this.material = material;
        return this;
    }

    public ItemBuilder name(Component component) {
        this.displayname = component;
        return this;
    }

    public ItemBuilder name(String name) {
        this.displayname = MiniMessage.miniMessage().deserialize(name);
        return this;
    }

    public ItemBuilder lores(List<Component> lores) {
        this.lores = lores;
        return this;
    }

    public ItemBuilder lores(Component... lores) {
        this.lores = Arrays.stream(lores).toList();
        return this;
    }

    public ItemBuilder lores(String... lores) {
        List<Component> lore = new ArrayList<>();
        MiniMessage mm = MiniMessage.miniMessage();
        for (String s : lores) {
            lore.add(mm.deserialize(s));
        }
        this.lores = lore;
        return this;
    }

    public ItemBuilder addLores(List<Component> lores) {
        this.lores.addAll(lores);
        return this;
    }

    public ItemBuilder addLores(Component... lores) {
        this.lores.addAll(Arrays.stream(lores).toList());
        return this;
    }

    public ItemBuilder addLores(String... lores) {
        List<Component> lore = new ArrayList<>();
        MiniMessage mm = MiniMessage.miniMessage();
        for (String s : lores) {
            lore.add(mm.deserialize(s));
        }
        this.lores.addAll(lore);
        return this;
    }

    public ItemBuilder custom(int id) {
        this.customId = id;
        return this;
    }

    public ItemStack build() {
        ItemStack itemStack = new ItemStack(this.material);
        var itemMeta = itemStack.getItemMeta();
        itemMeta.displayName(this.displayname);
        itemMeta.lore(this.lores);
        itemMeta.setCustomModelData(this.customId);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

}
