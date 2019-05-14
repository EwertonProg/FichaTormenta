package br.arpigi.fichaTormenta.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import br.arpigi.fichaTormenta.model.Personagem;
import br.arpigi.fichaTormenta.model.Personagem_;
import br.arpigi.fichaTormenta.util.Banco;
import br.arpigi.fichaTormenta.util.ListaPersonagemAdapter;
import io.objectbox.Box;

public class ListaPersonagensActivity extends AppCompatActivity {
    Box<Personagem> personagemBox;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_personagens);
        setSupportActionBar(findViewById(R.id.toolbar_principal));
        getSupportActionBar().setTitle("Mudou");

        personagemBox = Banco.get().boxFor(Personagem.class);

        ArrayList<Personagem> personagens =(ArrayList<Personagem>) personagemBox.query().eager(Personagem_.raca).order(Personagem_.__ID_PROPERTY).build().find();

        recyclerView = findViewById(R.id.lista_pesrsonagem_recycler);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ListaPersonagemAdapter(personagens, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

}
