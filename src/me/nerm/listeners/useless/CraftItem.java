package me.nerm.listeners.useless;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class CraftItem implements Listener {
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void onCraft(final CraftItemEvent event) {
		event.setCancelled(true);
	}
}