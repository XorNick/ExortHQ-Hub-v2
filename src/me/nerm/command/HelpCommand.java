package me.nerm.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nerm.utils.Bar;
import me.nerm.utils.C;

public class HelpCommand implements CommandExecutor {

	@Override
	public boolean onCommand(final CommandSender sender, final Command command, final String label,
			final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(C.RED + "You must be a player in order to run commands.");
			return true;
		}
		final Player player = (Player) sender; // Initialize Player
		final String cmd = command.getName(); // Initialize Commands
		if (cmd.equals("help") || cmd.equals("?")) {
			player.sendMessage(Bar.CHAT);
			player.sendMessage(C.DGREEN + C.UNDER + "ExortHQ Network Information");
			player.sendMessage("");
			player.sendMessage(C.GOLD + "Useful Commands");
			player.sendMessage(
					C.GREEN + "/report" + C.GRAY + " » " + C.DGREEN + "Report rule-breakers on the Network.");
			player.sendMessage(C.GREEN + "/request" + C.GRAY + " » " + C.DGREEN
					+ "Request assistance to all Online Staff Members.");
			player.sendMessage("");
			player.sendMessage(C.GOLD + "Useful Links");
			player.sendMessage(C.GREEN + "Store" + C.GRAY + " » " + C.DGREEN + "store.exorthq.net");
			player.sendMessage(C.GREEN + "Voice" + C.GRAY + " » " + C.DGREEN + "ts.exorthq.net");
			player.sendMessage(C.GREEN + "Reddit" + C.GRAY + " » " + C.DGREEN + "reddit.com/r/ExortHQ/");
			player.sendMessage(C.GREEN + "Twitter" + C.GRAY + " » " + C.DGREEN + "twiter.com/ExortHQ");
			player.sendMessage(Bar.CHAT);
			return true;
		}
		return true;
	}
}