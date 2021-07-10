package com.realgotqkura.items;

import com.realgotqkura.utils.ColorOf;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class OriginGUIItems {

    public ItemStack GUIGlass(){
        ItemStack glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta meta = glass.getItemMeta();
        meta.setDisplayName(ColorOf.colorOf("&0."));
        glass.setItemMeta(meta);
        return glass;
    }

    public ItemStack Halo(){
        ItemStack halo = new ItemStack(Material.BOOK);
        ItemMeta meta = halo.getItemMeta();
        meta.setDisplayName(ColorOf.colorOf("&eHalo: "));
        List<String> lore = new ArrayList<>();
        lore.add(ColorOf.colorOf("&7Often helping people with their holiness, "));
        lore.add(ColorOf.colorOf("&7Halos are helpful creatures, and weak"));
        lore.add(ColorOf.colorOf("&7when it comes to fighting."));
        lore.add("");
        lore.add(ColorOf.colorOf("&cAbilities:"));
        lore.add(ColorOf.colorOf("&7- &aSmall Appetite: &7 you gain &eSaturation I"));
        lore.add(ColorOf.colorOf("&7- &aSturdy Skin: &7you gain &eResistance II"));
        lore.add(ColorOf.colorOf("&7- &aFeatherweight: &7you gain &eSlow Falling I"));
        lore.add(ColorOf.colorOf("&7- &aWeak Arms: &7you gain &eWeakness I"));
        lore.add(ColorOf.colorOf("&7- &aHoly Ring: &7You have a circle of light shown above the head."));
        lore.add("");
        lore.add(ColorOf.colorOf("&cOrigin Items: "));
        lore.add(ColorOf.colorOf("&7- &aHoly Bible: &7On right click it freezes the entity you're looking"));
        lore.add(ColorOf.colorOf("&7at for 7 seconds (30 block radius)"));
        lore.add(ColorOf.colorOf("&7Cooldown: " + "&b30s"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        halo.setItemMeta(meta);
        return halo;
    }

    public ItemStack Elytrian(){
        ItemStack elytrian = new ItemStack(Material.ELYTRA);
        ItemMeta meta = elytrian.getItemMeta();
        meta.setDisplayName(ColorOf.colorOf("&eElytrian: "));
        List<String> lore = new ArrayList<>();
        lore.add(ColorOf.colorOf("&7Often flying around in the winds, Elytrians"));
        lore.add(ColorOf.colorOf("&7are the fastest origins when it comes"));
        lore.add(ColorOf.colorOf("&7to fly in the high winds."));
        lore.add("");
        lore.add(ColorOf.colorOf("&cAbilities: "));
        lore.add(ColorOf.colorOf("&7- &aVery Soft ground: &7You are able to withstand extreme "));
        lore.add(ColorOf.colorOf("&7fall damage"));
        lore.add(ColorOf.colorOf("&7- &aChestless: &7You are not able to wear a chestplate"));
        lore.add("");
        lore.add(ColorOf.colorOf("&cOrigin Items: "));
        lore.add(ColorOf.colorOf("&7- &aGift of the Winds: &7Every 60 seconds, you are able"));
        lore.add(ColorOf.colorOf("&7to launch about 20 blocks up in the air."));
        lore.add(ColorOf.colorOf("&7- &aWinged: &7You gain an unbreakable elytra with Curse of "));
        lore.add(ColorOf.colorOf("&7binding"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        elytrian.setItemMeta(meta);
        return elytrian;
    }

    public ItemStack Molian(){
        ItemStack molian = new ItemStack(Material.GOLDEN_PICKAXE);
        ItemMeta meta = molian.getItemMeta();
        meta.setDisplayName(ColorOf.colorOf("&eMolian: "));
        List<String> lore = new ArrayList<>();
        lore.add(ColorOf.colorOf("&7Hiding in the ground by other creatures, these"));
        lore.add(ColorOf.colorOf("&7creatures are blind and extremely fast at mining."));
        lore.add("");
        lore.add(ColorOf.colorOf("&cAbilities: "));
        lore.add(ColorOf.colorOf("&7- &aQuick Miner: &7you gain &eHaste II"));
        lore.add(ColorOf.colorOf("&7- &aSturdy skin: &7you gain &eResistance II"));
        lore.add(ColorOf.colorOf("&7- &aWeakling: &7you gain &eWeakness I"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        molian.setItemMeta(meta);
        return molian;
    }

    public ItemStack Avian(){
        ItemStack avian = new ItemStack(Material.FEATHER);
        ItemMeta meta = avian.getItemMeta();
        meta.setDisplayName(ColorOf.colorOf("&eAvian: "));
        List<String> lore = new ArrayList<>();
        lore.add(ColorOf.colorOf("&7The avian race has lost their ability to fly a "));
        lore.add(ColorOf.colorOf("&7long time ago. Now, these peaceful creatures"));
        lore.add(ColorOf.colorOf("&7can be seen gliding from one place to another."));
        lore.add("");
        lore.add(ColorOf.colorOf("&cAbility: "));
        lore.add(ColorOf.colorOf("&7- &aFeatherweight: &7you gain &eSlow Falling I"));
        lore.add(ColorOf.colorOf("&7- &aTailwind: &7you gain &eSpeed I"));
        lore.add(ColorOf.colorOf("&7- &aGold blood: &7You respawn with 10 absorption"));
        lore.add(ColorOf.colorOf("&7hearts."));
        lore.add(ColorOf.colorOf("&7- &aVegetarian: &7You cannot eat any meat foods"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        avian.setItemMeta(meta);
        return avian;
    }

    public ItemStack Ironian(){
        ItemStack ironian = new ItemStack(Material.IRON_INGOT);
        ItemMeta meta = ironian.getItemMeta();
        meta.setDisplayName(ColorOf.colorOf("&eIronian: "));
        List<String> lore = new ArrayList<>();
        lore.add(ColorOf.colorOf("&7Made out of iron and steel, these unknown"));
        lore.add(ColorOf.colorOf("&7creatures walk around and protect others."));
        lore.add("");
        lore.add(ColorOf.colorOf("&cAbilities: "));
        lore.add(ColorOf.colorOf("&7- &aVery Sturdy skin: &7you gain &eResistance II"));
        lore.add(ColorOf.colorOf("&7- &aIron Heart: &7You gain 5 more hearts than normal"));
        lore.add(ColorOf.colorOf("&7- &aSteel legs: &7You gain &eSlowness I"));
        lore.add(ColorOf.colorOf("&7- &aLarge Appetite: &7All food you eat gives you 1/2"));
        lore.add(ColorOf.colorOf("&7of its usual hunger levels"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ironian.setItemMeta(meta);
        return ironian;
    }

    public ItemStack Merlin(){
        ItemStack merlin = new ItemStack(Material.COD);
        ItemMeta meta = merlin.getItemMeta();
        meta.setDisplayName(ColorOf.colorOf("&eMerlin: "));
        List<String> lore = new ArrayList<>();
        lore.add(ColorOf.colorOf("&7These natural inhabitants of the ocean are not used"));
        lore.add(ColorOf.colorOf("&7to being out of the water for too long."));
        lore.add("");
        lore.add(ColorOf.colorOf("&cAbilities: "));
        lore.add(ColorOf.colorOf("&7- &aGills: &7You can breathe underwater"));
        lore.add(ColorOf.colorOf("&7- &aWet Eyes: &7You get &eNight Vision I &7while"));
        lore.add(ColorOf.colorOf("&7underwater"));
        lore.add(ColorOf.colorOf("&7- &aFins: &7You gain &eDolphin Effect I"));
        lore.add(ColorOf.colorOf("&7- &aFeet less: &7You can't wear boots"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        merlin.setItemMeta(meta);
        return merlin;
    }

    public ItemStack Feline(){
        ItemStack phantom = new ItemStack(Material.STRING);
        ItemMeta meta = phantom.getItemMeta();
        meta.setDisplayName(ColorOf.colorOf("&eFeline: "));
        List<String> lore = new ArrayList<>();
        lore.add(ColorOf.colorOf("&7With their cat-like appearance, the Feline scares"));
        lore.add(ColorOf.colorOf("&7creepers. With the dexterity of cats, they always"));
        lore.add(ColorOf.colorOf("&7land safely on their feet."));
        lore.add("");
        lore.add(ColorOf.colorOf("&cAbilities: "));
        lore.add(ColorOf.colorOf("&7- &aAcrobatics: &7You never take fall damage"));
        lore.add(ColorOf.colorOf("&7- &aStrong Ankles: &7you gain &eJump Boost II"));
        lore.add(ColorOf.colorOf("&7- &aNocturnal: &7you gain &eNight Vision I"));
        lore.add(ColorOf.colorOf("&7- &aNine lives: &7You have 1 less hearts than usual"));
        lore.add(ColorOf.colorOf("&7- &aWeak arms: &7You gain &eMining Fatigue I"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        phantom.setItemMeta(meta);
        return phantom;
    }

    public ItemStack Stellar(){
        ItemStack stellar = new ItemStack(Material.NETHERITE_INGOT);
        ItemMeta meta = stellar.getItemMeta();
        meta.setDisplayName(ColorOf.colorOf("&eStellar: "));
        List<String> lore = new ArrayList<>();
        lore.add(ColorOf.colorOf("&7These mysterious creatures coming from outer space"));
        lore.add(ColorOf.colorOf("&7can convert their hands in Netherite while fighting."));
        lore.add("");
        lore.add(ColorOf.colorOf("&cAbilities: "));
        lore.add(ColorOf.colorOf("&7- &aBig heart: &7You gain 10 more hearts than usual"));
        lore.add(ColorOf.colorOf("&7- &aVery Sturdy Skin: &7You gain &eResistance II"));
        lore.add(ColorOf.colorOf("&7- &aNetherite hands: &7After getting hit or "));
        lore.add(ColorOf.colorOf("&7damaging an entity you gain &eStrength I"));
        lore.add(ColorOf.colorOf("&7- &aUnwieldy: &7You cannot wear a shield"));
        lore.add(ColorOf.colorOf("&7- &aLarge Appetite: &7All food you eat gives you 1/2"));
        lore.add(ColorOf.colorOf("&7of its usual hunger levels"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        stellar.setItemMeta(meta);
        return stellar;
    }

    public ItemStack Blazeborn(){
        ItemStack blazeborn = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta meta = blazeborn.getItemMeta();
        meta.setDisplayName(ColorOf.colorOf("&eBlazeborn: "));
        List<String> lore = new ArrayList<>();
        lore.add(ColorOf.colorOf("&7Late descendants of the Blaze, the Blazeborn"));
        lore.add(ColorOf.colorOf("&7are immune to the perils of the Nether."));
        lore.add("");
        lore.add(ColorOf.colorOf("&cAbilites: "));
        lore.add(ColorOf.colorOf("&7- &aFire immunity: &7You gain &eFire Resistance I"));
        lore.add(ColorOf.colorOf("&7- &aBurning Wrath: &7When on fire you gain &eStrength I"));
        lore.add(ColorOf.colorOf("&7- &aHotblooded: &7You're immune to hunger and poison"));
        lore.add(ColorOf.colorOf("&7- &aHydrophobia: &7In Water you get Damaged slowly"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        blazeborn.setItemMeta(meta);
        return blazeborn;
    }

    public ItemStack Enderian(){
        ItemStack enderian = new ItemStack(Material.ENDER_CHEST);
        ItemMeta meta = enderian.getItemMeta();
        meta.setDisplayName(ColorOf.colorOf("&eEnderian: "));
        List<String> lore = new ArrayList<>();
        lore.add(ColorOf.colorOf("&7Born as sons and daughters of the Ender dragon, "));
        lore.add(ColorOf.colorOf("&7Enderians are capable of teleporting but are vulnerable"));
        lore.add(ColorOf.colorOf("&7to water"));
        lore.add("");
        lore.add(ColorOf.colorOf("&cAbilities: "));
        lore.add(ColorOf.colorOf("&7- &aFast Boi: &7You gain &eSpeed I"));
        lore.add(ColorOf.colorOf("&7- &aHydrophobia: &7You get damaged in water"));
        lore.add("");
        lore.add(ColorOf.colorOf("&cOrigin Items: "));
        lore.add(ColorOf.colorOf("&7- &aTeleporter: &7Allows you to teleport using an ender pearl"));
        lore.add(ColorOf.colorOf("&7at any time. &8Cooldown: &b15s"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        enderian.setItemMeta(meta);
        return enderian;
    }

    public ItemStack Arachnid(){
        ItemStack arachnid = new ItemStack(Material.COBWEB);
        ItemMeta meta = arachnid.getItemMeta();
        meta.setDisplayName(ColorOf.colorOf("&eArachnid: "));
        List<String> lore = new ArrayList<>();
        lore.add(ColorOf.colorOf("&7Their climbing abilities and ability to trap their foes"));
        lore.add(ColorOf.colorOf("&7in spiderweb make the Arachnid perfect hunters."));
        lore.add("");
        lore.add(ColorOf.colorOf("&cAbilities: "));
        lore.add(ColorOf.colorOf("&7- &aWebbing: &7Every time you hit a player they get cobwebed"));
        lore.add(ColorOf.colorOf("&7- &aCarnivore: &7You're only allowed to eat meat."));
        lore.add(ColorOf.colorOf("&7- &aFragile: &7You have 3 less hearts than normal"));
        lore.add("");
        lore.add(ColorOf.colorOf("&cOrigin Items: "));
        lore.add(ColorOf.colorOf("&7- &aLeap: &7Launches you forward at very high speeds"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        arachnid.setItemMeta(meta);
        return arachnid;
    }

    public ItemStack Shulk(){
        ItemStack shulk = new ItemStack(Material.SHULKER_BOX);
        ItemMeta meta = shulk.getItemMeta();
        meta.setDisplayName(ColorOf.colorOf("&eShulk: "));
        List<String> lore = new ArrayList<>();
        lore.add(ColorOf.colorOf("&7Related to Shulkers, the bodies of the Shulk "));
        lore.add(ColorOf.colorOf("&7 are outfitted with protective shell-like skin."));
        lore.add("");
        lore.add(ColorOf.colorOf("&cAbilities: "));
        lore.add(ColorOf.colorOf("&7- &aVery Sturdy skin: &7You gain &eResistance II"));
        lore.add(ColorOf.colorOf("&7- &aStrong arms: &7You gain &eStrength I &7When you"));
        lore.add(ColorOf.colorOf("&7get damage or damage an entity"));
        lore.add(ColorOf.colorOf("&7- &aShulk Born: &7You are immune to &eLevitation"));
        lore.add(ColorOf.colorOf("&7- &aUnwieldy: &7You cannot hold a shield"));
        lore.add(ColorOf.colorOf("&7- &aLarge Appetite: &7You get 1/2 the hunger bars that"));
        lore.add(ColorOf.colorOf("&7you would normally get."));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        shulk.setItemMeta(meta);
        return shulk;
    }

    public ItemStack Robotics(){
        ItemStack robotics = new ItemStack(Material.COMPARATOR);
        ItemMeta meta = robotics.getItemMeta();
        meta.setDisplayName(ColorOf.colorOf("&eRobotics: "));
        List<String> lore = new ArrayList<>();
        lore.add(ColorOf.colorOf("&7Decades after they been exiled by humans for their"));
        lore.add(ColorOf.colorOf("&7old crimes, they made their own place to live for."));
        lore.add("");
        lore.add(ColorOf.colorOf("&cAbilities: "));
        lore.add(ColorOf.colorOf("&7- &aSturdy Body: &7You gain &eResistance I"));
        lore.add(ColorOf.colorOf("&7- &aMetal Stomach: &7You don't have to eat"));
        lore.add(ColorOf.colorOf("&7- &aNight Camera: &7You gain &eNight Vision I"));
        lore.add(ColorOf.colorOf("&7- &aCircuit body: &7You're immune to poison and hunger"));
        lore.add(ColorOf.colorOf("&7- &aLeaky Circuits: &7You get damaged by water"));
        lore.add(ColorOf.colorOf("&7- &aRobotic Heart: &7You can't get Regeneration"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        robotics.setItemMeta(meta);
        return robotics;
    }

    public ItemStack Wanderer(){
        ItemStack wanderer = new ItemStack(Material.EMERALD);
        ItemMeta meta = wanderer.getItemMeta();
        meta.setDisplayName(ColorOf.colorOf("&eWanderer: "));
        List<String> lore = new ArrayList<>();
        lore.add(ColorOf.colorOf("&7Learned from the wanderer traders that go all around"));
        lore.add(ColorOf.colorOf("&7the world, these creatures are lucky finding good"));
        lore.add(ColorOf.colorOf("&7loot and convince villages for a discount."));
        lore.add("");
        lore.add(ColorOf.colorOf("&cAbilities: "));
        lore.add(ColorOf.colorOf("&7- &aWanderer Luck: &7You gain &eLuck I"));
        lore.add(ColorOf.colorOf("&7- &aNegotiator: &7You gain &eHero of the village I"));
        lore.add(ColorOf.colorOf("&7- &aHealing Methods: &7You gain &eRegeneration I"));
        lore.add(ColorOf.colorOf("&7- &aLarge Appetite: &7You get 1/2 of the hunger bars"));
        lore.add(ColorOf.colorOf("&7You would normally get."));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        wanderer.setItemMeta(meta);
        return wanderer;
    }

    public ItemStack Explorer(){
        ItemStack wanderer = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta meta = wanderer.getItemMeta();
        meta.setDisplayName(ColorOf.colorOf("&eExplorer: "));
        List<String> lore = new ArrayList<>();
        lore.add(ColorOf.colorOf("&7Brother of the Wanderers, these creatures like to"));
        lore.add(ColorOf.colorOf("&7explore the world at any time with their"));
        lore.add(ColorOf.colorOf("&7speed and small appetite."));
        lore.add("");
        lore.add(ColorOf.colorOf("&cAbilities: "));
        lore.add(ColorOf.colorOf("&7- &aVery Small Appetite: &7You gain &eSaturation I"));
        lore.add(ColorOf.colorOf("&7- &aTempo Boots: &7You gain &eSpeed I"));
        lore.add(ColorOf.colorOf("&7- &aStrong Ankles: &7You gain &eJump Boost I"));
        lore.add(ColorOf.colorOf("&7- &aPerfect Vision: &7You gain &eNight Vision I"));
        lore.add(ColorOf.colorOf("&7- &aSoft ground: &7You get 1/2 of the fall damage"));
        lore.add(ColorOf.colorOf("&7you would normally get."));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        wanderer.setItemMeta(meta);
        return wanderer;
    }

    public ItemStack Leprechaunian(){
        ItemStack wanderer = new ItemStack(Material.GOLD_INGOT);
        ItemMeta meta = wanderer.getItemMeta();
        meta.setDisplayName(ColorOf.colorOf("&eLeprechaun: "));
        List<String> lore = new ArrayList<>();
        lore.add(ColorOf.colorOf("&7Hiding at the end of the rainbow, these creatures"));
        lore.add(ColorOf.colorOf("&7are extremely lucky and they are able to jump"));
        lore.add(ColorOf.colorOf("&7very high."));
        lore.add("");
        lore.add(ColorOf.colorOf("&cAbilities: "));
        lore.add(ColorOf.colorOf("&7- &aThe leprechaun's luck: &7You gain &eLuck V"));
        lore.add(ColorOf.colorOf("&7- &aTempo Boots: &7You gain &eSpeed I"));
        lore.add(ColorOf.colorOf("&7- &aStrong Ankles: &7You gain &eJump Boost I"));
        lore.add(ColorOf.colorOf("&7- &aFragile: &7You have 4 less hearts than normal"));
        lore.add(ColorOf.colorOf("&7- &aLarge Appetite: &7You get 1/2 of the hunger bars"));
        lore.add(ColorOf.colorOf("&7You would normally get."));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        wanderer.setItemMeta(meta);
        return wanderer;
    }




}
