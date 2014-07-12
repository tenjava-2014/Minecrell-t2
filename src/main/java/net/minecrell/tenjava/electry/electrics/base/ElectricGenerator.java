package net.minecrell.tenjava.electry.electrics.base;

public abstract class ElectricGenerator extends Electric {
    private int efficiency;

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }
}
