package me.kaan.luckyprison.luckyPrisonCore;

import org.bukkit.plugin.java.JavaPlugin;

public final class LuckyPrisonCore extends JavaPlugin {

    @Override
    public void onEnable() {
        // HIER verbinden we de LuckyBlockListener met de server
        getServer().getPluginManager().registerEvents(new LuckyBlockListener(), this);

        getLogger().info("==================================");
        getLogger().info("LuckyPrisonCore is nu ONLINE!");
        getLogger().info("Lucky Blocks: GEACTIVEERD");
        getLogger().info("Versie: 1.0 | Maker: Savaer");
        getLogger().info("==================================");
    }

    @Override
    public void onDisable() {
        getLogger().info("LuckyPrisonCore wordt afgesloten...");
    }
}