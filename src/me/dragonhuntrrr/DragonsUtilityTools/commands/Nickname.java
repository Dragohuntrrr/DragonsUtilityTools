package me.dragonhuntrrr.DragonsUtilityTools.commands;

import me.dragonhuntrrr.DragonsUtilityTools.Message;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nickname implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("nickname")) {

            if (sender instanceof Player) {

                Player player = (Player) sender;
                if (args.length == 2) {

                    if (args[0].equalsIgnoreCase("remove")) {

                        player.setDisplayName(player.getName());
                        player.setPlayerListName(player.getName());

                        Message.player(player, "&cRemoved nickname!");
                    } else if (args[0].equalsIgnoreCase("set")) {

                        String nickName = args[1];
                        Player nickNamePlayer = Bukkit.getServer().getPlayer(args[1]);

                        if (player.hasPermission("utilityTools.nick.colorcodes")) {

                            if (nickNamePlayer != null) {

                                player.setDisplayName(ChatColor.translateAlternateColorCodes('&', nickName + "&r"));
                                player.setPlayerListName(ChatColor.translateAlternateColorCodes('&', nickName + "&r"));
                                Message.player(player, "&aNickname set!");
                            } else {

                                if (player.hasPermission("utilityTools.nick.override")) {

                                    player.setDisplayName(ChatColor.translateAlternateColorCodes('&', nickName + "&r"));
                                    player.setPlayerListName(ChatColor.translateAlternateColorCodes('&', nickName + "&r"));
                                    Message.player(player, "&aNickname set!");
                                } else {

                                    Message.player(player, "&cName is taken!");
                                }
                            }
                        } else {

                            if (nickNamePlayer != null) {

                                player.setDisplayName(nickName);
                                player.setPlayerListName(nickName);
                                Message.player(player, "&aNickname set!");
                            } else {

                                if (player.hasPermission("utilityTools.nick.override")) {

                                    player.setDisplayName(nickName);
                                    player.setPlayerListName(nickName);
                                    Message.player(player, "&aNickname set!");
                                } else {

                                    Message.player(player, "&cName is taken!");
                                }
                            }
                        }
                    } else {

                        Message.player(player, "&cInvalid arguments! \n" +
                                "Valid arguments: set, remove");
                    }
                } else if (args.length == 1) {

                    if (args[0].equalsIgnoreCase("remove"))
                        return true;

                    Message.player(player, "&cPlease enter a nickname!");

                } else {
                    Message.player(player, "&cNo arguments! \n" +
                            "Valid arguments: set, remove");
                }
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if (args.length == 1)
            return StringUtil.copyPartialMatches(args[0], Arrays.asList("set", "remove"), new ArrayList<>());

        return null;
    }
}
