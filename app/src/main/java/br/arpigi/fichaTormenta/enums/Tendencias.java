package br.arpigi.fichaTormenta.enums;

import java.util.ArrayList;

public enum Tendencias {
    LB("Leal/Bondoso"), NB("Neutro/Bondoso"), CB("Caótico/Bondoso"),
    LN("Leal/Neutro"), N("Neutro"), CN("Caótico/Neutro"),
    LM("Leal/Maligno"), NM("Neutro/Maligno"), CM("Caótico/Maligno");

    private String nome;

    private Tendencias(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static ArrayList<String> stringValues(){
        ArrayList<String> stringValues = new ArrayList<>();
        for(Tendencias tendencias:Tendencias.values()){
            stringValues.add(tendencias.nome.trim());
        }
        return stringValues;
    }

    public static Tendencias getTendendias(String nome){
        for(Tendencias tendencias: Tendencias.values()){
            if(tendencias.getNome().equals(nome)){
                return tendencias;
            }
        }
        return null;
    }

}
