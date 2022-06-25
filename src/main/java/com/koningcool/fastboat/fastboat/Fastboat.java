package com.koningcool.fastboat.fastboat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Fastboat extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println(ChatColor.GREEN + "FastBoat is enabled!");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.RED + "FastBoat is disabled!");
    }
    @EventHandler
    public void OnVehicleDrive(VehicleMoveEvent event){
        Entity vehicle = event.getVehicle();
        if (vehicle instanceof Boat){
            Boat boat = (Boat) vehicle;
            boat.setVelocity(boat.getVelocity().clone().multiply(10.0D));
            }
        }


}
