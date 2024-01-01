package de.dhbw.planning.print;

import de.dhbw.planning.*;
import de.dhbw.planning.Module;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class DeepPrinter {

    private static void systemOutPrintln(Object object) {
        System.out.println(object);
    }

    public static void printPretty(Course course) {
        if(course == null) { throw new IllegalArgumentException("Course could not be printed, it is null!"); }
        String _course = toString(course);
        systemOutPrintln(_course);
    }

    private static String toString(Course course) {
        return """
                LV             : %s
                Semester       : %s
                Agenda         :
                %s
                """.formatted(
                course.getTitle(),
                course.getSemester(),
                toString(course.getAgenda())
        );
    }

    private static String toString(CourseDay courseDay) {
        return """
                [%s] %s: %s"
                %s
                """.formatted(
                CourseDay.class.getSimpleName(),
                toString(courseDay.getDate()),
                courseDay.getTitle(),
                toString(courseDay.getAgenda())
        );
    }

    private static String toString(Module module) {
        return """
                [%s] %s. %s (%s)
                %s
                """.formatted(
                Module.class.getSimpleName(),
                module.getIndex(),
                module.getTitle(),
                module.getDirectory(),
                toString(module.getAgenda())
        );
    }

    private static String toString(Content content) {
        return String.format(
                "\n[%s|%s] %s, %s (completed=%s)",
                Content.class.getSimpleName(),
                content.getContentType(),
                content.getDuration(),
                content.getDescription(),
                content.isCompleted()
        );
    }

    private static String toString(LocalDate date) {
        return String.format("%s %s %s",
                date.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.GERMANY),
                Constants.DEFAULT_DATE_FORMATTER.format(date),
                "09:15-12:15"
        );
    }

    private static String toString(Agenda agenda) {
        if (agenda != null) {
            StringBuilder _agenda = new StringBuilder();

            for (Item item : agenda.getItems()) {
                String _item = "n/a";

                if (item instanceof CourseDay courseDay) {
                    _item = toString(courseDay);
                }
                else if (item instanceof Module module) {
                    _item = toString(module);
                }
                else if (item instanceof Content content) {
                    _item = toString(content);
                }
                else {
                    throw new IllegalArgumentException(
                            "Agenda items of type '"+item.getClass().getSimpleName()+"' not yet supported!");
                }
                _agenda.append(_item);
            }
            return _agenda.toString();
        }
        else {
            return "WARNING: Agenda is null!";
        }
    }
}