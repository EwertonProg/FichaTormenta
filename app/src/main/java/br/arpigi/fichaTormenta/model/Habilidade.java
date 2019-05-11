package br.arpigi.fichaTormenta.model;


import br.arpigi.fichaTormenta.enums.Habilidades;
import br.arpigi.fichaTormenta.util.HabilidadesConverter;
import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Index;

@Entity
public class Habilidade {
    @Id
    private Long id;

    @Index
    @Convert(converter = HabilidadesConverter.class,dbType = String.class)
    private Habilidades nome;

    private Byte valor;

    public Habilidade(Habilidades nome, Byte valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public Habilidade(Habilidades nome) {
        this.nome = nome;
    }

    public Habilidade() {
    }

    public static CharSequence calcularModificador(Integer valor){
        byte mod = (byte) ((valor - 10) / 2);
        if (valor < 10 && valor % 2 == 1) {
            mod--;
        }
        return Byte.toString(mod);
    }

    public Byte calcularModificador() {
        byte mod = (byte) ((this.valor - 10) / 2);
        if (this.valor < 10 && this.valor % 2 == 1) {
            mod--;
        }
        return mod;
    }

    public void aumentarHab(Byte valor) {
        this.valor = (byte) (this.valor + valor);
    }

    public Byte getValor() {
        return valor;
    }

    public void setValor(Byte valor) {
        this.valor = valor;
    }

    public Habilidades getNome() {
        return nome;
    }

    public void setNome(Habilidades nome) {
        this.nome = nome;
    }

    public void addValor(Byte valor) {
        this.valor = (byte) (this.valor + valor);
    }

    @Override
    public boolean equals(Object obj) {
        Habilidade hab = (Habilidade) obj;
        return this.nome.equals(hab.getNome());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
