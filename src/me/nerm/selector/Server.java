package me.nerm.selector;

import lombok.AccessLevel;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Missionary (missionarymc@gmail.com) on 8/9/2017.
 */
@Getter
public class Server {

    private String name;
    @Getter(AccessLevel.PRIVATE)
    private Material material;
    private int data;
    private List<String> lore;
    private int position;
    private boolean isUsingEZQueue;

    public Server(String name, Material material, int data, List<String> lore, int position, boolean isUsingEZQueue) {
        this.name = name;
        this.material = material;
        this.data = data;
        this.lore = lore;
        this.position = position;
        this.isUsingEZQueue = isUsingEZQueue;
    }

    public ItemStack getItemStackFromMaterial(){
        ItemStack serverItem = new ItemStack(material, 1, (short) data);
        ItemMeta serverItemMeta = serverItem.getItemMeta();
        serverItemMeta.setDisplayName(name);
        List<String> lore;
        List<String> lore1 = this.lore;
        lore = lore1.stream().map(aLore -> aLore.replace('&', '§')).collect(Collectors.toList());
        serverItemMeta.setLore(lore);
        serverItem.setItemMeta(serverItemMeta);
        return serverItem;
    }
}
