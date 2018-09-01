package com.thebeast572.customgodmode;

import com.thebeast572.customgodmode.handlers.customArray;
import com.thebeast572.customgodmode.utils.Reference;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(commandlabel.equalsIgnoreCase("decigod") || commandlabel.equalsIgnoreCase("godmode")) {
                if(player.hasPermission("decigodmode.allow")) {
                    if(customArray.godmodelist.contains(player.getName())) {
                        customArray.godmodelist.remove(player.getName());
                        player.sendMessage(Reference.PREFIX + ChatColor.GOLD + "You are no longer in " + ChatColor.RED + "godmode.");
                    } else {
                        customArray.godmodelist.add(player.getName());
                        player.sendMessage(Reference.PREFIX + ChatColor.GOLD + "You are now in " + ChatColor.RED + "godmode.");
                    }
                }
            }
        }
        return false;
    }
}
