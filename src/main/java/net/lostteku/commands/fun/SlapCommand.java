package net.lostteku.commands.fun;

import net.lostteku.Reingekekst;
import net.lostteku.enums.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SlapCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender.hasPermission("keks.*") || sender.hasPermission("keks.slap"))){
            sender.sendMessage(Messages.getCustomMessage(Messages.NO_PERMISSION));
            return false;
        }
        switch (args.length){
            case 1:
                if(Bukkit.getPlayer(args[0]) == null) { sender.sendMessage(Messages.getCustomMessage(Messages.NO_PLAYER)); return false; }
                Player target = Bukkit.getPlayer(args[0]);

                Location loc = target.getLocation();
                loc.add(5, 5, 5);
                target.getLocation().setX(loc.getX() + 10);
                target.getLocation().setY(loc.getY());
                target.getLocation().setZ(loc.getZ());
                target.getLocation().setYaw(loc.getYaw() + 5);

                target.teleport(loc);
                target.damage(0.5);
                target.playSound(target.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_BLAST, 1, 1);

                sender.sendMessage(Messages.getCustomMessage(Messages.ACTION_SUCESS));
                return true;
            default:
                sender.sendMessage(Messages.getCustomMessage(Messages.WRONG_COMMAND_ARGUMENTS) + " " + Reingekekst.getPlugin().getCommand(command.getName()).getUsage());
                return true;
        }
    }
}
