package me.nerm;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.nerm.command.ClearChatCommand;
import me.nerm.command.ClearCommand;
import me.nerm.command.HelpCommand;
import me.nerm.command.ListCommand;
import me.nerm.command.SetSpawnCommand;
import me.nerm.command.StoreCommand;
import me.nerm.listeners.Manager;
import me.nerm.scoreboard.ScoreboardManager;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;

public class Main extends JavaPlugin {

	public static Main instance;
	public static Permission perms = null;
	public static Chat chat;

	public void onEnable() {
		instance = this;
		Manager.register();
		new BukkitRunnable() {
			@SuppressWarnings("deprecation")
			public void run() {
				if (Bukkit.getOnlinePlayers().length != 0) {
					ScoreboardManager.updateScoreboard();
				}
			}
		}.runTaskTimer(this, 20L, 20L);
		commands();
		this.setupPermissions();
		this.setupChat();
		this.optimize();
	}

	// Get the instance by returning to the instance.
	public static Main getInstance() {
		return instance;
	}

	// Register the commands to the Enable Method.
	public void commands() {
		getCommand("help").setExecutor(new HelpCommand());
		getCommand("?").setExecutor(new HelpCommand());
		getCommand("list").setExecutor(new ListCommand());
		getCommand("online").setExecutor(new ListCommand());
		getCommand("players").setExecutor(new ListCommand());
		getCommand("buy").setExecutor(new StoreCommand());
		getCommand("store").setExecutor(new StoreCommand());
		getCommand("donate").setExecutor(new StoreCommand());
		getCommand("purchase").setExecutor(new StoreCommand());
		getCommand("setspawn").setExecutor(new SetSpawnCommand());
		getCommand("clear").setExecutor(new ClearCommand());
		getCommand("ci").setExecutor(new ClearCommand());
		getCommand("clearchat").setExecutor(new ClearChatCommand());
		getCommand("cc").setExecutor(new ClearChatCommand());
	}

	// Setup the Permissions Provider / Service using the TODO Vault API.
	public static boolean setupPermissions() {
		RegisteredServiceProvider<Permission> rsp = Bukkit.getServer().getServicesManager()
				.getRegistration(Permission.class);
		perms = rsp.getProvider();
		return perms != null;
	}

	// Setup the Chat Provider / Service using the TODO Vault API.
	public boolean setupChat() {
		RegisteredServiceProvider<Chat> rsp = Bukkit.getServer().getServicesManager().getRegistration(Chat.class);
		chat = rsp.getProvider();
		return chat != null;
	}

	// Receive the Permissions Service by returning the "setupPermissions()".
	public static Permission getPerms() {
		return perms;
	}

	// Receive the Chat Service by returning the "setupChat()".
	public static Chat getChat() {
		return chat;
	}

	// Send the Optimization Method on the boot.
	public void optimize() {
		final Server server = Bukkit.getServer();
		final World world = server.getWorld(""); // Change this to your world.
		server.setDefaultGameMode(GameMode.ADVENTURE);
		world.setAmbientSpawnLimit(0);
		world.setAnimalSpawnLimit(0);
		world.setDifficulty(Difficulty.PEACEFUL);
		world.setWeatherDuration(0);
		world.setKeepSpawnInMemory(true); // Set this to 'false' if you don't
		world.setMonsterSpawnLimit(0); // have a lot of memory.
		world.setPVP(false);
		world.setStorm(false);
		world.setTime(0);

	}
}