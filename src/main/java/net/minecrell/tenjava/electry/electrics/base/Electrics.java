package net.minecrell.tenjava.electry.electrics.base;

import net.minecrell.tenjava.electry.Items;
import net.minecrell.tenjava.electry.electrics.ElectricFurnace;
import net.minecrell.tenjava.electry.electrics.RedstoneCable;
import net.minecrell.tenjava.electry.electrics.SolarCell;
import net.minecrell.tenjava.electry.electrics.TripwireCable;

import java.util.Collections;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public enum Electrics {
    SOLAR_CELL ("Solar Cell", SolarCell.class) {
        @Override
        protected ItemStack createItem() {
            return setItemName(new ItemStack(Material.DAYLIGHT_DETECTOR));
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
    },

    ELECTRIC_FURNACE ("Electric Furnace", ElectricFurnace.class) {
        @Override
        protected ItemStack createItem() {
            return setItemName(new ItemStack(Material.FURNACE));
        }

        @Override
        protected Recipe createRecipe(ItemStack item) {
            return new ShapedRecipe(item).shape(
                    "III", // IRON |   IRON   | IRON
                    "IRI", // IRON | REDSTONE | IRON
                    "III"  // IRON |   IRON   | IRON
            )
                    .setIngredient('I', Material.IRON_INGOT)
                    .setIngredient('R', Material.REDSTONE);
        }
    },

    // TODO: One of the cables should be better
    REDSTONE_CABLE ("Redstone Cable", RedstoneCable.class) {
        @Override
        protected ItemStack createItem() {
            return setItemName(new ItemStack(Material.REDSTONE));
        }

        @Override
        protected Recipe createRecipe(ItemStack item) {
            ItemStack result = item.clone();
            result.setAmount(6);
            return new ShapedRecipe(result).shape(
                    "RRR", // REDSTONE | REDSTONE | REDSTONE
                    "SSS", //  STRING  |  STRING  |  STRING
                    "RRR"  // REDSTONE | REDSTONE | REDSTONE
            )
                    .setIngredient('R', Material.REDSTONE)
                    .setIngredient('S', Material.STRING);
        }
    },

    TRIPWIRE_CABE ("Tripwire Cable", TripwireCable.class) {
        @Override
        protected ItemStack createItem() {
            return setItemName(new ItemStack(Material.STRING));
        }

        @Override
        protected Recipe createRecipe(ItemStack item) {
            ItemStack result = item.clone();
            result.setAmount(6);
            return new ShapedRecipe(result).shape(
                    "SSS", //  STRING  |  STRING  |  STRING
                    "RRR", // REDSTONE | REDSTONE | REDSTONE
                    "SSS"  //  STRING  |  STRING  |  STRING
            )
                    .setIngredient('S', Material.STRING)
                    .setIngredient('R', Material.REDSTONE);
        }
    };

    private final String name;
    private final Class<? extends Electric> electric;

    private final ItemStack item;
    private final Recipe recipe;

    Electrics(String name, Class<? extends Electric> electric) {
        this.name = name;
        this.electric = electric;
        this.item = this.createItem();
        this.recipe = this.createRecipe(item);
    }

    protected abstract ItemStack createItem();

    protected ItemStack setItemName(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(this.getName());
        item.setItemMeta(Items.electrify(meta));
        return item;
    }


    protected abstract Recipe createRecipe(ItemStack item);

    public String getName() {
        return name;
    }

    public Class<? extends Electric> getElectric() {
        return electric;
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

    public static void registerRecipes(Server server) {
        for (Electrics electric : values())
            server.addRecipe(electric.getRecipe());
    }
}
