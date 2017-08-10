package me.nerm.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nerm.utils.C;

public class TeamSpeakCommand implements CommandExecutor {

	@Override
	public boolean onCommand(final CommandSender sender, final Command command, final String label,
			final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(C.RED + "You must be a player in order to run registerCommands.");
			return true;
		}
		final Player player = (Player) sender; // Initialize Player
		final String cmd = command.getName(); // Initialize Commands
		if (cmd.equals("ts") || cmd.equals("ts3") || cmd.equals("teamspeak3")) {
			player.sendMessage(C.GREEN + "You may connected to our Official " + C.ITALIC + "TeamSpeak Server " + C.GREEN
					+ "at " + C.WHITE + C.UNDER + "store.exorthq.net" + C.GREEN + ".");
			return true;
		}
		return true;
	}
}