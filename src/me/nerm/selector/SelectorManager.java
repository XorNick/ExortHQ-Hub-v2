package me.nerm.selector;

import me.nerm.Main;
import me.nerm.utils.C;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SelectorManager implements Listener {

    public void openInventory(final Player player) {
        Inventory selector = Bukkit.createInventory(null, (int) Math.ceil(Main.getInstance().getServerManager().getServers().size() / 9.0), ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("SELECTORNAME")));
        Main.getInstance().getServerManager().getServers().stream().map(server -> Main.getInstance().getServerManager().getServerIcon(server.getName())).forEach(selector::addItem);
        player.openInventory(selector);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInteract(final PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        Action action = event.getAction();
        if (action == Action.RIGHT_CLICK_AIR && player.getInventory().getItemInHand().getType() == Material.COMPASS) {
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

        ItemStack itemStack = event.getCurrentItem();

        if (Main.getInstance().getServerManager().getServerByIcon(itemStack).isUsingEZQueue()) {
            player.sendMessage(ChatColor.GRAY + "Connecting...");
            player.closeInventory();
            player.performCommand("play " + ChatColor.stripColor(itemStack.getItemMeta().getDisplayName()));
            event.setCancelled(true);
            event.setResult(Event.Result.DENY);
        } else {
            event.setCancelled(true);
            player.closeInventory();
            // TODO: 8/9/2017 Maybe add a direct connection to BungeeCord?!
        }
    }
}