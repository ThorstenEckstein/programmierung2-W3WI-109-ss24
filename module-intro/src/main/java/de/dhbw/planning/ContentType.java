package de.dhbw.planning;

public enum ContentType {
    Break         (null,                  null)
    ,Demo         ("eye",                 "gray")
    ,Domain       ("train",               "red")
    ,Exam         ("graduation-cap",      "green")
    ,Exercise     ("flask",               "red")
    ,Setup        ("gear",                "blue")
    ,Theory       (null,                  null)
    ,Topic        ("book",                "gray")
    ,UpdateProject("arrow-circle-o-down", "red")
    ,Welcome      ("heart",               "red")
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

}