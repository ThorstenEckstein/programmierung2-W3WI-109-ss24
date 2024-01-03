package de.dhbw.planning;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static de.dhbw.planning.Constants.DURATION_DEFAULT;

@SuppressWarnings("all")
public class AgendaScheduler {

    private Agenda agenda;

    public AgendaScheduler() { }

    public AgendaScheduler(Agenda agenda) {
        this.agenda = agenda;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    // ------------------ public utilities

    public List<List<Item>> splitAgendaBy(ContentType contentType, CourseDay courseDay) {
        List<List<Item>> itemLists = new LinkedList<>();

        List<Item> items = courseDay.getAgenda().getItems();
        List<Item> itemsWithSameContentType = getItemsByContentType(contentType, items);

        if (itemsWithSameContentType.size() == 1) {
            Item splitItem = itemsWithSameContentType.get(0);
            int splitIndex = items.indexOf(splitItem);
            List<Item> subListBefore = items.subList(0, splitIndex);
            List<Item> subListAfter = items.subList(splitIndex + 1, items.size() - 1);
            itemLists.add(subListBefore);
            itemLists.add(subListAfter);
        }
        else if (itemsWithSameContentType.size() == 2) {
            Item splitItem1 = itemsWithSameContentType.get(0);
            Item splitItem2 = itemsWithSameContentType.get(1);
            int splitIndex1 = items.indexOf(splitItem1);
            int splitIndex2 = items.indexOf(splitItem2);
            List<Item> subListBefore  = items.subList(0, splitIndex1);
            List<Item> subListBetween = items.subList(splitIndex1 + 1, splitIndex2);
            List<Item> subListAfter   = items.subList(splitIndex2 + 1, items.size());
            itemLists.add(subListBefore);
            itemLists.add(subListBetween);
            itemLists.add(subListAfter);
        }
        else {
            String message = String.format(
                    "[WARNING] The given agenda contains more than %s items of type '%s', " +
                    "but splitting agenda with more than '%s' is not yet supported!",
                    itemsWithSameContentType.size(),
                    contentType,
                    2
            );
            throw new IllegalArgumentException(message);
        }

        return itemLists;
    }

    public static Duration calculateTotalDuration(Agenda agenda, Class<?> clazz) {
        Duration total = Duration.ZERO;
        if (agenda == null) {
            System.err.printf(
                    "WARNING: Specified agenda for '%s' is 'null', \n"+
                    "         Using default '%s' to calculate total duration!",
                    clazz != null ? clazz.getSimpleName() : "unknown",
                    DURATION_DEFAULT
            );
            return total;
        }
        for (Item item : agenda.getItems()) {
            Duration itemDuration = item.getDuration();
            total = total.plus(itemDuration);
        }
        return total;
    }

    public static Duration calculateDuration(List<Item> items) {
        if (items == null) { return Duration.ZERO; }
        Duration sum = Duration.ZERO;
        for (Item item : items) {
            Duration itemDuration = item.getDuration();
            sum = sum.plus(itemDuration);
        }
        return sum;
    }

    // ------------------ private methods

    private List<Item> getItemsByContentType(ContentType contentType, List<Item> items) {
        if (isNull(items) || items.isEmpty()) { return Collections.EMPTY_LIST; }
        return items
                .stream()
                .filter(i -> isContentType(contentType, i))
                .collect(Collectors.toList());
    }

    private boolean isContentType(ContentType contentType, Item item) {
        if (contentType == null || item == null || item instanceof CourseDay || item instanceof Module) return false;
        return contentType.equals(((Content)item).getContentType());
    }

    private boolean isNull(Object object) {
        return object == null;
    }

}