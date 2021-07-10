package com.realgotqkura.origin;

import com.realgotqkura.items.OriginItems;
import com.realgotqkura.origins.OriginsMain;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Halo {

    public void HaloRunnable(Player player){
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        new BukkitRunnable(){

            @Override
            public void run() {
                main.reloadConfig();
                if(player.isOnline()){
                    if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Halo")){
                        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,20*6,1));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING,20*6,0));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS,20*6,0));
                        player.setMaxHealth(20);
                        HaloAboveHead(player);
                    }
                }else{
                    cancel();
                }
            }

        }.runTaskTimer(OriginsMain.getPlugin(OriginsMain.class), 100,5);
    }

    public void HaloAboveHead(Player player){
        Location ploc = player.getLocation();
        World world = player.getWorld();
        world.spawnParticle(Particle.REDSTONE, ploc.getX(), ploc.getY() + 2.3F, ploc.getZ(), 2, new Particle.DustOptions(Color.fromRGB(235, 235, 52),2));
    }

    public void EquipHaloItem(Player player){
        player.getInventory().setItem(8, new OriginItems().HolyBible());
    }

}
