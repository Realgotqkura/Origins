package com.realgotqkura.events;

import com.realgotqkura.items.OriginItems;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropEvents implements Listener {

    @EventHandler
    public void drop(PlayerDropItemEvent event){
        if(event.getItemDrop().getItemStack().equals(new OriginItems().HolyBible())){
            event.setCancelled(true);
        }
        if(event.getItemDrop().getItemStack().equals(new OriginItems().GiftOfTheWinds())){
            event.setCancelled(true);
        }
        if(event.getItemDrop().getItemStack().equals(new OriginItems().Elytra())){
            event.setCancelled(true);
        }
        if(event.getItemDrop().getItemStack().equals(new OriginItems().EnderPearlTP())){
            event.setCancelled(true);
        }
        if(event.getItemDrop().getItemStack().equals(new OriginItems().Leaper())){
            event.setCancelled(true);
        }
    }
}
