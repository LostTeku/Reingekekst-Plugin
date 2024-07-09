package net.lostteku.enums;

import net.lostteku.utils.ConfigManager;
import org.bukkit.ChatColor;

public enum DefaultConf {

    PREFIX("prefix", "&a&l-> &e"),
    LANGUAGE("language", "EN");

    private String path;
    private String value;
    private static ConfigManager manager = new ConfigManager();

    DefaultConf(String path, String value) {
        this.path = path;
        this.value = value;
    }

    public String getPath() {
        return path;
    }

    public String getValue() {
        return value;
    }

    public static String getCustomValue(DefaultConf conf){
        return ChatColor.translateAlternateColorCodes('&', manager.getConfigFile("config").getString(conf.getPath()).replace('#', '\n'));
    }
}
