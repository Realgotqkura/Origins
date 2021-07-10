package com.realgotqkura.origins;

import com.realgotqkura.commands.GetPlayerOrigins;
import com.realgotqkura.commands.GetToken;
import com.realgotqkura.commands.OriginsOpenGUI;
import com.realgotqkura.events.*;
import com.realgotqkura.gui.InventoryEvents;
import com.realgotqkura.items.OriginItems;
import com.realgotqkura.origin.*;
import com.realgotqkura.rebirthToken.RebirthTokenSystem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OriginsMain extends JavaPlugin {

    @Override
    public void onEnable(){
        this.saveDefaultConfig();
        System.out.println("Enabling Origins.");

        //Events
        this.getServer().getPluginManager().registerEvents(new JoinEvent(),this);
        this.getServer().getPluginManager().registerEvents(new InventoryEvents(), this);
        this.getServer().getPluginManager().registerEvents(new DropEvents(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerInventory(),this);
        this.getServer().getPluginManager().registerEvents(new PlayerItemClick(), this);
        this.getServer().getPluginManager().registerEvents(new OriginDeathEvent(), this);
        this.getServer().getPluginManager().registerEvents(new Elytrian(), this);
        this.getServer().getPluginManager().registerEvents(new Avian(), this);
        this.getServer().getPluginManager().registerEvents(new Ironian(), this);
        this.getServer().getPluginManager().registerEvents(new Stellar(), this);
        this.getServer().getPluginManager().registerEvents(new Enderian(), this);
        this.getServer().getPluginManager().registerEvents(new Arachnid(), this);
        this.getServer().getPluginManager().registerEvents(new RebirthTokenSystem(), this);

        //Commands
        this.getCommand("originsOpenGUI").setExecutor(new OriginsOpenGUI(this));
        this.getCommand("getPlayerOrigins").setExecutor(new GetPlayerOrigins());
        this.getCommand("gettoken").setExecutor(new GetToken());



        checkOrigin();

    }

    @Override
    public void onDisable(){
        System.out.println("Disabling Origins.");

    }

    public void checkOrigin(){
        this.reloadConfig();
        List<String> uuids = new ArrayList<>();
        for(Player player : Bukkit.getOnlinePlayers()){
            uuids.add(player.getUniqueId().toString());

        }
        for(String uuid : uuids){
            Player newPlayer = Bukkit.getPlayer(UUID.fromString(uuid));
            if(this.getConfig().getString("Origins." + uuid + ".Origin").equals("Halo")){
                new Halo().HaloRunnable(newPlayer);
                new Halo().EquipHaloItem(newPlayer);
                return;
            }
            if(this.getConfig().getString("Origins." + uuid + ".Origin").equals("Elytrian")){
                new Elytrian().ElytrianItems(newPlayer);
                new Elytrian().ElyrianRunnable(newPlayer);
                return;
            }
            if(this.getConfig().getString("Origins." + uuid + ".Origin").equals("Avian")){
                new Avian().AvianRunnable(newPlayer);
                return;
            }
            if(this.getConfig().getString("Origins." + uuid + ".Origin").equals("Molian")){
                new Molian().MolianRunnable(newPlayer);
                return;
            }
            if(this.getConfig().getString("Origins." + uuid + ".Origin").equals("Ironian")){
                new Ironian().IronianRunnable(newPlayer);
                return;
            }
            if(this.getConfig().getString("Origins." + uuid + ".Origin").equals("Merlin")){
                new Merlin().MerlinRunnable(newPlayer);
                return;
            }
            if(this.getConfig().getString("Origins." + uuid + ".Origin").equals("Feline")){
                new Feline().FelineRunnable(newPlayer);
                return;
            }
            if(this.getConfig().getString("Origins." + uuid + ".Origin").equals("Stellar")){
                new Stellar().StellarRunnable(newPlayer);
                return;
            }
            if(this.getConfig().getString("Origins." + uuid + ".Origin").equals("Blazeborn")){
                new Blazeborn().BlazebornRunnable(newPlayer);
                return;
            }
            if(this.getConfig().getString("Origins." + uuid + ".Origin").equals("Enderian")){
                new Enderian().EnderianRunnable(newPlayer);
                new Enderian().EquipEnderianItem(newPlayer);
                return;
            }
            if(this.getConfig().getString("Origins." + uuid + ".Origin").equals("Arachnid")){
                new Arachnid().ArachnidRunnable(newPlayer);
                new Arachnid().EquipArachnidItem(newPlayer);
                return;
            }
            if(this.getConfig().getString("Origins." + uuid + ".Origin").equals("Shulk")){
                new Shulk().ShulkRunnable(newPlayer);
                return;
            }
            if(this.getConfig().getString("Origins." + uuid + ".Origin").equals("Robotics")){
                new Robotics().RoboticsRunnable(newPlayer);
                return;
            }
            if(this.getConfig().getString("Origins." + uuid + ".Origin").equals("Wanderer")){
                new Wanderer().WandererRunnable(newPlayer);
                return;
            }
            if(this.getConfig().getString("Origins." + uuid + ".Origin").equals("Explorer")){
                new Explorer().ExplorerRunnable(newPlayer);
                return;
            }
            if(this.getConfig().getString("Origins." + uuid + ".Origin").equals("Leprechaun")){
                new Leprechaun().LeprechaunRunnable(newPlayer);
                return;
            }

        }
    }
}
