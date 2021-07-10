package com.realgotqkura.origin;

import com.realgotqkura.origins.OriginsMain;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Leprechaun {

    public void LeprechaunRunnable(Player player) {
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        new BukkitRunnable(){

            @Override
            public void run() {
                main.reloadConfig();
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Leprechaun")){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 20*5, 4));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*5, 0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20*5, 0));
                    player.setMaxHealth(12);
                    return;
                }
                cancel();
            }

        }.runTaskTimer(main, 100, 5);
    }
}
