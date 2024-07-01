package net.lostteku.commands.fun;

import net.lostteku.Reingekekst;
import net.lostteku.enums.Messages;
import net.lostteku.events.PlayerFoodListener;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NoFoodCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender.hasPermission("keks.*") || sender.hasPermission("keks.nofood"))){
            sender.sendMessage(Messages.getCustomMessage(Messages.NO_PERMISSION));
            return false;
        }
        switch (args.length){
            case 1:
                if(Bukkit.getPlayer(args[0]) == null) { sender.sendMessage(Messages.getCustomMessage(Messages.NO_PLAYER)); return false; }

                Player target = Bukkit.getPlayer(args[0]);

                if(PlayerFoodListener.nofoodPlayers.contains(target)){
                    PlayerFoodListener.nofoodPlayers.remove(target);
                    sender.sendMessage(Messages.getCustomMessage(Messages.ACTION_SUCESS));
                    return true;
                }

                PlayerFoodListener.nofoodPlayers.add(target);
                sender.sendMessage(Messages.getCustomMessage(Messages.ACTION_SUCESS));
                return true;

            default:
                sender.sendMessage(Messages.getCustomMessage(Messages.WRONG_COMMAND_ARGUMENTS) + " " + Reingekekst.getPlugin().getCommand(command.getName()).getUsage());
                return true;
        }
    }
}
