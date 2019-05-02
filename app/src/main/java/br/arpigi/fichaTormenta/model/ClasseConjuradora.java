package br.arpigi.fichaTormenta.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

import br.arpigi.fichaTormenta.enums.Habilidades;
import br.arpigi.fichaTormenta.util.HabilidadesConverter;
import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.converter.PropertyConverter;

@Entity
public class ClasseConjuradora extends Classe {
    //tipo magia = true para arcana, false para divina
    private Boolean tipoMagia;

    private Integer cDBase;

    @Convert(converter = HabilidadesConverter.class,dbType = String.class)
    private Habilidades habChave;

    private Byte pmsNvUm;

    private Byte pmsPorNv;

    private Byte numDeTruques;

    private Byte numDeMagiNvUm;

    private Byte magisPorNv;

    //	O primeiro "Byte"(Chave) ser� o n�vel de magia e o segundo
    //	"Byte"(Valor) em que nivel de classe poder� la�ar a o nivel de magia
    @Convert(converter = NvDeMagiPorNvDeClassConverter.class,dbType = String.class)
    private Map<Byte, Byte> nvDeMagiPorNvDeClass;

    public ClasseConjuradora(String nome, TipoBBA tipoBBA, Byte pvsPorNv, Byte pvsNvUm) {
        super(nome, tipoBBA, pvsPorNv, pvsNvUm);
    }

    public Boolean getTipoMagia() {
        return tipoMagia;
    }

    public void setTipoMagia(Boolean tipoMagia) {
        this.tipoMagia = tipoMagia;
    }

    public Integer getcDBase() {
        return cDBase;
    }

    public void setcDBase(Integer cDBase) {
        this.cDBase = cDBase;
    }

    public Habilidades getHabChave() {
        return habChave;
    }

    public void setHabChave(Habilidades habChave) {
        this.habChave = habChave;
    }

    public Byte getPmsNvUm() {
        return pmsNvUm;
    }

    public void setPmsNvUm(Byte pmsNvUm) {
        this.pmsNvUm = pmsNvUm;
    }

    public Byte getPmsPorNv() {
        return pmsPorNv;
    }

    public void setPmsPorNv(Byte pmsPorNv) {
        this.pmsPorNv = pmsPorNv;
    }

    public Byte getNumDeTruques() {
        return numDeTruques;
    }

    public void setNumDeTruques(Byte numDeTruques) {
        this.numDeTruques = numDeTruques;
    }

    public Byte getNumDeMagiNvUm() {
        return numDeMagiNvUm;
    }

    public void setNumDeMagiNvUm(Byte numDeMagiNvUm) {
        this.numDeMagiNvUm = numDeMagiNvUm;
    }

    public Byte getMagisPorNv() {
        return magisPorNv;
    }

    public void setMagisPorNv(Byte magisPorNv) {
        this.magisPorNv = magisPorNv;
    }

    public Map<Byte, Byte> getNvDeMagiPorNvDeClass() {
        return nvDeMagiPorNvDeClass;
    }

    public void setNvDeMagiPorNvDeClass(Map<Byte, Byte> nvDeMagiPorNvDeClass) {
        this.nvDeMagiPorNvDeClass = nvDeMagiPorNvDeClass;
    }

    public static class NvDeMagiPorNvDeClassConverter implements PropertyConverter<Map<Byte,Byte>,String> {
        Gson gson;
        @Override
        public Map<Byte, Byte> convertToEntityProperty(String databaseValue) {
            gson = new Gson();
            Type type = new TypeToken<Map<Byte,Byte>>(){}.getType();
            return gson.fromJson(databaseValue,type);
        }

        @Override
        public String convertToDatabaseValue(Map<Byte, Byte> entityProperty) {
            gson = new Gson();
            return gson.toJson(entityProperty);
        }
    }

}
