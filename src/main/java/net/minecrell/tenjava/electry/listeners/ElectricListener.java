package net.minecrell.tenjava.electry.listeners;

import net.minecrell.tenjava.electry.Electry;
import net.minecrell.tenjava.electry.Items;
import net.minecrell.tenjava.electry.electrics.RedstoneCable;
import net.minecrell.tenjava.electry.storage.ElectricMetaStorage;

import org.bukkit.Chunk;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.inventory.ItemStack;

public class ElectricListener extends AbstractListener {
    public ElectricListener(Electry plugin) {
        super(plugin);
    }

    @EventHandler(ignoreCancelled = true)
    public void onBlockPlace(BlockPlaceEvent event) {
        ItemStack item = event.getItemInHand();
        if (Items.isElectryItem(item)) {
            BlockState state = event.getBlockPlaced().getState();
            state.setMetadata(Items.META_ID, new ElectricMetaStorage<>(plugin,
                    plugin.getRegistry().forItem(event.getItemInHand().getType())));
            event.getPlayer().sendMessage("You have placed an Electry item!");
        }
    }

    private void save(Chunk chunk) {
        save(chunk, false);
    }

    private void save(Chunk chunk, boolean unload) {
        for (BlockState state : chunk.getTileEntities()) {
            if (state.hasMetadata(Items.META_ID)) {
                plugin.getLogger().fine("Saving: " + state.getBlock().getLocation());
                // TODO: Save to disk
                if (unload) {
                    plugin.getLogger().fine("And unloaded!");
                    state.removeMetadata(Items.META_ID, plugin);
                }
            }
        }
    }

    @EventHandler
    public void onChunkLoad(ChunkLoadEvent event) {
        // TODO: Load from disk
    }

    @EventHandler(ignoreCancelled = true)
    public void onChunkUnload(ChunkUnloadEvent event) {
        save(event.getChunk(), true);
    }

    @EventHandler
    public void onWorldSave(WorldSaveEvent event) {
        plugin.getLogger().info("Saving electrics...");
        for (Chunk chunk : event.getWorld().getLoadedChunks())
            save(chunk);
        plugin.getLogger().info("Done!");
    }
}
