package com.realgotqkura.events;

import com.realgotqkura.items.OriginItems;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class PlayerItemClick implements Listener {

    public HashMap<String, Long> cooldowns = new HashMap<String, Long>();

    @EventHandler
    public void click(PlayerInteractEvent event){
        int holyBibleCooldown = 30;
        Player player = event.getPlayer();
        if(player.getInventory().getItemInMainHand().isSimilar(new OriginItems().HolyBible())){
            if(event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR){
                if(event.getHand() == EquipmentSlot.HAND){
                    if(cooldowns.containsKey(player.getName())) {
                        long secondsLeft = ((cooldowns.get(player.getName()) / 1000) + holyBibleCooldown) - (System.currentTimeMillis() / 1000);
                        if (secondsLeft > 0) {
                            // Still cooling down
                            player.sendMessage(ChatColor.RED + "You cant use this ability for another " + secondsLeft + " seconds!");
                            return;
                        }else {
                            //Effect
                            try {
                                LivingEntity entity = getNearestEntityInSight(player, 30);
                                entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 7, 254));
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
                            LivingEntity entity = getNearestEntityInSight(player, 30);
                            entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 7, 254));
                        }catch(Exception e){
                            cooldowns.put(player.getName(), System.currentTimeMillis());
                        }
                        cooldowns.put(player.getName(), System.currentTimeMillis());
                    }

                }
            }
        }
    }

    public static LivingEntity getNearestEntityInSight(Player player, int range) {
        ArrayList<Entity> entities = (ArrayList<Entity>) player.getNearbyEntities(range, range, range);
        ArrayList<Block> sightBlock = (ArrayList<Block>) player.getLineOfSight( (Set<Material>) null, range);
        ArrayList<Location> sight = new ArrayList<Location>();
        for (int i = 0;i<sightBlock.size();i++)
            sight.add(sightBlock.get(i).getLocation());
        for (int i = 0;i<sight.size();i++) {
            for (Entity entity : entities) {
                if(entity instanceof LivingEntity){
                    LivingEntity entity1 = (LivingEntity) entity;
                    if (Math.abs(entity1.getLocation().getX()-sight.get(i).getX())<1.3) {
                        if (Math.abs(entity1.getLocation().getY()-sight.get(i).getY())<1.5) {
                            if (Math.abs(entity1.getLocation().getZ()-sight.get(i).getZ())<1.3) {
                                return entity1;
                            }
                        }
                    }
                }
            }
        }
        return null; //Return null/nothing if no entity was found
    }

}
