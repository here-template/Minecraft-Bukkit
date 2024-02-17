package fr.demo.gui;

import fr.demo.gui.entry.HealEntry;
import fr.demo.gui.utils.Entry;
import fr.demo.gui.utils.GUI;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

import java.util.List;

public class DemoGUI extends GUI {
    private List<Entry> entries;

    public DemoGUI(String indentifier, int size, String title) {
        super(indentifier, size, title);

        this.entries = List.of(
                new HealEntry(Material.GOLDEN_APPLE, "&6Heal", List.of("Heal yourself!"), 1, 0)
        );
    }

    @Override
    public List<Entry> getEntries() {
        return entries;
    }

    @Override
    public void onOpen(InventoryOpenEvent event) {

    }

    @Override
    public void onClose(InventoryCloseEvent event) {

    }
}
