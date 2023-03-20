package me.xiaozhangup.hygen.inv;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class BaseInvBuilder {

    InventoryHolder holder;
    ItemStack background;
    ItemStack head;
    ItemStack bottom;
    Component name = Component.text("");
    int size = 45;

    public BaseInvBuilder() {
    }

    public BaseInvBuilder name(Component name) {
        this.name = name;
        return this;
    }

    public BaseInvBuilder name(String name) {
        this.name = MiniMessage.miniMessage().deserialize(name);
        return this;
    }

    public BaseInvBuilder holder(InventoryHolder holder) {
        this.holder = holder;
        return this;
    }

    public BaseInvBuilder size(int size) {
        this.size = size;
        return this;
    }

    public BaseInvBuilder background(ItemStack itemStack) {
        this.background = itemStack;
        return this;
    }

    public BaseInvBuilder head(ItemStack itemStack) {
        this.head = itemStack;
        return this;
    }

    public BaseInvBuilder bottom(ItemStack itemStack) {
        this.bottom = itemStack;
        return this;
    }

    public Inventory build() {
        Inventory inventory = Bukkit.createInventory(this.holder, this.size, this.name);
        if (this.background != null) {
            for (int i = 0; i < inventory.getSize(); i++) {
                inventory.setItem(i, this.background);
            }
        }

        if (this.head != null) {
            for (int i = 0; i < 9; i++) {
                inventory.setItem(i, this.head);
            }
        }

        if (this.bottom != null) {
            for (int i = (inventory.getSize() - 9); i < inventory.getSize(); i++) {
                inventory.setItem(i, this.bottom);
            }
        }

        return inventory;
    }

}
