package me.nerm.command;

import me.nerm.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nerm.utils.C;

public class HelpCommand implements CommandExecutor {

	@Override
	public boolean onCommand(final CommandSender sender, final Command command, final String label,
			final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(C.RED + "You must be a player in order to run registerCommands.");
			return true;
		}
		final Player player = (Player) sender; // Initialize Player
		final String cmd = command.getName(); // Initialize Commands
		if (cmd.equals("help") || cmd.equals("?")) {
			for (String help : Main.getInstance().getConfig().getStringList("HELP")){
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', help));
			}
			return true;
		}
		return true;
	}
}