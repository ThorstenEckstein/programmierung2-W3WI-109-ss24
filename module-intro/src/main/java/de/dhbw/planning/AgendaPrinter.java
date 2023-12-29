package de.dhbw.planning;

public class AgendaPrinter {

    public static void print(Agenda agenda) {
        if(agenda == null) { throw new IllegalArgumentException("Agenda could not be printed (null)!"); }
        String _agenda = toString(agenda);
        System.out.println(_agenda);
    }

    private static String toString(Agenda agenda) {
        StringBuffer _agenda = new StringBuffer();

        for (Item item : agenda.getItems()) {
            String _item = "n/a";
            if (item instanceof Module module) {
                _item = String.format(
                        "\n[%s] %s. %s (%s)",
                        Module.class.getSimpleName(),
                        module.getIndex(),
                        module.getTitle(),
                        module.getDirectory()
                );
            } else if (item instanceof Content content) {
                _item = String.format(
                        "\n[%s|%s] %s, %s (completed=%s)",
                        Content.class.getSimpleName(),
                        content.getContentType(),
                        content.getDuration(),
                        content.getDescription(),
                        content.isCompleted()
                );
            }
            _agenda.append(_item);
        }
        return _agenda.toString();
    }

}
