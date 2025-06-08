package me.advyy.npcplugin.util;

import com.google.gson.*;
import java.io.*;
import java.net.*;

public class SkinFetcher {
    public static String[] getSkin(String username) {
        try {
            URL url = new URL("https://api.mojang.com/users/profiles/minecraft/" + username);
            JsonObject uuidObj = JsonParser.parseReader(new InputStreamReader(url.openStream())).getAsJsonObject();
            String uuid = uuidObj.get("id").getAsString();

            URL session = new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + uuid + "?unsigned=false");
            JsonObject profile = JsonParser.parseReader(new InputStreamReader(session.openStream())).getAsJsonObject();

            JsonObject prop = profile.getAsJsonArray("properties").get(0).getAsJsonObject();
            return new String[]{prop.get("value").getAsString(), prop.get("signature").getAsString()};
        } catch (Exception e) {
            return null;
        }
    }
}
