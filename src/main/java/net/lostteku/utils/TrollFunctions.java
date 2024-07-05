package net.lostteku.utils;

import net.lostteku.enums.Messages;
import net.lostteku.events.EntityExplodeListener;
import net.lostteku.events.PlayerFoodListener;
import net.lostteku.events.PlayerMoveListener;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;

public class TrollFunctions {

    public void ignitePlayer(Player player, int duration){
        player.setFireTicks(20 * Integer.valueOf(duration));
    }

    public void freezePlayer(Player player) {
        if(PlayerMoveListener.notMovablePlayers.contains(player)){
            PlayerMoveListener.notMovablePlayers.remove(player);
            return;
        }
        PlayerMoveListener.notMovablePlayers.add(player);
    }

    public void nofoodPlayer(Player player){
        if(PlayerFoodListener.nofoodPlayers.contains(player)){
            PlayerFoodListener.nofoodPlayers.remove(player);
            return;
        }
        PlayerFoodListener.nofoodPlayers.add(player);
    }

    public void starvePlayer(Player player) {
        player.setFoodLevel(0);
    }

    public void tntPlayer(Player player) {
        TNTPrimed tnt = player.getWorld().spawn(player.getLocation().add(0, 5,0), TNTPrimed.class);
        EntityExplodeListener.explodeBlocks.add(tnt.getType());
    }

    public void tntFollowPlayer(Player player) {
        TNTPrimed tnt = player.getWorld().spawn(player.getLocation().add(0, 0,0), TNTPrimed.class);
        tnt.setFuseTicks(20*10);
        EntityExplodeListener.explodeBlocks.add(tnt.getType());
        PlayerMoveListener.followtntPlayer.put(player, tnt);
    }

    public void blockFollowPlayer(Player player, Block block) {

    }
}
