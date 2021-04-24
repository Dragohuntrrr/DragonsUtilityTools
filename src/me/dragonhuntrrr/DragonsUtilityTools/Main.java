package me.dragonhuntrrr.DragonsUtilityTools;

import me.dragonhuntrrr.DragonsUtilityTools.commands.Nickname;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getCommand("nickname").setExecutor(new Nickname());
    }

    @Override
    public void onDisable() {
        plugin = null;
    }


}
