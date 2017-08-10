package me.nerm.tab;

import lombok.experimental.UtilityClass;
import me.nerm.utils.C;
import org.bukkit.entity.Player;

@UtilityClass
public class TabManager {

    public void giveColor(Player player) {
        if (player.hasPermission("hub.pro")) {
            player.setPlayerListName(C.YELLOW + player.getName());
        } else if (player.hasPermission("hub.elite")) {
            player.setPlayerListName(C.BLUE + player.getName());
        } else if (player.hasPermission("hub.supreme")) {
            player.setPlayerListName(C.GOLD + player.getName());
        } else if (player.hasPermission("hub.exort")) {
            player.setPlayerListName(C.DGREEN + player.getName());
        } else if (player.hasPermission("hub.media")) {
            player.setPlayerListName(C.PINK + player.getName());
        } else if (player.hasPermission("hub.famous")) {
            player.setPlayerListName(C.PURPLE + player.getName());
        } else if (player.hasPermission("hub.chat")) {
            player.setPlayerListName(C.DAQUA + player.getName());
        } else if (player.hasPermission("hub.mod")) {
            player.setPlayerListName(C.DAQUA + C.ITALIC + player.getName());
        } else if (player.hasPermission("hub.admin")) {
            player.setPlayerListName(C.RED + player.getName());
        } else if (player.hasPermission("hub.plat")) {
            player.setPlayerListName(C.RED + C.ITALIC + player.getName());
        } else if (player.hasPermission("hub.developer")) {
            player.setPlayerListName(C.GREEN + player.getName());
        } else if (player.hasPermission("hub.owner")) {
            player.setPlayerListName(C.DRED + player.getName());
        } else if (player.isOp()) {
            player.setPlayerListName(C.DRED + C.ITALIC + player.getName());
        }
    }
}