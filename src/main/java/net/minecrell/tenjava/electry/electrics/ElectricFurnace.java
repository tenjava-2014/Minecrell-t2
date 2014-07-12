package net.minecrell.tenjava.electry.electrics;

import net.minecrell.tenjava.electry.electrics.block.ElectricConsumer;
import net.minecrell.tenjava.electry.electrics.registry.DefaultElectric;

import org.bukkit.Location;

public class ElectricFurnace extends ElectricConsumer {
    public ElectricFurnace(Location location) {
        super(location, DefaultElectric.ELECTRIC_FURNACE);
    }

    @Override
    public int getConsumption() {
        return 0;
    }
}
