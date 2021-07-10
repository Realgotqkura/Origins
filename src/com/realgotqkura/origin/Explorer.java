package com.realgotqkura.origin;

import com.realgotqkura.origins.OriginsMain;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Explorer {

    public void ExplorerRunnable(Player player){
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        new BukkitRunnable(){

            @Override
            public void run() {
                main.reloadConfig();
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Explorer")){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 20*5, 0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*5, 0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20*5, 0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20*5, 0));
                    player.setMaxHealth(20);
                    return;
                }
                cancel();
            }

        }.runTaskTimer(main, 100, 5);
    }
}
