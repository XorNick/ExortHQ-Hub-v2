package me.nerm.listeners.player;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onMove(final PlayerMoveEvent event) {
		final Player player = event.getPlayer();
		Location location = player.getLocation();
		Location from = event.getFrom();
		if (location.getBlockX() >= 100 || location.getBlockX() <= -100 || location.getBlockZ() >= 100
				|| location.getBlockZ() <= 100) {
			player.teleport(new Location(player.getWorld(), 0, 100, 0, 0, 0));
			player.playSound(location, Sound.LEVEL_UP, 1, 1);
		}
	}
}