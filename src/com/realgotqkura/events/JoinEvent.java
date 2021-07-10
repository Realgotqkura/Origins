package com.realgotqkura.events;

import com.realgotqkura.gui.OriginsGUI;
import com.realgotqkura.origin.Halo;
import com.realgotqkura.origins.OriginsMain;
import com.realgotqkura.utils.ColorOf;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class JoinEvent implements Listener {

    @EventHandler
    public void join(PlayerJoinEvent event){
        Player player = event.getPlayer();
        OriginsGUI gui = new OriginsGUI();
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        main.reloadConfig();
        try {
            if (main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".UUID").equals(
                    player.getUniqueId().toString())) {

                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Halo")){
                    new Halo().EquipHaloItem(player);
                    new Halo().HaloRunnable(player);
                }
                return;
            }
        }catch(Exception e){
            gui.createGUI(player);
            player.sendMessage(ColorOf.colorOf("&a&lPick Your Origin &b&l" + player.getName()));
        }

    }

    @EventHandler
    public void Quit(PlayerQuitEvent event){

    }


}
