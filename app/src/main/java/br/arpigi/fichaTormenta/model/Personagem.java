package br.arpigi.fichaTormenta.model;


import android.os.Build;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import br.arpigi.fichaTormenta.activity.R;
import br.arpigi.fichaTormenta.enums.Habilidades;
import br.arpigi.fichaTormenta.enums.Pericias;
import br.arpigi.fichaTormenta.enums.Tendencias;
import br.arpigi.fichaTormenta.util.Banco;
import io.objectbox.Box;
import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Index;
import io.objectbox.annotation.IndexType;
import io.objectbox.annotation.Unique;
import io.objectbox.converter.PropertyConverter;
import io.objectbox.relation.ToMany;
import io.objectbox.relation.ToOne;

@Entity
public class Personagem {
    @Id
    private Long Id;

    @Index(type = IndexType.HASH)
    @Unique
    private String nome;

    private ToOne<Raca> raca;

    private ToMany<Classe> classes;

    private Byte nvDePersonagem = 0;

    private Byte bBA = 0;

    private Integer xp = 0;

    private Integer imagemPadrao;

    private ToMany<Habilidade> habilidades;

    private ToMany<Pericia> pericias;

    private Integer cA;

    private Integer pV = 0;

    private ToMany<Arma> armas;

    private ToOne<Armadura> armadura;

    private ToMany<Escudo> escudos;

    @Convert(converter = TendendiasConverter.class,dbType = String.class)
    private Tendencias tendencia;

    private Byte deslocamento;

    private Integer reducaoDano;

    private ToMany<Talento> talentos;

    private ToMany<Magia> magias;

    private Integer pM;

    private ToMany<Item> equipamentos;

    @Convert(converter = LinguasConverter.class,dbType = String.class)
    private List<String> liguas;

    private Byte ataqC = 0;

    private Byte ataqD = 0;

    private Byte fortitude = 0;

    private Byte reflexo = 0;

    private Byte vontade = 0;

    private String sexo;

    private byte penalidadeArmadura;

    public Personagem(Raca raca, String nome, List<Habilidade> hab, Classe classe) {
        this.nome = nome;
        this.raca.setTarget(raca);
        this.addHabilidades(hab);
        this.classes.add(classe);
        this.build();
    }

    public Personagem() {
    }

    public Personagem build(){
        if(this.raca.getTarget()!=null&&this.nome!=null&&!this.habilidades.isEmpty()&&!this.classes.isEmpty()){
            this.modificacoesPorRaca();
            this.criarPericias();
            uparNv(this.getClasses().get(0), null);
        }
        if (imagemPadrao == null){
            switch (Objects.requireNonNull(raca.getTarget()).getNome()){
                case "Anão":
                    imagemPadrao = R.drawable.img_anao_padrao;
                    break;
                case "Elfo":
                    imagemPadrao = R.drawable.img_elfo_padrao;
                    break;
                case "Goblin":
                    imagemPadrao = R.drawable.img_goblin_padrao;
                    break;
                case "Gnomo":
                    imagemPadrao = R.drawable.img_gnomo_padrao;
                    break;
                case "Halfling":
                    imagemPadrao = R.drawable.img_halfling_padrao;
                    break;
                case "Humano":
                    imagemPadrao = R.drawable.img_humano_padrao;
                    break;
                case "Lefou":
                    imagemPadrao = R.drawable.img_lefou_padrao;
                    break;
                case "Minotauro":
                    imagemPadrao = R.drawable.img_minotauro_padrao;
                    break;
                case "Qareen":
                    imagemPadrao = R.drawable.img_qareen_padrao;
                    break;
                default:
                    imagemPadrao = R.drawable.lena;
            }
        }
        return this;
    }

    private void modificacoesPorRaca() {
        this.deslocamento = this.raca.getTarget().getDeslocamento();
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
			raca.getTarget().getModHab().forEach((hab, mod) -> {
				Habilidade habc = this.getHabilidade(hab);
				habc.setValor((byte) (habc.getValor() + mod));
			});
		}else {
        Map<Habilidade, Byte> modhab = raca.getTarget().getModHab();
        for (Habilidade habilidade : this.habilidades) {
            if (modhab.containsKey(habilidade)) {
                habilidade.addValor(modhab.get(habilidade));
				}
            }
        }
    }

    private void uparNv(Classe classe, Habilidades aumHabilidade) {

        if (this.classes.contains(classe)) {
            Classe clas = this.classes.get(this.classes.indexOf(classe));
            clas.elevarNv();
            this.bBA = calcularBBA();
            Log.d("Classe",classe.getNome());
        } else {
            this.classes.add(classe);
            this.bBA = calcularBBA();
            Log.d("Classe",classe.getNome());
        }
            this.nvDePersonagem++;
        if (this.nvDePersonagem % 2 == 0) {
            Habilidade hab = getHabilidade(aumHabilidade);
            hab.aumentarHab((byte) 1);
        }
        this.atualizarPericias();
        this.atualizarHabCombate(classe);
        Box<Personagem> personagemBox = Banco.get().boxFor(Personagem.class);
        personagemBox.put(this);
    }

    private void atualizarHabCombate(Classe classe) {
        if (this.nvDePersonagem == 1) {
            this.pV += this.classes.get(0).getPvsNvUm()
                    + this.getHabilidade(Habilidades.CONSTITUICAO).calcularModificador();
        } else {
            this.pV += classe.getPvsPorNv() + this.getHabilidade(Habilidades.CONSTITUICAO).calcularModificador();
        }
        this.ataqC = (byte) (getHabilidade(Habilidades.FORCA).calcularModificador() + this.bBA
                + this.raca.getTarget().getTamanho().getModArma());
        this.ataqD = (byte) (getHabilidade(Habilidades.DESTREZA).calcularModificador() + this.bBA
                + this.raca.getTarget().getTamanho().getModArma());
        this.cA = (getHabilidade(Habilidades.DESTREZA).calcularModificador() + metadeDoNv()
                + this.raca.getTarget().getTamanho().getModCa() + 10);
        this.fortitude = (byte) (getHabilidade(Habilidades.CONSTITUICAO).calcularModificador() + metadeDoNv());
        this.reflexo = (byte) (getHabilidade(Habilidades.DESTREZA).calcularModificador() + metadeDoNv());
        this.vontade = (byte) (getHabilidade(Habilidades.SABEDORIA).calcularModificador() + metadeDoNv());
    }

    private void atualizarPericias() {
        for (Pericia pericia : this.pericias) {
            pericia.setNivelPersonagem(this.nvDePersonagem);
            pericia.setModHabilidade((this.getHabilidade(pericia.getNome().getHabilidadeChave()).calcularModificador()));
            pericia.calcularBonus();

        }

    }

    private void criarPericias() {
        Pericias[] pericias = Pericias.values();
        for (Pericias pericia : pericias) {
            this.pericias.add(new Pericia(pericia));
        }
    }

    //TODO Calcular as pericias afeadas pela penalidade de armadura
    private void atualizarPenalidadeArmadura(){

    }
    public void retirarPericiaTreinada(Pericia pericia){
        this.getPericia(pericia).setTreinada(false);
        this.atualizarPericias();
    }
    public void adicionarPericiasTreinadas(Pericia... periciasTreinadas) {

        for (int i = 0; i < periciasTreinadas.length; i++) {
            if (periciasTreinadas[i].getEspec() != Pericias.Especificacao.VAZIA) {
                periciasTreinadas[i].setTreinada(true);
                this.pericias.add(periciasTreinadas[i]);
            }
            Pericia p = this.getPericia(periciasTreinadas[i]);
            p.setTreinada(true);
        }
        this.atualizarPericias();
//		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//			this.pericias.sort((p1, p2) -> p1.compare(p1,p2));
//		}else{
//		    Collections.sort(this.pericias.,(p1, p2) -> p1.compare(p1,p2));
//		}
    }

    public void addArmadura(Armadura armadura){
        this.armadura.setTarget(armadura);
        addPenalidadeArmadura(armadura.getPenArmadura());
        atualizarPenalidadeArmadura();
    }
    public void addEscudo(Escudo escudo){
        this.escudos.add(escudo);
        addPenalidadeArmadura(escudo.getPenArmadura());
        atualizarPenalidadeArmadura();
    }

    private void addPenalidadeArmadura(byte valor){
        this.penalidadeArmadura = (byte) (this.penalidadeArmadura + valor);
    }

    private Byte calcularBBA() {
        Byte bba = (byte) 0;
        for (Classe c : this.classes) {
            bba = (byte) (c.getbBA() + bba);
        }
        return bba;
    }

    public boolean addXp(Integer xp) {
        this.xp += xp;
        return this.xp >= this.calcXpProxNv();
    }

    private Integer calcXpProxNv() {
        int result = 0;
        for (Integer x = 1; x <= this.nvDePersonagem; x++) {
            result = result + x * 1000;
        }
        return result;
    }

    private void addHabilidades(List<Habilidade> habilidades){
            this.habilidades.addAll(habilidades);
    }

    public String classesString(){
        StringBuilder sBuilder = new StringBuilder();
        for (Classe classe:classes){
            sBuilder.append(classe.getNome())
                    .append(" ")
                    .append(String.format("%s",classe.getNivelAtual()))
                    .append(", ");
        }
        sBuilder.delete(sBuilder.length()-2,sBuilder.length()-1);
        return sBuilder.toString();
    }

    public static class TendendiasConverter implements PropertyConverter<Tendencias,String>{

        @Override
        public Tendencias convertToEntityProperty(String databaseValue) {
            if (databaseValue==null){
                return Tendencias.N;
            }
            return Tendencias.valueOf(databaseValue);
        }

        @Override
        public String convertToDatabaseValue(Tendencias entityProperty) {
            return entityProperty.toString();
        }
    }

    public static class LinguasConverter implements PropertyConverter<List<String>,String>{
        Gson gson;
        @Override
        public List<String> convertToEntityProperty(String databaseValue) {
            gson = new Gson();
            Type type = new TypeToken<List<String>>(){}.getType();
            return gson.fromJson(databaseValue,type);
        }

        @Override
        public String convertToDatabaseValue(List<String> entityProperty) {
            gson = new Gson();
            return gson.toJson(entityProperty);
        }
    }


    private Integer metadeDoNv() {
        return this.nvDePersonagem / 2;
    }

    public void alterarHabilidade(Habilidades habilidade, Byte valor) {
        Habilidade habc = getHabilidade(habilidade);
        habc.setValor((byte) (habc.getValor() + valor));
    }

    public Habilidade getHabilidade(Habilidades habilidade) {
        return this.habilidades.get(this.habilidades.indexOf(new Habilidade(habilidade)));
    }

    public Habilidade getHabilidade(Habilidade habilidade) {
        return this.habilidades.get(this.habilidades.indexOf(habilidade));
    }

    public Pericia getPericia(Pericia pericia) {
        return this.pericias.get(this.pericias.indexOf(pericia));
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ToOne<Raca> getRaca() {
        return raca;
    }

    public void setRaca(ToOne<Raca> raca) {
        this.raca = raca;
    }

    public ToMany<Classe> getClasses() {
        return classes;
    }

    public void setClasses(ToMany<Classe> classes) {
        this.classes = classes;
    }

    public Byte getNvDePersonagem() {
        return nvDePersonagem;
    }

    public void setNvDePersonagem(Byte nvDePersonagem) {
        this.nvDePersonagem = nvDePersonagem;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public ToMany<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ToMany<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public ToMany<Pericia> getPericias() {
        return pericias;
    }

    public void setPericias(ToMany<Pericia> pericias) {
        this.pericias = pericias;
    }

    public Integer getcA() {
        return cA;
    }

    public void setcA(Integer cA) {
        this.cA = cA;
    }

    public Integer getCA() {
        return cA;
    }

    public void setCA(Integer cA) {
        this.cA = cA;
    }

    public Integer getpV() {
        return pV;
    }

    public void setpV(Integer pV) {
        this.pV = pV;
    }

    public Integer getPV() {
        return pV;
    }

    public void setPV(Integer pV) {
        this.pV = pV;
    }

    public ToMany<Arma> getArmas() {
        return armas;
    }

    public void setArmas(ToMany<Arma> armas) {
        this.armas = armas;
    }

    public ToOne<Armadura> getArmadura() {
        return armadura;
    }

    public void setArmadura(ToOne<Armadura> armadura) {
        this.armadura = armadura;
    }

    public ToMany<Escudo> getEscudos() {
        return escudos;
    }

    public void setEscudos(ToMany<Escudo> escudos) {
        this.escudos = escudos;
    }

    public Tendencias getTendencia() {
        return tendencia;
    }

    public void setTendencia(Tendencias tendencia) {
        this.tendencia = tendencia;
    }

    public Byte getDeslocamento() {
        return deslocamento;
    }

    public void setDeslocamento(Byte deslocamento) {
        this.deslocamento = deslocamento;
    }

    public Integer getReducaoDano() {
        return reducaoDano;
    }

    public void setReducaoDano(Integer reducaoDano) {
        this.reducaoDano = reducaoDano;
    }

    public ToMany<Talento> getTalentos() {
        return talentos;
    }

    public void setTalentos(ToMany<Talento> talentos) {
        this.talentos = talentos;
    }

    public ToMany<Magia> getMagias() {
        return magias;
    }

    public void setMagias(ToMany<Magia> magias) {
        this.magias = magias;
    }

    public Integer getpM() {
        return pM;
    }

    public void setpM(Integer pM) {
        this.pM = pM;
    }

    public Integer getPM() {
        return pM;
    }

    public void setPM(Integer pM) {
        this.pM = pM;
    }

    public ToMany<Item> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(ToMany<Item> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public List<String> getLiguas() {
        return liguas;
    }

    public void setLiguas(List<String> liguas) {
        this.liguas = liguas;
    }

    public Byte getAtaqC() {
        return ataqC;
    }

    public void setAtaqC(Byte ataqC) {
        this.ataqC = ataqC;
    }

    public Byte getAtaqD() {
        return ataqD;
    }

    public void setAtaqD(Byte ataqD) {
        this.ataqD = ataqD;
    }

    public Byte getFortitude() {
        return fortitude;
    }

    public void setFortitude(Byte fortitude) {
        this.fortitude = fortitude;
    }

    public Byte getReflexo() {
        return reflexo;
    }

    public void setReflexo(Byte reflexo) {
        this.reflexo = reflexo;
    }

    public Byte getVontade() {
        return vontade;
    }

    public void setVontade(Byte vontade) {
        this.vontade = vontade;
    }

    public Byte getbBA() {
        return bBA;
    }

    public void setbBA(Byte bBA) {
        this.bBA = bBA;
    }

    public Byte getBBA() {
        return bBA;
    }

    public void setBBA(Byte bBA) {
        this.bBA = bBA;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getImagemPadrao() {
        return imagemPadrao;
    }

    public void setImagemPadrao(Integer imagemPadrao) {
        this.imagemPadrao = imagemPadrao;
    }

    public byte getPenalidadeArmadura() {
        return penalidadeArmadura;
    }

    public void setPenalidadeArmadura(byte penalidadeArmadura) {
        this.penalidadeArmadura = penalidadeArmadura;
    }
}
