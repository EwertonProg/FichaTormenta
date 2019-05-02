package br.arpigi.fichaTormenta.dao;

import java.util.ArrayList;

import br.arpigi.fichaTormenta.model.Personagem;

public class PersonagemDao {
    private static ArrayList<Personagem> personagens = new ArrayList<>();

    public void add(Personagem personagem) {
        personagens.add(personagem);
    }

    public ArrayList<Personagem> getPersonagens() {
        return personagens;
    }
}
