package com.realgotqkura.items;

import com.realgotqkura.utils.ColorOf;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class OriginItems {

    public ItemStack HolyBible(){
        ItemStack holybible = new ItemStack(Material.BOOK);
        ItemMeta meta = holybible.getItemMeta();
        meta.setDisplayName(ColorOf.colorOf("&a&lHoly Bible"));
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ColorOf.colorOf("&e&lRIGHT CLICK &6Freeze&7: "));
        lore.add(ColorOf.colorOf("&7freezes the player you are looking at (30 block radius)"));
        lore.add(ColorOf.colorOf("&8Cooldown: &a30s"));
        lore.add("");
        lore.add(ColorOf.colorOf("&a&lORIGIN"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        holybible.setItemMeta(meta);
        return holybible;
    }

    public ItemStack GiftOfTheWinds(){
        ItemStack gift = new ItemStack(Material.FEATHER);
        ItemMeta meta = gift.getItemMeta();
        meta.setDisplayName(ColorOf.colorOf("&a&lGift of the winds"));
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ColorOf.colorOf("&e&lRIGHT CLICK &6Leap&7: "));
        lore.add(ColorOf.colorOf("&7launches you 20 blocks in the air"));
        lore.add(ColorOf.colorOf("&8Cooldown: &a60s"));
        lore.add("");
        lore.add(ColorOf.colorOf("&a&lORIGIN"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        gift.setItemMeta(meta);
        return gift;
    }

    public ItemStack Elytra(){
        ItemStack gift = new ItemStack(Material.ELYTRA);
        ItemMeta meta = gift.getItemMeta();
        meta.setDisplayName(ColorOf.colorOf("&a&lElytrian's Wings"));
        meta.addEnchant(Enchantment.BINDING_CURSE,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setUnbreakable(true);
        gift.setItemMeta(meta);
        return gift;
    }

    public ItemStack EnderPearlTP(){
        ItemStack gift = new ItemStack(Material.ENDER_PEARL);
        ItemMeta meta = gift.getItemMeta();
        meta.setDisplayName(ColorOf.colorOf("&5&lEnderian pearl"));
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ColorOf.colorOf("&e&lRIGHT CLICK &6Teleport&7: "));
        lore.add(ColorOf.colorOf("&7acts like a normal pearl (infinite uses)"));
        lore.add(ColorOf.colorOf("&8Cooldown: &a15s"));
        lore.add("");
        lore.add(ColorOf.colorOf("&a&lORIGIN"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        gift.setItemMeta(meta);
        return gift;
    }

    public ItemStack Leaper(){
        ItemStack gift = new ItemStack(Material.COBWEB);
        ItemMeta meta = gift.getItemMeta();
        meta.setDisplayName(ColorOf.colorOf("&7&lLeaper"));
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ColorOf.colorOf("&e&lRIGHT CLICK &6Leap&7: "));
        lore.add(ColorOf.colorOf("&7Launches you forward at high speeds"));
        lore.add(ColorOf.colorOf("&8Cooldown: &a30s"));
        lore.add("");
        lore.add(ColorOf.colorOf("&a&lORIGIN"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        gift.setItemMeta(meta);
        return gift;
    }
}
