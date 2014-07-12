package net.minecrell.tenjava.electry;

import net.minecrell.tenjava.electry.electrics.base.Electrics;
import net.minecrell.tenjava.electry.listeners.ElectricListener;

import org.bukkit.plugin.java.JavaPlugin;

public class Electry extends JavaPlugin {
    @Override
    public void onEnable() {
        Electrics.registerRecipes(this.getServer());
        new ElectricListener(this).register();

        // For the people complaining about such messages: CraftBukkit does only display that it IS enabling the
        // plugin and not that the plugin was SUCCESSFULLY enabled. Therefore this message just says that the
        // configuration and everything was successfully loaded and not only the plugin.
        this.getLogger().info(this.getDescription().getFullName() + " enabled.");
    }

    @Override
    public void onDisable() {
        this.getLogger().info(this.getDescription().getFullName() + " disabled.");
    }
}
