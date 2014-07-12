package net.minecrell.tenjava.electry.electrics.block;

import net.minecrell.tenjava.electry.electrics.registry.Electric;

import org.bukkit.block.Block;

public abstract class ElectricTransporter extends ElectricBlock {
    protected ElectricTransporter(Block block, Electric type) {
        super(block, type);
    }
}
