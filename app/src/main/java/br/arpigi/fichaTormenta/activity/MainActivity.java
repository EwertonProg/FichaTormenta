package br.arpigi.fichaTormenta.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.arpigi.fichaTormenta.enums.Habilidades;
import br.arpigi.fichaTormenta.enums.Pericias;
import br.arpigi.fichaTormenta.enums.TamanhoRaca;
import br.arpigi.fichaTormenta.model.Classe;
import br.arpigi.fichaTormenta.model.Habilidade;
import br.arpigi.fichaTormenta.model.Pericia;
import br.arpigi.fichaTormenta.model.Personagem;
import br.arpigi.fichaTormenta.model.Raca;
import br.arpigi.fichaTormenta.model.Raca_;
import br.arpigi.fichaTormenta.util.Banco;
import io.objectbox.Box;

public class MainActivity extends AppCompatActivity {

    private Intent i;
    private Box<Raca> racaBox;
    private Box<Personagem> personagemBox;
    private Box<Classe> classeBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Raca raca;
        racaBox = Banco.get().boxFor(Raca.class);
        personagemBox = Banco.get().boxFor(Personagem.class);
        classeBox = Banco.get().boxFor(Classe.class);
        Map<Habilidade, Byte> modHabilidades = new HashMap<>();
        modHabilidades.put(new Habilidade(Habilidades.CONSTITUICAO), (byte) 2);
        modHabilidades.put(new Habilidade(Habilidades.CARISMA), (byte) -2);
        modHabilidades.put(new Habilidade(Habilidades.DESTREZA), (byte) 4);
        racaBox.removeAll();
        classeBox.removeAll();
        personagemBox.removeAll();
        raca = new Raca("Goblin",modHabilidades,(byte)9, TamanhoRaca.PEQUENA);
        racaBox.put(raca);

        raca = racaBox.query().equal(Raca_.nome,"Goblin").build().findFirst();

        Classe classe = new Classe("Barbaro", Classe.TipoBBA.ALTO, (byte) 6, (byte) 24);
        Classe classe1 = new Classe("Guerreiro", Classe.TipoBBA.ALTO, (byte) 5, (byte) 20);


        ArrayList<Habilidade> habilidades = new ArrayList<>();

        habilidades.add(new Habilidade(Habilidades.FORCA, (byte) 2));
        habilidades.add(new Habilidade(Habilidades.DESTREZA, (byte) 7));
        habilidades.add(new Habilidade(Habilidades.CONSTITUICAO, (byte) 13));
        habilidades.add(new Habilidade(Habilidades.INTELIGENCIA, (byte) 16));
        habilidades.add(new Habilidade(Habilidades.SABEDORIA, (byte) 18));
        habilidades.add(new Habilidade(Habilidades.CARISMA, (byte) 19));

        Personagem p1 = new Personagem(raca,"",habilidades,classe);


        for (Integer i = 0; i < 10; i++) {
            if (p1.addXp(1000)) {
                p1.uparNv(classe1, Habilidades.DESTREZA);
            }
        }

        p1.adicionarPericiasTreinadas(new Pericia(Pericias.ADESTRAR_ANIMAIS), new Pericia(Pericias.ATLETISMO),
                new Pericia(Pericias.CAVALGAR), new Pericia(Pericias.INICIATIVA), new Pericia(Pericias.INTIMIDACAO),
                new Pericia(Pericias.OFICIO, Pericias.Especificacao.METALURGIA, true), new Pericia(Pericias.SOBREVIVENCIA));
        personagemBox.put(p1);

    }

    public void irListarFichas(View view) {
        i = new Intent(this, ListaPersonagensActivity.class);
        startActivity(i);
    }

    public void irCriarFicha(View view){
        i = new Intent(this, CriacaoPersonagemActivity.class);
        startActivity(i);}
}
