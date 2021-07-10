package com.realgotqkura.origin;

import com.realgotqkura.origins.OriginsMain;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Wanderer {

    public void WandererRunnable(Player player){
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        new BukkitRunnable(){

            @Override
            public void run() {
                main.reloadConfig();
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Wanderer")){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 20*5, 0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE, 20*5, 0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20*5, 0));
                    player.setMaxHealth(20);
                    return;
                }
                cancel();
            }

        }.runTaskTimer(main, 100, 5);
    }
}
