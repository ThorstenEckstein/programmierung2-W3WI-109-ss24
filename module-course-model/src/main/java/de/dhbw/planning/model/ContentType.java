package de.dhbw.planning.model;

public enum ContentType {
    Break         ("pause",               "green")
    ,Demo         ("eye",                 "gray")
    ,Domain       ("train",               "red")
    ,Exam         ("graduation-cap",      "green")
    ,Exercise     ("flask",               "red")
    ,Setup        ("gear",                "blue")
    ,Theory       ("book",                "gray")
    ,Topic        ("book",                "gray")
    ,UpdateProject("arrow-circle-o-down", "red")
    ,Welcome      ("heart",               "red")
    ,Unknown      ("question",            "black")

    ,Buffer       ("clock-o",             "gray")
    ;

    private final String icon;
    private final String role;

    ContentType(String icon, String role) {
        this.icon = icon;
        this.role = role;
    }

    public String getIcon() {
        return icon;
    }

    public String getRole() {
        return role;
    }

    public static boolean isBreak(ContentType contentType) {
        return ContentType.Break.equals(contentType);
    }

}