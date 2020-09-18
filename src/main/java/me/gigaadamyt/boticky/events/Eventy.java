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
    public void move(PlayerMoveEvent e) { // Funkce pro event
        Player p = e.getPlayer(); // Zde získám hráče abych mohl používat p a tím si to zkrátím
        if (!(p.getGameMode().equals(GameMode.CREATIVE) || p.getGameMode().equals(GameMode.SPECTATOR))) { // Zjištuje zda nemá CREATIVE nebo SPECTATOR
            if(p.getInventory().getBoots() == null || p.getInventory().getBoots().getItemMeta() == null || p.getInventory().getBoots().getItemMeta().getDisplayName() == null){ // Zjištuje zda slot pro boty se nerovná null, kvuli NullPointerException to používám
                p.setAllowFlight(false); // Vypíná hráči fly, když si boty sundá ve výšce
                return;
            }
            if (p.getInventory().getBoots().getItemMeta().getDisplayName().contains("§6§lBoticky")) { // Zjištuje zda hráč má ve slotu pro boty item s jmenem "§6§lBoticky"
                p.setAllowFlight(true); // Zapíná hráči fly
                Location loc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ()); // Získává lokaci hráče
                p.getWorld().spawnParticle(Particle.FALLING_DUST, loc, 5); // Spawne particles do světa na přesnou lokaci loc, při pohybu se spawne 5x 1 particle
                p.getWorld().spawnParticle(Particle.REDSTONE, loc, 5); // Spawne particles do světa na přesnou lokaci loc, při pohybu se spawne 5x 1 particle
            } else {
                p.setAllowFlight(false); // Vypne hráči fly
            }
        }
    }


    @EventHandler
    public void event(PlayerToggleFlightEvent e) { // Funkce pro event
        Player p = e.getPlayer(); // Zde získám hráče abych mohl používat p a tím si to zkrátím

        if (!(p.getGameMode().equals(GameMode.CREATIVE) || p.getGameMode().equals(GameMode.SPECTATOR))) { // Zjištuje zda nemá CREATIVE nebo SPECTATOR
            if(p.getInventory().getBoots() == null || p.getInventory().getBoots().getItemMeta() == null || p.getInventory().getBoots().getItemMeta().getDisplayName() == null){ // Zjištuje zda slot pro boty se nerovná null, kvuli NullPointerException to používám
                return;
            }
            if (p.getInventory().getBoots().getItemMeta().getDisplayName().contains("§6§lBoticky")) { // Zjištuje zda hráč má ve slotu pro boty item s jmenem "§6§lBoticky"
                p.setAllowFlight(true); // Zapíná hráči fly
            } else {
                p.setAllowFlight(false); // Vypíná hráči fly
            }
        }

    }

}
