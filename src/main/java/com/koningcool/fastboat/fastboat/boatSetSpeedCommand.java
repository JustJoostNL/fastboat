package com.koningcool.fastboat.fastboat;

import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class boatSetSpeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("fastboat.setspeed")) {
                if (args.length == 0) {
                    p.sendMessage(ChatColor.RED + "You did not provide any arguments while running this command. Please try again.");
                } else {
                    if (args.length == 1) {
                        String playerissuedspeed = args[0];
                        Fastboat.getPlugin().getConfig().set("speedmultiplier", Float.parseFloat(playerissuedspeed));
                        Fastboat.getPlugin().saveConfig();
                        Fastboat.getPlugin().boatSpeed = Float.parseFloat(playerissuedspeed);
                        p.sendMessage(ChatColor.GREEN + "The speed has changed to " + playerissuedspeed);
                    }
                }
            }else {
                if (sender instanceof ConsoleCommandSender)
                    System.out.println(ChatColor.RED + "Your not a player!");
                if (sender instanceof BlockCommandSender)
                    System.out.println("Your not a player!");
                if (!p.hasPermission("fastboat.setspeed")){
                    p.sendMessage(ChatColor.RED + "You do not have permission to set the boat speed!");
                }
            }
            return false;
        }
        return false;
    }
}
