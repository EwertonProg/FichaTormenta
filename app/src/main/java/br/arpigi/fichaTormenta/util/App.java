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

        Talento talento1 = new Talento("Acelerar Habilidade", GrupoDeTalento.DESTINO,"Benefício: Você pode usar a habilidade especial escolhida como uma ação livre, três vezes por dia (ou menos, caso a habilidade original só possa ser usada uma ou duas vezes por dia).\n" +
                "Você só pode usar esse talento uma vez por rodada. Habilidade com tempo de execução maior que uma ação completa não são afetadas por esse talento."
                ,"habilidade especial que exija uma ação de movimento ou padrão para ser usada.");

        Talento talento2 = new Talento("Adaptação Cultural", GrupoDeTalento.DESTINO,"Benefício: você recebe um bônus de +2 em testes de Conhecimento (Geografia) e pode escolher talentos nativos de qualquer reino.");

        Talento talento3 = new Talento("Foco em Arma", GrupoDeTalento.COMBATE,"Benefício: +1 em jogadas de ataque com a arma escolhida."
                ,"Saber usar a arma escolhida","bônus base de ataque +1");

        Talento talento4 = new Talento("Adaptabilidade", GrupoDeTalento.MAGIA,"Benefício: você pode lançar uma magia que não preparou. Você deve perder magias preparadas cujo custo some pelo menos o dobro do custo da magia que quer lançar. Por exemplo, para lançar uma magia de 3 PM, você deve perder magias preparadas que somem pelo menos 6 PM."
                ,"Classe mago");

        Talento talento5 = new Talento("Canto Monástico", GrupoDeTalento.MAGIA,"Benefício: quando você lança uma magia, pode gastar uma ação de movimento para entoar um canto litúrgico. Se fizer isso, a CD para resistir à magia aumenta em +1. Você pode usar este talento um número de vezes por dia igual ao seu bônus de Carisma +1. Obviamente, você não pode lançar magias desta forma se não puder fazer sons (por exemplo, sob efeito de Magia Silenciosa)."
                ,"Treinado em Atuação (música)","Capacidade de lançar magias divinas");

        Talento talento6 = new Talento("Amigo dos Animais", GrupoDeTalento.PODER_CONCEDIDO,"Benefício: você recebe a habilidade de classe empatia com a natureza, como se fosse um druida de nível igual a seu nível de personagem. Caso já possua esta habilidade, recebe +4 em seus testes."
                ,"devoto de Allihanna");

        Talento talento7 = new Talento("Alma do Dragão", GrupoDeTalento.PODER_CONCEDIDO,"você adquire o modelo meio-dragão, recebendo todos os seus poderes, exceto aqueles que já possui devido a seus pré-requisitos."
                ,"devoto de Kallyadranoch","Asas do Dragão","Escamas do Dragão","Garras do Dragão","Sopro do Dragão","personagem de 17º nível");

        Talento talento8 = new Talento("Anatomia Insana Aprimorada", GrupoDeTalento.TORMENTA,"Benefício: você tem 75% de chance de ignorar um acerto crítico ou ataque furtivo."
                ,"Anatomia Insana");

        Talento talento9 = new Talento("Anatomia Insana Total", GrupoDeTalento.TORMENTA,"Benefício: você é imune a acertos críticos e ataques furtivos."
                ,"Anatomia Insana","Anatomia Insana Aprimorada");

        Talento talento0 = new Talento("Acrobacia Audaz", GrupoDeTalento.PERICIA,"Benefício: você pode atravessar terrenos difíceis sem sofrer redução em seu deslocamento. Você pode realizar investidas mesmo nessas condições.\n"+
                "Normal: um personagem em terreno difícil tem seu deslocamento reduzido à metade, e não pode realizar investidas."
                ,"treinado em Acrobacia");

        Talento talento01 = new Talento("Acrobático", GrupoDeTalento.PERICIA,"Benefício: você pode rolar outra vez um teste de Acrobacia que tenha recém realizado. Você deve aceitar a segunda rolagem, mesmo que seja pior do que a primeira.");

        talentoBox.put(talento,talento1,talento0,talento01,talento2,talento3,talento4,talento5,talento6,talento7,talento8,talento9);
    }
}
