package net.minecrell.tenjava.electry.electrics.block;

import net.minecrell.tenjava.electry.electrics.registry.Electric;

import org.bukkit.block.Block;

public abstract class ElectricGenerator extends ElectricBlock {
    protected ElectricGenerator(Block block, Electric type) {
        super(block, type);
    }

    public abstract int getEfficiency();
}
