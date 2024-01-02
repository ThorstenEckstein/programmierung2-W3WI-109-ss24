package de.dhbw.planning;

import java.util.Arrays;

public enum Modules {

    WelcomeIntroAndSetup("WIaS", "Willkommen, Einführung & Setup"),
    Miscellaneous("Misc", "Verschiedenen, Container für nicht zuordbare Inhalte")
    ;

    private final String acronym;
    private final String title;

    Modules(String acronym, String title) {
        this.acronym = acronym;
        this.title = title;
    }

    public String getAcronym() {
        return acronym;
    }

    public String getTitle() {
        return title;
    }

    public Modules from(String acronym) {
        return Arrays
                .stream(Modules.values())
                .filter(m -> m.getAcronym().equalsIgnoreCase(acronym))
                .findFirst()
                .orElse(Modules.Miscellaneous);
    }
}