package com.realgotqkura.commands;

import com.realgotqkura.origins.OriginsMain;
import com.realgotqkura.utils.ColorOf;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class GetPlayerOrigins implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("Only for players!");
            return true;
        }

        Player player = (Player) sender;
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        main.reloadConfig();
        if(label.equalsIgnoreCase("getPlayerOrigins")){
            List<String> uuids = main.getConfig().getStringList("Origins.UUIDS");
            player.sendMessage(ColorOf.colorOf("&6&lPlayers and their Origins: "));
            for(String uuid : uuids){
                player.sendMessage(ColorOf.colorOf("&e" + main.getConfig().getString("Origins." + uuid + ".Username") + " &7has the origin &a" +
                        main.getConfig().getString("Origins." + uuid + ".Origin")));
            }

        }

        return false;
    }
}
