package com.bees.brewery;

public enum Grao {
    CEVADA("Cevada"),
    AVEIA("Aveia"),
    ARROZ("Arroz"),
    TRIGO("Trigo"),
    MILHO("Milho");

    private String value;

    Grao(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
