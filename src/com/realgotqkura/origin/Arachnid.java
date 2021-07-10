package com.realgotqkura.origin;

import com.realgotqkura.items.OriginItems;
import com.realgotqkura.origins.OriginsMain;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Arachnid implements Listener {

    public HashMap<String, Long> cooldowns = new HashMap<String, Long>();

    public void ArachnidRunnable(Player player){
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        new BukkitRunnable(){

            @Override
            public void run() {
                main.reloadConfig();
                if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Arachnid")){
                    player.setMaxHealth(14);
                    return;
                }
                cancel();
            }

        }.runTaskTimer(main, 100, 5);
    }

    public void EquipArachnidItem(Player player){
        player.getInventory().setItem(8, new OriginItems().Leaper());
    }

    @EventHandler
    public void onhit(EntityDamageByEntityEvent event){
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        if(event.getDamager() instanceof Player){
            Player player = (Player) event.getDamager();
            main.reloadConfig();
            if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Arachnid")){
                if(event.getEntity() instanceof Player){
                    Player entity = (Player) event.getEntity();
                    Location loc = entity.getLocation();
                    World world = loc.getWorld();
                    loc.getBlock().setType(Material.COBWEB);
                }
            }

        }
    }

    @EventHandler
    public void onEat(PlayerItemConsumeEvent event){
        List<Material> VeganFood = new ArrayList<>();
        VeganFood.add(Material.APPLE);
        VeganFood.add(Material.MUSHROOM_STEW);
        VeganFood.add(Material.CARROT);
        VeganFood.add(Material.CAKE);
        VeganFood.add(Material.POTATO);
        VeganFood.add(Material.BAKED_POTATO);
        VeganFood.add(Material.BREAD);
        VeganFood.add(Material.BEETROOT);
        VeganFood.add(Material.BEETROOT_SOUP);
        VeganFood.add(Material.COOKIE);
        VeganFood.add(Material.MELON_SLICE);
        VeganFood.add(Material.DRIED_KELP);
        VeganFood.add(Material.PUMPKIN_PIE);
        VeganFood.add(Material.SWEET_BERRIES);
        VeganFood.add(Material.GLOW_BERRIES);
        VeganFood.add(Material.HONEY_BOTTLE);
        VeganFood.add(Material.MILK_BUCKET);
        VeganFood.add(Material.GOLDEN_APPLE);
        VeganFood.add(Material.ENCHANTED_GOLDEN_APPLE);

        Player player = event.getPlayer();
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        main.reloadConfig();
        if(main.getConfig().getString("Origins." + player.getUniqueId().toString() + ".Origin").equals("Arachnid")){
            for(Material mat : VeganFood){
                if(event.getItem().getType() == mat){
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void click(PlayerInteractEvent event){
        int holyBibleCooldown = 30;
        Player player = event.getPlayer();
        if(player.getInventory().getItemInMainHand().isSimilar(new OriginItems().Leaper())){
            if(event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR){
                if(event.getHand() == EquipmentSlot.HAND){
                    if(cooldowns.containsKey(player.getName())) {
                        long secondsLeft = ((cooldowns.get(player.getName()) / 1000) + holyBibleCooldown) - (System.currentTimeMillis() / 1000);
                        if (secondsLeft > 0) {
                            // Still cooling down
                            player.sendMessage(ChatColor.RED + "You cant use this ability for another " + secondsLeft + " seconds!");
                            event.setCancelled(true);
                            return;
                        }else {
                            //Effect
                            try {
                                player.setVelocity(player.getLocation().getDirection().multiply(3));
                            }catch(Exception e){
                                cooldowns.remove(player.getName());
                                cooldowns.put(player.getName(), System.currentTimeMillis());
                            }
                            cooldowns.remove(player.getName());
                            cooldowns.put(player.getName(), System.currentTimeMillis());



                        }
                    }else{
                        //Effect
                        try {
                            player.setVelocity(player.getLocation().getDirection().multiply(3));
                        }catch(Exception e){
                            cooldowns.put(player.getName(), System.currentTimeMillis());
                        }
                        cooldowns.put(player.getName(), System.currentTimeMillis());
                    }

                }
            }
        }
    }
}
