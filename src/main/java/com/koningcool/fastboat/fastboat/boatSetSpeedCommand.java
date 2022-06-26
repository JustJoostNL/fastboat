package com.koningcool.fastboat.fastboat;

import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class boatSetSpeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if(args.length == 0){
                p.sendMessage("You did not provide any arguments while running this command. Please try again.");
            }else{
                if(args.length == 1){
                    String playerissuedspeed = args[0];
                    Fastboat.plugin.getConfig().set("speedmultiplier", playerissuedspeed);
                    p.sendMessage(ChatColor.GREEN + "The speed has changed to" + playerissuedspeed);
                }
            }
        }
        else{
            if(sender instanceof ConsoleCommandSender)
                System.out.println(ChatColor.RED + "Your not a player!");
            if(sender instanceof BlockCommandSender)
                System.out.println("Your not a player!");
        }
        return false;
    }
}
