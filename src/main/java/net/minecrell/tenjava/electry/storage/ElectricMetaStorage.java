package net.minecrell.tenjava.electry.storage;

import net.minecrell.tenjava.electry.electrics.base.ElectricBlock;

import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

public class ElectricMetaStorage<T extends ElectricBlock> extends FixedMetadataValue {
    public ElectricMetaStorage(Plugin plugin, T electric) {
        super(plugin, electric);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T value() {
        return (T) super.value(); // Should be save to cast
    }
}
