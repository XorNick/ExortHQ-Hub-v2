package me.nerm.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nerm.utils.C;

public class ClearCommand implements CommandExecutor {

	@Override
	public boolean onCommand(final CommandSender sender, final Command command, final String label,
			final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(C.RED + "You must be a player in order to run registerCommands.");
			return true;
		}
		final Player player = (Player) sender; // Initialize Player
		final String cmd = command.getName(); // Initialize Commands
		if (cmd.equals("clear") && player.hasPermission("clear.inv")) {
			if (args.length == 0) {
				player.sendMessage(C.GREEN + "You have cleared your inventory.");
				player.getInventory().setHelmet(null);
				player.getInventory().setChestplate(null);
				player.getInventory().setLeggings(null);
				player.getInventory().setBoots(null);
				player.getInventory().clear();
				return true;
			}
			final Player target = Bukkit.getPlayerExact(args[0]); // Target
			if (target == null) {
				player.sendMessage(C.RED + "That player is not online.");
				return true;
			}
			if (target == player) {
				player.sendMessage(C.RED + "You may not clear your own inventory, Instead type /clear.");
				return true;
			}
			if (args[0].equals(target.getName())) {
				player.sendMessage(
						C.GREEN + "You have cleared " + C.DGREEN + target.getName() + "'s " + C.GREEN + "inventory.");
				target.sendMessage(
						C.GREEN + "Your inventory was cleared by " + C.DGREEN + player.getName() + C.GREEN + ".");
				target.getInventory().clear();
				target.getInventory().setHelmet(null);
				target.getInventory().setChestplate(null);
				target.getInventory().setLeggings(null);
				target.getInventory().setBoots(null);
				return true;
			}
			return true;
		}
		return true;
	}
}