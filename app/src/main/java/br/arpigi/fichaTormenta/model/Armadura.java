package br.arpigi.fichaTormenta.model;

import io.objectbox.annotation.Entity;

@Entity
public class Armadura extends Item {
    private Byte bonusCA;
    private Byte penArmadura;
    private Byte maxDes;

    public Armadura(Long id, String nome, Integer peso, Integer preco, Byte bonusCA, Byte penArmadura, Byte maxDes) {
        super(id, nome, peso, preco);
        this.bonusCA = bonusCA;
        this.penArmadura = penArmadura;
        this.maxDes = maxDes;
    }

    public Armadura() {
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

    public Byte getMaxDes() {
        return this.maxDes;
    }

    public void setMaxDes(Byte maxDes) {
        this.maxDes = maxDes;
    }
}
