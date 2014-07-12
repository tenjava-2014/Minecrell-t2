package net.minecrell.tenjava.electry.electrics.block;

import net.minecrell.tenjava.electry.electrics.registry.Electric;

import com.google.common.base.Preconditions;

import org.bukkit.block.Block;

public abstract class ElectricBlock {
    protected transient final Block block;
    private final Electric type;
    private transient boolean enabled; // Don't write this to the configuration

    protected ElectricBlock(Block block, Electric type) {
        this.block = Preconditions.checkNotNull(block, "block");
        this.type = Preconditions.checkNotNull(type, "type");
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
