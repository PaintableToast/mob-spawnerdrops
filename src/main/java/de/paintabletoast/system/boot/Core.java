package de.paintabletoast.system.boot;

import de.paintabletoast.system.manager.PluginHandler;
import de.paintabletoast.system.var.Message;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin implements PluginHandler {
    @Override
    public void onEnable() {
        logLogo();
        Base base = new Base();
        base.initPlugin();
    }
    @Override
    public void onDisable() {
        logLogo();
        log(Message.PLUGIN_STOP.getMessage());
    }
    private void logLogo() {
        log("\n" +
                "\n" +
                " ________       ___    ___ ________  _________  _______   _____ ______      \n" +
                "|\\   ____\\     |\\  \\  /  /|\\   ____\\|\\___   ___\\\\  ___ \\ |\\   _ \\  _   \\    \n" +
                "\\ \\  \\___|_    \\ \\  \\/  / | \\  \\___|\\|___ \\  \\_\\ \\   __/|\\ \\  \\\\\\__\\ \\  \\   \n" +
                " \\ \\_____  \\    \\ \\    / / \\ \\_____  \\   \\ \\  \\ \\ \\  \\_|/_\\ \\  \\\\|__| \\  \\  \n" +
                "  \\|____|\\  \\    \\/  /  /   \\|____|\\  \\   \\ \\  \\ \\ \\  \\_|\\ \\ \\  \\    \\ \\  \\ \n" +
                "    ____\\_\\  \\ __/  / /       ____\\_\\  \\   \\ \\__\\ \\ \\_______\\ \\__\\    \\ \\__\\\n" +
                "   |\\_________\\\\___/ /       |\\_________\\   \\|__|  \\|_______|\\|__|     \\|__|\n" +
                "   \\|_________\\|___|/        \\|_________|                                   \n" +
                "                                                                            \n" +
                "                                                                            \n" +
                "\n");
    }
}
