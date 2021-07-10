package com.realgotqkura.rebirthToken;

import com.realgotqkura.gui.OriginsGUI;
import com.realgotqkura.gui.RecipeInventory;
import com.realgotqkura.utils.ColorOf;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RebirthTokenSystem implements Listener {

    public ItemStack token(){
        ItemStack token = new ItemStack(Material.PRISMARINE_CRYSTALS);
        ItemMeta meta = token.getItemMeta();
        meta.setDisplayName(ColorOf.colorOf("&d&kEE &bRebirth Token &d&kEE"));
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ColorOf.colorOf("&7This shard is used to craft a Rebirth Gem"));
        lore.add(ColorOf.colorOf("&7Which is used to reset your origin and give"));
        lore.add(ColorOf.colorOf("&7you a new beginning. You need 8 of them to craft"));
        lore.add(ColorOf.colorOf("&7a Rebirth Gem."));
        lore.add(ColorOf.colorOf("&7You obtain the token by killing all kinds of mobs"));
        lore.add(ColorOf.colorOf("&8Drop Chance: &a&l1/200"));
        lore.add("");
        lore.add(ColorOf.colorOf("&eRight click to show Rebirth Gem recipe"));
        lore.add("");
        lore.add(ColorOf.colorOf("&d&kEE &b&lRebirth &d&kEE"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        token.setItemMeta(meta);
        return token;
    }

    public ItemStack Gem(){
        ItemStack token = new ItemStack(Material.HEART_OF_THE_SEA);
        ItemMeta meta = token.getItemMeta();
        meta.setDisplayName(ColorOf.colorOf("&a&kEE &b&lRebirth Gem &a&kEE"));
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ColorOf.colorOf("&7This gem is used to change your origin"));
        lore.add(ColorOf.colorOf("&d&lRIGHT CLICK TO REBIRTH"));
        lore.add("");
        lore.add(ColorOf.colorOf("&d&kEE &b&lRebirth &d&kEE"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        token.setItemMeta(meta);
        return token;
    }

    @EventHandler
    public void onDeath(EntityDeathEvent event){
        Player player = event.getEntity().getKiller();
        int random = ThreadLocalRandom.current().nextInt(0, 200 + 1);
        try{
            if(event.getEntity().getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK){
                if(random == 69){
                    Bukkit.broadcastMessage(ColorOf.colorOf("&a" + player.getName() + " &6obtained a &d&kEE &bRebirth Token &d&kEE &7-" +
                            " &a&o1/200 &6chance"));
                    if(player.getInventory().firstEmpty() == -1){
                        World world = player.getWorld();
                        world.dropItem(player.getLocation(), token());
                    }else{
                        player.getInventory().addItem(token());
                    }
                }
            }
        }catch(Exception ignored){

        }
    }

    @EventHandler
    public void OnClick(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(player.getInventory().getItemInMainHand().isSimilar(token())){
            if(event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR){
                if(event.getHand() == EquipmentSlot.HAND){
                    new RecipeInventory().createGUI(player);
                }
            }
        }else if(player.getInventory().getItemInMainHand().isSimilar(Gem())){
            if(event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR){
                if(event.getHand() == EquipmentSlot.HAND){
                    player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount()-1);
                    new OriginsGUI().createGUI(player);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerCraft(PrepareItemCraftEvent event) {
        if(event.getInventory().getMatrix().length < 9) {
            return;
        }
        checkcraft(Gem(), event.getInventory(), new HashMap<Integer, ItemStack>(){{

            put(0, token());
            put(1, token());
            put(2, token());
            put(3, token());
            put(5, token());
            put(6, token());
            put(7, token());
            put(8, token());
            put(9, token());
            put(4, new ItemStack(Material.DIAMOND));
        }});
    }

    public void checkcraft(ItemStack result, CraftingInventory inv, HashMap<Integer, ItemStack> ing) {
        ItemStack[] matrix = inv.getMatrix();
        for(int i = 0; i < 9; i++) {
            if(ing.containsKey(i)) {
                if(matrix[i] == null || !matrix[i].equals(ing.get(i))) {
                    return;
                }
            }else {
                if(matrix[i] != null) {
                    return;
                }
            }
        }
        inv.setResult(result);
    }


}
