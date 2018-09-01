package com.thebeast572.customgodmode.files;

import com.thebeast572.customgodmode.Main;
import org.bukkit.entity.Player;

import java.io.File;

public class playerFile {

    public static File getPlayerFile(Player player) {
        File playerFile = new File(Main.getPlugin(Main.class).getDataFolder() + File.separator + "playerdata", player.getUniqueId() + ".yml");
        return playerFile;
    }
}
