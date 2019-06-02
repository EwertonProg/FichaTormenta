package br.arpigi.fichaTormenta.model;

import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.converter.PropertyConverter;

@Entity
public class Arma extends Item {

    private Byte critico;
    private Byte modCritico;
    private String dano;
    private Byte distancia;

    @Convert(converter = TipoConverter.class,dbType = String.class)
    private Tipo tipo;

    public Arma(Long id, String nome, Integer peso, Integer preco, Byte critico, Byte modCritico, Byte distancia, Tipo tipo, String dano) {
        super(id, nome, peso, preco);
        this.critico = critico;
        this.modCritico = modCritico;
        this.distancia = distancia;
        this.tipo = tipo;
        this.dano = dano;
    }
     public Arma(String nome, Integer peso, Integer preco, Byte critico, Byte modCritico, Byte distancia, Tipo tipo, String dano) {
            super(nome, peso, preco);
            this.critico = critico;
            this.modCritico = modCritico;
            this.distancia = distancia;
            this.tipo = tipo;
            this.dano = dano;
        }

    public Arma() {
    }


    public Byte getCritico() {
        return this.critico;
    }

    public void setCritico(Byte critico) {
        this.critico = critico;
    }

    public Byte getModCritico() {
        return this.modCritico;
    }

    public void setModCritico(Byte modCritico) {
        this.modCritico = modCritico;
    }

    public Byte getDistancia() {
        return this.distancia;
    }

    public void setDistancia(Byte distancia) {
        this.distancia = distancia;
    }

    public Tipo getTipo() {
        return this.tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getDano() {
        return dano;
    }

    public void setDano(String dano) {
        this.dano = dano;
    }

    public enum Tipo {
        CORTE("Corte"), PERFURACAO("Perfuração"), ESMAGAMENTO("Esmagamento");
        private String nome;

        private Tipo(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }
    }

    public static class TipoConverter implements PropertyConverter<Tipo,String>{

        @Override
        public Tipo convertToEntityProperty(String databaseValue) {
            return Tipo.valueOf(databaseValue);
        }

        @Override
        public String convertToDatabaseValue(Tipo entityProperty) {
            return entityProperty.toString();
        }
    }


}
