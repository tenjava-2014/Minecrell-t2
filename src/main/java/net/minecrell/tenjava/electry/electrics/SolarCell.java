package net.minecrell.tenjava.electry.electrics;

import net.minecrell.tenjava.electry.Items;
import net.minecrell.tenjava.electry.electrics.block.ElectricGenerator;
import net.minecrell.tenjava.electry.electrics.registry.DefaultElectric;

import java.util.Set;

import com.google.common.collect.Sets;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.ItemStack;

public class SolarCell extends ElectricGenerator {
    public static final int MAX_LIGHT_LEVEL = 15;
    private static final Set<BlockFace> LOOKUP_FURNACE = Sets.immutableEnumSet(BlockFace.DOWN, BlockFace.NORTH,
            BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST);

    public SolarCell(Location location) {
        super(location, DefaultElectric.SOLAR_CELL);
    }

    @Override
    public int getEfficiency() {
        return (int) (this.getLightLevel() * 1000d);
    }

    public double getLightLevel() {
        Block block = this.getBlock();
        if (block.getWorld().getTime() > 14000) return 0;
        double skyLevel = (double) block.getLightFromSky() / MAX_LIGHT_LEVEL;
        double lightLevel = (double) block.getLightLevel() / MAX_LIGHT_LEVEL;
        return skyLevel * lightLevel;
    }

    public void tick() {
        Block block = this.getBlock();
        int energy = this.getEfficiency();

        for (BlockFace lookup : LOOKUP_FURNACE) {
            if (energy < 500) return;
            ElectricFurnace furnace = Items.getSafely(block.getRelative(lookup));
            if (furnace != null) {
                FurnaceInventory inv = furnace.getFurnace().getInventory();
                ItemStack fuel = inv.getFuel();
                if (fuel == null || fuel.getType() == Material.REDSTONE) {
                    furnace.getFurnace().getInventory().setFuel(new ItemStack(Material.REDSTONE_BLOCK));
                    energy -= 500;
                }
            }
        }
    }
}
