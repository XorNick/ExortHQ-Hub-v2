package me.nerm.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nerm.utils.Bar;
import me.nerm.utils.C;

public class ListCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(final CommandSender sender, final Command command, final String label,
			final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(C.RED + "You must be a player in order to run registerCommands.");
			return true;
		}
		final Player player = (Player) sender; // Initialize Player
		final String cmd = command.getName(); // Initialize Commands
		if (cmd.equals("list") || cmd.equals("online") || cmd.equals("players")) {
			player.sendMessage(Bar.CHAT);
			player.sendMessage(C.GREEN + "There are currently " + C.DGREEN + Bukkit.getOnlinePlayers().size()
					+ " players " + C.GREEN + "conntected to your " + C.ITALIC + "Hub" + C.GREEN + ".");
			player.sendMessage(Bar.CHAT);
			return true;
		}
		return true;
	}
}