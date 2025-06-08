package me.advyy.npcplugin.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.entity.Player;

public class NpcListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEntityEvent event) {
        if (!(event.getRightClicked() instanceof Player)) return;

        Player clicked = (Player) event.getRightClicked();
        if (clicked.hasMetadata("NPC")) {
            event.getPlayer().sendMessage("§bHai parlato con " + clicked.getName() + "!");
        }
    }
}
