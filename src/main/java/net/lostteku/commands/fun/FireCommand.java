package net.lostteku.commands.fun;

import net.lostteku.Reingekekst;
import net.lostteku.enums.Messages;
import net.lostteku.utils.ConfigManager;
import net.lostteku.utils.TrollFunctions;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FireCommand implements CommandExecutor {

    private TrollFunctions trollFunctions = new TrollFunctions();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender.hasPermission("keks.*") || sender.hasPermission("keks.fire"))){
            sender.sendMessage(ConfigManager.getMessage(Messages.NO_PERMISSION));
            return false;
        }
        switch (args.length){
            case 2:
                if(Bukkit.getPlayer(args[0]) == null) { sender.sendMessage(ConfigManager.getMessage(Messages.NO_PLAYER)); return false; }

                trollFunctions.ignitePlayer( Bukkit.getPlayer(args[0]), Integer.valueOf(args[1]));

                sender.sendMessage(ConfigManager.getMessage(Messages.ACTION_SUCESS));
                return true;
            default:
                sender.sendMessage(ConfigManager.getMessage(Messages.WRONG_COMMAND_ARGUMENTS) + " " + Reingekekst.getPlugin().getCommand(command.getName()).getUsage());
                return true;
        }
    }
}
