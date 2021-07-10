package com.realgotqkura.origin;

import com.realgotqkura.items.OriginItems;
import com.realgotqkura.origins.OriginsMain;
import com.realgotqkura.utils.ColorOf;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.libs.it.unimi.dsi.fastutil.Hash;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;

public class Elytrian implements Listener {

    public void ElyrianRunnable(Player player){
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        new BukkitRunnable(){

            @Override
            public void run() {
                main.reloadConfig();
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Elytrian")){
                    player.setMaxHealth(20);
                }
            }

        }.runTaskTimer(main, 100, 5);
    }

    public void ElytrianItems(Player player){
        player.getInventory().setItem(8, new OriginItems().GiftOfTheWinds());
        player.getInventory().setChestplate(new OriginItems().Elytra());
    }

    @EventHandler
    public void onFall(EntityDamageEvent event){
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        if(event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            if(event.getCause() == EntityDamageEvent.DamageCause.FALL){
                switch (Objects.requireNonNull(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin"))) {
                    case "Elytrian", "Explorer" -> {
                        event.setCancelled(true);
                        event.setDamage(event.getDamage() * 0.5);
                    }
                    case "Feline" -> event.setCancelled(true);
                }
            }

        }
    }

    @EventHandler
    public void death(PlayerRespawnEvent event){
        Player player = event.getPlayer();
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Elytrian")){
            player.getInventory().setItem(8, new OriginItems().GiftOfTheWinds());
            player.getInventory().setChestplate(new OriginItems().Elytra());
        }

    }

    public HashMap<String, Long> cooldowns = new HashMap<>();

    @EventHandler
    public void click(PlayerInteractEvent event){
        int holyBibleCooldown = 60;
        Player player = event.getPlayer();
        if(player.getInventory().getItemInMainHand().isSimilar(new OriginItems().GiftOfTheWinds())){
            if(event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR){
                if(event.getHand() == EquipmentSlot.HAND){
                    if(cooldowns.containsKey(player.getName())) {
                        long secondsLeft = ((cooldowns.get(player.getName()) / 1000) + holyBibleCooldown) - (System.currentTimeMillis() / 1000);
                        if (secondsLeft > 0) {
                            // Still cooling down
                            player.sendMessage(ChatColor.RED + "You cant use this ability for another " + secondsLeft + " seconds!");
                            return;
                        }else {
                            //Effect
                            try {
                                Location ploc = player.getLocation();
                                Vector dir = ploc.getDirection();
                                player.setVelocity(new Vector((dir.getX() / -1), (dir.getY() / -1) + 10, (dir.getZ() / -1)));
                                player.sendMessage(ColorOf.colorOf("&a&lZooooom!"));
                            }catch(Exception e){
                                cooldowns.remove(player.getName());
                                cooldowns.put(player.getName(), System.currentTimeMillis());
                            }
                            cooldowns.remove(player.getName());
                            cooldowns.put(player.getName(), System.currentTimeMillis());



                        }
                    }else{
                        //Effect
                        try {
                            Location ploc = player.getLocation();
                            Vector dir = ploc.getDirection();
                            player.setVelocity(new Vector((dir.getX() / -1), (dir.getY() / -1) + 10, (dir.getZ() / -1)));
                            player.sendMessage(ColorOf.colorOf("&a&lZooooom!"));
                        }catch(Exception e){
                            cooldowns.put(player.getName(), System.currentTimeMillis());
                        }
                        cooldowns.put(player.getName(), System.currentTimeMillis());
                    }

                }
            }
        }
    }

}
