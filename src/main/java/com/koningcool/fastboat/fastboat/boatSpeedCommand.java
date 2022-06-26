package com.koningcool.fastboat.fastboat;

import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class boatSpeedCommand implements CommandExecutor {
@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(sender instanceof Player) {
            Player p = (Player) sender;
            int speed = Fastboat.plugin.getConfig().getInt("speedmultiplier");
            p.sendMessage("The current boat speed speed is:" + speed);
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
