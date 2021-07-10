package com.realgotqkura.origin;

import com.realgotqkura.origins.OriginsMain;
import net.minecraft.world.food.FoodInfo;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftItem;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class Avian implements Listener {

    public void AvianRunnable(Player player){
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        new BukkitRunnable(){

            @Override
            public void run() {
                main.reloadConfig();
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Avian")){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING,20*5,0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,20*5,0));
                    player.setMaxHealth(20);
                    return;
                }
                cancel();
            }

        }.runTaskTimer(OriginsMain.getPlugin(OriginsMain.class), 100, 5);
    }

    @EventHandler
    public void onDeath(PlayerRespawnEvent event){
        Player player = event.getPlayer();
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        main.reloadConfig();
        if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Avian")) {
            player.setAbsorptionAmount(20);
        }
    }

    @EventHandler
    public void onEat(PlayerItemConsumeEvent event){
        List<Material> nonVeganFood = new ArrayList<>();
        nonVeganFood.add(Material.PORKCHOP);
        nonVeganFood.add(Material.COOKED_PORKCHOP);
        nonVeganFood.add(Material.COD);
        nonVeganFood.add(Material.COOKED_COD);
        nonVeganFood.add(Material.SALMON);
        nonVeganFood.add(Material.COOKED_SALMON);
        nonVeganFood.add(Material.TROPICAL_FISH);
        nonVeganFood.add(Material.PUFFERFISH);
        nonVeganFood.add(Material.BEEF);
        nonVeganFood.add(Material.COOKED_BEEF);
        nonVeganFood.add(Material.CHICKEN);
        nonVeganFood.add(Material.COOKED_CHICKEN);
        nonVeganFood.add(Material.RABBIT);
        nonVeganFood.add(Material.COOKED_RABBIT);
        nonVeganFood.add(Material.RABBIT_STEW);
        nonVeganFood.add(Material.MUTTON);
        nonVeganFood.add(Material.COOKED_MUTTON);

        Player player = event.getPlayer();
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Avian")){
            for(Material mat : nonVeganFood){
                if(event.getItem().getType() == mat){
                    event.setCancelled(true);
                }
            }
        }


    }
}
