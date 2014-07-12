package net.minecrell.tenjava.electry;

import net.minecrell.tenjava.electry.util.Helper;

import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public final class Items {
    private Items() {}

    public static boolean isElectryItem(ItemStack item) {
        if (item == null) return false;
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return false;
        List<String> lore = meta.getLore();
        return !Helper.nullOrEmpty(lore) && lore.get(0).equals("Electry");
    }
}
