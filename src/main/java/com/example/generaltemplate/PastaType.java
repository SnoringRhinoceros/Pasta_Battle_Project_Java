package com.example.generaltemplate;

public enum PastaType {
    SPAGHETTI("Spaghetti"),
    RAVIOLI("Ravioli"),
    ROTINI("Rotini");
    private String name;
    PastaType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
