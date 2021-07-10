package com.realgotqkura.events;

import com.realgotqkura.gui.OriginsGUI;
import com.realgotqkura.origin.*;
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
                    return;
                }
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Elytrian")){
                    new Elytrian().ElyrianRunnable(player);
                    new Elytrian().ElytrianItems(player);
                    return;
                }
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Avian")){
                    new Avian().AvianRunnable(player);
                    return;
                }
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Molian")){
                    new Molian().MolianRunnable(player);
                    return;
                }
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Ironian")){
                    new Ironian().IronianRunnable(player);
                    return;
                }
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Merlin")){
                   new Merlin().MerlinRunnable(player);
                    return;
                }
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Feline")){
                    new Feline().FelineRunnable(player);
                    return;
                }
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Stellar")){
                    new Stellar().StellarRunnable(player);
                    return;
                }
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Blazeborn")) {
                    new Blazeborn().BlazebornRunnable(player);
                    return;
                }
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Enderian")){
                   new Enderian().EquipEnderianItem(player);
                   new Enderian().EnderianRunnable(player);
                    return;
                }
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Arachnid")){
                    new Arachnid().ArachnidRunnable(player);
                    new Arachnid().EquipArachnidItem(player);
                    return;
                }
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Shulk")){
                    new Shulk().ShulkRunnable(player);
                    return;
                }
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Robotics")){
                    new Robotics().RoboticsRunnable(player);
                    return;
                }
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Wanderer")){
                    new Wanderer().WandererRunnable(player);
                    return;
                }
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Explorer")){
                    new Explorer().ExplorerRunnable(player);
                    return;
                }
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Leprechaun")){
                    new Leprechaun().LeprechaunRunnable(player);
                    return;
                }

                return;
            }else{
                gui.createGUI(player);
                player.sendMessage(ColorOf.colorOf("&a&lPick Your Origin &b&l" + player.getName()));
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
