package br.arpigi.fichaTormenta.model;

import android.os.Build;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Index;
import io.objectbox.annotation.IndexType;
import io.objectbox.annotation.Unique;
import io.objectbox.converter.PropertyConverter;

@Entity
public class Classe {
    @Id
    private Long id;

    @Index(type = IndexType.HASH)
    @Unique
    private String nome;

    private Byte bBA;

    @Convert(converter = TipoBBAConverter.class,dbType = String.class)
    private TipoBBA tipoBBA;

    private Byte nivelAtual;

    private String descricao;

    @Convert(converter = HabPorNvConverter.class,dbType = String.class)
    private Map<Byte, String> habPorNv;

    private Byte pvsPorNv;

    private Byte pvsNvUm;

    private Byte numDePeri;

    @Convert(converter = TalentosClassConverter.class,dbType = String.class)
    private List<Talento> talentosClass;

    public Classe(String nome, TipoBBA tipoBBA, Byte pvsPorNv, Byte pvsNvUm) {
        this.nome = nome;
        this.nivelAtual = 1;
        this.tipoBBA = tipoBBA;
        this.pvsNvUm = pvsNvUm;
        this.pvsPorNv = pvsPorNv;
        calcularBBA();
        gerardescricao();
    }

    public Classe() {
        this.nivelAtual = 0;
    }

    public Classe build(){
        this.nivelAtual = 1;
        calcularBBA();
        gerardescricao();
        return this;
    }



    public List<String> habAdquiridas() {
        List<String> habs = new ArrayList<>();
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
			habPorNv.forEach((nivel, hab) -> {
				if (nivel <= nivelAtual) {
					habs.add(hab);
				}
			});
		}else{
        for (Byte i = 1; i < nivelAtual; i++) {
            habs.add(this.habPorNv.get((byte) i));
		}

        }
        return habs;
    }

    public void elevarNv() {
        this.nivelAtual++;
        calcularBBA();
    }

    private void calcularBBA() {
        bBA = (byte) (this.nivelAtual * this.tipoBBA.getValor());
    }

    public Byte getPvsNvUm() {
        return pvsNvUm;
    }

    public void setPvsNvUm(Byte pvsNvUm) {
        this.pvsNvUm = pvsNvUm;
    }

    public TipoBBA getTipoBBA() {
        return tipoBBA;
    }

    public void setTipoBBA(TipoBBA tipoBBA) {
        this.tipoBBA = tipoBBA;
    }

    public Byte getPvsPorNv() {
        return pvsPorNv;
    }

    public void setPvsPorNv(Byte pvsPorNv) {
        this.pvsPorNv = pvsPorNv;
    }

    public Byte getNumDePeri() {
        return numDePeri;
    }

    public void setNumDePeri(Byte numDePeri) {
        this.numDePeri = numDePeri;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Byte getbBA() {
        return bBA;
    }

    public void setbBA(Byte bBA) {
        this.bBA = bBA;
    }

    public Byte getNivelAtual() {
        return nivelAtual;
    }

    public void setNivelAtual(Byte nivelAtual) {
        this.nivelAtual = nivelAtual;
        bBA = (byte) (this.nivelAtual * this.tipoBBA.getValor());
    }

    public Map<Byte, String> getHabPorNv() {
        return habPorNv;
    }

    public void setHabPorNv(Map<Byte, String> habPorNv) {
        this.habPorNv = habPorNv;
    }

    @Override
    public boolean equals(Object obj) {
        Classe classe = (Classe) obj;

        return this.nome.equals(classe.getNome());
    }

    private void gerardescricao(){
        StringBuffer s = new StringBuffer();
        s.append("Pontos de Vida:\nUm "+this.nome.toLowerCase()+" começa com "+this.pvsNvUm+" pontos de vida" +
                "(+ modifi cador de Constituição) e ganha "+this.pvsPorNv+" PV (+ mod. Con) por " +
                "nível seguinte.");
        this.descricao = s.toString();
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getBBA() {
        return this.bBA;
    }

    public void setBBA(Byte bBA) {
        this.bBA = bBA;
    }

    public List<Talento> getTalentosClass() {
        return talentosClass;
    }

    public void setTalentosClass(List<Talento> talentosClass) {
        this.talentosClass =  talentosClass;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public enum TipoBBA {
        BAIXO(0.5), MEDIO(0.75), ALTO(1.0);

        private Double valor;

        private TipoBBA(Double valor) {
            this.valor = valor;
        }

        public Double getValor() {
            return valor;
        }

    }

    public static class HabPorNvConverter implements PropertyConverter<Map<String,Byte>,String> {
        Gson gson;
        @Override
        public Map<String, Byte> convertToEntityProperty(String databaseValue) {
            gson = new Gson();
            Type type = new TypeToken<Map<String,Byte>>(){}.getType();
            return gson.fromJson(databaseValue,type);
        }

        @Override
        public String convertToDatabaseValue(Map<String, Byte> entityProperty) {
            gson = new Gson();
            return gson.toJson(entityProperty);
        }
    }

    public static class TalentosClassConverter implements PropertyConverter<List<Talento>,String> {
        Gson gson;
        @Override
        public List<Talento> convertToEntityProperty(String databaseValue) {
            gson = new Gson();
            Type type = new TypeToken<List<Talento>>(){}.getType();
            return gson.fromJson(databaseValue,type);
        }

        @Override
        public String convertToDatabaseValue(List<Talento> entityProperty) {
            gson = new Gson();
            return gson.toJson(entityProperty);
        }
    }
    public static class TipoBBAConverter implements PropertyConverter<TipoBBA,String>{

        @Override
        public TipoBBA convertToEntityProperty(String databaseValue) {
            return TipoBBA.valueOf(databaseValue);
        }

        @Override
        public String convertToDatabaseValue(TipoBBA entityProperty) {
            return entityProperty.toString();
        }
    }

}
