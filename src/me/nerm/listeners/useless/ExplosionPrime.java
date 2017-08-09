package me.nerm.listeners.useless;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class ExplosionPrime implements Listener {

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPrime(final ExplosionPrimeEvent event) {
		event.setCancelled(true);
	}
}