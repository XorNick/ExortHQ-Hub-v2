package me.nerm.command;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nerm.utils.C;

public class SetSpawnCommand implements CommandExecutor {

	@Override
	public boolean onCommand(final CommandSender sender, final Command command, final String label,
			final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(C.RED + "You must be a player in order to run commands.");
			return true;
		}
		final Player player = (Player) sender; // Initialize Player
		final String cmd = command.getName(); // Initialize Commands
		final Server server = Bukkit.getServer(); // Initialize Server
		final Location location = player.getLocation();
		if (cmd.equals("setspawn") && player.hasPermission("set.spawn")) {
			// If they have the permission proceed to setting the World Spawn.
			server.getWorld(player.getWorld().getName()).setSpawnLocation(location.getBlockX(), location.getBlockY(),
					location.getBlockZ());
			player.sendMessage(C.YELLOW + "You have set your Server Hub's to spawn to " + C.GOLD + location.getBlockX()
					+ ", " + location.getBlockY() + ", " + location.getBlockZ() + C.YELLOW + ".");
			Bukkit.getWorld(player.getWorld().getName()).save();
			return true;
		}
		return true;
	}
}