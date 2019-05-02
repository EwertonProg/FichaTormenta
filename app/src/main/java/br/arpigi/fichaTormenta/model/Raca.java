package br.arpigi.fichaTormenta.model;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

import br.arpigi.fichaTormenta.enums.TamanhoRaca;
import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Index;
import io.objectbox.annotation.IndexType;
import io.objectbox.annotation.Unique;
import io.objectbox.converter.PropertyConverter;

@Entity
public class Raca {

    @Id
    private Long Id;

    @Index(type = IndexType.HASH)
    @Unique
    private String nome;

    @Convert(converter = ModHabConverter.class,dbType = String.class)
    private Map<Habilidade, Byte> modHab;

    private Byte deslocamento;

    @Convert(converter = TamanhoRacaConverter.class,dbType = String.class)
    private TamanhoRaca tamanho;

    public Raca(String nome, Map<Habilidade, Byte> modHab, Byte deslocamento, TamanhoRaca tamanho) {
        this.nome = nome;
        this.modHab = modHab;
        this.deslocamento = deslocamento;
        this.tamanho = tamanho;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<Habilidade, Byte> getModHab() {
        return modHab;
    }

    public void setModHab(Map<Habilidade, Byte> modHab) {
        this.modHab = modHab;
    }

    public Byte getDeslocamento() {
        return deslocamento;
    }

    public void setDeslocamento(Byte deslocamento) {
        this.deslocamento = deslocamento;
    }

    public TamanhoRaca getTamanho() {
        return tamanho;
    }

    public void setTamanho(TamanhoRaca tamanho) {
        this.tamanho = tamanho;
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public static class TamanhoRacaConverter implements PropertyConverter<TamanhoRaca,String> {

        @Override
        public TamanhoRaca convertToEntityProperty(String databaseValue) {
            return TamanhoRaca.valueOf(databaseValue);
        }

        @Override
        public String convertToDatabaseValue(TamanhoRaca entityProperty) {
            return entityProperty.toString();
        }
    }

    public static class ModHabConverter implements PropertyConverter<Map<Habilidade,Byte>, String>{

        Gson gson ;
        @Override
        public Map<Habilidade, Byte> convertToEntityProperty(String databaseValue) {
            gson = new Gson();
            Type type = new TypeToken<Map<Habilidade, Byte>>(){}.getType();
            return gson.fromJson(databaseValue,type);
        }

        @Override
        public String convertToDatabaseValue(Map<Habilidade, Byte> entityProperty) {
            gson = new Gson();
            return gson.toJson(entityProperty);
        }
    }

}
