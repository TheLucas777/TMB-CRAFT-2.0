package at.lucas.craft.listener;

import at.lucas.craft.commands.CountdownCommand;
import at.lucas.craft.utils.FileConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage("§eDer Spieler §e" + p.getDisplayName() + " §eist dem Server beigetreten!");
        p.setPlayerListHeader("\n§eTMB-CRAFT §d2.0 \n     §7sponsored by §7TMB     \n");
        p.setPlayerListFooter(" \n§c✗ Clan-TMB.de ✗ \n");
    }
}
