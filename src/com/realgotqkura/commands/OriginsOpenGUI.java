package com.realgotqkura.commands;

import com.realgotqkura.gui.OriginsGUI;
import com.realgotqkura.origins.OriginsMain;
import com.realgotqkura.utils.ColorOf;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OriginsOpenGUI implements CommandExecutor {

    OriginsMain plugin;
    public OriginsOpenGUI(OriginsMain plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("Only for players.");
            return true;
        }

        Player player = (Player) sender;
        if(label.equalsIgnoreCase("originsOpenGUI")){
            if(player.hasPermission("origins.originsOpenGUI")) {
                OriginsGUI gui = new OriginsGUI();
                gui.createGUI(player);
                return true;
            }
            player.sendMessage(ColorOf.colorOf("&7[&a&lOrigins&7] &cYou need the &borigins.originsOpenGUI &cpermission to use this command."));
            return true;
        }
        return false;
    }
}
