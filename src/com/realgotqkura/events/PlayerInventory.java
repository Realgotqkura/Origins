package com.realgotqkura.events;

import com.realgotqkura.items.OriginItems;
import com.realgotqkura.origins.OriginsMain;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerInventory implements Listener {

    @EventHandler
    public void inv(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if(event.getSlot() == 8){
            if(event.getCurrentItem().isSimilar(new OriginItems().HolyBible())){
                event.setCancelled(true);
                new BukkitRunnable(){


                    @Override
                    public void run() {
                        player.getItemOnCursor().setAmount(0);
                        cancel();
                    }

                }.runTaskTimer(OriginsMain.getPlugin(OriginsMain.class),1,1);
            }
            if(event.getCurrentItem().isSimilar(new OriginItems().GiftOfTheWinds())){
                event.setCancelled(true);
                new BukkitRunnable(){


                    @Override
                    public void run() {
                        player.getItemOnCursor().setAmount(0);
                        cancel();
                    }

                }.runTaskTimer(OriginsMain.getPlugin(OriginsMain.class),1,1);
            }
            if(event.getCurrentItem().isSimilar(new OriginItems().EnderPearlTP())){
                event.setCancelled(true);
                new BukkitRunnable(){


                    @Override
                    public void run() {
                        player.getItemOnCursor().setAmount(0);
                        cancel();
                    }

                }.runTaskTimer(OriginsMain.getPlugin(OriginsMain.class),1,1);
            }
            if(event.getCurrentItem().isSimilar(new OriginItems().Leaper())){
                event.setCancelled(true);
                new BukkitRunnable(){


                    @Override
                    public void run() {
                        player.getItemOnCursor().setAmount(0);
                        cancel();
                    }

                }.runTaskTimer(OriginsMain.getPlugin(OriginsMain.class),1,1);
            }
        }
    }
}
