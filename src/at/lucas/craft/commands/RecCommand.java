package at.lucas.craft.commands;

import at.lucas.craft.utils.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class RecCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
            Team rp = scoreboard.getTeam("rec");
            if (rp == null) scoreboard.registerNewTeam("rec");

            rp.setPrefix("§cAufnahme §8| ");
            if (rp.getEntries().contains(p.getName())) {
                p.setDisplayName(p.getName());
                p.sendMessage(Main.PREFIX + "§cDu hast den Aufnahme Modus verlassen!");
                rp.removeEntry(p.getName());
                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.setScoreboard(scoreboard);
                }
            } else {
                p.setDisplayName("§cAufnahme §8| §f" + p.getName());
                p.sendMessage(Main.PREFIX + "§cDu bist nun im Aufnahme Modus!");
                rp.addEntry(p.getName());
            }

            for (Player players : Bukkit.getOnlinePlayers()) {
                players.setScoreboard(scoreboard);
            }
        }
        return true;

    }
}
