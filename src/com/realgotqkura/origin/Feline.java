package com.realgotqkura.origin;

import com.realgotqkura.origins.OriginsMain;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Feline {

    public void FelineRunnable(Player player){
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        new BukkitRunnable() {

            @Override
            public void run() {
                main.reloadConfig();
                if (main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Feline")) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20 * 5, 1));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20 * 5, 0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 20 * 5, 0));
                    player.setMaxHealth(18);
                    return;
                }
                cancel();
            }

        }.runTaskTimer(main, 100, 15);
    }

}
