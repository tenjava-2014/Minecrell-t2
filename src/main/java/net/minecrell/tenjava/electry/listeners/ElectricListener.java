package net.minecrell.tenjava.electry.listeners;

import net.minecrell.tenjava.electry.Electry;
import net.minecrell.tenjava.electry.Items;
import net.minecrell.tenjava.electry.electrics.RedstoneCable;
import net.minecrell.tenjava.electry.storage.ElectricMetaStorage;

import org.bukkit.Chunk;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.inventory.ItemStack;

public class ElectricListener extends AbstractListener {
    public ElectricListener(Electry plugin) {
        super(plugin);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        ItemStack item = event.getItemInHand();
        if (Items.isElectryItem(item)) {
            BlockState state = event.getBlockPlaced().getState();
            state.setMetadata(Items.META_ID, new ElectricMetaStorage<>(plugin, new RedstoneCable()));
            event.getPlayer().sendMessage("You have placed an electry item!");
        }
    }

    @EventHandler
    public void onWorldSave(WorldSaveEvent event) {
        plugin.getLogger().info("Saving Electry blocks...");
        // TODO: Save to disk
        for (Chunk chunk : event.getWorld().getLoadedChunks()) {
            for (BlockState state : chunk.getTileEntities()) {
                if (state.hasMetadata(Items.META_ID)) {
                    plugin.getLogger().info("Yay!!");
                }
            }
        }
    }
}
