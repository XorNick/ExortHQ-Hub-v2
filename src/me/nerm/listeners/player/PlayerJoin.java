package me.nerm.listeners.player;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.nerm.scoreboard.ScoreboardManager;
import me.nerm.tab.TabManager;
import me.nerm.utils.Bar;
import me.nerm.utils.C;
import me.nerm.utils.ItemStackBuilder;

public class PlayerJoin implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onJoin(final PlayerJoinEvent event) {
		Player player = event.getPlayer();
		event.setJoinMessage(null);
		player.sendMessage(C.GOLD + "Successfully loaded your profile.");
		player.loadData();
		sendChat(player);
		give(player);
		TabManager.giveColor(player);
		ScoreboardManager.giveScoreboard(player);
		ScoreboardManager.updateScoreboard();
	}

	// Give the players the items on join.
	public void give(final Player player) {
		player.getInventory().setItem(4, new ItemStackBuilder(Material.COMPASS).setName(C.GREEN + "Server Selector")
				.addLore(C.YELLOW + "Click on an item to connect to a Server").build());
		player.getInventory().setItem(8,
				new ItemStackBuilder(Material.INK_SACK).durability(8).setName(C.GRAY + "Disable Players Visbility")
						.addLore(C.YELLOW + "Right-Click to Hide Players").build());
		player.setFoodLevel(20);
	}

	// Display the chat related information on join.
	public void sendChat(final Player player) {
		final Location location = player.getLocation();
		player.playSound(location, Sound.LEVEL_UP, 1, 1);
		player.sendMessage(Bar.CHAT);
		player.sendMessage(C.GREEN + "Welcome to the " + C.DGREEN + C.BOLD + "ExortHQ Network" + C.GREEN + ".");
		player.sendMessage("");
		player.sendMessage(C.GREEN + "Store" + C.GRAY + " » " + C.DGREEN + "store.exorthq.net");
		player.sendMessage(C.GREEN + "Voice" + C.GRAY + " » " + C.DGREEN + "ts.exorthq.net");
		player.sendMessage(C.GREEN + "Reddit" + C.GRAY + " » " + C.DGREEN + "reddit.com/r/ExortHQ/");
		player.sendMessage(C.GREEN + "Twitter" + C.GRAY + " » " + C.DGREEN + "twiter.com/ExortHQ");
		player.sendMessage(Bar.CHAT);
	}
}