package me.nerm.listeners.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener {

	@EventHandler(priority = EventPriority.LOWEST)
	public void onDamage(final EntityDamageEvent event) {
		event.setCancelled(true);
	}
}