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
        pl = this;
        Bukkit.getConsoleSender().sendMessage("§6BOTICKY§a - Plugin byl zapnut!");
        getCommand("boticky").setExecutor(new BotickyEx());



        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Eventy(), pl);
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§6BOTICKY§c - Plugin byl vypnut.");
    }


}
