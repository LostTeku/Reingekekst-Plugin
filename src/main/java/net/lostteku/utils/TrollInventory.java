package net.lostteku.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class TrollInventory {

    private Inventory inventory;

    public Inventory createInventory(){

        inventory = Bukkit.createInventory(null, 9*4, "§cTroll-Inventory");

        ItemStack fireItem = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta fireMeta = fireItem.getItemMeta();
        fireMeta.setItemName("troll_fire");
        fireMeta.setDisplayName("§eAnzünden");
        fireItem.setItemMeta(fireMeta);

        ItemStack freezeItem = new ItemStack(Material.SNOWBALL);
        ItemMeta freezeMeta = freezeItem.getItemMeta();
        freezeMeta.setItemName("troll_freeze");
        freezeMeta.setDisplayName("§bEinfrieren");
        freezeItem.setItemMeta(freezeMeta);

        ItemStack nofooditem = new ItemStack(Material.ROTTEN_FLESH);
        ItemMeta nofoodMeta = nofooditem.getItemMeta();
        nofoodMeta.setItemName("troll_nofood");
        nofoodMeta.setDisplayName("§aEssen blockieren");
        nofooditem.setItemMeta(nofoodMeta);

        ItemStack starveItem = new ItemStack(Material.CHICKEN);
        ItemMeta starveMeta = starveItem.getItemMeta();
        starveMeta.setItemName("troll_starve");
        starveMeta.setDisplayName("§aVerhungern");
        starveItem.setItemMeta(starveMeta);

        ItemStack stickItem = new ItemStack(Material.STICK);
        ItemMeta stickMeta = stickItem.getItemMeta();
        stickMeta.setItemName("troll_stick");
        stickMeta.setDisplayName("§dMagischer Stick");
        stickItem.setItemMeta(stickMeta);

        ItemStack tntItem = new ItemStack(Material.TNT);
        ItemMeta tntMeta = tntItem.getItemMeta();
        tntMeta.setItemName("troll_tnt");
        tntMeta.setDisplayName("§4Fallendes TNT");
        tntItem.setItemMeta(tntMeta);

        ItemStack followtntItem = new ItemStack(Material.TNT_MINECART);
        ItemMeta followtntMeta = followtntItem.getItemMeta();
        followtntMeta.setItemName("troll_followtnt");
        followtntMeta.setDisplayName("§4Verfolgendes TNT");
        followtntItem.setItemMeta(followtntMeta);

        inventory.setItem(11, fireItem);
        inventory.setItem(12, freezeItem);
        inventory.setItem(13, nofooditem);
        inventory.setItem(14, starveItem);
        inventory.setItem(15, stickItem);
        inventory.setItem(20, tntItem);
        inventory.setItem(21, followtntItem);

        return inventory;
    }

    public Inventory getInventory() {
        return inventory == null ? createInventory() : inventory;
    }

    public Inventory getPlayerSelectInventory(){
        Inventory playerselectinventory = Bukkit.createInventory(null, 9*4, "§cTroll-Inventory: Player-Select");


        ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) itemStack.getItemMeta();
        int i = 0;

        for(Player player : Bukkit.getOnlinePlayers()){
            meta.setOwningPlayer(player);
            meta.setItemName(player.getName());
            meta.setDisplayName(player.getName());
            itemStack.setItemMeta(meta);

            if(!(i > 35)) playerselectinventory.setItem(i, itemStack);

            i++;
        }
        return playerselectinventory;
    }

    public Inventory getDurationInventory(){
        Inventory durationinventory = Bukkit.createInventory(null, 9, "§cTroll-Inventory: Select Duration");

        ItemStack itemStack = new ItemStack(Material.BEDROCK);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setItemName("5");
        meta.setDisplayName("5 Sekunden");
        itemStack.setItemMeta(meta);

        durationinventory.setItem(1, itemStack);
        return durationinventory;
    }
}
