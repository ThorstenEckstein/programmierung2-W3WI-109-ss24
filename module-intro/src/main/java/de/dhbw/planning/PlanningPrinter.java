package de.dhbw.planning;

public class PlanningPrinter {

    private static void _printSimple(Object object) {
        System.out.println(object);
    }

    public static void printSimple(Course course) {
        if(course == null) { throw new IllegalArgumentException("Course could not be printed, it is null!"); }
        _printSimple(course);
    }

    public static void printSimple(CourseDay courseDay) {
        if(courseDay == null) { throw new IllegalArgumentException("CourseDay could not be printed, it is null!"); }
        _printSimple(courseDay);
    }

    public static void printSimple(Module module) {
        if(module == null) { throw new IllegalArgumentException("Module could not be printed, it is null!"); }
        _printSimple(module);
    }

    public static void printSimple(Content content) {
        if(content == null) { throw new IllegalArgumentException("Content could not be printed, it is null!"); }
        _printSimple(content);
    }

    public static void printSimple(Agenda agenda) {
        if(agenda == null) { throw new IllegalArgumentException("Agenda could not be printed, it is null!"); }
        String _agenda = toString(agenda);
        _printSimple(_agenda);
    }

    private static String toString(Agenda agenda) {
        StringBuilder _agenda = new StringBuilder();

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
                        content.getType(),
                        content.getDuration(),
                        content.getDescription(),
                        content.isCompleted()
                );
            }
            else if (item instanceof CourseDay courseDay) {
                _item = String.format(
                        "\n[%s] %s",
                        CourseDay.class.getSimpleName(),
                        courseDay.getTitle()
                );
            } else {
                throw new IllegalArgumentException(
                        "Agenda items of type '"+item.getClass().getSimpleName()+"' not yet supported!");
            }
            _agenda.append(_item);
        }
        return _agenda.toString();
    }

}
