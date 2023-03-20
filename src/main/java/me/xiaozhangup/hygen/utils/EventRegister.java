package me.xiaozhangup.hygen.utils;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class EventRegister {

    private final ArrayList<Listener> listeners = new ArrayList<>();
    private final Plugin plugin;
    private boolean log = false;

    public EventRegister(Plugin plugin, boolean log) {
        this.plugin = plugin;
        this.log = log;
    }

    public EventRegister(Plugin plugin) {
        this.plugin = plugin;
    }

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    public void addListeners(Listener... listener) {
        listeners.addAll(Arrays.asList(listener));
    }

    public void addListeners(Collection<? extends Listener> listener) {
        listeners.addAll(listener);
    }

    public void register() {
        listeners.forEach(listener -> {
            Bukkit.getPluginManager().registerEvents(listener, this.plugin);
            if (this.log) {
                this.plugin.getLogger().info("Registration " + listener.getClass().getName() + "...");
            }
        });
        listeners.clear();
    }

}
