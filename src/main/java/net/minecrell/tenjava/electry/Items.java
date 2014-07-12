package net.minecrell.tenjava.electry;

import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public final class Items {
    private Items() {}

    private static final String ITEM_IDENTIFICATION = "Electry";

    public static ItemMeta electrify(ItemMeta meta) {
        meta.getLore().add(0, ITEM_IDENTIFICATION);
        return meta;
    }

    public static boolean isElectryItem(ItemStack item) {
        if (item == null) return false;
        List<String> lore = item.getItemMeta().getLore();
        return lore.size() > 0 && lore.get(0).equals(ITEM_IDENTIFICATION);
    }
}
