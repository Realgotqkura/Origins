package com.realgotqkura.origin;

import com.realgotqkura.origins.OriginsMain;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Blazeborn {

    public void BlazebornRunnable(Player player){
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        new BukkitRunnable() {

            @Override
            public void run() {
                main.reloadConfig();
                if (main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Blazeborn")) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 20 * 5, 0));
                    if(player.getFireTicks() > 0){
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20 * 5, 0));
                    }
                    player.removePotionEffect(PotionEffectType.POISON);
                    player.removePotionEffect(PotionEffectType.HUNGER);
                    player.setMaxHealth(20);
                    if(player.isInWater()) {
                        player.damage(1);
                    }
                    return;
                }
                cancel();
            }

        }.runTaskTimer(main, 100, 15);
    }
}
