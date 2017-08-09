package me.nerm.listeners.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntitySpawn implements Listener {

	@EventHandler(priority = EventPriority.LOWEST)
	public void onSpawn(final EntitySpawnEvent event) {
		event.setCancelled(true);
	}
}