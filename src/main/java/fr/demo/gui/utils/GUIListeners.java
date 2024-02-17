package fr.demo.gui.utils;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

import java.util.Objects;

public class GUIListeners implements Listener {
    private GUI gui;
    private GUIManager manager;

    public GUIListeners(GUI gui, GUIManager manager) {
        this.gui = gui;
        this.manager = manager;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (Objects.equals(event.getClickedInventory(), gui.getInventory())) {
            event.setCancelled(true);
            int clickedSlot = event.getSlot();
            for (Entry entry : gui.getEntries()) {
                if (entry.getSlot() == clickedSlot) {
                    entry.onClick(event);
                    break;
                }
            }
        }
    }

    @EventHandler
    public void onOpen(InventoryOpenEvent event) {
        if (event.getInventory().equals(gui.getInventory())) {
            gui.onOpen(event);
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        if (event.getInventory().equals(gui.getInventory())) {
            gui.onClose(event);

            InventoryClickEvent.getHandlerList().unregister(this);
            InventoryOpenEvent.getHandlerList().unregister(this);
            InventoryCloseEvent.getHandlerList().unregister(this);
        }
    }
}
