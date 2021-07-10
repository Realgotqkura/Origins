package com.realgotqkura.gui;

import com.realgotqkura.items.OriginGUIItems;
import com.realgotqkura.rebirthToken.RebirthTokenSystem;
import com.realgotqkura.utils.ColorOf;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.sound.sampled.ReverbType;

public class RecipeInventory {

    private Inventory inv;

    public void createGUI(Player player){
        inv = Bukkit.createInventory(null, 45, ColorOf.colorOf("&b&lRebirth Gem Recipe"));

        inv.setItem(10, new RebirthTokenSystem().token());
        inv.setItem(11, new RebirthTokenSystem().token());
        inv.setItem(12, new RebirthTokenSystem().token());
        inv.setItem(21, new RebirthTokenSystem().token());
        inv.setItem(30, new RebirthTokenSystem().token());
        inv.setItem(29, new RebirthTokenSystem().token());
        inv.setItem(28, new RebirthTokenSystem().token());
        inv.setItem(19, new RebirthTokenSystem().token());
        inv.setItem(20, new ItemStack(Material.DIAMOND));
        inv.setItem(25, new RebirthTokenSystem().Gem());
        for(int i = 0; i< inv.getSize(); i++){
            if(inv.getItem(i) == null){
                inv.setItem(i, new OriginGUIItems().GUIGlass());
            }
        }
        player.openInventory(inv);
    }
}
