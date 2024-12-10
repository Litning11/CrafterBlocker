package org.unitedlands.crafterBlocker;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.CrafterCraftEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public final class CrafterBlocker extends JavaPlugin implements Listener {

    private static final String CRAFTER_DISABLED_MESSAGE = "§c§lU§f§lL §7§lCore §8§l» §cCrafters have been temporarily disabled.";

    @Override
    public void onEnable() {
        // Plugin startup logic.
        // Registering event listeners.
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("CrafterBlocker has been enabled.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic.
        getLogger().info("CrafterBlocker has been disabled.");
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        // Check if the block placed is a crafter.
        if (event.getBlockPlaced().getType() == Material.CRAFTER) {
            event.getPlayer().sendMessage(CRAFTER_DISABLED_MESSAGE);
        }
    }

    @EventHandler
    public void onCrafterCraft(CrafterCraftEvent event) {
        // Cancel the crafting event.
        event.setCancelled(true);
    }
}
