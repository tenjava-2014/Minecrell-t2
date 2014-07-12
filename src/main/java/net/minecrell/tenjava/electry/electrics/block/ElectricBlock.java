package net.minecrell.tenjava.electry.electrics.block;

import net.minecrell.tenjava.electry.electrics.registry.Electric;

public abstract class ElectricBlock {
    private final Electric type;
    private transient boolean enabled; // Don't write this to the configuration

    protected ElectricBlock(Electric type) {
        this.type = type;
    }

    public final Electric getType() {
        return type;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enable) {
        this.enabled = enable;
    }
}
