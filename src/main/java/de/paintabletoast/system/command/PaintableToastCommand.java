package de.paintabletoast.system.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class PaintableToastCommand implements CommandHandler {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("&7");
        return false;
    }
}
