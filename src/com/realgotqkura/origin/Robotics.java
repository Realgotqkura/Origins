package com.realgotqkura.origin;

import com.realgotqkura.origins.OriginsMain;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;


public class Robotics {

    public void RoboticsRunnable(Player player){
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        new BukkitRunnable(){

            @Override
            public void run() {
                main.reloadConfig();
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Robotics")){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20*5, 0));
                    player.removePotionEffect(PotionEffectType.HUNGER);
                    player.removePotionEffect(PotionEffectType.ABSORPTION);
                    player.removePotionEffect(PotionEffectType.POISON);
                    player.removePotionEffect(PotionEffectType.REGENERATION);
                    player.setFoodLevel(20);
                    player.setMaxHealth(20);
                    if(player.isInWater()){
                        player.damage(1);
                    }
                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20*5, 0));
                    return;
                }
                cancel();
            }

        }.runTaskTimer(main, 100, 5);
    }
}
