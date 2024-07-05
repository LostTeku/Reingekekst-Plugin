package net.lostteku.commands.fun;

import net.lostteku.Reingekekst;
import net.lostteku.enums.Messages;
import net.lostteku.events.PlayerMoveListener;
import net.lostteku.utils.TrollFunctions;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreezeCommand implements CommandExecutor {

    private TrollFunctions trollFunctions = new TrollFunctions();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender.hasPermission("keks.*") || sender.hasPermission("keks.freeze"))){
            sender.sendMessage(Messages.getCustomMessage(Messages.NO_PERMISSION));
            return false;
        }
        switch (args.length){
            case 1:
                if(Bukkit.getPlayer(args[0]) == null) { sender.sendMessage(Messages.getCustomMessage(Messages.NO_PLAYER)); return false; }

                trollFunctions.freezePlayer(Bukkit.getPlayer(args[0]));

                return true;

            default:
                sender.sendMessage(Messages.getCustomMessage(Messages.WRONG_COMMAND_ARGUMENTS) + " " + Reingekekst.getPlugin().getCommand(command.getName()).getUsage());
                return true;
        }
    }
}
