package net.minecrell.tenjava.electry.electrics;

import net.minecrell.tenjava.electry.electrics.block.ElectricCable;
import net.minecrell.tenjava.electry.electrics.registry.DefaultElectric;

import org.bukkit.block.Block;

public class RedstoneCable extends ElectricCable {
    public RedstoneCable(Block block) {
        super(block, DefaultElectric.REDSTONE_CABLE);
    }
}
