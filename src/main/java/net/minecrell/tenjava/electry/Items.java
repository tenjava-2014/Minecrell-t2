package net.minecrell.tenjava.electry;

import net.minecrell.tenjava.electry.electrics.base.Electrics;

import java.util.Collections;
import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public final class Items {
    private Items() {}

    private static final String ITEM_IDENTIFICATION = "Electry";

    public static ItemStack createItem(Electrics electric, ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(electric.getName());
        List<String> lore = meta.getLore();
        if (lore != null)
            lore.add(0, ITEM_IDENTIFICATION);
        else lore = Collections.singletonList(ITEM_IDENTIFICATION);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static boolean isElectryItem(ItemStack item) {
        if (item == null) return false;
        ItemMeta meta = item.getItemMeta();
        return meta.hasLore() && meta.getLore().get(0).equals(ITEM_IDENTIFICATION);
    }
}
