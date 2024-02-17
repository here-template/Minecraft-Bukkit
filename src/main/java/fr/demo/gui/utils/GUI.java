package fr.demo.gui.utils;

import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import java.util.List;

public abstract class GUI {
    public GUI(String indentifier, int size, String title) {
        this.indentifier = indentifier;
        this.size = size;
        this.title = title;
    }

    private String indentifier;
    private int size;
    private String title;
    private Inventory inventory;
    private List<Entry> entries;

    public String getIndentifier() {
        return indentifier;
    }
    public int getSize() {
        return size;
    }
    public String getTitle() {
        return title;
    }
    public List<Entry> getEntries() {
        return entries;
    }
    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public abstract void onOpen(InventoryOpenEvent event);
    public abstract void onClose(InventoryCloseEvent event);
}
