package net.minecrell.tenjava.electry.electrics.block;

import net.minecrell.tenjava.electry.electrics.registry.Electric;

import org.bukkit.Location;

public abstract class ElectricGenerator extends ElectricBlock {
    protected ElectricGenerator(Location location, Electric type) {
        super(location, type);
    }

    public abstract int getEfficiency();
}
