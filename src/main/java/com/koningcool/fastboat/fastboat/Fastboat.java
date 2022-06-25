package com.koningcool.fastboat.fastboat;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public final class Fastboat extends JavaPlugin implements Listener {


    @Override
    public void onLoad(){
        System.out.println(ChatColor.GREEN + "FastBoat loaded!");
    }

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
    public void onVehicleDrive(VehicleMoveEvent event) {
        Entity vehicle = event.getVehicle();
        Entity passenger = (Entity) event.getVehicle().getPassengers();

        if (vehicle instanceof Boat) {
            if (passenger instanceof Player) {
                Player p = (Player) passenger;
                Boat boat = (Boat) vehicle;
                if (p.hasPermission("fastboat.use")) {
                    boat.setVelocity(new Vector(boat.getLocation().getDirection().multiply(1.5).getX(), 0, boat.getLocation().getDirection().multiply(1.5).getZ()));
                } else {
                    p.sendMessage("You do not have permission to use the boat fast, but you can still you the boat!");
                }

            }
        }
    }
}