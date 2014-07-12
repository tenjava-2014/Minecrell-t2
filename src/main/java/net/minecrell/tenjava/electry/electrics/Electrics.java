package net.minecrell.tenjava.electry.electrics;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public enum Electrics {
    SOLAR_CELL("Solar Cell") {
        @Override
        protected ItemStack createItem() {
            ItemStack item = new ItemStack(Material.DAYLIGHT_DETECTOR);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(this.getName());
            item.setItemMeta(meta);
            return item;
        }

        @Override
        protected Recipe createRecipe(ItemStack item) {
            return new ShapedRecipe(item).shape(
                    "GGG", //   GLASS   |   GLASS   |   GLASS
                    "DRD", //  DIAMOND  | REDSTONE  |  DIAMOND
                    "WWW"  // WOOD SLAB | WOOD SLAB | WOOD SLAB
            )
                    .setIngredient('G', Material.GLASS)
                    .setIngredient('D', Material.DIAMOND).setIngredient('R', Material.REDSTONE)
                    .setIngredient('W', Material.WOOD_STEP);
        }
    };

    private final String name;
    private final ItemStack item;
    private final Recipe recipe;

    Electrics(String name) {
        this.name = name;
        this.item = this.createItem();
        this.recipe = this.createRecipe(item);
    }

    protected abstract ItemStack createItem();
    protected abstract Recipe createRecipe(ItemStack item);

    public String getName() {
        return name;
    }

    public ItemStack getItem() {
        return item;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
