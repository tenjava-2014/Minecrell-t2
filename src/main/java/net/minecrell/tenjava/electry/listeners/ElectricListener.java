package net.minecrell.tenjava.electry.listeners;

import net.minecrell.tenjava.electry.Electry;
import net.minecrell.tenjava.electry.Items;
import net.minecrell.tenjava.electry.electrics.SolarCell;
import net.minecrell.tenjava.electry.electrics.block.ElectricBlock;
import net.minecrell.tenjava.electry.storage.RuntimeMetaStorage;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
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
            Block block = event.getBlockPlaced();
            BlockState state = block.getState();
            ElectricBlock electric = plugin.getRegistry().forItem(event.getItemInHand().getType(),
                    block.getLocation());
            state.setMetadata(Items.META_ID, new RuntimeMetaStorage<>(plugin, electric));
            if (electric instanceof SolarCell) {
                Bukkit.getScheduler().runTaskTimer(plugin, ((SolarCell) electric)::tick, 0, 20);
            }
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

    @EventHandler(ignoreCancelled = true)
    public void onBlockClick(PlayerInteractEvent event) {
        if (!event.hasBlock()) return;
        if (event.getClickedBlock().hasMetadata(Items.META_ID)) {
            ElectricBlock block = Items.get(event.getClickedBlock());
            if (block instanceof SolarCell) {
                event.getPlayer().sendMessage("Efficiency: " + ((SolarCell) block).getEfficiency());
            }
            event.getPlayer().sendMessage("That is a " + block.getType().getName());
        }
    }
}
