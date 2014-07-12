package net.minecrell.tenjava.electry.electrics;

import net.minecrell.tenjava.electry.electrics.block.ElectricConsumer;
import net.minecrell.tenjava.electry.electrics.registry.DefaultElectric;

import org.bukkit.block.Block;

public class ElectricFurnace extends ElectricConsumer {
    public ElectricFurnace(Block block) {
        super(block, DefaultElectric.ELECTRIC_FURNACE);
    }

    @Override
    public int getConsumption() {
        return 0;
    }
}
