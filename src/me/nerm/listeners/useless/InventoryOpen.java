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
		if (type == InventoryType.ANVIL) {
			event.setCancelled(true);
		}
		if (type == InventoryType.BEACON) {
			event.setCancelled(true);
		}
		if (type == InventoryType.BREWING) {
			event.setCancelled(true);
		}
		if (type == InventoryType.CHEST) {
			event.setCancelled(true);
		}
		if (type == InventoryType.CRAFTING) {
			event.setCancelled(true);
		}
		if (type == InventoryType.DISPENSER) {
			event.setCancelled(true);
		}
		if (type == InventoryType.DROPPER) {
			event.setCancelled(true);
		}
		if (type == InventoryType.ENCHANTING) {
			event.setCancelled(true);
		}
		if (type == InventoryType.ENDER_CHEST) {
			event.setCancelled(true);
		}
		if (type == InventoryType.FURNACE) {
			event.setCancelled(true);
		}
		if (type == InventoryType.HOPPER) {
			event.setCancelled(true);
		}
		if (type == InventoryType.MERCHANT) {
			event.setCancelled(true);
		}
		if (type == InventoryType.WORKBENCH) {
			event.setCancelled(true);
		}
	}
}