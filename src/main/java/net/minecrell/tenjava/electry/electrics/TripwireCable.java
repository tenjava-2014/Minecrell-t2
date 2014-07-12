package net.minecrell.tenjava.electry.electrics;

import net.minecrell.tenjava.electry.electrics.block.ElectricCable;
import net.minecrell.tenjava.electry.electrics.registry.DefaultElectric;

import org.bukkit.block.Block;

public class TripwireCable extends ElectricCable {
    public TripwireCable(Block block) {
        super(block, DefaultElectric.TRIPWIRE_CABLE);
    }
}
