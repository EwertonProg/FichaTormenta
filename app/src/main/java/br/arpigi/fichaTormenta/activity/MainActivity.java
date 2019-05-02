package br.arpigi.fichaTormenta.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.arpigi.fichaTormenta.dao.PersonagemDao;
import br.arpigi.fichaTormenta.enums.Habilidades;
import br.arpigi.fichaTormenta.enums.Pericias;
import br.arpigi.fichaTormenta.enums.TamanhoRaca;
import br.arpigi.fichaTormenta.model.Classe;
import br.arpigi.fichaTormenta.model.Habilidade;
import br.arpigi.fichaTormenta.model.Pericia;
import br.arpigi.fichaTormenta.model.Personagem;
import br.arpigi.fichaTormenta.model.Raca;

public class MainActivity extends AppCompatActivity {

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i = new Intent(this, ListaPersonagens.class);
        ArrayList<Habilidade> habilidades = new ArrayList<Habilidade>();

        habilidades.add(new Habilidade(Habilidades.FORCA, (byte) 2));
        habilidades.add(new Habilidade(Habilidades.DESTREZA, (byte) 7));
        habilidades.add(new Habilidade(Habilidades.CONSTITUICAO, (byte) 13));
        habilidades.add(new Habilidade(Habilidades.INTELIGENCIA, (byte) 16));
        habilidades.add(new Habilidade(Habilidades.SABEDORIA, (byte) 18));
        habilidades.add(new Habilidade(Habilidades.CARISMA, (byte) 19));

        Map<Habilidade, Byte> modHabilidades = new HashMap<>();
        modHabilidades.put(new Habilidade(Habilidades.CONSTITUICAO), (byte) 2);
        modHabilidades.put(new Habilidade(Habilidades.CARISMA), (byte) -2);
        modHabilidades.put(new Habilidade(Habilidades.DESTREZA), (byte) 4);

        Raca raca = new Raca("Goblin", modHabilidades, (byte) 9, TamanhoRaca.PEQUENA);
        Classe classe = new Classe("Barbaro", Classe.TipoBBA.ALTO, (byte) 6, (byte) 24);
        Classe classe1 = new Classe("Guerreiro", Classe.TipoBBA.ALTO, (byte) 5, (byte) 20);

        Personagem p1 = new Personagem(raca, "papatubos", habilidades, classe);

        for (Integer i = 0; i < 10; i++) {
            if (p1.addXp(1000)) {
                p1.uparNv(classe1, Habilidades.DESTREZA);
            }
        }
        p1.adicionarPericiasTreinadas(new Pericia(Pericias.ADESTRAR_ANIMAIS), new Pericia(Pericias.ATLETISMO),
                new Pericia(Pericias.CAVALGAR), new Pericia(Pericias.INICIATIVA), new Pericia(Pericias.INTIMIDACAO),
                new Pericia(Pericias.OFICIO, Pericias.Especificacao.METALURGIA, true), new Pericia(Pericias.SOBREVIVENCIA));


        PersonagemDao personagemDao = new PersonagemDao();
        personagemDao.add(p1);

    }

    public void irListarFichas(View view) {
        startActivity(i);
    }
}
