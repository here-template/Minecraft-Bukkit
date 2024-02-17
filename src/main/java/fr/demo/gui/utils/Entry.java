package fr.demo.gui.utils;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.List;

public abstract class Entry {
    public Entry(Material material, String name, List<String> lore, int quantity, int slot) {
        this.material = material;
        this.name = name;
        this.lore = lore;
        this.quantity = quantity;
        this.slot = slot;
    }

    private Material material;
    private String name;
    private List<String> lore;
    private int quantity;
    private int slot;

    public Material getMaterial() {
        return material;
    }
    public String getName() {
        return name;
    }
    public List<String> getLore() {
        return lore;
    }
    public int getQuantity() {
        return quantity;
    }
    public int getSlot() {
        return slot;
    }

    public abstract void onClick(InventoryClickEvent event);
    public abstract void onUpdate();
}
