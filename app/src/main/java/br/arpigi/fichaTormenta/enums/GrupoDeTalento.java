package br.arpigi.fichaTormenta.enums;

public enum GrupoDeTalento {
    COMBATE("Combate"), PERICIA("Pericia"), MAGIA("Magia"), PODER_CONCEDIDO("Poder Concedido"), TORMENTA("Tormenta"),
    DESTINO("Destino");

    String nome;

    private GrupoDeTalento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
