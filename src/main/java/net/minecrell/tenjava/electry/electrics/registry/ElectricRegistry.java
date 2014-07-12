package net.minecrell.tenjava.electry.electrics.registry;

import net.minecrell.tenjava.electry.Electry;
import net.minecrell.tenjava.electry.electrics.block.ElectricBlock;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class ElectricRegistry {
    private final Multimap<ElectricType, Electric> electrics =
            Multimaps.newSetMultimap(new EnumMap<>(ElectricType.class), HashSet::new);
    private final Map<Material, Electric> itemLookup = new HashMap<>();

    private final Electry plugin;

    public ElectricRegistry(Electry plugin) {
        this.plugin = plugin;
    }

    public void register(Electric electric) {
        electrics.put(electric.getType(), electric);
        itemLookup.put(electric.getMaterial(), electric);
        plugin.getServer().addRecipe(electric.getRecipe());
    }

    public Collection<Electric> getElectrics() {
        return Collections.unmodifiableCollection(electrics.values());
    }

    public ElectricBlock forItem(Material material, Block block) {
        Electric electric = itemLookup.get(material);
        return electric != null ? electric.create(block) : null;
    }
}
