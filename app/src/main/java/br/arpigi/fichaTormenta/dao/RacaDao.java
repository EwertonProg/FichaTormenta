package br.arpigi.fichaTormenta.dao;

import java.util.ArrayList;
import java.util.List;

import br.arpigi.fichaTormenta.model.Raca;

public class RacaDao {
    private static List<Raca> racas = new ArrayList<>();

    public void add(Raca raca) {
        racas.add(raca);
    }

    public List<Raca> getRacas() {
        return racas;
    }
}
