package br.arpigi.fichaTormenta.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.arpigi.fichaTormenta.model.Arma;
import br.arpigi.fichaTormenta.model.Armadura;
import br.arpigi.fichaTormenta.model.Escudo;
import br.arpigi.fichaTormenta.model.Item;
import br.arpigi.fichaTormenta.model.Personagem;
import br.arpigi.fichaTormenta.util.Banco;
import br.arpigi.fichaTormenta.util.ListaArmaduraEscudoCombateAdapter;
import br.arpigi.fichaTormenta.util.ListaArmasCombateAdapter;
import io.objectbox.Box;

public class CombateActivity extends AppCompatActivity {

    TextView tvCa, tvPv, tvAtkCorpo, tvAtkDist, tvBba, tvFortitude, tvReflexo, tvVontade;
    Personagem personagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combate);
        Toolbar toolbar = findViewById(R.id.toolbar_principal);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Dados de Combate");

        Box<Arma> armaBox = Banco.get().boxFor(Arma.class);

        Box<Personagem> personagemBox = Banco.get().boxFor(Personagem.class);
        personagem = personagemBox.get(getIntent().getLongExtra("idPersonagem",0));

        if(armaBox.isEmpty()) {
            personagem.addArmadura(new Armadura("Armadura completa", 25, 1500, (byte) 8, (byte) -5, (byte) 1));
            personagem.addEscudo(new Escudo("Escudo pesado", 7, 15, (byte) 2, (byte) -2));
            personagem.getArmas().add(new Arma("Machado de batalha", 3, 10, (byte) 20, (byte) 3, (byte) 0, Arma.Tipo.CORTE, "1d8"));
            personagem.getArmas().add(new Arma("Machadinha", 2, 6, (byte) 20, (byte) 2, (byte) 3, Arma.Tipo.CORTE, "1d6"));

            personagemBox.put(personagem);
        }

        montarItensTela();

        List<Item> itens = new ArrayList<>();
        itens.add(personagem.getArmadura().getTarget());
        itens.addAll(personagem.getEscudos());

        //Recycler View da lista de escudos e armadura
        RecyclerView recyclerViewDef = findViewById(R.id.lista_armadura_escudo_recycler);
        RecyclerView.LayoutManager layoutManagerDef = new LinearLayoutManager(this);
        RecyclerView.Adapter adapterDef = new ListaArmaduraEscudoCombateAdapter(this,itens);
        recyclerViewDef.setAdapter(adapterDef);
        recyclerViewDef.setLayoutManager(layoutManagerDef);

        //Recycler View da lista de armas
        RecyclerView recyclerViewAtk = findViewById(R.id.lista_arma_recycler);
        RecyclerView.LayoutManager layoutManagerAtk = new LinearLayoutManager(this);
        RecyclerView.Adapter adapterAtk = new ListaArmasCombateAdapter(this,personagem.getArmas());
        recyclerViewAtk.setAdapter(adapterAtk);
        recyclerViewAtk.setLayoutManager(layoutManagerAtk);
    }

    private void montarItensTela(){
        tvCa = findViewById(R.id.tv_classe_armadura_combate);
        tvPv = findViewById(R.id.tv_pv_combate);
        tvAtkCorpo = findViewById(R.id.tv_atk_corpo_combate);
        tvAtkDist = findViewById(R.id.tv_atk_distancia_combate);
        tvBba = findViewById(R.id.tv_bba_combate);
        tvFortitude = findViewById(R.id.tv_fortitude_combate);
        tvReflexo = findViewById(R.id.tv_reflexo_combate);
        tvVontade = findViewById(R.id.tv_vontade_combate);

        tvCa.setText(String.format("%s",personagem.getcA()));
        tvPv.setText(String.format("%s",personagem.getpV()));
        tvAtkCorpo.setText(String.format("%s",personagem.getAtaqC()));
        tvAtkDist.setText(String.format("%s",personagem.getAtaqD()));
        tvBba.setText(String.format("%s",personagem.getbBA()));
        tvFortitude.setText(String.format("%s",personagem.getFortitude()));
        tvReflexo.setText(String.format("%s",personagem.getReflexo()));
        tvVontade.setText(String.format("%s",personagem.getVontade()));
    }
}
