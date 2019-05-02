package br.arpigi.fichaTormenta.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Index;
import io.objectbox.annotation.IndexType;
import io.objectbox.annotation.Unique;

@Entity
public class Item {
    @Id
    private Long id;

    @Index(type = IndexType.HASH)
    @Unique
    private String nome;

    private Integer peso;

    private Integer preco;

    public Item(Long id, String nome, Integer peso, Integer preco) {
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.preco = preco;
    }

    public Item() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
