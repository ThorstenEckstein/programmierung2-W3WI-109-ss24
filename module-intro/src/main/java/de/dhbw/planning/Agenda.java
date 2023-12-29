package de.dhbw.planning;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <pre>
 * Agenda Example:
 *   1. Module
 *   2. Pause
 *   3. Module
 * </pre>
 */
public class Agenda {

    private Set<Item> items = new LinkedHashSet<>();

    public Set<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

}