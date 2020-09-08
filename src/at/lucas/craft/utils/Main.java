package at.lucas.craft.utils;

import at.lucas.craft.commands.CountdownCommand;
import at.lucas.craft.listener.JoinListener;
import at.lucas.craft.listener.QuitListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {
    private static Main plugin;

    public static String PREFIX = "[§6TMB-Craft§f] ";
    public static String NoConsl = PREFIX + "Kein Konsolenbefehl";
    public static String NoPerm = PREFIX + "§cDazu hast du keine berechtigung";

    @Override
    public void onEnable() {
        plugin = this;
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new CountdownCommand(),this);
        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new JoinListener(), this);
        Objects.requireNonNull(getCommand("start")).setExecutor(new CountdownCommand());
        System.out.println("[TMB-CRAFT]GESTARTET");
    }

    @Override
    public void onDisable() {
        System.out.println("[TMB-CRAFT]GESTOPPT");
    }
    public static Main getPlugin(){
        return plugin;
    }
}
