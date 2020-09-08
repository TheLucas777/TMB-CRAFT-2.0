package at.lucas.craft.commands;

import at.lucas.craft.utils.FileConfig;
import at.lucas.craft.utils.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.plugin.Plugin;

public class CountdownCommand implements CommandExecutor, Listener {
    private int task;
    private int time = 10;
    private boolean move;
    private boolean day;
    public FileConfig countdown = new FileConfig("Countdown.yml");
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            Plugin plugin = Main.getPlugin();
            if (p.hasPermission("tmb.start")) {

                BossBar bar = Bukkit.createBossBar("Countdown", BarColor.WHITE, BarStyle.SEGMENTED_10);
                this.task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {



                    @Override
                    public void run() {
                        time--;
                        bar.setProgress(time/10d);
                        countdown.set("move", true);
                        for(Player player : plugin.getServer().getOnlinePlayers()){
                            bar.addPlayer(player);
                            bar.setVisible(true);
                            player.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 0.2f,1.2f);
                        }
                        bar.setTitle("§d"+time+" §7Sekunden bis zum Start");
                        if (time == 0) {
                            countdown.set("move", false);
                            Bukkit.getScheduler().cancelTask(task);
                            Bukkit.broadcastMessage(Main.PREFIX + "§cCountdown beendet");
                            time = 10;
                            bar.removeAll();
                        }
                    }
                }, 0, 20);

                countdown.set("move", move);
                countdown.saveConfig();
            } else p.sendMessage(Main.NoPerm);
        } else sender.sendMessage(Main.NoConsl);
        return false;
    }
    @EventHandler
    public void onMove(PlayerBedEnterEvent e){

    }
}
