package net.minecrell.tenjava.electry.electrics.base;

public abstract class ElectricBlock {
    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enable) {
        this.enabled = enable;
    }
}
