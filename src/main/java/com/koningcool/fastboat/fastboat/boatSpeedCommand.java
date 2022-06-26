package com.koningcool.fastboat.fastboat;

import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class boatSpeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("fastboat.seespeed")) {
                float theboatspeed = Fastboat.getPlugin().boatSpeed;
                p.sendMessage("The current boat speed is: " + theboatspeed);
            }else {
                if (sender instanceof ConsoleCommandSender)
                    System.out.println(ChatColor.RED + "Your not a player!");
                if (sender instanceof BlockCommandSender)
                    System.out.println("Your not a player!");
                if(!p.hasPermission("fastboat.seespeed"))
                    p.sendMessage("You do not have permission to see the boat speed!");
            }



            return false;
        }
        return false;
    }
}
