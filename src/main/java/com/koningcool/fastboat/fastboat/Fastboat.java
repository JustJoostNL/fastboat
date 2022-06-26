package com.koningcool.fastboat.fastboat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public final class Fastboat extends JavaPlugin implements Listener {

    public static Fastboat plugin;

    @Override
    public void onLoad() {
        System.out.println(ChatColor.GREEN + "FastBoat loaded!");
    }

    @Override
    public void onEnable() {
        plugin = this;
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("setboatspeed").setExecutor(new boatSetSpeedCommand());
        getCommand("boatspeed").setExecutor(new boatSpeedCommand());

        System.out.println(ChatColor.GREEN + "FastBoat is enabled!");
        System.out.println(ChatColor.RED + "Warning, only change the config file with /setboatspeed [your speed here]");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.RED + "FastBoat is disabled!");
    }

    @EventHandler
    public void onVehicleDrive(VehicleMoveEvent event) {
        Entity vehicle = event.getVehicle();
        boolean emptycheck = event.getVehicle().isEmpty();
        ArrayList passenger = (ArrayList) event.getVehicle().getPassengers();

        if (vehicle instanceof Boat) {
            if (passenger instanceof Player) {
                Player p = (Player) passenger;
                Boat boat = (Boat) vehicle;
                if (p.hasPermission("fastboat.use")) {
                    int speed = getConfig().getInt("speedmultiplier");
                    boat.setVelocity(new Vector(boat.getLocation().getDirection().clone().multiply(speed).getX(), 0, boat.getLocation().getDirection().clone().multiply(speed).getZ()));
                } else {
                    p.sendMessage("You do not have permission to use the boat fast, but you can still you the boat!");
                }

            }
        }
    }
}