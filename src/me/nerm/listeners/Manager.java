package me.nerm.listeners;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import me.nerm.Main;
import me.nerm.listeners.entity.EntityDamage;
import me.nerm.listeners.entity.EntitySpawn;
import me.nerm.listeners.player.BlockBreak;
import me.nerm.listeners.player.BlockPlace;
import me.nerm.listeners.player.PlayerJoin;
import me.nerm.listeners.player.PlayerMove;
import me.nerm.listeners.player.PlayerQuit;
import me.nerm.listeners.useless.CraftItem;
import me.nerm.listeners.useless.ExplosionPrime;
import me.nerm.listeners.useless.FoodLevelChange;
import me.nerm.listeners.useless.InventoryOpen;
import me.nerm.listeners.useless.PlayerDropItem;
import me.nerm.listeners.useless.PortalCreate;
import me.nerm.listeners.useless.WeatherChange;
import me.nerm.selector.SelectorManager;

public class Manager extends Main {

	// Register the events for the Boot Method.
	public static void register() {
		final PluginManager manager = Bukkit.getPluginManager();
		manager.registerEvents(new PlayerJoin(), Main.getInstance());
		manager.registerEvents(new PlayerQuit(), Main.getInstance());
		manager.registerEvents(new PlayerMove(), Main.getInstance());
		manager.registerEvents(new BlockBreak(), Main.getInstance());
		manager.registerEvents(new BlockPlace(), Main.getInstance());
		manager.registerEvents(new EntityDamage(), Main.getInstance());
		manager.registerEvents(new EntitySpawn(), Main.getInstance());
		manager.registerEvents(new CraftItem(), Main.getInstance());
		manager.registerEvents(new ExplosionPrime(), Main.getInstance());
		manager.registerEvents(new FoodLevelChange(), Main.getInstance());
		manager.registerEvents(new InventoryOpen(), Main.getInstance());
		manager.registerEvents(new PlayerDropItem(), Main.getInstance());
		manager.registerEvents(new PortalCreate(), Main.getInstance());
		manager.registerEvents(new WeatherChange(), Main.getInstance());
		manager.registerEvents(new SelectorManager(), Main.getInstance());
	}
}