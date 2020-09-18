package me.gigaadamyt.boticky.ex;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class BotickyEx implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if (s instanceof Player) {
            Player p = (Player) s;
            ItemStack botky = new ItemStack(Material.GOLD_BOOTS, 1);
            ItemMeta botkym = botky.getItemMeta();
            botkym.setDisplayName("§6§lBoticky");
            List<String> botkyl = new ArrayList<String>();
            botkyl.add("");
            botkyl.add("§7Pri nasazeni boticek muzete letat!");
            botkyl.add("");
            botkym.setLore(botkyl);
            botky.setItemMeta(botkym);

            p.getInventory().addItem(botky);
            p.sendMessage("§aZiskal jsi boticky!");

        } else {
            s.sendMessage("§cTento prikaz muze jenom hrac!!");
        }


        return false;
    }
}