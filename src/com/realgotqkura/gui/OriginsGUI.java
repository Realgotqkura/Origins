package com.realgotqkura.gui;

import com.realgotqkura.items.OriginGUIItems;
import com.realgotqkura.utils.ColorOf;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class OriginsGUI {

    public Inventory gui;

    public void createGUI(Player player){
        gui = Bukkit.createInventory(null, 54, ColorOf.colorOf("&3&lChoose Your Origin: "));

        //Setting slots
        gui.setItem(10, new OriginGUIItems().Halo());
        gui.setItem(12, new OriginGUIItems().Elytrian());
        gui.setItem(14, new OriginGUIItems().Avian());
        gui.setItem(16, new OriginGUIItems().Molian());
        gui.setItem(19, new OriginGUIItems().Ironian());
        gui.setItem(21, new OriginGUIItems().Merlin());
        gui.setItem(23, new OriginGUIItems().Feline());
        gui.setItem(25, new OriginGUIItems().Stellar());
        gui.setItem(28, new OriginGUIItems().Blazeborn());
        gui.setItem(30, new OriginGUIItems().Enderian());
        gui.setItem(32, new OriginGUIItems().Arachnid());
        gui.setItem(34, new OriginGUIItems().Shulk());
        gui.setItem(37, new OriginGUIItems().Robotics());
        gui.setItem(39, new OriginGUIItems().Wanderer());
        gui.setItem(41, new OriginGUIItems().Explorer());
        gui.setItem(43, new OriginGUIItems().Leprechaunian());

        for(int i = 0; i < gui.getSize(); i++){
            if(gui.getItem(i) == null){
                gui.setItem(i, new OriginGUIItems().GUIGlass());
            }
        }
        player.openInventory(gui);

    }
}
