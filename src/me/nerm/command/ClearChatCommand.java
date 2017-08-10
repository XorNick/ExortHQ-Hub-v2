package me.nerm.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nerm.utils.C;

public class ClearChatCommand implements CommandExecutor {

	@Override
	public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(C.RED + "You must be a player in order to run registerCommands.");
			return true;
		}
		final Player player = (Player) sender; // Initialize Player
		final String cmd = command.getName(); // Initialize Commands
		if (cmd.equals("clearchat") || cmd.equals("cc") && player.hasPermission("clear.chat")) {
			for (int i = 0; i < 100; i++) {
				Bukkit.broadcastMessage("");
			}
			// Display who cleared then chat upon clearing it.
			Bukkit.broadcastMessage(
					C.GRAY + "Global Chat has been cleared by " + C.GREEN + player.getName() + C.GRAY + ".");
			return true;
		}
		return true;
	}
}