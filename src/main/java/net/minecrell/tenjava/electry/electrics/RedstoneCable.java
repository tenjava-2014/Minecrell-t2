package net.minecrell.tenjava.electry.electrics;

import net.minecrell.tenjava.electry.electrics.block.ElectricCable;
import net.minecrell.tenjava.electry.electrics.registry.DefaultElectric;
import net.minecrell.tenjava.electry.electrics.registry.Electric;

public class RedstoneCable extends ElectricCable {
    public RedstoneCable() {
        super(DefaultElectric.REDSTONE_CABLE);
    }
}
