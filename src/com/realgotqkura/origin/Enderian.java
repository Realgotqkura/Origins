package com.realgotqkura.origin;

import com.realgotqkura.items.OriginItems;
import com.realgotqkura.origins.OriginsMain;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class Enderian implements Listener {

    public HashMap<String, Long> cooldowns = new HashMap<String, Long>();

    public void EnderianRunnable(Player player){
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        new BukkitRunnable() {

            @Override
            public void run() {
                main.reloadConfig();
                if (main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Enderian")) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 5, 0));
                    if(player.isInWater()) {
                        player.damage(1);
                    }
                    EquipEnderianItem(player);
                    player.setMaxHealth(20);
                    return;
                }
                cancel();
            }

        }.runTaskTimer(main, 100, 15);
    }

    public void EquipEnderianItem(Player player){
        player.getInventory().setItem(8, new OriginItems().EnderPearlTP());
    }


    @EventHandler
    public void click(PlayerInteractEvent event){
        int holyBibleCooldown = 15;
        Player player = event.getPlayer();
        if(player.getInventory().getItemInMainHand().isSimilar(new OriginItems().EnderPearlTP())){
            if(event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR){
                if(event.getHand() == EquipmentSlot.HAND){
                    if(cooldowns.containsKey(player.getName())) {
                        long secondsLeft = ((cooldowns.get(player.getName()) / 1000) + holyBibleCooldown) - (System.currentTimeMillis() / 1000);
                        if (secondsLeft > 0) {
                            // Still cooling down
                            player.sendMessage(ChatColor.RED + "You cant use this ability for another " + secondsLeft + " seconds!");
                            event.setCancelled(true);
                            return;
                        }else {
                            //Effect
                            try {
                                EquipEnderianItem(player);
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
                            EquipEnderianItem(player);
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
