package net.lostteku.events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import java.util.ArrayList;

public class PlayerFoodListener implements Listener {

    public static ArrayList<Player> nofoodPlayers = new ArrayList<>();

    @EventHandler
    public void onFeed(FoodLevelChangeEvent event){
        if(event.getEntityType() == EntityType.PLAYER){
            if(nofoodPlayers.contains(event.getEntity())){
                event.setCancelled(true);
            }
        }
    }
}
