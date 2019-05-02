package br.arpigi.fichaTormenta.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import br.arpigi.fichaTormenta.dao.PersonagemDao;
import br.arpigi.fichaTormenta.util.ListaPersonagemAdapter;

public class ListaPersonagens extends AppCompatActivity {

    PersonagemDao personagemDao;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_personagens);

        personagemDao = new PersonagemDao();
        recyclerView = findViewById(R.id.lista_pesrsonagem_recycler);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ListaPersonagemAdapter(personagemDao.getPersonagens(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

}
