package me.nerm.listeners.useless;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.PortalCreateEvent;

public class PortalCreate implements Listener {

	@EventHandler(priority = EventPriority.LOWEST)
	public void onCreate(final PortalCreateEvent event) {
		event.setCancelled(true);
	}
}