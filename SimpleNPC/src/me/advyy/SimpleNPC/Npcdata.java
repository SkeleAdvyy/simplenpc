package me.advyy.npcplugin;

public class NpcData {
    private String name;
    private String skin;
    private double x, y, z;
    private float yaw, pitch;
    private String world;

    public NpcData(String name, String skin, double x, double y, double z, float yaw, float pitch, String world) {
        this.name = name;
        this.skin = skin;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
        this.world = world;
    }

    public String getName() { return name; }
    public String getSkin() { return skin; }
    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }
    public float getYaw() { return yaw; }
    public float getPitch() { return pitch; }
    public String getWorld() { return world; }
}
