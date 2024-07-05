package net.lostteku.events;

import org.bukkit.Location;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerItemListener implements Listener {

    @EventHandler
    public void onItem(PlayerInteractEvent event){
        if(!event.getPlayer().hasPermission("keks.stick")) return;
        if(!event.getAction().equals(Action.LEFT_CLICK_AIR)) return;
        if(event.getItem() == null) return;
        if(event.getItem().getItemMeta() == null) return;
        if(!event.getItem().getItemMeta().isUnbreakable()) return;

        if(event.getItem().getItemMeta().getItemName().equals("fireball_stick")){
            event.getPlayer().launchProjectile(Fireball.class);
        }
        if(event.getItem().getItemMeta().getItemName().equals("monsterspawn_stick")){
            event.getPlayer().getWorld().spawn(event.getPlayer().getTargetBlock(null, 100).getLocation(), Zombie.class);
        }
        if(event.getItem().getItemMeta().getItemName().equals("explosion_stick")){
            event.getPlayer().getWorld().createExplosion(event.getPlayer().getTargetBlock(null, 100).getLocation(), 10);
        }
    }
}
