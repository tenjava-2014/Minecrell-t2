package net.minecrell.tenjava.electry.listeners;

import net.minecrell.tenjava.electry.Electry;

import com.google.common.base.Preconditions;

import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

public abstract class AbstractListener implements Listener {
    private final Electry plugin;

    protected AbstractListener(Electry plugin) {
        this.plugin = Preconditions.checkNotNull(plugin, "plugin");
    }

    public Electry getPlugin() {
        return plugin;
    }

    public void register() {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void unregister() {
        HandlerList.unregisterAll(this);
    }
}
