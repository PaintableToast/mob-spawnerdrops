package de.paintabletoast.system.event.randomdrops;
import de.paintabletoast.system.event.ListenerHandler;
import de.paintabletoast.system.utils.ItemBuilder;
import de.paintabletoast.system.var.Config;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Random;

public class BlockBreakSpawnerEvent implements ListenerHandler {
    @EventHandler
    private final void onBlockBreak(final BlockBreakEvent event) {
        if(event.getPlayer().getGameMode().equals(GameMode.SURVIVAL))
        if(event.getBlock().getType().equals(Material.SPAWNER))
            if (checkItemInHand(event.getPlayer())) {
                final Block block = event.getBlock();
                final Location blocklocation = block.getLocation();
                final int random = new Random().nextInt(Config.RANDOM_SPAWNER_DROP.getInt());
                try {
                    if (random == 0) blocklocation.getWorld().dropItem(blocklocation, new ItemBuilder(Material.SPAWNER));
                } catch (final Exception error) {}
            }
    }
}
