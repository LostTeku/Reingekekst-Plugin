package net.lostteku.commands.fun;

import net.lostteku.enums.Messages;
import net.lostteku.utils.TrollFunctions;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StickCommand implements CommandExecutor {

    private TrollFunctions trollFunctions = new TrollFunctions();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player)) return false;

        if(!(sender.hasPermission("keks.*") || sender.hasPermission("keks.stick"))){
            sender.sendMessage(Messages.getCustomMessage(Messages.NO_PERMISSION));
            return false;
        }

        if(args.length != 1){
            sender.sendMessage(Messages.getCustomMessage(Messages.WRONG_COMMAND_ARGUMENTS) + "\n" + "Stick-Arten: \n1: Feuerbälle\n2:Monsterspawn\n3:Explosions\n/stick <id>");
            return true;
        }


      switch (args[0]) {
          case "1": case "2": case "3":
              ItemStack stack = new ItemStack(Material.STICK);
              ItemMeta meta = stack.getItemMeta();

              meta.setDisplayName("§c§lMagie-Stick");
              meta.setUnbreakable(true);
              meta.setItemName(StickTypes.getItemnamebyID(args[0]).getItemname());
              stack.setItemMeta(meta);

              ((Player) sender).getInventory().addItem(stack);
              sender.sendMessage(Messages.getCustomMessage(Messages.MAGIC_WAND_GIVEN));
              return true;
          default:
              sender.sendMessage(Messages.getCustomMessage(Messages.WRONG_COMMAND_ARGUMENTS) + "\n" + "Stick-Arten: \n1: Fireballs\n2:Monsterspawn\n3:Explosions\n/stick <id>");
              return true;

      }
    }

    public enum StickTypes {
        fireball_stick("1", "fireball_stick"),
        monsterspawn_stick("2", "monsterspawn_stick"),
        explosion_stick("3", "explosion_stick");

        private String stickid;
        private String itemname;

        StickTypes(String id, String itemname){
            this.stickid = id;
            this.itemname = itemname;
        }

        public String getStickid() {
            return stickid;
        }

        public String getItemname() {
            return itemname;
        }

        public static StickTypes getItemnamebyID(String id) {
            switch (id){
                case "1":
                    return StickTypes.fireball_stick;
                case "2":
                    return StickTypes.monsterspawn_stick;
                case "3":
                    return StickTypes.explosion_stick;
            }
            return null;
        }
    }
}
