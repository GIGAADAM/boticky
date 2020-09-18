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
        if (s instanceof Player) { // Zjištuje zda-li odesílatel (s) je enum Player (tedy typu Hráč)
            Player p = (Player) s; // Získam z s hráče
            ItemStack botky = new ItemStack(Material.GOLD_BOOTS, 1); // Vytvoří ItemStack
            ItemMeta botkym = botky.getItemMeta(); // Získá ItemMetu itemu z ItemStacku botky
            botkym.setDisplayName("§6§lBoticky"); // Nastaví do IM název itemu
            List<String> botkyl = new ArrayList<String>(); // Vytvoří List, který použíju pro zapsání Loru itemu
            // Přidávám do listu text (text do loru)
            botkyl.add("");
            botkyl.add("§7Pri nasazeni boticek muzete letat!");
            botkyl.add("");

            botkym.setLore(botkyl); // Nastavuje lore do IM
            botky.setItemMeta(botkym); // Nastavuje IM do ItemStacku botky

            p.getInventory().addItem(botky); // Přidá hráči do Inventáře item z ItemStacku botky
            p.sendMessage("§aZiskal jsi boticky!"); // Napíše hráči zprávu

        } else {
            s.sendMessage("§cTento prikaz muze jenom hrac!!"); // Napíše odesílateli zprávu
        }


        return false;
    }
}
