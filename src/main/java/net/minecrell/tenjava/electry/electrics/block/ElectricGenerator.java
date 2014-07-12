package net.minecrell.tenjava.electry.electrics.block;

import net.minecrell.tenjava.electry.electrics.registry.Electric;

public abstract class ElectricGenerator extends ElectricBlock {
    private int efficiency;

    protected ElectricGenerator(Electric type) {
        super(type);
    }

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }
}
