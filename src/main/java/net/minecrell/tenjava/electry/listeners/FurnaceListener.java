package net.minecrell.tenjava.electry.listeners;

import net.minecrell.tenjava.electry.Electry;
import net.minecrell.tenjava.electry.Items;
import net.minecrell.tenjava.electry.electrics.ElectricFurnace;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.FurnaceBurnEvent;

public class FurnaceListener extends AbstractListener {
    public FurnaceListener(Electry plugin) {
        super(plugin);
    }

    @EventHandler
    public void onFurnaceBurn(FurnaceBurnEvent event) {
        Block block = event.getBlock();
        ElectricFurnace furnace = Items.getSafely(block);
        if (furnace == null) return;
        if (event.getFuel().getType() == Material.REDSTONE_BLOCK) {
            event.setBurnTime(20);
            event.setBurning(true);
        } else event.setCancelled(true);
    }
}
