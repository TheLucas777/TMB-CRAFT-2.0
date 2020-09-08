package at.lucas.craft.commands;

import at.lucas.craft.utils.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class rolleCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("roleplay")) {
                    p.performCommand("roleplay");
                } else if (args[0].equalsIgnoreCase("aufnahme")) {
                    p.performCommand("aufnahme");
                } else if (args[0].equalsIgnoreCase("stream")) {
                    p.performCommand("stream");
                } else p.sendMessage(Main.PREFIX + "§cBitte verwende §7/rolle §aRoleplay §8| §cAufnahme §8| §dStream!");

            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String lable, String[] args) {
        List<String> tab = new ArrayList<>();
        if (args.length == 1) {
            tab.add("roleplay");
            tab.add("aufnahme");
            tab.add("stream");
        }
        return tab;
    }
}
