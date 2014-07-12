package net.minecrell.tenjava.electry;

import java.util.Collections;
import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public final class Items {
    private Items() {}

    private static final String ITEM_IDENTIFICATION = "Electry";

    public static ItemMeta electrify(ItemMeta meta) {
        List<String> lore = meta.getLore();
        if (lore != null)
            lore.add(0, ITEM_IDENTIFICATION);
        else lore = Collections.singletonList(ITEM_IDENTIFICATION)
        meta.setLore(lore);
        return meta;
    }

    public static boolean isElectryItem(ItemStack item) {
        if (item == null) return false;
        ItemMeta meta = item.getItemMeta();
        return meta.hasLore() && meta.getLore().get(0).equals(ITEM_IDENTIFICATION);
    }
}
