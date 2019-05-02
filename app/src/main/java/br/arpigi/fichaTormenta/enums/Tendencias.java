package br.arpigi.fichaTormenta.enums;

public enum Tendencias {
    LB("Leal/Bondoso"), NB("Neutro/Bondoso"), CB("Caótico/Bondoso"),
    LN("Leal/Neutro"), N("Neutro"), CN("Caótico/Neutro"),
    LM("Leal/Maligno"), NM("Neutro/Maligno"), CM("Caótico/Maligno");

    private String nome;

    private Tendencias(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
