package br.arpigi.fichaTormenta.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import br.arpigi.fichaTormenta.model.Classe;
import br.arpigi.fichaTormenta.model.Classe_;
import br.arpigi.fichaTormenta.util.Banco;
import br.arpigi.fichaTormenta.util.ListaSelecaoClasseAdapter;
import io.objectbox.Box;

public class SelecaoClasseActivity extends AppCompatActivity {
    Box<Classe> classeBox;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao_classe);

        classeBox = Banco.get().boxFor(Classe.class);

        ArrayList<Classe> classes = (ArrayList<Classe>) classeBox.query().order(Classe_.__ID_PROPERTY).build().find();

        recyclerView = findViewById(R.id.lista_classes_selecao_recycler);
        adapter = new ListaSelecaoClasseAdapter(classes,this);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
