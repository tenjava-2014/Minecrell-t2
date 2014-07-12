package net.minecrell.tenjava.electry.electrics.block;

import net.minecrell.tenjava.electry.electrics.registry.Electric;

public abstract class ElectricCable extends ElectricTransporter {
    protected ElectricCable(Electric type) {
        super(type);
    }
}
