package net.minecrell.tenjava.electry.electrics;

import net.minecrell.tenjava.electry.electrics.block.ElectricCable;
import net.minecrell.tenjava.electry.electrics.registry.DefaultElectric;

public class RedstoneCable extends ElectricCable {
    public RedstoneCable() {
        super(DefaultElectric.REDSTONE_CABLE);
    }
}
