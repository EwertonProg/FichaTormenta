package br.arpigi.fichaTormenta.model;


import java.util.Comparator;

import br.arpigi.fichaTormenta.enums.Pericias;
import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Index;
import io.objectbox.converter.PropertyConverter;

@Entity
public class Pericia implements Comparator<Pericia> {
    @Id
    private Long id;

    @Index
    @Convert(converter = PericiasConverter.class,dbType = String.class)
    private Pericias nome;

    @Convert(converter = EspecificacaoConverter.class,dbType = String.class)
    private Pericias.Especificacao espec;

    private Byte graduacao;
    private Byte modHabilidade;
    private Byte bonus;
    private Byte nivelPersonagem;
    private boolean treinada;

    public Pericia() {
    }

    public Pericia(Pericias nome) {
        this.nome = nome;
        this.modHabilidade = 0;
        this.nivelPersonagem = 0;
        this.bonus = 0;
        this.espec = Pericias.Especificacao.VAZIA;
    }

    public Pericia(Pericias nome, boolean treinada) {
        this(nome);
        this.treinada = treinada;
    }

    public Pericia(Pericias nome, Pericias.Especificacao espec, boolean treinada) {
        this(nome, treinada);
        this.espec = espec;
    }

    public Pericia(Long id, Pericias nome, Pericias.Especificacao espec, Byte graduacao, Byte modHabilidade,
                   Byte bonus, Byte nivelPersonagem, boolean treinada) {
        this.id = id;
        this.nome = nome;
        this.espec = espec;
        this.graduacao = graduacao;
        this.modHabilidade = modHabilidade;
        this.bonus = bonus;
        this.nivelPersonagem = nivelPersonagem;
        this.treinada = treinada;
    }

    public void calcularBonus() {
        if (this.treinada) {
            this.graduacao = (byte) (3 + nivelPersonagem);
        } else {
            this.graduacao = (byte) (nivelPersonagem / 2);
        }

        this.bonus = (byte) (this.graduacao + this.modHabilidade);
    }

    public Pericias getNome() {
        return nome;
    }

    public void setNome(Pericias nome) {
        this.nome = nome;
    }

    public Pericias.Especificacao getEspec() {
        return espec;
    }

    public void setEspec(Pericias.Especificacao espec) {
        this.espec = espec;
    }

    public Byte getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(Byte graduacao) {
        this.graduacao = graduacao;
    }

    public Byte getModHabilidade() {
        return modHabilidade;
    }

    public void setModHabilidade(Byte modHabilidade) {
        this.modHabilidade = modHabilidade;
    }

    public Byte getBonus() {
        return bonus;
    }

    public void setBonus(Byte bonus) {
        this.bonus = bonus;
    }

    public Byte getNivelPersonagem() {
        return nivelPersonagem;
    }

    public void setNivelPersonagem(Byte nivelPersonagem) {
        this.calcularBonus();
        this.nivelPersonagem = nivelPersonagem;
    }

    public boolean isTreinada() {
        return treinada;
    }

    @Override
    public boolean equals(Object obj) {
        Pericia outra = (Pericia) obj;
        return this.nome.equals(outra.nome) && this.espec.equals(outra.espec);
    }

    @Override
    public String toString() {
        return this.nome + " " + this.espec;
    }

    @Override
    public int compare(Pericia o1, Pericia o2) {
        if (o1.equals(o2)) {
            return 0;
        }
        return o1.nome.compareTo(o2.nome);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getTreinada() {
        return this.treinada;
    }

    public void setTreinada(boolean treinada) {
        this.treinada = treinada;
    }

    public static class PericiasConverter implements PropertyConverter<Pericias,String> {

        @Override
        public Pericias convertToEntityProperty(String databaseValue) {
            return Pericias.valueOf(databaseValue);
        }

        @Override
        public String convertToDatabaseValue(Pericias entityProperty) {
            return entityProperty.toString();
        }
    }

    public static class EspecificacaoConverter implements PropertyConverter<Pericias.Especificacao,String>{

        @Override
        public Pericias.Especificacao convertToEntityProperty(String databaseValue) {
            return Pericias.Especificacao.valueOf(databaseValue);
        }

        @Override
        public String convertToDatabaseValue(Pericias.Especificacao entityProperty) {
            return entityProperty.toString();
        }
    }

}