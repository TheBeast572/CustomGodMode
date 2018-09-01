package com.thebeast572.customgodmode.handlers;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class entityHitByEntity implements Listener {

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
        if(event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if(customArray.godmodelist.contains(player.getName())) {
                event.setCancelled(true);
                player.setHealth(20);
                player.setFoodLevel(20);
            } else {
                return;
            }
        } else {
            return;
        }
    }
}
