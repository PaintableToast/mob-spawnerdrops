package de.paintabletoast.system.event;

import de.paintabletoast.system.boot.Core;
import de.paintabletoast.system.event.randomdrops.BlockBreakSpawnerEvent;
import de.paintabletoast.system.event.randomdrops.SpawnMobEggDropEvent;
import de.paintabletoast.system.manager.PluginHandler;
import de.paintabletoast.system.var.FileReplace;
import de.paintabletoast.system.var.Message;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public enum Event implements PluginHandler {
    BLOCK_BREAK_SPAWNER_EVENT(new BlockBreakSpawnerEvent()),
    ENTITY_KILL_MOB_EVENT(new SpawnMobEggDropEvent());
    private Listener listener;
    private final Core core = JavaPlugin.getPlugin(Core.class);
    Event(Listener listener) {
        this.listener = listener;
        registerEvent();
    }
    private void registerEvent() {
        final String name = listener.getClass().getSimpleName();
        try {
            Bukkit.getPluginManager().registerEvents(listener, core);
            log(Message.LISTENER_SUCCESS.getMessage().replace(FileReplace.LISTENER.getPart(), name));
        } catch (Exception error) {
            logError(error, Message.LISTENER_ERROR.getMessage().replace(FileReplace.LISTENER.getPart(), name));
        }
    }
}
