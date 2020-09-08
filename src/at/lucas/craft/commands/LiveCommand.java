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

import java.util.ArrayList;

public class LiveCommand implements CommandExecutor, Listener {
    ArrayList<Player> live = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
            Team rp = scoreboard.getTeam("live");
            if (rp == null) scoreboard.registerNewTeam("live");

            rp.setPrefix("§dStream §8| ");
            if (rp.getEntries().contains(p.getName())) {
                p.setDisplayName(p.getName());
                p.sendMessage(Main.PREFIX + "§dDu hast den Stream Modus verlassen!");
                rp.removeEntry(p.getName());
                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.setScoreboard(scoreboard);
                }
            } else {
                p.setDisplayName("§dStream §8| §f" + p.getName());
                p.sendMessage(Main.PREFIX + "§dDu bist nun im Stream Modus!");
                rp.addEntry(p.getName());
            }

            for (Player players : Bukkit.getOnlinePlayers()) {
                players.setScoreboard(scoreboard);
            }
        }
        return true;

    }

}
