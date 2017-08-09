package me.nerm.selector;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.nerm.utils.C;
import me.nerm.utils.ItemStackBuilder;

public class SelectorManager implements Listener {

	public static Inventory selector = Bukkit.createInventory(null, 27, C.GREEN + "Select a server..!");

	public void openInventory(final Player player) {
		final ItemStack HCF = new ItemStackBuilder(Material.FISHING_ROD).setName(C.GREEN + "Hardcore Factions")
				.addLore("", C.GRAY + " * " + C.YELLOW + "10 Man Faction",
						C.GRAY + " * " + C.YELLOW + "Advanced Anti Cheat")
				.build();
		final ItemStack KIT = new ItemStackBuilder(Material.DIAMOND_SWORD).setName(C.GREEN + "Kit Map")
				.addLore("", C.GRAY + " * " + C.YELLOW + "5 Man Factions", C.GRAY + " * " + C.YELLOW + "5 Minute Koth")
				.build();
		selector.setItem(11, HCF);
		selector.setItem(17, KIT);
		player.openInventory(selector);
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onInteract(final PlayerInteractEvent event) {
		final Player player = event.getPlayer();
		Action action = event.getAction();
		if (action == action.RIGHT_CLICK_AIR && player.getInventory().getItemInHand().getType() == Material.COMPASS) {
			openInventory(player);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onClick(final InventoryClickEvent event) {
		final Player player = (Player) event.getWhoClicked();
		if (!player.isOp()) {
			event.setCancelled(true);
		}
		if (event.getClickedInventory() == null || (event.getCurrentItem().getType() == Material.AIR)) {
			return;
		}
		if (event.getCurrentItem().getType().equals(Material.FISHING_ROD)) {
			player.sendMessage(C.GREEN + C.ITALIC + "Sending you to Hardcore Factions..");
			player.performCommand("play HCF");
			event.setCancelled(true);
		}
		if (event.getCurrentItem().getType().equals(Material.DIAMOND_SWORD)) {
			player.sendMessage(C.GREEN + C.ITALIC + "Sending you to Kit Map..");
			player.performCommand("play Kits");
			event.setCancelled(true);
		}
	}
}