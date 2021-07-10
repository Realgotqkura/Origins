package com.realgotqkura.origin;

import com.realgotqkura.origins.OriginsMain;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Stellar implements Listener {

    public void StellarRunnable(Player player){
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        new BukkitRunnable() {

            @Override
            public void run() {
                main.reloadConfig();
                if (main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Stellar")) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20 * 5, 1));
                    player.setMaxHealth(40);
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

        }.runTaskTimer(main, 100, 15);
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event){
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        main.reloadConfig();
        if(event.getDamager() instanceof Player){
            Player player = (Player) event.getDamager();
            if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Stellar") ||
                    main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Shulk")) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20 * 5, 0));
            }
            return;
        }
        if(event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Stellar") ||
                    main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Shulk")) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20 * 5, 0));
            }
        }
    }
}
