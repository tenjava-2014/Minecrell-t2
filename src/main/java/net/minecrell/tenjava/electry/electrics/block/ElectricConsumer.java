package net.minecrell.tenjava.electry.electrics.block;

import net.minecrell.tenjava.electry.electrics.registry.Electric;

import org.bukkit.Location;

public abstract class ElectricConsumer extends ElectricBlock {
    private int consumption;

    protected ElectricConsumer(Location location, Electric type) {
        super(location, type);
    }

    public abstract int getConsumption();
}
