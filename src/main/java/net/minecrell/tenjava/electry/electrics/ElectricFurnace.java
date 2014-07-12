package net.minecrell.tenjava.electry.electrics;

import net.minecrell.tenjava.electry.electrics.block.ElectricConsumer;
import net.minecrell.tenjava.electry.electrics.registry.DefaultElectric;

public class ElectricFurnace extends ElectricConsumer {
    public ElectricFurnace() {
        super(DefaultElectric.ELECTRIC_FURNACE);
    }
}
