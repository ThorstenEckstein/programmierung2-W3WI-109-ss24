package de.dhbw.planning.model;

import java.util.Arrays;

public enum Modules {

    WelcomeIntroAndSetup(
            "WI+S",
            "module-intro",
            "Willkommen, Einführung & Setup"),
    ToolsAndHelp(
            "T+H",
            "module-intro",
            "Werkzeuge, Hilfe, allgemeine Themen rund um die Softwareentwicklung"),
    ClassesAndObjects(
            "C+O",
            "module-classes",
            "Klassen & Objekte (Instanzen)"),
    InterfacesAndAbstractClasses(
            "I+AC",
            "module-interfaces",
            "Interfaces & abstrakte Klassen"),
    DatatypesAndCasting(
            "D+C",
            "module-datatypes",
            "Datentypen & Typumwandlungen"),
    LoopsAndConditions(
            "L+C",
            "module-loops",
            "Kontrollstrukturen, Schleifen & Konditionalausdrücke"),
    VisibilityAndAccessModifier(
            "V+AM",
            "module-visibility",
            "Scopes, Sichtbarkeiten, Access Modifier"),
    Miscellaneous(
            "Misc",
            "miscellaneous",
            "Verschiedenen, Container für nicht zuordbare Inhalte"),
    Unknown(
            "Unk",
            "unknown",
            "Unbekannt")
    ;

    private final String acronym;
    private final String directory;
    private final String title;

    Modules(String acronym, String directory, String title) {
        this.acronym = acronym;
        this.directory = directory;
        this.title = title;
    }

    // If you want to use the acronym to be written/read, just activate this: @JsonValue
    public String getAcronym() {
        return acronym;
    }

    public String getDirectory() {
        return directory;
    }

    public String getTitle() {
        return title;
    }

    public Modules from(String acronymOrDirectory) {
        return Arrays
                .stream(Modules.values())
                .filter(m ->
                        m.getAcronym().equalsIgnoreCase(acronymOrDirectory) ||
                        m.getDirectory().equalsIgnoreCase(acronymOrDirectory)
                )
                .findFirst()
                .orElse(Modules.Miscellaneous);
    }
}