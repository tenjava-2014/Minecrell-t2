package net.minecrell.tenjava.electry.electrics;

import net.minecrell.tenjava.electry.electrics.block.ElectricGenerator;
import net.minecrell.tenjava.electry.electrics.registry.DefaultElectric;

import org.bukkit.block.Block;

public class SolarCell extends ElectricGenerator {
    public SolarCell(Block block) {
        super(block, DefaultElectric.SOLAR_CELL);
    }

    @Override
    public int getEfficiency() {
        return this.getLightLevel() * 10;
    }

    public int getLightLevel() {
        return block.getLightFromSky();
    }
}
