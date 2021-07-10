package com.realgotqkura.origin;

import com.realgotqkura.origins.OriginsMain;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Merlin {

    public void MerlinRunnable(Player player){
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        new BukkitRunnable(){

            @Override
            public void run() {
                main.reloadConfig();
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Merlin")){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 20*5, 9));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20*5, 0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 20*5, 0));
                    player.setMaxHealth(20);
                    if(player.getInventory().getBoots() != null){
                        for(int i = 0; i < player.getInventory().getSize(); i++){
                            if(player.getInventory().getItem(i) == null){
                                player.getInventory().setItem(i, player.getInventory().getBoots());
                                player.getInventory().setBoots(new ItemStack(Material.AIR));
                                player.updateInventory();
                            }
                        }
                    }
                    return;
                }
                cancel();
            }

        }.runTaskTimer(main, 100, 15);
    }
}
