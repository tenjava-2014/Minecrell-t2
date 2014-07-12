package net.minecrell.tenjava.electry.electrics.registry;

import net.minecrell.tenjava.electry.electrics.ElectricFurnace;
import net.minecrell.tenjava.electry.electrics.RedstoneCable;
import net.minecrell.tenjava.electry.electrics.SolarCell;
import net.minecrell.tenjava.electry.electrics.TripwireCable;
import net.minecrell.tenjava.electry.electrics.block.ElectricBlock;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

import static net.minecrell.tenjava.electry.Items.createItem;

public enum DefaultElectric implements Electric {
    SOLAR_CELL ("Solar Cell", SolarCell.class, ElectricType.GENERATOR, Material.DAYLIGHT_DETECTOR) {
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

        @Override
        public ElectricBlock create() {
            return new SolarCell();
        }
    },

    ELECTRIC_FURNACE ("Electric Furnace", ElectricFurnace.class, ElectricType.CONSUMER, Material.FURNACE) {
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

        @Override
        public ElectricBlock create() {
            return new ElectricFurnace();
        }
    },

    // TODO: One of the cables should be better
    REDSTONE_CABLE ("Redstone Cable", RedstoneCable.class, ElectricType.TRANSPORTER, Material.REDSTONE) {
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

        @Override
        public ElectricBlock create() {
            return new RedstoneCable();
        }
    },

    TRIPWIRE_CABLE ("Tripwire Cable", TripwireCable.class, ElectricType.TRANSPORTER, Material.STRING) {
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

        @Override
        public ElectricBlock create() {
            return new TripwireCable();
        }
    };

    private final String name;
    private final ElectricType type;
    private final Class<? extends ElectricBlock> electric;

    private final Material material;
    private final Recipe recipe;

    DefaultElectric(String name, Class<? extends ElectricBlock> electric, ElectricType type, Material material) {
        this.type = type;
        Preconditions.checkArgument(!Strings.isNullOrEmpty(name), "name cannot be empty");
        this.name = name;
        this.electric = Preconditions.checkNotNull(electric);
        this.material = Preconditions.checkNotNull(material);
        this.recipe = this.createRecipe(material);
    }

    protected abstract Recipe createRecipe(Material material);

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ElectricType getType() {
        return type;
    }

    @Override
    public Class<? extends ElectricBlock> getElectric() {
        return electric;
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public Recipe getRecipe() {
        return recipe;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public static void register(ElectricRegistry registry) {
        for (Electric electric : values())
            registry.register(electric);
    }
}
