package br.arpigi.fichaTormenta.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Index;
import io.objectbox.annotation.IndexType;
import io.objectbox.annotation.Unique;

@Entity
public class Magia {
    @Id
    private Integer id;

    @Index(type = IndexType.HASH)
    @Unique
    private String nome;
}
