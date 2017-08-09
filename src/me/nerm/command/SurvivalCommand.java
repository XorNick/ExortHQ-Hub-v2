package me.nerm.command;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nerm.utils.C;

public class SurvivalCommand implements CommandExecutor {

	@Override
	public boolean onCommand(final CommandSender sender, final Command command, final String label,
			final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(C.RED + "You must be a player in order to run commands.");
			return true;
		}
		final Player player = (Player) sender; // Initialize Player
		final String cmd = command.getName(); // Initialize Commands
		if (cmd.equals("survival") || cmd.equals("gms") && player.hasPermission("survival.mode")) {
			if (player.getGameMode() == GameMode.SURVIVAL) {
				player.sendMessage(C.RED + "You are already in that specified game-mode.");
				return true;
			}
			player.setGameMode(GameMode.SURVIVAL);
			player.sendMessage(
					C.GREEN + "You have changed your game-mode to " + C.DGREEN + "Survival Mode" + C.GREEN + ".");
			return true;
		}
		return true;
	}
}