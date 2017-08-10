package me.nerm;

import lombok.Getter;
import me.nerm.command.*;
import me.nerm.listeners.Manager;
import me.nerm.scoreboard.ScoreboardManager;
import me.nerm.selector.ServerManager;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.*;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin {

    // TODO: 8/9/2017 Overall this plugin is abusing static quite greatly and could be made better.

    @Getter
    public static Main instance;
    @Getter
    public static Permission perms = null;
    @Getter
    public static Chat chat;
    @Getter
    private ServerManager serverManager;

    public void onEnable() {
        instance = this;
        Manager.register();
        new BukkitRunnable() {
            public void run() {
                if (Bukkit.getOnlinePlayers().size() != 0) {
                    ScoreboardManager.updateScoreboard();
                }
            }
        }.runTaskTimer(this, 20L, 20L);
        registerCommands();
        setupPermissions();
        setupChat();
        setupWorld();
        serverManager = new ServerManager(this);
        serverManager.loadServersFromFile();
    }

    // Register the registerCommands to the Enable Method.
    public void registerCommands() {
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

    // Setup the Permissions Provider / Service using the Vault API.
    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = Bukkit.getServer().getServicesManager()
                .getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    // Setup the Chat Provider / Service using the Vault API.
    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = Bukkit.getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    private void setupWorld() {
        final Server server = Bukkit.getServer();
        final World world = server.getWorld(getConfig().getString("WORLD")); // Change this to your world.
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

    @Override
    public void onDisable() {
        chat = null;
        perms = null;
        instance = null;
    }
}