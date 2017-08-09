package me.nerm.listeners.useless;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropItem implements Listener {

	@EventHandler(priority = EventPriority.LOWEST)
	public void onDrop(final PlayerDropItemEvent event) {
		event.setCancelled(true);
	}
}