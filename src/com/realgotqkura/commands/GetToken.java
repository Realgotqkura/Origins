package com.realgotqkura.commands;

import com.realgotqkura.rebirthToken.RebirthTokenSystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetToken implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("Not for consoles bruh");
            return true;
        }
        Player player = (Player) sender;
        if(label.equalsIgnoreCase("gettoken")){
            if(player.hasPermission("Origins.gettoken.use")){
                player.getInventory().setItem(0, new RebirthTokenSystem().token());
                return true;
            }
        }
        return false;
    }
}
