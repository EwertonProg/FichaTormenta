package br.arpigi.fichaTormenta.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.Objects;

import br.arpigi.fichaTormenta.model.Pericia;
import br.arpigi.fichaTormenta.model.Personagem;
import br.arpigi.fichaTormenta.util.Banco;
import br.arpigi.fichaTormenta.util.ListaPericiasAdapter;
import io.objectbox.Box;

public class PericiasActivity extends AppCompatActivity implements ListaPericiasAdapter.ChamadaCheckBoxPericia {
    Box<Personagem> personagemBox;
    Personagem personagem;
    Box<Pericia> periciaBox;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pericias);

        Toolbar toolbar = findViewById(R.id.toolbar_principal);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Pericias");

        personagemBox = Banco.get().boxFor(Personagem.class);
        periciaBox = Banco.get().boxFor(Pericia.class);
        personagem = personagemBox.get(getIntent().getLongExtra("idPersonagem",0));

        RecyclerView recyclerView = findViewById(R.id.lista_pericia_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new ListaPericiasAdapter(personagem.getPericias(), this, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void periciaSelecionada(Pericia pericia, boolean isChecked, int itemPosicao) {
        personagem.getPericia(pericia).setTreinada(isChecked);
        pericia.calcularBonus();
        periciaBox.put(pericia);
        adapter.notifyItemChanged(itemPosicao);
    }
}
