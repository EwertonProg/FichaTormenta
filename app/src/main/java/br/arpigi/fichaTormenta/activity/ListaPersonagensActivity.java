package br.arpigi.fichaTormenta.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

import br.arpigi.fichaTormenta.model.Personagem;
import br.arpigi.fichaTormenta.model.Personagem_;
import br.arpigi.fichaTormenta.util.Banco;
import br.arpigi.fichaTormenta.util.ListaPersonagemAdapter;
import io.objectbox.Box;

public class ListaPersonagensActivity extends AppCompatActivity implements ListaPersonagemAdapter.ClickPersonagem {
    Box<Personagem> personagemBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_personagens);
        setSupportActionBar(findViewById(R.id.toolbar_principal));
        Objects.requireNonNull(getSupportActionBar()).setTitle("Lista de Fichas");

        personagemBox = Banco.get().boxFor(Personagem.class);

        ArrayList<Personagem> personagens =(ArrayList<Personagem>) personagemBox.query().eager(Personagem_.raca).eager(Personagem_.classes).build().find();

        RecyclerView recyclerView = findViewById(R.id.lista_pesrsonagem_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.Adapter adapter = new ListaPersonagemAdapter(personagens, this, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void personagemClicado(Long id) {
        Intent i = new Intent(this, DescricaoPersonagemActivity.class);
        i.putExtra("idPersonagem",id);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        this.finish();
        personagemBox.closeThreadResources();
    }
}
