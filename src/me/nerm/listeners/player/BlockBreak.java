package me.nerm.listeners.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBreak(final BlockBreakEvent event) {
		final Player player = event.getPlayer();
		if (!player.isOp()) {
			event.setCancelled(true);
		}
	}
}