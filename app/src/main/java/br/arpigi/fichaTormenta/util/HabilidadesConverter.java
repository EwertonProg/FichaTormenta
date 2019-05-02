package br.arpigi.fichaTormenta.util;

import br.arpigi.fichaTormenta.enums.Habilidades;
import io.objectbox.converter.PropertyConverter;

public class HabilidadesConverter implements PropertyConverter<Habilidades,String> {
    @Override
    public Habilidades convertToEntityProperty(String databaseValue) {
        return Habilidades.valueOf(databaseValue);
    }

    @Override
    public String convertToDatabaseValue(Habilidades entityProperty) {
        return entityProperty.toString();
    }
}
