package net.lostteku.commands.fun;

import net.lostteku.enums.Messages;
import net.lostteku.utils.ConfigManager;
import net.lostteku.utils.TrollInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TrollCommand implements CommandExecutor {

    private TrollInventory trollInventory = new TrollInventory();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player)) return false;
        if(!(sender.hasPermission("keks.*") || sender.hasPermission("keks.troll"))){
            sender.sendMessage(ConfigManager.getMessage(Messages.NO_PERMISSION));
            return false;
        }

        ((Player) sender).openInventory(trollInventory.getInventory());
        return true;
    }
}
