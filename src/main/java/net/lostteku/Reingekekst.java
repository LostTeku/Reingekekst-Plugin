package net.lostteku;

import net.lostteku.commands.fun.*;
import net.lostteku.events.EntityExplodeListener;
import net.lostteku.events.PlayerFoodListener;
import net.lostteku.events.PlayerMoveListener;
import net.lostteku.utils.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Reingekekst extends JavaPlugin {

    private static Reingekekst plugin;

    private ConfigManager configManager = new ConfigManager();

    @Override
    public void onEnable() {
        plugin = this;
        configManager.loadFiles();

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new EntityExplodeListener(), this);
        pm.registerEvents(new PlayerMoveListener(), this);
        pm.registerEvents(new PlayerFoodListener(), this);

        //getCommand("slap").setExecutor(new SlapCommand());
        getCommand("tnt").setExecutor(new TntCommand());
        getCommand("fire").setExecutor(new FireCommand());
        getCommand("freeze").setExecutor(new FreezeCommand());
        getCommand("starve").setExecutor(new StarveCommand());
        getCommand("nofood").setExecutor(new NoFoodCommand());
    }

    public static Reingekekst getPlugin() {
        return plugin;
    }
}
