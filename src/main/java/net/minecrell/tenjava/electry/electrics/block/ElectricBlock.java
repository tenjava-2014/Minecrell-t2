package net.minecrell.tenjava.electry.electrics.block;

import net.minecrell.tenjava.electry.electrics.registry.Electric;

import com.google.common.base.Preconditions;

import org.bukkit.Location;
import org.bukkit.block.Block;

public abstract class ElectricBlock {
    protected transient final Location location;
    private final Electric type;
    private transient boolean enabled; // Don't write this to the configuration

    protected ElectricBlock(Location location, Electric type) {
        this.location = Preconditions.checkNotNull(location, "location");
        this.type = Preconditions.checkNotNull(type, "type");
    }

    public final Location getLocation() {
        return location;
    }

    public final Block getBlock() {
        return location.getBlock();
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
