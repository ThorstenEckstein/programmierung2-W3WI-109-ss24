package de.dhbw.planning;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum Modules {

    WelcomeIntroAndSetup(
            "WInS",
            "module-intro",
            "Willkommen, Einführung & Setup"),
    ToolsAndHelp(
            "TnH",
            "module-intro",
            "Werkzeuge, Hilfe, allgemeine Themen rund um die Softwareentwicklung"),
    ClassesAndObjects(
            "CnO",
            "module-classes",
            "Klassen & Objekte (Instanzen)"),
    InterfacesAndAbstractClasses(
            "InAC",
            "module-interfaces",
            "Interfaces & abstrakte Klassen"),
    DatatypesAndCasting(
            "DnC",
            "module-datatypes",
            "Datentypen & Typumwandlungen"),
    LoopsAndConditions(
            "LnC",
            "module-loops",
            "Kontrollstrukturen, Schleifen & Konditionalausdrücke"),
    VisibilityAndAccessModifier(
            "VnAM",
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