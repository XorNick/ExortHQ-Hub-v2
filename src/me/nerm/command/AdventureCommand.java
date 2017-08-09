package me.nerm.command;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nerm.utils.C;

public class AdventureCommand implements CommandExecutor {

	@Override
	public boolean onCommand(final CommandSender sender, final Command command, final String label,
			final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(C.RED + "You must be a player in order to run commands.");
			return true;
		}
		final Player player = (Player) sender; // Initialize Player
		final String cmd = command.getName(); // Initialize Commands
		if (cmd.equals("adventure") || cmd.equals("gma") && player.hasPermission("adventure.mode")) {
			if (player.getGameMode() == GameMode.ADVENTURE) {
				player.sendMessage(C.RED + "You are already in that specified game-mode.");
				return true;
			}
			player.setGameMode(GameMode.ADVENTURE);
			player.sendMessage(
					C.GREEN + "You have changed your game-mode to " + C.DGREEN + "Adventure Mode" + C.GREEN + ".");
			return true;
		}
		return true;
	}
}