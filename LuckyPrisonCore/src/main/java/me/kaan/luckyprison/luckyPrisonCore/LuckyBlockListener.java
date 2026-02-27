package me.kaan.luckyprison.luckyPrisonCore;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import java.util.Random;

public class LuckyBlockListener implements Listener {

    private final Random random = new Random();

    @EventHandler
    public void onLuckyBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();

        // We gebruiken een GOLD_BLOCK als ons eerste type Lucky Block
        if (block.getType() == Material.GOLD_BLOCK) {

            // We zorgen dat het blok niet gewoon een gold block dropt
            event.setDropItems(false);

            // Genereer een willekeurig getal tussen 0 en 2
            int chance = random.nextInt(3);

            if (chance == 0) {
                player.sendMessage("§e[Lucky] §fJe vond 5 Diamanten!");
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.DIAMOND, 5));
            } else if (chance == 1) {
                player.sendMessage("§e[Lucky] §fOeps... een zombie!");
                block.getWorld().spawn(block.getLocation(), org.bukkit.entity.Zombie.class);
            } else {
                player.sendMessage("§e[Lucky] §6Je hebt geluk! Je kreeg een goudstaaf.");
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GOLD_INGOT, 1));
            }
        }
    }
}