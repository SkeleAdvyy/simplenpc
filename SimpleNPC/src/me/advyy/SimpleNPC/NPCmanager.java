package me.advyy.npcplugin;

import com.google.gson.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.io.*;
import java.util.*;

public class NpcManager {
    private static final Map<String, NpcData> npcMap = new HashMap<>();
    private static final File file = new File(NpcPlugin.getInstance().getDataFolder(), "npcs.json");

    public static void addNpc(NpcData data) {
        npcMap.put(data.getName(), data);
        spawnNpc(data);
    }

    public static void removeNpc(String name) {
        npcMap.remove(name);
    }

    public static void spawnNpc(NpcData data) {
        // codice NMS per spawnare NPC (vedi sotto)
    }

    public static void loadNPCs() {
        if (!file.exists()) return;
        try (Reader reader = new FileReader(file)) {
            JsonArray array = JsonParser.parseReader(reader).getAsJsonArray();
            for (JsonElement el : array) {
                NpcData data = new Gson().fromJson(el, NpcData.class);
                npcMap.put(data.getName(), data);
                spawnNpc(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveNPCs() {
        JsonArray array = new JsonArray();
        for (NpcData data : npcMap.values()) {
            array.add(new Gson().toJsonTree(data));
        }
        try (Writer writer = new FileWriter(file)) {
            new GsonBuilder().setPrettyPrinting().create().toJson(array, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Collection<NpcData> getAllNpcs() {
        return npcMap.values();
    }
}
