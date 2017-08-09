package me.nerm.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nerm.utils.C;

public class StoreCommand implements CommandExecutor {

	@Override
	public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(C.RED + "You must be a player in order to run commands.");
			return true;
		}
		final Player player = (Player) sender; // Initialize Player
		final String cmd = command.getName(); // Initialize Commands
		if (cmd.equals("buy") || cmd.equals("store") || cmd.equals("donate") || cmd.equals("purchase")) {
			player.sendMessage(C.GREEN + "You can purchase our" + C.ITALIC + " digital-goods" + C.GREEN
					+ " on our store " + C.WHITE + C.UNDER + "store.exorthq.net" + C.GREEN + ".");
			return true;
		}
		return true;
	}
}