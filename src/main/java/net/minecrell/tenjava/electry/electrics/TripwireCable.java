package net.minecrell.tenjava.electry.electrics;

import net.minecrell.tenjava.electry.electrics.block.ElectricCable;
import net.minecrell.tenjava.electry.electrics.registry.DefaultElectric;

import org.bukkit.Location;

public class TripwireCable extends ElectricCable {
    public TripwireCable(Location location) {
        super(location, DefaultElectric.TRIPWIRE_CABLE);
    }
}
