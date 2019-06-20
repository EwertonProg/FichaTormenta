package br.arpigi.fichaTormenta.model;


import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.arpigi.fichaTormenta.enums.Habilidades;
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

    //para identificar se a raca tem modificadores de habilidade variaveis
    private Boolean habVariavel = false;

    //quantas habilidades podem ser aumentadas, represetada pelo size do array
    //e quanto cada uma pode ser adicionada reprensentada pelo valor em si em cada campo
    //Ex: um array {2,4} significa que pode ser selecionada 2 habilidades,
    //na primeira será adicionado +2 e na segunda será adicionado +4
    @Convert(converter = qtdHabVariavelConverter.class, dbType = String.class)
    private List<Byte> qtdHabVariavel;

    //habilidades que podem ser aumentadas
    @Convert(converter = HabilidadeConverter.class,dbType = String.class)
    private List<Habilidades> habVariavelAumento;

    public Raca(String nome, Map<Habilidade, Byte> modHab, Byte deslocamento, TamanhoRaca tamanho) {
        this.nome = nome;
        this.modHab = modHab;
        this.deslocamento = deslocamento;
        this.tamanho = tamanho;
        this.qtdHabVariavel = new ArrayList<>();
        this.habVariavelAumento = new ArrayList<>();
    }

    public Raca(String nome, Map<Habilidade, Byte> modHab, Byte deslocamento, TamanhoRaca tamanho, List<Byte> qtdHabVariavel,  Habilidades... habVariavelAumento) {
        this.nome = nome;
        this.modHab = modHab;
        this.deslocamento = deslocamento;
        this.tamanho = tamanho;
        this.habVariavel = true;
        this.habVariavelAumento = Arrays.asList(habVariavelAumento);
        this.qtdHabVariavel = qtdHabVariavel;
    }

    public Raca() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<Habilidade, Byte> getModHab() {
        return this.modHab;
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

    public Boolean getHabVariavel() {
        return habVariavel;
    }

    public void setHabVariavel(Boolean habVariavel) {
        this.habVariavel = habVariavel;
    }

    public List<Byte> getQtdHabVariavel() {
        return qtdHabVariavel;
    }

    public void setQtdHabVariavel(ArrayList<Byte> qtdHabVariavel) {
        this.qtdHabVariavel = qtdHabVariavel;
    }

    public List<Habilidades> getHabVariavelAumento() {
        return habVariavelAumento;
    }

    public void setHabVariavelAumento(ArrayList<Habilidades> habVariavelAumento) {
        this.habVariavelAumento = habVariavelAumento;
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
            Log.d("fichaIN",databaseValue);
            gson = new Gson();
            Type type = new TypeToken<Map<String, Byte>>(){}.getType();
            Map<String,Byte> modhabString = gson.fromJson(databaseValue,type);
            Map<Habilidade, Byte> modhabRet = new HashMap<>();
            for (Map.Entry<String,Byte> modhab:modhabString.entrySet()) {
                modhabRet.put(new Habilidade(Habilidades.valueOf(modhab.getKey())),modhab.getValue());
            }
            return modhabRet;
        }

        @Override
        public String convertToDatabaseValue(Map<Habilidade, Byte> entityProperty) {
            gson = new Gson();
            Map<String,Byte> modhabString = new HashMap<>();
            for (Map.Entry<Habilidade,Byte> modhab:entityProperty.entrySet()) {
                modhabString.put(modhab.getKey().getNome().toString(),modhab.getValue());
            }

            String s = gson.toJson(modhabString);
            return s;
        }
    }

    public static class qtdHabVariavelConverter implements PropertyConverter<List<Integer>,String>{
        Gson gson;
        @Override
        public List<Integer> convertToEntityProperty(String databaseValue) {
            gson = new Gson();
            Type type = new TypeToken<List<Integer>>(){}.getType();
            return gson.fromJson(databaseValue,type);
        }

        @Override
        public String convertToDatabaseValue(List<Integer> entityProperty) {
            gson = new Gson();
            return gson.toJson(entityProperty);
        }
    }

    public static class HabilidadeConverter implements PropertyConverter<List<Habilidades>,String> {
        Gson gson;
        @Override
        public List<Habilidades> convertToEntityProperty(String databaseValue) {
            gson = new Gson();
            Type type = new TypeToken<List<String>>(){}.getType();
            ArrayList<String> habilidadesString = gson.fromJson(databaseValue,type);
            ArrayList<Habilidades> habilidade = new ArrayList<>();
            if(habilidadesString!=null) {
                for (String habilidadeString : habilidadesString) {
                    habilidade.add(Habilidades.valueOf(habilidadeString));
                }
            }
            return habilidade;
        }

        @Override
        public String convertToDatabaseValue(List<Habilidades> entityProperty) {
            gson = new Gson();
            ArrayList<String> habilidadesString = new ArrayList<>();
            for(Habilidades habilidade : entityProperty){
                habilidadesString.add(habilidade.toString());
            }
            return gson.toJson(habilidadesString);
        }
    }

}
