package net.lostteku;

import net.lostteku.commands.fun.*;
import net.lostteku.events.*;
import net.lostteku.utils.ConfigManager;
import net.lostteku.utils.TrollInventory;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.MalformedURLException;

public class Reingekekst extends JavaPlugin {

    private static Reingekekst plugin;

    private ConfigManager configManager = new ConfigManager();
    private TrollInventory trollInventory = new TrollInventory();

    @Override
    public void onEnable() {
        plugin = this;
        configManager.loadFiles();


        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new EntityExplodeListener(), this);
        pm.registerEvents(new PlayerMoveListener(), this);
        pm.registerEvents(new PlayerFoodListener(), this);
        pm.registerEvents(new PlayerItemListener(), this);
        pm.registerEvents(new PlayerInventoryListener(), this);

        //getCommand("slap").setExecutor(new SlapCommand());
        getCommand("tnt").setExecutor(new TntCommand());
        getCommand("fire").setExecutor(new FireCommand());
        getCommand("freeze").setExecutor(new FreezeCommand());
        getCommand("starve").setExecutor(new StarveCommand());
        getCommand("nofood").setExecutor(new NoFoodCommand());
        getCommand("stick").setExecutor(new StickCommand());
        getCommand("troll").setExecutor(new TrollCommand());

        trollInventory.createInventory();

    }

    public static Reingekekst getPlugin() {
        return plugin;
    }
}
