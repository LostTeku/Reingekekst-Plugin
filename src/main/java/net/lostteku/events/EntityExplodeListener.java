package net.lostteku.events;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import java.util.ArrayList;

public class EntityExplodeListener implements Listener {

    public static ArrayList<EntityType> explodeBlocks = new ArrayList<>();

    @EventHandler
    public void onExplode(EntityExplodeEvent e) {
        if(explodeBlocks.contains(e.getEntityType())){
            explodeBlocks.remove(e.getEntityType());
            e.getEntity().getWorld().createExplosion(e.getLocation(), 10F, false, false);
            e.setCancelled(true);
        }
    }
}
