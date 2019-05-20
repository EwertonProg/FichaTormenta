package br.arpigi.fichaTormenta.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

import br.arpigi.fichaTormenta.enums.Habilidades;
import br.arpigi.fichaTormenta.enums.Pericias;
import br.arpigi.fichaTormenta.model.Classe;
import br.arpigi.fichaTormenta.model.Classe_;
import br.arpigi.fichaTormenta.model.Habilidade;
import br.arpigi.fichaTormenta.model.Pericia;
import br.arpigi.fichaTormenta.model.Personagem;
import br.arpigi.fichaTormenta.model.Raca;
import br.arpigi.fichaTormenta.model.Raca_;
import br.arpigi.fichaTormenta.util.Banco;
import io.objectbox.Box;

public class MainActivity extends AppCompatActivity {

    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Raca raca;
        Box<Raca> racaBox = Banco.get().boxFor(Raca.class);
        Box<Personagem> personagemBox = Banco.get().boxFor(Personagem.class);
        Box<Classe> classeBox = Banco.get().boxFor(Classe.class);
        personagemBox.removeAll();
        ArrayList<Habilidade> habilidades = new ArrayList<>();

        habilidades.add(new Habilidade(Habilidades.FORCA, (byte) 2));
        habilidades.add(new Habilidade(Habilidades.DESTREZA, (byte) 7));
        habilidades.add(new Habilidade(Habilidades.CONSTITUICAO, (byte) 13));
        habilidades.add(new Habilidade(Habilidades.INTELIGENCIA, (byte) 16));
        habilidades.add(new Habilidade(Habilidades.SABEDORIA, (byte) 18));
        habilidades.add(new Habilidade(Habilidades.CARISMA, (byte) 19));

        Classe c = classeBox.query().equal(Classe_.nome,"Ladino").build().findFirst().build();
        raca = racaBox.query().equal(Raca_.nome,"Goblin").build().findFirst();

        Personagem p1 = new Personagem(raca,"Teste",habilidades,c);

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
