package me.nerm.listeners.useless;

import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;

public class InventoryOpen implements Listener {

	@EventHandler(priority = EventPriority.LOWEST)
	public void onOpen(final InventoryOpenEvent event) {
		InventoryType type = event.getInventory().getType();
		if (type == type.ANVIL) {
			event.setCancelled(true);
		}
		if (type == type.BEACON) {
			event.setCancelled(true);
		}
		if (type == type.BREWING) {
			event.setCancelled(true);
		}
		if (type == type.CHEST) {
			event.setCancelled(true);
		}
		if (type == type.CRAFTING) {
			event.setCancelled(true);
		}
		if (type == type.DISPENSER) {
			event.setCancelled(true);
		}
		if (type == type.DROPPER) {
			event.setCancelled(true);
		}
		if (type == type.ENCHANTING) {
			event.setCancelled(true);
		}
		if (type == type.ENDER_CHEST) {
			event.setCancelled(true);
		}
		if (type == type.FURNACE) {
			event.setCancelled(true);
		}
		if (type == type.HOPPER) {
			event.setCancelled(true);
		}
		if (type == type.MERCHANT) {
			event.setCancelled(true);
		}
		if (type == type.WORKBENCH) {
			event.setCancelled(true);
		}
	}
}