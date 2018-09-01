package com.thebeast572.customgodmode;

import com.thebeast572.customgodmode.handlers.customArray;
import com.thebeast572.customgodmode.utils.Reference;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.thebeast572.customgodmode.files.playerFile.getPlayerFile;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(commandlabel.equalsIgnoreCase("decigod") || commandlabel.equalsIgnoreCase("godmode")) {
                if(player.hasPermission("decigodmode.allow")) {

                    if(customArray.godmodelist.contains(player.getUniqueId())) {
                        customArray.godmodelist.remove(player.getUniqueId());
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(Reference.PREFIX + "§6You are no longer in " + "§c§lGODMODE.");
                    } else {
                        Date now = new Date();
                        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy [HH:mm:ss]");

                        if(!(getPlayerFile(player).exists())) {
                            File playerFile = getPlayerFile(player);
                            YamlConfiguration playerData = YamlConfiguration.loadConfiguration(playerFile);

                            playerData.set("player-name", player.getName());
                            playerData.set("last-login", format.format(now));
                            playerData.set("last-used-command", format.format(now));

                            try {
                                playerData.save(playerFile);
                            } catch(IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            File playerFile = getPlayerFile(player);
                            YamlConfiguration playerData = YamlConfiguration.loadConfiguration(playerFile);

                            playerData.set("last-login", format.format(now));
                            playerData.set("last-used-command", format.format(now));

                            try {
                                playerData.save(playerFile);
                            } catch(IOException e) {
                                e.printStackTrace();
                            }
                        }
                        customArray.godmodelist.add(player.getUniqueId());
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(Reference.PREFIX + "§6You are now in " + "§c§lGODMODE.");
                    }
                }
            }
        }
        return false;
    }
}
