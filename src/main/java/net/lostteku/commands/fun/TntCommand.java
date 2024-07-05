package net.lostteku.commands.fun;

import net.lostteku.Reingekekst;
import net.lostteku.enums.Messages;
import net.lostteku.events.EntityExplodeListener;
import net.lostteku.utils.TrollFunctions;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;

public class TntCommand implements CommandExecutor {

    private TrollFunctions trollFunctions = new TrollFunctions();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player)) return false;
        if(!(sender.hasPermission("keks.*") || sender.hasPermission("keks.tnt"))){
            sender.sendMessage(Messages.getCustomMessage(Messages.NO_PERMISSION));
            return false;
        }
        switch (args.length){
            case 1:
                if(Bukkit.getPlayer(args[0]) == null) { sender.sendMessage(Messages.getCustomMessage(Messages.NO_PLAYER)); return false; }

                trollFunctions.tntPlayer(Bukkit.getPlayer(args[0]));

                sender.sendMessage(Messages.getCustomMessage(Messages.ACTION_SUCESS));
                return true;
            default:
                sender.sendMessage(Messages.getCustomMessage(Messages.WRONG_COMMAND_ARGUMENTS) + " " + Reingekekst.getPlugin().getCommand(command.getName()).getUsage());
                return true;
        }
    }
}
