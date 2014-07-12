package net.minecrell.tenjava.electry.electrics;

import net.minecrell.tenjava.electry.electrics.base.ElectricGenerator;

public class SolarCell extends ElectricGenerator {
    private int lightLevel;

    public int getLightLevel() {
        return lightLevel;
    }
}
