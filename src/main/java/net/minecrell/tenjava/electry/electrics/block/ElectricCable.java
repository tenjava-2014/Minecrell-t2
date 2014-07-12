package net.minecrell.tenjava.electry.electrics.block;

import net.minecrell.tenjava.electry.electrics.registry.Electric;

import org.bukkit.Location;

public abstract class ElectricCable extends ElectricTransporter {
    protected ElectricCable(Location location, Electric type) {
        super(location, type);
    }
}
