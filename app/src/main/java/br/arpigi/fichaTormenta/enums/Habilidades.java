package br.arpigi.fichaTormenta.enums;

public enum Habilidades {
    FORCA("Força"), DESTREZA("Destreza"), CONSTITUICAO("Constituição"), INTELIGENCIA("Inteligência"),
    SABEDORIA("Sabedoria"), CARISMA("Carisma");

    private String nome;

    private Habilidades(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
