package br.arpigi.fichaTormenta.enums;

public enum Pericias {
    ACROBACIA("Acrobacia", Habilidades.DESTREZA), ADESTRAR_ANIMAIS("Adestrar Animais", Habilidades.CARISMA),
    ATLETISMO("Atletismo", Habilidades.FORCA), ATUACAO("Atuação", Habilidades.CARISMA),
    CAVALGAR("Cavalgar", Habilidades.DESTREZA), CONHECIMENTO("Conhecimento", Habilidades.INTELIGENCIA),
    CURA("Cura", Habilidades.SABEDORIA), DIPLOMACIA("Diplomacia", Habilidades.CARISMA),
    ENGANACAO("Enganação", Habilidades.CARISMA), FURTIVIDADE("Furtividade", Habilidades.DESTREZA),
    IDENTIFICAR_MAGIA("Identifcar Magia", Habilidades.INTELIGENCIA), INICIATIVA("Iniciativa", Habilidades.DESTREZA),
    INTIMIDACAO("Intimidação", Habilidades.CARISMA), INTUICAO("Intuição", Habilidades.SABEDORIA),
    LADINAGEM("Ladinagem", Habilidades.DESTREZA), OBTER_INFORMACAO("Obter Informaação", Habilidades.CARISMA),
    OFICIO("Ofício", Habilidades.INTELIGENCIA), PERCEPCAO("Percepção", Habilidades.SABEDORIA),
    SOBREVIVENCIA("Sobrevivência", Habilidades.SABEDORIA);

    private String nome;
    private Habilidades habilidadeChave;

    private Pericias(String nome, Habilidades habilidadeChave) {
        this.nome = nome;
        this.habilidadeChave = habilidadeChave;
    }

    public String getNome() {
        return nome;
    }

    public Habilidades getHabilidadeChave() {
        return habilidadeChave;
    }



    public enum Especificacao {
        DRAMATURGIA("Dramaturgia"), DANCA("Dança"), MUSICA("Música"), ORATORIA("Oratória"), ARCANO("Arcano"),
        ENGENHARIA("Engenharia"), GEOGRAFIA("Geografia"), HISTORIA("História"), NATUREZA("Natureza"),
        NOBREZA("Nobreza"), RELIGIAO("Religião"), TORMENTA("Tormenta"), ALQUIMIA("Alquimia"), ALVENARIA("Alvenaria"),
        CARPINTARIA("Carpintaria"), JOALHEIRIA("Joalheria"), METALURGIA("Metalurgia"), PROFISSAO("Profissão"),
        ARTE("Arte"), VAZIA("");

        private String nome;

        private Especificacao(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }
    }

}
