package net.minecrell.tenjava.electry.electrics.block;

import net.minecrell.tenjava.electry.electrics.registry.Electric;

import org.bukkit.block.Block;

public abstract class ElectricCable extends ElectricTransporter {
    protected ElectricCable(Block block, Electric type) {
        super(block, type);
    }
}
