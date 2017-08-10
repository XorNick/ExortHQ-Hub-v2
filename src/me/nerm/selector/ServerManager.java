package me.nerm.selector;

import lombok.Getter;
import me.nerm.Main;
import me.nerm.utils.Config;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Missionary (missionarymc@gmail.com) on 8/9/2017.
 */
public class ServerManager {

    @Getter
    public Set<Server> servers = new HashSet<>();

    private final Main plugin;

    private Config config;

    public ServerManager(Main plugin) {
        this.plugin = plugin;
        config = new Config(plugin, "servers.yml", null);
    }

    public void loadServersFromFile() {
        FileConfiguration configuration = config.getConfiguration();
        for (String serv : configuration.getKeys(false)) {
            Server server = new Server(ChatColor.translateAlternateColorCodes('&', configuration.getString(serv + ".NAME")),
                    Material.getMaterial(configuration.getString(serv + ".MATERIAL")),
                    configuration.getInt(serv + ".DATA"),
                    configuration.getStringList(serv + ".LORE"),
                    configuration.getInt(serv + ".POSITION"),
                    configuration.getBoolean(serv + ".EZQUEUE"));
            servers.add(server);
        }
    }

    public Server getServerByName(String name) {
        return servers.stream().filter(server -> server.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public ItemStack getServerIcon(String name) {
        Server server = getServerByName(name);
        return server != null ? server.getItemStackFromMaterial() : null;
    }

    public Server getServerByIcon(ItemStack stack){
        return servers.stream().filter(server -> server.getItemStackFromMaterial().equals(stack)).findFirst().orElse(null);
    }
}
