package net.minecrell.tenjava.electry.electrics;

import net.minecrell.tenjava.electry.electrics.block.ElectricCable;
import net.minecrell.tenjava.electry.electrics.registry.DefaultElectric;

import org.bukkit.Location;

public class RedstoneCable extends ElectricCable {
    public RedstoneCable(Location location) {
        super(location, DefaultElectric.REDSTONE_CABLE);
    }
}
