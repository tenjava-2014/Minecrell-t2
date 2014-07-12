package net.minecrell.tenjava.electry.electrics.registry;

import net.minecrell.tenjava.electry.electrics.block.ElectricBlock;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.Recipe;

public interface Electric {
    String getName();

    ElectricType getType();
    Class<? extends ElectricBlock> getElectric();

    ElectricBlock create(Block block);

    Material getMaterial();
    Recipe getRecipe();
}
