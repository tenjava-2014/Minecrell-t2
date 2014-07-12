package net.minecrell.tenjava.electry.electrics.base;

import net.minecrell.tenjava.electry.electrics.ElectricFurnace;
import net.minecrell.tenjava.electry.electrics.RedstoneCable;
import net.minecrell.tenjava.electry.electrics.SolarCell;
import net.minecrell.tenjava.electry.electrics.TripwireCable;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

import static net.minecrell.tenjava.electry.Items.createItem;

public enum Electrics {
    SOLAR_CELL ("Solar Cell", SolarCell.class, Material.DAYLIGHT_DETECTOR) {
        @Override
        protected Recipe createRecipe(Material material) {
            return new ShapedRecipe(createItem(this, new ItemStack(material))).shape(
                    "GGG", //   GLASS   |   GLASS   |   GLASS
                    "DRD", //  DIAMOND  | REDSTONE  |  DIAMOND
                    "WWW"  // WOOD SLAB | WOOD SLAB | WOOD SLAB
            )
                    .setIngredient('G', Material.GLASS)
                    .setIngredient('D', Material.DIAMOND).setIngredient('R', Material.REDSTONE)
                    .setIngredient('W', Material.WOOD_STEP);
        }
    },

    ELECTRIC_FURNACE ("Electric Furnace", ElectricFurnace.class, Material.FURNACE) {
        @Override
        protected Recipe createRecipe(Material material) {
            return new ShapedRecipe(createItem(this, new ItemStack(material))).shape(
                    "III", // IRON |   IRON   | IRON
                    "IRI", // IRON | REDSTONE | IRON
                    "III"  // IRON |   IRON   | IRON
            )
                    .setIngredient('I', Material.IRON_INGOT)
                    .setIngredient('R', Material.REDSTONE);
        }
    },

    // TODO: One of the cables should be better
    REDSTONE_CABLE ("Redstone Cable", RedstoneCable.class, Material.REDSTONE) {
        @Override
        protected Recipe createRecipe(Material material) {
            return new ShapedRecipe(createItem(this, new ItemStack(material, 6))).shape(
                    "RRR", // REDSTONE | REDSTONE | REDSTONE
                    "SSS", //  STRING  |  STRING  |  STRING
                    "RRR"  // REDSTONE | REDSTONE | REDSTONE
            )
                    .setIngredient('R', Material.REDSTONE)
                    .setIngredient('S', Material.STRING);
        }
    },

    TRIPWIRE_CABLE ("Tripwire Cable", TripwireCable.class, Material.STRING) {
        @Override
        protected Recipe createRecipe(Material material) {
            return new ShapedRecipe(createItem(this, new ItemStack(material, 6))).shape(
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

    private final Material material;
    private final Recipe recipe;

    Electrics(String name, Class<? extends Electric> electric, Material material) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(name), "name cannot be empty");
        this.name = name;
        this.electric = Preconditions.checkNotNull(electric);
        this.material = Preconditions.checkNotNull(material);
        this.recipe = this.createRecipe(material);
    }

    protected abstract Recipe createRecipe(Material material);

    public String getName() {
        return name;
    }

    public Class<? extends Electric> getElectric() {
        return electric;
    }

    public Material getMaterial() {
        return material;
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
