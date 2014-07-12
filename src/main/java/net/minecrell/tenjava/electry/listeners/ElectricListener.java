package net.minecrell.tenjava.electry.listeners;

import net.minecrell.tenjava.electry.Electry;
import net.minecrell.tenjava.electry.Items;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class ElectricListener extends AbstractListener {
    public ElectricListener(Electry plugin) {
        super(plugin);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        ItemStack item = event.getItemInHand();
        if (Items.isElectryItem(item)) {
            event.getPlayer().sendMessage("You have placed an electry item!");
        }
    }
}
