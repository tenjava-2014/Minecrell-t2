package net.minecrell.tenjava.electry.electrics;

import net.minecrell.tenjava.electry.electrics.block.ElectricConsumer;
import net.minecrell.tenjava.electry.electrics.registry.DefaultElectric;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Furnace;
import org.bukkit.inventory.ItemStack;

public class ElectricFurnace extends ElectricConsumer {
    public ElectricFurnace(Location location) {
        super(location, DefaultElectric.ELECTRIC_FURNACE);
        this.getFurnace().getInventory().setFuel(new ItemStack(Material.REDSTONE));
    }

    public Furnace getFurnace() {
        return (Furnace) this.getBlock().getState();
    }

    @Override
    public int getConsumption() {
        return this.getFurnace().getBurnTime() > 0 ? 500 : 0;
    }
}
