package net.minecrell.tenjava.electry.electrics;

import net.minecrell.tenjava.electry.electrics.block.ElectricGenerator;
import net.minecrell.tenjava.electry.electrics.registry.DefaultElectric;
import net.minecrell.tenjava.electry.electrics.registry.Electric;

public class SolarCell extends ElectricGenerator {
    private int lightLevel;

    public SolarCell(Electric type) {
        super(DefaultElectric.SOLAR_CELL);
    }

    public int getLightLevel() {
        return lightLevel;
    }
}
