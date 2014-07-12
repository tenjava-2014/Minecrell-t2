package net.minecrell.tenjava.electry.electrics;

import net.minecrell.tenjava.electry.electrics.block.ElectricConsumer;
import net.minecrell.tenjava.electry.electrics.registry.DefaultElectric;
import net.minecrell.tenjava.electry.electrics.registry.Electric;

public class ElectricFurnace extends ElectricConsumer {
    @Override
    public Electric getType() {
        return DefaultElectric.ELECTRIC_FURNACE;
    }
}
