package de.paintabletoast.system.var;

import java.util.ArrayList;

public enum Config {
    RANDOM_MOB_SPAWN,
    RANDOM_SPAWNER_DROP,
    SPAWNER_BREAK,
    BLACKLIST,
    SPAWNER_ENCHANTMENT;
    public final int getInt() {
        return (int) ConfigFile.CONFIG.getConfig().get(PathFile.CONFIG.getPath() + this.name());
    }
    public final ArrayList<String> getArrayList() {
        return (ArrayList<String>) ConfigFile.CONFIG.getConfig().get(PathFile.CONFIG.getPath() + this.name());
    }
}
