package me.nerm.tab;

import org.bukkit.entity.Player;

import me.nerm.listeners.player.PlayerJoin;
import me.nerm.utils.C;

public class TabManager extends PlayerJoin {

	public static void giveColor(Player player) {
		if (player.hasPermission("hub.pro")) {
			player.setPlayerListName(C.YELLOW + player.getName());
		}
		if (player.hasPermission("hub.elite")) {
			player.setPlayerListName(C.BLUE + player.getName());
		}
		if (player.hasPermission("hub.supreme")) {
			player.setPlayerListName(C.GOLD + player.getName());
		}
		if (player.hasPermission("hub.exort")) {
			player.setPlayerListName(C.DGREEN + player.getName());
		}
		if (player.hasPermission("hub.media")) {
			player.setPlayerListName(C.PINK + player.getName());
		}
		if (player.hasPermission("hub.famous")) {
			player.setPlayerListName(C.PURPLE + player.getName());
		}
		if (player.hasPermission("hub.chat")) {
			player.setPlayerListName(C.DAQUA + player.getName());
		}
		if (player.hasPermission("hub.mod")) {
			player.setPlayerListName(C.DAQUA + C.ITALIC + player.getName());
		}
		if (player.hasPermission("hub.admin")) {
			player.setPlayerListName(C.RED + player.getName());
		}
		if (player.hasPermission("hub.plat")) {
			player.setPlayerListName(C.RED + C.ITALIC + player.getName());
		}
		if (player.hasPermission("hub.developer")) {
			player.setPlayerListName(C.GREEN + player.getName());
		}
		if (player.hasPermission("hub.owner")) {
			player.setPlayerListName(C.DRED + player.getName());
		}
		if (player.isOp()) {
			player.setPlayerListName(C.DRED + C.ITALIC + player.getName());
		}
	}
}