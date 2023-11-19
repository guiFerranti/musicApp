package com.guilherme.MusicApp.models;

public enum Tipo {
    SOLO("solo"),
    DUO("duo"),
    BANDA("banda");

    private String tipo;

    Tipo(String tipo){
        this.tipo = tipo;
    }

    public static Tipo qualTipo(String opcao) {
        for (Tipo tipo: Tipo.values()) {
            if(tipo.tipo.contains(opcao)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Nenhum tipo encontrado");
    }
}
