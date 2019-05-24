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
        raca = new Raca(getString(R.string.goblin), modHabilidades, (byte) 9, TamanhoRaca.PEQUENA);

        Map<Habilidade, Byte> modHabilidades1 = new HashMap<>();
        modHabilidades1.put(new Habilidade(Habilidades.CARISMA), (byte) 2);
        modHabilidades1.put(new Habilidade(Habilidades.SABEDORIA), (byte) 4);
        Raca raca1 = new Raca("Aggelus", modHabilidades1, (byte) 9, TamanhoRaca.MEDIA);

        Map<Habilidade, Byte> modHabilidades2 = new HashMap<>();
        modHabilidades2.put(new Habilidade(Habilidades.SABEDORIA), (byte) 2);
        modHabilidades2.put(new Habilidade(Habilidades.DESTREZA), (byte) -2);
        modHabilidades2.put(new Habilidade(Habilidades.CONSTITUICAO), (byte) 4);
        Raca raca2 = new Raca(getString(R.string.anao), modHabilidades2, (byte) 6, TamanhoRaca.MEDIA);

        Map<Habilidade, Byte> modHabilidades3 = new HashMap<>();
        modHabilidades3.put(new Habilidade(Habilidades.INTELIGENCIA), (byte) 2);
        modHabilidades3.put(new Habilidade(Habilidades.DESTREZA), (byte) 4);
        modHabilidades3.put(new Habilidade(Habilidades.CONSTITUICAO), (byte) -2);
        Raca raca3 = new Raca(getString(R.string.elfo), modHabilidades3, (byte) 9, TamanhoRaca.MEDIA);

        Map<Habilidade, Byte> modHabilidades4 = new HashMap<>();
        modHabilidades4.put(new Habilidade(Habilidades.FORCA), (byte) -2);
        modHabilidades4.put(new Habilidade(Habilidades.CARISMA), (byte) 2);
        modHabilidades4.put(new Habilidade(Habilidades.DESTREZA), (byte) 4);
        Raca raca4 = new Raca(getString(R.string.halfling), modHabilidades4, (byte) 6, TamanhoRaca.PEQUENA);

        Map<Habilidade, Byte> modHabilidades5 = new HashMap<>();
        modHabilidades5.put(new Habilidade(Habilidades.FORCA), (byte) 4);
        modHabilidades5.put(new Habilidade(Habilidades.CARISMA), (byte) -4);
        modHabilidades5.put(new Habilidade(Habilidades.CONSTITUICAO), (byte) 2);
        Raca raca5 = new Raca(getString(R.string.minotauro), modHabilidades5, (byte) 9, TamanhoRaca.MEDIA);

        Map<Habilidade, Byte> modHabilidades6 = new HashMap<>();
        modHabilidades6.put(new Habilidade(Habilidades.INTELIGENCIA), (byte) 2);
        modHabilidades6.put(new Habilidade(Habilidades.CARISMA), (byte) 4);
        modHabilidades6.put(new Habilidade(Habilidades.SABEDORIA), (byte) -2);
        Raca raca6 = new Raca(getString(R.string.qareen), modHabilidades6, (byte) 9, TamanhoRaca.MEDIA);

        Map<Habilidade, Byte> modHabilidades7 = new HashMap<>();
        modHabilidades7.put(new Habilidade(Habilidades.CONSTITUICAO), (byte) 2);
        modHabilidades7.put(new Habilidade(Habilidades.FORCA), (byte) -2);
        modHabilidades7.put(new Habilidade(Habilidades.INTELIGENCIA), (byte) 4);
        Raca raca7 = new Raca(getString(R.string.gnomo), modHabilidades7, (byte) 6, TamanhoRaca.PEQUENA);

        racaBox.put(raca, raca1, raca2, raca3, raca4, raca5, raca6, raca7);

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

        classeBox.put(classe, classe1, classe2, classe3, classe4, classe5, classe6, classe7, classe8, classe9, classe10, classe11, classe12);

        Talento talento = new Talento("Acerto Crítico Aprimorado", GrupoDeTalento.COMBATE, "Benefício: sua margem de ameaça com a arma escolhida é dobrada. Este efeito não se acumula com qualquer outro que dobre a margem de ameaça, e é sempre o primeiro a ser aplicado."
                , "Foco em Arma com a arma escolhida", "bônus base de ataque +8");


        Talento talento1 = new Talento("Acelerar Habilidade", GrupoDeTalento.DESTINO, "Benefício: Você pode usar a habilidade especial escolhida como uma ação livre, três vezes por dia (ou menos, caso a habilidade original só possa ser usada uma ou duas vezes por dia).\n" +
                "Você só pode usar esse talento uma vez por rodada. Habilidade com tempo de execução maior que uma ação completa não são afetadas por esse talento."
                , "habilidade especial que exija uma ação de movimento ou padrão para ser usada.");

        Talento talento2 = new Talento("Adaptação Cultural", GrupoDeTalento.DESTINO, "Benefício: você recebe um bônus de +2 em testes de Conhecimento (Geografia) e pode escolher talentos nativos de qualquer reino.");

        Talento talento3 = new Talento("Foco em Arma", GrupoDeTalento.COMBATE, "Benefício: +1 em jogadas de ataque com a arma escolhida."
                , "Saber usar a arma escolhida", "bônus base de ataque +1");

        Talento talento8 = new Talento("Anatomia Insana Aprimorada", GrupoDeTalento.TORMENTA, "Benefício: você tem 75% de chance de ignorar um acerto crítico ou ataque furtivo."
                , "Anatomia Insana");

        Talento talento9 = new Talento("Anatomia Insana Total", GrupoDeTalento.TORMENTA, "Benefício: você é imune a acertos críticos e ataques furtivos."
                , "Anatomia Insana", "Anatomia Insana Aprimorada");

        Talento talento0 = new Talento("Acrobacia Audaz", GrupoDeTalento.PERICIA, "Benefício: você pode atravessar terrenos difíceis sem sofrer redução em seu deslocamento. Você pode realizar investidas mesmo nessas condições.\n" +
                "Normal: um personagem em terreno difícil tem seu deslocamento reduzido à metade, e não pode realizar investidas."
                , "treinado em Acrobacia");

        Talento talento01 = new Talento("Acrobático", GrupoDeTalento.PERICIA, "Benefício: você pode rolar outra vez um teste de Acrobacia que tenha recém realizado. Você deve aceitar a segunda rolagem, mesmo que seja pior do que a primeira.");

        Talento talento10 = new Talento("Acuidade com Arma", GrupoDeTalento.COMBATE, "Benefício: quando usa armas de corpo-a-corpo leves, você\n" +
                "pode usar seu modifi cador de Destreza em vez de Força em jogadas de ataque. Se estiver usando este talento e um escudo, aplique\n" +
                "a penalidade de armadura do escudo em jogadas de ataque.", " Des 13");
        Talento talento11 = new Talento("Agarrar Aprimorado", GrupoDeTalento.COMBATE, "Benefício: você recebe +4 em jogadas de ataque para agarrar", " For 13, Ataque Desarmado Aprimorado");

        Talento talento12 = new Talento("Apanhar Objetos", GrupoDeTalento.COMBATE, "Benefício: quando usa o talento Desviar Objetos, você pode\n" +
                "apanhar a arma ao invés de apenas desviá-la. Armas de arremesso\n" +
                "podem ser atiradas de volta ao oponente como uma reação.", "Des 15, Ataque Desarmado Aprimorado,\n" +
                "Desviar Objetos.");

        Talento talento13 = new Talento("Aparar\n", GrupoDeTalento.COMBATE, "Benefício:uma vez por rodada, você pode tentar aparar um\n" +
                "ataque que iria atingi-lo. Faça uma jogada de ataque. Se o resultado\n" +
                "da sua jogada for maior que a do oponente, você evita o ataque.", " Des 15, Acuidade com Arma, Especialização\n" +
                "em Combate, bônus base de ataque +6.");

        Talento talento14 = new Talento("Aparência Inofensiva", GrupoDeTalento.COMBATE, "Benefício: a primeira criatura inteligente (Int 3 ou mais) que\n" +
                "atacar você em um combate deve fazer um teste de Intuição (CD\n" +
                "10 + metade do seu nível + seu modifi cador de Carisma). Se falhar,\n" +
                "perderá sua ação. Este talento só funciona uma vez por combate;\n" +
                "isto é, independente da criatura falhar ou não no teste, poderá\n" +
                "atacar você normalmente nas rodadas seguintes.", " Car 13.");

        Talento talento15 = new Talento("Ataque Atordoante\n", GrupoDeTalento.COMBATE, "Benefício: declare que está usando este talento antes de fazer\n" +
                "um ataque desarmado. Se você acertar o ataque, além de sofrer o\n" +
                "dano normal, a vítima deve fazer um teste de Fortitude (CD 10 +\n" +
                "metade do seu nível + modifi cador de Sabedoria). Se falhar, fi ca\n" +
                "atordoada por uma rodada.\n" +
                "Você pode usar este talento um número de vezes por dia igual\n" +
                "a 1 + seu modifi cador de Sabedoria. Criaturas imunes a acertos\n" +
                "críticos não podem ser atordoadas.", " Sab 13, Ataque Desarmado Aprimorado.");
        Talento talento16 = new Talento("Ataque com Escudo Aprimorado\n", GrupoDeTalento.COMBATE, "Benefício: quando você ataca com o escudo, mantém seu bônus na CA.", "Usar Escudo.");
        Talento talento17 = new Talento("Ataque Desarmado Aprimorado", GrupoDeTalento.COMBATE, "Benefício: seus ataques desarmados causam 1d4 pontos de\n" +
                "dano, e podem causar dano letal ou não-letal (à sua escolha)");
        Talento talento18 = new Talento("Ataque Duplo", GrupoDeTalento.COMBATE, "Benefício: quando faz um ataque com a arma escolhida, você\n" +
                "pode fazer um ataque adicional na mesma ação padrão, mas sofre\n" +
                "penalidade de –5 em ambas as jogadas de ataque.", ": Foco em Arma com a arma escolhida, bônus\n" +
                "base de ataque +6.");
        Talento talento19 = new Talento("Ataque em Movimento", GrupoDeTalento.COMBATE, "Benefício: quando estiver atacando corpo-a-corpo, você pode\n" +
                "se mover antes e depois do ataque, desde que a distância total percorrida não seja maior que seu deslocamento.\n" +
                "Você não pode usar este talento se estiver de armadura pesada.", "Des 13, Esquiva, Mobilidade, bônus base de\n" +
                "ataque +4.");
        Talento talento20 = new Talento("Ataque Giratório", GrupoDeTalento.COMBATE, "Benefício: você pode fazer um ataque corpo-\n" +
                "-a-corpo contra cada oponente adjacente. Usar este\n" +
                "talento é uma ação completa.", "Des 13, Int 13, Esquiva, Mobilidade, Ataque em Movimento, Especialização em\n" +
                "Combate, bônus base de ataque +4.");
        Talento talento21 = new Talento("Ataque Poderoso\n", GrupoDeTalento.COMBATE, "Benefício: declare que está usando este talento\n" +
                "antes de fazer um ataque corpo-a-corpo. Você sofre\n" +
                "uma penalidade de –2 na jogada de ataque, mas recebe +4 na jogada de dano.", "For 13.");
        Talento talento22 = new Talento("Ataque Preciso\n", GrupoDeTalento.COMBATE, "Benefício: quando usa uma arma afetada pelo talento Acuidade com Arma, você\n" +
                "causa 1d6 pontos de dano adicional.", "Des 15, Acui dade com\n" +
                "Arma, Especialização em Combate, bônus\n" +
                "base de ataque +11.");
        Talento talento23 = new Talento("Ataque Sagaz", GrupoDeTalento.COMBATE, "Benefício: quando usa uma arma afetada pelo talento Acuidade com Arma, você soma seu modifi cador de Inteligência (além\n" +
                "do modifi cador de Força) em jogadas de dano.", "Pré-requisitos: Int 13, Acuidade com Arma, bônus base de\n" +
                "ataque +4.");
        Talento talento24 = new Talento("Atropelar Aprimorado", GrupoDeTalento.COMBATE, "Benefício: quando você realiza a manobra atropelar, o alvo\n" +
                "não pode escolher evitá-lo. Além disso, você recebe +4 em jogadas\n" +
                "de ataque para atropelar.", " For 13, Ataque Poderoso.");
        Talento talento25 = new Talento("Bloqueio Ambidestro\n", GrupoDeTalento.COMBATE, "Benefício: quando estiver usando duas armas ou uma arma\n" +
                "dupla, você recebe +1 na classe de armadura.", " Des 15, Combater com Duas Armas.");
        Talento talento26 = new Talento("Casca Grossa\n", GrupoDeTalento.COMBATE, "Benefício: você soma seu bônus de Constituição na CA. Este\n" +
                "bônus não é cumulativo com armaduras.", "Con 13.");
        Talento talento27 = new Talento("Combate Montado\n", GrupoDeTalento.COMBATE, "Benefício: uma vez por rodada, você pode tentar desviar um\n" +
                "ataque que iria atingir sua montaria. Faça um teste de Cavalgar. Se\n" +
                "o resultado for maior que a jogada de ataque do oponente, você\n" +
                "evita o ataque.", " treinado em Cavalgar.");
        Talento talento28 = new Talento("Combater com Duas Armas\n", GrupoDeTalento.COMBATE, "Benefício: se estiver usando uma arma de uma mão e uma\n" +
                "arma leve, ou duas armas leves, você pode fazer dois ataques com\n" +
                "a mesma ação padrão, um com cada uma. No entanto, você sofre\n" +
                "penalidade de –4 em ambas as jogadas de ataque.", "Des 15.");
        Talento talento29 = new Talento("Combater Com\n" +
                "Duas Armas Aprimorado", GrupoDeTalento.COMBATE, "Benefício: usando o talento Combater com Duas Armas, sua\n" +
                "penalidade em jogadas de ataque diminui para –2.", "Des 17, Combater com Duas Armas, bônus\n" +
                "base de ataque +6.");
        Talento talento30 = new Talento("Combater Com\n" +
                "Duas Armas Maior\n", GrupoDeTalento.COMBATE, "Benefício: usando o talento Combater com Duas Armas,\n" +
                "você não sofre nenhuma penalidade em jogadas de ataque.", " Des 19, Combater Com Duas Armas, Combater Com Duas Armas Aprimorado, bônus base de ataque +11.");
        Talento talento31 = new Talento("Derrubar Aprimorado", GrupoDeTalento.COMBATE, "+4 em testes de derrubar.", "Int 13, Especialização em Combate.");
        Talento talento32 = new Talento("Desarmar Aprimorado\n", GrupoDeTalento.COMBATE, "Benefício: +4 em testes de desarmar.", " Int 13, Especialização em Combate.");
        Talento talento33 = new Talento("Desviar Objetos\n", GrupoDeTalento.COMBATE, "Benefício: você pode tentar desviar um ataque à distância\n" +
                "que iria atingi-lo. Faça um teste de Refl exos. Se o resultado do\n" +
                "seu teste for maior que a jogada de ataque do oponente, você\n" +
                "evita o ataque.\n" +
                "Você só pode usar este talento se estiver com uma mão livre.\n" +
                "Armas muito grandes (como pedras de catapulta) ou criadas por\n" +
                "magia não podem ser desviadas.", "Des 13, Ataque Desarmado Aprimorado.");
        Talento talento34 = new Talento("Duro de Matar\n", GrupoDeTalento.COMBATE, "Benefício: quando você sofre dano que poderia levá-lo a 0\n" +
                "ou menos pontos de vida, você pode ignorar completamente esse\n" +
                "dano. Você pode usar este talento uma vez por dia.");
        Talento talento35 = new Talento("Empunhadura Poderosa\n", GrupoDeTalento.COMBATE, "Benefício: ao usar armas uma categoria de tamanho acima da\n" +
                "sua, sua penalidade cai para –2.", " For 17.");
        Talento talento36 = new Talento("Empurrar Aprimorado\n", GrupoDeTalento.COMBATE, "Benefício: +4 em jogadas de ataque para empurrar.\n", "Força 13, Ataque Poderoso.");
        Talento talento37 = new Talento("Especialização em Arma\n", GrupoDeTalento.COMBATE, "Benefício: usando a arma escolhida, você recebe +2 em jogadas de dano", " Foco em Arma com a arma escolhida, guerreiro 4º nível.");
        Talento talento38 = new Talento("Especialização em\n" +
                "Arma Aprimorada", GrupoDeTalento.COMBATE, " seu bônus no dano pelo talento Especialização em\n" +
                "Arma aumenta para +4.", " Foco em Arma, Foco em Arma Aprimorado,\n" +
                "Especialização em Arma com a arma escolhida, guerreiro 12º nível.");
        Talento talento39 = new Talento("Especialização em Armadura\n", GrupoDeTalento.COMBATE, "Benefício: quando usando uma armadura do tipo escolhido,\n" +
                "você recebe redução de dano 2.", "Foco em Armadura do tipo escolhido, guerreiro 8º nível.");
        Talento talento40 = new Talento("Especialização em Combate\n", GrupoDeTalento.COMBATE, "Benefício: declare que está usando este talento antes de fazer\n" +
                "um ataque corpo-a-corpo. Você sofre –2 na jogada de ataque, mas\n" +
                "recebe +4 na classe de armadura até o próximo turno.", " Int 13.\n");
        Talento talento41 = new Talento("Esquiva", GrupoDeTalento.COMBATE, "Benefício: você recebe CA+1.\n", " Des 13.");
        Talento talento42 = new Talento("Fintar Aprimorado\n", GrupoDeTalento.COMBATE, "Benefício: você pode realizar um teste de Enganação para fi ntar em combate usando uma ação de movimento.", " Int 13, Especialização em Combate.");
        Talento talento43 = new Talento("Flerte Estratégico\n", GrupoDeTalento.COMBATE, "Benefício: faça uma fi nta em combate contra um inimigo\n" +
                "que possa se sentir fi sicamente atraído por você. Se for bem-sucedido, sua vítima fi ca embaraçada e sofre penalidade de –2 em jogadas\n" +
                "e testes até o fi m do combate.", " Car 13, Fintar Aprimorado.");

        Talento talento44 = new Talento("Foco em Arma Aprimorado\n", GrupoDeTalento.COMBATE, "Benefício: o bônus que você recebe pelo talento Foco em\n" +
                "Arma aumenta para +2.", " Foco em Arma com a arma escolhida, guerreiro 8º nível.");
        Talento talento45 = new Talento("Foco em Armadura", GrupoDeTalento.COMBATE, "Benefício: quando usando uma armadura do tipo escolhido,\n" +
                "você aumenta seu bônus de armadura em +1 e diminui sua penalidade de armadura em –1.", " saber usar o tipo de armadura escolhido.");
        Talento talento46 = new Talento("Golpe com Duas Mãos\n", GrupoDeTalento.COMBATE, "Benefício: quando usando uma arma de corpo-a-corpo com\n" +
                "as duas mãos, você soma o dobro de seu modifi cador de Força às\n" +
                "jogadas de dano. Este talento não pode ser usado com armas leves.\n", " For 15, Ataque Poderoso.");
        Talento talento47 = new Talento("Granadeiro", GrupoDeTalento.COMBATE, "Benefício: você recebe +2 em jogadas de ataque e dano com\n" +
                "quaisquer armas que permitem um teste de Refl exos para reduzir\n" +
                "seu efeito, como fogo alquímico e granadas.", " treinado em Ofício (alquimia).");
        Talento talento48 = new Talento("Insulto Sagaz\n", GrupoDeTalento.COMBATE, "Benefício: faça uma fi nta em combate. Se for bem-sucedido,\n" +
                "seu oponente fi ca enfurecido e sofre uma penalidade de –2 na CA\n" +
                "até o fi m do combate.", ": Car 13, Fintar Aprimorado.");
        Talento talento49 = new Talento("Investida Implacável\n", GrupoDeTalento.COMBATE, "Benefício: quando está montado e faz uma investida, você\n" +
                "causa dano dobrado com uma arma comum, ou triplicado com\n" +
                "uma lança.", "treinado em Cavalgar, Combate Montado,\n" +
                "Investida Montada");
        Talento talento50 = new Talento("Investida Montada\n", GrupoDeTalento.COMBATE, "Benefício: quando está montado e faz uma investida, você\n" +
                "pode continuar se movendo depois do ataque. Você deve continuar\n" +
                "se movendo em linha reta, e seu movimento total na rodada não\n" +
                "pode ser superior ao dobro do deslocamento da montaria.", " treinado em Cavalgar, Combate Montado.");
        Talento talento51 = new Talento("Lutar às Cegas\n", GrupoDeTalento.COMBATE, "Benefício: sempre que você erra um ataque devido a camufl agem, pode rolar mais uma vez a chance de acertar. Além disso, você\n" +
                "não fi ca desprevenido contra inimigos que não possa ver.");
        Talento talento52 = new Talento("Mestre em Arma\n", GrupoDeTalento.COMBATE, "Benefício: usando a arma escolhida, você recebe +1 em jogadas de ataque e dano, e sua margem de ameaça aumenta em 1.\n" +
                "Além disso, uma vez por dia, você pode rolar outra vez uma jogada\n" +
                "de ataque que tenha recém realizado. Você deve aceitar a segunda\n" +
                "rolagem, mesmo que seja pior que a primeira.", "Especialização em Arma, Especialização em\n" +
                "Arma Aprimorada, Foco em Arma, Foco em Arma Aprimorado\n" +
                "(todos com a arma escolhida), guerreiro 16º nível.");
        Talento talento53 = new Talento("Mira Apurada\n", GrupoDeTalento.COMBATE, "Benefício: você pode gastar uma ação de movimento para\n" +
                "mirar um alvo. Se fi zer isso, recebe +1 em jogadas de ataque à\n" +
                "distância realizadas contra ele na mesma rodada.", ": Sab 13, Tiro Certeiro, Tiro Longo");
        Talento talento54 = new Talento("Mira Mortal\n", GrupoDeTalento.COMBATE, "Benefício: sua margem de ameaça com armas de projéteis\n" +
                "aumenta em 1. Por exemplo, a margem de ameaça da pistola é 19-\n" +
                "20; para um personagem com este talento, será 18-20.", "Des 17, Sab 13, Mira Apurada, Tiro Certeiro,\n" +
                "Tiro Longo, bônus base de ataque +11.");
        Talento talento55 = new Talento("Mobilidade", GrupoDeTalento.COMBATE, "Benefício: você recebe +2 na CA sempre que usa uma ação de\n" +
                "movimento para deslocar-se.", " Des 13, Esquiva.\n");
        Talento talento56 = new Talento("Na Mosca\n", GrupoDeTalento.COMBATE, "Benefício: você soma seu modifi cador de Destreza em jogadas de dano com armas de ataque à distância.", "Des 13, Tiro Certeiro, Tiro Preciso");
        Talento talento57 = new Talento("Panache", GrupoDeTalento.COMBATE, "Benefício: faça uma fi nta em combate. Se for bem-sucedido,\n" +
                "seu oponente fi ca espantado com a manobra, e no próximo turno\n" +
                "só pode realizar uma ação padrão.", "Car 13, Fintar Aprimorado.");
        Talento talento58 = new Talento("Perito em Arma\n", GrupoDeTalento.COMBATE, "Benefício: graças a uma extrema habilidade com a arma, que\n" +
                "funciona como uma verdadeira extensão de seu corpo, você pode\n" +
                "substituir um teste de qualquer perícia por uma jogada de ataque\n" +
                "com a arma escolhida. Você pode, por exemplo, usar uma espada para\n" +
                "destrancar uma fechadura (Ladinagem), como suporte para subir em\n" +
                "algo (Atletismo), como apoio para uma cambalhota (Acrobacia), para\n" +
                "fazer manobras impressionantes (Atuação) e assim por diante.", ": Des 13, Int 13, Acuidade com Arma, Foco\n" +
                "em Arma com a arma escolhida.");
        Talento talento59 = new Talento("Pisotear", GrupoDeTalento.COMBATE, "Benefício: quando está montado e realiza a manobra atropelar, o alvo não pode escolher evitá-lo. Além disso, se a montaria\n" +
                "derrubar um oponente, pode fazer um ataque contra esse oponente\n" +
                "como uma ação livre (recebendo o bônus padrão de +4 em jogadas\n" +
                "de ataque contra oponentes caídos).", " treinado em Cavalgar, Combate Montado.");
        Talento talento60 = new Talento("Rapidez de Recarga\n", GrupoDeTalento.COMBATE, "Benefício: a ação necessária para recarregar a arma\n" +
                "escolhida diminui em uma\n" +
                "categoria — ação completa\n" +
                "vira padrão, padrão vira de\n" +
                "movimento, e de movimento vira livre. Por exemplo,\n" +
                "recarregar um mosquete\n" +
                "normalmente é uma ação padrão, mas para um personagem com\n" +
                "este talento é uma ação de movimento.", "saber usar a arma escolhida.");
        Talento talento61 = new Talento("Reflexos de Combate\n", GrupoDeTalento.COMBATE, "Benefício: se estiver adjacente a um oponente desprevenido,\n" +
                "você pode fazer um ataque corpo-a-corpo contra ele como uma\n" +
                "ação livre.", "Des 13.");
        Talento talento62 = new Talento("Saque Rápido\n", GrupoDeTalento.COMBATE, "Benefício: você pode sacar ou guardar uma arma como uma\n" +
                "ação livre");
        Talento talento63 = new Talento("Separar Aprimorado\n", GrupoDeTalento.COMBATE, "Benefício: você recebe +4 em jogadas de ataque para separar.\n" +
                "Além disso, você causa dano dobrado contra objetos.", "For 13, Ataque Poderoso.");
        Talento talento64 = new Talento("Tiro Certeiro\n", GrupoDeTalento.COMBATE, "Benefício: você recebe +1 em jogadas de ataque e dano com\n" +
                "armas de ataque à distância contra alvos que estejam a até 9m.");
        Talento talento65 = new Talento("Tiro em Movimento\n", GrupoDeTalento.COMBATE, "Benefício: quando estiver atacando à distância, você pode se\n" +
                "mover antes e depois do ataque, desde que a distância total percorrida não seja maior que seu deslocamento.\n" +
                "Você não pode usar este talento se estiver de armadura pesada", "Des 13, Esquiva, Mobilidade, Tiro Certeiro,\n" +
                "bônus base de ataque +4.");
        Talento talento66 = new Talento("Tiro Longo\n", GrupoDeTalento.COMBATE, "Benefício: o incremento de distância de qualquer arma que você utiliza é dobrado.", "Tiro Certeiro");
        Talento talento67 = new Talento("Tiro Montado\n", GrupoDeTalento.COMBATE, "Benefício: sua penalidade para ataques à distância quando sua montaria se movimenta é reduzida\n" +
                "para –2.", "treinado em Cavalgar,\n" +
                "Combate Montado.");
        Talento talento68 = new Talento("Tiro Múltiplo\n", GrupoDeTalento.COMBATE, "Benefício: usando uma ação padrão e\n" +
                "uma arma de projéteis, você pode fazer dois\n" +
                "ataques contra um único oponente a até 9m.\n" +
                "Ambos usam a mesma jogada (com penalidade de –4) e causam dano normalmente.", "Des 17, Tiro Certeiro,\n" +
                "Tiro Rápido, bônus base de ataque +6.");
        Talento talento69 = new Talento("Tiro Preciso\n", GrupoDeTalento.COMBATE, "Benefício: você pode fazer ataques à distância contra oponentes envolvidos em combate corpo-a-corpo sem sofrer a penalidade\n" +
                "de –4 na jogada de ataque.", " Tiro Certeiro");
        Talento talento70 = new Talento("Tiro Preciso Aprimorado\n", GrupoDeTalento.COMBATE, "Benefício: seus ataques à distância ignoram cobertura e\n" +
                "camufl agem (exceto cobertura ou camufl agem totais).\n" +
                "Além disso, quando ataca um alvo envolvido na manobra agarrar, você acerta automaticamente o alvo\n" +
                "que escolheu.", "Des 19, Tiro Certeiro, Tiro Preciso, bônus\n" +
                "base de ataque +11.");
        Talento talento71 = new Talento("Tiro Rápido\n", GrupoDeTalento.COMBATE, "Benefício: usando uma\n" +
                "arma de ataque à distância,\n" +
                "você pode fazer um ataque adicional. Se fi zer isso, sofre uma\n" +
                "penalidade de –2 em todas as jogadas de ataque. Usar este talento é\n" +
                "uma ação completa.", "Des 13,\n" +
                "Tiro Certeiro.");
        Talento talento72 = new Talento("Torcida", GrupoDeTalento.COMBATE, "Benefício: você recebe +1 em jogadas de\n" +
                "ataque, CA e testes de resistência quando tem\n" +
                "a torcida a seu favor, durante uma luta ou outro\n" +
                "tipo de disputa. Entenda-se por “torcida” qualquer\n" +
                "número de pessoas ou criaturas inteligentes (mesmo\n" +
                "que seja apenas uma!) que não está realizando nenhuma\n" +
                "outra ação além de ver a luta. Você só recebe este benefício quando a maioria das pessoas presentes na\n" +
                "cena está gritando seu nome ou torcendo\n" +
                "por sua vitória.", "Car 13");
        Talento talento73 = new Talento("Trespassar", GrupoDeTalento.COMBATE, "Benefício: quando você derruba um inimigo com um ataque\n" +
                "corpo-a-corpo (reduzindo seus PV para 0 ou menos), pode realizar\n" +
                "um ataque adicional contra outra criatura adjacente.\n" +
                "O ataque adicional usa os mesmos bônus de ataque e dano do\n" +
                "primeiro, mas os dados devem ser rolados novamente. Você pode\n" +
                "usar este talento uma vez por rodada.", "For 13, Ataque Poderoso.");
        Talento talento74 = new Talento("Trespassar Aprimorado\n", GrupoDeTalento.COMBATE, "Benefício: você pode usar o talento Trespassar quantas vezes\n" +
                "quiser na mesma rodada.", "For 13, Ataque Poderoso, Trespassar, bônus\n" +
                "base de ataque +4.");
        Talento talento75 = new Talento("Usar Armas Simples\n", GrupoDeTalento.COMBATE, "Benefício: você sabe usar armas simples.\n");
        Talento talento76 = new Talento("Usar Armas Marciais\n", GrupoDeTalento.COMBATE, "Benefício: você sabe usar armas marciais.\n", "Usar Armas Simples.");
        Talento talento77 = new Talento("Usar Arma Exótica\n", GrupoDeTalento.COMBATE, "Benefício: você sabe usar a arma escolhida.\n", "Usar Armas Simples");
        Talento talento78 = new Talento("Usar Armaduras Leves\n", GrupoDeTalento.COMBATE, "Benefício: você sabe usar armadura acolchoada, corselete de\n" +
                "couro, couro batido, camisa de cota de malha e outras armaduras leves.");
        Talento talento79 = new Talento("Usar Armaduras Médias", GrupoDeTalento.COMBATE, "Benefício: você sabe usar cota de escamas, cota de malha,\n" +
                "couraça, gibão de peles e outras armaduras médias.", "Usar Armaduras Leves");
        Talento talento80 = new Talento("Usar Armaduras Pesadas\n", GrupoDeTalento.COMBATE, "Benefício: você sabe usar loriga segmentada, meia armadura,\n" +
                "armadura completa e outras armaduras pesadas.", "Usar Armaduras (leves, médias)");
        Talento talento81 = new Talento("Usar Escudos\n", GrupoDeTalento.COMBATE, "Benefício: você sabe usar escudos leves e pesados.\n");
        Talento talento82 = new Talento("Usar Venenos\n", GrupoDeTalento.COMBATE, "Benefício: você pode aplicar veneno em armas sem risco de se\n" +
                "envenenar acidentalmente.", "treinado em Ofício (alquimia), tendência\n" +
                "não Bondosa.");
        Talento talento83 = new Talento("Vitalidade", GrupoDeTalento.COMBATE, "Benefício: você recebe 1 ponto de vida adicional por nível\n" +
                "de personagem. Quando sobe de nível, os PV que recebe por este\n" +
                "talento aumentam de acordo.");
        Talento talento84 = new Talento("Afinidade com Animais", GrupoDeTalento.PERICIA, "Benefício: você pode rolar outra vez um teste de Adestrar\n" +
                "Animais que tenha recém realizado. Você deve aceitar a segunda\n" +
                "rolagem, mesmo que seja pior que a primeira.");
        Talento talento85 = new Talento("Ágil", GrupoDeTalento.PERICIA, "Benefício: você pode usar seu modifi cador de Destreza em\n" +
                "vez de Força em testes de Atletismo.", " Des 15.");
        Talento talento86 = new Talento("Aptidão Mágica\n", GrupoDeTalento.PERICIA, "Benefício: você pode rolar outra vez um teste de Identifi car\n" +
                "Magia que tenha recém realizado. Você deve aceitar a segunda rolagem, mesmo que seja pior que a primeira.");
        Talento talento87 = new Talento("Artista", GrupoDeTalento.PERICIA, "Benefício: você pode rolar outra vez um teste de Atuação que\n" +
                "tenha recém realizado. Você deve aceitar a segunda rolagem, mesmo que seja pior que a primeira.");
        Talento talento88 = new Talento("Atlético", GrupoDeTalento.PERICIA, "Benefício: você pode rolar outra vez um teste de Atletismo\n" +
                "que tenha recém realizado. Você deve aceitar a segunda rolagem,\n" +
                "mesmo que seja pior que a primeira.");
        Talento talento89 = new Talento("Autossuficiente", GrupoDeTalento.PERICIA, "Benefício: você não sofre a penalidade de –5 para fazer testes\n" +
                "de Cura em si mesmo, e recebe +4 nos testes de Sobrevivência se\n" +
                "estiver sozinho (sem nenhum aliado a até 18m).");
        Talento talento90 = new Talento("Criar Obra-Prima\n", GrupoDeTalento.PERICIA, "Benefício: você pode construir armas, armaduras e kits de\n" +
                "ferramentas de qualidade obra-prima. Uma arma obra-prima fornece +1 em jogadas de ataque; uma armadura obra-prima tem sua\n" +
                "penalidade de armadura reduzida em 1; e um kit de ferramentas\n" +
                "obra-prima fornece +2 nos testes da perícia apropriada.", " treinado em Ofício, Foco em Perícia (Ofício).");
        Talento talento91 = new Talento("Dedos Ágeis\n", GrupoDeTalento.PERICIA, "Benefício: você pode rolar outra vez um teste de Ladinagem\n" +
                "que tenha recém realizado. Você deve aceitar a segunda rolagem,\n" +
                "mesmo que seja pior que a primeira.");
        Talento talento92 = new Talento("Diligente", GrupoDeTalento.PERICIA, "Benefício: você pode gastar uma ação de movimento para se\n" +
                "concentrar na tarefa à frente. Se fi zer isso, recebe +2 nos testes de\n" +
                "perícia realizados até a próxima rodada.");
        Talento talento93 = new Talento("Foco em Perícia\n", GrupoDeTalento.PERICIA, "Benefício: você recebe +4 em testes da perícia escolhida.\n", " treinado na perícia escolhida.");
        Talento talento94 = new Talento("Fraudulento", GrupoDeTalento.PERICIA, "Benefício: você pode rolar outra vez um teste de Enganação\n" +
                "que tenha recém realizado. Você deve aceitar a segunda rolagem,\n" +
                "mesmo que seja pior que a primeira.");
        Talento talento95 = new Talento("Impostor", GrupoDeTalento.PERICIA, "Benefício: graças a seu extremo charme, magnetismo pessoal\n" +
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
                "de Carisma.", " Car 13, Foco em Perícia (Enganação)");
        Talento talento96 = new Talento("Iniciativa\n" +
                "Aprimorada", GrupoDeTalento.PERICIA, "Benefício: você pode rolar\n" +
                "outra vez um teste de Iniciativa que tenha recém realizado.\n" +
                "Você deve aceitar a segunda rolagem, mesmo que seja pior que\n" +
                "a primeira.");
        Talento talento97 = new Talento("Investigador", GrupoDeTalento.PERICIA, "Benefício: você pode somar seu bônus de Inteligência a testes\n" +
                "de Obter Informação e testes de Percepção para procurar.", "Int 13");
        Talento talento98 = new Talento("Negociador", GrupoDeTalento.PERICIA, "Benefício: quando você chega a uma comunidade, faça um\n" +
                "teste de Ofício (CD 20). Se tiver sucesso, você pode comprar itens\n" +
                "nesta comunidade por 75% do preço padrão (arredondado para\n" +
                "baixo). Por exemplo, você pode comprar uma armadura completa\n" +
                "(que normalmente custa 1.500 TO) por 1.125 TO.\n" +
                "Se falhar, você pode tentar novamente em um mês (ou quando visitar outra comunidade).", "treinado em Ofício");
        Talento talento99 = new Talento("Persuasivo", GrupoDeTalento.PERICIA, "Benefício: você pode rolar outra vez um teste de Diplomacia que tenha recém realizado.\n" +
                "Você deve aceitar a segunda\n" +
                "rolagem, mesmo que seja pior\n" +
                "que a primeira.");
        Talento talento100 = new Talento("Prontidão", GrupoDeTalento.PERICIA, "Benefício: você pode\n" +
                "rolar outra vez um teste de\n" +
                "Percepção que tenha recém\n" +
                "realizado. Você deve aceitar a\n" +
                "segunda rolagem, mesmo que\n" +
                "seja pior que a primeira.");
        Talento talento101 = new Talento("Rastrear", GrupoDeTalento.PERICIA, "Benefício: você pode\n" +
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
                "(mas lembre-se de que a CD aumenta a cada dia).", " treinado em\n" +
                "Sobrevivência");
        Talento talento102 = new Talento("Senso da Natureza\n", GrupoDeTalento.PERICIA, "Benefício: você pode rolar outra vez um teste de Sobrevivência que tenha recém realizado. Você deve aceitar a segunda rolagem, mesmo que seja pior que a primeira");
        Talento talento103 = new Talento("Sorrateiro", GrupoDeTalento.PERICIA, "Benefício: você pode rolar outra vez um teste de Furtividade\n" +
                "que tenha recém realizado. Você deve aceitar a segunda rolagem,\n" +
                "mesmo que seja pior que a primeira.");
        Talento talento104 = new Talento("Treino em Perícia\n", GrupoDeTalento.PERICIA, "Benefício: você se torna treinado na perícia escolhida.\n");
        Talento talento105 = new Talento("Acelerar Magia [metamágico]\n \n", GrupoDeTalento.MAGIA, "Benefício: quando você usa este talento, pode lançar uma\n" +
                "magia como uma ação livre. Lançar uma magia acelerada não deixa você desprevenido.\n" +
                "Você só pode usar este talento uma vez por rodada. Magias\n" +
                "com um tempo de execução maior que uma ação completa não são\n" +
                "afetadas por este talento.");
        Talento talento106 = new Talento("Ampliar Magia [metamágico]", GrupoDeTalento.MAGIA, "Benefício: quando você usa este talento, a área da magia é\n" +
                "duplicada (por exemplo, uma bola de fogo ampliada tem 12m de\n" +
                "raio, em vez de 6m).\n" +
                "Magias sem área de efeito não são afetadas por este talento.");
        Talento talento107 = new Talento("Aumentar Magia [metamágico]\n", GrupoDeTalento.MAGIA, "Benefício: quando você usa este talento, o alcance da magia é\n" +
                "duplicado (por exemplo, um relâmpago aumentado tem um alcance de 90m, em vez de 45m).\n" +
                "Magias sem alcance medido em metros não podem ser afetadas por este talento.");
        Talento talento108 = new Talento("Conhecimento Mágico", GrupoDeTalento.MAGIA, "Benefício: você aprende mais duas magias de quaisquer níveis\n" +
                "que possa lançar. Por exemplo, se você é um mago de 3º nível,\n" +
                "pode aprender duas magias novas de 1º ou 2º nível.");
        Talento talento109 = new Talento("Contramágica Aprimorada\n", GrupoDeTalento.MAGIA, "Benefício: você pode usar qualquer magia como contramágica, desde que seu custo em PM seja igual ou superior ao custo\n" +
                "da magia que você quer anular.");
        Talento talento110 = new Talento("Dominar Magia\n", GrupoDeTalento.MAGIA, "Benefício: o custo em PM para lançar a magia escolhida diminui em 1. O custo fi nal (após aplicar todos os modifi cadores,\n" +
                "incluindo este talento e talentos metamágicos) é no mínimo 1 PM.");
        Talento talento111 = new Talento("Elevar Magia [metamágico]\n", GrupoDeTalento.MAGIA, "Benefício: uma magia elevada tem um nível de magia mais\n" +
                "alto que o normal (até um máximo de 9º nível). Diferente de outros talentos metamágicos, Elevar Magia aumenta verdadeiramente o nível da magia. Todos os efeitos dependentes de nível (como\n" +
                "CD para resistir) são calculados de acordo com o nível elevado");
        Talento talento112 = new Talento("Estender Magia [metamágico]\n", GrupoDeTalento.MAGIA, "Benefício: a duração da magia é duplicada (por exemplo, um\n" +
                "imobilizar pessoa estendido dura 2 minutos, em vez de 1 min).\n" +
                "Magias com duração instantânea, permanente ou concentração não podem ser afetadas por este talento.");
        Talento talento113 = new Talento("Familiar", GrupoDeTalento.MAGIA, "Benefício: você recebe a habilidade familiar do mago. Consulte a descrição da classe mago para mais detalhes.", " capacidade de lançar magias arcanas.");
        Talento talento114 = new Talento("Foco em Magia\n", GrupoDeTalento.MAGIA, "Benefício: a difi culdade do teste de resistência contra a magia\n" +
                "escolhida aumenta em CD+2.");
        Talento talento115 = new Talento("Foco em Magia Aprimorado\n", GrupoDeTalento.MAGIA, "Benefício: o aumento de difi culdade oferecido pelo talento\n" +
                "Foco em Magia aumenta para CD+4.", "Foco em Magia com a magia escolhida.");
        Talento talento116 = new Talento("Magia Natural\n", GrupoDeTalento.MAGIA, " Benefício: você pode lançar magias quando está na forma\n" +
                "selvagem.", "Sab 13, habilidade de forma selvagem.");
        Talento talento117 = new Talento("Magia Sem Gestos [metamágico]\n", GrupoDeTalento.MAGIA, "Benefício: uma magia sem gestos pode ser lançada sem nenhum componente gestual.");
        Talento talento118 = new Talento("Magia Silenciosa [metamágico]\n", GrupoDeTalento.MAGIA, "Benefício: uma magia silenciosa pode ser lançada sem nenhum componente verbal.");
        Talento talento119 = new Talento("Magias em Combate\n", GrupoDeTalento.MAGIA, "Benefício: você não fi ca desprevenido quando lança uma\n" +
                "magia");
        Talento talento120 = new Talento("Mago de Batalha\n", GrupoDeTalento.MAGIA, "Benefício: você soma seu modifi cador de Inteligência às jogadas de dano de suas magias.", " Int 13, Magias em Combate, mago 4º nível.");
        Talento talento121 = new Talento("Maximizar Magia [metamágico]\n", GrupoDeTalento.MAGIA, "Benefício: quando você usa este talento, todos os efeitos numéricos variáveis da magia são aumentados ao máximo. Por exemplo, uma bola de fogo capaz de causar 6d6 pontos de dano, quando\n" +
                "maximizada, causará 36 pontos de dano (mais quaisquer bônus),\n" +
                "sem a necessidade de rolar dados.\n" +
                "Uma magia sem efeitos variáveis não pode ser afetada por este\n" +
                "talento.\n" +
                "Uma magia potencializada e maximizada adquire os benefícios separados de cada talento: o resultado máximo, mais metade\n" +
                "do resultado jogado normalmente");
        Talento talento122 = new Talento("Poder Mágico\n", GrupoDeTalento.MAGIA, "Benefício: você recebe 1 ponto de magia adicional.");
        Talento talento123 = new Talento("Potencializar Invocação", GrupoDeTalento.MAGIA, "Benefício: as criaturas que você invoca com as magias invocar\n" +
                "recebem +2 em suas jogadas de ataque e dano.");
        Talento talento124 = new Talento("Potencializar Magia [metamágico]\n", GrupoDeTalento.MAGIA, "Benefício: quando você usa este talento, todos os efeitos numéricos variáveis da magia são aumentados em 50%. Por exemplo,\n" +
                "um relâmpago capaz de causar 6d6 pontos de dano, após rolar 21,\n" +
                "causa mais 50% (neste caso, 10), para um total de 31 pontos de\n" +
                "dano. Quaisquer bônus que você tenha também são potencializados.\n" +
                "Uma magia sem efeitos variáveis não pode ser afetada por\n" +
                "este talento.\n" +
                "Uma magia potencializada e maximizada adquire os benefícios separados de cada talento: o resultado máximo, mais metade\n" +
                "do resultado jogado normalmente.");
        Talento talento125 = new Talento("Ajuda dos Ancestrais\n", GrupoDeTalento.DESTINO, "Benefício: você pode lançar a magia adivinhação uma vez por\n" +
                "dia, sem gastar pontos de magia.", " Sab 13.");
        Talento talento126 = new Talento("Ao Sabor do Destino\n", GrupoDeTalento.DESTINO, "Benefício: você recebe os seguintes benefícios, de acordo\n" +
                "com seu nível de personagem. Caso adquira este talento depois\n" +
                "do 5º nível, você recebe todos os benefícios dos níveis anteriores. 5º +1 em jogadas de ataque e dano.\n" +
                "6º +4 em uma perícia à sua escolha.\n" +
                "7º +1 na CA.\n" +
                "8º +2 em uma habilidade à sua escolha (cumulativo).\n" +
                "9º +1 nos testes de resistência.\n" +
                "10º +2 em jogadas de ataque e dano.\n" +
                "11º +4 em uma perícia à sua escolha.\n" +
                "12º +2 na CA.\n" +
                "13º +2 em uma habilidade à sua escolha (cumulativo).\n" +
                "14º +2 nos testes de resistência.\n" +
                "15º +3 em jogadas de ataque e dano.\n" +
                "16º +4 em uma perícia à sua escolha.\n" +
                "17º +3 na CA.\n" +
                "18º +2 em uma habilidade à sua escolha (cumulativo).\n" +
                "19º +3 nos testes de resistência.\n" +
                "20º +4 em jogadas de ataque e dano.", " Car 13, personagem 5º nível.");
        Talento talento127 = new Talento("Atraente", GrupoDeTalento.DESTINO, " você recebe +4 nos testes de Diplomacia e Enganação\n" +
                "contra qualquer um que possa se sentir fi sicamente atraído por você.");

        Talento talento128 = new Talento("Comandar", GrupoDeTalento.DESTINO, "Benefício: você pode usar uma ação padrão para gritar ordens\n" +
                "para seus aliados. Aqueles que puderem ouvi-lo recebem +1 em\n" +
                "suas jogadas e testes por um número de rodadas igual a 1 + seu\n" +
                "modifi cador de Carisma.");

        Talento talento129 = new Talento("Corrida", GrupoDeTalento.DESTINO, "Benefício: seu deslocamento aumenta em +3m.\n");

        Talento talento130 = new Talento("Devoto", GrupoDeTalento.DESTINO, "Benefício: escolha uma magia divina de nível 0. Você pode\n" +
                "lançar esta magia até três vezes por dia, como se fosse um clérigo.", " Sab 11, estar entre os adoradores típicos do\n" +
                "deus escolhido (veja em “Deuses”, no Capítulo 6).");

        Talento talento131 = new Talento("Estudioso Arcano", GrupoDeTalento.DESTINO, "Benefício: escolha uma magia arcana de nível 0. Você pode\n" +
                "lançar esta magia até três vezes por dia, como se fosse um mago.", " Int 11.");

        Talento talento132 = new Talento("Expulsão Aprimorada", GrupoDeTalento.DESTINO, "Benefício: a difi culdade do teste de Vontade contra o talento\n" +
                "Expulsar/Fascinar Mortos-Vivos aumenta em CD+2.", " Expulsar/Fascinar Mortos-Vivos");

        Talento talento133 = new Talento("Expulsar/Fascinar Mortos-Vivos\n", GrupoDeTalento.DESTINO, "Benefício: este talento afeta todos os mortos-vivos a até 9m.\n" +
                "Se você canaliza energia positiva, pode deixá-los apavorados durante um minuto. Se canaliza energia negativa, pode deixá-los sob\n" +
                "seu comando. Dar uma ordem aos mortos-vivos é uma ação de\n" +
                "movimento. O nível somado de mortos-vivos sob seu comando\n" +
                "não pode exceder seu próprio nível.\n" +
                "Mortos-vivos têm direito a um teste de Vontade (CD 10 +\n" +
                "metade de seu nível + modifi cador de Carisma) para evitar qualquer destes efeitos.\n" +
                "Usar este talento é uma ação padrão, e gasta uma utilização\n" +
                "diária da habilidade canalizar energia positiva/negativa.", "habilidade de canalizar energia positiva/\n" +
                "negativa.");

        Talento talento134 = new Talento("Fortitude Maior\n", GrupoDeTalento.DESTINO, "Benefício: seu bônus base de Fortitude aumenta +2.\n");

        Talento talento135 = new Talento("Liderança", GrupoDeTalento.DESTINO, "Benefício: escolha entre ter um parceiro, ou ter seguidores.Um parceiro é um segundo personagem, dois níveis abaixo\n" +
                "do seu. Você é livre para construir esse personagem, escolhendo\n" +
                "sua raça e classe — mas a tendência do parceiro deve estar apenas\n" +
                "um passo distante da sua. O parceiro avança de nível quando você\n" +
                "também avança.\n" +
                "Um parceiro é alguém leal, que segue seu personagem por\n" +
                "razões pessoais. Ele segue suas ordens, e pode até arriscar a vida\n" +
                "para ajudá-lo. Mas um parceiro constantemente maltratado pode\n" +
                "— por intervenção do mestre — desistir de segui-lo.\n" +
                "Se escolheu seguidores, você tem uma quantidade de níveis\n" +
                "de seguidores igual a seu nível multiplicado por seu modifi cador\n" +
                "de Carisma (mínimo 1). Por exemplo, um paladino de 10º nível e\n" +
                "Carisma 16 (+3) tem 30 níveis de seguidores. Você pode distribuir\n" +
                "os níveis como quiser para construir os personagens, mas o nível\n" +
                "máximo que eles podem ter é igual a metade do seu. Então, o mesmo paladino poderia ter seguidores de até 5º nível. Essa diferença\n" +
                "de poder torna os seguidores inefi cazes em combate. Em geral eles\n" +
                "atuam apenas contra adversários fracos, ou então como ajudantes,\n" +
                "guardas, mensageiros, carregadores...\n" +
                "Seguidores podem ser de qualquer tendência, mas não costumam ser tão leais ou corajosos quanto parceiros. Podem lutar se\n" +
                "ordenados, mas abandonam a luta se perdem metade ou mais de\n" +
                "seus pontos de vida. Seguidores não sobem de nível; quando você\n" +
                "sobe de nível, ganha mais seguidores.\n" +
                "Ao perder parceiros ou seguidores (por morte ou desistência),\n" +
                "você vai precisar de 1d4 meses para encontrar outros", "personagem 6º nível.");

        Talento talento136 = new Talento("Linguista", GrupoDeTalento.DESTINO, "Benefício: você aprende um número de novos idiomas igual\n" +
                "a 3 + seu modifi cador de Inteligência (mínimo 1).\n");

        Talento talento137 = new Talento("Reflexos Rápidos\n", GrupoDeTalento.DESTINO, "Benefício: seu bônus base de Refl exos aumenta +2.\n");

        Talento talento138 = new Talento("Surto Heroico\n", GrupoDeTalento.DESTINO, "Benefício: você pode realizar uma ação padrão ou de movimento adicional na rodada. Por exemplo, pode realizar uma ação\n" +
                "completa e uma ação padrão, ou uma ação padrão e duas ações de\n" +
                "movimento, ou qualquer outra combinação.\n" +
                "Você pode usar este talento uma vez por dia", "tendência Bondosa.");

        Talento talento139 = new Talento("Terreno Familiar", GrupoDeTalento.DESTINO, "Benefício: você recebe +2 na classe de armadura e testes\n" +
                "de Acrobacia, Atletismo, Furtividade, Percepção e Sobrevivência\n" +
                "quando estiver no tipo de terreno escolhido.");

        Talento talento140 = new Talento("Tolerância", GrupoDeTalento.DESTINO, "Benefício: você recebe +4 em testes de Constituição para\n" +
                "prender o fôlego e evitar dano por fome ou sede, e em testes de\n" +
                "Fortitude para evitar dano por frio ou calor. Você também pode\n" +
                "dormir de armadura sem fi car fatigado.");

        Talento talento141 = new Talento("Vontade de Ferro\n", GrupoDeTalento.DESTINO, "Benefício: seu bônus base de Vontade aumenta +2.\n");

        Talento talento142 = new Talento("Domínio da Água\n",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: você está permanentemente sob efeito da magia\n" +
                "respirar na água","devoto de Oceano ou Wynna.");
        Talento talento143 = new Talento("Domínio dos Animais\n",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: você está permanentemente sob efeito da magia\n" +
                "falar com animais. Além disso, Sobrevivência é uma perícia de classe para você."," devoto de Allihanna, Megalokk ou Oceano.");
        Talento talento144 = new Talento("Domínio do Ar\n",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: você está permanentemente sob efeito da magia\n" +
                "queda suave.","devoto de Oceano ou Wynna.");
        Talento talento145 = new Talento("Domínio do Bem\n",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: para criaturas de tendência Maligna, a difi culdade\n" +
                "para resistir às suas magias divinas aumenta em CD+1."," devoto de Allihanna, Azgher, Khalmyr, Lena,\n" +
                "Marah ou Valkaria.");
        Talento talento146 = new Talento("Domínio do Caos\n",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: para criaturas de tendência Leal, a difi culdade para\n" +
                "resistir às suas magias divinas aumenta em CD+1.","devoto de Hyninn ou Nimb.");
        Talento talento147 = new Talento("Domínio do Conhecimento\n",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: você pode fazer testes de qualquer Conhecimento\n" +
                "como se fosse treinado, com um bônus igual a seu nível + modifi -\n" +
                "cador de Inteligência."," devoto de Kallyadranoch, Sszzaas, Tanna-Toh\n" +
                "ou Th yatis");
        Talento talento148 = new Talento("Domínio da Cura\n",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: suas magias de cura curam 1 PV adicional por nível da magia. Por exemplo, curar ferimentos moderados (uma magia\n" +
                "de 2º nível) cura 2 PV adicionais."," devoto de Allihanna, Lena, Marah ou Th yatis");
        Talento talento149 = new Talento("Domínio da Destruição\n",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: você recebe +1 em jogadas de dano corpo-a-corpo.","devoto de Kallyadranoch, Keenn, Mega lokk\n" +
                "ou Ragnar.");
        Talento talento150 = new Talento("Domínio da Enganação\n",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: Enganação, Furtividade e Ladinagem passam a ser\n" +
                "perícias de classe para você."," devoto de Hyninn ou Sszzaas.\n");
        Talento talento151 = new Talento("Domínio do Fogo\n",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: uma vez por dia, como uma ação livre, você pode\n" +
                "receber um bônus igual ao seu nível na Força por uma rodada."," devoto de Keenn ou Tauron.");
        Talento talento152 = new Talento("Domínio da Guerra\n",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: você recebe os talentos Usar Arma e Foco em\n" +
                "Arma, apenas para a arma predileta de sua divindade"," devoto de Keenn, Khalmyr, Lin-Wu, Ragnar,\n" +
                "Tauron ou Valkaria.");
        Talento talento153 = new Talento("Domínio da Magia\n",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: uma vez por dia, você pode lançar qualquer magia que conheça sem gastar pontos de magia. Você também pode\n" +
                "aplicar efeitos de talentos metamágicos que possua a essa magia,\n" +
                "mas nesse caso deverá pagar o custo extra exigido pelo(s) talento(s).","devoto de Kallyadranoch ou Wynna.");
        Talento talento154 = new Talento("Domínio do Mal\n",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: para criaturas de tendência Bondosa, a difi culdade\n" +
                "para resistir às suas magias divinas aumenta em CD+1.\n"," devoto de Kallyadranoch, Keenn, Megalokk,\n" +
                "Ragnar, Sszzaas ou Tenebra.");
        Talento talento155 = new Talento("Domínio da Morte\n",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: uma vez por dia, você pode usar o toque da morte.\n" +
                "Faça um ataque de toque desarmado. Se você acertar, role 1d6 por\n" +
                "nível. Se o total igualar ou superar os pontos de vida do alvo, ele\n" +
                "morre (sem direito a teste de resistência). Caso contrário, o alvo\n" +
                "não sofre nada."," devoto de Ragnar, Sszzaas ou Tenebra.");
        Talento talento156 = new Talento("Domínio da Ordem\n",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: para criaturas de tendência Caótica, a difi culdade\n" +
                "para resistir às suas magias divinas aumenta em CD+1.","devoto de Khalmyr, Lin-Wu, Tanna-Toh ou\n" +
                "Tauron.");
        Talento talento157 = new Talento("Domínio das Plantas\n",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: você pode lançar a magia constrição três vezes por\n" +
                "dia, como um clérigo, sem gastar pontos de magia.","devoto de Allihanna, Lena, Megalokk ou Oceano.");
        Talento talento158 = new Talento("Domínio da Proteção\n",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: uma vez por dia, com uma ação padrão, você pode\n" +
                "tocar um alvo e gerar um escudo de proteção que fornece um bônus igual a seu nível em testes de resistência. Por exemplo, se você\n" +
                "é um personagem de 5º nível, fornece +5 em testes de resistência.\n" +
                "O escudo dura um minuto.",": devoto de Khalmyr, Lena, Lin-Wu, Marah,\n" +
                "Tanna-Toh, Tauron ou Tenebra.");
        Talento talento159 = new Talento("Domínio do Sol\n",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: uma vez por dia, quando usa Expulsar Mortos-\n" +
                "-Vivos, você pode invocar o poder do sol. Se fi zer isso, os mortos-\n" +
                "-vivos que falharem em seu teste de resistência são destruídos (em\n" +
                "vez de fi car apavorados)."," Expulsar Mortos-Vivos, devoto de Azgher ou\n" +
                "Lin-Wu.");
        Talento talento160 = new Talento("Domínio da Sorte\n",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: uma vez por dia, você pode rolar novamente uma\n" +
                "jogada ou teste que tenha recém realizado."," devoto de Hyninn, Marah, Nimb, Wynna ou\n" +
                "Valkaria.");
        Talento talento161 = new Talento("Domínio da Terra\n",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: como uma ação de movimento, você pode fi xar-se\n" +
                "ao solo e receber CA+2. O efeito dura até que você se mova. Este\n" +
                "talento não pode ser usado se você não está em contato fi rme com o\n" +
                "chão, ou se está em uma superfície precária (corda, escada, ponte...)."," devoto de Khalmyr, Tenebra ou Wynna.");
        Talento talento162 = new Talento("Domínio da Viagem\n",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: uma vez por dia, você pode se tornar imune a qualquer efeito que restrinja seu movimento (como se usasse a magia\n" +
                "movimentação livre), por um número de rodadas igual ao seu nível","devoto de Azgher, Hynnin, Tanna-Toh,\n" +
                "Th yatis ou Valkaria.");





        talentoBox.put(talento, talento1, talento0, talento01, talento2, talento3,talento8, talento9, talento10, talento11, talento12, talento13, talento14, talento15, talento16, talento17, talento18, talento19, talento20, talento21, talento22, talento23, talento24, talento25, talento26, talento27, talento28, talento29, talento30, talento31, talento32, talento33, talento34, talento35, talento36, talento37, talento38, talento39, talento40, talento41, talento42, talento43, talento44, talento45, talento46, talento47, talento48, talento49, talento50, talento51, talento52, talento53, talento54, talento55, talento56, talento57, talento58, talento59, talento60, talento61, talento62, talento63, talento64, talento65, talento66, talento67, talento68, talento69, talento70, talento71, talento72, talento73, talento74, talento75, talento76, talento77, talento78, talento79, talento80, talento81, talento82, talento83, talento84, talento85, talento86, talento87, talento88, talento89, talento90, talento91, talento92, talento93, talento94, talento95, talento96, talento97, talento98, talento99, talento100, talento101, talento102, talento103, talento104, talento105, talento106, talento107, talento108, talento109, talento110, talento111, talento112, talento113, talento114, talento115, talento116, talento117, talento118, talento119, talento120, talento121, talento122, talento123, talento124, talento125, talento126, talento127, talento128, talento129, talento130, talento131, talento132, talento133, talento134, talento135, talento136, talento137, talento138, talento139, talento140, talento141,talento142,talento143,talento144,talento145,talento146,talento147,talento148,talento149,talento150,talento151,talento152,talento153,talento154,talento155,talento156,talento157,talento158,talento160,talento161,talento162);
    }
}
