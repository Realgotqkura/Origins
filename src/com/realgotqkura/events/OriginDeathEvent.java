package com.realgotqkura.events;

import com.realgotqkura.items.OriginItems;
import com.realgotqkura.origins.OriginsMain;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class OriginDeathEvent implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        Player player = event.getEntity();
        for(int i = 0; i < event.getDrops().size(); i++){
            ItemStack stack = event.getDrops().get(i);
            if(stack.isSimilar(new OriginItems().HolyBible())){
                event.getDrops().remove(stack);
            }
            if(stack.isSimilar(new OriginItems().GiftOfTheWinds())){
                event.getDrops().remove(stack);
                event.getDrops().remove(new OriginItems().Elytra());
            }
            if(stack.isSimilar(new OriginItems().EnderPearlTP())){
                event.getDrops().remove(stack);
            }
            if(stack.isSimilar(new OriginItems().Leaper())){
                event.getDrops().remove(stack);
            }
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event){
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        Player player = event.getPlayer();
        if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Halo")){
            player.getInventory().setItem(8, new OriginItems().HolyBible());

        }
        if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Enderian")){
            player.getInventory().setItem(8, new OriginItems().EnderPearlTP());

        }
        if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Arachnid")){
            player.getInventory().setItem(8, new OriginItems().Leaper());

        }
    }


}
