package net.lostteku.events;

import net.lostteku.enums.Messages;
import net.lostteku.utils.TrollFunctions;
import net.lostteku.utils.TrollInventory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PlayerInventoryListener implements Listener {

    private TrollInventory trollInventory = new TrollInventory();
    private TrollFunctions trollFunctions = new TrollFunctions();
    private HashMap<Player, String> trollplayers = new HashMap<>();

    @EventHandler
    public void onInventory(InventoryClickEvent event) {
        if (event.getCurrentItem() == null) return;
        if (!(event.getWhoClicked() instanceof Player)) return;
        if (!event.getView().getTitle().equals("§cTroll-Inventory") && !event.getView().getTitle().equals("§cTroll-Inventory: Player-Select") && !event.getView().getTitle().equals("§cTroll-Inventory: Select Duration"))
            return;
        if (!event.getWhoClicked().hasPermission("keks.troll") || !event.getWhoClicked().isOp()) {
            event.setCancelled(true);
            event.getView().close();
            return;
        }
        event.setCancelled(true);

        switch (event.getCurrentItem().getItemMeta().getItemName()) {
            case "troll_fire":
            case "troll_freeze":
            case "troll_nofood":
            case "troll_starve":
            case "troll_tnt":
            case "troll_followtnt":
                trollplayers.put(((Player) event.getWhoClicked()).getPlayer(), event.getCurrentItem().getItemMeta().getItemName());
                event.getView().close();
                event.getWhoClicked().openInventory(trollInventory.getPlayerSelectInventory());
                break;
            default:
                if(event.getView().getTitle().equals("§cTroll-Inventory: Player-Select")) {
                    Player target = Bukkit.getPlayer(event.getCurrentItem().getItemMeta().getItemName());
                    for (Map.Entry<Player, String> set : trollplayers.entrySet()) {
                        if (set.getKey().equals(((Player) event.getWhoClicked()).getPlayer())) {

                            switch (set.getValue()) {
                                case "troll_fire":
                                    trollFunctions.ignitePlayer(target, 20);
                                    break;
                                case "troll_freeze":
                                    trollFunctions.freezePlayer(target);
                                    break;
                                case "troll_nofood":
                                    trollFunctions.nofoodPlayer(target);
                                    break;
                                case "troll_starve":
                                    trollFunctions.starvePlayer(target);
                                    break;
                                case "troll_tnt":
                                    trollFunctions.tntPlayer(target);
                                    break;
                                case "troll_followtnt":
                                    trollFunctions.tntFollowPlayer(target);
                                    break;
                            }

                        }
                    }
                    event.getView().close();
                    ((Player) event.getWhoClicked()).getPlayer().sendMessage(Messages.getCustomMessage(Messages.ACTION_SUCESS));
                    trollplayers.remove(((Player) event.getWhoClicked()).getPlayer());
                    return;
                }

        }
    }
}
