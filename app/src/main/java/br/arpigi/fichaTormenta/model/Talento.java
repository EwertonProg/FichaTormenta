package br.arpigi.fichaTormenta.model;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import br.arpigi.fichaTormenta.enums.GrupoDeTalento;
import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Index;
import io.objectbox.annotation.IndexType;
import io.objectbox.annotation.Unique;
import io.objectbox.converter.PropertyConverter;

@Entity
public class Talento {

    @Id
    private Long id;

    @Index(type = IndexType.HASH)
    @Unique
    private String nome;

    @Convert(converter = GrupoDeTalentoConverter.class, dbType = String.class)
    private GrupoDeTalento Grupo;

    private String descricao;

    @Convert(converter = PreRequisitoConverter.class, dbType = String.class)
    private List<String> prerequisitos;


    public Talento() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GrupoDeTalento getGrupo() {
        return this.Grupo;
    }

    public void setGrupo(GrupoDeTalento Grupo) {
        this.Grupo = Grupo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<String> getPrerequisitos() {
        return this.prerequisitos;
    }

    public void setPrerequisitos(List<String> prerequisitos) {
        this.prerequisitos = prerequisitos;
    }

    public static class GrupoDeTalentoConverter implements PropertyConverter<GrupoDeTalento,String>{

        @Override
        public GrupoDeTalento convertToEntityProperty(String databaseValue) {
            return GrupoDeTalento.valueOf(databaseValue);
        }

        @Override
        public String convertToDatabaseValue(GrupoDeTalento entityProperty) {
            return entityProperty.toString();
        }
    }

    public static class PreRequisitoConverter implements PropertyConverter<List<String>,String>{
        Gson gson;
        @Override
        public List<String> convertToEntityProperty(String databaseValue) {
            gson = new Gson();
            Type type = new TypeToken<List<String>>(){}.getType();
            return gson.fromJson(databaseValue,type);
        }

        @Override
        public String convertToDatabaseValue(List<String> entityProperty) {
            gson = new Gson();
            return gson.toJson(entityProperty);
        }
    }

}
