package at.lucas.craft.commands;

import at.lucas.craft.utils.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.bukkit.event.Listener;

import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;


public class RPCommand implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
            Team rp = scoreboard.getTeam("rp");
            if (rp == null) scoreboard.registerNewTeam("rp");

            rp.setPrefix("§aRoleplay §8| ");
            if (rp.getEntries().contains(p.getName())) {
                p.setDisplayName(p.getName());
                p.sendMessage(Main.PREFIX + "§aDu hast den Roleplay Modus verlassen!");
                rp.removeEntry(p.getName());
                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.setScoreboard(scoreboard);
                }
            } else {
                p.setDisplayName("§aRoleplay §8| §f" + p.getName());
                p.sendMessage(Main.PREFIX + "§aDu bist nun im Roleplay Modus!");
                rp.addEntry(p.getName());
            }

            for (Player players : Bukkit.getOnlinePlayers()) {
                players.setScoreboard(scoreboard);
            }
        }
        return true;

    }
}
