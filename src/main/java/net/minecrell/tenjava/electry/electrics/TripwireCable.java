package net.minecrell.tenjava.electry.electrics;

import net.minecrell.tenjava.electry.electrics.block.ElectricCable;
import net.minecrell.tenjava.electry.electrics.registry.DefaultElectric;

public class TripwireCable extends ElectricCable {
    public TripwireCable() {
        super(DefaultElectric.TRIPWIRE_CABLE);
    }
}
