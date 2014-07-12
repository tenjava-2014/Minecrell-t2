package net.minecrell.tenjava.electry.electrics.block;

public abstract class ElectricGenerator extends ElectricBlock {
    private int efficiency;

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }
}
