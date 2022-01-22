package de.paintabletoast.system.event.randomdrops;

import de.paintabletoast.system.event.ListenerHandler;
import de.paintabletoast.system.utils.ItemBuilder;
import de.paintabletoast.system.var.Config;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Random;

public class SpawnMobEggDropEvent implements ListenerHandler {
    @EventHandler
    private final void onDeath(final EntityDeathEvent event) {
        if(event.getEntityType().isAlive())
            if(!Config.BLACKLIST.getArrayList().contains(event.getEntity().getType().name().toUpperCase()))
                doDrop(event.getEntity());
    }
    private final void doDrop(final LivingEntity entity) {
        final Location location = entity.getLocation();
        final int random = new Random().nextInt(Config.RANDOM_MOB_SPAWN.getInt());
        try {
            if(random == 0) location.getWorld().dropItem(location, new ItemBuilder(Material.valueOf(entity.getType().name().toUpperCase() + "_SPAWN_EGG")));
        } catch (final Exception error) {}

    }
}
