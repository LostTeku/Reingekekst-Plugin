package net.lostteku.enums;

import net.lostteku.utils.ConfigManager;
import org.bukkit.ChatColor;

public enum Messages {

    NO_PERMISSION("noPermissionMessage"),
    WRONG_COMMAND_ARGUMENTS("wrongCommandArguments"),
    NO_PLAYER("noPlayerFound"),
    OFFLINE_PLAYER("offlinePlayerMessage"),
    ACTION_SUCESS("actionSuccess"),
    MAGIC_WAND_GIVEN("gaveMagicWand");


    private String path;

    Messages(String path) {
        this.path = path;
    }

    public static String getPath(Messages msg) {
        return msg.path;
    }
}



