package br.arpigi.fichaTormenta.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import br.arpigi.fichaTormenta.dao.PersonagemDao;
import br.arpigi.fichaTormenta.util.ListaPersonagemAdapter;

public class ListaPersonagensActivity extends AppCompatActivity {
    Toolbar toolbar;
    PersonagemDao personagemDao;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        setContentView(R.layout.activity_lista_personagens);

        personagemDao = new PersonagemDao();
        recyclerView = findViewById(R.id.lista_pesrsonagem_recycler);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ListaPersonagemAdapter(personagemDao.getPersonagens(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

}
