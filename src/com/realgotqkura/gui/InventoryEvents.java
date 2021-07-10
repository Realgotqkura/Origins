package com.realgotqkura.gui;

import com.realgotqkura.items.OriginGUIItems;
import com.realgotqkura.items.OriginItems;
import com.realgotqkura.origin.*;
import com.realgotqkura.origins.OriginsMain;
import com.realgotqkura.utils.ColorOf;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class InventoryEvents implements Listener {

    @EventHandler
    public void InvClick2(InventoryClickEvent event){
        if(!event.getView().getTitle().equals(ColorOf.colorOf("&b&lRebirth Gem Recipe"))){
            return;
        }

        event.setCancelled(true);
    }

    @EventHandler
    public void InvClick(InventoryClickEvent event){
        if(!event.getView().getTitle().equals(ColorOf.colorOf("&3&lChoose Your Origin: "))){
            return;
        }
        List<String> uuids = new ArrayList<>();
        for(Player player : Bukkit.getOnlinePlayers()){
            uuids.add(player.getUniqueId().toString());
        }
        for(OfflinePlayer player : Bukkit.getOfflinePlayers()){
            if(!uuids.contains(player.getUniqueId().toString())){
                uuids.add(player.getUniqueId().toString());
            }
        }

        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();
        OriginsMain main = OriginsMain.getPlugin(OriginsMain.class);
        if(!event.getCurrentItem().isSimilar(new OriginGUIItems().GUIGlass())){
            player.getInventory().setItem(8, new ItemStack(Material.AIR));
            try {
                if (player.getInventory().getChestplate().isSimilar(new OriginItems().Elytra())) {
                    player.getInventory().setChestplate(new ItemStack(Material.AIR));
                }
            }catch(Exception ignored){

            }
        }
        if(event.getSlot() == 10){
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Origin", "Halo");
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Username", player.getName());
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".UUID", player.getUniqueId().toString());
            main.getConfig().set("Origins.UUIDS", uuids);
            main.saveConfig();
            new Halo().HaloRunnable(player);
            new Halo().EquipHaloItem(player);
            player.closeInventory();
            return;
        }
        if(event.getSlot() == 12){
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Origin", "Elytrian");
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Username", player.getName());
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".UUID", player.getUniqueId().toString());
            main.getConfig().set("Origins.UUIDS", uuids);
            main.saveConfig();
            new Elytrian().ElytrianItems(player);
            new Elytrian().ElyrianRunnable(player);
            player.closeInventory();
            return;
        }
        if(event.getSlot() == 14){
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Origin", "Avian");
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Username", player.getName());
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".UUID", player.getUniqueId().toString());
            main.getConfig().set("Origins.UUIDS", uuids);
            main.saveConfig();
            new Avian().AvianRunnable(player);
            player.closeInventory();
            return;
        }
        if(event.getSlot() == 16){
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Origin", "Molian");
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Username", player.getName());
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".UUID", player.getUniqueId().toString());
            main.getConfig().set("Origins.UUIDS", uuids);
            main.saveConfig();
            new Molian().MolianRunnable(player);
            player.closeInventory();
            return;
        }
        if(event.getSlot() == 19){
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Origin", "Ironian");
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Username", player.getName());
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".UUID", player.getUniqueId().toString());
            main.getConfig().set("Origins.UUIDS", uuids);
            main.saveConfig();
            new Ironian().IronianRunnable(player);
            player.closeInventory();
            return;
        }
        if(event.getSlot() == 21){
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Origin", "Merlin");
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Username", player.getName());
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".UUID", player.getUniqueId().toString());
            main.getConfig().set("Origins.UUIDS", uuids);
            main.saveConfig();
            new Merlin().MerlinRunnable(player);
            player.closeInventory();
            return;
        }
        if(event.getSlot() == 23){
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Origin", "Feline");
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Username", player.getName());
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".UUID", player.getUniqueId().toString());
            main.getConfig().set("Origins.UUIDS", uuids);
            main.saveConfig();
            new Feline().FelineRunnable(player);
            player.closeInventory();
            return;
        }
        if(event.getSlot() == 25){
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Origin", "Stellar");
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Username", player.getName());
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".UUID", player.getUniqueId().toString());
            main.getConfig().set("Origins.UUIDS", uuids);
            main.saveConfig();
            new Stellar().StellarRunnable(player);
            player.closeInventory();
            return;
        }
        if(event.getSlot() == 28){
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Origin", "Blazeborn");
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Username", player.getName());
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".UUID", player.getUniqueId().toString());
            main.getConfig().set("Origins.UUIDS", uuids);
            main.saveConfig();
            new Blazeborn().BlazebornRunnable(player);
            player.closeInventory();
            return;
        }
        if(event.getSlot() == 30){
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Origin", "Enderian");
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Username", player.getName());
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".UUID", player.getUniqueId().toString());
            main.getConfig().set("Origins.UUIDS", uuids);
            main.saveConfig();
            new Enderian().EnderianRunnable(player);
            new Enderian().EquipEnderianItem(player);
            player.closeInventory();
            return;
        }
        if(event.getSlot() == 32){
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Origin", "Arachnid");
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Username", player.getName());
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".UUID", player.getUniqueId().toString());
            main.getConfig().set("Origins.UUIDS", uuids);
            main.saveConfig();
            new Arachnid().EquipArachnidItem(player);
            new Arachnid().ArachnidRunnable(player);
            player.closeInventory();
            return;
        }
        if(event.getSlot() == 34){
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Origin", "Shulk");
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Username", player.getName());
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".UUID", player.getUniqueId().toString());
            main.getConfig().set("Origins.UUIDS", uuids);
            main.saveConfig();
            new Shulk().ShulkRunnable(player);
            player.closeInventory();
            return;
        }
        if(event.getSlot() == 37){
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Origin", "Robotics");
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Username", player.getName());
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".UUID", player.getUniqueId().toString());
            main.getConfig().set("Origins.UUIDS", uuids);
            main.saveConfig();
            new Robotics().RoboticsRunnable(player);
            player.closeInventory();
            return;
        }
        if(event.getSlot() == 39){
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Origin", "Wanderer");
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Username", player.getName());
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".UUID", player.getUniqueId().toString());
            main.getConfig().set("Origins.UUIDS", uuids);
            main.saveConfig();
            new Wanderer().WandererRunnable(player);
            player.closeInventory();
            return;
        }
        if(event.getSlot() == 41){
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Origin", "Explorer");
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Username", player.getName());
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".UUID", player.getUniqueId().toString());
            main.getConfig().set("Origins.UUIDS", uuids);
            main.saveConfig();
            new Explorer().ExplorerRunnable(player);
            player.closeInventory();
            return;
        }
        if(event.getSlot() == 43){
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Origin", "Leprechaun");
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".Username", player.getName());
            main.getConfig().set("Origins." + player.getUniqueId().toString() + ".UUID", player.getUniqueId().toString());
            main.getConfig().set("Origins.UUIDS", uuids);
            main.saveConfig();
            new Leprechaun().LeprechaunRunnable(player);
            player.closeInventory();
            return;
        }

    }
}
