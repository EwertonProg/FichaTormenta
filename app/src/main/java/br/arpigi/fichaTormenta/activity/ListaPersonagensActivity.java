package br.arpigi.fichaTormenta.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;

import br.arpigi.fichaTormenta.model.Personagem;
import br.arpigi.fichaTormenta.model.Personagem_;
import br.arpigi.fichaTormenta.util.Banco;
import br.arpigi.fichaTormenta.util.ListaPersonagemAdapter;
import io.objectbox.Box;

public class ListaPersonagensActivity extends AppCompatActivity {
    Toolbar toolbar;
    Box<Personagem> personagemBox;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        setContentView(R.layout.activity_lista_personagens);
        personagemBox = Banco.get().boxFor(Personagem.class);
        ArrayList<Personagem> personagens =(ArrayList<Personagem>) personagemBox.query().eager(Personagem_.raca).order(Personagem_.__ID_PROPERTY).build().find();
        Log.d("fichaA",personagens.get(0).getRaca().getTarget().getNome());
        recyclerView = findViewById(R.id.lista_pesrsonagem_recycler);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ListaPersonagemAdapter(personagens, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

}
