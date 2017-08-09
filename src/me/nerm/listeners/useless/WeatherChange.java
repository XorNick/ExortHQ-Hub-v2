package me.nerm.listeners.useless;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherChange implements Listener {

	@EventHandler(priority = EventPriority.LOWEST)
	public void onChange(final WeatherChangeEvent event) {
		event.setCancelled(true);
	}
}