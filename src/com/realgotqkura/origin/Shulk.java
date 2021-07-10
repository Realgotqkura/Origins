package com.realgotqkura.origin;

import com.realgotqkura.origins.OriginsMain;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Shulk {

    public void ShulkRunnable(Player player){
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        new BukkitRunnable(){

            @Override
            public void run() {
                main.reloadConfig();
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Shulk")){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20*5, 1));
                    player.removePotionEffect(PotionEffectType.LEVITATION);
                    player.setMaxHealth(20);
                    if(player.getInventory().getItemInOffHand().isSimilar(new ItemStack(Material.SHIELD))){
                        for(int i = 0; i < player.getInventory().getSize(); i++){
                            if(player.getInventory().getItem(i) == null){
                                player.getInventory().setItem(i, player.getInventory().getItemInOffHand());
                                player.getInventory().setItemInOffHand(new ItemStack(Material.AIR));
                                player.updateInventory();
                            }
                        }
                    }
                    return;
                }
                cancel();
            }

        }.runTaskTimer(main, 100, 5);
    }
}
