package me.dragonhuntrrr.DragonsUtilityTools;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.w3c.dom.Text;

public class Message {

    public static void player(Player player, String message) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
    public static void console(String message) {
        System.out.println(ChatColor.translateAlternateColorCodes('&', message));
    }
}
