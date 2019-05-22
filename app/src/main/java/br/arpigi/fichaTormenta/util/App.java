package br.arpigi.fichaTormenta.util;

import android.app.Application;

import java.util.HashMap;
import java.util.Map;

import br.arpigi.fichaTormenta.activity.R;
import br.arpigi.fichaTormenta.enums.GrupoDeTalento;
import br.arpigi.fichaTormenta.enums.Habilidades;
import br.arpigi.fichaTormenta.enums.TamanhoRaca;
import br.arpigi.fichaTormenta.model.Classe;
import br.arpigi.fichaTormenta.model.Habilidade;
import br.arpigi.fichaTormenta.model.Raca;
import br.arpigi.fichaTormenta.model.Talento;
import io.objectbox.Box;

public class App extends Application {
    Box<Raca> racaBox;
    Box<Classe> classeBox;
    Box<Talento> talentoBox;

    @Override
    public void onCreate() {
        super.onCreate();
        Banco.init(this);
        racaBox = Banco.get().boxFor(Raca.class);
        classeBox = Banco.get().boxFor(Classe.class);
        talentoBox = Banco.get().boxFor(Talento.class);
        racaBox.removeAll();
        classeBox.removeAll();
        talentoBox.removeAll();
        Raca raca;
        Map<Habilidade, Byte> modHabilidades = new HashMap<>();
        modHabilidades.put(new Habilidade(Habilidades.CONSTITUICAO), (byte) 2);
        modHabilidades.put(new Habilidade(Habilidades.CARISMA), (byte) -2);
        modHabilidades.put(new Habilidade(Habilidades.DESTREZA), (byte) 4);
        raca = new Raca(getString(R.string.goblin),modHabilidades,(byte)9, TamanhoRaca.PEQUENA);

        Map<Habilidade, Byte> modHabilidades1 = new HashMap<>();
        modHabilidades1.put(new Habilidade(Habilidades.CARISMA), (byte) 2);
        modHabilidades1.put(new Habilidade(Habilidades.SABEDORIA), (byte) 4);
        Raca raca1 = new Raca("Aggelus",modHabilidades1,(byte)9, TamanhoRaca.MEDIA);

        Map<Habilidade, Byte> modHabilidades2 = new HashMap<>();
        modHabilidades2.put(new Habilidade(Habilidades.SABEDORIA), (byte) 2);
        modHabilidades2.put(new Habilidade(Habilidades.DESTREZA), (byte) -2);
        modHabilidades2.put(new Habilidade(Habilidades.CONSTITUICAO), (byte) 4);
        Raca raca2 = new Raca(getString(R.string.anao),modHabilidades2,(byte)6, TamanhoRaca.MEDIA);

        Map<Habilidade, Byte> modHabilidades3 = new HashMap<>();
        modHabilidades3.put(new Habilidade(Habilidades.INTELIGENCIA), (byte) 2);
        modHabilidades3.put(new Habilidade(Habilidades.DESTREZA), (byte) 4);
        modHabilidades3.put(new Habilidade(Habilidades.CONSTITUICAO), (byte) -2);
        Raca raca3 = new Raca(getString(R.string.elfo),modHabilidades3,(byte)9, TamanhoRaca.MEDIA);

        Map<Habilidade, Byte> modHabilidades4 = new HashMap<>();
        modHabilidades4.put(new Habilidade(Habilidades.FORCA), (byte) -2);
        modHabilidades4.put(new Habilidade(Habilidades.CARISMA), (byte) 2);
        modHabilidades4.put(new Habilidade(Habilidades.DESTREZA), (byte) 4);
        Raca raca4 = new Raca(getString(R.string.halfling),modHabilidades4,(byte)6, TamanhoRaca.PEQUENA);

        Map<Habilidade, Byte> modHabilidades5 = new HashMap<>();
        modHabilidades5.put(new Habilidade(Habilidades.FORCA), (byte) 4);
        modHabilidades5.put(new Habilidade(Habilidades.CARISMA), (byte) -4);
        modHabilidades5.put(new Habilidade(Habilidades.CONSTITUICAO), (byte) 2);
        Raca raca5 = new Raca(getString(R.string.minotauro),modHabilidades5,(byte)9, TamanhoRaca.MEDIA);

        Map<Habilidade, Byte> modHabilidades6 = new HashMap<>();
        modHabilidades6.put(new Habilidade(Habilidades.INTELIGENCIA), (byte) 2);
        modHabilidades6.put(new Habilidade(Habilidades.CARISMA), (byte) 4);
        modHabilidades6.put(new Habilidade(Habilidades.SABEDORIA), (byte) -2);
        Raca raca6 = new Raca(getString(R.string.qareen),modHabilidades6,(byte)9, TamanhoRaca.MEDIA);

        Map<Habilidade, Byte> modHabilidades7 = new HashMap<>();
        modHabilidades7.put(new Habilidade(Habilidades.CONSTITUICAO), (byte) 2);
        modHabilidades7.put(new Habilidade(Habilidades.FORCA), (byte) -2);
        modHabilidades7.put(new Habilidade(Habilidades.INTELIGENCIA), (byte) 4);
        Raca raca7 = new Raca(getString(R.string.gnomo),modHabilidades7,(byte)6, TamanhoRaca.PEQUENA);

        racaBox.put(raca,raca1,raca2,raca3,raca4,raca5,raca6,raca7);

        Classe classe = new Classe("Barbaro", Classe.TipoBBA.ALTO, (byte) 6, (byte) 24);
        Classe classe1 = new Classe("Guerreiro", Classe.TipoBBA.ALTO, (byte) 5, (byte) 20);
        Classe classe2 = new Classe("Bardo", Classe.TipoBBA.MEDIO, (byte) 3, (byte) 12);
        Classe classe3 = new Classe("Clerigo", Classe.TipoBBA.MEDIO, (byte) 4, (byte) 16);
        Classe classe4 = new Classe("Druida", Classe.TipoBBA.MEDIO, (byte) 4, (byte) 16);
        Classe classe5 = new Classe("Feiticeiro", Classe.TipoBBA.BAIXO, (byte) 2, (byte) 8);
        Classe classe6 = new Classe("Ladino", Classe.TipoBBA.MEDIO, (byte) 3, (byte) 12);
        Classe classe7 = new Classe("Mago", Classe.TipoBBA.BAIXO, (byte) 2, (byte) 8);
        Classe classe8 = new Classe("Monge", Classe.TipoBBA.ALTO, (byte) 4, (byte) 16);
        Classe classe9 = new Classe("Paladino", Classe.TipoBBA.ALTO, (byte) 5, (byte) 20);
        Classe classe10 = new Classe("Ranger", Classe.TipoBBA.ALTO, (byte) 4, (byte) 16);
        Classe classe11 = new Classe("Samurai", Classe.TipoBBA.ALTO, (byte) 5, (byte) 20);
        Classe classe12 = new Classe("Swashbuckler", Classe.TipoBBA.ALTO, (byte) 4, (byte) 16);

        classeBox.put(classe,classe1,classe2,classe3,classe4,classe5,classe6,classe7,classe8,classe9,classe10,classe11,classe12);

        Talento talento = new Talento("Acerto Crítico Aprimorado", GrupoDeTalento.COMBATE,"Benefício: sua margem de ameaça com a arma escolhida é dobrada. Este efeito não se acumula com qualquer outro que dobre a margem de ameaça, e é sempre o primeiro a ser aplicado."
                ,"Foco em Arma com a arma escolhida","bônus base de ataque +8");

        Talento talento1 = new Talento("Foco em Arma", GrupoDeTalento.COMBATE,"Benefício: +1 em jogadas de ataque com a arma escolhida."
                ,"Saber usar a arma escolhida","bônus base de ataque +1");

        talentoBox.put(talento,talento1);
    }
}
