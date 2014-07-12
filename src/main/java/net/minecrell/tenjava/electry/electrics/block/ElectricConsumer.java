package net.minecrell.tenjava.electry.electrics.block;

import net.minecrell.tenjava.electry.electrics.registry.Electric;

public abstract class ElectricConsumer extends ElectricBlock {
    private int consumption;

    protected ElectricConsumer(Electric type) {
        super(type);
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }
}
