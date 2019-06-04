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
import br.arpigi.fichaTormenta.model.Magia;
import br.arpigi.fichaTormenta.model.Raca;
import br.arpigi.fichaTormenta.model.Talento;
import io.objectbox.Box;

public class App extends Application {
    Box<Raca> racaBox;
    Box<Magia> magiaBox;
    Box<Classe> classeBox;
    Box<Talento> talentoBox;

    @Override
    public void onCreate() {
        super.onCreate();
        Banco.init(this);
        racaBox = Banco.get().boxFor(Raca.class);
        magiaBox = Banco.get().boxFor(Magia.class);
        classeBox = Banco.get().boxFor(Classe.class);
        talentoBox = Banco.get().boxFor(Talento.class);
        if (racaBox.isEmpty()) {
            Magia magia1 = new Magia("Arrombar",(byte)2,"1 porta ou objeto similar","9m", Magia.TipoMagia.ARCANA, "ação padrão","A magia arrombar abre portas, baús " +
                    "e janelas trancadas, presas, barradas ou " +
                    "protegidas por tranca arcana (neste caso, o " +
                    "efeito da tranca arcana não é anulado, mas " +
                    "neutralizado por 10 minutos). Ela também " +
                    "afrouxa grilhões e solta correntes." +
                    "A magia não afeta objetos muito grandes (com mais de 3m de largura ou altura)," +
                    "como a porta de um castelo." ,"Instantânea","Nenhum","Nenhum", null, Magia.Descritor.TRANSMUTACAO);
            Magia magia2 = new Magia ("Abençoar Água", (byte)1, "1 frasco de água", "toque", Magia.TipoMagia.DIVINA, "Ação Padrão", "Esta magia imbui um frasco d’água com energia positiva, transformando-a em água benta", "instantânea", "nenhum", "nenhum", null, Magia.Descritor.CURA);

            Magia magia3 = new Magia ("Abrir/Fechar", (byte)0, "1 objeto de até 20kg que possa ser aberto ou fechado", "toque", Magia.TipoMagia.ARCANA, "Ação Padrão", "Você pode abrir ou fechar uma porta, baú, garrafa, bolsa, etc. Esta magia não afeta objetos trancados.", "instantânea", "nenhum", "nenhum", null, Magia.Descritor.TRANSMUTACAO);

            Magia magia4 = new Magia ("Acalmar Animal", (byte)1, "1 animal", "9m", Magia.TipoMagia.DIVINA, "Ação Padrão", "Esta magia acalma um animal, deixando-o dócil e inofensivo. Qualquer ameaça óbvia anula a magia.", "1 minuto", "Vontade anula", "nenhum", null, Magia.Descritor.ENCANTAMENTO);

            Magia magia5 = new Magia ("Acalmar Emoções", (byte)2, null, "30m", Magia.TipoMagia.DIVINA, "Ação Padrão", "Esta magia acalma as criaturas na área, que não podem atacar ou realizar qualquer tipo de ação agressiva (mas podem se defender normalmente). Qualquer ameaça óbvia anula a magia.", "concentração, até 1 minuto", "Vontade anula", "nenhum", "dispersão com 6m de raio", Magia.Descritor.ENCANTAMENTO);

            Magia magia6 = new Magia ("Adivinhação", (byte)4, "você", "pessoal", Magia.TipoMagia.DIVINA, "Ação Padrão", "Esta magia responde uma pergunta feita por você. O mestre deve rolar 1d6;com um resultado de 1 a 5 a adivinhação funciona, e você recebe sua resposta, que pode ser desde uma simples frase até uma profecia ou enigma. Em um resultado de 6 a adivinhação falha, e você não recebe resposta alguma. Você não pode lançar mais de uma adivinhação para a mesma pergunta. Adivinhação não é poderosa o suficiente para resolver tramas intrincadas — como regra geral, qualquer coisa que exija mais de um dia de investigação não será descoberta. Mas a magia pode fornecer pistas, indicando um caminho a tomar para descobrir a resposta que procura.", "instantânea", "nenhum", "nenhum", null, Magia.Descritor.ADIVINHACAO);

            Magia magia7 = new Magia ("Agilidade do Gato", (byte)2, "1 criatura", "toque", Magia.TipoMagia.DIVINA, "Ação de Movimento", "Esta magia torna o alvo mais gracioso, coordenado e ágil, fornecendo um bônus de +4 na Destreza.", "1 minuto", "nenhum", "nenhum", null, Magia.Descritor.TRANSMUTACAO);

            Magia magia8 = new Magia ("Agilidade do Gato", (byte)2, "1 criatura", "toque", Magia.TipoMagia.ARCANA, "Ação de Movimento", "Esta magia torna o alvo mais gracioso, coordenado e ágil, fornecendo um bônus de +4 na Destreza.", "1 minuto", "nenhum", "nenhum", null, Magia.Descritor.TRANSMUTACAO);

            Magia magia9 = new Magia ("Agilidade do Gato em Massa", (byte)6, "até 5 criaturas", "toque", Magia.TipoMagia.ARCANA, "Ação de Movimento", "Esta magia torna o alvo mais gracioso, coordenado e ágil, fornecendo um bônus de +4 na Destreza.", "1 minuto", "nenhum", "nenhum", null, Magia.Descritor.TRANSMUTACAO);

            Magia magia10 = new Magia ("Agilidade do Gato em Massa", (byte)6, "até 5 criaturas", "toque", Magia.TipoMagia.DIVINA, "Ação de Movimento", "Esta magia torna o alvo mais gracioso, coordenado e ágil, fornecendo um bônus de +4 na Destreza.", "1 minuto", "nenhum", "nenhum", null, Magia.Descritor.TRANSMUTACAO);

            Magia magia11 = new Magia ("Ajuda", (byte)2, "1 criatura", "toque", Magia.TipoMagia.DIVINA, "Ação Padrão", "Esta magia concede ao alvo um bônus de +1 nas jogadas de ataque e testes de resistência contra medo, além de 1d8+1 PV temporários. PV temporários são os primeiros a serem perdidos quando o alvo sofre dano, e desaparecem quando a magia termina.", "1 Minuto", "nenhum", "nenhum", null, Magia.Descritor.CURA);

            Magia magia12 = new Magia ("Alarme", (byte)1, "1 criatura", "toque", Magia.TipoMagia.DIVINA, "Ação Padrão", "Esta magia concede ao alvo um bônus de +1 nas jogadas de ataque e testes de resistência contra medo, além de 1d8+1 PV temporários. PV temporários são os primeiros a serem perdidos quando o alvo sofre dano, e desaparecem quando a magia termina.", "1 Minuto", "nenhum", "nenhum", null, Magia.Descritor.CURA);

            Magia magia13 = new Magia ("Aliado Extraplanar  Menor", (byte)4, "nenhum", "9m", Magia.TipoMagia.DIVINA, "10 minutos", "Você pede à sua divindade que envie um espírito para ajudá-lo. Esse espírito realiza uma tarefa à sua escolha — desde algo simples como “use suas asas para nos levar até o topo da montanha” até algo complexo como “escolte esses camponeses até o próximo castelo” —, mas exige um pagamento em troca. Uma tarefa que exija até um minuto para ser realizada custa 100 TO, uma que exija até um dia custa 500 TO e uma tarefa que exija até uma semana (o máximo que a criatura fi cará) custa 1.000 TO.", "instantânea", "nenhum", "1 espirito de até 6 nivel", null, Magia.Descritor.INVOCACAO);

            Magia magia14 = new Magia ("Aliado Extraplanar", (byte)6, "nenhum", "9m", Magia.TipoMagia.DIVINA, "10 minutos", "Como aliado extraplanar menor, mas você invoca um espírito de até 12º nível. Além disso, uma tarefa que exija até um minuto para ser realizada custa 200 TO, uma que exija até um dia custa 1.000 TO e uma tarefa que exija até uma semana custa 2.000 TO. Custo em XP: 250 XP", "instantânea", "nenhum", "1 espirito de até 12 nivel", null, Magia.Descritor.INVOCACAO);

            Magia magia15 = new Magia ("Aliado Extraplanar  Maior", (byte)8, "nenhum", "9m", Magia.TipoMagia.DIVINA, "10 minutos", "Como aliado extraplanar menor, mas você invoca um espírito de até 18º nível. Além disso, uma tarefa que exija até um minuto para ser realizada custa 300 TO, uma que exija até um dia custa 1.500 TO e uma tarefa que exija até uma semana custa 2.500 TO. Custo em XP: 500 XP", "instantânea", "nenhum", "1 espirito de até 18 nivel", null, Magia.Descritor.INVOCACAO);

            Magia magia16 = new Magia ("Alterar Forma", (byte)9, "você", "pessoal", Magia.TipoMagia.ARCANA, "Ação Padrão", " Como metamorfose, mas você pode assumir a forma de qualquer criatura, de qualquer tamanho, com até 30 níveis. A cada rodada, você pode usar uma ação de movimento para assumir outra forma.", "1 hora", "nenhum", "nenhum", null, Magia.Descritor.TRANSMUTACAO);

            Magia magia17 = new Magia ("Alterar Forma", (byte)9, "você", "pessoal", Magia.TipoMagia.DIVINA, "Ação Padrão", " Como metamorfose, mas você pode assumir a forma de qualquer criatura, de qualquer tamanho, com até 30 níveis. A cada rodada, você pode usar uma ação de movimento para assumir outra forma.", "1 hora", "nenhum", "nenhum", null, Magia.Descritor.TRANSMUTACAO);

            Magia magia18 = new Magia ("Alterar-se", (byte)2, "você", "pessoal", Magia.TipoMagia.ARCANA, "Ação Padrão", " Você pode mudar sua aparência e forma — inclusive roupas e equipamento — para qualquer outra criatura, no máximo, uma categoria de tamanho menor ou maior. Você mantém suas estatísticas, mas recebe uma habilidade da forma selvagem do druida (veja o Capítulo 2: Classes).Se sua nova forma não é capaz de falar ou não tem membros capazes de fazer gestos precisos, você não pode lançar magias até voltar a sua forma normal.Se usar esta magia para criar um disfarce, você recebe +10 no teste de Enganação.", "1 hora", "nenhum", "nenhum", null, Magia.Descritor.TRANSMUTACAO);

            Magia magia19 = new Magia ("Amaldiçoar Água", (byte)1, "1 frasco de água", "toque", Magia.TipoMagia.DIVINA, "1 minuto", " Esta magia imbui um frasco de água com energia negativa, transformando-a em água profana. Água profana causa dano a espíritos Bondosos da mesma forma que água benta causa dano a espíritos Malignos. Componente material: 2,5kg de prata em pó (que valem 25 TO).", "instantânea", "nenhum", "nenhum", null, Magia.Descritor.NECROMANCIA);

            Magia magia20 = new Magia ("Âncora Dimensional", (byte)4, "nenhum", "30m", Magia.TipoMagia.DIVINA, "Ação Padrão", " Você dispara pela mão um raio esverdeado. Faça um ataque de toque à distância. Se acertar, o alvo é envolvido por um campo de força cor de esmeralda que impede qualquer movimento planar. Isso inclui todas as magias de invocação (como porta dimensional, teletransporte e viagem planar), além de viagens astrais, etéreas ou pelo Plano das Sombras.", "10 minutos", "nenhum", "raio", null, Magia.Descritor.ABJURACAO);

            Magia magia21 = new Magia ("Âncora Dimensional", (byte)4, "nenhum", "30m", Magia.TipoMagia.ARCANA, "Ação Padrão", " Você dispara pela mão um raio esverdeado. Faça um ataque de toque à distância. Se acertar, o alvo é envolvido por um campo de força cor de esmeralda que impede qualquer movimento planar. Isso inclui todas as magias de invocação (como porta dimensional, teletransporte e viagem planar), além de viagens astrais, etéreas ou pelo Plano das Sombras.", "10 minutos", "nenhum", "raio", null, Magia.Descritor.ABJURACAO);



            magiaBox.put(magia1,magia2,magia3,magia4,magia5,magia6,magia7,magia8,magia9,magia10,magia11,magia12,magia13,magia14,magia15,magia16,magia17,magia18,magia19,magia20,magia21);

            Raca raca;
            Map<Habilidade, Byte> modHabilidades = new HashMap<>();
            modHabilidades.put(new Habilidade(Habilidades.CONSTITUICAO), (byte) 2);
            modHabilidades.put(new Habilidade(Habilidades.CARISMA), (byte) -2);
            modHabilidades.put(new Habilidade(Habilidades.DESTREZA), (byte) 4);
            raca = new Raca(getString(R.string.goblin), modHabilidades, (byte) 9, TamanhoRaca.PEQUENA);

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

        Talento talento1 = new Talento("Acelerar Habilidade", GrupoDeTalento.DESTINO,"Benefício: Você pode usar a habilidade especial escolhida como uma ação livre, três vezes por dia (ou menos, caso a habilidade original só possa ser usada uma ou duas vezes por dia). " +
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

        Talento talento0 = new Talento("Acrobacia Audaz", GrupoDeTalento.PERICIA,"Benefício: você pode atravessar terrenos difíceis sem sofrer redução em seu deslocamento. Você pode realizar investidas mesmo nessas condições. "+
                "Normal: um personagem em terreno difícil tem seu deslocamento reduzido à metade, e não pode realizar investidas."
                ,"treinado em Acrobacia");

        Talento talento01 = new Talento("Acrobático", GrupoDeTalento.PERICIA,"Benefício: você pode rolar outra vez um teste de Acrobacia que tenha recém realizado. Você deve aceitar a segunda rolagem, mesmo que seja pior do que a primeira.");

        Talento talento10 = new Talento("Acuidade com Arma", GrupoDeTalento.COMBATE, "Benefício: quando usa itensDef de corpo-a-corpo leves, você " +
                "pode usar seu modifi cador de Destreza em vez de Força em jogadas de ataque. Se estiver usando este talento e um escudo, aplique " +
                "a penalidade de armadura do escudo em jogadas de ataque.", " Des 13");
        Talento talento11 = new Talento("Agarrar Aprimorado", GrupoDeTalento.COMBATE, "Benefício: você recebe +4 em jogadas de ataque para agarrar", " For 13, Ataque Desarmado Aprimorado");

        Talento talento12 = new Talento("Apanhar Objetos", GrupoDeTalento.COMBATE, "Benefício: quando usa o talento Desviar Objetos, você pode " +
                "apanhar a arma ao invés de apenas desviá-la. Armas de arremesso " +
                "podem ser atiradas de volta ao oponente como uma reação.", "Des 15, Ataque Desarmado Aprimorado, " +
                "Desviar Objetos.");

        Talento talento13 = new Talento("Aparar ", GrupoDeTalento.COMBATE, "Benefício:uma vez por rodada, você pode tentar aparar um " +
                "ataque que iria atingi-lo. Faça uma jogada de ataque. Se o resultado " +
                "da sua jogada for maior que a do oponente, você evita o ataque.", " Des 15, Acuidade com Arma, Especialização " +
                "em Combate, bônus base de ataque +6.");

        Talento talento14 = new Talento("Aparência Inofensiva", GrupoDeTalento.COMBATE, "Benefício: a primeira criatura inteligente (Int 3 ou mais) que " +
                "atacar você em um combate deve fazer um teste de Intuição (CD " +
                "10 + metade do seu nível + seu modifi cador de Carisma). Se falhar, " +
                "perderá sua ação. Este talento só funciona uma vez por combate; " +
                "isto é, independente da criatura falhar ou não no teste, poderá " +
                "atacar você normalmente nas rodadas seguintes.", " Car 13.");

        Talento talento15 = new Talento("Ataque Atordoante ", GrupoDeTalento.COMBATE, "Benefício: declare que está usando este talento antes de fazer " +
                "um ataque desarmado. Se você acertar o ataque, além de sofrer o " +
                "dano normal, a vítima deve fazer um teste de Fortitude (CD 10 + " +
                "metade do seu nível + modifi cador de Sabedoria). Se falhar, fi ca " +
                "atordoada por uma rodada. " +
                "Você pode usar este talento um número de vezes por dia igual " +
                "a 1 + seu modifi cador de Sabedoria. Criaturas imunes a acertos " +
                "críticos não podem ser atordoadas.", " Sab 13, Ataque Desarmado Aprimorado.");
        Talento talento16 = new Talento("Ataque com Escudo Aprimorado ", GrupoDeTalento.COMBATE, "Benefício: quando você ataca com o escudo, mantém seu bônus na CA.", "Usar Escudo.");
        Talento talento17 = new Talento("Ataque Desarmado Aprimorado", GrupoDeTalento.COMBATE, "Benefício: seus ataques desarmados causam 1d4 pontos de " +
                "dano, e podem causar dano letal ou não-letal (à sua escolha)");
        Talento talento18 = new Talento("Ataque Duplo", GrupoDeTalento.COMBATE, "Benefício: quando faz um ataque com a arma escolhida, você " +
                "pode fazer um ataque adicional na mesma ação padrão, mas sofre " +
                "penalidade de –5 em ambas as jogadas de ataque.", ": Foco em Arma com a arma escolhida, bônus " +
                "base de ataque +6.");
        Talento talento19 = new Talento("Ataque em Movimento", GrupoDeTalento.COMBATE, "Benefício: quando estiver atacando corpo-a-corpo, você pode " +
                "se mover antes e depois do ataque, desde que a distância total percorrida não seja maior que seu deslocamento. " +
                "Você não pode usar este talento se estiver de armadura pesada.", "Des 13, Esquiva, Mobilidade, bônus base de " +
                "ataque +4.");
        Talento talento20 = new Talento("Ataque Giratório", GrupoDeTalento.COMBATE, "Benefício: você pode fazer um ataque corpo- " +
                "-a-corpo contra cada oponente adjacente. Usar este " +
                "talento é uma ação completa.", "Des 13, Int 13, Esquiva, Mobilidade, Ataque em Movimento, Especialização em " +
                "Combate, bônus base de ataque +4.");
        Talento talento21 = new Talento("Ataque Poderoso ", GrupoDeTalento.COMBATE, "Benefício: declare que está usando este talento " +
                "antes de fazer um ataque corpo-a-corpo. Você sofre " +
                "uma penalidade de –2 na jogada de ataque, mas recebe +4 na jogada de dano.", "For 13.");
        Talento talento22 = new Talento("Ataque Preciso ", GrupoDeTalento.COMBATE, "Benefício: quando usa uma arma afetada pelo talento Acuidade com Arma, você " +
                "causa 1d6 pontos de dano adicional.", "Des 15, Acui dade com " +
                "Arma, Especialização em Combate, bônus " +
                "base de ataque +11.");
        Talento talento23 = new Talento("Ataque Sagaz", GrupoDeTalento.COMBATE, "Benefício: quando usa uma arma afetada pelo talento Acuidade com Arma, você soma seu modifi cador de Inteligência (além " +
                "do modifi cador de Força) em jogadas de dano.", "Pré-requisitos: Int 13, Acuidade com Arma, bônus base de " +
                "ataque +4.");
        Talento talento24 = new Talento("Atropelar Aprimorado", GrupoDeTalento.COMBATE, "Benefício: quando você realiza a manobra atropelar, o alvo " +
                "não pode escolher evitá-lo. Além disso, você recebe +4 em jogadas " +
                "de ataque para atropelar.", " For 13, Ataque Poderoso.");
        Talento talento25 = new Talento("Bloqueio Ambidestro ", GrupoDeTalento.COMBATE, "Benefício: quando estiver usando duas itensDef ou uma arma " +
                "dupla, você recebe +1 na classe de armadura.", " Des 15, Combater com Duas Armas.");
        Talento talento26 = new Talento("Casca Grossa ", GrupoDeTalento.COMBATE, "Benefício: você soma seu bônus de Constituição na CA. Este " +
                "bônus não é cumulativo com armaduras.", "Con 13.");
        Talento talento27 = new Talento("Combate Montado ", GrupoDeTalento.COMBATE, "Benefício: uma vez por rodada, você pode tentar desviar um " +
                "ataque que iria atingir sua montaria. Faça um teste de Cavalgar. Se " +
                "o resultado for maior que a jogada de ataque do oponente, você " +
                "evita o ataque.", " treinado em Cavalgar.");
        Talento talento28 = new Talento("Combater com Duas Armas ", GrupoDeTalento.COMBATE, "Benefício: se estiver usando uma arma de uma mão e uma " +
                "arma leve, ou duas itensDef leves, você pode fazer dois ataques com " +
                "a mesma ação padrão, um com cada uma. No entanto, você sofre " +
                "penalidade de –4 em ambas as jogadas de ataque.", "Des 15.");
        Talento talento29 = new Talento("Combater Com " +
                "Duas Armas Aprimorado", GrupoDeTalento.COMBATE, "Benefício: usando o talento Combater com Duas Armas, sua " +
                "penalidade em jogadas de ataque diminui para –2.", "Des 17, Combater com Duas Armas, bônus " +
                "base de ataque +6.");
        Talento talento30 = new Talento("Combater Com " +
                "Duas Armas Maior ", GrupoDeTalento.COMBATE, "Benefício: usando o talento Combater com Duas Armas, " +
                "você não sofre nenhuma penalidade em jogadas de ataque.", " Des 19, Combater Com Duas Armas, Combater Com Duas Armas Aprimorado, bônus base de ataque +11.");
        Talento talento31 = new Talento("Derrubar Aprimorado", GrupoDeTalento.COMBATE, "+4 em testes de derrubar.", "Int 13, Especialização em Combate.");
        Talento talento32 = new Talento("Desarmar Aprimorado ", GrupoDeTalento.COMBATE, "Benefício: +4 em testes de desarmar.", " Int 13, Especialização em Combate.");
        Talento talento33 = new Talento("Desviar Objetos ", GrupoDeTalento.COMBATE, "Benefício: você pode tentar desviar um ataque à distância " +
                "que iria atingi-lo. Faça um teste de Refl exos. Se o resultado do " +
                "seu teste for maior que a jogada de ataque do oponente, você " +
                "evita o ataque. " +
                "Você só pode usar este talento se estiver com uma mão livre. " +
                "Armas muito grandes (como pedras de catapulta) ou criadas por " +
                "magia não podem ser desviadas.", "Des 13, Ataque Desarmado Aprimorado.");
        Talento talento34 = new Talento("Duro de Matar ", GrupoDeTalento.COMBATE, "Benefício: quando você sofre dano que poderia levá-lo a 0 " +
                "ou menos pontos de vida, você pode ignorar completamente esse " +
                "dano. Você pode usar este talento uma vez por dia.");
        Talento talento35 = new Talento("Empunhadura Poderosa ", GrupoDeTalento.COMBATE, "Benefício: ao usar itensDef uma categoria de tamanho acima da " +
                "sua, sua penalidade cai para –2.", " For 17.");
        Talento talento36 = new Talento("Empurrar Aprimorado ", GrupoDeTalento.COMBATE, "Benefício: +4 em jogadas de ataque para empurrar. ", "Força 13, Ataque Poderoso.");
        Talento talento37 = new Talento("Especialização em Arma ", GrupoDeTalento.COMBATE, "Benefício: usando a arma escolhida, você recebe +2 em jogadas de dano", " Foco em Arma com a arma escolhida, guerreiro 4º nível.");
        Talento talento38 = new Talento("Especialização em " +
                "Arma Aprimorada", GrupoDeTalento.COMBATE, " seu bônus no dano pelo talento Especialização em " +
                "Arma aumenta para +4.", " Foco em Arma, Foco em Arma Aprimorado, " +
                "Especialização em Arma com a arma escolhida, guerreiro 12º nível.");
        Talento talento39 = new Talento("Especialização em Armadura ", GrupoDeTalento.COMBATE, "Benefício: quando usando uma armadura do tipo escolhido, " +
                "você recebe redução de dano 2.", "Foco em Armadura do tipo escolhido, guerreiro 8º nível.");
        Talento talento40 = new Talento("Especialização em Combate ", GrupoDeTalento.COMBATE, "Benefício: declare que está usando este talento antes de fazer " +
                "um ataque corpo-a-corpo. Você sofre –2 na jogada de ataque, mas " +
                "recebe +4 na classe de armadura até o próximo turno.", " Int 13. ");
        Talento talento41 = new Talento("Esquiva", GrupoDeTalento.COMBATE, "Benefício: você recebe CA+1. ", " Des 13.");
        Talento talento42 = new Talento("Fintar Aprimorado ", GrupoDeTalento.COMBATE, "Benefício: você pode realizar um teste de Enganação para fi ntar em combate usando uma ação de movimento.", " Int 13, Especialização em Combate.");
        Talento talento43 = new Talento("Flerte Estratégico ", GrupoDeTalento.COMBATE, "Benefício: faça uma fi nta em combate contra um inimigo " +
                "que possa se sentir fi sicamente atraído por você. Se for bem-sucedido, sua vítima fi ca embaraçada e sofre penalidade de –2 em jogadas " +
                "e testes até o fi m do combate.", " Car 13, Fintar Aprimorado.");

        Talento talento44 = new Talento("Foco em Arma Aprimorado ", GrupoDeTalento.COMBATE, "Benefício: o bônus que você recebe pelo talento Foco em " +
                "Arma aumenta para +2.", " Foco em Arma com a arma escolhida, guerreiro 8º nível.");
        Talento talento45 = new Talento("Foco em Armadura", GrupoDeTalento.COMBATE, "Benefício: quando usando uma armadura do tipo escolhido, " +
                "você aumenta seu bônus de armadura em +1 e diminui sua penalidade de armadura em –1.", " saber usar o tipo de armadura escolhido.");
        Talento talento46 = new Talento("Golpe com Duas Mãos ", GrupoDeTalento.COMBATE, "Benefício: quando usando uma arma de corpo-a-corpo com " +
                "as duas mãos, você soma o dobro de seu modifi cador de Força às " +
                "jogadas de dano. Este talento não pode ser usado com itensDef leves. ", " For 15, Ataque Poderoso.");
        Talento talento47 = new Talento("Granadeiro", GrupoDeTalento.COMBATE, "Benefício: você recebe +2 em jogadas de ataque e dano com " +
                "quaisquer itensDef que permitem um teste de Refl exos para reduzir " +
                "seu efeito, como fogo alquímico e granadas.", " treinado em Ofício (alquimia).");
        Talento talento48 = new Talento("Insulto Sagaz ", GrupoDeTalento.COMBATE, "Benefício: faça uma fi nta em combate. Se for bem-sucedido, " +
                "seu oponente fi ca enfurecido e sofre uma penalidade de –2 na CA " +
                "até o fi m do combate.", ": Car 13, Fintar Aprimorado.");
        Talento talento49 = new Talento("Investida Implacável ", GrupoDeTalento.COMBATE, "Benefício: quando está montado e faz uma investida, você " +
                "causa dano dobrado com uma arma comum, ou triplicado com " +
                "uma lança.", "treinado em Cavalgar, Combate Montado, " +
                "Investida Montada");
        Talento talento50 = new Talento("Investida Montada ", GrupoDeTalento.COMBATE, "Benefício: quando está montado e faz uma investida, você " +
                "pode continuar se movendo depois do ataque. Você deve continuar " +
                "se movendo em linha reta, e seu movimento total na rodada não " +
                "pode ser superior ao dobro do deslocamento da montaria.", " treinado em Cavalgar, Combate Montado.");
        Talento talento51 = new Talento("Lutar às Cegas ", GrupoDeTalento.COMBATE, "Benefício: sempre que você erra um ataque devido a camufl agem, pode rolar mais uma vez a chance de acertar. Além disso, você " +
                "não fi ca desprevenido contra inimigos que não possa ver.");
        Talento talento52 = new Talento("Mestre em Arma ", GrupoDeTalento.COMBATE, "Benefício: usando a arma escolhida, você recebe +1 em jogadas de ataque e dano, e sua margem de ameaça aumenta em 1. " +
                "Além disso, uma vez por dia, você pode rolar outra vez uma jogada " +
                "de ataque que tenha recém realizado. Você deve aceitar a segunda " +
                "rolagem, mesmo que seja pior que a primeira.", "Especialização em Arma, Especialização em " +
                "Arma Aprimorada, Foco em Arma, Foco em Arma Aprimorado " +
                "(todos com a arma escolhida), guerreiro 16º nível.");
        Talento talento53 = new Talento("Mira Apurada ", GrupoDeTalento.COMBATE, "Benefício: você pode gastar uma ação de movimento para " +
                "mirar um alvo. Se fi zer isso, recebe +1 em jogadas de ataque à " +
                "distância realizadas contra ele na mesma rodada.", ": Sab 13, Tiro Certeiro, Tiro Longo");
        Talento talento54 = new Talento("Mira Mortal ", GrupoDeTalento.COMBATE, "Benefício: sua margem de ameaça com itensDef de projéteis " +
                "aumenta em 1. Por exemplo, a margem de ameaça da pistola é 19- " +
                "20; para um personagem com este talento, será 18-20.", "Des 17, Sab 13, Mira Apurada, Tiro Certeiro, " +
                "Tiro Longo, bônus base de ataque +11.");
        Talento talento55 = new Talento("Mobilidade", GrupoDeTalento.COMBATE, "Benefício: você recebe +2 na CA sempre que usa uma ação de " +
                "movimento para deslocar-se.", " Des 13, Esquiva. ");
        Talento talento56 = new Talento("Na Mosca ", GrupoDeTalento.COMBATE, "Benefício: você soma seu modifi cador de Destreza em jogadas de dano com itensDef de ataque à distância.", "Des 13, Tiro Certeiro, Tiro Preciso");
        Talento talento57 = new Talento("Panache", GrupoDeTalento.COMBATE, "Benefício: faça uma fi nta em combate. Se for bem-sucedido, " +
                "seu oponente fi ca espantado com a manobra, e no próximo turno " +
                "só pode realizar uma ação padrão.", "Car 13, Fintar Aprimorado.");
        Talento talento58 = new Talento("Perito em Arma ", GrupoDeTalento.COMBATE, "Benefício: graças a uma extrema habilidade com a arma, que " +
                "funciona como uma verdadeira extensão de seu corpo, você pode " +
                "substituir um teste de qualquer perícia por uma jogada de ataque " +
                "com a arma escolhida. Você pode, por exemplo, usar uma espada para " +
                "destrancar uma fechadura (Ladinagem), como suporte para subir em " +
                "algo (Atletismo), como apoio para uma cambalhota (Acrobacia), para " +
                "fazer manobras impressionantes (Atuação) e assim por diante.", ": Des 13, Int 13, Acuidade com Arma, Foco " +
                "em Arma com a arma escolhida.");
        Talento talento59 = new Talento("Pisotear", GrupoDeTalento.COMBATE, "Benefício: quando está montado e realiza a manobra atropelar, o alvo não pode escolher evitá-lo. Além disso, se a montaria " +
                "derrubar um oponente, pode fazer um ataque contra esse oponente " +
                "como uma ação livre (recebendo o bônus padrão de +4 em jogadas " +
                "de ataque contra oponentes caídos).", " treinado em Cavalgar, Combate Montado.");
        Talento talento60 = new Talento("Rapidez de Recarga ", GrupoDeTalento.COMBATE, "Benefício: a ação necessária para recarregar a arma " +
                "escolhida diminui em uma " +
                "categoria — ação completa " +
                "vira padrão, padrão vira de " +
                "movimento, e de movimento vira livre. Por exemplo, " +
                "recarregar um mosquete " +
                "normalmente é uma ação padrão, mas para um personagem com " +
                "este talento é uma ação de movimento.", "saber usar a arma escolhida.");
        Talento talento61 = new Talento("Reflexos de Combate ", GrupoDeTalento.COMBATE, "Benefício: se estiver adjacente a um oponente desprevenido, " +
                "você pode fazer um ataque corpo-a-corpo contra ele como uma " +
                "ação livre.", "Des 13.");
        Talento talento62 = new Talento("Saque Rápido ", GrupoDeTalento.COMBATE, "Benefício: você pode sacar ou guardar uma arma como uma " +
                "ação livre");
        Talento talento63 = new Talento("Separar Aprimorado ", GrupoDeTalento.COMBATE, "Benefício: você recebe +4 em jogadas de ataque para separar. " +
                "Além disso, você causa dano dobrado contra objetos.", "For 13, Ataque Poderoso.");
        Talento talento64 = new Talento("Tiro Certeiro ", GrupoDeTalento.COMBATE, "Benefício: você recebe +1 em jogadas de ataque e dano com " +
                "itensDef de ataque à distância contra alvos que estejam a até 9m.");
        Talento talento65 = new Talento("Tiro em Movimento ", GrupoDeTalento.COMBATE, "Benefício: quando estiver atacando à distância, você pode se " +
                "mover antes e depois do ataque, desde que a distância total percorrida não seja maior que seu deslocamento. " +
                "Você não pode usar este talento se estiver de armadura pesada", "Des 13, Esquiva, Mobilidade, Tiro Certeiro, " +
                "bônus base de ataque +4.");
        Talento talento66 = new Talento("Tiro Longo ", GrupoDeTalento.COMBATE, "Benefício: o incremento de distância de qualquer arma que você utiliza é dobrado.", "Tiro Certeiro");
        Talento talento67 = new Talento("Tiro Montado ", GrupoDeTalento.COMBATE, "Benefício: sua penalidade para ataques à distância quando sua montaria se movimenta é reduzida " +
                "para –2.", "treinado em Cavalgar, " +
                "Combate Montado.");
        Talento talento68 = new Talento("Tiro Múltiplo ", GrupoDeTalento.COMBATE, "Benefício: usando uma ação padrão e " +
                "uma arma de projéteis, você pode fazer dois " +
                "ataques contra um único oponente a até 9m. " +
                "Ambos usam a mesma jogada (com penalidade de –4) e causam dano normalmente.", "Des 17, Tiro Certeiro, " +
                "Tiro Rápido, bônus base de ataque +6.");
        Talento talento69 = new Talento("Tiro Preciso ", GrupoDeTalento.COMBATE, "Benefício: você pode fazer ataques à distância contra oponentes envolvidos em combate corpo-a-corpo sem sofrer a penalidade " +
                "de –4 na jogada de ataque.", " Tiro Certeiro");
        Talento talento70 = new Talento("Tiro Preciso Aprimorado ", GrupoDeTalento.COMBATE, "Benefício: seus ataques à distância ignoram cobertura e " +
                "camufl agem (exceto cobertura ou camufl agem totais). " +
                "Além disso, quando ataca um alvo envolvido na manobra agarrar, você acerta automaticamente o alvo " +
                "que escolheu.", "Des 19, Tiro Certeiro, Tiro Preciso, bônus " +
                "base de ataque +11.");
        Talento talento71 = new Talento("Tiro Rápido ", GrupoDeTalento.COMBATE, "Benefício: usando uma " +
                "arma de ataque à distância, " +
                "você pode fazer um ataque adicional. Se fi zer isso, sofre uma " +
                "penalidade de –2 em todas as jogadas de ataque. Usar este talento é " +
                "uma ação completa.", "Des 13, " +
                "Tiro Certeiro.");
        Talento talento72 = new Talento("Torcida", GrupoDeTalento.COMBATE, "Benefício: você recebe +1 em jogadas de " +
                "ataque, CA e testes de resistência quando tem " +
                "a torcida a seu favor, durante uma luta ou outro " +
                "tipo de disputa. Entenda-se por “torcida” qualquer " +
                "número de pessoas ou criaturas inteligentes (mesmo " +
                "que seja apenas uma!) que não está realizando nenhuma " +
                "outra ação além de ver a luta. Você só recebe este benefício quando a maioria das pessoas presentes na " +
                "cena está gritando seu nome ou torcendo " +
                "por sua vitória.", "Car 13");
        Talento talento73 = new Talento("Trespassar", GrupoDeTalento.COMBATE, "Benefício: quando você derruba um inimigo com um ataque " +
                "corpo-a-corpo (reduzindo seus PV para 0 ou menos), pode realizar " +
                "um ataque adicional contra outra criatura adjacente. " +
                "O ataque adicional usa os mesmos bônus de ataque e dano do " +
                "primeiro, mas os dados devem ser rolados novamente. Você pode " +
                "usar este talento uma vez por rodada.", "For 13, Ataque Poderoso.");
        Talento talento74 = new Talento("Trespassar Aprimorado ", GrupoDeTalento.COMBATE, "Benefício: você pode usar o talento Trespassar quantas vezes " +
                "quiser na mesma rodada.", "For 13, Ataque Poderoso, Trespassar, bônus " +
                "base de ataque +4.");
        Talento talento75 = new Talento("Usar Armas Simples ", GrupoDeTalento.COMBATE, "Benefício: você sabe usar itensDef simples. ");
        Talento talento76 = new Talento("Usar Armas Marciais ", GrupoDeTalento.COMBATE, "Benefício: você sabe usar itensDef marciais. ", "Usar Armas Simples.");
        Talento talento77 = new Talento("Usar Arma Exótica ", GrupoDeTalento.COMBATE, "Benefício: você sabe usar a arma escolhida. ", "Usar Armas Simples");
        Talento talento78 = new Talento("Usar Armaduras Leves ", GrupoDeTalento.COMBATE, "Benefício: você sabe usar armadura acolchoada, corselete de " +
                "couro, couro batido, camisa de cota de malha e outras armaduras leves.");
        Talento talento79 = new Talento("Usar Armaduras Médias", GrupoDeTalento.COMBATE, "Benefício: você sabe usar cota de escamas, cota de malha, " +
                "couraça, gibão de peles e outras armaduras médias.", "Usar Armaduras Leves");
        Talento talento80 = new Talento("Usar Armaduras Pesadas ", GrupoDeTalento.COMBATE, "Benefício: você sabe usar loriga segmentada, meia armadura, " +
                "armadura completa e outras armaduras pesadas.", "Usar Armaduras (leves, médias)");
        Talento talento81 = new Talento("Usar Escudos ", GrupoDeTalento.COMBATE, "Benefício: você sabe usar escudos leves e pesados. ");
        Talento talento82 = new Talento("Usar Venenos ", GrupoDeTalento.COMBATE, "Benefício: você pode aplicar veneno em itensDef sem risco de se " +
                "envenenar acidentalmente.", "treinado em Ofício (alquimia), tendência " +
                "não Bondosa.");
        Talento talento83 = new Talento("Vitalidade", GrupoDeTalento.COMBATE, "Benefício: você recebe 1 ponto de vida adicional por nível " +
                "de personagem. Quando sobe de nível, os PV que recebe por este " +
                "talento aumentam de acordo.");
        Talento talento84 = new Talento("Afinidade com Animais", GrupoDeTalento.PERICIA, "Benefício: você pode rolar outra vez um teste de Adestrar " +
                "Animais que tenha recém realizado. Você deve aceitar a segunda " +
                "rolagem, mesmo que seja pior que a primeira.");
        Talento talento85 = new Talento("Ágil", GrupoDeTalento.PERICIA, "Benefício: você pode usar seu modifi cador de Destreza em " +
                "vez de Força em testes de Atletismo.", " Des 15.");
        Talento talento86 = new Talento("Aptidão Mágica ", GrupoDeTalento.PERICIA, "Benefício: você pode rolar outra vez um teste de Identifi car " +
                "Magia que tenha recém realizado. Você deve aceitar a segunda rolagem, mesmo que seja pior que a primeira.");
        Talento talento87 = new Talento("Artista", GrupoDeTalento.PERICIA, "Benefício: você pode rolar outra vez um teste de Atuação que " +
                "tenha recém realizado. Você deve aceitar a segunda rolagem, mesmo que seja pior que a primeira.");
        Talento talento88 = new Talento("Atlético", GrupoDeTalento.PERICIA, "Benefício: você pode rolar outra vez um teste de Atletismo " +
                "que tenha recém realizado. Você deve aceitar a segunda rolagem, " +
                "mesmo que seja pior que a primeira.");
        Talento talento89 = new Talento("Autossuficiente", GrupoDeTalento.PERICIA, "Benefício: você não sofre a penalidade de –5 para fazer testes " +
                "de Cura em si mesmo, e recebe +4 nos testes de Sobrevivência se " +
                "estiver sozinho (sem nenhum aliado a até 18m).");
        Talento talento90 = new Talento("Criar Obra-Prima ", GrupoDeTalento.PERICIA, "Benefício: você pode construir itensDef, armaduras e kits de " +
                "ferramentas de qualidade obra-prima. Uma arma obra-prima fornece +1 em jogadas de ataque; uma armadura obra-prima tem sua " +
                "penalidade de armadura reduzida em 1; e um kit de ferramentas " +
                "obra-prima fornece +2 nos testes da perícia apropriada.", " treinado em Ofício, Foco em Perícia (Ofício).");
        Talento talento91 = new Talento("Dedos Ágeis ", GrupoDeTalento.PERICIA, "Benefício: você pode rolar outra vez um teste de Ladinagem " +
                "que tenha recém realizado. Você deve aceitar a segunda rolagem, " +
                "mesmo que seja pior que a primeira.");
        Talento talento92 = new Talento("Diligente", GrupoDeTalento.PERICIA, "Benefício: você pode gastar uma ação de movimento para se " +
                "concentrar na tarefa à frente. Se fi zer isso, recebe +2 nos testes de " +
                "perícia realizados até a próxima rodada.");
        Talento talento93 = new Talento("Foco em Perícia ", GrupoDeTalento.PERICIA, "Benefício: você recebe +4 em testes da perícia escolhida. ", " treinado na perícia escolhida.");
        Talento talento94 = new Talento("Fraudulento", GrupoDeTalento.PERICIA, "Benefício: você pode rolar outra vez um teste de Enganação " +
                "que tenha recém realizado. Você deve aceitar a segunda rolagem, " +
                "mesmo que seja pior que a primeira.");
        Talento talento95 = new Talento("Impostor", GrupoDeTalento.PERICIA, "Benefício: graças a seu extremo charme, magnetismo pessoal " +
                "e super confi ança, você consegue " +
                "convencer as pessoas (e também " +
                "a si próprio!) de que tem certas " +
                "habilidades ou conhecimentos, " +
                "quando na verdade não tem. " +
                "Você pode substituir um " +
                "teste de qualquer perícia por um " +
                "teste de Enganação. Você pode " +
                "usar este talento um número de " +
                "vezes por dia igual a seu bônus " +
                "de Carisma.", " Car 13, Foco em Perícia (Enganação)");
        Talento talento96 = new Talento("Iniciativa " +
                "Aprimorada", GrupoDeTalento.PERICIA, "Benefício: você pode rolar " +
                "outra vez um teste de Iniciativa que tenha recém realizado. " +
                "Você deve aceitar a segunda rolagem, mesmo que seja pior que " +
                "a primeira.");
        Talento talento97 = new Talento("Investigador", GrupoDeTalento.PERICIA, "Benefício: você pode somar seu bônus de Inteligência a testes " +
                "de Obter Informação e testes de Percepção para procurar.", "Int 13");
        Talento talento98 = new Talento("Negociador", GrupoDeTalento.PERICIA, "Benefício: quando você chega a uma comunidade, faça um " +
                "teste de Ofício (CD 20). Se tiver sucesso, você pode comprar itens " +
                "nesta comunidade por 75% do preço padrão (arredondado para " +
                "baixo). Por exemplo, você pode comprar uma armadura completa " +
                "(que normalmente custa 1.500 TO) por 1.125 TO. " +
                "Se falhar, você pode tentar novamente em um mês (ou quando visitar outra comunidade).", "treinado em Ofício");
        Talento talento99 = new Talento("Persuasivo", GrupoDeTalento.PERICIA, "Benefício: você pode rolar outra vez um teste de Diplomacia que tenha recém realizado. " +
                "Você deve aceitar a segunda " +
                "rolagem, mesmo que seja pior " +
                "que a primeira.");
        Talento talento100 = new Talento("Prontidão", GrupoDeTalento.PERICIA, "Benefício: você pode " +
                "rolar outra vez um teste de " +
                "Percepção que tenha recém " +
                "realizado. Você deve aceitar a " +
                "segunda rolagem, mesmo que " +
                "seja pior que a primeira.");
        Talento talento101 = new Talento("Rastrear", GrupoDeTalento.PERICIA, "Benefício: você pode " +
                "fazer testes de Sobrevivência " +
                "para encontrar rastros. A difi - " +
                "culdade varia de acordo com o " +
                "solo — CD 10 para solo macio " +
                "(neve, lama), 15 para solo padrão (grama, terra) e 20 para solo duro (rocha ou " +
                "piso de interiores). " +
                "Você ganha +1 para cada três criaturas no grupo sendo seguido. Você sofre uma penalidade de –1 para cada dia " +
                "desde a criação dos rastros e uma penalidade de –5 em visibilidade " +
                "precária (noite, chuva, neblina). Você precisa fazer um teste para " +
                "encontrar os rastros e mais um para cada dia de perseguição. " +
                "Se falhar você pode tentar novamente gastando mais um dia " +
                "(mas lembre-se de que a CD aumenta a cada dia).", " treinado em " +
                "Sobrevivência");
        Talento talento102 = new Talento("Senso da Natureza ", GrupoDeTalento.PERICIA, "Benefício: você pode rolar outra vez um teste de Sobrevivência que tenha recém realizado. Você deve aceitar a segunda rolagem, mesmo que seja pior que a primeira");
        Talento talento103 = new Talento("Sorrateiro", GrupoDeTalento.PERICIA, "Benefício: você pode rolar outra vez um teste de Furtividade " +
                "que tenha recém realizado. Você deve aceitar a segunda rolagem, " +
                "mesmo que seja pior que a primeira.");
        Talento talento104 = new Talento("Treino em Perícia ", GrupoDeTalento.PERICIA, "Benefício: você se torna treinado na perícia escolhida. ");
        Talento talento105 = new Talento("Acelerar Magia [metamágico]   ", GrupoDeTalento.MAGIA, "Benefício: quando você usa este talento, pode lançar uma " +
                "magia como uma ação livre. Lançar uma magia acelerada não deixa você desprevenido. " +
                "Você só pode usar este talento uma vez por rodada. Magias " +
                "com um tempo de execução maior que uma ação completa não são " +
                "afetadas por este talento.");
        Talento talento106 = new Talento("Ampliar Magia [metamágico]", GrupoDeTalento.MAGIA, "Benefício: quando você usa este talento, a área da magia é " +
                "duplicada (por exemplo, uma bola de fogo ampliada tem 12m de " +
                "raio, em vez de 6m). " +
                "Magias sem área de efeito não são afetadas por este talento.");
        Talento talento107 = new Talento("Aumentar Magia [metamágico] ", GrupoDeTalento.MAGIA, "Benefício: quando você usa este talento, o alcance da magia é " +
                "duplicado (por exemplo, um relâmpago aumentado tem um alcance de 90m, em vez de 45m). " +
                "Magias sem alcance medido em metros não podem ser afetadas por este talento.");
        Talento talento108 = new Talento("Conhecimento Mágico", GrupoDeTalento.MAGIA, "Benefício: você aprende mais duas magias de quaisquer níveis " +
                "que possa lançar. Por exemplo, se você é um mago de 3º nível, " +
                "pode aprender duas magias novas de 1º ou 2º nível.");
        Talento talento109 = new Talento("Contramágica Aprimorada ", GrupoDeTalento.MAGIA, "Benefício: você pode usar qualquer magia como contramágica, desde que seu custo em PM seja igual ou superior ao custo " +
                "da magia que você quer anular.");
        Talento talento110 = new Talento("Dominar Magia ", GrupoDeTalento.MAGIA, "Benefício: o custo em PM para lançar a magia escolhida diminui em 1. O custo fi nal (após aplicar todos os modifi cadores, " +
                "incluindo este talento e talentos metamágicos) é no mínimo 1 PM.");
        Talento talento111 = new Talento("Elevar Magia [metamágico] ", GrupoDeTalento.MAGIA, "Benefício: uma magia elevada tem um nível de magia mais " +
                "alto que o normal (até um máximo de 9º nível). Diferente de outros talentos metamágicos, Elevar Magia aumenta verdadeiramente o nível da magia. Todos os efeitos dependentes de nível (como " +
                "CD para resistir) são calculados de acordo com o nível elevado");
        Talento talento112 = new Talento("Estender Magia [metamágico] ", GrupoDeTalento.MAGIA, "Benefício: a duração da magia é duplicada (por exemplo, um " +
                "imobilizar pessoa estendido dura 2 minutos, em vez de 1 min). " +
                "Magias com duração instantânea, permanente ou concentração não podem ser afetadas por este talento.");
        Talento talento113 = new Talento("Familiar", GrupoDeTalento.MAGIA, "Benefício: você recebe a habilidade familiar do mago. Consulte a descrição da classe mago para mais detalhes.", " capacidade de lançar magias arcanas.");
        Talento talento114 = new Talento("Foco em Magia ", GrupoDeTalento.MAGIA, "Benefício: a difi culdade do teste de resistência contra a magia " +
                "escolhida aumenta em CD+2.");
        Talento talento115 = new Talento("Foco em Magia Aprimorado ", GrupoDeTalento.MAGIA, "Benefício: o aumento de difi culdade oferecido pelo talento " +
                "Foco em Magia aumenta para CD+4.", "Foco em Magia com a magia escolhida.");
        Talento talento116 = new Talento("Magia Natural ", GrupoDeTalento.MAGIA, " Benefício: você pode lançar magias quando está na forma " +
                "selvagem.", "Sab 13, habilidade de forma selvagem.");
        Talento talento117 = new Talento("Magia Sem Gestos [metamágico] ", GrupoDeTalento.MAGIA, "Benefício: uma magia sem gestos pode ser lançada sem nenhum componente gestual.");
        Talento talento118 = new Talento("Magia Silenciosa [metamágico] ", GrupoDeTalento.MAGIA, "Benefício: uma magia silenciosa pode ser lançada sem nenhum componente verbal.");
        Talento talento119 = new Talento("Magias em Combate ", GrupoDeTalento.MAGIA, "Benefício: você não fi ca desprevenido quando lança uma " +
                "magia");
        Talento talento120 = new Talento("Mago de Batalha ", GrupoDeTalento.MAGIA, "Benefício: você soma seu modifi cador de Inteligência às jogadas de dano de suas magias.", " Int 13, Magias em Combate, mago 4º nível.");
        Talento talento121 = new Talento("Maximizar Magia [metamágico] ", GrupoDeTalento.MAGIA, "Benefício: quando você usa este talento, todos os efeitos numéricos variáveis da magia são aumentados ao máximo. Por exemplo, uma bola de fogo capaz de causar 6d6 pontos de dano, quando " +
                "maximizada, causará 36 pontos de dano (mais quaisquer bônus), " +
                "sem a necessidade de rolar dados. " +
                "Uma magia sem efeitos variáveis não pode ser afetada por este " +
                "talento. " +
                "Uma magia potencializada e maximizada adquire os benefícios separados de cada talento: o resultado máximo, mais metade " +
                "do resultado jogado normalmente");
        Talento talento122 = new Talento("Poder Mágico ", GrupoDeTalento.MAGIA, "Benefício: você recebe 1 ponto de magia adicional.");
        Talento talento123 = new Talento("Potencializar Invocação", GrupoDeTalento.MAGIA, "Benefício: as criaturas que você invoca com as magias invocar " +
                "recebem +2 em suas jogadas de ataque e dano.");
        Talento talento124 = new Talento("Potencializar Magia [metamágico] ", GrupoDeTalento.MAGIA, "Benefício: quando você usa este talento, todos os efeitos numéricos variáveis da magia são aumentados em 50%. Por exemplo, " +
                "um relâmpago capaz de causar 6d6 pontos de dano, após rolar 21, " +
                "causa mais 50% (neste caso, 10), para um total de 31 pontos de " +
                "dano. Quaisquer bônus que você tenha também são potencializados. " +
                "Uma magia sem efeitos variáveis não pode ser afetada por " +
                "este talento. " +
                "Uma magia potencializada e maximizada adquire os benefícios separados de cada talento: o resultado máximo, mais metade " +
                "do resultado jogado normalmente.");
        Talento talento125 = new Talento("Ajuda dos Ancestrais ", GrupoDeTalento.DESTINO, "Benefício: você pode lançar a magia adivinhação uma vez por " +
                "dia, sem gastar pontos de magia.", " Sab 13.");
        Talento talento126 = new Talento("Ao Sabor do Destino ", GrupoDeTalento.DESTINO, "Benefício: você recebe os seguintes benefícios, de acordo " +
                "com seu nível de personagem. Caso adquira este talento depois " +
                "do 5º nível, você recebe todos os benefícios dos níveis anteriores. 5º +1 em jogadas de ataque e dano. " +
                "6º +4 em uma perícia à sua escolha. " +
                "7º +1 na CA. " +
                "8º +2 em uma habilidade à sua escolha (cumulativo). " +
                "9º +1 nos testes de resistência. " +
                "10º +2 em jogadas de ataque e dano. " +
                "11º +4 em uma perícia à sua escolha. " +
                "12º +2 na CA. " +
                "13º +2 em uma habilidade à sua escolha (cumulativo). " +
                "14º +2 nos testes de resistência. " +
                "15º +3 em jogadas de ataque e dano. " +
                "16º +4 em uma perícia à sua escolha. " +
                "17º +3 na CA. " +
                "18º +2 em uma habilidade à sua escolha (cumulativo). " +
                "19º +3 nos testes de resistência. " +
                "20º +4 em jogadas de ataque e dano.", " Car 13, personagem 5º nível.");
        Talento talento127 = new Talento("Atraente", GrupoDeTalento.DESTINO, " você recebe +4 nos testes de Diplomacia e Enganação " +
                "contra qualquer um que possa se sentir fi sicamente atraído por você.");

        Talento talento128 = new Talento("Comandar", GrupoDeTalento.DESTINO, "Benefício: você pode usar uma ação padrão para gritar ordens " +
                "para seus aliados. Aqueles que puderem ouvi-lo recebem +1 em " +
                "suas jogadas e testes por um número de rodadas igual a 1 + seu " +
                "modifi cador de Carisma.");

        Talento talento129 = new Talento("Corrida", GrupoDeTalento.DESTINO, "Benefício: seu deslocamento aumenta em +3m. ");

        Talento talento130 = new Talento("Devoto", GrupoDeTalento.DESTINO, "Benefício: escolha uma magia divina de nível 0. Você pode " +
                "lançar esta magia até três vezes por dia, como se fosse um clérigo.", " Sab 11, estar entre os adoradores típicos do " +
                "deus escolhido (veja em “Deuses”, no Capítulo 6).");

        Talento talento131 = new Talento("Estudioso Arcano", GrupoDeTalento.DESTINO, "Benefício: escolha uma magia arcana de nível 0. Você pode " +
                "lançar esta magia até três vezes por dia, como se fosse um mago.", " Int 11.");

        Talento talento132 = new Talento("Expulsão Aprimorada", GrupoDeTalento.DESTINO, "Benefício: a difi culdade do teste de Vontade contra o talento " +
                "Expulsar/Fascinar Mortos-Vivos aumenta em CD+2.", " Expulsar/Fascinar Mortos-Vivos");

        Talento talento133 = new Talento("Expulsar/Fascinar Mortos-Vivos ", GrupoDeTalento.DESTINO, "Benefício: este talento afeta todos os mortos-vivos a até 9m. " +
                "Se você canaliza energia positiva, pode deixá-los apavorados durante um minuto. Se canaliza energia negativa, pode deixá-los sob " +
                "seu comando. Dar uma ordem aos mortos-vivos é uma ação de " +
                "movimento. O nível somado de mortos-vivos sob seu comando " +
                "não pode exceder seu próprio nível. " +
                "Mortos-vivos têm direito a um teste de Vontade (CD 10 + " +
                "metade de seu nível + modifi cador de Carisma) para evitar qualquer destes efeitos. " +
                "Usar este talento é uma ação padrão, e gasta uma utilização " +
                "diária da habilidade canalizar energia positiva/negativa.", "habilidade de canalizar energia positiva/ " +
                "negativa.");

        Talento talento134 = new Talento("Fortitude Maior ", GrupoDeTalento.DESTINO, "Benefício: seu bônus base de Fortitude aumenta +2. ");

        Talento talento135 = new Talento("Liderança", GrupoDeTalento.DESTINO, "Benefício: escolha entre ter um parceiro, ou ter seguidores.Um parceiro é um segundo personagem, dois níveis abaixo " +
                "do seu. Você é livre para construir esse personagem, escolhendo " +
                "sua raça e classe — mas a tendência do parceiro deve estar apenas " +
                "um passo distante da sua. O parceiro avança de nível quando você " +
                "também avança. " +
                "Um parceiro é alguém leal, que segue seu personagem por " +
                "razões pessoais. Ele segue suas ordens, e pode até arriscar a vida " +
                "para ajudá-lo. Mas um parceiro constantemente maltratado pode " +
                "— por intervenção do mestre — desistir de segui-lo. " +
                "Se escolheu seguidores, você tem uma quantidade de níveis " +
                "de seguidores igual a seu nível multiplicado por seu modifi cador " +
                "de Carisma (mínimo 1). Por exemplo, um paladino de 10º nível e " +
                "Carisma 16 (+3) tem 30 níveis de seguidores. Você pode distribuir " +
                "os níveis como quiser para construir os personagens, mas o nível " +
                "máximo que eles podem ter é igual a metade do seu. Então, o mesmo paladino poderia ter seguidores de até 5º nível. Essa diferença " +
                "de poder torna os seguidores inefi cazes em combate. Em geral eles " +
                "atuam apenas contra adversários fracos, ou então como ajudantes, " +
                "guardas, mensageiros, carregadores... " +
                "Seguidores podem ser de qualquer tendência, mas não costumam ser tão leais ou corajosos quanto parceiros. Podem lutar se " +
                "ordenados, mas abandonam a luta se perdem metade ou mais de " +
                "seus pontos de vida. Seguidores não sobem de nível; quando você " +
                "sobe de nível, ganha mais seguidores. " +
                "Ao perder parceiros ou seguidores (por morte ou desistência), " +
                "você vai precisar de 1d4 meses para encontrar outros", "personagem 6º nível.");

        Talento talento136 = new Talento("Linguista", GrupoDeTalento.DESTINO, "Benefício: você aprende um número de novos idiomas igual " +
                "a 3 + seu modifi cador de Inteligência (mínimo 1). ");

        Talento talento137 = new Talento("Reflexos Rápidos ", GrupoDeTalento.DESTINO, "Benefício: seu bônus base de Refl exos aumenta +2. ");

        Talento talento138 = new Talento("Surto Heroico ", GrupoDeTalento.DESTINO, "Benefício: você pode realizar uma ação padrão ou de movimento adicional na rodada. Por exemplo, pode realizar uma ação " +
                "completa e uma ação padrão, ou uma ação padrão e duas ações de " +
                "movimento, ou qualquer outra combinação. " +
                "Você pode usar este talento uma vez por dia", "tendência Bondosa.");

        Talento talento139 = new Talento("Terreno Familiar", GrupoDeTalento.DESTINO, "Benefício: você recebe +2 na classe de armadura e testes " +
                "de Acrobacia, Atletismo, Furtividade, Percepção e Sobrevivência " +
                "quando estiver no tipo de terreno escolhido.");

        Talento talento140 = new Talento("Tolerância", GrupoDeTalento.DESTINO, "Benefício: você recebe +4 em testes de Constituição para " +
                "prender o fôlego e evitar dano por fome ou sede, e em testes de " +
                "Fortitude para evitar dano por frio ou calor. Você também pode " +
                "dormir de armadura sem fi car fatigado.");

        Talento talento141 = new Talento("Vontade de Ferro ", GrupoDeTalento.DESTINO, "Benefício: seu bônus base de Vontade aumenta +2. ");

        Talento talento142 = new Talento("Domínio da Água ",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: você está permanentemente sob efeito da magia " +
                "respirar na água","devoto de Oceano ou Wynna.");
        Talento talento143 = new Talento("Domínio dos Animais ",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: você está permanentemente sob efeito da magia " +
                "falar com animais. Além disso, Sobrevivência é uma perícia de classe para você."," devoto de Allihanna, Megalokk ou Oceano.");
        Talento talento144 = new Talento("Domínio do Ar ",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: você está permanentemente sob efeito da magia " +
                "queda suave.","devoto de Oceano ou Wynna.");
        Talento talento145 = new Talento("Domínio do Bem ",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: para criaturas de tendência Maligna, a difi culdade " +
                "para resistir às suas magias divinas aumenta em CD+1."," devoto de Allihanna, Azgher, Khalmyr, Lena, " +
                "Marah ou Valkaria.");
        Talento talento146 = new Talento("Domínio do Caos ",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: para criaturas de tendência Leal, a difi culdade para " +
                "resistir às suas magias divinas aumenta em CD+1.","devoto de Hyninn ou Nimb.");
        Talento talento147 = new Talento("Domínio do Conhecimento ",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: você pode fazer testes de qualquer Conhecimento " +
                "como se fosse treinado, com um bônus igual a seu nível + modifi - " +
                "cador de Inteligência."," devoto de Kallyadranoch, Sszzaas, Tanna-Toh " +
                "ou Th yatis");
        Talento talento148 = new Talento("Domínio da Cura ",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: suas magias de cura curam 1 PV adicional por nível da magia. Por exemplo, curar ferimentos moderados (uma magia " +
                "de 2º nível) cura 2 PV adicionais."," devoto de Allihanna, Lena, Marah ou Th yatis");
        Talento talento149 = new Talento("Domínio da Destruição ",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: você recebe +1 em jogadas de dano corpo-a-corpo.","devoto de Kallyadranoch, Keenn, Mega lokk " +
                "ou Ragnar.");
        Talento talento150 = new Talento("Domínio da Enganação ",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: Enganação, Furtividade e Ladinagem passam a ser " +
                "perícias de classe para você."," devoto de Hyninn ou Sszzaas. ");
        Talento talento151 = new Talento("Domínio do Fogo ",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: uma vez por dia, como uma ação livre, você pode " +
                "receber um bônus igual ao seu nível na Força por uma rodada."," devoto de Keenn ou Tauron.");
        Talento talento152 = new Talento("Domínio da Guerra ",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: você recebe os talentos Usar Arma e Foco em " +
                "Arma, apenas para a arma predileta de sua divindade"," devoto de Keenn, Khalmyr, Lin-Wu, Ragnar, " +
                "Tauron ou Valkaria.");
        Talento talento153 = new Talento("Domínio da Magia ",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: uma vez por dia, você pode lançar qualquer magia que conheça sem gastar pontos de magia. Você também pode " +
                "aplicar efeitos de talentos metamágicos que possua a essa magia, " +
                "mas nesse caso deverá pagar o custo extra exigido pelo(s) talento(s).","devoto de Kallyadranoch ou Wynna.");
        Talento talento154 = new Talento("Domínio do Mal ",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: para criaturas de tendência Bondosa, a difi culdade " +
                "para resistir às suas magias divinas aumenta em CD+1. "," devoto de Kallyadranoch, Keenn, Megalokk, " +
                "Ragnar, Sszzaas ou Tenebra.");
        Talento talento155 = new Talento("Domínio da Morte ",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: uma vez por dia, você pode usar o toque da morte. " +
                "Faça um ataque de toque desarmado. Se você acertar, role 1d6 por " +
                "nível. Se o total igualar ou superar os pontos de vida do alvo, ele " +
                "morre (sem direito a teste de resistência). Caso contrário, o alvo " +
                "não sofre nada."," devoto de Ragnar, Sszzaas ou Tenebra.");
        Talento talento156 = new Talento("Domínio da Ordem ",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: para criaturas de tendência Caótica, a difi culdade " +
                "para resistir às suas magias divinas aumenta em CD+1.","devoto de Khalmyr, Lin-Wu, Tanna-Toh ou " +
                "Tauron.");
        Talento talento157 = new Talento("Domínio das Plantas ",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: você pode lançar a magia constrição três vezes por " +
                "dia, como um clérigo, sem gastar pontos de magia.","devoto de Allihanna, Lena, Megalokk ou Oceano.");
        Talento talento158 = new Talento("Domínio da Proteção ",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: uma vez por dia, com uma ação padrão, você pode " +
                "tocar um alvo e gerar um escudo de proteção que fornece um bônus igual a seu nível em testes de resistência. Por exemplo, se você " +
                "é um personagem de 5º nível, fornece +5 em testes de resistência. " +
                "O escudo dura um minuto.",": devoto de Khalmyr, Lena, Lin-Wu, Marah, " +
                "Tanna-Toh, Tauron ou Tenebra.");
        Talento talento159 = new Talento("Domínio do Sol ",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: uma vez por dia, quando usa Expulsar Mortos- " +
                "-Vivos, você pode invocar o poder do sol. Se fi zer isso, os mortos- " +
                "-vivos que falharem em seu teste de resistência são destruídos (em " +
                "vez de fi car apavorados)."," Expulsar Mortos-Vivos, devoto de Azgher ou " +
                "Lin-Wu.");
        Talento talento160 = new Talento("Domínio da Sorte ",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: uma vez por dia, você pode rolar novamente uma " +
                "jogada ou teste que tenha recém realizado."," devoto de Hyninn, Marah, Nimb, Wynna ou " +
                "Valkaria.");
        Talento talento161 = new Talento("Domínio da Terra ",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: como uma ação de movimento, você pode fi xar-se " +
                "ao solo e receber CA+2. O efeito dura até que você se mova. Este " +
                "talento não pode ser usado se você não está em contato fi rme com o " +
                "chão, ou se está em uma superfície precária (corda, escada, ponte...)."," devoto de Khalmyr, Tenebra ou Wynna.");
        Talento talento162 = new Talento("Domínio da Viagem ",GrupoDeTalento.PODER_CONCEDIDO,"Benefício: uma vez por dia, você pode se tornar imune a qualquer efeito que restrinja seu movimento (como se usasse a magia " +
                "movimentação livre), por um número de rodadas igual ao seu nível","devoto de Azgher, Hynnin, Tanna-Toh, " +
                "Th yatis ou Valkaria.");
        Talento talento163 = new Talento("Anatomia Insana ",GrupoDeTalento.TORMENTA,"Benefício: você tem 25% de chance de ignorar o dano adicional de um acerto crítico ou ataque furtivo.");
        Talento talento164 = new Talento("Carapaça",GrupoDeTalento.TORMENTA,"Benefício: você recebe +1 na CA. Este bônus aumenta em +1 " +
                "para cada dois outros talentos da Tormenta que você possui");
        Talento talento165 = new Talento("Corpo Aberrante ",GrupoDeTalento.TORMENTA,"Benefício: você recebe redução de dano 1. Esta redução de " +
                "dano aumenta em 1 para cada dois outros talentos da Tormenta " +
                "que você possui.","outro talento da Tormenta");
        Talento talento166 = new Talento("Membros Estendidos ",GrupoDeTalento.TORMENTA,"Benefício: o alcance de seus ataques corporais aumenta em " +
                "1,5m (se você for uma criatura Média, por exemplo, seu alcance " +
                "natural passa para 3m).");
        Talento talento167 = new Talento("Mente Caótica ",GrupoDeTalento.TORMENTA,"Benefício: qualquer criatura que tente ler ou estudar sua " +
                "mente deve ser bem-sucedida em um teste de Vontade (CD 20 " +
                "+ seu número de talentos da Tormenta). Se falhar, a criatura " +
                "fi ca atordoada por um número de rodadas igual ao número de " +
                "talentos da Tormenta que você possui."," tendência Caótica.");
        Talento talento168 = new Talento("Resistência a Energia ",GrupoDeTalento.TORMENTA,"Benefício: você recebe resistência 2 contra o tipo de energia " +
                "escolhido. Essa resistência aumenta em 2 para cada outro talento " +
                "da Tormenta que você possui.");
        Talento talento169 = new Talento("Sentido Sísmico ",GrupoDeTalento.TORMENTA,"Benefício: você percebe qualquer criatura em movimento que " +
                "esteja em contato com o chão. Este sentido tem alcance igual a " +
                "1,5m para cada talento da Tormenta que você possui."," Sab 13.");
        Talento talento170 = new Talento("Visão Ampla ",GrupoDeTalento.TORMENTA,"Benefício: você recebe +4 em testes de " +
                "Percepção e não pode ser flanqueado.","Sab 13.");
        Talento talento171 = new Talento("Visão no Escuro ",GrupoDeTalento.TORMENTA,"Benefício: você recebe visão no escuro 18m. Se você já possui " +
                "visão no escuro, seu alcance aumenta em +18m.");
        Talento talento172 = new Talento("Visco Rubro ",GrupoDeTalento.TORMENTA,"Benefício: você recebe um bônus de +1 nos ataques corpo-a- " +
                "-corpo. Este bônus aumenta em 1 para cada dois outros talentos da " +
                "Tormenta que você possui.");
        talentoBox.put(talento, talento1, talento0, talento01, talento2, talento3,talento4,talento5,talento6,talento7,talento8,talento9, talento10, talento11, talento12, talento13, talento14, talento15, talento16, talento17, talento18, talento19, talento20, talento21, talento22, talento23, talento24, talento25, talento26, talento27, talento28, talento29, talento30, talento31, talento32, talento33, talento34, talento35, talento36, talento37, talento38, talento39, talento40, talento41, talento42, talento43, talento44, talento45, talento46, talento47, talento48, talento49, talento50, talento51, talento52, talento53, talento54, talento55, talento56, talento57, talento58, talento59, talento60, talento61, talento62, talento63, talento64, talento65, talento66, talento67, talento68, talento69, talento70, talento71, talento72, talento73, talento74, talento75, talento76, talento77, talento78, talento79, talento80, talento81, talento82, talento83, talento84, talento85, talento86, talento87, talento88, talento89, talento90, talento91, talento92, talento93, talento94, talento95, talento96, talento97, talento98, talento99, talento100, talento101, talento102, talento103, talento104, talento105, talento106, talento107, talento108, talento109, talento110, talento111, talento112, talento113, talento114, talento115, talento116, talento117, talento118, talento119, talento120, talento121, talento122, talento123, talento124, talento125, talento126, talento127, talento128, talento129, talento130, talento131, talento132, talento133, talento134, talento135, talento136, talento137, talento138, talento139, talento140, talento141,talento142,talento143,talento144,talento145,talento146,talento147,talento148,talento149,talento150,talento151,talento152,talento153,talento154,talento155,talento156,talento157,talento158,talento159,talento160,talento161,talento162,talento163,talento164,talento165,talento166,talento167,talento168,talento169,talento170,talento171,talento172);

        }
    }
}
