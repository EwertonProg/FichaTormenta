package br.arpigi.fichaTormenta.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Index;
import io.objectbox.annotation.IndexType;
import io.objectbox.annotation.Transient;
import io.objectbox.annotation.Unique;
import io.objectbox.converter.PropertyConverter;

@Entity
public class Magia {
    @Id
    private Long id;

    @Index(type = IndexType.HASH)
    @Unique
    private String nome;

    private Byte nivel;

    private String alvo;

    private String alcance;

    @Convert(converter = TipoMagiaConverter.class, dbType = String.class)
    private TipoMagia tipoMagia;

    @Convert(converter = DescritorConverter.class, dbType = String.class)
    private List<Descritor> descritores;

    private String tempoDeExecucao;

    private String Descricao;

    @Transient
    private Boolean onPersonagem = false;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Byte getNivel() {
        return nivel;
    }

    public void setNivel(Byte nivel) {
        this.nivel = nivel;
    }

    public String getAlvo() {
        return alvo;
    }

    public void setAlvo(String alvo) {
        this.alvo = alvo;
    }

    public String getAlcance() {
        return alcance;
    }

    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }

    public TipoMagia getTipoMagia() {
        return tipoMagia;
    }

    public void setTipoMagia(TipoMagia tipoMagia) {
        this.tipoMagia = tipoMagia;
    }

    public List<Descritor> getDescritor() {
        return descritores;
    }

    public void setDescritor(List<Descritor> descritors) {
        this.descritores = descritors;
    }

    public String getTempoDeExecucao() {
        return tempoDeExecucao;
    }

    public void setTempoDeExecucao(String tempoDeExecucao) {
        this.tempoDeExecucao = tempoDeExecucao;
    }

    public Boolean getOnPersonagem() {
        return onPersonagem;
    }

    public void setOnPersonagem(Boolean onPersonagem) {
        this.onPersonagem = onPersonagem;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public enum TipoMagia{
        ARCANA("Arcana"), DIVINA("Divina");

        private String nome;

        TipoMagia(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }
    }

    public enum Descritor{
        ABJURACAO("Abjuração"), ACIDO("Ácido"), AGUA("Água"), AR("Ar"), ELETRICIADE("eletricidade"),
        ESSENCIA("Essência"), FOGO("Fogo"), FRIO("Frio"), SONICO("Sônico"), TERRA("Terra"),
        ADIVINHACAO("Adivinhação"), BEM("Bem"), MAL("Mal"), ORDEM("Ordem"), CAOS("Caos"), CURA("Cura"),
        ESMAGAMENTO("Encantamento"), ESCURIDAP("Escuridão"), LUZ("Luz"), ILUSAO("Ilusão"),
        INVOCACAO("Invocação"), MEDO("Medo"), NECROMANCIA("Necromancia"), TRANSMUTACAO("Transmutação");

        private String nome;

        Descritor(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }
    }

    public static class TipoMagiaConverter implements PropertyConverter<TipoMagia,String> {

        @Override
        public TipoMagia convertToEntityProperty(String databaseValue) {
            return TipoMagia.valueOf(databaseValue);
        }

        @Override
        public String convertToDatabaseValue(TipoMagia entityProperty) {
            return entityProperty.toString();
        }
    }

    public static class DescritorConverter implements PropertyConverter<List<Descritor>,String> {
        Gson gson;
        @Override
        public List<Descritor> convertToEntityProperty(String databaseValue) {
            gson = new Gson();
            Type type = new TypeToken<List<String>>(){}.getType();
            ArrayList<String> descritoresString = gson.fromJson(databaseValue,type);
            ArrayList<Descritor> descritores = new ArrayList<>();
            for (String descritorString:descritoresString){
                descritores.add(Descritor.valueOf(descritorString));
            }
            return descritores;
        }

        @Override
        public String convertToDatabaseValue(List<Descritor> entityProperty) {
            gson = new Gson();
            ArrayList<String> descritoresString = new ArrayList<>();
            for(Descritor descritor : entityProperty){
                descritoresString.add(descritor.toString());
            }
            return gson.toJson(descritoresString);
        }
    }
}
