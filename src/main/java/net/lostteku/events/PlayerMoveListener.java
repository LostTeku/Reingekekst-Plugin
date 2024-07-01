package net.lostteku.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class PlayerMoveListener implements Listener {

    public static ArrayList<Player> notMovablePlayers = new ArrayList<>();

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if(notMovablePlayers.contains(event.getPlayer())){
            event.setCancelled(true);
        }
    }
}
