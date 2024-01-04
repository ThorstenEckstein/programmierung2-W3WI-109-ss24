package de.dhbw.planning.print;

import de.dhbw.planning.model.Module;
import de.dhbw.planning.model.*;
import de.dhbw.planning.scheduling.ContentSchedule;
import de.dhbw.planning.scheduling.CourseDaySchedule;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import static de.dhbw.planning.model.ContentType.isBreak;

public class DeepPrinter {

    private static final String I3 = "   ";
    private static final String I6 = "      ";
    private static final String I9 = "         ";

    private static void print(Object object) {
        System.out.println(object);
    }

    public static void printPretty(List<CourseDaySchedule> courseDaySchedules) {
        for (CourseDaySchedule courseDaySchedule : courseDaySchedules) {
            print(toString(courseDaySchedule));
            List<ContentSchedule> contentSchedules = courseDaySchedule.getContentSchedules();
            for (ContentSchedule contentSchedule : contentSchedules) {
                print(toString(contentSchedule));
            }
        }
    }

    public static void printPretty(Course course) {
        // print base data about LV
        print(toString(course));

        // course agenda
        Agenda courseAgenda = course.getAgenda();
        if (courseAgenda != null) {

            for(Item courseAgendaItem: courseAgenda.getItems()) {
                CourseDay courseDay = (CourseDay) courseAgendaItem;

                // print course day
                print(toString(courseDay));

                // course day agenda
                Agenda courseDayAgenda = courseDay.getAgenda();
                if (courseDayAgenda != null) {
                    int courseDayItemIndex = 1;

                    for(Item courseDayAgendaItem : courseDayAgenda.getItems()) {
                        String _courseDayAgendaItem = null;

                        // course day agenda item is one of 2 types

                        // module
                        if (courseDayAgendaItem instanceof Module module) {
                            _courseDayAgendaItem = toString(courseDayItemIndex, module);

                            // module agenda
                            Agenda moduleAgenda = module.getAgenda();
                            if (moduleAgenda != null) {
                                int contentIndex = 1;

                                for (Item moduleAgendaItem : moduleAgenda.getItems()) {
                                    Content content = (Content) moduleAgendaItem;

                                    // print content
                                    print(toString(contentIndex, I9, content));
                                }
                            }

                        }

                        // content
                        if (courseDayAgendaItem instanceof Content content) {
                            _courseDayAgendaItem = toString(courseDayItemIndex, I6, content);
                        }

                        // print course day
                        print(_courseDayAgendaItem);
                        // increase index
                        courseDayItemIndex++;
                    }
                }
            }
        }
    }

    private static String toString(Course course) {
        return """
                LV       : %s
                Semester : %s
                
                Agenda:"""
                .formatted(
                course.getTitle(),
                course.getSemester()
        );
    }

    private static String toString(CourseDay courseDay) {
        return String.format(
                "\n%s[%s] %s",
                I3,
                CourseDay.class.getSimpleName(),
                //toString(courseDay.getDate()),
                courseDay.getTitle()
        );
    }

    private static String toString(int index, Module module) {
        return String.format(
                "      %s. [%s] %s (%s)",
                index,
                Module.class.getSimpleName(),
                module.getTitle(),
                module.getDirectory()
        );
    }

    private static String toString(int index, String indention, Content content) {
        return String.format(
                "%s%s. [%s] %s, %s",
                indention,
                index,
                content.getContentType(),
                content.getDuration(),
                content.getDescription()
        );
    }

    private static String toString(LocalDate date) {
        return String.format("%s %s %s",
                date.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.GERMANY),
                Constants.DEFAULT_DATE_FORMATTER.format(date),
                "09:15-12:15"
        );
    }

    private static String toString(CourseDaySchedule courseDaySchedule) {
        return """
                \n%s: %s, %s - %s"""
                .formatted(
                        courseDaySchedule.getDate(),
                        courseDaySchedule.getCourseDay().getTitle(),
                        courseDaySchedule.getStartTime(),
                        courseDaySchedule.getEndTime()
                );
    }

    private static String toString(ContentSchedule contentSchedule) {
        Content content = contentSchedule.getContent();

        String format;
        if (isBreak(content.getContentType())) {
            format = "%s%s - %s [%-5s: %-8s]  --------------- %s ---------------";
        } else {
            format = "%s%s - %s [%-5s: %-8s]  %s";
        }

        //String padding = calculatePadding(contentSchedule);

        return String.format(format,
                I3,
                contentSchedule.getStartTime(),
                contentSchedule.getEndTime(),
                content.getModule().getAcronym(),
                content.getContentType(),
                //padding,
                content.getDescription()
        );
    }

    /*
    private static String calculatePadding(ContentSchedule contentSchedule) {
        // length of current indention
        int l1 = I3.length();
        // length of "StartTime - EndTime ", in any case 13
        int l2 = 13;
        // length of module acronym
        int l3 = contentSchedule.getContent().getModule().getAcronym().length();
        // length of content type term
        int l4 = contentSchedule.getContent().getContentType().toString().length();
        // plus layout chars (square brackets) or whitespaces, 2 brackets, 2 whitespaces
        int l5 = 4;

        int nTimes = 32 - (l1 + l2 + l3 + l4 + l5);

        return " ".repeat(nTimes);
    }
    */

}