package net.minecrell.tenjava.electry;

import net.minecrell.tenjava.electry.electrics.block.ElectricBlock;
import net.minecrell.tenjava.electry.electrics.registry.Electric;
import net.minecrell.tenjava.electry.storage.RuntimeMetaStorage;

import java.util.Collections;
import java.util.List;

import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public final class Items {
    private Items() {}

    public static final String ITEM_ID = "Electry";
    public static final String META_ID = ITEM_ID + "Storage";

    public static ItemStack createItem(Electric electric, ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(electric.getName());
        List<String> lore = meta.getLore();
        if (lore != null)
            lore.add(0, ITEM_ID);
        else lore = Collections.singletonList(ITEM_ID);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static boolean isElectryItem(ItemStack item) {
        if (item == null) return false;
        ItemMeta meta = item.getItemMeta();
        return meta.hasLore() && meta.getLore().get(0).equals(ITEM_ID);
    }

    public static boolean isElectryBlock(Block block) {
        return block.hasMetadata(META_ID);
    }

    @SuppressWarnings("unchecked")
    public static <T extends ElectricBlock> T get(Block block) {
        return (T) ((RuntimeMetaStorage<?>) block.getMetadata(Items.META_ID).get(0)).value();
    }

    @SuppressWarnings("unchecked")
    public static <T extends ElectricBlock> T getSafely(Block block) {
        if (!isElectryBlock(block)) return null;
        try {
            return (T) ((RuntimeMetaStorage<?>) block.getMetadata(Items.META_ID).get(0)).value();
        } catch (ClassCastException ignored) {
            return null;
        }
    }
}
