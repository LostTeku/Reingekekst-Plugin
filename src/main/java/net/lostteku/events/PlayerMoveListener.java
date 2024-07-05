package net.lostteku.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerMoveListener implements Listener {

    public static ArrayList<Player> notMovablePlayers = new ArrayList<>();
    public static HashMap<Player, TNTPrimed> followtntPlayer = new HashMap<>();


    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if(notMovablePlayers.contains(event.getPlayer())){
            event.setCancelled(true);
        }

        if(followtntPlayer.containsKey(event.getPlayer())){
            if(followtntPlayer.get(event.getPlayer()) != null) {
                followtntPlayer.get(event.getPlayer()).teleport(event.getPlayer(), PlayerTeleportEvent.TeleportCause.PLUGIN);
                return;
            }
            followtntPlayer.remove(event.getPlayer());
        }
    }
}
