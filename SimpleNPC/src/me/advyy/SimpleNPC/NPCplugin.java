package me.advyy.npcplugin;

import me.advyy.npcplugin.listener.NpcListener;
import org.bukkit.plugin.java.JavaPlugin;

public class NpcPlugin extends JavaPlugin {
    private static NpcPlugin instance;

    public static NpcPlugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getCommand("npc").setExecutor(new NpcCommand());
        getServer().getPluginManager().registerEvents(new NpcListener(), this);
        NpcManager.loadNPCs(); // carica NPC all'avvio
        getLogger().info("✅ Plugin NPC avviato");
    }

    @Override
    public void onDisable() {
        NpcManager.saveNPCs(); // salva alla chiusura
    }
}
