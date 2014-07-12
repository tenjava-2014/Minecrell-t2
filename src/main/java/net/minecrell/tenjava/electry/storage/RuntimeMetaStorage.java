package net.minecrell.tenjava.electry.storage;

import net.minecrell.tenjava.electry.electrics.block.ElectricBlock;

import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

public class RuntimeMetaStorage<T extends ElectricBlock> extends FixedMetadataValue {
    public RuntimeMetaStorage(Plugin plugin, T electric) {
        super(plugin, electric);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T value() {
        return (T) super.value(); // Should be save to cast
    }
}
