package me.nerm.listeners.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.nerm.utils.C;

public class PlayerQuit implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onQuit(final PlayerQuitEvent event) {
		final Player player = event.getPlayer();
		event.setQuitMessage(null);
		player.sendMessage(C.GOLD + "Saving your profile..");
		player.saveData();
		clear(player);
	}

	// Clear their inventory when they leave the server.
	private void clear(final Player player) {
		player.getInventory().setHelmet(null);
		player.getInventory().setChestplate(null);
		player.getInventory().setLeggings(null);
		player.getInventory().setBoots(null);
		player.getInventory().clear();
	}
}