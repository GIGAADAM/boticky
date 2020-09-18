package me.gigaadamyt.boticky;

import me.gigaadamyt.boticky.events.Eventy;
import me.gigaadamyt.boticky.ex.BotickyEx;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Main pl;

    @Override
    public void onEnable() {
        pl = this; // Nastaví pl na this (Main.class) používám při registraci eventů nebo BukkitRunnable
        Bukkit.getConsoleSender().sendMessage("§6BOTICKY§a - Plugin byl zapnut!"); // Pošle do konzole zprávu
        getCommand("boticky").setExecutor(new BotickyEx()); // Nastaví executor na příkaz, executor má v sobě vše co příkaz má poté vyvolat


        PluginManager pm = Bukkit.getPluginManager(); // Získá PluginManager přes, který zaregistruji event třídu
        pm.registerEvents(new Eventy(), pl); // Registruje eventy
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§6BOTICKY§c - Plugin byl vypnut."); // Pošle do konzole zprávu.
    }


}
