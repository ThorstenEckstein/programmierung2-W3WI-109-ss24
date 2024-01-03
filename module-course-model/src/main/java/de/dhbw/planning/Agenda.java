package de.dhbw.planning;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Agenda {

    private List<Item> items = new LinkedList<>();

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    @JsonDeserialize(as=LinkedList.class)
    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "items=" + items +
                '}';
    }
}