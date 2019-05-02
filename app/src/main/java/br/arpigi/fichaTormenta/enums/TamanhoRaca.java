package br.arpigi.fichaTormenta.enums;


public enum TamanhoRaca {
    PEQUENA((byte) 1, (byte) 1), MEDIA((byte) 0, (byte) 0);

    private Byte modArma;
    private Byte modCa;

    TamanhoRaca(Byte modArma, Byte modCa) {
        this.modArma = modArma;
        this.modCa = modCa;
    }

    public Byte getModArma() {
        return modArma;
    }

    public Byte getModCa() {
        return modCa;
    }


}
