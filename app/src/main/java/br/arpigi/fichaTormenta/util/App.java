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

        Talento talento10 = new Talento("Acuidade com Arma",GrupoDeTalento.COMBATE,"Benefício: quando usa armas de corpo-a-corpo leves, você\n" +
                "pode usar seu modifi cador de Destreza em vez de Força em jogadas de ataque. Se estiver usando este talento e um escudo, aplique\n" +
                "a penalidade de armadura do escudo em jogadas de ataque."," Des 13");
        Talento talento11 = new Talento("Agarrar Aprimorado",GrupoDeTalento.COMBATE,"Benefício: você recebe +4 em jogadas de ataque para agarrar"," For 13, Ataque Desarmado Aprimorado");

        Talento talento12 = new Talento("Apanhar Objetos",GrupoDeTalento.COMBATE,"Benefício: quando usa o talento Desviar Objetos, você pode\n" +
                "apanhar a arma ao invés de apenas desviá-la. Armas de arremesso\n" +
                "podem ser atiradas de volta ao oponente como uma reação.","Des 15, Ataque Desarmado Aprimorado,\n" +
                "Desviar Objetos.");

        Talento talento13 = new Talento("Aparar\n",GrupoDeTalento.COMBATE,"Benefício:uma vez por rodada, você pode tentar aparar um\n" +
                "ataque que iria atingi-lo. Faça uma jogada de ataque. Se o resultado\n" +
                "da sua jogada for maior que a do oponente, você evita o ataque."," Des 15, Acuidade com Arma, Especialização\n" +
                "em Combate, bônus base de ataque +6.");

        Talento talento14 = new Talento("Aparência Inofensiva",GrupoDeTalento.COMBATE,"Benefício: a primeira criatura inteligente (Int 3 ou mais) que\n" +
                "atacar você em um combate deve fazer um teste de Intuição (CD\n" +
                "10 + metade do seu nível + seu modifi cador de Carisma). Se falhar,\n" +
                "perderá sua ação. Este talento só funciona uma vez por combate;\n" +
                "isto é, independente da criatura falhar ou não no teste, poderá\n" +
                "atacar você normalmente nas rodadas seguintes."," Car 13.");

        Talento talento15 = new Talento("Ataque Atordoante\n",GrupoDeTalento.COMBATE,"Benefício: declare que está usando este talento antes de fazer\n" +
                "um ataque desarmado. Se você acertar o ataque, além de sofrer o\n" +
                "dano normal, a vítima deve fazer um teste de Fortitude (CD 10 +\n" +
                "metade do seu nível + modifi cador de Sabedoria). Se falhar, fi ca\n" +
                "atordoada por uma rodada.\n" +
                "Você pode usar este talento um número de vezes por dia igual\n" +
                "a 1 + seu modifi cador de Sabedoria. Criaturas imunes a acertos\n" +
                "críticos não podem ser atordoadas."," Sab 13, Ataque Desarmado Aprimorado.");
        Talento talento16 = new Talento("Ataque com Escudo Aprimorado\n",GrupoDeTalento.COMBATE,"Benefício: quando você ataca com o escudo, mantém seu bônus na CA.","Usar Escudo.");
        Talento talento17 = new Talento("Ataque Desarmado Aprimorado",GrupoDeTalento.COMBATE,"Benefício: seus ataques desarmados causam 1d4 pontos de\n" +
                "dano, e podem causar dano letal ou não-letal (à sua escolha)");
        Talento talento18 = new Talento("Ataque Duplo",GrupoDeTalento.COMBATE,"Benefício: quando faz um ataque com a arma escolhida, você\n" +
                "pode fazer um ataque adicional na mesma ação padrão, mas sofre\n" +
                "penalidade de –5 em ambas as jogadas de ataque.",": Foco em Arma com a arma escolhida, bônus\n" +
                "base de ataque +6.");
        Talento talento19 = new Talento("Ataque em Movimento",GrupoDeTalento.COMBATE,"Benefício: quando estiver atacando corpo-a-corpo, você pode\n" +
                "se mover antes e depois do ataque, desde que a distância total percorrida não seja maior que seu deslocamento.\n" +
                "Você não pode usar este talento se estiver de armadura pesada.","Des 13, Esquiva, Mobilidade, bônus base de\n" +
                "ataque +4.");
        Talento talento20 = new Talento("Ataque Giratório",GrupoDeTalento.COMBATE,"Benefício: você pode fazer um ataque corpo-\n" +
                "-a-corpo contra cada oponente adjacente. Usar este\n" +
                "talento é uma ação completa.","Des 13, Int 13, Esquiva, Mobilidade, Ataque em Movimento, Especialização em\n" +
                "Combate, bônus base de ataque +4.");
        Talento talento21 = new Talento("Ataque Poderoso\n",GrupoDeTalento.COMBATE,"Benefício: declare que está usando este talento\n" +
                "antes de fazer um ataque corpo-a-corpo. Você sofre\n" +
                "uma penalidade de –2 na jogada de ataque, mas recebe +4 na jogada de dano.","For 13.");
        Talento talento22 = new Talento("Ataque Preciso\n",GrupoDeTalento.COMBATE,"Benefício: quando usa uma arma afetada pelo talento Acuidade com Arma, você\n" +
                "causa 1d6 pontos de dano adicional.","Des 15, Acui dade com\n" +
                "Arma, Especialização em Combate, bônus\n" +
                "base de ataque +11.");
        Talento talento23 = new Talento("Ataque Sagaz",GrupoDeTalento.COMBATE,"Benefício: quando usa uma arma afetada pelo talento Acuidade com Arma, você soma seu modifi cador de Inteligência (além\n" +
                "do modifi cador de Força) em jogadas de dano.","Pré-requisitos: Int 13, Acuidade com Arma, bônus base de\n" +
                "ataque +4.");
        Talento talento24 = new Talento("Atropelar Aprimorado",GrupoDeTalento.COMBATE,"Benefício: quando você realiza a manobra atropelar, o alvo\n" +
                "não pode escolher evitá-lo. Além disso, você recebe +4 em jogadas\n" +
                "de ataque para atropelar."," For 13, Ataque Poderoso.");
        Talento talento25 = new Talento("Bloqueio Ambidestro\n",GrupoDeTalento.COMBATE,"Benefício: quando estiver usando duas armas ou uma arma\n" +
                "dupla, você recebe +1 na classe de armadura."," Des 15, Combater com Duas Armas.");
        Talento talento26 = new Talento("Casca Grossa\n",GrupoDeTalento.COMBATE,"Benefício: você soma seu bônus de Constituição na CA. Este\n" +
                "bônus não é cumulativo com armaduras.","Con 13.");
        Talento talento27 = new Talento("Combate Montado\n",GrupoDeTalento.COMBATE,"Benefício: uma vez por rodada, você pode tentar desviar um\n" +
                "ataque que iria atingir sua montaria. Faça um teste de Cavalgar. Se\n" +
                "o resultado for maior que a jogada de ataque do oponente, você\n" +
                "evita o ataque."," treinado em Cavalgar.");
        Talento talento28 = new Talento("Combater com Duas Armas\n",GrupoDeTalento.COMBATE,"Benefício: se estiver usando uma arma de uma mão e uma\n" +
                "arma leve, ou duas armas leves, você pode fazer dois ataques com\n" +
                "a mesma ação padrão, um com cada uma. No entanto, você sofre\n" +
                "penalidade de –4 em ambas as jogadas de ataque.","Des 15.");
        Talento talento29 = new Talento("Combater Com\n" +
                "Duas Armas Aprimorado",GrupoDeTalento.COMBATE,"Benefício: usando o talento Combater com Duas Armas, sua\n" +
                "penalidade em jogadas de ataque diminui para –2.","Des 17, Combater com Duas Armas, bônus\n" +
                "base de ataque +6.");
        Talento talento30 = new Talento("Combater Com\n" +
                "Duas Armas Maior\n",GrupoDeTalento.COMBATE,"Benefício: usando o talento Combater com Duas Armas,\n" +
                "você não sofre nenhuma penalidade em jogadas de ataque."," Des 19, Combater Com Duas Armas, Combater Com Duas Armas Aprimorado, bônus base de ataque +11.");
        Talento talento31 = new Talento("Derrubar Aprimorado",GrupoDeTalento.COMBATE,"+4 em testes de derrubar.","Int 13, Especialização em Combate.");
        Talento talento32 = new Talento("Desarmar Aprimorado\n",GrupoDeTalento.COMBATE,"Benefício: +4 em testes de desarmar."," Int 13, Especialização em Combate.");
        Talento talento33 = new Talento("Desviar Objetos\n",GrupoDeTalento.COMBATE,"Benefício: você pode tentar desviar um ataque à distância\n" +
                "que iria atingi-lo. Faça um teste de Refl exos. Se o resultado do\n" +
                "seu teste for maior que a jogada de ataque do oponente, você\n" +
                "evita o ataque.\n" +
                "Você só pode usar este talento se estiver com uma mão livre.\n" +
                "Armas muito grandes (como pedras de catapulta) ou criadas por\n" +
                "magia não podem ser desviadas.","Des 13, Ataque Desarmado Aprimorado.");
        Talento talento34 = new Talento("Duro de Matar\n",GrupoDeTalento.COMBATE,"Benefício: quando você sofre dano que poderia levá-lo a 0\n" +
                "ou menos pontos de vida, você pode ignorar completamente esse\n" +
                "dano. Você pode usar este talento uma vez por dia.");
        Talento talento35 = new Talento("Empunhadura Poderosa\n",GrupoDeTalento.COMBATE,"Benefício: ao usar armas uma categoria de tamanho acima da\n" +
                "sua, sua penalidade cai para –2."," For 17.");
        Talento talento36 = new Talento("Empurrar Aprimorado\n",GrupoDeTalento.COMBATE,"Benefício: +4 em jogadas de ataque para empurrar.\n","Força 13, Ataque Poderoso.");
        Talento talento37 = new Talento("Especialização em Arma\n",GrupoDeTalento.COMBATE,"Benefício: usando a arma escolhida, você recebe +2 em jogadas de dano"," Foco em Arma com a arma escolhida, guerreiro 4º nível.");
        Talento talento38 = new Talento("Especialização em\n" +
                "Arma Aprimorada",GrupoDeTalento.COMBATE," seu bônus no dano pelo talento Especialização em\n" +
                "Arma aumenta para +4."," Foco em Arma, Foco em Arma Aprimorado,\n" +
                "Especialização em Arma com a arma escolhida, guerreiro 12º nível.");
        Talento talento39 = new Talento("Especialização em Armadura\n",GrupoDeTalento.COMBATE,"Benefício: quando usando uma armadura do tipo escolhido,\n" +
                "você recebe redução de dano 2.","Foco em Armadura do tipo escolhido, guerreiro 8º nível.");
        Talento talento40 = new Talento("Especialização em Combate\n",GrupoDeTalento.COMBATE,"Benefício: declare que está usando este talento antes de fazer\n" +
                "um ataque corpo-a-corpo. Você sofre –2 na jogada de ataque, mas\n" +
                "recebe +4 na classe de armadura até o próximo turno."," Int 13.\n");
        Talento talento41 = new Talento("Esquiva",GrupoDeTalento.COMBATE,"Benefício: você recebe CA+1.\n"," Des 13.");
        Talento talento42 = new Talento("Fintar Aprimorado\n",GrupoDeTalento.COMBATE,"Benefício: você pode realizar um teste de Enganação para fi ntar em combate usando uma ação de movimento."," Int 13, Especialização em Combate.");
        Talento talento43 = new Talento("Flerte Estratégico\n",GrupoDeTalento.COMBATE,"Benefício: faça uma fi nta em combate contra um inimigo\n" +
                "que possa se sentir fi sicamente atraído por você. Se for bem-sucedido, sua vítima fi ca embaraçada e sofre penalidade de –2 em jogadas\n" +
                "e testes até o fi m do combate."," Car 13, Fintar Aprimorado.");

        Talento talento44 = new Talento("Foco em Arma Aprimorado\n",GrupoDeTalento.COMBATE,"Benefício: o bônus que você recebe pelo talento Foco em\n" +
                "Arma aumenta para +2."," Foco em Arma com a arma escolhida, guerreiro 8º nível.");
        Talento talento45 = new Talento("Foco em Armadura",GrupoDeTalento.COMBATE,"Benefício: quando usando uma armadura do tipo escolhido,\n" +
                "você aumenta seu bônus de armadura em +1 e diminui sua penalidade de armadura em –1."," saber usar o tipo de armadura escolhido.");
        Talento talento46 = new Talento("Golpe com Duas Mãos\n",GrupoDeTalento.COMBATE,"Benefício: quando usando uma arma de corpo-a-corpo com\n" +
                "as duas mãos, você soma o dobro de seu modifi cador de Força às\n" +
                "jogadas de dano. Este talento não pode ser usado com armas leves.\n"," For 15, Ataque Poderoso.");
        Talento talento47 = new Talento("Granadeiro",GrupoDeTalento.COMBATE,"Benefício: você recebe +2 em jogadas de ataque e dano com\n" +
                "quaisquer armas que permitem um teste de Refl exos para reduzir\n" +
                "seu efeito, como fogo alquímico e granadas."," treinado em Ofício (alquimia).");
        Talento talento48 = new Talento("Insulto Sagaz\n",GrupoDeTalento.COMBATE,"Benefício: faça uma fi nta em combate. Se for bem-sucedido,\n" +
                "seu oponente fi ca enfurecido e sofre uma penalidade de –2 na CA\n" +
                "até o fi m do combate.",": Car 13, Fintar Aprimorado.");
        Talento talento49 = new Talento("Investida Implacável\n",GrupoDeTalento.COMBATE,"Benefício: quando está montado e faz uma investida, você\n" +
                "causa dano dobrado com uma arma comum, ou triplicado com\n" +
                "uma lança.","treinado em Cavalgar, Combate Montado,\n" +
                "Investida Montada");
        Talento talento50 = new Talento("Investida Montada\n",GrupoDeTalento.COMBATE,"Benefício: quando está montado e faz uma investida, você\n" +
                "pode continuar se movendo depois do ataque. Você deve continuar\n" +
                "se movendo em linha reta, e seu movimento total na rodada não\n" +
                "pode ser superior ao dobro do deslocamento da montaria."," treinado em Cavalgar, Combate Montado.");
        Talento talento51 = new Talento("Lutar às Cegas\n",GrupoDeTalento.COMBATE,"Benefício: sempre que você erra um ataque devido a camufl agem, pode rolar mais uma vez a chance de acertar. Além disso, você\n" +
                "não fi ca desprevenido contra inimigos que não possa ver.");
        Talento talento52 = new Talento("Mestre em Arma\n",GrupoDeTalento.COMBATE,"Benefício: usando a arma escolhida, você recebe +1 em jogadas de ataque e dano, e sua margem de ameaça aumenta em 1.\n" +
                "Além disso, uma vez por dia, você pode rolar outra vez uma jogada\n" +
                "de ataque que tenha recém realizado. Você deve aceitar a segunda\n" +
                "rolagem, mesmo que seja pior que a primeira.","Especialização em Arma, Especialização em\n" +
                "Arma Aprimorada, Foco em Arma, Foco em Arma Aprimorado\n" +
                "(todos com a arma escolhida), guerreiro 16º nível.");
        Talento talento53 = new Talento("Mira Apurada\n",GrupoDeTalento.COMBATE,"Benefício: você pode gastar uma ação de movimento para\n" +
                "mirar um alvo. Se fi zer isso, recebe +1 em jogadas de ataque à\n" +
                "distância realizadas contra ele na mesma rodada.",": Sab 13, Tiro Certeiro, Tiro Longo");
        Talento talento54 = new Talento("Mira Mortal\n",GrupoDeTalento.COMBATE,"Benefício: sua margem de ameaça com armas de projéteis\n" +
                "aumenta em 1. Por exemplo, a margem de ameaça da pistola é 19-\n" +
                "20; para um personagem com este talento, será 18-20.","Des 17, Sab 13, Mira Apurada, Tiro Certeiro,\n" +
                "Tiro Longo, bônus base de ataque +11.");
        Talento talento55 = new Talento("Mobilidade",GrupoDeTalento.COMBATE,"Benefício: você recebe +2 na CA sempre que usa uma ação de\n" +
                "movimento para deslocar-se."," Des 13, Esquiva.\n");
        Talento talento56 = new Talento("Na Mosca\n",GrupoDeTalento.COMBATE,"Benefício: você soma seu modifi cador de Destreza em jogadas de dano com armas de ataque à distância.","Des 13, Tiro Certeiro, Tiro Preciso");
        Talento talento57 = new Talento("Panache",GrupoDeTalento.COMBATE,"Benefício: faça uma fi nta em combate. Se for bem-sucedido,\n" +
                "seu oponente fi ca espantado com a manobra, e no próximo turno\n" +
                "só pode realizar uma ação padrão.","Car 13, Fintar Aprimorado.");
        Talento talento58 = new Talento("Perito em Arma\n",GrupoDeTalento.COMBATE,"Benefício: graças a uma extrema habilidade com a arma, que\n" +
                "funciona como uma verdadeira extensão de seu corpo, você pode\n" +
                "substituir um teste de qualquer perícia por uma jogada de ataque\n" +
                "com a arma escolhida. Você pode, por exemplo, usar uma espada para\n" +
                "destrancar uma fechadura (Ladinagem), como suporte para subir em\n" +
                "algo (Atletismo), como apoio para uma cambalhota (Acrobacia), para\n" +
                "fazer manobras impressionantes (Atuação) e assim por diante.",": Des 13, Int 13, Acuidade com Arma, Foco\n" +
                "em Arma com a arma escolhida.");
        Talento talento59 = new Talento("Pisotear",GrupoDeTalento.COMBATE,"Benefício: quando está montado e realiza a manobra atropelar, o alvo não pode escolher evitá-lo. Além disso, se a montaria\n" +
                "derrubar um oponente, pode fazer um ataque contra esse oponente\n" +
                "como uma ação livre (recebendo o bônus padrão de +4 em jogadas\n" +
                "de ataque contra oponentes caídos)."," treinado em Cavalgar, Combate Montado.");
        Talento talento60 = new Talento("Rapidez de Recarga\n",GrupoDeTalento.COMBATE,"Benefício: a ação necessária para recarregar a arma\n" +
                "escolhida diminui em uma\n" +
                "categoria — ação completa\n" +
                "vira padrão, padrão vira de\n" +
                "movimento, e de movimento vira livre. Por exemplo,\n" +
                "recarregar um mosquete\n" +
                "normalmente é uma ação padrão, mas para um personagem com\n" +
                "este talento é uma ação de movimento.","saber usar a arma escolhida.");
        Talento talento61 = new Talento("Reflexos de Combate\n",GrupoDeTalento.COMBATE,"Benefício: se estiver adjacente a um oponente desprevenido,\n" +
                "você pode fazer um ataque corpo-a-corpo contra ele como uma\n" +
                "ação livre.","Des 13.");
        Talento talento62 = new Talento("Saque Rápido\n",GrupoDeTalento.COMBATE,"Benefício: você pode sacar ou guardar uma arma como uma\n" +
                "ação livre");
        Talento talento63 = new Talento("Separar Aprimorado\n",GrupoDeTalento.COMBATE,"Benefício: você recebe +4 em jogadas de ataque para separar.\n" +
                "Além disso, você causa dano dobrado contra objetos.","For 13, Ataque Poderoso.");
        Talento talento64 = new Talento("Tiro Certeiro\n",GrupoDeTalento.COMBATE,"Benefício: você recebe +1 em jogadas de ataque e dano com\n" +
                "armas de ataque à distância contra alvos que estejam a até 9m.");
        Talento talento65 = new Talento("Tiro em Movimento\n",GrupoDeTalento.COMBATE,"Benefício: quando estiver atacando à distância, você pode se\n" +
                "mover antes e depois do ataque, desde que a distância total percorrida não seja maior que seu deslocamento.\n" +
                "Você não pode usar este talento se estiver de armadura pesada","Des 13, Esquiva, Mobilidade, Tiro Certeiro,\n" +
                "bônus base de ataque +4.");
        Talento talento66 = new Talento("Tiro Longo\n",GrupoDeTalento.COMBATE,"Benefício: o incremento de distância de qualquer arma que você utiliza é dobrado.", "Tiro Certeiro");
        Talento talento67 = new Talento("Tiro Montado\n",GrupoDeTalento.COMBATE,"Benefício: sua penalidade para ataques à distância quando sua montaria se movimenta é reduzida\n" +
                "para –2.","treinado em Cavalgar,\n" +
                "Combate Montado.");
        Talento talento68 = new Talento("Tiro Múltiplo\n",GrupoDeTalento.COMBATE,"Benefício: usando uma ação padrão e\n" +
                "uma arma de projéteis, você pode fazer dois\n" +
                "ataques contra um único oponente a até 9m.\n" +
                "Ambos usam a mesma jogada (com penalidade de –4) e causam dano normalmente.","Des 17, Tiro Certeiro,\n" +
                "Tiro Rápido, bônus base de ataque +6.");
        Talento talento69 = new Talento("Tiro Preciso\n",GrupoDeTalento.COMBATE,"Benefício: você pode fazer ataques à distância contra oponentes envolvidos em combate corpo-a-corpo sem sofrer a penalidade\n" +
                "de –4 na jogada de ataque."," Tiro Certeiro");
        Talento talento70 = new Talento("Tiro Preciso Aprimorado\n",GrupoDeTalento.COMBATE,"Benefício: seus ataques à distância ignoram cobertura e\n" +
                "camufl agem (exceto cobertura ou camufl agem totais).\n" +
                "Além disso, quando ataca um alvo envolvido na manobra agarrar, você acerta automaticamente o alvo\n" +
                "que escolheu.","Des 19, Tiro Certeiro, Tiro Preciso, bônus\n" +
                "base de ataque +11.");
        Talento talento71 = new Talento("Tiro Rápido\n",GrupoDeTalento.COMBATE,"Benefício: usando uma\n" +
                "arma de ataque à distância,\n" +
                "você pode fazer um ataque adicional. Se fi zer isso, sofre uma\n" +
                "penalidade de –2 em todas as jogadas de ataque. Usar este talento é\n" +
                "uma ação completa.","Des 13,\n" +
                "Tiro Certeiro.");
        Talento talento72 = new Talento("Torcida",GrupoDeTalento.COMBATE,"Benefício: você recebe +1 em jogadas de\n" +
                "ataque, CA e testes de resistência quando tem\n" +
                "a torcida a seu favor, durante uma luta ou outro\n" +
                "tipo de disputa. Entenda-se por “torcida” qualquer\n" +
                "número de pessoas ou criaturas inteligentes (mesmo\n" +
                "que seja apenas uma!) que não está realizando nenhuma\n" +
                "outra ação além de ver a luta. Você só recebe este benefício quando a maioria das pessoas presentes na\n" +
                "cena está gritando seu nome ou torcendo\n" +
                "por sua vitória.","Car 13");
        Talento talento73 = new Talento("Trespassar",GrupoDeTalento.COMBATE,"Benefício: quando você derruba um inimigo com um ataque\n" +
                "corpo-a-corpo (reduzindo seus PV para 0 ou menos), pode realizar\n" +
                "um ataque adicional contra outra criatura adjacente.\n" +
                "O ataque adicional usa os mesmos bônus de ataque e dano do\n" +
                "primeiro, mas os dados devem ser rolados novamente. Você pode\n" +
                "usar este talento uma vez por rodada.","For 13, Ataque Poderoso.");
        Talento talento74 = new Talento("Trespassar Aprimorado\n",GrupoDeTalento.COMBATE,"Benefício: você pode usar o talento Trespassar quantas vezes\n" +
                "quiser na mesma rodada.","For 13, Ataque Poderoso, Trespassar, bônus\n" +
                "base de ataque +4.");
        Talento talento75 = new Talento("Usar Armas Simples\n",GrupoDeTalento.COMBATE,"Benefício: você sabe usar armas simples.\n");
        Talento talento76 = new Talento("Usar Armas Marciais\n",GrupoDeTalento.COMBATE,"Benefício: você sabe usar armas marciais.\n","Usar Armas Simples.");
        Talento talento77 = new Talento("Usar Arma Exótica\n",GrupoDeTalento.COMBATE,"Benefício: você sabe usar a arma escolhida.\n","Usar Armas Simples");
        Talento talento78 = new Talento("Usar Armaduras Leves\n",GrupoDeTalento.COMBATE,"Benefício: você sabe usar armadura acolchoada, corselete de\n" +
                "couro, couro batido, camisa de cota de malha e outras armaduras leves.");
        Talento talento79 = new Talento("Usar Armaduras Médias",GrupoDeTalento.COMBATE,"Benefício: você sabe usar cota de escamas, cota de malha,\n" +
                "couraça, gibão de peles e outras armaduras médias.","Usar Armaduras Leves");
        Talento talento80 = new Talento("Usar Armaduras Pesadas\n",GrupoDeTalento.COMBATE,"Benefício: você sabe usar loriga segmentada, meia armadura,\n" +
                "armadura completa e outras armaduras pesadas.","Usar Armaduras (leves, médias)");
        Talento talento81 = new Talento("Usar Escudos\n",GrupoDeTalento.COMBATE,"Benefício: você sabe usar escudos leves e pesados.\n");
        Talento talento82 = new Talento("Usar Venenos\n",GrupoDeTalento.COMBATE,"Benefício: você pode aplicar veneno em armas sem risco de se\n" +
                "envenenar acidentalmente.","treinado em Ofício (alquimia), tendência\n" +
                "não Bondosa.");
        Talento talento83 = new Talento("Vitalidade",GrupoDeTalento.COMBATE,"Benefício: você recebe 1 ponto de vida adicional por nível\n" +
                "de personagem. Quando sobe de nível, os PV que recebe por este\n" +
                "talento aumentam de acordo.");
        Talento talento84 = new Talento("Afinidade com Animais",GrupoDeTalento.PERICIA,"Benefício: você pode rolar outra vez um teste de Adestrar\n" +
                "Animais que tenha recém realizado. Você deve aceitar a segunda\n" +
                "rolagem, mesmo que seja pior que a primeira.");
        Talento talento85 = new Talento("Ágil",GrupoDeTalento.PERICIA,"Benefício: você pode usar seu modifi cador de Destreza em\n" +
                "vez de Força em testes de Atletismo."," Des 15.");
        Talento talento86 = new Talento("Aptidão Mágica\n",GrupoDeTalento.PERICIA,"Benefício: você pode rolar outra vez um teste de Identifi car\n" +
                "Magia que tenha recém realizado. Você deve aceitar a segunda rolagem, mesmo que seja pior que a primeira.");
        Talento talento87 = new Talento("Artista",GrupoDeTalento.PERICIA,"Benefício: você pode rolar outra vez um teste de Atuação que\n" +
                "tenha recém realizado. Você deve aceitar a segunda rolagem, mesmo que seja pior que a primeira.");
        Talento talento88 = new Talento("Atlético",GrupoDeTalento.PERICIA,"Benefício: você pode rolar outra vez um teste de Atletismo\n" +
                "que tenha recém realizado. Você deve aceitar a segunda rolagem,\n" +
                "mesmo que seja pior que a primeira.");
        Talento talento89 = new Talento("Autossuficiente",GrupoDeTalento.PERICIA,"Benefício: você não sofre a penalidade de –5 para fazer testes\n" +
                "de Cura em si mesmo, e recebe +4 nos testes de Sobrevivência se\n" +
                "estiver sozinho (sem nenhum aliado a até 18m).");
        Talento talento90 = new Talento("Criar Obra-Prima\n",GrupoDeTalento.PERICIA,"Benefício: você pode construir armas, armaduras e kits de\n" +
                "ferramentas de qualidade obra-prima. Uma arma obra-prima fornece +1 em jogadas de ataque; uma armadura obra-prima tem sua\n" +
                "penalidade de armadura reduzida em 1; e um kit de ferramentas\n" +
                "obra-prima fornece +2 nos testes da perícia apropriada."," treinado em Ofício, Foco em Perícia (Ofício).");
        Talento talento91 = new Talento("Dedos Ágeis\n",GrupoDeTalento.PERICIA,"Benefício: você pode rolar outra vez um teste de Ladinagem\n" +
                "que tenha recém realizado. Você deve aceitar a segunda rolagem,\n" +
                "mesmo que seja pior que a primeira.");
        Talento talento92 = new Talento("Diligente",GrupoDeTalento.PERICIA,"Benefício: você pode gastar uma ação de movimento para se\n" +
                "concentrar na tarefa à frente. Se fi zer isso, recebe +2 nos testes de\n" +
                "perícia realizados até a próxima rodada.");
        Talento talento93 = new Talento("Foco em Perícia\n",GrupoDeTalento.PERICIA,"Benefício: você recebe +4 em testes da perícia escolhida.\n"," treinado na perícia escolhida.");
        Talento talento94 = new Talento("Fraudulento",GrupoDeTalento.PERICIA,"Benefício: você pode rolar outra vez um teste de Enganação\n" +
                "que tenha recém realizado. Você deve aceitar a segunda rolagem,\n" +
                "mesmo que seja pior que a primeira.");
        Talento talento95 = new Talento("Impostor",GrupoDeTalento.PERICIA,"Benefício: graças a seu extremo charme, magnetismo pessoal\n" +
                "e super confi ança, você consegue\n" +
                "convencer as pessoas (e também\n" +
                "a si próprio!) de que tem certas\n" +
                "habilidades ou conhecimentos,\n" +
                "quando na verdade não tem.\n" +
                "Você pode substituir um\n" +
                "teste de qualquer perícia por um\n" +
                "teste de Enganação. Você pode\n" +
                "usar este talento um número de\n" +
                "vezes por dia igual a seu bônus\n" +
                "de Carisma."," Car 13, Foco em Perícia (Enganação)");
        Talento talento96 = new Talento("Iniciativa\n" +
                "Aprimorada",GrupoDeTalento.PERICIA,"Benefício: você pode rolar\n" +
                "outra vez um teste de Iniciativa que tenha recém realizado.\n" +
                "Você deve aceitar a segunda rolagem, mesmo que seja pior que\n" +
                "a primeira.");
        Talento talento97 = new Talento("Investigador",GrupoDeTalento.PERICIA,"Benefício: você pode somar seu bônus de Inteligência a testes\n" +
                "de Obter Informação e testes de Percepção para procurar.","Int 13");
        Talento talento98 = new Talento("Negociador",GrupoDeTalento.PERICIA,"Benefício: quando você chega a uma comunidade, faça um\n" +
                "teste de Ofício (CD 20). Se tiver sucesso, você pode comprar itens\n" +
                "nesta comunidade por 75% do preço padrão (arredondado para\n" +
                "baixo). Por exemplo, você pode comprar uma armadura completa\n" +
                "(que normalmente custa 1.500 TO) por 1.125 TO.\n" +
                "Se falhar, você pode tentar novamente em um mês (ou quando visitar outra comunidade).","treinado em Ofício");
        Talento talento99 = new Talento("Persuasivo",GrupoDeTalento.PERICIA,"Benefício: você pode rolar outra vez um teste de Diplomacia que tenha recém realizado.\n" +
                "Você deve aceitar a segunda\n" +
                "rolagem, mesmo que seja pior\n" +
                "que a primeira.");
        Talento talento100 = new Talento("Prontidão",GrupoDeTalento.PERICIA,"Benefício: você pode\n" +
                "rolar outra vez um teste de\n" +
                "Percepção que tenha recém\n" +
                "realizado. Você deve aceitar a\n" +
                "segunda rolagem, mesmo que\n" +
                "seja pior que a primeira.");
        Talento talento101 = new Talento("Rastrear",GrupoDeTalento.PERICIA,"Benefício: você pode\n" +
                "fazer testes de Sobrevivência\n" +
                "para encontrar rastros. A difi -\n" +
                "culdade varia de acordo com o\n" +
                "solo — CD 10 para solo macio\n" +
                "(neve, lama), 15 para solo padrão (grama, terra) e 20 para solo duro (rocha ou\n" +
                "piso de interiores).\n" +
                "Você ganha +1 para cada três criaturas no grupo sendo seguido. Você sofre uma penalidade de –1 para cada dia\n" +
                "desde a criação dos rastros e uma penalidade de –5 em visibilidade\n" +
                "precária (noite, chuva, neblina). Você precisa fazer um teste para\n" +
                "encontrar os rastros e mais um para cada dia de perseguição.\n" +
                "Se falhar você pode tentar novamente gastando mais um dia\n" +
                "(mas lembre-se de que a CD aumenta a cada dia)."," treinado em\n" +
                "Sobrevivência");
        Talento talento102 = new Talento("Senso da Natureza\n",GrupoDeTalento.PERICIA,"Benefício: você pode rolar outra vez um teste de Sobrevivência que tenha recém realizado. Você deve aceitar a segunda rolagem, mesmo que seja pior que a primeira");
        Talento talento103 = new Talento("Sorrateiro",GrupoDeTalento.PERICIA,"Benefício: você pode rolar outra vez um teste de Furtividade\n" +
                "que tenha recém realizado. Você deve aceitar a segunda rolagem,\n" +
                "mesmo que seja pior que a primeira.");
        Talento talento104 = new Talento("Treino em Perícia\n",GrupoDeTalento.PERICIA,"Benefício: você se torna treinado na perícia escolhida.\n");




        talentoBox.put(talento,talento1,talento0,talento01,talento2,talento3,talento4,talento5,talento6,talento7,talento8,talento9,talento10,talento11,talento12,talento13,talento14,talento15,talento16,talento17,talento18,talento19,talento20,talento21,talento22,talento23,talento24,talento25,talento26,talento27,talento28,talento29,talento30,talento31,talento32,talento33,talento34,talento35,talento36,talento37,talento38,talento39,talento40,talento41,talento42,talento43,talento44,talento45,talento46,talento47,talento48,talento49,talento50,talento51,talento52,talento53,talento54,talento55,talento56,talento57,talento58,talento59,talento60,talento61,talento62,talento63,talento64,talento65,talento66,talento67,talento68,talento69,talento70,talento71,talento72,talento73,talento74,talento75,talento76,talento77,talento78,talento79,talento80,talento81,talento82,talento83,talento84,talento85,talento86,talento87,talento88,talento89,talento90,talento91,talento92,talento93,talento94,talento95,talento96,talento97,talento98,talento99,talento100,talento101,talento102,talento103,talento104);
    }
}
