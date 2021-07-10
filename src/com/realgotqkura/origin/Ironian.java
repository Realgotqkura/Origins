package com.realgotqkura.origin;

import com.realgotqkura.origins.OriginsMain;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Ironian implements Listener {

    public void IronianRunnable(Player player){
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        new BukkitRunnable(){

            @Override
            public void run() {
                main.reloadConfig();
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Ironian")){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20*5, 1));
                    player.setMaxHealth(30);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*5, 0));
                    return;
                }
                cancel();
            }

        }.runTaskTimer(main, 100, 5);
    }

    @EventHandler
    public void onEat(PlayerItemConsumeEvent event){
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        Player player = event.getPlayer();
        if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Ironian") ||
                main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Stellar") ||
                main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Shulk") ||
                main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Wanderer") ||
                main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Leprechaun")){
            event.setCancelled(true);
            ItemStack stack = CraftItemStack.asNMSCopy(event.getItem());
            Item item = stack.getItem();
            player.setFoodLevel(player.getFoodLevel() + (item.getFoodInfo().getNutrition() / 2));
            player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
        }
    }
}
