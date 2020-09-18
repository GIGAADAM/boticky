package me.gigaadamyt.boticky.events;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class Eventy implements Listener {

    @EventHandler
    public void move(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (!(p.getGameMode().equals(GameMode.CREATIVE) || p.getGameMode().equals(GameMode.SPECTATOR))) {
            if(p.getInventory().getBoots() == null || p.getInventory().getBoots().getItemMeta() == null || p.getInventory().getBoots().getItemMeta().getDisplayName() == null){
                p.setAllowFlight(false);
                return;
            }
            if (p.getInventory().getBoots().getItemMeta().getDisplayName().contains("§6§lBoticky")) {
                p.setAllowFlight(true);
                Location loc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ());
                p.getWorld().spawnParticle(Particle.FALLING_DUST, loc, 5);
                p.getWorld().spawnParticle(Particle.REDSTONE, loc, 5);
            } else {
                p.setAllowFlight(false);
            }
        }
    }


    @EventHandler
    public void event(PlayerToggleFlightEvent e) {
        Player p = e.getPlayer();

        if (!(p.getGameMode().equals(GameMode.CREATIVE) || p.getGameMode().equals(GameMode.SPECTATOR))) {
            if(p.getInventory().getBoots() == null || p.getInventory().getBoots().getItemMeta() == null || p.getInventory().getBoots().getItemMeta().getDisplayName() == null){
                return;
            }
            if (p.getInventory().getBoots().getItemMeta().getDisplayName().contains("§6§lBoticky")) {
                p.setAllowFlight(true);
            } else {
                p.setAllowFlight(false);
            }
        }

    }

}
