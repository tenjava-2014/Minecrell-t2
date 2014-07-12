package net.minecrell.tenjava.electry.electrics.base;

public abstract class ElectricConsumer extends Electric {
    private int consumption;

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }
}
