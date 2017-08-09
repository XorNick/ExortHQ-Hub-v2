package me.nerm.listeners.useless;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChange implements Listener {

	@EventHandler(priority = EventPriority.LOWEST)
	public void onChange(final FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}
}