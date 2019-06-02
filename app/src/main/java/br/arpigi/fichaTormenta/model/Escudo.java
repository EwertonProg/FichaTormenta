package br.arpigi.fichaTormenta.model;

import io.objectbox.annotation.Entity;

@Entity
public class Escudo extends Item {
    private Byte bonusCA;
    private Byte penArmadura;

    public Escudo(Long id, String nome, Integer peso, Integer preco, Byte bonusCA, Byte penArmadura) {
        super(id, nome, peso, preco);
        this.bonusCA = bonusCA;
        this.penArmadura = penArmadura;
    }
    public Escudo( String nome, Integer peso, Integer preco, Byte bonusCA, Byte penArmadura) {
        super(nome, peso, preco);
        this.bonusCA = bonusCA;
        this.penArmadura = penArmadura;
    }

    public Escudo() {
    }


    public Byte getBonusCA() {
        return this.bonusCA;
    }

    public void setBonusCA(Byte bonusCA) {
        this.bonusCA = bonusCA;
    }

    public Byte getPenArmadura() {
        return this.penArmadura;
    }

    public void setPenArmadura(Byte penArmadura) {
        this.penArmadura = penArmadura;
    }
}
