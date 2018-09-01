package com.thebeast572.customgodmode.handlers;

import com.thebeast572.customgodmode.utils.Reference;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class customGamemodeFunctions implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if(customArray.godmodelist.contains(player.getUniqueId())) {
            if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if(player.getItemInHand() != null) {
                    event.setCancelled(true);
                    player.sendMessage(Reference.PREFIX + "§6You cannot " + "§c§lUSE ITEMS" + " §6in " + "§c§lGODMODE!");
                }
            }
        } else {
            return;
        }
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        if(customArray.godmodelist.contains(player.getUniqueId())) {
            event.setCancelled(true);
            player.sendMessage(Reference.PREFIX + "§6You cannot " + "§c§lDROP ITEMS" + " §6in " + "§c§lGODMODE!");
        } else {
            return;
        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if(customArray.godmodelist.contains(player.getUniqueId())) {
            event.setCancelled(true);
            player.sendMessage(Reference.PREFIX + "§6You cannot use " + "§c§lINVENTORY " + "§6in " + "§c§lGODMODE!");
        } else {
            return;
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onInventoryOpen(InventoryOpenEvent event) {
        Player player = (Player) event.getPlayer();
        if(customArray.godmodelist.contains(player.getUniqueId())) {
            event.setCancelled(true);
            Inventory inv = Bukkit.createInventory(null, 9, "§c§lGODMODE Inventory");

            player.openInventory(inv);
        } else {
            return;
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if(customArray.godmodelist.contains(player.getUniqueId())) {
            event.setCancelled(true);
            player.sendMessage(Reference.PREFIX + "§6You cannot break "  + "§c§lBLOCKS" + " §6in " + "§c§lGODMODE!");
        } else {
            return;
        }
    }

    @EventHandler
    public void onEnttiyHit(EntityDamageByEntityEvent event) {
        if(event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            if(customArray.godmodelist.contains(player.getUniqueId())) {
                event.setCancelled(true);
                player.sendMessage(Reference.PREFIX + "§6You cannot hurt other "  + "§c§lENTITIES" + " §6in " + "§c§lGODMODE!");
            } else {
                return;
            }
        }
    }
}
