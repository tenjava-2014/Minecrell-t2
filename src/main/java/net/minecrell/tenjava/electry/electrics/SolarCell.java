package net.minecrell.tenjava.electry.electrics;

import net.minecrell.tenjava.electry.electrics.block.ElectricGenerator;
import net.minecrell.tenjava.electry.electrics.registry.DefaultElectric;

import org.bukkit.Location;
import org.bukkit.block.Block;

public class SolarCell extends ElectricGenerator {
    public static final int MAX_LIGHT_LEVEL = 15;

    public SolarCell(Location location) {
        super(location, DefaultElectric.SOLAR_CELL);
    }

    @Override
    public int getEfficiency() {
        return (int) (this.getLightLevel() * 1000d);
    }

    public double getLightLevel() {
        Block block = this.getBlock();
        double skyLevel = (double) block.getLightFromSky() / MAX_LIGHT_LEVEL;
        double lightLevel = (double) block.getLightLevel() / MAX_LIGHT_LEVEL;
        return skyLevel * lightLevel;
    }
}
