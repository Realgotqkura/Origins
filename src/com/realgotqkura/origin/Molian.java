package com.realgotqkura.origin;

import com.realgotqkura.origins.OriginsMain;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Molian {

    public void MolianRunnable(Player player){
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        new BukkitRunnable(){

            @Override
            public void run() {
                main.reloadConfig();
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Molian")) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20 * 5, 1));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20 * 5, 1));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20 * 5, 0));
                    player.setMaxHealth(20);
                    return;
                }
                cancel();
            }

        }.runTaskTimer(main, 100, 5);
    }
}
