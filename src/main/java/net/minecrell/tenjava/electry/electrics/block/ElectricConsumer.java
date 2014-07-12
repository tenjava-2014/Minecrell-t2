package net.minecrell.tenjava.electry.electrics.block;

public abstract class ElectricConsumer extends ElectricBlock {
    private int consumption;

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }
}
