package de.paintabletoast.system.event;

import de.paintabletoast.system.var.Config;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public interface ListenerHandler extends Listener {
    default boolean checkItemInHand(final Player player) {
        for (String material_stringid : Config.SPAWNER_BREAK.getArrayList()) {
            final Material material = Material.valueOf(material_stringid);
            final ItemStack item = player.getInventory().getItemInMainHand();
            Bukkit.broadcastMessage("RICHTIGE PICKE");
            if(item.getType().equals(material))
                for (String enchantment_stringid : Config.SPAWNER_ENCHANTMENT.getArrayList()) {
                    final Enchantment enchantment = Enchantment.getByName(enchantment_stringid);
                    if(item.getEnchantments().containsKey(enchantment)) {
                        Bukkit.broadcastMessage("Richtiges Enchantment");
                        return true;

                    }
                }
        }
        return false;
    }
}
